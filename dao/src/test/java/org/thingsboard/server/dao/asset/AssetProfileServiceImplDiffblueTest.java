/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileServiceImplDiffblueTest {
  /**
   * Test {@link AssetProfileServiceImpl#handleEvictEvent(AssetProfileEvictEvent)} with {@code
   * AssetProfileEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#handleEvictEvent(AssetProfileEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.handleEvictEvent(AssetProfileEvictEvent)"})
  public void testHandleEvictEventWithAssetProfileEvictEvent_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfile savedAssetProfile = mock(AssetProfile.class);
    when(savedAssetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));

    AssetProfileEvictEvent event =
        new AssetProfileEvictEvent(
            ModelConstants.SYSTEM_TENANT, "New Name", "not empty", null, false);
    event.setSavedAssetProfile(savedAssetProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> assetProfileServiceImpl.handleEvictEvent(event));
    verify(savedAssetProfile).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileById(TenantId, AssetProfileId)} with {@code
   * tenantId}, {@code assetProfileId}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileById(TenantId,
   * AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.findAssetProfileById(TenantId, AssetProfileId)"
  })
  public void testFindAssetProfileByIdWithTenantIdAssetProfileId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileById(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileById(TenantId, AssetProfileId, boolean)}
   * with {@code tenantId}, {@code assetProfileId}, {@code putInCache}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileById(TenantId,
   * AssetProfileId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.findAssetProfileById(TenantId, AssetProfileId, boolean)"
  })
  public void testFindAssetProfileByIdWithTenantIdAssetProfileIdPutInCache() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileById(
                ModelConstants.SYSTEM_TENANT, assetProfileId, true));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfoById(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfoById(TenantId,
   * AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileInfo AssetProfileServiceImpl.findAssetProfileInfoById(TenantId, AssetProfileId)"
  })
  public void testFindAssetProfileInfoById_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfoById(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean, boolean)} with
   * {@code assetProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile, boolean, boolean)"
  })
  public void testSaveAssetProfileWithAssetProfileDoValidatePublishSaveEvent() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.saveAssetProfile(
                new AssetProfile(assetProfileId), false, false));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  public void testDeleteAssetProfile_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"
  })
  public void testFindAssetProfiles() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"
  })
  public void testFindAssetProfiles2() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"
  })
  public void testFindAssetProfiles_thenCallsGetId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"
  })
  public void testFindAssetProfiles_thenCallsGetSortOrder() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"
  })
  public void testFindAssetProfileInfos() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"
  })
  public void testFindAssetProfileInfos2() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"
  })
  public void testFindAssetProfileInfos_thenCallsGetId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfileInfos(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"
  })
  public void testFindAssetProfileInfos_thenCallsGetSortOrder() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.createDefaultAssetProfile(TenantId)"})
  public void testCreateDefaultAssetProfile_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.createDefaultAssetProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findDefaultAssetProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.findDefaultAssetProfile(TenantId)"})
  public void testFindDefaultAssetProfile_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findDefaultAssetProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findDefaultAssetProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findDefaultAssetProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileInfo AssetProfileServiceImpl.findDefaultAssetProfileInfo(TenantId)"
  })
  public void testFindDefaultAssetProfileInfo_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findDefaultAssetProfileInfo(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  public void testSetDefaultAssetProfile_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.setDefaultAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  public void testDeleteAssetProfilesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfilesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> assetProfileServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AssetProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE, new AssetProfileServiceImpl().getEntityType());
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List AssetProfileServiceImpl.findAssetProfileNamesByTenantId(TenantId, boolean)"
  })
  public void testFindAssetProfileNamesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfileNamesByTenantId(tenantId, true));
    verify(tenantId).getId();
  }
}
