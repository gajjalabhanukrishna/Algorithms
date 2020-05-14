public class TextJustification {


    public String find(String[] word, int maxWidth, int index){
        if(index < word.length){
            String result = "";

            int currentLen = 0;
            int remainingLen = maxWidth;

            while(result.length() < maxWidth && index < word.length){

                if(remainingLen >= word[index].length() +1){
                    if(!result.equals("")){
                        result += "@" + word[index];
                        currentLen = word[index].length();
                    }else{
                        result += word[index];
                        currentLen = word[index].length();
                    }
                    remainingLen -= currentLen;
                    index++;
                } else if(remainingLen > 0){
                    if(!result.contains("@")){
                        for(int i = 0; i< remainingLen; i++){
                            result = result + " ";
                        }
                    } else {
                        String[] arr = result.split("@");
                        int mod = (remainingLen % (arr.length - 1));
                        int splitedSpace = remainingLen / (arr.length - 1);
                        String spaces = " ";
                        for (int i = 0; i < splitedSpace; i++) {
                            spaces = spaces + " ";
                        }
                        String leftmost = spaces;
                        for (int i = 0; i < mod; i++) {
                            leftmost = leftmost + " ";
                        }
                        result = result.replaceFirst("@", leftmost);
                        result = result.replaceAll("@", spaces);
                    }
                }
            }

            result = result.replaceAll("@", " ");
            return result + "\n" + find(word,maxWidth,index);
        } else{
            return "";
        }
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String [] words = {"This", "is", "a", "text", "justification","problem","in","tutorial","horizon"};
        int maxWidth = 16;
        System.out.println(tj.find(words,maxWidth,0));
    }
}


