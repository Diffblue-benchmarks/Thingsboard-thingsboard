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
import org.thingsboard.server.common.data.sync.ie.RuleChainExportData;

@ExtendWith(MockitoExtension.class)
class RuleChainExportServiceDiffblueTest {
  @InjectMocks
  private RuleChainExportService ruleChainExportService;

  /**
   * Test {@link RuleChainExportService#newExportData()}.
   * <p>
   * Method under test: {@link RuleChainExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainExportData RuleChainExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    RuleChainExportData actualNewExportDataResult = ruleChainExportService.newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getMetaData());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link RuleChainExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link RuleChainExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set RuleChainExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = ruleChainExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.RULE_CHAIN));
  }
}
