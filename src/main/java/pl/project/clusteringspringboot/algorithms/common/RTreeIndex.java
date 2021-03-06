package pl.project.clusteringspringboot.algorithms.common;

import pl.project.clusteringspringboot.spatialindex.rtree.RTree;
import pl.project.clusteringspringboot.spatialindex.spatialindex.IShape;
import pl.project.clusteringspringboot.spatialindex.spatialindex.Point;
import pl.project.clusteringspringboot.spatialindex.storagemanager.IBuffer;
import pl.project.clusteringspringboot.spatialindex.storagemanager.MemoryStorageManager;
import pl.project.clusteringspringboot.spatialindex.storagemanager.PropertySet;
import pl.project.clusteringspringboot.spatialindex.storagemanager.RandomEvictionsBuffer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Piotr Lasek on 01.06.2017.
 */
public class RTreeIndex {

    private RTree treeIndex;
    private ArrayList<Point> internalSetOfPoints;
    private int datasetSize;

    /**
     *
     * @throws IOException
     */
    public void initRTree(ArrayList<Point> SetOfPoints, int nDim) throws IOException {

        this.internalSetOfPoints = SetOfPoints;
        MyVisitor.SetOfPoints = SetOfPoints;
        PropertySet ps = new PropertySet();
        ps.setProperty("FileName", "nbc-rtree");
        ps.setProperty("FillFactor", 0.1);
        ps.setProperty("IndexCapacity", 32);
        ps.setProperty("LeafCapacity", 32);
        ps.setProperty("Dimension", nDim);

        MemoryStorageManager memmanag = new MemoryStorageManager();
        IBuffer mem = new RandomEvictionsBuffer(memmanag, 40000, false);

        treeIndex = new RTree(ps, mem);
    }

    /**
     *
     * @param d
     * @param mp
     * @param id
     */
    public void insertData(byte[] d, Point mp, int id) {
        treeIndex.insertData(d, mp, id);
        datasetSize++;
    }

    /**
     *
     * @param point
     * @param Eps
     * @return
     */
    public ArrayList<Point> regionQuery(IShape point,
                                        double Eps) {
        MyVisitor kNN = new MyVisitor();
        treeIndex.nearestNeighborQuery(Eps, point, kNN, datasetSize);
        return kNN.neighbours;
    }

    public void nearestNeighborQuery(int k, IShape p, MyVisitor kNN) {
        treeIndex.nearestNeighborQuery(k, p, kNN);
    }
}

