package project4PointEnclosure;

import java.awt.*;

public class PointCounter {
    public static final float ALPHA = 0.001f;

    /**
     * Check weather the point is laying on the polygon edge
     * @param point enumerated point
     * @param points a bunch of points from user input
     * @return true if point is lay on the edge
     */
    public static boolean isPointOnLine(Point point, Point[] points) {
        int i, j;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if (points[i].x != points[j].x) {
                float a = (points[i].y - points[j].y) / (points[i].x - points[j].x);
                float b = points[j].y - a * points[j].x;
                if (Math.abs(point.y - (a * point.x +b)) < ALPHA) {
                    return true;
                }
            }
            else if (point.x == points[i].x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check weather the point is inside the polygon
     * @param point enumerated point
     * @param points a bunch of points from user input
     * @return true if point is inside the polygon
     */
    public static boolean isPointInPolygon(Point point, Point[] points) {
        int i, j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > point.y) != (points[j].y > point.y) &&
                    (point.x < (points[j].x - points[i].x) * (point.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
                result = !result;
            }
        }
        return result;
    }
}
