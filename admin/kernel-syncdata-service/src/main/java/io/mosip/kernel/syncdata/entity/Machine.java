package io.mosip.kernel.syncdata.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.mosip.kernel.syncdata.entity.id.IdAndLanguageCodeID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Entity for Machine Details
 * 
 * @author Megha Tanga
 * @author Urvil Joshi
 * @since 1.0.1
 *
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "machine_master", schema = "master")
public class Machine extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5585825705521742941L;

	@Id
	@Column(name = "id", nullable = false, length = 10)
	private String id;

	@Column(name = "lang_code", nullable = true, length = 3)
	private String langCode;

	/**
	 * Field for machine name
	 */
	@Column(name = "name", nullable = false, length = 64)
	private String name;

	/**
	 * Field for machine serial number
	 */
	@Column(name = "serial_num", nullable = true, length = 64)
	private String serialNum;

	/**
	 * Field for machine ip address
	 */
	@Column(name = "ip_address", length = 17)
	private String ipAddress;
	/**
	 * Field for machine mac address
	 */
	@Column(name = "mac_address", nullable = true, length = 64)
	private String macAddress;

	/**
	 * Field for machine specific id
	 */
	@Column(name = "mspec_id", nullable = false, length = 36)
	private String machineSpecId;

	/**
	 * Field for validity end Date and Time for machine
	 */
	@Column(name = "validity_end_dtimes")
	private LocalDateTime validityDateTime;

	/**
	 * Field for publicKey
	 */
	@Column(name = "public_key", length=1024)
	private String publicKey;

	/**
	 * Field for public key pringerprint
	 */
	@Column(name = "key_index")
	private String keyIndex;

	@Column(name = "zone_code", length = 36)
	private String zoneCode;
	
	@Column(name = "regcntr_id", length = 10)
	private String regCenterId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mspec_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MachineSpecification machineSpecification;

	/**
	 * Field for signature verification public key
	 */
	@Column(name = "sign_public_key", length=1024)
	private String signPublicKey;

	/**
	 * Field for signature verification public key fingerprint
	 */
	@Column(name = "sign_key_index")
	private String signKeyIndex;
}
