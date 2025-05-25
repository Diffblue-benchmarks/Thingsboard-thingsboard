package org.thingsboard.server.dao.widget;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class WidgetsBundleServiceImplDiffblueTest {
  /**
   * Test {@link WidgetsBundleServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetsBundleServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType WidgetsBundleServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGETS_BUNDLE, (new WidgetsBundleServiceImpl()).getEntityType());
  }
}
