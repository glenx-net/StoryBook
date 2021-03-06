package net.glenx.storybook.model;

/**
 * Created by irglenc_adm on 27/12/2016.
 */

public class Page {

    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private Boolean mIsFinal = false;

    public Page(int ImageId, String text, Choice choice1, Choice choice2){
        mImageId = ImageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;

    };


    public Page(int ImageId, String text){
        mImageId = ImageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;

        mIsFinal = true;
    };

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public Boolean getFinal() {
        return mIsFinal;
    }

    public void setFinal(Boolean aFinal) {
        mIsFinal = aFinal;
    }

}
