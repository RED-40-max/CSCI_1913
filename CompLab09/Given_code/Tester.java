package Given_code;
import AddBorder;
import Brighten;
import ColorPallet;
import Greyscale;
import Stamp;
import TransformationUtils;

/**
 * Tester class
 * Tester file for CSCI 1913 Lab 09
 * Original author: Daniel Kluver
 * Changes by Adriana Picoral in Fall 2025
 */

public class Tester {
    public static void main(String[] args) {
        boolean popUpImages = false;
        RGBImage img, out;
        Transformation t;
        Transformation[] transformations;

        // example 1 -- Transformation class
        System.out.println("************* Example 1 *************");
        img = RGBImageUtil.load("sourceImages/bruininks.png");
        t = new Transformation();
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_bruininks_T.png");

        // example 2 -- greyscale
        System.out.println("************* Example 2 *************");
        img = RGBImageUtil.load("sourceImages/bruininks_inside.png");
        t = new Greyscale();
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_bruininks_inside_G.png");

        // example 3 -- Brighten
        System.out.println("************* Example 3 *************");
        img = RGBImageUtil.load("sourceImages/Southeast_Steam_Plant-University_of_Minnesota-large.png");
        t = new Brighten(110);
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_Southeast_Steam_Plant-University_of_Minnesota-large_b110.png");

        // example 4 -- Brighten
        System.out.println("************* Example 4 *************");
        img = RGBImageUtil.load("sourceImages/Southeast_Steam_Plant-University_of_Minnesota-large.png");
        t = new Brighten(-40);
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_Southeast_Steam_Plant-University_of_Minnesota-large_bn40.png");

        // example 5 -- AddBorder
        System.out.println("************* Example 5 *************");
        img = RGBImageUtil.load("sourceImages/thumb.png");
        t = new AddBorder(1, new RGBColor(0,255,0));
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_thumb_A1green.png");

        // example 6 -- AddBorder
        System.out.println("************* Example 6 *************");
        img = RGBImageUtil.load("sourceImages/thumb.png");
        t = new AddBorder(10, new RGBColor(255,0,255));
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_thumb_A10purple.png");

        // example 7 -- AddBorder
        System.out.println("************* Example 7 *************");
        img = RGBImageUtil.load("sourceImages/University_of_Minnesota_entrance_sign_1-large.png");
        t = new AddBorder(10, new RGBColor(255,255,0));
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_University_of_Minnesota_entrance_sign_1-large_A10yellow.png");

        // example 8 -- ColorPallet
        System.out.println("************* Example 8 *************");
        img = RGBImageUtil.load("sourceImages/UMN-CivilEngineering-large.png");
        t = new ColorPallet(new RGBColor[]{new RGBColor(60, 59, 110),
                new RGBColor(255, 255, 255),
                new RGBColor(178, 34, 52)});
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_UMN-CivilEngineering-large_Pamerica.png");

        // example 9 -- ColorPallet
        System.out.println("************* Example 9 *************");
        img = RGBImageUtil.load("sourceImages/Platonic_figure_at_UMN-large.png");
        t = new ColorPallet(new RGBColor[]{
                new RGBColor(160,154,188),
                new RGBColor(182,166,202),
                new RGBColor(213,207,225),
                new RGBColor(225, 222, 233),
                new RGBColor(212, 190, 190)});
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_Platonic_figure_at_UMN-large_Pliliac.png");
        RGBImage expected = RGBImageUtil.load("expectedImages/Platonic_figure_at_UMN-large_Pliliac.png");
        if (imagesMatch(expected, out)) {
            System.out.println("Images match!");
        };


        // example 10 -- Stamp
        System.out.println("************* Example 10 *************");
        img = RGBImageUtil.load("sourceImages/groovy.png");
        t = new Stamp(RGBImageUtil.load("sourceImages/thumb.png"));
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_groovy_Sthumb.png");


        // example 11 -- Stamp
        System.out.println("************* Example 11 *************");
        img = RGBImageUtil.load("sourceImages/bruininks.png");
        t = new Stamp(RGBImageUtil.load("sourceImages/groovy.png"));
        out = t.transform(img);
        if (popUpImages) { showImages(img, out); }
        RGBImageUtil.saveImage(out, "outputImages/your_bruininks_Sgroovy.png");

        // Example 12 -- transformation util.
        System.out.println("************* Example 12 *************");
        transformations = new Transformation[]{
                new AddBorder(13, new RGBColor(238, 130, 238)), // violet
                new AddBorder(11, new RGBColor(75, 0, 130)), // indigo
                new AddBorder(9, new RGBColor(0, 0, 255)), // blue
                new AddBorder(7, new RGBColor(0, 128, 0)), // green
                new AddBorder(5, new RGBColor(255, 255, 0)), // yellow
                new AddBorder(3, new RGBColor(255, 165, 0)), // orange
                new AddBorder(1, new RGBColor(255, 0, 0)), // red

        };
        TransformationUtils.transformMany(transformations, "sourceImages/thumb.png", "outputImages/your_thumb_many_rainbow.png");
        img = RGBImageUtil.load("sourceImages/thumb.png");
        out = RGBImageUtil.load("outputImages/your_thumb_many_rainbow.png");
        if (popUpImages) { showImages(img, out); }


        // Example 13 -- transformation util.
        System.out.println("************* Example 13 *************");
        transformations = new Transformation[]{
                new Greyscale(),
                new AddBorder(10, new RGBColor(0,0,255)),
                new Stamp(RGBImageUtil.load("sourceImages/thumb.png"))
        };
        TransformationUtils.transformMany(transformations, "sourceImages/bruininks.png", "outputImages/your_bruininks_many.png");
        img = RGBImageUtil.load("sourceImages/bruininks.png");
        out = RGBImageUtil.load("outputImages/your_bruininks_many.png");
        if (popUpImages) { showImages(img, out); }

       // Example 14 -- transformation util.
        System.out.println("************* Example 14 *************");
        transformations = new Transformation[]{
                new Brighten(100),
                new ColorPallet(new RGBColor[]{
                        new RGBColor(160,154,188),
                        new RGBColor(182,166,202),
                        new RGBColor(213,207,225),
                        new RGBColor(225, 222, 233),
                        new RGBColor(212, 190, 190)}),
                new Brighten(-100),
                new Stamp(RGBImageUtil.load("sourceImages/thumb.png"))
        };
        TransformationUtils.transformMany(transformations, "sourceImages/Platonic_figure_at_UMN-large.png", "outputImages/your_Platonic_figure_at_UMN-large_many.png");
        img = RGBImageUtil.load("sourceImages/Platonic_figure_at_UMN-large.png");
        out = RGBImageUtil.load("outputImages/your_Platonic_figure_at_UMN-large_many.png");
        if (popUpImages) { showImages(img, out); }

        RGBImage output = RGBImageUtil.load("outputImages/your_Platonic_figure_at_UMN-large_many.png");
        expected = RGBImageUtil.load("expectedImages/Platonic_figure_at_UMN-large_many.png");
        if (imagesMatch(expected, output)) {
            System.out.println("Images match!");
        };
    }

    private static void showImages(RGBImage img, RGBImage out) {
        RGBImageUtil.showImage(img);
        RGBImageUtil.showImage(out);
    }

    private static boolean imagesMatch(RGBImage expected, RGBImage output) {
        if (expected.getWidth() != output.getWidth() || expected.getHeight() != output.getHeight()) {
            System.out.println("Solution image and your transformed image's width and height are not match.");
            return false;
        }

        for (int x=0; x < expected.getWidth(); x++) {
            for (int y=0; y < expected.getHeight(); y++) {
                RGBColor expectedColor = expected.getColor(x, y);
                RGBColor outputColor = output.getColor(x, y);
                if (!expectedColor.equals(outputColor)) {
                    System.out.print("Location: pixel [" + x + ", " + y + "] does not match. Color expected: ");
                    System.out.println(expected.getColor(x, y) + " color found: " + output.getColor(x, y));
                    return false;
                }
            }
        }

        return true;

    }
}
