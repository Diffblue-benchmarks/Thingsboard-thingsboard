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
package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.MobileAppEntity;
import org.thingsboard.server.dao.model.sql.MobileAppOauth2ClientCompositeKey;
import org.thingsboard.server.dao.model.sql.MobileAppOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaMobileAppDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaMobileAppDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaMobileAppDao jpaMobileAppDao;

  @MockBean private MobileAppOauth2ClientRepository mobileAppOauth2ClientRepository;

  @MockBean private MobileAppRepository mobileAppRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaMobileAppDao#getEntityClass()}
   *   <li>{@link JpaMobileAppDao#getEntityType()}
   *   <li>{@link JpaMobileAppDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaMobileAppDao.getEntityClass()",
    "EntityType JpaMobileAppDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaMobileAppDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppDao jpaMobileAppDao =
        new JpaMobileAppDao(
            mock(MobileAppRepository.class), mock(MobileAppOauth2ClientRepository.class));

    // Act
    Class<MobileAppEntity> actualEntityClass = jpaMobileAppDao.getEntityClass();
    EntityType actualEntityType = jpaMobileAppDao.getEntityType();
    jpaMobileAppDao.getRepository();

    // Assert
    assertEquals(EntityType.MOBILE_APP, actualEntityType);
    Class<MobileAppEntity> expectedEntityClass = MobileAppEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaMobileAppDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    UUID tenantId = UUID.randomUUID();
    mobileAppEntity.setTenantId(tenantId);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<MobileAppEntity> content = new ArrayList<>();
    content.add(mobileAppEntity);
    when(mobileAppRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<MobileApp> actualFindByTenantIdResult =
        jpaMobileAppDao.findByTenantId(tenantId2, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(mobileAppRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<MobileApp> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    MobileApp getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("App Secret", getResult.getAppSecret());
    assertEquals("Pkg Name", getResult.getName());
    assertEquals("Pkg Name", getResult.getPkgName());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    MobileAppId id = getResult.getId();
    assertEquals(EntityType.MOBILE_APP, id.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId3.getEntityType());
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(id.isNullUid());
    assertTrue(getResult.isOauth2Enabled());
    assertSame(uuidId, id.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaMobileAppDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenNull_uuid_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(mobileAppRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<MobileApp> actualFindByTenantIdResult =
        jpaMobileAppDao.findByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaMobileAppDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(mobileAppRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<MobileApp> actualFindByTenantIdResult =
        jpaMobileAppDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(mobileAppRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaMobileAppDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<MobileAppEntity> content = new ArrayList<>();
    content.add(mobileAppEntity);
    when(mobileAppRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<MobileApp> actualFindByTenantIdResult =
        jpaMobileAppDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(mobileAppRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<MobileApp> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaMobileAppDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(mobileAppRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<MobileApp> actualFindByTenantIdResult =
        jpaMobileAppDao.findByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link MobileAppId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId,
   * MobileAppId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaMobileAppDao.findOauth2ClientsByMobileAppId(TenantId, MobileAppId)"})
  public void testFindOauth2ClientsByMobileAppId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult =
        jpaMobileAppDao.findOauth2ClientsByMobileAppId(ModelConstants.SYSTEM_TENANT, mobileAppId);

    // Assert
    verify(mobileAppId).getId();
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByMobileAppIdResult.isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId,
   * MobileAppId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaMobileAppDao.findOauth2ClientsByMobileAppId(TenantId, MobileAppId)"})
  public void testFindOauth2ClientsByMobileAppId_thenReturnEmpty() {
    // Arrange
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult =
        jpaMobileAppDao.findOauth2ClientsByMobileAppId(
            ModelConstants.SYSTEM_TENANT, new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByMobileAppIdResult.isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId,
   * MobileAppId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaMobileAppDao.findOauth2ClientsByMobileAppId(TenantId, MobileAppId)"})
  public void testFindOauth2ClientsByMobileAppId_thenReturnSizeIsOne() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    ArrayList<MobileAppOauth2ClientEntity> mobileAppOauth2ClientEntityList = new ArrayList<>();
    mobileAppOauth2ClientEntityList.add(mobileAppOauth2ClientEntity);
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(mobileAppOauth2ClientEntityList);
    MobileAppId mobileAppId = new MobileAppId(ModelConstants.NULL_UUID);

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult =
        jpaMobileAppDao.findOauth2ClientsByMobileAppId(ModelConstants.SYSTEM_TENANT, mobileAppId);

    // Assert
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertEquals(1, actualFindOauth2ClientsByMobileAppIdResult.size());
    MobileAppOauth2Client getResult = actualFindOauth2ClientsByMobileAppIdResult.get(0);
    OAuth2ClientId oAuth2ClientId = getResult.getOAuth2ClientId();
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertTrue(oAuth2ClientId.isNullUid());
    assertEquals(mobileAppId, getResult.getMobileAppId());
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link OAuth2ClientId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.addOauth2Client(MobileAppOauth2Client)"})
  public void testAddOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);

    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.addOauth2Client(MobileAppOauth2Client)"})
  public void testAddOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);

    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link OAuth2ClientId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.removeOauth2Client(MobileAppOauth2Client)"})
  public void testRemoveOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(mobileAppOauth2ClientRepository)
        .deleteById(Mockito.<MobileAppOauth2ClientCompositeKey>any());

    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.removeOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository)
        .deleteById(isA(MobileAppOauth2ClientCompositeKey.class));
    verify(mobileAppId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.removeOauth2Client(MobileAppOauth2Client)"})
  public void testRemoveOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    doNothing()
        .when(mobileAppOauth2ClientRepository)
        .deleteById(Mockito.<MobileAppOauth2ClientCompositeKey>any());

    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.removeOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository)
        .deleteById(isA(MobileAppOauth2ClientCompositeKey.class));
    verify(mobileAppId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(mobileAppRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaMobileAppDao.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(mobileAppRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaMobileAppDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link MobileAppRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaMobileAppDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaMobileAppDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaMobileAppDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppRepository).deleteByTenantId(isA(UUID.class));
  }
}
