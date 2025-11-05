
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



public class Brighten extends Transformation
{

    protected int amount;

    /* Constructor for Brighten
    *
    * takes in an 'amount': basically how much to brighten (or darken) the image.
    * positive amount --> makes everything lighter
    * negative amount --> makes everything darker
    *
    * all it does here is store that value so we can use it later.
    */
    public Brighten(int amount)
    {
        this.amount = amount;

    }

    /* transform() is inherited from Transformation
    *
    * this just runs the doTransform() function on every pixel automatically.
    * nothing fancy needs to happen here: we just call super.
    */
    public RGBImage transform(RGBImage image)
    {
        return super.transform(image);
    }

    /* method that actually changes how bright each pixel is
   *
   * goes through each color channel (red, green, blue):
   *     adds the 'amount' to it, thats how we brighten or darken.
   *
   * makes sure the final values stay between 0 and 255 (since RGB can’t go beyond that)
   *     --> if its higher than 255, cap it at 255
   *     --> if its lower than 0, bump it up to 0
   *
   * returns the new adjusted color.
   */
  @Override
    protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image)
    {
        int[] arr = {originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue()};
        int[] finalArr = new int[3];

        for(int i = 0; i < arr.length; i++)
        {
            if((arr[i] + amount) > 255)
            {
                finalArr[i] = 255;
            }
            else if((arr[i] + amount) < 0)
            {
                finalArr[i] = 0;
            }
            else
            {
                finalArr[i] = arr[i] + amount;

            }
        }
        return new RGBColor(finalArr[0], finalArr[1], finalArr[2]);

    }

}
