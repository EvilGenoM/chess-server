package mobi.mpk.chess.message;

public class StrokeMessage extends Message {

    public StrokeMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        String textStroke[] = text.split(" ");

        if(     textStroke.length != 2 ||
                textStroke[0].length() != 2 ||
                textStroke[1].length() != 2){

            return false;

        }

        char letterTo = textStroke[0].charAt(0);
        int numberTo = Character.digit(textStroke[0].charAt(1), 10);


        if(letterTo<'a' || letterTo>'h'){
            return false;
        } else if (numberTo < 1 || numberTo > 8){
            return false;
        }

        char letterFrom = textStroke[1].charAt(0);
        int numberFrom = Character.digit(textStroke[1].charAt(1), 10);

        if(letterFrom < 'a' || letterFrom > 'h'){
            return false;
        } else if (numberFrom < 1 || numberFrom > 8){
            return false;
        }

        this.text = text;

        return true;
    }

}
