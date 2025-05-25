package org.thingsboard.server.service.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;

@ExtendWith(MockitoExtension.class)
class DefaultEntitiesExportImportServiceDiffblueTest {
  @InjectMocks
  private DefaultEntitiesExportImportService defaultEntitiesExportImportService;

  /**
   * Test {@link DefaultEntitiesExportImportService#getEntityTypeComparatorForImport()}.
   * <p>
   * Method under test: {@link DefaultEntitiesExportImportService#getEntityTypeComparatorForImport()}
   */
  @Test
  @DisplayName("Test getEntityTypeComparatorForImport()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Comparator DefaultEntitiesExportImportService.getEntityTypeComparatorForImport()"})
  void testGetEntityTypeComparatorForImport() {
    // Arrange, Act and Assert
    assertEquals(0, defaultEntitiesExportImportService.getEntityTypeComparatorForImport()
        .compare(EntityType.TENANT, EntityType.TENANT));
  }
}
