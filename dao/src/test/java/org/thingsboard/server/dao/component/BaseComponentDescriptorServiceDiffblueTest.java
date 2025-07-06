package org.thingsboard.server.dao.component;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseComponentDescriptorService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseComponentDescriptorServiceDiffblueTest {
  @Autowired private BaseComponentDescriptorService baseComponentDescriptorService;

  @MockBean private ComponentDescriptorDao componentDescriptorDao;

  @MockBean private DataValidator<ComponentDescriptor> dataValidator;

  /**
   * Test {@link BaseComponentDescriptorService#saveComponent(TenantId, ComponentDescriptor)}.
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#saveComponent(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.saveComponent(TenantId, ComponentDescriptor)"
  })
  public void testSaveComponent() {
    // Arrange
    when(componentDescriptorDao.saveIfNotExist(
            Mockito.<TenantId>any(), Mockito.<ComponentDescriptor>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<ComponentDescriptor>any(),
            Mockito.<Function<ComponentDescriptor, TenantId>>any()))
        .thenReturn(new ComponentDescriptor());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.saveComponent(
                ModelConstants.SYSTEM_TENANT, new ComponentDescriptor()));
    verify(componentDescriptorDao)
        .saveIfNotExist(isA(TenantId.class), isA(ComponentDescriptor.class));
    verify(dataValidator).validate(isA(ComponentDescriptor.class), isA(Function.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#saveComponent(TenantId, ComponentDescriptor)}.
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#saveComponent(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.saveComponent(TenantId, ComponentDescriptor)"
  })
  public void testSaveComponent2() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    Optional<ComponentDescriptor> ofResult = Optional.of(componentDescriptor);
    when(componentDescriptorDao.saveIfNotExist(
            Mockito.<TenantId>any(), Mockito.<ComponentDescriptor>any()))
        .thenReturn(ofResult);
    when(dataValidator.validate(
            Mockito.<ComponentDescriptor>any(),
            Mockito.<Function<ComponentDescriptor, TenantId>>any()))
        .thenReturn(new ComponentDescriptor());

    // Act
    ComponentDescriptor actualSaveComponentResult =
        baseComponentDescriptorService.saveComponent(
            ModelConstants.SYSTEM_TENANT, new ComponentDescriptor());

    // Assert
    verify(componentDescriptorDao)
        .saveIfNotExist(isA(TenantId.class), isA(ComponentDescriptor.class));
    verify(dataValidator).validate(isA(ComponentDescriptor.class), isA(Function.class));
    assertSame(componentDescriptor, actualSaveComponentResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#saveComponent(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link ComponentDescriptorDao}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#saveComponent(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.saveComponent(TenantId, ComponentDescriptor)"
  })
  public void testSaveComponent_givenComponentDescriptorDao_thenThrowDataValidationException() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<ComponentDescriptor>any(),
            Mockito.<Function<ComponentDescriptor, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.saveComponent(
                ModelConstants.SYSTEM_TENANT, new ComponentDescriptor()));
    verify(dataValidator).validate(isA(ComponentDescriptor.class), isA(Function.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#saveComponent(TenantId, ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Then calls {@link ComponentDescriptorDao#findByClazz(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#saveComponent(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.saveComponent(TenantId, ComponentDescriptor)"
  })
  public void testSaveComponent_thenCallsFindByClazz() {
    // Arrange
    Optional<ComponentDescriptor> emptyResult = Optional.empty();
    when(componentDescriptorDao.saveIfNotExist(
            Mockito.<TenantId>any(), Mockito.<ComponentDescriptor>any()))
        .thenReturn(emptyResult);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorDao.findByClazz(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(componentDescriptor);
    when(dataValidator.validate(
            Mockito.<ComponentDescriptor>any(),
            Mockito.<Function<ComponentDescriptor, TenantId>>any()))
        .thenReturn(new ComponentDescriptor());

    // Act
    ComponentDescriptor actualSaveComponentResult =
        baseComponentDescriptorService.saveComponent(
            ModelConstants.SYSTEM_TENANT, new ComponentDescriptor());

    // Assert
    verify(componentDescriptorDao).findByClazz(isA(TenantId.class), isNull());
    verify(componentDescriptorDao)
        .saveIfNotExist(isA(TenantId.class), isA(ComponentDescriptor.class));
    verify(dataValidator).validate(isA(ComponentDescriptor.class), isA(Function.class));
    assertSame(componentDescriptor, actualSaveComponentResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}.
   *
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.findById(TenantId, ComponentDescriptorId)"
  })
  public void testFindById_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorDao.findById(
            Mockito.<TenantId>any(), Mockito.<ComponentDescriptorId>any()))
        .thenReturn(componentDescriptor);

    // Act
    ComponentDescriptor actualFindByIdResult =
        baseComponentDescriptorService.findById(
            ModelConstants.SYSTEM_TENANT,
            new ComponentDescriptorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(componentDescriptorDao).findById(isA(TenantId.class), isA(ComponentDescriptorId.class));
    assertSame(componentDescriptor, actualFindByIdResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findById(TenantId,
   * ComponentDescriptorId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.findById(TenantId, ComponentDescriptorId)"
  })
  public void testFindById_thenThrowDataValidationException() {
    // Arrange
    when(componentDescriptorDao.findById(
            Mockito.<TenantId>any(), Mockito.<ComponentDescriptorId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findById(
                ModelConstants.SYSTEM_TENANT,
                new ComponentDescriptorId(
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(componentDescriptorDao).findById(isA(TenantId.class), isA(ComponentDescriptorId.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.findByClazz(TenantId, String)"
  })
  public void testFindByClazz_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorDao.findByClazz(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(componentDescriptor);

    // Act
    ComponentDescriptor actualFindByClazzResult =
        baseComponentDescriptorService.findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorDao).findByClazz(isA(TenantId.class), eq("Clazz"));
    assertSame(componentDescriptor, actualFindByClazzResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ComponentDescriptor BaseComponentDescriptorService.findByClazz(TenantId, String)"
  })
  public void testFindByClazz_thenThrowDataValidationException() {
    // Arrange
    when(componentDescriptorDao.findByClazz(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseComponentDescriptorService.findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz"));
    verify(componentDescriptorDao).findByClazz(isA(TenantId.class), eq("Clazz"));
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink() {
    // Arrange
    when(componentDescriptorDao.findByTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<ComponentType>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findByTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT,
                ComponentType.ENRICHMENT,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(componentDescriptorDao)
        .findByTypeAndPageLink(
            isA(TenantId.class), eq(ComponentType.ENRICHMENT), isA(PageLink.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findByTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findByTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<ComponentType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        baseComponentDescriptorService.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByTypeAndPageLink(
            isA(TenantId.class), eq(ComponentType.ENRICHMENT), isA(PageLink.class));
    assertSame(
        actualFindByTypeAndPageLinkResult.EMPTY_PAGE_DATA, actualFindByTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<ComponentType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        baseComponentDescriptorService.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByTypeAndPageLink(
            isA(TenantId.class), eq(ComponentType.ENRICHMENT), isA(PageLink.class));
    assertSame(
        actualFindByTypeAndPageLinkResult.EMPTY_PAGE_DATA, actualFindByTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<ComponentType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        baseComponentDescriptorService.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByTypeAndPageLink(
            isA(TenantId.class), eq(ComponentType.ENRICHMENT), isA(PageLink.class));
    assertSame(
        actualFindByTypeAndPageLinkResult.EMPTY_PAGE_DATA, actualFindByTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_thenCallsGetProperty() {
    // Arrange
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
            baseComponentDescriptorService.findByTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId, ComponentType,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#findByTypeAndPageLink(TenantId,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByTypeAndPageLink(TenantId, ComponentType, PageLink)"
  })
  public void testFindByTypeAndPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<ComponentType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult =
        baseComponentDescriptorService.findByTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorDao)
        .findByTypeAndPageLink(
            isA(TenantId.class), eq(ComponentType.ENRICHMENT), isA(PageLink.class));
    assertSame(
        actualFindByTypeAndPageLinkResult.EMPTY_PAGE_DATA, actualFindByTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink() {
    // Arrange
    when(componentDescriptorDao.findByScopeAndTypeAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<ComponentType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT,
                ComponentScope.SYSTEM,
                ComponentType.ENRICHMENT,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(componentDescriptorDao)
        .findByScopeAndTypeAndPageLink(
            isA(TenantId.class),
            eq(ComponentScope.SYSTEM),
            eq(ComponentType.ENRICHMENT),
            isA(PageLink.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT,
                ComponentScope.SYSTEM,
                ComponentType.ENRICHMENT,
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByScopeAndTypeAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<ComponentType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByScopeAndTypeAndPageLink(
            isA(TenantId.class),
            eq(ComponentScope.SYSTEM),
            eq(ComponentType.ENRICHMENT),
            isA(PageLink.class));
    assertSame(
        actualFindByScopeAndTypeAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindByScopeAndTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByScopeAndTypeAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<ComponentType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByScopeAndTypeAndPageLink(
            isA(TenantId.class),
            eq(ComponentScope.SYSTEM),
            eq(ComponentType.ENRICHMENT),
            isA(PageLink.class));
    assertSame(
        actualFindByScopeAndTypeAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindByScopeAndTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByScopeAndTypeAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<ComponentType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(componentDescriptorDao)
        .findByScopeAndTypeAndPageLink(
            isA(TenantId.class),
            eq(ComponentScope.SYSTEM),
            eq(ComponentType.ENRICHMENT),
            isA(PageLink.class));
    assertSame(
        actualFindByScopeAndTypeAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindByScopeAndTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_thenCallsGetProperty() {
    // Arrange
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
            baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT,
                ComponentScope.SYSTEM,
                ComponentType.ENRICHMENT,
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId,
   * ComponentScope, ComponentType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseComponentDescriptorService#findByScopeAndTypeAndPageLink(TenantId, ComponentScope,
   * ComponentType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseComponentDescriptorService.findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)"
  })
  public void testFindByScopeAndTypeAndPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<ComponentDescriptor> emptyPageDataResult = PageData.emptyPageData();
    when(componentDescriptorDao.findByScopeAndTypeAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<ComponentScope>any(),
            Mockito.<ComponentType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult =
        baseComponentDescriptorService.findByScopeAndTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ComponentScope.SYSTEM,
            ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorDao)
        .findByScopeAndTypeAndPageLink(
            isA(TenantId.class),
            eq(ComponentScope.SYSTEM),
            eq(ComponentType.ENRICHMENT),
            isA(PageLink.class));
    assertSame(
        actualFindByScopeAndTypeAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindByScopeAndTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ComponentDescriptorDao} {@link
   *       ComponentDescriptorDao#deleteByClazz(TenantId, String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseComponentDescriptorService.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz_givenComponentDescriptorDaoDeleteByClazzDoesNothing() {
    // Arrange
    doNothing()
        .when(componentDescriptorDao)
        .deleteByClazz(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    baseComponentDescriptorService.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorDao).deleteByClazz(isA(TenantId.class), eq("Clazz"));
  }

  /**
   * Test {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseComponentDescriptorService.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(componentDescriptorDao)
        .deleteByClazz(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseComponentDescriptorService.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz"));
    verify(componentDescriptorDao).deleteByClazz(isA(TenantId.class), eq("Clazz"));
  }
}
