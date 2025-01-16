package com.example.projet2;

import com.example.projet2.Employe;
import com.example.projet2.kaban;
import com.example.projet2.Tache;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.awt.*;
import java.util.ArrayList;

public class MainController {

    @FXML
    private StackPane contentPane;

    private VBox employeView;
    private VBox projetView;
    private VBox tacheView;
    private VBox kanbanView;
    private VBox calendrierView;

    private kaban kanban = new kaban(); // Correction de la casse pour "Kaban"

    @FXML
    public void initialize() {
        initializeEmployeView();
        initializeProjetView();
        initializeTacheView();
        initializeKanbanView();
        initializeCalendrierView();

        contentPane.getChildren().add(new Label("Bienvenue dans l'application de gestion de tâches !"));
    }

    private void initializeCalendrierView() {
        calendrierView = new VBox(10); // Création d'une vue verticale avec un espacement de 10
        calendrierView.setPadding(new javafx.geometry.Insets(10,10,10,10)); // Ajout d'un peu de marge autour de la vue

        // Titre de la section Calendrier
        Label titleLabel = new Label("Vue Calendrier");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Création du DatePicker pour sélectionner une date
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Sélectionner une date");

        // Liste des tâches associées à la date sélectionnée
        ListView<Tache> tacheListView = new ListView<>();
        tacheListView.setCellFactory(param -> new ListCell<Tache>() {
            @Override
            protected void updateItem(Tache item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNom() + " (Échéance : " + item.getEcheance() + ")");
                }
            }
        });


        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Filtrage des tâches pour la date sélectionnée
                ArrayList<Tache> filteredTaches = new ArrayList<>();
                for (Tache tache : Tache.ttTaches) {
                    if (tache.getEcheance().equals(newValue.toString())) {
                        filteredTaches.add(tache);
                    }
                }
                tacheListView.getItems().setAll(filteredTaches);
            }
        });

        // Ajout des composants à la vue
        calendrierView.getChildren().addAll(titleLabel, datePicker, tacheListView);
    }


    private void initializeEmployeView() {
        employeView = new VBox(10);
        employeView.getChildren().add(new Label("Gestion des Employés"));

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        TextField posteField = new TextField();
        posteField.setPromptText("Poste");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        Button ajouterButton = new Button("Ajouter");

        TableView<Employe> employeTable = new TableView<>();
        TableColumn<Employe, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Employe, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Employe, String> posteColumn = new TableColumn<>("Poste");
        TableColumn<Employe, String> emailColumn = new TableColumn<>("Email");

        employeTable.getColumns().addAll(idColumn, nomColumn, posteColumn, emailColumn);

        ajouterButton.setOnAction(e -> {
            String nom = nomField.getText();
            String poste = posteField.getText();
            String email = emailField.getText();

            if (!nom.isEmpty() && !poste.isEmpty() && !email.isEmpty()) {
                Employe.newEmploye(nom, poste, email, new ArrayList<>());
                employeTable.getItems().setAll(Employe.listesEmployes);
                nomField.clear();
                posteField.clear();
                emailField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Tous les champs sont obligatoires !");
                alert.show();
            }
        });

        employeView.getChildren().addAll(nomField, posteField, emailField, ajouterButton, employeTable);
    }

    private void initializeProjetView() {
        projetView = new VBox(10);
        projetView.getChildren().add(new Label("Gestion des Projets"));
        // Ajout des champs et actions pour la gestion des projets
    }

    private void initializeTacheView() {
        tacheView = new VBox(10);
        tacheView.getChildren().add(new Label("Gestion des Tâches"));
        // Ajout des champs et actions pour la gestion des tâches
    }

    private void initializeKanbanView() {
        kanbanView = new VBox(10);
        kanbanView.getChildren().add(new Label("Vue Kanban"));

        HBox kanbanColumns = new HBox(10);

        VBox todoColumn = createKanbanColumn("À faire", "À faire");
        VBox inProgressColumn = createKanbanColumn("En cours", "En cours");
        VBox doneColumn = createKanbanColumn("Terminé", "Terminé");

        kanbanColumns.getChildren().addAll(todoColumn, inProgressColumn, doneColumn);
        kanbanView.getChildren().add(kanbanColumns);
    }

    private VBox createKanbanColumn(String title, String columnKey) {
        VBox column = new VBox(10);

        column.setPadding(new javafx.geometry.Insets(10,10,10,10));
        column.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-background-color: #f4f4f4;");

        Label columnLabel = new Label(title);
        ListView<Tache> taskList = new ListView<>();
        taskList.setCellFactory(param -> new ListCell<Tache>() {
            @Override
            protected void updateItem(Tache item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNom() + " (" + item.getEcheance() + ")");
                }
            }
        });

        taskList.getItems().setAll(kanban.get(columnKey));

        taskList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && taskList.getSelectionModel().getSelectedItem() != null) {
                Tache selectedTask = taskList.getSelectionModel().getSelectedItem();
                moveTaskToNextColumn(selectedTask, columnKey);
                refreshKanbanView();
            }
        });

        column.getChildren().addAll(columnLabel, taskList);
        return column;
    }

    private void moveTaskToNextColumn(Tache task, String currentColumn) {
        String nextColumn = switch (currentColumn) {
            case "À faire" -> "En cours";
            case "En cours" -> "Terminé";
            default -> null;
        };

        if (nextColumn != null) {
            kanban.deplacerTacheKanban(task, nextColumn);
        }
    }

    private void refreshKanbanView() {
        kanbanView.getChildren().clear();
        initializeKanbanView();
    }

    @FXML
    private void showEmployes() {
        contentPane.getChildren().setAll(employeView);
    }

    @FXML
    private void showProjets() {
        contentPane.getChildren().setAll(projetView);
    }

    @FXML
    private void showTaches() {
        contentPane.getChildren().setAll(tacheView);
    }

    @FXML
    private void showKanban() {
        contentPane.getChildren().setAll(kanbanView);
    }

    @FXML
    private void showCalendrier() {
        contentPane.getChildren().setAll(calendrierView);
    }
}