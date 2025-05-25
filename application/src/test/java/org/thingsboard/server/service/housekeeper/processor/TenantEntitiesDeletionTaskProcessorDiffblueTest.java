package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;

class TenantEntitiesDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link TenantEntitiesDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link TenantEntitiesDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType TenantEntitiesDeletionTaskProcessor.getTaskType()"})
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_TENANT_ENTITIES,
        (new TenantEntitiesDeletionTaskProcessor(null)).getTaskType());
  }
}
