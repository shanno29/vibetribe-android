package matthew.shannon.jamfam.model.base;

import android.support.annotation.NonNull;

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
