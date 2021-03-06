/**
 * 
 *  Copyright (C) 2013 Vanderbilt University <csaba.toth, b.malin @vanderbilt.edu>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.openhie.openempi.matching;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhie.openempi.ApplicationException;
import org.openhie.openempi.InitializationException;
import org.openhie.openempi.configuration.AdminConfiguration.ComponentType;
import org.openhie.openempi.model.LeanRecordPair;
import org.openhie.openempi.model.Person;
import org.openhie.openempi.model.PersonMatch;

public interface MatchingServiceSelector
{
	public MatchingServiceType[] getMatchingServiceTypes();
	
	public List<String> getMatchingServiceNames();
	
	public MatchingServiceType getMatchingServiceType(String name);
	
	public void init(String matchingServiceTypeName, Map<String, Object> configParameters) throws InitializationException;
	
	public Set<LeanRecordPair> match(String matchingServiceTypeName, String blockingServiceTypeName,
			String leftTableName, String rightTableName, Person person) throws ApplicationException;
	
	public PersonMatch linkRecords(String blockingServiceTypeName, Object blockingServiceCustomParameters,
			String matchingServiceTypeName, Object matchingServiceCustomParameters,
			String linkTableName, String leftTableName, String leftOriginalIdFieldName,
			List<LeanRecordPair> pairs, ComponentType componentType,
			boolean emOnly, boolean persistLinks) throws ApplicationException;
}
