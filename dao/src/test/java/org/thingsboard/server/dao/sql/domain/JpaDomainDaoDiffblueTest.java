package org.thingsboard.server.dao.sql.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
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
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DomainEntity;
import org.thingsboard.server.dao.model.sql.DomainOauth2ClientCompositeKey;
import org.thingsboard.server.dao.model.sql.DomainOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDomainDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaDomainDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DomainOauth2ClientRepository domainOauth2ClientRepository;

  @MockBean
  private DomainRepository domainRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDomainDao jpaDomainDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDomainDao#getEntityClass()}
   *   <li>{@link JpaDomainDao#getEntityType()}
   *   <li>{@link JpaDomainDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaDomainDao jpaDomainDao = new JpaDomainDao(mock(DomainRepository.class),
        mock(DomainOauth2ClientRepository.class));

    // Act
    Class<DomainEntity> actualEntityClass = jpaDomainDao.getEntityClass();
    EntityType actualEntityType = jpaDomainDao.getEntityType();
    jpaDomainDao.getRepository();

    // Assert
    assertEquals(EntityType.DOMAIN, actualEntityType);
    Class<DomainEntity> expectedEntityClass = DomainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link DomainEntity#DomainEntity()} CreatedTime is zero.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenDomainEntityCreatedTimeIsZero_thenReturnDataSizeIsTwo() {
    // Arrange
    DomainEntity domainEntity = mock(DomainEntity.class);
    Domain domain = new Domain();
    when(domainEntity.toData()).thenReturn(domain);
    doNothing().when(domainEntity).setCreatedTime(anyLong());
    doNothing().when(domainEntity).setId(Mockito.<UUID>any());
    doNothing().when(domainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(domainEntity).setName(Mockito.<String>any());
    doNothing().when(domainEntity).setOauth2Enabled(Mockito.<Boolean>any());
    doNothing().when(domainEntity).setPropagateToEdge(Mockito.<Boolean>any());
    doNothing().when(domainEntity).setTenantId(Mockito.<UUID>any());
    domainEntity.setCreatedTime(-1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("42");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(0L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("org.thingsboard.server.dao.model.sql.DomainEntity");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    UUID tenantId = UUID.randomUUID();
    domainEntity2.setTenantId(tenantId);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<DomainEntity> content = new ArrayList<>();
    content.add(domainEntity2);
    content.add(domainEntity);
    PageImpl<DomainEntity> pageImpl = new PageImpl<>(content);
    when(domainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(domainEntity).setCreatedTime(eq(-1L));
    verify(domainEntity).setId(isA(UUID.class));
    verify(domainEntity).setUuid(isA(UUID.class));
    verify(domainEntity).setName(eq("42"));
    verify(domainEntity).setOauth2Enabled(eq(true));
    verify(domainEntity).setPropagateToEdge(eq(true));
    verify(domainEntity).setTenantId(isA(UUID.class));
    verify(domainEntity).toData();
    verify(domainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Domain> data = actualFindByTenantIdResult.getData();
    assertEquals(2, data.size());
    Domain getResult = data.get(0);
    assertEquals("org.thingsboard.server.dao.model.sql.DomainEntity", getResult.getName());
    assertEquals(2L, actualFindByTenantIdResult.getTotalElements());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(domain, data.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(domainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(domainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Domain#Domain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsDomain() {
    // Arrange
    DomainEntity domainEntity = mock(DomainEntity.class);
    Domain domain = new Domain();
    when(domainEntity.toData()).thenReturn(domain);
    doNothing().when(domainEntity).setCreatedTime(anyLong());
    doNothing().when(domainEntity).setId(Mockito.<UUID>any());
    doNothing().when(domainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(domainEntity).setName(Mockito.<String>any());
    doNothing().when(domainEntity).setOauth2Enabled(Mockito.<Boolean>any());
    doNothing().when(domainEntity).setPropagateToEdge(Mockito.<Boolean>any());
    doNothing().when(domainEntity).setTenantId(Mockito.<UUID>any());
    domainEntity.setCreatedTime(-1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("42");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<DomainEntity> content = new ArrayList<>();
    content.add(domainEntity);
    PageImpl<DomainEntity> pageImpl = new PageImpl<>(content);
    when(domainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(domainEntity).setCreatedTime(eq(-1L));
    verify(domainEntity).setId(isA(UUID.class));
    verify(domainEntity).setUuid(isA(UUID.class));
    verify(domainEntity).setName(eq("42"));
    verify(domainEntity).setOauth2Enabled(eq(true));
    verify(domainEntity).setPropagateToEdge(eq(true));
    verify(domainEntity).setTenantId(isA(UUID.class));
    verify(domainEntity).toData();
    verify(domainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Domain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(domain, data.get(0));
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(domainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}
   */
  @Test
  public void testCountDomainByTenantIdAndOauth2Enabled_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(domainRepository.countByTenantIdAndOauth2Enabled(Mockito.<UUID>any(), anyBoolean())).thenReturn(1);

    // Act
    int actualCountDomainByTenantIdAndOauth2EnabledResult = jpaDomainDao
        .countDomainByTenantIdAndOauth2Enabled(ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(domainRepository).countByTenantIdAndOauth2Enabled(isA(UUID.class), eq(true));
    assertEquals(1, actualCountDomainByTenantIdAndOauth2EnabledResult);
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  public void testFindOauth2ClientsByDomainId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult = jpaDomainDao
        .findOauth2ClientsByDomainId(ModelConstants.SYSTEM_TENANT, domainId);

    // Assert
    verify(domainId).getId();
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  public void testFindOauth2ClientsByDomainId_thenReturnSizeIsOne() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    ArrayList<DomainOauth2ClientEntity> domainOauth2ClientEntityList = new ArrayList<>();
    domainOauth2ClientEntityList.add(domainOauth2ClientEntity);
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any())).thenReturn(domainOauth2ClientEntityList);
    DomainId domainId = new DomainId(ModelConstants.NULL_UUID);

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult = jpaDomainDao
        .findOauth2ClientsByDomainId(ModelConstants.SYSTEM_TENANT, domainId);

    // Assert
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertEquals(1, actualFindOauth2ClientsByDomainIdResult.size());
    DomainOauth2Client getResult = actualFindOauth2ClientsByDomainIdResult.get(0);
    OAuth2ClientId oAuth2ClientId = getResult.getOAuth2ClientId();
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertTrue(oAuth2ClientId.isNullUid());
    assertEquals(domainId, getResult.getDomainId());
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   * <ul>
   *   <li>When {@link DomainId#DomainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  public void testFindOauth2ClientsByDomainId_whenDomainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult = jpaDomainDao
        .findOauth2ClientsByDomainId(ModelConstants.SYSTEM_TENANT, new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link DomainId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenDomainIdGetIdReturnNull_uuid() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);
    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(domainOauth2Client.getDomainId()).thenReturn(domainId);

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
    verify(domainId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(domainOauth2Client.getDomainId()).thenReturn(new DomainId(ModelConstants.NULL_UUID));

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(domainOauth2Client.getDomainId()).thenReturn(new DomainId(ModelConstants.NULL_UUID));

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link DomainId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenDomainIdGetIdReturnNull_uuid() {
    // Arrange
    doNothing().when(domainOauth2ClientRepository).deleteById(Mockito.<DomainOauth2ClientCompositeKey>any());
    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(domainOauth2Client.getDomainId()).thenReturn(domainId);

    // Act
    jpaDomainDao.removeOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).deleteById(isA(DomainOauth2ClientCompositeKey.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
    verify(domainId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(domainOauth2ClientRepository).deleteById(Mockito.<DomainOauth2ClientCompositeKey>any());
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(domainOauth2Client.getDomainId()).thenReturn(new DomainId(ModelConstants.NULL_UUID));

    // Act
    jpaDomainDao.removeOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).deleteById(isA(DomainOauth2ClientCompositeKey.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(domainOauth2ClientRepository).deleteById(Mockito.<DomainOauth2ClientCompositeKey>any());
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(domainOauth2Client.getDomainId()).thenReturn(new DomainId(ModelConstants.NULL_UUID));

    // Act
    jpaDomainDao.removeOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).deleteById(isA(DomainOauth2ClientCompositeKey.class));
    verify(domainOauth2Client).getDomainId();
    verify(domainOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaDomainDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link DomainRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(domainRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaDomainDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(domainRepository).deleteByTenantId(isA(UUID.class));
  }
}
