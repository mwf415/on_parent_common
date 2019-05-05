package cn.onlov.cms.common.core.entity.base;

import cn.onlov.cms.common.core.entity.Config;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jo_config table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jo_config"
 */

public abstract class BaseConfig  implements Serializable {

	public static String REF = "Config";
	public static String PROP_VALUE = "value";
	public static String PROP_ID = "id";


	// constructors
	public BaseConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseConfig (String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String id;

	// fields
	private String value;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="cfg_key"
     */
	public String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: cfg_value
	 */
	public String getValue () {
		return value;
	}

	/**
	 * Set the value related to the column: cfg_value
	 * @param value the cfg_value value
	 */
	public void setValue (String value) {
		this.value = value;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof Config)) return false;
		else {
			Config config = (Config) obj;
			if (null == this.getId() || null == config.getId()) return false;
			else return (this.getId().equals(config.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}