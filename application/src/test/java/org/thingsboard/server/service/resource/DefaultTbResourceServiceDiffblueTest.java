package org.thingsboard.server.service.resource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.lwm2m.LwM2mObject;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;

class DefaultTbResourceServiceDiffblueTest {
  /**
   * Test {@link DefaultTbResourceService#save(TbResource, User)} with
   * {@code TbResource}, {@code User}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbResourceService#save(TbResource, User)}
   */
  @Test
  @DisplayName("Test save(TbResource, User) with 'TbResource', 'User'; then throw IllegalArgumentException")
  void testSaveWithTbResourceUser_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(mock(ResourceService.class));

    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbResourceService.save(resource, new User()));
  }

  /**
   * Test {@link DefaultTbResourceService#delete(TbResource, User)} with
   * {@code TbResource}, {@code User}.
   * <ul>
   *   <li>Given {@link ResourceType#IMAGE}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbResourceService#delete(TbResource, User)}
   */
  @Test
  @DisplayName("Test delete(TbResource, User) with 'TbResource', 'User'; given IMAGE; then throw IllegalArgumentException")
  void testDeleteWithTbResourceUser_givenImage_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator()));

    TbResource tbResource = new TbResource();
    tbResource.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbResourceService.delete(tbResource, new User()));
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}.
   * <ul>
   *   <li>Then calls
   * {@link TbResourceRepository#findResourcesByIds(UUID, UUID, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}
   */
  @Test
  @DisplayName("Test findLwM2mObject(TenantId, String, String, String[]); then calls findResourcesByIds(UUID, UUID, String, String[])")
  void testFindLwM2mObject_thenCallsFindResourcesByIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.findResourcesByIds(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String[]>any())).thenReturn(new ArrayList<>());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator()));

    // Act
    List<LwM2mObject> actualFindLwM2mObjectResult = defaultTbResourceService
        .findLwM2mObject(new TenantId(UUID.randomUUID()), "asc", "Sort Property", new String[]{"Object Ids"});

    // Assert
    verify(resourceRepository).findResourcesByIds(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"),
        isA(String[].class));
    assertTrue(actualFindLwM2mObjectResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}.
   * <ul>
   *   <li>Then calls
   * {@link ResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}
   */
  @Test
  @DisplayName("Test findLwM2mObject(TenantId, String, String, String[]); then calls findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])")
  void testFindLwM2mObject_thenCallsFindTenantResourcesByResourceTypeAndObjectIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceService resourceService = mock(ResourceService.class);
    when(resourceService.findTenantResourcesByResourceTypeAndObjectIds(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<String[]>any())).thenReturn(new ArrayList<>());
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);

    // Act
    List<LwM2mObject> actualFindLwM2mObjectResult = defaultTbResourceService
        .findLwM2mObject(new TenantId(UUID.randomUUID()), "asc", "Sort Property", new String[]{"Object Ids"});

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndObjectIds(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(String[].class));
    assertTrue(actualFindLwM2mObjectResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}.
   * <ul>
   *   <li>Then calls {@link TbResource#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}
   */
  @Test
  @DisplayName("Test findLwM2mObject(TenantId, String, String, String[]); then calls getData()")
  void testFindLwM2mObject_thenCallsGetData() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getSearchText()).thenReturn("Search Text");
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<TbResource> tbResourceList = new ArrayList<>();
    tbResourceList.add(tbResource);
    ResourceService resourceService = mock(ResourceService.class);
    when(resourceService.findTenantResourcesByResourceTypeAndObjectIds(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<String[]>any())).thenReturn(tbResourceList);
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);

    // Act
    List<LwM2mObject> actualFindLwM2mObjectResult = defaultTbResourceService
        .findLwM2mObject(new TenantId(UUID.randomUUID()), "asc", "Sort Property", new String[]{"Object Ids"});

    // Assert
    verify(tbResource).getData();
    verify(tbResource, atLeast(1)).getSearchText();
    verify(resourceService).findTenantResourcesByResourceTypeAndObjectIds(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(String[].class));
    assertTrue(actualFindLwM2mObjectResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}.
   * <ul>
   *   <li>When {@code DESC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}
   */
  @Test
  @DisplayName("Test findLwM2mObject(TenantId, String, String, String[]); when 'DESC'")
  void testFindLwM2mObject_whenDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceService resourceService = mock(ResourceService.class);
    when(resourceService.findTenantResourcesByResourceTypeAndObjectIds(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<String[]>any())).thenReturn(new ArrayList<>());
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);

    // Act
    List<LwM2mObject> actualFindLwM2mObjectResult = defaultTbResourceService
        .findLwM2mObject(new TenantId(UUID.randomUUID()), "DESC", "Sort Property", new String[]{"Object Ids"});

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndObjectIds(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(String[].class));
    assertTrue(actualFindLwM2mObjectResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}.
   * <ul>
   *   <li>When {@code name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObject(TenantId, String, String, String[])}
   */
  @Test
  @DisplayName("Test findLwM2mObject(TenantId, String, String, String[]); when 'name'")
  void testFindLwM2mObject_whenName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceService resourceService = mock(ResourceService.class);
    when(resourceService.findTenantResourcesByResourceTypeAndObjectIds(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<String[]>any())).thenReturn(new ArrayList<>());
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);

    // Act
    List<LwM2mObject> actualFindLwM2mObjectResult = defaultTbResourceService
        .findLwM2mObject(new TenantId(UUID.randomUUID()), "asc", "name", new String[]{"Object Ids"});

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndObjectIds(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(String[].class));
    assertTrue(actualFindLwM2mObjectResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>Then calls
   * {@link TbResourceRepository#findResourcesPage(UUID, UUID, String, String, String, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test findLwM2mObjectPage(TenantId, String, String, PageLink); then calls findResourcesPage(UUID, UUID, String, String, String, Pageable)")
  void testFindLwM2mObjectPage_thenCallsFindResourcesPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.findResourcesPage(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    List<LwM2mObject> actualFindLwM2mObjectPageResult = defaultTbResourceService.findLwM2mObjectPage(tenantId,
        "Sort Property", "asc", new PageLink(3));

    // Assert
    verify(resourceRepository).findResourcesPage(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isNull(),
        isNull(), isA(Pageable.class));
    assertTrue(actualFindLwM2mObjectPageResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>Then calls
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test findLwM2mObjectPage(TenantId, String, String, PageLink); then calls findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)")
  void testFindLwM2mObjectPage_thenCallsFindTenantResourcesByResourceTypeAndPageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseImageService resourceService = mock(BaseImageService.class);
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(resourceService.findTenantResourcesByResourceTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    List<LwM2mObject> actualFindLwM2mObjectPageResult = defaultTbResourceService.findLwM2mObjectPage(tenantId,
        "Sort Property", "asc", new PageLink(3));

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndPageLink(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(PageLink.class));
    assertTrue(actualFindLwM2mObjectPageResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>Then calls {@link TbResource#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test findLwM2mObjectPage(TenantId, String, String, PageLink); then calls getData()")
  void testFindLwM2mObjectPage_thenCallsGetData() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getSearchText()).thenReturn("Search Text");
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<TbResource> data = new ArrayList<>();
    data.add(tbResource);
    BaseImageService resourceService = mock(BaseImageService.class);
    when(resourceService.findTenantResourcesByResourceTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<PageLink>any())).thenReturn(new PageData<>(data, 1, 1L, true));
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    List<LwM2mObject> actualFindLwM2mObjectPageResult = defaultTbResourceService.findLwM2mObjectPage(tenantId,
        "Sort Property", "asc", new PageLink(3));

    // Assert
    verify(tbResource).getData();
    verify(tbResource, atLeast(1)).getSearchText();
    verify(resourceService).findTenantResourcesByResourceTypeAndPageLink(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(PageLink.class));
    assertTrue(actualFindLwM2mObjectPageResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>When {@code DESC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test findLwM2mObjectPage(TenantId, String, String, PageLink); when 'DESC'")
  void testFindLwM2mObjectPage_whenDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseImageService resourceService = mock(BaseImageService.class);
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(resourceService.findTenantResourcesByResourceTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    List<LwM2mObject> actualFindLwM2mObjectPageResult = defaultTbResourceService.findLwM2mObjectPage(tenantId,
        "Sort Property", "DESC", new PageLink(3));

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndPageLink(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(PageLink.class));
    assertTrue(actualFindLwM2mObjectPageResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>When {@code name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbResourceService#findLwM2mObjectPage(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test findLwM2mObjectPage(TenantId, String, String, PageLink); when 'name'")
  void testFindLwM2mObjectPage_whenName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseImageService resourceService = mock(BaseImageService.class);
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(resourceService.findTenantResourcesByResourceTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<ResourceType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultTbResourceService defaultTbResourceService = new DefaultTbResourceService(resourceService);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    List<LwM2mObject> actualFindLwM2mObjectPageResult = defaultTbResourceService.findLwM2mObjectPage(tenantId, "name",
        "asc", new PageLink(3));

    // Assert
    verify(resourceService).findTenantResourcesByResourceTypeAndPageLink(isA(TenantId.class),
        eq(ResourceType.LWM2M_MODEL), isA(PageLink.class));
    assertTrue(actualFindLwM2mObjectPageResult.isEmpty());
  }
}
