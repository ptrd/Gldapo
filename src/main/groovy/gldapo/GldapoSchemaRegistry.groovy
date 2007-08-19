/* 
 * Copyright 2007 Luke Daley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gldapo;
import gldapo.schema.injecto.GldapoSchemaMetaInjecto;
import injecto.Injecto

class GldapoSchemaRegistry extends LinkedList<Class>
{
	static final CONFIG_SCHEMAS_KEY = 'schemas'
	
	void add(Class schema)
	{
		use (Injecto) {
			schema.injecto(GldapoSchemaMetaInjecto)
		}

		super(schema)
	}
	
	static newFromConfig(ConfigObject config)
	{
		def registry = this.newInstance()
		if (config.containsKey(CONFIG_SCHEMAS_KEY))
		{
			config[CONFIG_SCHEMAS_KEY].each { registry << it }
		}

		return registry
	}
}