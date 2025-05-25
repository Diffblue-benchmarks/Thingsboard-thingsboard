package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

class AttributesDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link AttributesDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link AttributesDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType AttributesDeletionTaskProcessor.getTaskType()"})
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES,
        (new AttributesDeletionTaskProcessor(new BaseAttributesService(new JpaAttributeDao()))).getTaskType());
  }
}
