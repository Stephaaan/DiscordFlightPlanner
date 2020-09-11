package models;

import enums.Action;

import java.util.Arrays;

public class Command {


    private Action action;



    private String[] args;

    public Command(String message) {
        extractCommandFromMessage(message);
    }
    public Command(String action, String[] args){
        this(Action.get(action), args);
    }
    public Command(Action action, String[] args){
        this.action = action;
        this.args = args;
    }

    private void extractCommandFromMessage(String message) {
        String[] splittedMessage = message.split(" ");
        this.action = Action.get(splittedMessage[0]);
        if(splittedMessage.length == 1){
            //command without argument
            this.args = new String[0];
        }else {
            this.args = Arrays.copyOfRange(splittedMessage, 1, splittedMessage.length);
        }
    }

    public Action getAction() {
        return action;
    }
    public String[] getArgs() {
        return args;
    }

}
