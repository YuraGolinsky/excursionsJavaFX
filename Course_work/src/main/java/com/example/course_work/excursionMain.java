package com.example.course_work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;

public class excursionMain extends Application{
    ArrayList<Excursions> addList = new ArrayList<Excursions>();
    ArrayList<Excursions> readList = new ArrayList<Excursions>();
    ArrayList<Excursions> searchList = new ArrayList<Excursions>();
    ArrayList<Integer> indexOfFindList = new ArrayList<Integer>();
    ArrayList<Excursions> readListEvery = new ArrayList<Excursions>();

    @Override
    public void start(Stage stage) throws Exception {
//Меню файла
        MenuBar menubar = new MenuBar(); Menu fileButton = new Menu("Файл");
        MenuItem aboutButton = new MenuItem ( "Про роботу");
        MenuItem exitButton = new MenuItem("Вихід");
        fileButton.getItems().addAll(aboutButton,new SeparatorMenuItem(),exitButton);
        menubar.getMenus().add(fileButton);

//Меню налаштувань
        //Зміна кольору
        Menu settings= new Menu("Вигляд вікна");
        Menu font = new Menu("Шрифт");
        Menu colorsMenu=new Menu("Змінити колір");
        MenuItem red = new MenuItem("Червоний");
        MenuItem Violet = new MenuItem("Фіолетовий");
        MenuItem yellow = new MenuItem("Жовтий");
        MenuItem multiple_colors = new MenuItem("Кілька кольорів");
        MenuItem main_color = new MenuItem("Основний колір");

//Зміна шрифту
        ButtonGroup buttonGroup = new ButtonGroup();
        MenuItem TimesNewRoman = new MenuItem("Times New Roman");
        MenuItem Courier = new MenuItem("Courier");
        menubar.getMenus().add(settings);
        settings.getItems().addAll(colorsMenu, font);
        colorsMenu.getItems().addAll(red,Violet,yellow,multiple_colors,main_color);
        font.getItems().addAll(TimesNewRoman, Courier);

        EventHandler<ActionEvent> MenuHandler = (ActionEvent actionEvent) ->
        {
            String name = ((MenuItem)actionEvent.getTarget()).getText();
            if(name.equals("Вихід"))Platform.exit();
        };

        exitButton.setOnAction(MenuHandler);
        red.setOnAction(MenuHandler);
        Violet.setOnAction(MenuHandler);
        yellow.setOnAction(MenuHandler);
        multiple_colors.setOnAction(MenuHandler);
        aboutButton.setOnAction(MenuHandler);
        TimesNewRoman.setOnAction(MenuHandler);
        Courier.setOnAction(MenuHandler);

//Параметри сцени
        stage.setTitle("Екскурсії");
        GridPane gridpane=new GridPane();
        gridpane.setPadding(new Insets(0,20,20,20));
        gridpane.setVgap(10);
        gridpane.setHgap(15);

        Scene scene=new Scene(gridpane,900,550);
        stage.setScene(scene);
        stage.setResizable(false);

//Додавання заголовків та текстових полів для вводу
        Label NameLabel=new Label("Назва екскурсії");
        Label CountryandCityLabel=new Label("Країна та місто");
        Label transportLabel=new Label("Транспорт ");
        Label Trivality_of_excursionsLabel=new Label("Тривалість" );
        Label PriceLabel=new Label("Вартість");

        TextField NameText= new TextField();
        NameText.setPromptText("Введіть назву екскурсії");

        TextField CountryandCityText= new TextField();
        CountryandCityText.setPromptText("Введіть країну та місто");

        TextField transportText= new TextField();
        transportText.setPromptText("Введіть транспорт для екскурсії");

        TextField Trivality_of_excursionsText= new TextField();
        Trivality_of_excursionsText.setPromptText("Введіть тривалість екскурсії");

        TextField PriceText= new TextField();
        PriceText.setPromptText("Введіть вартість екскурсії");

        Button addToBufButton = new Button("Додавання даних у буфер обміну");
        Button writeToFileButton = new Button("Записати у файл");
        Label bufLabel=new Label ("Кількість строк у буфері");
        NameLabel.setFont(new Font ("Arial",12));
        CountryandCityLabel.setFont(new Font ("Arial",12));
        transportLabel.setFont(new Font ("Arial",12));
        Trivality_of_excursionsLabel.setFont(new Font ("Arial",12));
        PriceLabel.setFont(new Font ("Arial",12));
        bufLabel.setFont(new Font ("Arial",12));

        NameText.setPrefSize(220,20);
        CountryandCityText.setPrefSize(220,20);
        transportText.setPrefSize(220,20);
        PriceText.setPrefSize(220,20);
        Trivality_of_excursionsText.setPrefSize(220,20);

        addToBufButton.setFont(new Font ("Arial",12));
        addToBufButton.setPrefSize(220,20);
        writeToFileButton.setFont(new Font ("Arial",12));
        writeToFileButton.setPrefSize(220,20);

//Розташування на сцені
        TitledPane titledPane=new TitledPane();
        titledPane.setText("Введення даних");
        GridPane gridPane1=new GridPane();
        gridPane1.setPadding(new Insets (10,20,20,20)); gridPane1.setVgap(5);
        gridPane1.setHgap(10);
        gridPane1.setStyle("-fx-background-color: #FFFFFF");

        GridPane.setConstraints(NameLabel, 0, 1);
        GridPane.setHalignment(NameLabel, HPos.LEFT);
        gridPane1.getChildren().add(NameLabel);
        GridPane.setConstraints(NameText, 0, 2);
        gridPane1.getChildren().add(NameText);

        GridPane.setConstraints(CountryandCityLabel,0,4);
        GridPane.setHalignment(CountryandCityLabel,HPos.LEFT);
        gridPane1.getChildren().add(CountryandCityLabel);
        GridPane.setConstraints(CountryandCityText, 0, 5);
        gridPane1.getChildren().add(CountryandCityText);

        GridPane.setConstraints(transportLabel,0,8);
        GridPane.setHalignment(transportLabel,HPos.LEFT);
        gridPane1.getChildren().add(transportLabel);
        GridPane.setConstraints(transportText, 0, 9);
        gridPane1.getChildren().add(transportText);

        GridPane.setConstraints(Trivality_of_excursionsLabel,0,12);
        GridPane.setHalignment(Trivality_of_excursionsLabel,HPos.LEFT);
        gridPane1.getChildren().add(Trivality_of_excursionsLabel);
        GridPane.setConstraints(Trivality_of_excursionsText, 0, 13);
        gridPane1.getChildren().add(Trivality_of_excursionsText);

        GridPane.setConstraints(PriceLabel,0,16);
        GridPane.setHalignment(PriceLabel,HPos.LEFT);
        gridPane1.getChildren().add(PriceLabel);
        GridPane.setConstraints(PriceText, 0, 17);
        gridPane1.getChildren().add(PriceText);

        GridPane.setConstraints(addToBufButton,0,20);
        gridPane1.getChildren().add(addToBufButton);
        GridPane.setConstraints(bufLabel,0,24);
        gridPane1.setColumnSpan(bufLabel,3);
        GridPane.setHalignment(bufLabel,HPos.LEFT);
        gridPane1.getChildren().add(bufLabel);
        GridPane.setConstraints(writeToFileButton,0,28);
        gridPane1.getChildren().add(writeToFileButton);

//Меню
        GridPane.setConstraints(menubar, 0, 0);
        gridPane1.setColumnSpan(menubar,11);
        gridpane.getChildren().add(menubar);

        titledPane.setCollapsible(false);

        titledPane.setContent(gridPane1);

        GridPane.setConstraints(titledPane,0,1);
        GridPane.setColumnSpan(titledPane,4);
        gridpane.getChildren().add(titledPane);

        TextArea textArea=new TextArea(); textArea.setPrefSize(400,437);
        textArea.setPromptText("Дані з файлу:");

        Button readFileButton=new Button ("Вивести дані з файлу");
        readFileButton.setFont(new Font("Arial",12));
        readFileButton.setPrefSize(200,20);

        Button clearButton=new Button ("Очистити");
        clearButton.setFont(new Font("Arial",12));
        clearButton.setPrefSize(200,20);

        Button searchButton=new Button("Пошук");
        searchButton.setFont(new Font("Arial",12));
        Button editButton=new Button("Зміна даних");
        editButton.setFont(new Font("Arial",12));

        ComboBox choiceComboBox= new ComboBox();
        choiceComboBox.setPromptText("Оберіть дані");
        choiceComboBox.getItems().add("Назва екскурсії");
        choiceComboBox.getItems().add("Країна та місто");
        choiceComboBox.getItems().add("Транспорт");
        choiceComboBox.getItems().add("Тривалість");
        choiceComboBox.getItems().add("Вартість");

        TextField searchText = new TextField();
        searchText.setPromptText("Введіть поле для пошуку");

        TextField editText = new TextField();
        editText.setPromptText("Введіть дані для заміни");

        TitledPane TpanelArray = new TitledPane();
        GridPane gridArray = new GridPane();
        gridArray.setPadding(new Insets(10));
        gridArray.setVgap(5); gridArray.setHgap(10);
        gridArray.setStyle("-fx-background-color: #FFFFFF");

        TpanelArray.setCollapsible(false); TpanelArray.setText("Виведення");
        TpanelArray.setContent(gridArray);

        TitledPane searchTitledPanel = new TitledPane();
        searchTitledPanel.setPrefSize(150,200);
        searchTitledPanel.setText("Пошук");

        GridPane searchGridPanel = new GridPane();
        searchGridPanel.setPadding(new Insets(20));
        searchGridPanel.setVgap(10); searchGridPanel.setHgap(10);
        searchGridPanel.setStyle("-fx-background-color:#FFFFFF");

        GridPane.setConstraints(searchText,1,0);
        searchGridPanel.getChildren().add(searchText);

        GridPane.setConstraints(searchButton,1,1);
        GridPane.setHalignment(searchButton,HPos.RIGHT);
        searchGridPanel.getChildren().add(searchButton);

        GridPane.setConstraints(choiceComboBox,1,2);
        searchGridPanel.getChildren().add(choiceComboBox);

        GridPane.setConstraints(editText,1,3);
        GridPane.setHalignment(editText,HPos.RIGHT);
        searchGridPanel.getChildren().add(editText);

        GridPane.setConstraints(editButton,1,4);
        GridPane.setHalignment(editButton,HPos.RIGHT);
        searchGridPanel.getChildren().add(editButton);

        searchTitledPanel.setContent(searchGridPanel);

        GridPane.setConstraints(searchTitledPanel,4,4);
        gridArray.getChildren().add(searchTitledPanel);

        GridPane.setConstraints(textArea,0,0);
        GridPane.setColumnSpan(textArea,4);
        GridPane.setRowSpan(textArea,5);
        gridArray.getChildren().add(textArea);

        GridPane.setConstraints(readFileButton,4,0);
        GridPane.setHalignment(readFileButton,HPos.RIGHT);
        gridArray.getChildren().add(readFileButton);

        GridPane.setConstraints(clearButton,4,2);
        GridPane.setHalignment(clearButton,HPos.RIGHT);
        gridArray.getChildren().add(clearButton);

        GridPane.setConstraints(TpanelArray, 8, 1);
        GridPane.setColumnSpan(TpanelArray,2);
        gridpane.getChildren().add(TpanelArray);

//ОБРОБКА ПОДІЙ
//Додавання у буфер

        addToBufButton.setOnAction((ActionEvent event) ->
        {
            Excursions excursions;
            if
            (!NameText.getText().isEmpty()&&!CountryandCityText.getText().isEmpty()&&!transportText.getText().isEmpty()&&!Trivality_of_excursionsText.getText().isEmpty()&&!PriceText.getText().isEmpty())
            {



                try
                {String Name=NameText.getText().toUpperCase();
                    String CountryandCity=CountryandCityText.getText().toUpperCase();
                    String transport=transportText.getText().toUpperCase();

                    double
                            Trivality_of_excursions=Double.parseDouble(Trivality_of_excursionsText.getText().toUpperCase());
                    double
                            Price=Double.parseDouble(PriceText.getText().toUpperCase());
                    excursions = new Excursions(Name, CountryandCity, transport, Trivality_of_excursions, Price);


                    addList.add(excursions);
                }

                catch(Exception e)
                {
                    System.out.println("Помилка! "+e.getMessage());
                }
                NameText.clear(); CountryandCityText.clear(); transportText.clear();
                Trivality_of_excursionsText.clear();
                PriceText.clear();
                bufLabel.setText("Кількість строк у буфері: " + addList.size());
            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.WARNING);
                DialogPane dialogPane=alert.getDialogPane();
                dialogPane.setStyle("-fx-background-color: #e0e04c");
                alert.setTitle("Помилка!");
                alert.setHeaderText("Введіть усі дані!");
                alert.setContentText(null);
                alert.showAndWait();

            }
        });

//Запис у файл та створення текстового документа
        writeToFileButton.setOnAction((ActionEvent event)->{
            if (addList.isEmpty() )
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                DialogPane dialogPane=alert.getDialogPane();
                dialogPane.setStyle("-fx-background-color: #FF6347");
                alert.setTitle("Помилка!");
                alert.setHeaderText("Щоб записати в файл, введіть дані!");
                alert.setContentText(null); alert.showAndWait();
            }
            else
            {
                try(PrintWriter out = new PrintWriter(new
                        FileWriter("D:\\Excursions.txt",true))){
                    Iterator<Excursions> iterator = addList.iterator();
                    while(iterator.hasNext()){
                        Excursions element;
                        element = iterator.next(); element.writeData(out);
                    }
                    bufLabel.setText("Всі строки додано у файл");
                    addList.clear();
                }
                catch(IOException e)
                {
                    e.printStackTrace();

                }
            }});

//Читання з файлу
        readFileButton.setOnAction((ActionEvent event) -> {textArea.clear();
            readList.clear();

            String s;
            Excursions obj;

            File fl = new File("D:\\Excursions.txt");
            if (!fl.exists() || fl.length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-background-color: darkgrey");
                alert.setTitle("Помилка!");
                alert.setHeaderText("Файл пустий або його не існує.");
                alert.setContentText(null);
                alert.showAndWait();

            } else {
                try (BufferedReader in = new BufferedReader(new FileReader(fl))) {

                    while ((s = in.readLine()) != null) {
                        obj = new Excursions();
                        obj.readData(s, in);
                        readList.add(obj);
                    }
                    for (int i = 0; i < readList.size(); i++) {
//textArea.appendText(readList.get(i)+"\n"); obj=new MoveCount();
                        obj = readList.get(i);
                        String text = String.format("Назва екскурсії: %s\nКраїна та місто: %s\nТранспорт: %s\nТривалість: %.0f\nВартість:%.0f\n",
                                obj.getName(), obj.getCountryandCity(),
                                obj.gettransport(), obj.getTrivality_of_excursions(),
                                obj.getPrice());
                        textArea.appendText(text + "\n");

                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });






//Пошук у файлі
        searchButton.setOnAction((ActionEvent event) -> { textArea.clear();
            indexOfFindList.clear(); boolean flag=false; Excursions mc;
            if(!searchText.getText().isEmpty()){ for(int i=0;
                                                     i<readList.size(); i++){
                mc = readList.get(i);

                if(mc.getName().equals(searchText.getText().toUpperCase())){
                    flag = true; textArea.appendText(mc+"\n");
                    indexOfFindList.add(i);
                }
            }


                if(!flag){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    DialogPane dialogPane=alert.getDialogPane();
                    dialogPane.setStyle("-fx-background-color: #FFFFFF");
                    alert.setTitle("Помилка!");
                    alert.setHeaderText("Файл не знайдено!"); alert.setContentText(null);
                    alert.showAndWait();
                }}
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                DialogPane dialogPane=alert.getDialogPane();
                dialogPane.setStyle("-fx-background-color: #FFFFFF");
                alert.setTitle("Помилка!");
                alert.setHeaderText("Введіть дані для пошуку");
                alert.setContentText(null);
                alert.showAndWait();
            }
        });

//Зміна даних
        editButton.setOnAction((ActionEvent event) -> {
            String m1 = "Назва екскурсії";
            String m2 = "Країна та місто";
            String m3 = "Транспорт";
            String m4 = "Тривалість";
            String m5 = "Вартість";
            Excursions excursions = null;
            if(indexOfFindList.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                DialogPane dialogPane=alert.getDialogPane();
                dialogPane.setStyle("-fx-background-color: #FFFFFF");
                alert.setTitle("Помилка!");
                alert.setHeaderText("Дані не знайдено.");
                alert.setContentText(null);
                alert.showAndWait();
            }
            else{
                if(choiceComboBox.getValue()==null ||
                        editText.getText().isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    DialogPane dialogPane=alert.getDialogPane();
                    dialogPane.setStyle("-fx-background-color: #FFFFFF");
                    alert.setTitle("Помилка!");
                    alert.setHeaderText("Дані не знайдено.");
                    alert.setContentText(null);
                    alert.showAndWait();
                }
                else{

                    if(choiceComboBox.getValue().toString()== m1){
                        for(int i=0; i<indexOfFindList.size(); i++){
                            excursions = readList.get(indexOfFindList.get(i));

                            excursions.setName(editText.getText().toUpperCase());
                            readList.set(indexOfFindList.get(i), excursions);
                        }
                    }
                    if(choiceComboBox.getValue().toString()==m2){
                        for(int i=0; i<indexOfFindList.size(); i++){
                            excursions = readList.get(indexOfFindList.get(i));

                            excursions.setCountryandCity(editText.getText().toUpperCase());
                            readList.set(indexOfFindList.get(i), excursions);
                        }
                    }

                    if(choiceComboBox.getValue().toString()==m3){
                        for(int i=0; i<indexOfFindList.size(); i++){
                            excursions = readList.get(indexOfFindList.get(i));

                            excursions.settransport(editText.getText().toUpperCase());
                            readList.set(indexOfFindList.get(i), excursions);
                        }
                    }

                    if(choiceComboBox.getValue().toString()==m4){ for(int i=0; i<indexOfFindList.size(); i++){
                        excursions = readList.get(indexOfFindList.get(i));

                        excursions.setTrivality_of_excursions(Integer.parseInt(editText.getText()));
                        readList.set(indexOfFindList.get(i), excursions);
                    }
                    }
                    if(choiceComboBox.getValue().toString()==m5){
                        for(int i=0; i<indexOfFindList.size(); i++){
                            excursions = readList.get(indexOfFindList.get(i));

                            excursions.setPrice(Integer.parseInt(editText.getText()));
                            readList.set(indexOfFindList.get(i), excursions);
                        }
                    }
                    textArea.appendText("\nДані успішно замінено:\n"); textArea.appendText(excursions +"\n");

                    try (PrintWriter out = new PrintWriter(new
                            FileWriter("D:\\Excursions.txt"))){
                        Iterator<Excursions> it = readList.iterator();
                        while(it.hasNext()) {
                            Excursions element;
                            element=it.next();
                            element.writeData(out);
                        }
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    readList.clear();
                }
            }
        });

//Кнопки меню
        aboutButton.setOnAction((ActionEvent event ) -> {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            DialogPane dialogPane=alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #F0F8FF");
            alert.setTitle("Інформація про виконавця");
            alert.setHeaderText("Варіант 17 Екскурсій ," +
                    "Робота Голінського Юрія Валерійовича,\nстудентп групи 333Б.\nОНТУ, 2022 р.");

            alert.showAndWait();
        });
        clearButton.setOnAction((ActionEvent event ) -> {
            NameText.clear();
            CountryandCityText.clear();
            transportText.clear();
            Trivality_of_excursionsText.clear();
            PriceText.clear();
            textArea.clear();
        });
        red.setOnAction((ActionEvent event ) -> {
            gridPane1.setStyle("-fx-background-color:#e30202");
            gridArray.setStyle("-fx-background-color:#ba2323");
            searchGridPanel.setStyle("-fx-background-color:#b35959");

            NameLabel.setStyle("-fx-text-fill: white");
            CountryandCityLabel.setStyle("-fx-text-fill: white");
            transportLabel.setStyle("-fx-text-fill: white");
            Trivality_of_excursionsLabel.setStyle("-fx-text-fill: white");
            PriceLabel.setStyle("-fx-text-fill: white");
            bufLabel.setStyle("-fx-text-fill: white");
        });
        Font font1 = new Font("Times New Roman",14);
        Font font2 = new Font("Courier",14);
        TimesNewRoman.setOnAction((ActionEvent event ) -> {
            searchButton.setFont(font1);
            editButton.setFont(font1);
            textArea.setFont(font1);
            textArea.setStyle("-fx-text-fill: #4682B4");
        });

        Courier.setOnAction((ActionEvent event ) -> {
            searchButton.setFont(font2);
            editButton.setFont(font2);
            textArea.setFont(font2);
            textArea.setStyle("-fx-text-fill: #FFA500");
        });

        Violet.setOnAction((ActionEvent event ) -> {
            gridPane1.setStyle("-fx-background-color:#b918d6");
            gridArray.setStyle("-fx-background-color:#b918d6");
            searchGridPanel.setStyle("-fx-background-color:#b918d6");

            NameLabel.setStyle("-fx-text-fill: white");
            CountryandCityLabel.setStyle("-fx-text-fill: white");
            transportLabel.setStyle("-fx-text-fill: white");
            Trivality_of_excursionsLabel.setStyle("-fx-text-fill: white");
            PriceLabel.setStyle("-fx-text-fill: white");
            bufLabel.setStyle("-fx-text-fill: white");
        });

        yellow.setOnAction((ActionEvent event ) -> {
            gridPane1.setStyle("-fx-background-color:#F0E68C");
            gridArray.setStyle("-fx-background-color:#F0E68C");
            searchGridPanel.setStyle("-fx-background-color:#FFD700");

            NameLabel.setStyle("-fx-text-fill: black");
            CountryandCityLabel.setStyle("-fx-text-fill: black");
            transportLabel.setStyle("-fx-text-fill: black");
            Trivality_of_excursionsLabel.setStyle("-fx-text-fill: black");
            PriceLabel.setStyle("-fx-text-fill: black");
            bufLabel.setStyle("-fx-text-fill: black");
        });
        multiple_colors.setOnAction((ActionEvent event ) -> {
            gridPane1.setStyle("-fx-background-color:#d61818");
            gridArray.setStyle("-fx-background-color:#b4cfd9");
            searchGridPanel.setStyle("-fx-background-color:#319418");

            NameLabel.setStyle("-fx-text-fill: #0a0a0a");
            CountryandCityLabel.setStyle("-fx-text-fill: #0a0a0a");
            transportLabel.setStyle("-fx-text-fill: #0a0a0a");
            Trivality_of_excursionsLabel.setStyle("-fx-text-fill: #0a0a0a");
            PriceLabel.setStyle("-fx-text-fill: #0a0a0a");
            bufLabel.setStyle("-fx-text-fill: #0a0a0a");
        });


        main_color.setOnAction((ActionEvent event ) -> {
            gridPane1.setStyle("-fx-background-color:white");
            gridArray.setStyle("-fx-background-color:white");
            searchGridPanel.setStyle("-fx-background-color:white");

            NameLabel.setStyle("-fx-text-fill: #0a0a0a");
            CountryandCityLabel.setStyle("-fx-text-fill: #0a0a0a");
            transportLabel.setStyle("-fx-text-fill: #0a0a0a");
            Trivality_of_excursionsLabel.setStyle("-fx-text-fill: #0a0a0a");
            PriceLabel.setStyle("-fx-text-fill: #0a0a0a");
            bufLabel.setStyle("-fx-text-fill: #0a0a0a");
        });
        stage.show();

    }
    static void errorM()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane=alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: blue");
        alert.setTitle("Поле не знайдено!");
        alert.setHeaderText("Оберіть поле!");
        alert.setContentText(null);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}









