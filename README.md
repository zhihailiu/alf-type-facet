# Add Content Type as Facet in Alfresco Share Faceted Search

Share faceted search has a list of default facets, such as Creator, File Type etc. You can also use Search Manager to add custom facets. A common use case is to add content type, aka Content, Folder or custom type you created in content modeling, as a facet so search results can be filtered by content type. Unfortunately, you can't do that in Search Manager - content type is not in its list.

In this project, I use Alfresco webscript to add content type as facet, and add customized display label handler to show title for the facet in facet menu. The project is created as "all-in-one" with Alfresco SDK 2.2.0. It runs Alfresco Community 5.1.0.

1.Start Alfresco
```
$mvn clean install -Prun
```
2.Add content type as a facet
```
http://localhost:8080/alfresco/s/api/facet/facet-config
```
use POST method with JSON data
```
{  
   "filterID":"filter_content_type",
   "facetQName":"TYPE",
   "displayName":"Content Type",
   "displayControl":"alfresco/search/FacetFilters",
   "maxFilters":10,
   "hitThreshold":1,
   "minFilterValueLength":3,
   "sortBy":"ALPHABETICALLY",
   "scope":"ALL",
   "isEnabled":true,
   "isDefault":false
}
```
3.Login Share and search for "project"
 
