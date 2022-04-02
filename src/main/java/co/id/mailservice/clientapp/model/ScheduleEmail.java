/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Deanchristt
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleEmail {
    private Long id;
    private EmailListName emailListName;
    private Konten konten;
    private Date tanggal_kirim;
}
