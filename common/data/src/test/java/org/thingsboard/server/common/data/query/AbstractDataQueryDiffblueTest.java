package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractDataQueryDiffblueTest {
  /**
   * Test {@link AbstractDataQuery#getEntityFields()}.
   * <p>
   * Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  @DisplayName("Test getEntityFields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AbstractDataQuery.getEntityFields()"})
  void testGetEntityFields() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getEntityFields());
  }

  /**
   * Test {@link AbstractDataQuery#getLatestValues()}.
   * <p>
   * Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AbstractDataQuery.getLatestValues()"})
  void testGetLatestValues() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getLatestValues());
  }

  /**
   * Test {@link AbstractDataQuery#getPageLink()}.
   * <p>
   * Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  @DisplayName("Test getPageLink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.query.EntityDataPageLink AbstractDataQuery.getPageLink()"})
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getPageLink());
  }

  /**
   * Test {@link AbstractDataQuery#toString()}.
   * <p>
   * Method under test: {@link AbstractDataQuery#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractDataQuery.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
        + " pageLink=null, entityFields=null, latestValues=null))", (new EntityDataQuery()).toString());
  }
}
