package com.support.android.tokusatsu;

import android.support.v7.app.AppCompatActivity;
/**
 * Created by Mário on 14/10/2015.
 */
public class CompartilhaActivity  extends AppCompatActivity {

    /*

       private Toolbar mToolbar;
        private Toolbar mToolbarBottom;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);

            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("Second Activity");
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mToolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Intent it = null;

                    switch(menuItem.getItemId()){
                        case R.id.action_facebook:
                            it = new Intent(Intent.ACTION_VIEW);
                            it.setData(Uri.parse("http://www.facebook.com"));
                            break;
                        case R.id.action_youtube:
                            it = new Intent(Intent.ACTION_VIEW);
                            it.setData(Uri.parse("http://www.youtube.com"));
                            break;
                        case R.id.action_google_plus:
                            it = new Intent(Intent.ACTION_VIEW);
                            it.setData(Uri.parse("http://plus.google.com"));
                            break;
                        case R.id.action_linkedin:
                            it = new Intent(Intent.ACTION_VIEW);
                            it.setData(Uri.parse("http://www.linkedin.com"));
                            break;
                        case R.id.action_whatsapp:
                            it = new Intent(Intent.ACTION_VIEW);
                            it.setData(Uri.parse("http://www.whatsapp.com"));
                            break;
                    }

                    startActivity(it);
                    return true;
                }
            });
            mToolbarBottom.inflateMenu(R.menu.menu_bottom);

            mToolbarBottom.findViewById(R.id.iv_settings).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SecondActivity.this, "Settings pressed", Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        protected void onResume() {
            super.onResume();

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                mToolbar.setBackgroundResource(R.drawable.toolbar_rounded_corners);
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_second, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if(id == android.R.id.home){
                finish();
            }

            return true;
        }
    }
    */

}
