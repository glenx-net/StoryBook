package net.glenx.storybook.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.glenx.storybook.R;
import net.glenx.storybook.model.Page;
import net.glenx.storybook.model.Story;

public class StoryActivity extends Activity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName==null) {
            mName = "Friend";
        }

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choice1button);
        mChoice2 = (Button) findViewById(R.id.choice2button);

        loadPage(0);


    }


    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        if(mCurrentPage.getFinal()) {
               mChoice1.setVisibility(View.INVISIBLE);
               mChoice2.setText("PLAY AGIAN");
               mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
        else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });

        }

    }

}
