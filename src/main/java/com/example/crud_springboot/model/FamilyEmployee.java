package com.example.crud_springboot.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "m_family_employee")
public class FamilyEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mFamilyEmployeeId;

    @ManyToOne
    @JoinColumn(name = "m_employee_id", nullable = false)
    private Employee employee;

    @Column(name = "hubungan_keluarga", nullable = false)
    private String hubunganKeluarga;

    @Column(name = "nama_anggota_keluarga", nullable = false)
    private String namaAnggotaKeluarga;

    @Column(name = "tanggal_lahir_anggota_keluarga", nullable = false)
    private LocalDate tanggalLahirAnggotaKeluarga;

    // Getter dan Setter
    public Long getmFamilyEmployeeId() {
        return mFamilyEmployeeId;
    }

    public void setmFamilyEmployeeId(Long mFamilyEmployeeId) {
        this.mFamilyEmployeeId = mFamilyEmployeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getHubunganKeluarga() {
        return hubunganKeluarga;
    }

    public void setHubunganKeluarga(String hubunganKeluarga) {
        this.hubunganKeluarga = hubunganKeluarga;
    }

    public String getNamaAnggotaKeluarga() {
        return namaAnggotaKeluarga;
    }

    public void setNamaAnggotaKeluarga(String namaAnggotaKeluarga) {
        this.namaAnggotaKeluarga = namaAnggotaKeluarga;
    }

    public LocalDate getTanggalLahirAnggotaKeluarga() {
        return tanggalLahirAnggotaKeluarga;
    }

    public void setTanggalLahirAnggotaKeluarga(LocalDate tanggalLahirAnggotaKeluarga) {
        this.tanggalLahirAnggotaKeluarga = tanggalLahirAnggotaKeluarga;
    }
}
