
/* Computer Lab 09: Image change
 *
 * Authors: Nikki Som, Shawn Grove, Leonard Jin
 *
 * Files in project:
 *     Transformation.java
 *     RGBImageUtil.java
 *     RGBImage.java
 *     RGBColor.java
 *     Tester.java
 *
 *     Greyscale.java
 *     Stamp.java
 *     AddBorder.java
 *     ColorPallet.java
 *     Brighten.java
 *     TransformationUtils.java
 */

public class Stamp extends Transformation
{
    public RGBImage toStamp ;

    public Stamp(RGBImage toStamp)
    {
        this.toStamp = toStamp;

    }

    public RGBImage transform(RGBImage image)
    {
        return super.transform(image);

    }

    /* method that blends the stamp image with the original image
    *
    * for every pixel:
    *     - check if it’s inside the stamp’s bounds
    *     - if it is, grab the color from the stamp image at that same (x, y)
    *     - average each RGB channel between the two images
    *         (so it’s kind of halfway transparent)
    *     - if it’s outside the stamp area, keep the original color
    *
    * also has a small null check just in case getColor() doesn’t return anything
    * (prevents crashes and makes sure the pixel stays unchanged).
    */
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image)
    {

        int[] ogArr = {originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue()};

        RGBColor stampColor = toStamp.getColor(x, y);

        if (stampColor == null) {
            return originalColor;
        }

        int[] stampArr= {stampColor.getRed(), stampColor.getGreen(), stampColor.getBlue()};
        int[] finalArr = new int[3];

        if (x >= 0 && x < toStamp.getWidth() && y >= 0 && y < toStamp.getHeight())
        {
            // pixel is inside the stamp area, blend colors
            for (int i = 0; i < 3; i++)
            {
                finalArr[i] = (ogArr[i] + stampArr[i]) / 2;

            }
            return new RGBColor(finalArr[0], finalArr[1], finalArr[2]);
        } else
        {
            // outside the stamp, keep original pixel
            return originalColor;
        }





    }





}
