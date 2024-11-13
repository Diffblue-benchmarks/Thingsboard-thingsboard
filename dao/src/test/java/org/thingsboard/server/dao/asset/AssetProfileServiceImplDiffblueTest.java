package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileServiceImplDiffblueTest {
  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfiles_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findAssetProfiles tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfiles_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfileInfos_thenThrowConstraintViolationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findAssetProfileInfos tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfileInfos_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link AssetProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE, (new AssetProfileServiceImpl()).getEntityType());
  }
}
