package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;

@ExtendWith(MockitoExtension.class)
class DeviceExportServiceDiffblueTest {
  @InjectMocks
  private DeviceExportService deviceExportService;

  /**
   * Test {@link DeviceExportService#newExportData()}.
   * <p>
   * Method under test: {@link DeviceExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceExportData DeviceExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    DeviceExportData actualNewExportDataResult = deviceExportService.newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getCredentials());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link DeviceExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link DeviceExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DeviceExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = deviceExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.DEVICE));
  }
}
