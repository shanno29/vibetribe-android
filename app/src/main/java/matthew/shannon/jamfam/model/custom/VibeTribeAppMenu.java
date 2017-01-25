package matthew.shannon.jamfam.model.custom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.ogaclejapan.arclayout.ArcLayout;

import at.markushi.ui.CircleButton;

public class VibeTribeAppMenu extends RelativeLayout {
    private AppCompatActivity activity;
    private CircleButton soundcloudButton;
    private CircleButton spotifyButton;
    private CircleButton youtubeButton;
    private CircleButton pandoraButton;
    private CircleButton centerButton;
    private ArcLayout arc;

    public VibeTribeAppMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        //this.activity = (AppCompatActivity) context;
    }

//    @Override protected void onFinishInflate() {
//        super.onFinishInflate();
//        inflate(getContext(), R.layout.app_menu_layout, this);
//
//        this.arc = (ArcLayout)findViewById(R.id.arc);
//        this.centerButton = (CircleButton) findViewById(R.id.center_item);
//        this.soundcloudButton = (CircleButton) findViewById(R.id.soundcloud);
//        this.spotifyButton = (CircleButton) findViewById(R.id.spotify);
//        this.youtubeButton = (CircleButton) findViewById(R.id.youtube);
//        this.pandoraButton = (CircleButton) findViewById(R.id.pandora);
//
//        this.centerButton.setOnClickListener(view -> toggleAppMenu(false));
//        this.soundcloudButton.setOnClickListener(view -> goToApp("SOUNDCLOUD"));
//        this.spotifyButton.setOnClickListener(view -> goToApp("SPOTIFY"));
//        this.youtubeButton.setOnClickListener(view -> goToApp("YOUTUBE"));
//        this.pandoraButton.setOnClickListener(view -> goToApp("PANDORA"));
//    }
//
//    @Override protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//
//    }
//
//    private void init(){
//
//    }
//
//    private void goToApp(String TYPE) {
//        toggleAppMenu(false);
//        new Handler().postDelayed(() -> {
//            try {
//                String intent = null;
//                switch(TYPE) {
//                    case "YOUTUBE":
//                        intent = "com.google.android.apps.youtube.music";
//                        break;
//                    case "SPOTIFY":
//                        intent = "com.spotify.music";
//                        break;
//                    case "SOUNDCLOUD":
//                        intent = "com.soundcloud.android";
//                        break;
//                    case "PANDORA":
//                        intent = "com.pandora.android";
//                        break;
//                }
//                getContext().startActivity(getContext().getPackageManager().getLaunchIntentForPackage(intent));
//            } catch(Exception e) {
//                goToStore(getContext(), TYPE);
//            }
//        }, 500);
//    }
//    private static void goToStore(Context context, String TYPE){
//        String url = null;
//        switch(TYPE) {
//            case "VIBETRIBE":
//                url = "https://play.google.com/store/apps/details?id=matthew.shannon.vibetribe";
//                break;
//            case "YOUTUBE":
//                url = "https://play.google.com/store/apps/details?id=com.google.android.apps.youtube.music";
//                break;
//            case "SPOTIFY":
//                url = "https://play.google.com/store/apps/details?id=com.spotify.music";
//                break;
//            case "SOUNDCLOUD":
//                url = "https://play.google.com/store/apps/details?id=com.soundcloud.android";
//                break;
//            case "PANDORA":
//                url = "https://play.google.com/store/apps/details?id=com.pandora.android";
//                break;
//        }
//        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
//    }
//
//    public void toggleAppMenu(boolean hidden) {
//
//        int cx = (int)(this.getX() + this.getWidth() / 2);
//        int cy = (int)(this.getY() + this.getHeight() / 2);
//
//        int radius = Math.max(this.getWidth(), this.getHeight());
//
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
//
//            if(hidden){
//                this.setVisibility(View.VISIBLE);
//                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(this, cx, cy, 0, radius);
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.addListener(new SupportAnimator.AnimatorListener(){
//                    @Override public void onAnimationStart(){}
//                    @Override public void onAnimationEnd(){
//                        List<Animator> animList = new ArrayList<>();
//                        animList.add(showItem(centerButton));
//                        for(int i = 0, len = arc.getChildCount(); i < len; i++) {
//                            animList.add(showItem(arc.getChildAt(i)));
//                        }
//                        start(animList);
//                    }
//                    @Override public void onAnimationCancel(){}
//                    @Override public void onAnimationRepeat(){}
//                });
//                animator.setDuration(800);
//                animator.start();
//
//            }
//            else{
//                List<Animator> animList = new ArrayList<>();
//                for(int i = arc.getChildCount() - 1; i >= 0; i--) {
//                    animList.add(hideItem(arc.getChildAt(i), centerButton));
//                }
//                Animator animator = hideItem(centerButton, centerButton);
//                animator.addListener(new Animator.AnimatorListener(){
//                    @Override public void onAnimationStart(Animator animator){
//
//                    }
//
//                    @Override public void onAnimationEnd(Animator animator){
//                        SupportAnimator reveal = ViewAnimationUtils.createCircularReveal(VibeTribeAppMenu.this, cx, cy, radius, 0);
//                        reveal.addListener(new SupportAnimator.AnimatorListener(){
//                            @Override public void onAnimationStart(){
//
//                            }
//
//                            @Override public void onAnimationEnd(){
//                                VibeTribeAppMenu.this.setVisibility(View.INVISIBLE);
//
//                            }
//
//                            @Override public void onAnimationCancel(){
//
//                            }
//
//                            @Override public void onAnimationRepeat(){
//
//                            }
//                        });
//                        reveal.start();
//                    }
//
//                    @Override public void onAnimationCancel(Animator animator){
//
//                    }
//
//                    @Override public void onAnimationRepeat(Animator animator){
//
//                    }
//                });
//                start(animList);
//            }
//
//        }
//        else{
//
//            if(hidden){
//                this.setVisibility(View.VISIBLE);
//                List<Animator> animList = new ArrayList<>();
//                animList.add(android.view.ViewAnimationUtils.createCircularReveal(this, cx, cy, 0, radius));
//                animList.add(showItem(centerButton));
//                for(int i = 0, len = arc.getChildCount(); i < len; i++) {
//                    animList.add(showItem(arc.getChildAt(i)));
//                }
//                start(animList);
//
//            }
//            else{
//                List<Animator> animList = new ArrayList<>();
//                for(int i = arc.getChildCount() - 1; i >= 0; i--) {
//                    animList.add(hideItem(arc.getChildAt(i), centerButton));
//                }
//                animList.add(hideItem(centerButton, centerButton));
//                Animator anim = android.view.ViewAnimationUtils.createCircularReveal(this, cx, cy, radius, 0);
//                anim.addListener(new Animator.AnimatorListener(){
//                    @Override public void onAnimationStart(Animator animator){
//
//                    }
//
//                    @Override public void onAnimationEnd(Animator animator){
//                        VibeTribeAppMenu.this.setVisibility(View.INVISIBLE);
//                    }
//
//                    @Override public void onAnimationCancel(Animator animator){
//
//                    }
//
//                    @Override public void onAnimationRepeat(Animator animator){
//
//                    }
//                });
//                animList.add(anim);
//                start(animList);
//            }
//        }
//
//    }
//
//    private void start(List<Animator> animList){
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.playSequentially(animList);
//        animSet.start();
//    }
//    private Animator showItem(View item){
//        item.setScaleX(0f);
//        item.setScaleY(0f);
//        item.setTranslationX(item.getRootView().getX() - item.getX());
//        item.setTranslationY(item.getRootView().getY() - item.getY());
//        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item, scaleX(0f, 1f), scaleY(0f, 1f), translationX(item.getRootView().getX() - item.getX(), 0f), translationY(item.getRootView().getY() - item.getY(), 0f));
//
//        anim.setInterpolator(new DecelerateInterpolator());
//        anim.setDuration(50);
//        return anim;
//    }
//    private Animator hideItem(View item, CircleButton button){
//
//        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item, scaleX(1f, 0f), scaleY(1f, 0f), translationX(0f, button.getX() - item.getX()), translationY(0f, button.getY() - item.getY()));
//
//        anim.setInterpolator(new DecelerateInterpolator());
//        anim.addListener(new AnimatorListenerAdapter(){
//            @Override public void onAnimationEnd(Animator animation){
//                super.onAnimationEnd(animation);
//                item.setTranslationX(0f);
//                item.setTranslationY(0f);
//            }
//        });
//        anim.setDuration(50);
//        return anim;
//    }
//    private PropertyValuesHolder translationX(float... values){
//        return PropertyValuesHolder.ofFloat("translationX", values);
//    }
//    private PropertyValuesHolder translationY(float... values){
//        return PropertyValuesHolder.ofFloat("translationY", values);
//    }
//    private PropertyValuesHolder scaleX(float... values){
//        return PropertyValuesHolder.ofFloat("scaleX", values);
//    }
//    private PropertyValuesHolder scaleY(float... values){
//        return PropertyValuesHolder.ofFloat("scaleY", values);
//    }

}