
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


public class ColorPallet extends Transformation
{
   protected  RGBColor[] pallet;


    /* constructor for ColorPallet
   *
   * takes in an array of colors (the “pallet”) that we’ll use to
   * recolor the image.
   *
   * for every pixel, we’ll look for the color in this
   * pallet that’s closest to it and swap it out.
   */
    public ColorPallet(RGBColor[] pallet)
    {
        this.pallet = pallet;
    }

    /* transform() just calls the parent version.
    * it runs doTransform() automatically for every pixel.
    */
    @Override
    public RGBImage transform(RGBImage image)
    {
        return super.transform(image);
    }


  /* method that replaces each pixels color with its closest match
   * from the given pallet.
   *
   * for each pixel:
   *     - start with the first color in the pallet as “closest”
   *     - go through all colors in the pallet
   *     - calculate the distance between the current pixel color
   *       and that color
   *     - keep whichever color is the closest so far
   *
   * returns that closest color for the pixel.
   */
  @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image)
    {
        RGBColor closestColor = pallet[0];
        double minDistance = RGBColor.distance(originalColor, pallet[0]);

       for(int i = 0; i < pallet.length; i++)
       {
        double currentDistance = RGBColor.distance(originalColor, pallet[i]);

        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closestColor = pallet[i];
        }

       }

       return closestColor;

    }

}
