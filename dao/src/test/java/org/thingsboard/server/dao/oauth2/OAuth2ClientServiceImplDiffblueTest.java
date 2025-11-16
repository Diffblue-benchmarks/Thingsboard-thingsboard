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
package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientLoginInfo;
import org.thingsboard.server.common.data.oauth2.PlatformType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {OAuth2ClientServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuth2ClientServiceImplDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<OAuth2Client> dataValidator;

  @MockBean private OAuth2ClientDao oAuth2ClientDao;

  @Autowired private OAuth2ClientServiceImpl oAuth2ClientServiceImpl;

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientLoginInfosByDomainName(String)"})
  public void testFindOAuth2ClientLoginInfosByDomainName_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findEnabledByDomainName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientLoginInfo> actualFindOAuth2ClientLoginInfosByDomainNameResult =
        oAuth2ClientServiceImpl.findOAuth2ClientLoginInfosByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientDao).findEnabledByDomainName("Domain Name");
    assertTrue(actualFindOAuth2ClientLoginInfosByDomainNameResult.isEmpty());
  }

  /**
   * Test {@link
   * OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String,
   * PlatformType)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String,
   * PlatformType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OAuth2ClientServiceImpl.findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String, PlatformType)"
  })
  public void testFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findEnabledByPkgNameAndPlatformType(
            Mockito.<String>any(), Mockito.<PlatformType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientLoginInfo>
        actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult =
            oAuth2ClientServiceImpl.findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(
                "Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientDao).findEnabledByPkgNameAndPlatformType("Pkg Name", PlatformType.WEB);
    assertTrue(actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#saveOAuth2Client(TenantId, OAuth2Client)}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2Client#OAuth2Client()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#saveOAuth2Client(TenantId, OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2Client OAuth2ClientServiceImpl.saveOAuth2Client(TenantId, OAuth2Client)"
  })
  public void testSaveOAuth2Client_thenReturnOAuth2Client() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<OAuth2Client>any(), Mockito.<Function<OAuth2Client, TenantId>>any()))
        .thenReturn(new OAuth2Client());
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.save(Mockito.<TenantId>any(), Mockito.<OAuth2Client>any()))
        .thenReturn(oAuth2Client);

    // Act
    OAuth2Client actualSaveOAuth2ClientResult =
        oAuth2ClientServiceImpl.saveOAuth2Client(ModelConstants.SYSTEM_TENANT, new OAuth2Client());

    // Assert
    verify(oAuth2ClientDao).save(isA(TenantId.class), isA(OAuth2Client.class));
    verify(dataValidator).validate(isA(OAuth2Client.class), isA(Function.class));
    assertSame(oAuth2Client, actualSaveOAuth2ClientResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2Client OAuth2ClientServiceImpl.findOAuth2ClientById(TenantId, OAuth2ClientId)"
  })
  public void testFindOAuth2ClientById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2Client);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OAuth2Client actualFindOAuth2ClientByIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientById(ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2Client, actualFindOAuth2ClientByIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2Client OAuth2ClientServiceImpl.findOAuth2ClientById(TenantId, OAuth2ClientId)"
  })
  public void testFindOAuth2ClientById_whenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2Client);

    // Act
    OAuth2Client actualFindOAuth2ClientByIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientById(
            ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2Client, actualFindOAuth2ClientByIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(TenantId)"})
  public void testFindOAuth2ClientsByTenantId() {
    // Arrange
    PageData<OAuth2Client> emptyPageDataResult = PageData.emptyPageData();
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    List<OAuth2Client> actualFindOAuth2ClientsByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualFindOAuth2ClientsByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(TenantId)"})
  public void testFindOAuth2ClientsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<OAuth2Client> actualFindOAuth2ClientsByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(pageData).getData();
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualFindOAuth2ClientsByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(TenantId)"})
  public void testFindOAuth2ClientsByTenantId_thenCallsGetData() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    List<OAuth2Client> actualFindOAuth2ClientsByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualFindOAuth2ClientsByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OAuth2ClientServiceImpl.findAppSecret(OAuth2ClientId, String)"})
  public void testFindAppSecret_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn("App Secret");

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    String actualFindAppSecretResult =
        oAuth2ClientServiceImpl.findAppSecret(oAuth2ClientId, "Pkg Name");

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   *
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@code App Secret}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OAuth2ClientServiceImpl.findAppSecret(OAuth2ClientId, String)"})
  public void testFindAppSecret_whenOAuth2ClientIdWithIdIsNull_uuid_thenReturnAppSecret() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult =
        oAuth2ClientServiceImpl.findAppSecret(
            new OAuth2ClientId(ModelConstants.NULL_UUID), "Pkg Name");

    // Assert
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>Then calls {@link OAuth2ClientDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientServiceImpl.deleteOAuth2ClientById(TenantId, OAuth2ClientId)"
  })
  public void testDeleteOAuth2ClientById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(oAuth2ClientDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOAuth2ClientById(
        ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(TenantId)"})
  public void testDeleteOauth2ClientsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    oAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(TenantId)"})
  public void testDeleteOauth2ClientsByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData OAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindOAuth2ClientInfosByTenantId() {
    // Arrange
    PageData<OAuth2Client> emptyPageDataResult = PageData.emptyPageData();
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData OAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindOAuth2ClientInfosByTenantId2() {
    // Arrange
    PageData<OAuth2Client> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertEquals(pageData, actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData OAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindOAuth2ClientInfosByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<OAuth2Client, Object>>any()))
        .thenReturn(emptyPageDataResult);
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(
            tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(pageData).mapData(isA(Function.class));
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData OAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(TenantId, PageLink)"
  })
  public void testFindOAuth2ClientInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<OAuth2Client, Object>>any()))
        .thenReturn(emptyPageDataResult);
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientInfosByIds(TenantId, List)"})
  public void testFindOAuth2ClientInfosByIds_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientDao.findByIds(Mockito.<UUID>any(), Mockito.<List<OAuth2ClientId>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<OAuth2ClientInfo> actualFindOAuth2ClientInfosByIdsResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(oAuth2ClientDao).findByIds(isA(UUID.class), isA(List.class));
    assertTrue(actualFindOAuth2ClientInfosByIdsResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ClientServiceImpl.findOAuth2ClientInfosByIds(TenantId, List)"})
  public void testFindOAuth2ClientInfosByIds_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findByIds(Mockito.<UUID>any(), Mockito.<List<OAuth2ClientId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientInfo> actualFindOAuth2ClientInfosByIdsResult =
        oAuth2ClientServiceImpl.findOAuth2ClientInfosByIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(oAuth2ClientDao).findByIds(isA(UUID.class), isA(List.class));
    assertTrue(actualFindOAuth2ClientInfosByIdsResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)"
  })
  public void testIsPropagateOAuth2ClientToEdge_thenReturnFalse() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult =
        oAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(
            ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)"
  })
  public void testIsPropagateOAuth2ClientToEdge_thenReturnTrue() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult =
        oAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(
            ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   *
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId,
   * OAuth2ClientId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)"
  })
  public void testIsPropagateOAuth2ClientToEdge_whenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult =
        oAuth2ClientServiceImpl.isPropagateOAuth2ClientToEdge(
            ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    oAuth2ClientServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional OAuth2ClientServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2Client);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        oAuth2ClientServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof OAuth2Client);
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(oAuth2Client, getResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link OAuth2ClientServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType OAuth2ClientServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.OAUTH2_CLIENT, new OAuth2ClientServiceImpl().getEntityType());
  }
}
