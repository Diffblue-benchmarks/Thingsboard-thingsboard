package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;

@ExtendWith(MockitoExtension.class)
class ResourceExportServiceDiffblueTest {
  @InjectMocks
  private ResourceExportService resourceExportService;

  /**
   * Test {@link ResourceExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link ResourceExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ResourceExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = resourceExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.TB_RESOURCE));
  }
}
