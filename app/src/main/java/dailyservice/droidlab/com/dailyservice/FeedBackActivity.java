package dailyservice.droidlab.com.dailyservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
* Created by Dinesh on 4/19/2015.
*/
public class FeedBackActivity extends Activity {
    Button emailSendButton;
    EditText emailAddressField, emailSubjectField, emailContentField;
    View emailView = null;

    String kContent = "Content";

    // Change background variables
    String kBackgroundResId = "backgroundResId";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setting the view to be displayed
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.email_layout);

        emailView = findViewById(R.id.email_view);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // final AdView ad = (AdView) findViewById(R.id.myad);///.....added ad
        // here..................

        // ad.setAdListener(new myAdListener());

        int backgroundResId = getIntent().getIntExtra(kBackgroundResId, -1);
//        if (backgroundResId != -1) {
//            // emailView.setBackgroundResource(backgroundResId);
//            emailView.setBackgroundResource(R.drawable.xmas);
//        }

        // Quit Button
        ImageButton quitButton = (ImageButton) (findViewById(R.id.email_quitButton));
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //quitApplication();
            }
        });

        // Back Button
        ImageButton backButton = (ImageButton) (findViewById(R.id.email_backButton));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // returnToPreviousActivity();
            }
        });

        emailSendButton = (Button) findViewById(R.id.email_sendButton);
       // emailSendButton.setTypeface(textFace);

        emailAddressField = (EditText) findViewById(R.id.email_addressField);
       // emailAddressField.setTypeface(textFace);

        emailAddressField.setText("droidlab.it@gmail.com");
        emailSubjectField = (EditText) findViewById(R.id.email_subjectField);
       // emailSubjectField.setTypeface(textFace);

        emailContentField = (EditText) findViewById(R.id.email_contentField);
       // emailContentField.setTypeface(textFace);
        emailContentField.setText(getIntent().getStringExtra(kContent));

        emailSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // final Intent emailIntent = new
                // Intent(android.content.Intent.ACTION_SEND);
                // emailIntent.setType("plain/text");
                // emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                // new String[]{ emailAddressField.getText().toString()});
                // emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                // emailSubjectField.getText());
                // emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                // emailContentField.getText());
                // startActivity(Intent.createChooser(emailIntent,
                // "Send mail..."));

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent
                        .putExtra(Intent.EXTRA_EMAIL,
                                new String[] { "droidlab.it@gmail.com" });  // jewel@wedothewebs.com
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubjectField
                        .getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, emailContentField.getText()
                        .toString());
                try {
                    // startActivity(Intent.createChooser(intent,
                    // "Send mail..."));
                    startActivity(intent);
                    // Toast.makeText(SendingEmailActivity.this,
                    // "Mail Sent Successfully", Toast.LENGTH_SHORT).show();

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(FeedBackActivity.this,
                            "There are no email clients installed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
