package com.acme.facet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.alfresco.repo.search.impl.solr.facet.handler.AbstractFacetLabelDisplayHandler;
import org.alfresco.repo.search.impl.solr.facet.handler.FacetLabel;
import org.alfresco.service.cmr.dictionary.DictionaryService;
import org.alfresco.service.cmr.dictionary.TypeDefinition;
import org.alfresco.service.namespace.QName;
import org.alfresco.util.ParameterCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Show title as label for content type facet.
 */
public class TypeFacetLabelDisplayHandler extends AbstractFacetLabelDisplayHandler {

	private static final Logger logger = LoggerFactory.getLogger(TypeFacetLabelDisplayHandler.class);

	public TypeFacetLabelDisplayHandler(Set<String> supportedFieldFacets) {
		ParameterCheck.mandatory("supportedFieldFacets", supportedFieldFacets);
		this.supportedFieldFacets = Collections.unmodifiableSet(new HashSet<>(supportedFieldFacets));
	}

	@Override
	public FacetLabel getDisplayLabel(String value) {
		logger.debug("value={}", value);

		QName qname = QName.createQName(value);
		DictionaryService dictionaryService = serviceRegistry.getDictionaryService();
		TypeDefinition type = dictionaryService.getType(qname);
		String title = type.getTitle(dictionaryService);

		return new FacetLabel(value, title, -1);
	}

}