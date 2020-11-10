/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NC;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;

public class simpleTest extends Application {

    private static final Font FONT = Font.font("Tahoma", 18);

    private QuestionPane qPane = new QuestionPane();
    private SidePane sPane = new SidePane();

    private Parent createContent() {
        HBox root = new HBox(30);
        root.setPadding(new Insets(100, 100, 100, 100));

        qPane.setQuestion(new Question("Calculate 5x4. Pick the best answer:", "20", "25", "15", "10"));

        root.getChildren().addAll(qPane, sPane);
        return root;
    }

    private void nextQuestion() {
        qPane.setQuestion(new Question("Calculate 6/2. Pick the best answer: ", "3", "6", "2", "1"));
        sPane.selectNext();
    }
    


    private class SidePane extends VBox {
        private int current = 1;
        public SidePane() {
            super(10);

            for (int i = 10; i > 0; i--) {
                Text text = new Text("Question " + i);
                text.setFill(i == current ? Color.BLACK : Color.GRAY);

                getChildren().add(text);
            }
        }

        public void selectNext() {
            if (current == 10) {
                return;
            }
            
            
            Text text = (Text)getChildren().get(10 - current);
            text.setFill(Color.GREEN);
            current++;
            text = (Text)getChildren().get(10 - current);
            text.setFill(Color.BLACK);
        }
        
  
    }

    

    private class QuestionPane extends VBox {
        private Text text = new Text();
        private List<Button> buttons = new ArrayList<>();
        private Question current;

        public QuestionPane() {
            super(20);
          
       

            text.setFont(FONT);

            VBox vbox = new VBox();
            for (int i = 0; i < 4; i++) {
                Button btn = new Button();
                btn.setFont(FONT);
                btn.setPrefWidth(50);
                btn.setOnAction(event -> {
                    if (btn.getText().equals(current.getCorrectAnswer())) {
                        nextQuestion();
                    }
                    else {
                        System.out.println("Incorrect");
                        nextQuestion();
                    }
                });

                buttons.add(btn);
                vbox.getChildren().add(btn);
            }
            
            

            setAlignment(Pos.CENTER);
            getChildren().addAll(text, vbox);
        }

        public void setQuestion(Question question) {
            current = question;
            text.setText(question.name);

            Collections.shuffle(buttons);
            for (int i = 0; i < 4; i++) {
                buttons.get(i).setText(question.answers.get(i));
            }
        }
    }

    private class Question {
        private String name;
        private List<String> answers;

        public Question(String name, String... answers) {
            this.name = name;
            this.answers = Arrays.asList(answers);
        }

        public String getCorrectAnswer() {
            return answers.get(0);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
   
    	primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

