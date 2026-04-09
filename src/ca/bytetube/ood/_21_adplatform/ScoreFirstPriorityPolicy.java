package ca.bytetube.ood._21_adplatform;

public class ScoreFirstPriorityPolicy implements AdPriorityPolicy {
    @Override
    public int compare(Ad a, Ad b) {
        int scoreDiff = Integer.compare(b.getScore(), a.getScore());
        if (scoreDiff != 0) {
            return scoreDiff;
        }
        return Long.compare(a.getSequence(), b.getSequence());
    }
}
