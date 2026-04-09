package ca.bytetube.ood._21_adplatform;

import java.util.Comparator;

public interface AdPriorityPolicy extends Comparator<Ad> {

    static AdPriorityPolicy defaultPolicy() {
        return new ScoreFirstPriorityPolicy();
    }

}
