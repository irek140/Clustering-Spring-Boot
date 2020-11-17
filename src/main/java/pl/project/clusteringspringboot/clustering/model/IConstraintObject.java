package pl.project.clusteringspringboot.clustering.model;

public interface IConstraintObject extends ISpatialObject {

    boolean isCannotLinkPoint();
    boolean isMustLinkPoint();
    boolean wasDeferred();

    void isCannotLinkPoint(boolean isCannotLinkPoint);
    void isMustLinkPoint(boolean isMustLinkPoint);
    void wasDeferred(boolean wasDeferred);

    IConstraintObject getParentCannotLinkPoint();
    void setParentCannotLinkPoint(IConstraintObject parentCannotLinkPoint);

    int getClusterId();
}
