package matthew.shannon.jamfam.presenter;

import android.support.annotation.NonNull;
import com.google.common.base.Preconditions;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter {

    private final CompositeSubscription subscriptions;

    protected BasePresenter() {
        subscriptions = new CompositeSubscription();
    }

    protected void add(@NonNull Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            subscriptions.add(subscription);
        }
    }

    public void unsubscribe() {
        if (subscriptions.hasSubscriptions() && !subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }
    }


}
