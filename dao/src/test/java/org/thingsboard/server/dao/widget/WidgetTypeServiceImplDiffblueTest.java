package org.thingsboard.server.dao.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.DeprecatedFilter;
import org.thingsboard.server.common.data.widget.WidgetType;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.common.data.widget.WidgetsBundleWidget;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {WidgetTypeServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class WidgetTypeServiceImplDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private DataValidator<WidgetTypeDetails> dataValidator;

  @MockBean
  private ImageService imageService;

  @MockBean
  private WidgetTypeDao widgetTypeDao;

  @Autowired
  private WidgetTypeServiceImpl widgetTypeServiceImpl;

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}.
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link WidgetType#WidgetType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}
   */
  @Test
  public void testFindWidgetTypeById_whenWidgetTypeIdWithIdIsNull_uuid_thenReturnWidgetType() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetType);

    // Act
    WidgetType actualFindWidgetTypeByIdResult = widgetTypeServiceImpl.findWidgetTypeById(ModelConstants.SYSTEM_TENANT,
        new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetType, actualFindWidgetTypeByIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId, WidgetTypeId)}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId, WidgetTypeId)}
   */
  @Test
  public void testFindWidgetTypeDetailsById_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetTypeDetails);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByIdResult = widgetTypeServiceImpl
        .findWidgetTypeDetailsById(ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}
   */
  @Test
  public void testWidgetTypeExistsByTenantIdAndWidgetTypeId_thenReturnFalse() {
    // Arrange
    when(widgetTypeDao.existsByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult = widgetTypeServiceImpl
        .widgetTypeExistsByTenantIdAndWidgetTypeId(ModelConstants.SYSTEM_TENANT,
            new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).existsByTenantIdAndId(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}
   */
  @Test
  public void testWidgetTypeExistsByTenantIdAndWidgetTypeId_thenReturnTrue() {
    // Arrange
    when(widgetTypeDao.existsByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult = widgetTypeServiceImpl
        .widgetTypeExistsByTenantIdAndWidgetTypeId(ModelConstants.SYSTEM_TENANT,
            new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).existsByTenantIdAndId(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Tags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  public void testSaveWidgetType_givenWidgetTypeIdWithIdIsNull_uuid_thenReturnTagsIsNull() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<WidgetTypeDetails>any())).thenReturn(true);
    when(widgetTypeDao.save(Mockito.<TenantId>any(), Mockito.<WidgetTypeDetails>any()))
        .thenReturn(new WidgetTypeDetails());
    when(dataValidator.validate(Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenReturn(new WidgetTypeDetails());

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setId(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    WidgetTypeDetails actualSaveWidgetTypeResult = widgetTypeServiceImpl.saveWidgetType(widgetTypeDetails);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(WidgetTypeDetails.class));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
    verify(widgetTypeDao).save(isNull(), isA(WidgetTypeDetails.class));
    assertNull(actualSaveWidgetTypeResult.getTags());
    assertNull(actualSaveWidgetTypeResult.getDescriptor());
    assertNull(actualSaveWidgetTypeResult.getVersion());
    assertNull(actualSaveWidgetTypeResult.getFqn());
    assertNull(actualSaveWidgetTypeResult.getName());
    assertNull(actualSaveWidgetTypeResult.getDescription());
    assertNull(actualSaveWidgetTypeResult.getImage());
    assertNull(actualSaveWidgetTypeResult.getUuidId());
    assertNull(actualSaveWidgetTypeResult.getTenantId());
    assertNull(actualSaveWidgetTypeResult.getId());
    assertNull(actualSaveWidgetTypeResult.getExternalId());
    assertEquals(0L, actualSaveWidgetTypeResult.getCreatedTime());
    assertFalse(actualSaveWidgetTypeResult.isDeprecated());
    assertFalse(actualSaveWidgetTypeResult.isScada());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  public void testSaveWidgetType_whenWidgetTypeDetails_thenReturnWidgetTypeDetails() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<WidgetTypeDetails>any())).thenReturn(true);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.save(Mockito.<TenantId>any(), Mockito.<WidgetTypeDetails>any())).thenReturn(widgetTypeDetails);
    when(dataValidator.validate(Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenReturn(new WidgetTypeDetails());

    // Act
    WidgetTypeDetails actualSaveWidgetTypeResult = widgetTypeServiceImpl.saveWidgetType(new WidgetTypeDetails());

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(WidgetTypeDetails.class));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
    verify(widgetTypeDao).save(isNull(), isA(WidgetTypeDetails.class));
    assertSame(widgetTypeDetails, actualSaveWidgetTypeResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}.
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}
   */
  @Test
  public void testDeleteWidgetType_whenWidgetTypeIdWithIdIsNull_uuid_thenCallsRemoveById() {
    // Arrange
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    widgetTypeServiceImpl.deleteWidgetType(ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypesByPageLink() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult = widgetTypeServiceImpl
        .findSystemWidgetTypesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetTypesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypesByPageLink_thenCallsGetPage() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult = widgetTypeServiceImpl
        .findSystemWidgetTypesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetTypesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypesByPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult = widgetTypeServiceImpl
        .findSystemWidgetTypesByPageLink(null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetTypesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findAllTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_thenCallsGetPage() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findAllTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findAllTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_thenCallsGetPage() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult = widgetTypeServiceImpl
        .findTenantWidgetTypesByTenantIdAndPageLink(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetTypesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testFindWidgetTypesByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypesByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testFindWidgetTypesDetailsByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesDetailsByWidgetsBundleId(ModelConstants.SYSTEM_TENANT,
            new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, widgetsBundleId, true,
            DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(true),
        eq(DeprecatedFilter.ALL), isA(List.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesInfosByWidgetsBundleIdResult.EMPTY_PAGE_DATA,
        actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Given a string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenAString_whenArrayListAddAString() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes
        .add("Executing findWidgetTypesInfosByWidgetsBundleId, tenantId [{}], widgetsBundleId [{}], fullSearch [{}],"
            + " deprecatedFilter [{}], widgetTypes [{}], pageLink [{}]");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, widgetsBundleId, true,
            DeprecatedFilter.ALL, widgetTypes, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(true),
        eq(DeprecatedFilter.ALL), isA(List.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesInfosByWidgetsBundleIdResult.EMPTY_PAGE_DATA,
        actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    widgetTypes
        .add("Executing findWidgetTypesInfosByWidgetsBundleId, tenantId [{}], widgetsBundleId [{}], fullSearch [{}],"
            + " deprecatedFilter [{}], widgetTypes [{}], pageLink [{}]");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, widgetsBundleId, true,
            DeprecatedFilter.ALL, widgetTypes, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(true),
        eq(DeprecatedFilter.ALL), isA(List.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesInfosByWidgetsBundleIdResult.EMPTY_PAGE_DATA,
        actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenCallsGetPage() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, widgetsBundleId, true,
            DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(true),
        eq(DeprecatedFilter.ALL), isA(List.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesInfosByWidgetsBundleIdResult.EMPTY_PAGE_DATA,
        actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, widgetsBundleId, true,
            DeprecatedFilter.ALL, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(true),
        eq(DeprecatedFilter.ALL), isA(List.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesInfosByWidgetsBundleIdResult.EMPTY_PAGE_DATA,
        actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testFindWidgetFqnsByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult = widgetTypeServiceImpl
        .findWidgetFqnsByWidgetsBundleId(ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetFqnsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link WidgetType#WidgetType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId, String)}
   */
  @Test
  public void testFindWidgetTypeByTenantIdAndFqn_whenSystem_tenant_thenReturnWidgetType() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(widgetType);

    // Act
    WidgetType actualFindWidgetTypeByTenantIdAndFqnResult = widgetTypeServiceImpl
        .findWidgetTypeByTenantIdAndFqn(ModelConstants.SYSTEM_TENANT, "Fqn");

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetType, actualFindWidgetTypeByTenantIdAndFqnResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}
   */
  @Test
  public void testFindWidgetTypeDetailsByTenantIdAndFqn_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findDetailsByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetails);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByTenantIdAndFqnResult = widgetTypeServiceImpl
        .findWidgetTypeDetailsByTenantIdAndFqn(ModelConstants.SYSTEM_TENANT, "Fqn");

    // Assert
    verify(widgetTypeDao).findDetailsByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByTenantIdAndFqnResult);
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsNull() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetList.add(new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(null), 1));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(null));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetList
        .add(new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsRemoveWidgetTypeFromWidgetsBundle() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetList.add(new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(UUID.randomUUID()), 1));
    doNothing().when(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsRemoveWidgetTypeFromWidgetsBundle2() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetList.add(new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(UUID.randomUUID()), 1));
    doNothing().when(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(null));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsSaveWidgetsBundleWidget() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsSaveWidgetsBundleWidget2() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetTypes_whenArrayList() {
    // Arrange
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(ModelConstants.SYSTEM_TENANT, widgetsBundleId,
        new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("Executing updateWidgetsBundleWidgetFqns, tenantId [{}], widgetsBundleId [{}], widgetFqns [{}]");

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetFqns);

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("Executing updateWidgetsBundleWidgetTypes, tenantId [{}], widgetsBundleId [{}], widgetTypeIds [{}]");
    widgetFqns.add("Executing updateWidgetsBundleWidgetFqns, tenantId [{}], widgetsBundleId [{}], widgetFqns [{}]");

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetFqns);

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns_givenWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetList
        .add(new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId2,
        new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsFindWidgetTypeIdsByTenantIdAndFqns() {
    // Arrange
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId,
        new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsSaveWidgetsBundleWidget() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId,
        new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}
   */
  @Test
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsSaveWidgetsBundleWidget2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(ModelConstants.SYSTEM_TENANT, widgetsBundleId,
        new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao).findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#deleteWidgetTypesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteWidgetTypesByTenantId_thenCallsFindTenantWidgetTypesByTenantId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetTypeDao).findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testDeleteWidgetTypesByBundleId_thenCallsFindWidgetTypesInfosByWidgetsBundleId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyBoolean(),
        Mockito.<DeprecatedFilter>any(), Mockito.<List<String>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(ModelConstants.SYSTEM_TENANT,
        new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), isA(UUID.class), eq(false),
        eq(DeprecatedFilter.ALL), isNull(), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindTenantWidgetTypesByTenantId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetTypeDao).findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link AlarmId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetType);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = widgetTypeServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetType, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetType);

    // Act
    Optional<HasId<?>> actualFindEntityResult = widgetTypeServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetType, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetTypeServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGET_TYPE, (new WidgetTypeServiceImpl()).getEntityType());
  }
}
