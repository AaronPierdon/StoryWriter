/*
 * Developer:  Aaron Pierdon
 * Date:       Feb 7, 2018
 * Description:

 */

package dataModel;


public class StoryChapter {
    private String name;
    private String theText;
    private int sequence;

    public void setName(String name) {
        this.name = name;
    }

    public void setTheText(String theText) {
        this.theText = theText;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public String getTheText() {
        return theText;
    }

    public int getSequence() {
        return sequence;
    }
}
