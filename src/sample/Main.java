package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // ------------------------------------------------------------------------- Все контролы -----------------------------------------------------------
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(new Label("lable")); // метка
        flowPane.getChildren().add(new Button("Button")); // кнопка

        //-------------------------------------------------------------radio button
        ToggleGroup group = new ToggleGroup(); // создание группы
        RadioButton rb1 = new RadioButton("1"); // создание кнокпи
        RadioButton rb2 = new RadioButton("2");
        RadioButton rb3 = new RadioButton("3");
        rb1.setToggleGroup(group); // объединение в группу
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb3.setSelected(true); // выбранная кнопка
        flowPane.getChildren().addAll(rb1,rb2,rb3); // добавление на панель

        //------------------------------------------------------------- toggle Button / кнопка как тумблер (вкл и выкл)
        flowPane.getChildren().addAll(new ToggleButton("toggle Button")); // создание

        flowPane.getChildren().addAll(new CheckBox("checkBox")); // галочка
        flowPane.getChildren().addAll(new ChoiceBox<String>(FXCollections.observableArrayList("4","5","6","7"))); // выпадающий список
        flowPane.getChildren().addAll(new TextField("texField")); //обычный ввод тектса
        flowPane.getChildren().addAll(new PasswordField()); // ввод пароля

        //------------------------------------------------------------- ScrollBar - прокртка ползунка
        ScrollBar sc = new ScrollBar(); // создание
        sc.setMin(0);
        sc.setMax(100);
        sc.setValue(50); // где он будет
        flowPane.getChildren().addAll(sc); // добавление на панель

        /* // через картинку
        Image IMG = new Image(getClass().getResourceAsStream("scrol.png"));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ImageView(IMG));
        flowPane.getChildren().add(scrollPane);
         */

        // ------------------------------------------------------------- ListView - список
        ListView<String> listView = new ListView<String>(); // создание
        ObservableList<String> item = FXCollections.observableArrayList("8","9","10","11"); // поля
        listView.setItems(item); // добавлние полей в список
        listView.setMaxHeight(100);
        flowPane.getChildren().addAll(listView);// добавление на панель

        // ------------------------------------------------------------- TreeItem - тоже список
        TreeItem<String> stringTreeItem = new TreeItem<String>("inbox");
        stringTreeItem.setExpanded(true); // создание
        for (int i=0; i<6; i++){
            TreeItem<String> item1 = new TreeItem<String>("Massege "+i);
            stringTreeItem.getChildren().addAll(item1); // поля
        }
        TreeView<String> tree = new TreeView<String>(stringTreeItem); // добавлние полей в список
        tree.setMaxHeight(100);
        flowPane.getChildren().addAll(tree); // добавление на панель

        // ------------------------------------------------------------- ComboBox
        ObservableList<String> option =  // поля
                FXCollections.observableArrayList(
                        "Otion 1",
                        "Otion 2",
                        "Otion 3"
                );
        ComboBox comboBox = new ComboBox(option); // добавлние полей
        flowPane.getChildren().addAll(comboBox);// добавление на панель

        // ------------------------------------------------------------- Separator - разделитель
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        flowPane.getChildren().addAll(separator);

        // ------------------------------------------------------------- показатель с метками
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        flowPane.getChildren().addAll(slider);

        ProgressBar pb = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);
        flowPane.getChildren().addAll(pb, pi);

        // ------------------------------------------------------------- создание гиперсылки
        Hyperlink link = new Hyperlink();
        link.setText("https://google.com");
        link.setOnAction(event -> {
            System.out.println("this link");
        });
        flowPane.getChildren().addAll(link);

        //------------------------------------------------------------- подсказка
        Tooltip tooltip = new Tooltip();
        tooltip.setText("this linck to google");
        link.setTooltip(tooltip);

        // ------------------------------------------------------------- редактор текста
        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        flowPane.getChildren().addAll(htmlEditor);

        // ------------------------------------------------------------- менюшка с выподающим списком
        TitledPane tp = new TitledPane("My title pane", new Button("button"));
        flowPane.getChildren().addAll(tp);

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(tp, new TitledPane("second", new TextField("text field")));
        accordion.setExpandedPane(tp);
        flowPane.getChildren().addAll(accordion);

        // ------------------------------------------------------------- меню вверху
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEditor = new Menu("Editor");
        MenuItem menuItem1 = new MenuItem("Open");
        MenuItem menuItem2 = new MenuItem("Close");
        menuFile.getItems().addAll(menuItem1, menuItem2);
        menuBar.getMenus().addAll(menuFile, menuEditor);

        // разбиваем на 2 панели
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, flowPane);

        // ------------------------------------------------------------- цветная палитра
        ColorPicker colorPicker = new ColorPicker();
        flowPane.getChildren().addAll(colorPicker);

        // ------------------------------------------------------------- Pagination - переход по номерам
        Pagination pagination = new Pagination();
        flowPane.getChildren().addAll(pagination);

        // ------------------------------------------------------------- FileChooser - открытие файлов
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("FileChooser");

        Button button = new Button("Open dialog FileChooser");
        button.setOnAction(event -> {
            fileChooser.showOpenDialog(primaryStage);
        });
        flowPane.getChildren().addAll(button);

        // ------------------------------------------------------------- настройка формы
        primaryStage.setTitle("UI Controls");
        primaryStage.setScene(new Scene(vBox, 790, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
