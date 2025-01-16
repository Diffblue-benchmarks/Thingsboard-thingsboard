package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.asset.AssetSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.service.asset.AssetBulkImportService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

class AssetControllerDiffblueTest {
  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery); then throw IncorrectParameterException")
  void testFindByQuery_thenThrowIncorrectParameterException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());

    AssetController assetController = new AssetController(assetBulkImportService,
        new DefaultTbAssetService(new BaseAssetService()));
    AssetSearchQuery query = mock(AssetSearchQuery.class);
    when(query.getParameters()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> assetController.findByQuery(query));
    verify(query).getParameters();
  }
}
