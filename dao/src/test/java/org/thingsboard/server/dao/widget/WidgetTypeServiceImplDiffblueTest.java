package org.thingsboard.server.dao.widget;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class WidgetTypeServiceImplDiffblueTest {
  /**
   * Test {@link WidgetTypeServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetTypeServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType WidgetTypeServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGET_TYPE, (new WidgetTypeServiceImpl()).getEntityType());
  }
}
