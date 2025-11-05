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



public class AddBorder extends Transformation {

  /* Constructor for AddBorder
   *
   * just takes in how thick the border should be (in pixels)
   * and what color it should be.
   *
   * those are the only two things we really need here
   * everything else happens automatically when transform() runs.
   */
  public AddBorder(int width, RGBColor color) {
    // The constructor only needs to set the uninitiated variables.
    borderWidth = width;
    borderColor = color;
  }

  /* Method that adds a border to the image
  *
  * goes through every single pixel and checks:
  *     -> is it close enough to the edge to count as part of the border?
  *         (that means within 'borderWidth' pixels from any side)
  *
  * if it is, we color it using the borderColor.
  * if its not, we just leave it as the original color.
  *
  * basically: color the edges, keep the middle.
  *
  * this runs automatically through transform() in Transformation.
  */
  // By overriding the doTransform function, the transform function will work automatically.
  @Override
  protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
    // Get the original images dimensions.
    int imageWidth = image.getWidth(), imageHeight = image.getHeight();

    if (x < borderWidth || x >= imageWidth - borderWidth)
      return borderColor;

    if (y < borderWidth || y >= imageHeight - borderWidth)
      return borderColor;

    return originalColor;
  }

  // These variables should never change, and should never be accesed externally.
  final private int borderWidth;
  final private RGBColor borderColor;

}

