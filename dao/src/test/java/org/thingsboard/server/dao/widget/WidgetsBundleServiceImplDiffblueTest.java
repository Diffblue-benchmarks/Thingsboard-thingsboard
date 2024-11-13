package org.thingsboard.server.dao.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;
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
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {WidgetsBundleServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class WidgetsBundleServiceImplDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private DataValidator<WidgetsBundle> dataValidator;

  @MockBean
  private ImageService imageService;

  @MockBean
  private ResourceService resourceService;

  @MockBean
  private WidgetTypeService widgetTypeService;

  @MockBean
  private WidgetsBundleDao widgetsBundleDao;

  @Autowired
  private WidgetsBundleServiceImpl widgetsBundleServiceImpl;

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testFindWidgetsBundleById_thenReturnWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetsBundle);

    // Act
    WidgetsBundle actualFindWidgetsBundleByIdResult = widgetsBundleServiceImpl
        .findWidgetsBundleById(ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetsBundle, actualFindWidgetsBundleByIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   * <ul>
   *   <li>Then return Order is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  public void testSaveWidgetsBundle_thenReturnOrderIsNull() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any())).thenReturn(true);
    when(widgetsBundleDao.save(Mockito.<TenantId>any(), Mockito.<WidgetsBundle>any())).thenReturn(new WidgetsBundle());
    when(dataValidator.validate(Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenReturn(new WidgetsBundle());

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setId(new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Act
    WidgetsBundle actualSaveWidgetsBundleResult = widgetsBundleServiceImpl.saveWidgetsBundle(widgetsBundle);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("bundle"));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
    verify(widgetsBundleDao).save(isNull(), isA(WidgetsBundle.class));
    assertNull(actualSaveWidgetsBundleResult.getOrder());
    assertNull(actualSaveWidgetsBundleResult.getVersion());
    assertNull(actualSaveWidgetsBundleResult.getAlias());
    assertNull(actualSaveWidgetsBundleResult.getDescription());
    assertNull(actualSaveWidgetsBundleResult.getImage());
    assertNull(actualSaveWidgetsBundleResult.getName());
    assertNull(actualSaveWidgetsBundleResult.getTitle());
    assertNull(actualSaveWidgetsBundleResult.getUuidId());
    assertNull(actualSaveWidgetsBundleResult.getTenantId());
    assertNull(actualSaveWidgetsBundleResult.getExternalId());
    assertNull(actualSaveWidgetsBundleResult.getId());
    assertEquals(0L, actualSaveWidgetsBundleResult.getCreatedTime());
    assertFalse(actualSaveWidgetsBundleResult.isScada());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   * <ul>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  public void testSaveWidgetsBundle_thenReturnWidgetsBundle() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any())).thenReturn(true);
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.save(Mockito.<TenantId>any(), Mockito.<WidgetsBundle>any())).thenReturn(widgetsBundle);
    when(dataValidator.validate(Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenReturn(new WidgetsBundle());

    // Act
    WidgetsBundle actualSaveWidgetsBundleResult = widgetsBundleServiceImpl.saveWidgetsBundle(new WidgetsBundle());

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("bundle"));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
    verify(widgetsBundleDao).save(isNull(), isA(WidgetsBundle.class));
    assertSame(widgetsBundle, actualSaveWidgetsBundleResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  public void testSaveWidgetsBundle_thenThrowIncorrectParameterException() {
    // Arrange
    when(dataValidator.validate(Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.saveWidgetsBundle(new WidgetsBundle()));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testDeleteWidgetsBundle() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred")).when(widgetsBundleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new WidgetsBundle());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> widgetsBundleServiceImpl
        .deleteWidgetsBundle(ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID)));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleDao} {@link Dao#findById(TenantId, UUID)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testDeleteWidgetsBundle_givenWidgetsBundleDaoFindByIdReturnNull() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> widgetsBundleServiceImpl
        .deleteWidgetsBundle(ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID)));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}
   */
  @Test
  public void testDeleteWidgetsBundle_thenCallsRemoveById() {
    // Arrange
    doNothing().when(widgetsBundleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new WidgetsBundle());

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundle(ModelConstants.SYSTEM_TENANT,
        new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  public void testFindWidgetsBundleByTenantIdAndAlias_thenReturnWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundle);

    // Act
    WidgetsBundle actualFindWidgetsBundleByTenantIdAndAliasResult = widgetsBundleServiceImpl
        .findWidgetsBundleByTenantIdAndAlias(ModelConstants.SYSTEM_TENANT, "Alias");

    // Assert
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
    assertSame(widgetsBundle, actualFindWidgetsBundleByTenantIdAndAliasResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  public void testFindWidgetsBundleByTenantIdAndAlias_thenThrowIncorrectParameterException() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(ModelConstants.SYSTEM_TENANT, "Alias"));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetsBundlesByPageLink() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult = widgetsBundleServiceImpl
        .findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetsBundlesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetsBundlesByPageLink2() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult = widgetsBundleServiceImpl
        .findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetsBundlesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetsBundlesByPageLink_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetsBundlesByPageLink_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findSystemWidgetsBundles, widgetsBundleFilter [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetsBundlesByPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult = widgetsBundleServiceImpl
        .findSystemWidgetsBundlesByPageLink(null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(actualFindSystemWidgetsBundlesByPageLinkResult.EMPTY_PAGE_DATA,
        actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}
   */
  @Test
  public void testFindSystemWidgetsBundles_thenReturnEmpty() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    List<WidgetsBundle> actualFindSystemWidgetsBundlesResult = widgetsBundleServiceImpl
        .findSystemWidgetsBundles(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao).findSystemWidgetsBundles(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertTrue(actualFindSystemWidgetsBundlesResult.isEmpty());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}
   */
  @Test
  public void testFindSystemWidgetsBundles_thenThrowIncorrectParameterException() {
    // Arrange
    when(widgetsBundleDao.findSystemWidgetsBundles(Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundles(ModelConstants.SYSTEM_TENANT));
    verify(widgetsBundleDao).findSystemWidgetsBundles(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantId2() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findTenantWidgetsBundlesByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findAllTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink2() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findAllTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink3() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findAllTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao).findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink_thenThrowRuntimeException() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findAllTenantWidgetsBundlesByTenantIdAndPageLink, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink2() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink3() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult = widgetsBundleServiceImpl
        .findTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_thenThrowRuntimeException() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter = WidgetsBundleFilter.builder()
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(
        new RuntimeException("Executing findTenantWidgetsBundlesByTenantIdAndPageLink, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantId_thenReturnEmpty() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    List<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult = widgetsBundleServiceImpl
        .findAllTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao).findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.isEmpty());
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  public void testFindAllTenantWidgetsBundlesByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(widgetsBundleDao).findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteWidgetsBundlesByTenantId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleDao} {@link Dao#findById(TenantId, UUID)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteWidgetsBundlesByTenantId_givenWidgetsBundleDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteWidgetsBundlesByTenantId_thenCallsRemoveById() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    doThrow(new IncorrectParameterException("An error occurred")).when(widgetsBundleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new WidgetsBundle());
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetsBundleServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleDao} {@link Dao#findById(TenantId, UUID)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenWidgetsBundleDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsRemoveById() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    doThrow(new IncorrectParameterException("An error occurred")).when(widgetsBundleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new WidgetsBundle());
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(Mockito.<String>any(), isA(ResourceType[].class)))
        .thenReturn("Check System Resources Usage");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets2() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(Mockito.<String>any(), isA(ResourceType[].class))).thenReturn("");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets3() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(Mockito.<String>any(), isA(ResourceType[].class)))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets_given42_whenArrayListAdd42_thenThrowRuntimeException() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("foo");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets_givenNull_whenArrayListAddNull_thenThrowRuntimeException() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("foo");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   * <ul>
   *   <li>Given {@link ResourceService}
   * {@link ResourceService#checkSystemResourcesUsage(String, ResourceType[])}
   * return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  public void testUpdateSystemWidgets_givenResourceServiceCheckSystemResourcesUsageReturn42() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(Mockito.<String>any(), isA(ResourceType[].class))).thenReturn("42");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetsBundle);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = widgetsBundleServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetsBundle, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetsBundle);

    // Act
    Optional<HasId<?>> actualFindEntityResult = widgetsBundleServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetsBundle, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetsBundleServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGETS_BUNDLE, (new WidgetsBundleServiceImpl()).getEntityType());
  }
}
