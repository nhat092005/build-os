kernel/sound/core/snd-hwdep.ko.xz symbol:snd_hwdep_new
snd

kernel/sound/core/snd-pcm-dmaengine.ko.xz symbol:snd_dmaengine_pcm_get_chan symbol:snd_hwparams_to_dma_slave_config symbol:snd_dmaengine_pcm_set_config_from_dai_data symbol:snd_dmaengine_pcm_trigger symbol:snd_dmaengine_pcm_pointer_no_residue symbol:snd_dmaengine_pcm_pointer symbol:snd_dmaengine_pcm_request_channel symbol:snd_dmaengine_pcm_open symbol:snd_dmaengine_pcm_open_request_chan symbol:snd_dmaengine_pcm_sync_stop symbol:snd_dmaengine_pcm_close symbol:snd_dmaengine_pcm_close_release_chan symbol:snd_dmaengine_pcm_refine_runtime_hwparams
snd_pcm

kernel/sound/core/snd-pcm.ko.xz symbol:snd_pcm_format_name symbol:snd_pcm_new_stream symbol:snd_pcm_new symbol:snd_pcm_new_internal symbol:snd_pcm_notify symbol:snd_pcm_stream_lock symbol:snd_pcm_stream_unlock symbol:snd_pcm_stream_lock_irq symbol:snd_pcm_stream_unlock_irq symbol:_snd_pcm_stream_lock_irqsave symbol:_snd_pcm_stream_lock_irqsave_nested symbol:snd_pcm_stream_unlock_irqrestore symbol:snd_pcm_hw_refine symbol:snd_pcm_runtime_buffer_set_silence symbol:snd_pcm_stop symbol:snd_pcm_stop_xrun symbol:snd_pcm_suspend_all symbol:snd_pcm_release_substream symbol:snd_pcm_open_substream symbol:snd_pcm_kernel_ioctl symbol:snd_pcm_lib_default_mmap symbol:snd_pcm_mmap_data symbol:snd_pcm_set_ops symbol:snd_pcm_set_sync_per_card symbol:snd_interval_refine symbol:snd_interval_ratnum symbol:snd_interval_list symbol:snd_interval_ranges symbol:snd_pcm_hw_rule_add symbol:snd_pcm_hw_constraint_mask64 symbol:snd_pcm_hw_constraint_integer symbol:snd_pcm_hw_constraint_minmax symbol:snd_pcm_hw_constraint_list symbol:snd_pcm_hw_constraint_ranges symbol:snd_pcm_hw_constraint_ratnums symbol:snd_pcm_hw_constraint_ratdens symbol:snd_pcm_hw_constraint_msbits symbol:snd_pcm_hw_constraint_step symbol:snd_pcm_hw_constraint_pow2 symbol:snd_pcm_hw_rule_noresample symbol:_snd_pcm_hw_params_any symbol:snd_pcm_hw_param_value symbol:_snd_pcm_hw_param_setempty symbol:snd_pcm_hw_param_first symbol:snd_pcm_hw_param_last symbol:snd_pcm_hw_params_bits symbol:snd_pcm_lib_ioctl symbol:snd_pcm_period_elapsed_under_stream_lock symbol:snd_pcm_period_elapsed symbol:__snd_pcm_lib_xfer symbol:snd_pcm_std_chmaps symbol:snd_pcm_alt_chmaps symbol:snd_pcm_add_chmap_ctls symbol:snd_pcm_format_signed symbol:snd_pcm_format_unsigned symbol:snd_pcm_format_linear symbol:snd_pcm_format_little_endian symbol:snd_pcm_format_big_endian symbol:snd_pcm_format_width symbol:snd_pcm_format_physical_width symbol:snd_pcm_format_size symbol:snd_pcm_format_silence_64 symbol:snd_pcm_format_set_silence symbol:snd_pcm_hw_limit_rates symbol:snd_pcm_rate_to_rate_bit symbol:snd_pcm_rate_bit_to_rate symbol:snd_pcm_rate_mask_intersect symbol:snd_pcm_rate_range_to_bits symbol:snd_pcm_lib_preallocate_free_for_all symbol:snd_pcm_lib_preallocate_pages symbol:snd_pcm_lib_preallocate_pages_for_all symbol:snd_pcm_set_managed_buffer symbol:snd_pcm_set_managed_buffer_all symbol:snd_pcm_lib_malloc_pages symbol:snd_pcm_lib_free_pages symbol:snd_dma_alloc_dir_pages symbol:snd_dma_alloc_pages_fallback symbol:snd_dma_free_pages symbol:snd_devm_alloc_dir_pages symbol:snd_dma_buffer_mmap symbol:snd_dma_buffer_sync symbol:snd_sgbuf_get_addr symbol:snd_sgbuf_get_page symbol:snd_sgbuf_get_chunk_size symbol:snd_pcm_hw_constraint_eld symbol:snd_pcm_create_iec958_consumer_default symbol:snd_pcm_fill_iec958_consumer symbol:snd_pcm_fill_iec958_consumer_hw_params symbol:snd_pcm_create_iec958_consumer symbol:snd_pcm_create_iec958_consumer_hw_params
snd snd_timer

kernel/sound/core/snd-seq-device.ko.xz symbol:snd_seq_autoload_init symbol:snd_seq_autoload_exit symbol:snd_seq_device_load_drivers symbol:snd_seq_device_new symbol:__snd_seq_driver_register symbol:snd_seq_driver_unregister
snd

kernel/sound/core/seq/snd-seq-midi-event.ko.xz symbol:snd_midi_event_new symbol:snd_midi_event_free symbol:snd_midi_event_reset_encode symbol:snd_midi_event_reset_decode symbol:snd_midi_event_no_status symbol:snd_midi_event_encode_byte symbol:snd_midi_event_decode
snd_seq

kernel/sound/core/seq/snd-seq.ko.xz devname:snd/seq char_major_116_1 symbol:snd_use_lock_sync_helper symbol:snd_seq_client_ioctl_lock symbol:snd_seq_client_ioctl_unlock symbol:snd_seq_set_queue_tempo symbol:snd_seq_create_kernel_client symbol:snd_seq_delete_kernel_client symbol:snd_seq_kernel_client_enqueue symbol:snd_seq_kernel_client_dispatch symbol:snd_seq_kernel_client_ctl symbol:snd_seq_kernel_client_write_poll symbol:snd_seq_kernel_client_get symbol:snd_seq_kernel_client_put symbol:snd_seq_dump_var_event symbol:snd_seq_expand_var_event symbol:snd_seq_expand_var_event_at symbol:snd_seq_system_broadcast symbol:snd_seq_event_port_attach symbol:snd_seq_event_port_detach
snd snd_seq_device snd_timer

kernel/sound/core/seq/snd-seq-virmidi.ko.xz symbol:snd_virmidi_new
snd_rawmidi snd_seq snd_seq_midi_event snd

kernel/sound/core/seq/snd-seq-dummy.ko.xz snd_seq_client_14
snd_seq

kernel/sound/core/seq/snd-seq-midi.ko.xz
snd_rawmidi snd_seq_device snd_seq snd_seq_midi_event

kernel/sound/core/oss/snd-pcm-oss.ko.xz sound_service_?_12 sound_service_?_3
snd_pcm snd

kernel/sound/core/snd-rawmidi.ko.xz symbol:snd_rawmidi_drop_output symbol:snd_rawmidi_drain_output symbol:snd_rawmidi_drain_input symbol:snd_rawmidi_kernel_open symbol:snd_rawmidi_kernel_release symbol:snd_rawmidi_info_select symbol:snd_rawmidi_output_params symbol:snd_rawmidi_input_params symbol:snd_rawmidi_receive symbol:snd_rawmidi_kernel_read symbol:snd_rawmidi_transmit_empty symbol:snd_rawmidi_transmit_peek symbol:snd_rawmidi_transmit_ack symbol:snd_rawmidi_transmit symbol:snd_rawmidi_proceed symbol:snd_rawmidi_kernel_write symbol:snd_rawmidi_init symbol:snd_rawmidi_new symbol:snd_rawmidi_free symbol:snd_rawmidi_set_ops
snd snd_seq_device

kernel/sound/core/snd.ko.xz char_major_116_* symbol:snd_major symbol:snd_ecards_limit symbol:snd_request_card symbol:snd_lookup_minor_data symbol:snd_register_device symbol:snd_unregister_device symbol:snd_device_alloc symbol:snd_card_new symbol:snd_devm_card_new symbol:snd_card_free_on_error symbol:snd_card_ref symbol:snd_card_disconnect symbol:snd_card_disconnect_sync symbol:snd_card_free_when_closed symbol:snd_card_free symbol:snd_card_set_id symbol:snd_card_add_dev_attr symbol:snd_card_register symbol:snd_component_add symbol:snd_card_file_add symbol:snd_card_file_remove symbol:snd_power_ref_and_wait symbol:snd_power_wait symbol:copy_to_user_fromio symbol:copy_to_iter_fromio symbol:copy_from_user_toio symbol:copy_from_iter_toio symbol:snd_ctl_notify symbol:snd_ctl_notify_one symbol:snd_ctl_new1 symbol:snd_ctl_free_one symbol:snd_ctl_add symbol:snd_ctl_replace symbol:snd_ctl_remove symbol:snd_ctl_remove_id symbol:snd_ctl_activate_id symbol:snd_ctl_rename_id symbol:snd_ctl_rename symbol:snd_ctl_find_numid symbol:snd_ctl_find_id symbol:snd_ctl_register_ioctl symbol:snd_ctl_register_ioctl_compat symbol:snd_ctl_unregister_ioctl symbol:snd_ctl_unregister_ioctl_compat symbol:snd_ctl_get_preferred_subdevice symbol:snd_ctl_request_layer symbol:snd_ctl_register_layer symbol:snd_ctl_disconnect_layer symbol:snd_ctl_boolean_mono_info symbol:snd_ctl_boolean_stereo_info symbol:snd_ctl_enum_info symbol:release_and_free_resource symbol:snd_pci_quirk_lookup_id symbol:snd_pci_quirk_lookup symbol:snd_fasync_helper symbol:snd_kill_fasync symbol:snd_fasync_free symbol:snd_device_new symbol:snd_device_disconnect symbol:snd_device_free symbol:snd_device_register symbol:snd_device_get_state symbol:snd_seq_root symbol:snd_info_get_line symbol:snd_info_get_str symbol:snd_info_create_module_entry symbol:snd_info_create_card_entry symbol:snd_info_free_entry symbol:snd_info_register symbol:snd_card_rw_proc_new symbol:snd_oss_info_register symbol:snd_lookup_oss_minor_data symbol:snd_register_oss_device symbol:snd_unregister_oss_device symbol:_snd_ctl_add_follower symbol:snd_ctl_add_followers symbol:snd_ctl_make_virtual_master symbol:snd_ctl_add_vmaster_hook symbol:snd_ctl_sync_vmaster symbol:snd_ctl_apply_vmaster_followers symbol:snd_jack_add_new_kctl symbol:snd_jack_new symbol:snd_jack_set_parent symbol:snd_jack_set_key symbol:snd_jack_report

kernel/sound/core/snd-timer.ko.xz devname:snd/timer char_major_116_33 symbol:snd_timer_instance_new symbol:snd_timer_instance_free symbol:snd_timer_open symbol:snd_timer_close symbol:snd_timer_resolution symbol:snd_timer_start symbol:snd_timer_stop symbol:snd_timer_continue symbol:snd_timer_pause symbol:snd_timer_interrupt symbol:snd_timer_new symbol:snd_timer_notify symbol:snd_timer_global_new symbol:snd_timer_global_free symbol:snd_timer_global_register
snd

kernel/sound/core/snd-compress.ko.xz symbol:snd_compr_malloc_pages symbol:snd_compr_free_pages symbol:snd_compr_stop_error symbol:snd_compress_new
snd_pcm snd

kernel/sound/core/snd-hrtimer.ko.xz snd_timer_3
snd_timer

kernel/sound/soc/dwc/designware_i2s.ko.xz platform:designware_i2s of:N*T*Cstarfive,jh7110_i2srxC* of:N*T*Cstarfive,jh7110_i2srx of:N*T*Cstarfive,jh7110_i2stx1C* of:N*T*Cstarfive,jh7110_i2stx1 of:N*T*Cstarfive,jh7110_i2stx0C* of:N*T*Cstarfive,jh7110_i2stx0 of:N*T*Csnps,designware_i2sC* of:N*T*Csnps,designware_i2s
snd_soc_core snd_pcm

kernel/sound/soc/snd-soc-core.ko.xz platform:soc_audio symbol:null_dailink_component symbol:snd_soc_debugfs_root symbol:snd_soc_dai_name_get symbol:snd_soc_rtdcom_lookup symbol:snd_soc_lookup_component_nolocked symbol:snd_soc_lookup_component symbol:snd_soc_get_pcm_runtime symbol:snd_soc_close_delayed_work symbol:snd_soc_copy_dai_args symbol:snd_soc_find_dai symbol:snd_soc_find_dai_with_mutex symbol:snd_soc_remove_pcm_runtime symbol:snd_soc_add_pcm_runtimes symbol:snd_soc_runtime_set_dai_fmt symbol:snd_soc_set_dmi_name symbol:snd_soc_poweroff symbol:snd_soc_pm_ops symbol:snd_soc_cnew symbol:snd_soc_add_component_controls symbol:snd_soc_add_card_controls symbol:snd_soc_add_dai_controls symbol:snd_soc_register_card symbol:snd_soc_unregister_card symbol:snd_soc_unregister_dai symbol:snd_soc_register_dai symbol:snd_soc_component_initialize symbol:snd_soc_add_component symbol:snd_soc_register_component symbol:snd_soc_unregister_component_by_driver symbol:snd_soc_unregister_component symbol:snd_soc_of_parse_card_name symbol:snd_soc_of_parse_audio_simple_widgets symbol:snd_soc_of_parse_pin_switches symbol:snd_soc_of_get_slot_mask symbol:snd_soc_of_parse_tdm_slot symbol:snd_soc_dlc_use_cpu_as_platform symbol:snd_soc_of_parse_node_prefix symbol:snd_soc_of_parse_audio_routing symbol:snd_soc_of_parse_aux_devs symbol:snd_soc_daifmt_clock_provider_flipped symbol:snd_soc_daifmt_clock_provider_from_bitmap symbol:snd_soc_daifmt_parse_format symbol:snd_soc_daifmt_parse_clock_provider_raw symbol:snd_soc_get_stream_cpu symbol:snd_soc_get_dai_id symbol:snd_soc_get_dlc symbol:snd_soc_of_get_dlc symbol:snd_soc_get_dai_name symbol:snd_soc_of_get_dai_name symbol:snd_soc_get_dai_via_args symbol:snd_soc_of_put_dai_link_codecs symbol:snd_soc_of_get_dai_link_codecs symbol:snd_soc_of_put_dai_link_cpus symbol:snd_soc_of_get_dai_link_cpus symbol:dapm_mark_endpoints_dirty symbol:dapm_kcontrol_get_value symbol:snd_soc_dapm_kcontrol_widget symbol:snd_soc_dapm_kcontrol_dapm symbol:snd_soc_dapm_force_bias_level symbol:snd_soc_dapm_dai_get_connected_widgets symbol:snd_soc_dapm_dai_free_widgets symbol:dapm_regulator_event symbol:dapm_pinctrl_event symbol:dapm_clock_event symbol:snd_soc_dapm_mux_update_power symbol:snd_soc_dapm_mixer_update_power symbol:snd_soc_dapm_free_widget symbol:snd_soc_dapm_sync_unlocked symbol:snd_soc_dapm_sync symbol:snd_soc_dapm_update_dai symbol:snd_soc_dapm_widget_name_cmp symbol:snd_soc_dapm_add_routes symbol:snd_soc_dapm_del_routes symbol:snd_soc_dapm_weak_routes symbol:snd_soc_dapm_new_widgets symbol:snd_soc_dapm_get_volsw symbol:snd_soc_dapm_put_volsw symbol:snd_soc_dapm_get_enum_double symbol:snd_soc_dapm_put_enum_double symbol:snd_soc_dapm_info_pin_switch symbol:snd_soc_dapm_get_pin_switch symbol:snd_soc_dapm_put_pin_switch symbol:snd_soc_dapm_new_control symbol:snd_soc_dapm_new_controls symbol:snd_soc_dapm_new_dai_widgets symbol:snd_soc_dapm_stream_stop symbol:snd_soc_dapm_enable_pin_unlocked symbol:snd_soc_dapm_enable_pin symbol:snd_soc_dapm_force_enable_pin_unlocked symbol:snd_soc_dapm_force_enable_pin symbol:snd_soc_dapm_disable_pin_unlocked symbol:snd_soc_dapm_disable_pin symbol:snd_soc_dapm_nc_pin_unlocked symbol:snd_soc_dapm_nc_pin symbol:snd_soc_dapm_get_pin_status symbol:snd_soc_dapm_ignore_suspend symbol:snd_soc_dapm_free symbol:snd_soc_dapm_init symbol:snd_soc_jack_report symbol:snd_soc_jack_add_zones symbol:snd_soc_jack_get_type symbol:snd_soc_jack_add_pins symbol:snd_soc_jack_notifier_register symbol:snd_soc_jack_notifier_unregister symbol:snd_soc_jack_add_gpios symbol:snd_soc_jack_add_gpiods symbol:snd_soc_jack_free_gpios symbol:snd_soc_calc_frame_size symbol:snd_soc_params_to_frame_size symbol:snd_soc_calc_bclk symbol:snd_soc_params_to_bclk symbol:snd_soc_tdm_params_to_bclk symbol:snd_soc_dai_is_dummy symbol:snd_soc_dummy_dlc symbol:snd_soc_dai_set_sysclk symbol:snd_soc_dai_set_clkdiv symbol:snd_soc_dai_set_pll symbol:snd_soc_dai_set_bclk_ratio symbol:snd_soc_dai_set_fmt symbol:snd_soc_dai_set_tdm_slot symbol:snd_soc_dai_set_channel_map symbol:snd_soc_dai_get_channel_map symbol:snd_soc_dai_set_tristate symbol:snd_soc_dai_digital_mute symbol:snd_soc_dai_action symbol:snd_soc_dai_active symbol:snd_soc_dai_compr_startup symbol:snd_soc_dai_compr_shutdown symbol:snd_soc_dai_compr_trigger symbol:snd_soc_dai_compr_set_params symbol:snd_soc_dai_compr_get_params symbol:snd_soc_dai_compr_ack symbol:snd_soc_dai_compr_pointer symbol:snd_soc_dai_compr_set_metadata symbol:snd_soc_dai_compr_get_metadata symbol:snd_soc_component_set_sysclk symbol:snd_soc_component_set_pll symbol:snd_soc_component_enable_pin symbol:snd_soc_component_enable_pin_unlocked symbol:snd_soc_component_disable_pin symbol:snd_soc_component_disable_pin_unlocked symbol:snd_soc_component_nc_pin symbol:snd_soc_component_nc_pin_unlocked symbol:snd_soc_component_get_pin_status symbol:snd_soc_component_force_enable_pin symbol:snd_soc_component_force_enable_pin_unlocked symbol:snd_soc_component_get_kcontrol symbol:snd_soc_component_notify_control symbol:snd_soc_component_set_jack symbol:snd_soc_component_get_jack_type symbol:snd_soc_component_init_regmap symbol:snd_soc_component_exit_regmap symbol:snd_soc_component_compr_open symbol:snd_soc_component_compr_free symbol:snd_soc_component_compr_trigger symbol:snd_soc_component_compr_set_params symbol:snd_soc_component_compr_get_params symbol:snd_soc_component_compr_get_caps symbol:snd_soc_component_compr_get_codec_caps symbol:snd_soc_component_compr_ack symbol:snd_soc_component_compr_pointer symbol:snd_soc_component_compr_copy symbol:snd_soc_component_compr_set_metadata symbol:snd_soc_component_compr_get_metadata symbol:snd_soc_component_read symbol:snd_soc_component_write symbol:snd_soc_component_update_bits symbol:snd_soc_component_update_bits_async symbol:snd_soc_component_read_field symbol:snd_soc_component_write_field symbol:snd_soc_component_async_complete symbol:snd_soc_component_test_bits symbol:snd_soc_runtime_action symbol:snd_soc_set_runtime_hwparams symbol:snd_soc_runtime_calc_hw symbol:widget_in_list symbol:dpcm_end_walk_at_be symbol:dpcm_be_dai_trigger symbol:snd_soc_dpcm_runtime_update symbol:snd_soc_dpcm_get_substream symbol:devm_snd_soc_register_dai symbol:devm_snd_soc_register_component symbol:devm_snd_soc_register_card symbol:devm_snd_dmaengine_pcm_register symbol:snd_soc_info_enum_double symbol:snd_soc_get_enum_double symbol:snd_soc_put_enum_double symbol:snd_soc_info_volsw symbol:snd_soc_info_volsw_sx symbol:snd_soc_get_volsw symbol:snd_soc_put_volsw symbol:snd_soc_get_volsw_sx symbol:snd_soc_put_volsw_sx symbol:snd_soc_info_volsw_range symbol:snd_soc_put_volsw_range symbol:snd_soc_get_volsw_range symbol:snd_soc_limit_volume symbol:snd_soc_bytes_info symbol:snd_soc_bytes_get symbol:snd_soc_bytes_put symbol:snd_soc_bytes_info_ext symbol:snd_soc_bytes_tlv_callback symbol:snd_soc_info_xr_sx symbol:snd_soc_get_xr_sx symbol:snd_soc_put_xr_sx symbol:snd_soc_get_strobe symbol:snd_soc_put_strobe symbol:snd_soc_link_compr_startup symbol:snd_soc_link_compr_shutdown symbol:snd_soc_link_compr_set_params symbol:snd_soc_card_get_kcontrol symbol:snd_soc_card_jack_new symbol:snd_soc_card_jack_new_pins symbol:snd_soc_card_add_dai_link symbol:snd_soc_card_remove_dai_link symbol:snd_soc_new_compress symbol:snd_dmaengine_pcm_prepare_slave_config symbol:snd_dmaengine_pcm_register symbol:snd_dmaengine_pcm_unregister
snd_pcm snd snd_pcm_dmaengine snd_compress

kernel/sound/soc/codecs/snd-soc-i-sabre-codec.ko.xz of:N*T*Caudiophonics,i_sabre_codecC* of:N*T*Caudiophonics,i_sabre_codec i2c:i_sabre_codec
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/codecs/snd-soc-pcm1794a.ko.xz of:N*T*Cti,pcm1794aC* of:N*T*Cti,pcm1794a
snd_soc_core

kernel/sound/soc/codecs/snd-soc-cs42xx8.ko.xz symbol:cs42xx8_regmap_config symbol:cs42448_data symbol:cs42888_data symbol:cs42xx8_probe symbol:cs42xx8_pm
snd_soc_core

kernel/sound/soc/codecs/snd-soc-wm8804.ko.xz symbol:wm8804_regmap_config symbol:wm8804_probe symbol:wm8804_remove symbol:wm8804_pm
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-spdif-tx.ko.xz platform:spdif_dit of:N*T*Clinux,spdif_ditC* of:N*T*Clinux,spdif_dit
snd_soc_core

kernel/sound/soc/codecs/snd-soc-cs4271.ko.xz of:N*T*Ccirrus,cs4271C* of:N*T*Ccirrus,cs4271 symbol:cs4271_dt_ids symbol:cs4271_regmap_config symbol:cs4271_probe
snd_soc_core snd

kernel/sound/soc/codecs/snd-soc-tas5713.ko.xz of:N*T*Cti,tas5713C* of:N*T*Cti,tas5713 i2c:tas5713
snd_soc_core regmap_i2c

kernel/sound/soc/codecs/snd-soc-pcm186x-i2c.ko.xz i2c:pcm1865 i2c:pcm1864 i2c:pcm1863 i2c:pcm1862 of:N*T*Cti,pcm1865C* of:N*T*Cti,pcm1865 of:N*T*Cti,pcm1864C* of:N*T*Cti,pcm1864 of:N*T*Cti,pcm1863C* of:N*T*Cti,pcm1863 of:N*T*Cti,pcm1862C* of:N*T*Cti,pcm1862
snd_soc_pcm186x regmap_i2c

kernel/sound/soc/codecs/snd-soc-pcm179x-codec.ko.xz symbol:pcm179x_regmap_config symbol:pcm179x_common_init
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-cs42xx8-i2c.ko.xz of:N*T*Ccirrus,cs42888C* of:N*T*Ccirrus,cs42888 of:N*T*Ccirrus,cs42448C* of:N*T*Ccirrus,cs42448 i2c:cs42888 i2c:cs42448
regmap_i2c snd_soc_cs42xx8

kernel/sound/soc/codecs/snd-soc-wm8804-i2c.ko.xz i2c:wm8804 of:N*T*Cwlf,wm8804C* of:N*T*Cwlf,wm8804
snd_soc_wm8804 regmap_i2c

kernel/sound/soc/codecs/snd-soc-pcm186x.ko.xz symbol:pcm186x_regmap symbol:pcm186x_probe
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-sigmadsp.ko.xz symbol:devm_sigmadsp_init symbol:sigmadsp_attach symbol:sigmadsp_setup symbol:sigmadsp_reset symbol:sigmadsp_restrict_params
snd snd_pcm

kernel/sound/soc/codecs/snd-soc-sigmadsp-i2c.ko.xz symbol:devm_sigmadsp_init_i2c
snd_soc_sigmadsp

kernel/sound/soc/codecs/snd-soc-adau1701.ko.xz i2c:adau1702 i2c:adau1701 i2c:adau1401a i2c:adau1401 of:N*T*Cadi,adau1701C* of:N*T*Cadi,adau1701
snd_soc_core snd_soc_sigmadsp snd_soc_sigmadsp_i2c snd_pcm

kernel/sound/soc/codecs/snd-soc-ad193x-i2c.ko.xz i2c:ad1937 i2c:ad1936
regmap_i2c snd_soc_ad193x

kernel/sound/soc/codecs/snd-soc-sgtl5000.ko.xz of:N*T*Cfsl,sgtl5000C* of:N*T*Cfsl,sgtl5000 i2c:sgtl5000
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/codecs/snd-soc-tas571x.ko.xz of:N*T*Cti,tas5733C* of:N*T*Cti,tas5733 of:N*T*Cti,tas5721C* of:N*T*Cti,tas5721 of:N*T*Cti,tas5719C* of:N*T*Cti,tas5719 of:N*T*Cti,tas5717C* of:N*T*Cti,tas5717 of:N*T*Cti,tas5711C* of:N*T*Cti,tas5711 of:N*T*Cti,tas5707C* of:N*T*Cti,tas5707 i2c:tas5733 i2c:tas5721 i2c:tas5719 i2c:tas5717 i2c:tas5711 i2c:tas5707
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-ad193x-spi.ko.xz spi:adau1328 spi:ad1939 spi:ad1938 spi:ad1934 spi:ad1933 spi:ad193x
snd_soc_ad193x regmap_spi

kernel/sound/soc/codecs/snd-soc-wm-adsp.ko.xz symbol:wm_adsp_fw_get symbol:wm_adsp_fw_put symbol:wm_adsp_fw_enum symbol:wm_adsp_control_add symbol:wm_adsp_write_ctl symbol:wm_adsp_read_ctl symbol:wm_adsp1_init symbol:wm_adsp1_event symbol:wm_adsp2_set_dspclk symbol:wm_adsp2_preloader_get symbol:wm_adsp2_preloader_put symbol:wm_adsp_power_up symbol:wm_adsp_power_down symbol:wm_adsp_early_event symbol:wm_adsp_run symbol:wm_adsp_stop symbol:wm_adsp_event symbol:wm_adsp2_component_probe symbol:wm_adsp2_component_remove symbol:wm_adsp2_init symbol:wm_halo_init symbol:wm_adsp2_remove symbol:wm_adsp_compr_open symbol:wm_adsp_compr_free symbol:wm_adsp_compr_set_params symbol:wm_adsp_compr_get_caps symbol:wm_adsp_compr_trigger symbol:wm_adsp_compr_handle_irq symbol:wm_adsp_compr_pointer symbol:wm_adsp_compr_copy symbol:wm_adsp2_bus_error symbol:wm_halo_bus_error symbol:wm_halo_wdt_expire
cs_dsp snd_soc_core snd_compress

kernel/sound/soc/codecs/snd-soc-cs4271-i2c.ko.xz i2c:cs4271
snd_soc_cs4271 regmap_i2c

kernel/sound/soc/codecs/snd-soc-hdmi-codec.ko.xz platform:hdmi_audio_codec
snd_pcm snd snd_soc_core

kernel/sound/soc/codecs/snd-soc-dmic.ko.xz platform:dmic_codec of:N*T*Cdmic_codecC* of:N*T*Cdmic_codec
snd_soc_core

kernel/sound/soc/codecs/snd-soc-wm8741.ko.xz i2c:wm8741 of:N*T*Cwlf,wm8741C* of:N*T*Cwlf,wm8741
snd_soc_core regmap_i2c snd_pcm regmap_spi

kernel/sound/soc/codecs/snd-soc-tpa6130a2.ko.xz of:N*T*Cti,tpa6140a2C* of:N*T*Cti,tpa6140a2 of:N*T*Cti,tpa6130a2C* of:N*T*Cti,tpa6130a2 i2c:tpa6140a2 i2c:tpa6130a2
snd_soc_core regmap_i2c

kernel/sound/soc/codecs/snd-soc-wm5102.ko.xz platform:wm5102_codec
snd_soc_arizona snd_soc_core snd_soc_wm_adsp arizona

kernel/sound/soc/codecs/snd-soc-arizona.ko.xz symbol:arizona_init_spk symbol:arizona_init_spk_irqs symbol:arizona_free_spk_irqs symbol:arizona_init_mono symbol:arizona_init_gpio symbol:arizona_init_common symbol:arizona_init_vol_limit symbol:arizona_mixer_texts symbol:arizona_mixer_values symbol:arizona_mixer_tlv symbol:arizona_sample_rate_text symbol:arizona_sample_rate_val symbol:arizona_sample_rate_val_to_name symbol:arizona_rate_text symbol:arizona_rate_val symbol:arizona_isrc_fsh symbol:arizona_isrc_fsl symbol:arizona_asrc_rate1 symbol:arizona_in_vd_ramp symbol:arizona_in_vi_ramp symbol:arizona_out_vd_ramp symbol:arizona_out_vi_ramp symbol:arizona_lhpf1_mode symbol:arizona_lhpf2_mode symbol:arizona_lhpf3_mode symbol:arizona_lhpf4_mode symbol:arizona_ng_hold symbol:arizona_in_hpf_cut_enum symbol:arizona_in_dmic_osr symbol:arizona_anc_input_src symbol:arizona_anc_ng_enum symbol:arizona_output_anc_src symbol:arizona_voice_trigger_switch symbol:arizona_input_analog symbol:arizona_in_ev symbol:arizona_out_ev symbol:arizona_hp_ev symbol:arizona_dvfs_up symbol:arizona_dvfs_down symbol:arizona_dvfs_sysclk_ev symbol:arizona_init_dvfs symbol:arizona_anc_ev symbol:arizona_clk_ev symbol:arizona_set_sysclk symbol:arizona_dai_ops symbol:arizona_simple_dai_ops symbol:arizona_init_dai symbol:arizona_set_fll_refclk symbol:arizona_set_fll symbol:arizona_init_fll symbol:arizona_set_output_mode symbol:arizona_adsp2_rate_controls symbol:arizona_eq_coeff_put symbol:arizona_lhpf_coeff_put symbol:arizona_of_get_audio_pdata symbol:arizona_jack_codec_dev_probe symbol:arizona_jack_codec_dev_remove symbol:arizona_jack_set_jack
snd_soc_core arizona snd_pcm snd

kernel/sound/soc/codecs/snd-soc-adau7002.ko.xz of:N*T*Cadi,adau7002C* of:N*T*Cadi,adau7002
snd_soc_core

kernel/sound/soc/codecs/snd-soc-da7213.ko.xz i2c:da7213 of:N*T*Cdlg,da7213C* of:N*T*Cdlg,da7213 of:N*T*Cdlg,da7212C* of:N*T*Cdlg,da7212
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/codecs/snd-soc-spdif-rx.ko.xz of:N*T*Clinux,spdif_dirC* of:N*T*Clinux,spdif_dir
snd_soc_core

kernel/sound/soc/codecs/snd-soc-max98357a.ko.xz of:N*T*Cmaxim,max98360aC* of:N*T*Cmaxim,max98360a of:N*T*Cmaxim,max98357aC* of:N*T*Cmaxim,max98357a
snd_soc_core

kernel/sound/soc/codecs/snd-soc-ak4554.ko.xz of:N*T*Casahi_kasei,ak4554C* of:N*T*Casahi_kasei,ak4554
snd_soc_core

kernel/sound/soc/codecs/snd-soc-tlv320aic3x-i2c.ko.xz of:N*T*Cti,tlv320aic3106C* of:N*T*Cti,tlv320aic3106 of:N*T*Cti,tlv320aic3104C* of:N*T*Cti,tlv320aic3104 of:N*T*Cti,tlv320aic3007C* of:N*T*Cti,tlv320aic3007 of:N*T*Cti,tlv320aic33C* of:N*T*Cti,tlv320aic33 of:N*T*Cti,tlv320aic3xC* of:N*T*Cti,tlv320aic3x i2c:tlv320aic3106 i2c:tlv320aic3104 i2c:tlv320aic3007 i2c:tlv320aic33 i2c:tlv320aic3x
regmap_i2c snd_soc_tlv320aic3x

kernel/sound/soc/codecs/snd-soc-wm8960.ko.xz of:N*T*Cwlf,wm8960C* of:N*T*Cwlf,wm8960 i2c:wm8960
snd_soc_core regmap_i2c snd snd_pcm

kernel/sound/soc/codecs/snd-soc-wm8904.ko.xz of:N*T*Cwlf,wm8912C* of:N*T*Cwlf,wm8912 of:N*T*Cwlf,wm8904C* of:N*T*Cwlf,wm8904 i2c:wm8918 i2c:wm8912 i2c:wm8904
snd_soc_core regmap_i2c snd snd_pcm

kernel/sound/soc/codecs/snd-soc-tlv320aic23-i2c.ko.xz of:N*T*Cti,tlv320aic23C* of:N*T*Cti,tlv320aic23 i2c:tlv320aic23
regmap_i2c snd_soc_tlv320aic23

kernel/sound/soc/codecs/snd-soc-wm8731-i2c.ko.xz i2c:wm8731 of:N*T*Cwlf,wm8731C* of:N*T*Cwlf,wm8731
regmap_i2c snd_soc_wm8731

kernel/sound/soc/codecs/snd-soc-pcm5102a.ko.xz of:N*T*Cti,pcm5102aC* of:N*T*Cti,pcm5102a
snd_soc_core

kernel/sound/soc/codecs/snd-soc-tlv320aic23.ko.xz symbol:tlv320aic23_regmap symbol:tlv320aic23_probe
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-ad193x.ko.xz symbol:ad193x_regmap_config symbol:ad193x_probe
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-pcm3168a-i2c.ko.xz i2c:pcm3168a of:N*T*Cti,pcm3168aC* of:N*T*Cti,pcm3168a
snd_soc_pcm3168a regmap_i2c

kernel/sound/soc/codecs/snd-soc-tlv320aic32x4.ko.xz symbol:aic32x4_regmap_config symbol:aic32x4_probe symbol:aic32x4_remove symbol:aic32x4_register_clocks
snd_soc_core snd_pcm snd

kernel/sound/soc/codecs/snd-soc-pcm179x-i2c.ko.xz i2c:pcm179x of:N*T*Cti,pcm1792aC* of:N*T*Cti,pcm1792a
snd_soc_pcm179x_codec regmap_i2c

kernel/sound/soc/codecs/snd-soc-pcm3168a.ko.xz symbol:pcm3168a_regmap symbol:pcm3168a_probe symbol:pcm3168a_remove symbol:pcm3168a_pm_ops
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-ics43432.ko.xz of:N*T*Ccui,cmm_4030d_261C* of:N*T*Ccui,cmm_4030d_261 of:N*T*Cinvensense,ics43432C* of:N*T*Cinvensense,ics43432
snd_soc_core

kernel/sound/soc/codecs/snd-soc-pcm512x-i2c.ko.xz i2c:tas5756 i2c:tas5754 i2c:pcm5242 i2c:pcm5142 i2c:pcm5141 i2c:pcm5122 i2c:pcm5121 of:N*T*Cti,tas5756C* of:N*T*Cti,tas5756 of:N*T*Cti,tas5754C* of:N*T*Cti,tas5754 of:N*T*Cti,pcm5242C* of:N*T*Cti,pcm5242 of:N*T*Cti,pcm5142C* of:N*T*Cti,pcm5142 of:N*T*Cti,pcm5141C* of:N*T*Cti,pcm5141 of:N*T*Cti,pcm5122C* of:N*T*Cti,pcm5122 of:N*T*Cti,pcm5121C* of:N*T*Cti,pcm5121
snd_soc_pcm512x regmap_i2c

kernel/sound/soc/codecs/snd-soc-ma120x0p.ko.xz i2c:ma120x0p of:N*T*Cma,ma120x0pC* of:N*T*Cma,ma120x0p
snd_soc_core regmap_i2c

kernel/sound/soc/codecs/snd-soc-wm8731.ko.xz symbol:wm8731_init symbol:wm8731_regmap
snd_soc_core snd snd_pcm

kernel/sound/soc/codecs/snd-soc-pcm512x.ko.xz symbol:pcm512x_regmap symbol:pcm512x_probe symbol:pcm512x_remove symbol:pcm512x_pm_ops
snd_soc_core snd_pcm snd

kernel/sound/soc/codecs/snd-soc-tlv320aic32x4-i2c.ko.xz i2c:tas2505 i2c:tlv320aic32x6 i2c:tlv320aic32x4 of:N*T*Cti,tas2505C* of:N*T*Cti,tas2505 of:N*T*Cti,tlv320aic32x6C* of:N*T*Cti,tlv320aic32x6 of:N*T*Cti,tlv320aic32x4C* of:N*T*Cti,tlv320aic32x4
regmap_i2c snd_soc_tlv320aic32x4

kernel/sound/soc/codecs/snd-soc-adau1977.ko.xz symbol:adau1977_probe symbol:adau1977_regmap_config
snd_pcm snd_soc_core

kernel/sound/soc/codecs/snd-soc-adau1977-i2c.ko.xz of:N*T*Cadi,adau1979C* of:N*T*Cadi,adau1979 of:N*T*Cadi,adau1978C* of:N*T*Cadi,adau1978 of:N*T*Cadi,adau1977C* of:N*T*Cadi,adau1977 i2c:adau1979 i2c:adau1978 i2c:adau1977
regmap_i2c snd_soc_adau1977

kernel/sound/soc/codecs/snd-soc-tlv320aic3x.ko.xz symbol:aic3x_regmap symbol:aic3x_probe symbol:aic3x_remove
snd_soc_core snd_pcm

kernel/sound/soc/codecs/snd-soc-cs4265.ko.xz i2c:cs4265 of:N*T*Ccirrus,cs4265C* of:N*T*Ccirrus,cs4265
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/bcm/snd-soc-rpi-simple-soundcard.ko.xz of:N*T*Cpifi,pifi_mini_210C* of:N*T*Cpifi,pifi_mini_210 of:N*T*Cmerus,merus_ampC* of:N*T*Cmerus,merus_amp of:N*T*Crpi,rpi_dacC* of:N*T*Crpi,rpi_dac of:N*T*Cdionaudio,dionaudio_kiwiC* of:N*T*Cdionaudio,dionaudio_kiwi of:N*T*Chifiberry,hifiberry_dac8xC* of:N*T*Chifiberry,hifiberry_dac8x of:N*T*Chifiberry,hifiberry_dacC* of:N*T*Chifiberry,hifiberry_dac of:N*T*Chifiberry,hifiberry_amp3C* of:N*T*Chifiberry,hifiberry_amp3 of:N*T*Chifiberry,hifiberry_ampC* of:N*T*Chifiberry,hifiberry_amp of:N*T*Chifiberry,hifiberry_adc8xC* of:N*T*Chifiberry,hifiberry_adc8x of:N*T*Chifiberrydacplusdsp,hifiberrydacplusdsp_soundcardC* of:N*T*Chifiberrydacplusdsp,hifiberrydacplusdsp_soundcard of:N*T*Cgooglevoicehat,googlevoicehat_soundcardC* of:N*T*Cgooglevoicehat,googlevoicehat_soundcard of:N*T*Cadi,adau1977_adcC* of:N*T*Cadi,adau1977_adc
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-allo-piano-dac-plus.ko.xz of:N*T*Callo,piano_dac_plusC* of:N*T*Callo,piano_dac_plus
snd_soc_core snd

kernel/sound/soc/bcm/snd-soc-hifiberry-dacplushd.ko.xz of:N*T*Chifiberry,hifiberry_dacplushdC* of:N*T*Chifiberry,hifiberry_dacplushd
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-hifiberry-studio-dac8x.ko.xz of:N*T*Chifiberry,hifiberry_studio_dac8xC* of:N*T*Chifiberry,hifiberry_studio_dac8x
regmap_i2c snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-justboom-both.ko.xz of:N*T*Cjustboom,justboom_bothC* of:N*T*Cjustboom,justboom_both
snd_soc_core

kernel/sound/soc/bcm/snd-soc-pifi-40.ko.xz of:N*T*Cpifi,pifi_40C* of:N*T*Cpifi,pifi_40
snd_soc_core snd

kernel/sound/soc/bcm/snd-soc-rpi-wm8804-soundcard.ko.xz of:N*T*Cinterludeaudio,interludeaudio_digitalC* of:N*T*Cinterludeaudio,interludeaudio_digital of:N*T*Chifiberry,hifiberry_digiC* of:N*T*Chifiberry,hifiberry_digi of:N*T*Callo,allo_digioneC* of:N*T*Callo,allo_digione of:N*T*Ciqaudio,wm8804_digiC* of:N*T*Ciqaudio,wm8804_digi of:N*T*Cjustboom,justboom_digiC* of:N*T*Cjustboom,justboom_digi
snd_soc_core

kernel/sound/soc/bcm/snd-soc-i-sabre-q2m.ko.xz of:N*T*Caudiophonics,i_sabre_q2mC* of:N*T*Caudiophonics,i_sabre_q2m
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-allo-boss-dac.ko.xz of:N*T*Callo,boss_dacC* of:N*T*Callo,boss_dac
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-audiosense-pi.ko.xz platform:audiosense_pi of:N*T*Cas,audiosense_piC* of:N*T*Cas,audiosense_pi
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-hifiberry-dacplus.ko.xz of:N*T*Chifiberry,hifiberry_dacplusC* of:N*T*Chifiberry,hifiberry_dacplus
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-audioinjector-pi-soundcard.ko.xz platform:audioinjector_pi_soundcard of:N*T*Cai,audioinjector_pi_soundcardC* of:N*T*Cai,audioinjector_pi_soundcard
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-audioinjector-isolated-soundcard.ko.xz platform:audioinjector_isolated_soundcard of:N*T*Cai,audioinjector_isolated_soundcardC* of:N*T*Cai,audioinjector_isolated_soundcard
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-googlevoicehat-codec.ko.xz of:N*T*Cgoogle,voicehatC* of:N*T*Cgoogle,voicehat
snd_soc_core

kernel/sound/soc/bcm/snd-soc-hifiberry-dacplusdsp.ko.xz of:N*T*Chifiberry,dacplusdspC* of:N*T*Chifiberry,dacplusdsp
snd_soc_core

kernel/sound/soc/bcm/snd-soc-rpi-cirrus.ko.xz of:N*T*Cwlf,rpi_cirrusC* of:N*T*Cwlf,rpi_cirrus
snd_soc_core snd_pcm snd

kernel/sound/soc/bcm/snd-soc-allo-katana-codec.ko.xz of:N*T*Callo,allo_katana_codecC* of:N*T*Callo,allo_katana_codec i2c:allo_katana_codec
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/bcm/snd-soc-dionaudio-loco.ko.xz of:N*T*Cdionaudio,loco_pcm5242_tpa3118C* of:N*T*Cdionaudio,loco_pcm5242_tpa3118
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-iqaudio-dac.ko.xz of:N*T*Ciqaudio,iqaudio_dacC* of:N*T*Ciqaudio,iqaudio_dac
snd_soc_core

kernel/sound/soc/bcm/snd-soc-chipdip-dac.ko.xz of:N*T*Cchipdip,chipdip_dacC* of:N*T*Cchipdip,chipdip_dac
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-dacberry400.ko.xz platform:dacberry400 of:N*T*Cosaelectronics,dacberry400C* of:N*T*Cosaelectronics,dacberry400
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-hifiberry-dacplusadcpro.ko.xz of:N*T*Chifiberry,hifiberry_dacplusadcproC* of:N*T*Chifiberry,hifiberry_dacplusadcpro
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-iqaudio-codec.ko.xz of:N*T*Ciqaudio,iqaudio_codecC* of:N*T*Ciqaudio,iqaudio_codec
snd_soc_core

kernel/sound/soc/bcm/snd-soc-bcm2835-i2s.ko.xz platform:bcm2835_i2s of:N*T*Cbrcm,bcm2835_i2sC* of:N*T*Cbrcm,bcm2835_i2s
snd_pcm snd_soc_core

kernel/sound/soc/bcm/snd-soc-pisound.ko.xz of:N*T*Cblokaslabs,pisound_spiC* of:N*T*Cblokaslabs,pisound_spi of:N*T*Cblokaslabs,pisoundC* of:N*T*Cblokaslabs,pisound
snd_rawmidi snd_soc_core snd snd_pcm

kernel/sound/soc/bcm/snd-soc-audioinjector-octo-soundcard.ko.xz platform:audioinjector_octo_soundcard of:N*T*Cai,audioinjector_octo_soundcardC* of:N*T*Cai,audioinjector_octo_soundcard
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-fe-pi-audio.ko.xz of:N*T*Cfe_pi,fe_pi_audioC* of:N*T*Cfe_pi,fe_pi_audio
snd_soc_core

kernel/sound/soc/bcm/snd-soc-rpi-proto.ko.xz of:N*T*Crpi,rpi_protoC* of:N*T*Crpi,rpi_proto
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-hifiberry-dacplusadc.ko.xz of:N*T*Chifiberry,hifiberry_dacplusadcC* of:N*T*Chifiberry,hifiberry_dacplusadc
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-dionaudio-loco-v2.ko.xz of:N*T*Cdionaudio,dionaudio_loco_v2C* of:N*T*Cdionaudio,dionaudio_loco_v2
snd_soc_core

kernel/sound/soc/bcm/snd-soc-hifiberry-adc.ko.xz of:N*T*Chifiberry,hifiberry_adcC* of:N*T*Chifiberry,hifiberry_adc
snd_soc_core snd_pcm

kernel/sound/soc/bcm/snd-soc-allo-boss2-dac.ko.xz of:N*T*Callo,allo_cs43198C* of:N*T*Callo,allo_cs43198 i2c:allo_cs43198
snd_soc_core regmap_i2c snd_pcm

kernel/sound/soc/bcm/snd-soc-allo-piano-dac.ko.xz of:N*T*Callo,piano_dacC* of:N*T*Callo,piano_dac
snd_soc_core

kernel/sound/soc/bcm/snd-soc-justboom-dac.ko.xz of:N*T*Cjustboom,justboom_dacC* of:N*T*Cjustboom,justboom_dac
snd_soc_core

kernel/sound/soc/bcm/snd-soc-digidac1-soundcard.ko.xz of:N*T*Crra,digidac1_soundcardC* of:N*T*Crra,digidac1_soundcard
snd_soc_core snd snd_pcm

kernel/sound/soc/raspberrypi/rp1_aout.ko.xz of:N*T*Craspberrypi,rp1_audio_outC* of:N*T*Craspberrypi,rp1_audio_out
snd_soc_core

kernel/sound/soc/generic/snd-soc-simple-card-utils.ko.xz symbol:simple_util_get_sample_fmt symbol:simple_util_parse_convert symbol:simple_util_is_convert_required symbol:simple_util_parse_daifmt symbol:simple_util_parse_tdm_width_map symbol:simple_util_set_dailink_name symbol:simple_util_parse_card_name symbol:simple_util_parse_clk symbol:simple_util_startup symbol:simple_util_shutdown symbol:simple_util_hw_params symbol:simple_util_be_hw_params_fixup symbol:simple_util_dai_init symbol:simple_util_canonicalize_platform symbol:simple_util_canonicalize_cpu symbol:simple_util_clean_reference symbol:simple_util_parse_routing symbol:simple_util_parse_widgets symbol:simple_util_parse_pin_switches symbol:simple_util_init_jack symbol:simple_util_init_aux_jacks symbol:simple_util_init_priv symbol:simple_util_remove symbol:graph_util_card_probe symbol:graph_util_is_ports0 symbol:graph_util_parse_dai symbol:graph_util_parse_link_direction symbol:graph_util_parse_trigger_order
snd_soc_core snd_pcm

kernel/sound/soc/generic/snd-soc-audio-graph-card.ko.xz platform:asoc_audio_graph_card of:N*T*Caudio_graph_scu_cardC* of:N*T*Caudio_graph_scu_card of:N*T*Caudio_graph_cardC* of:N*T*Caudio_graph_card symbol:audio_graph_parse_of
snd_soc_simple_card_utils snd_soc_core

kernel/sound/soc/generic/snd-soc-simple-card.ko.xz platform:asoc_simple_card of:N*T*Csimple_scu_audio_cardC* of:N*T*Csimple_scu_audio_card of:N*T*Csimple_audio_cardC* of:N*T*Csimple_audio_card
snd_soc_core snd_soc_simple_card_utils

kernel/sound/drivers/snd-dummy.ko.xz
snd snd_pcm

kernel/sound/drivers/snd-mtpav.ko.xz
snd_rawmidi snd

kernel/sound/drivers/snd-virmidi.ko.xz
snd snd_seq_virmidi

kernel/sound/drivers/upisnd/snd-soc-upisnd-codec.ko.xz i2c:upisnd_codec of:N*T*Cblokas,upisnd_codecC* of:N*T*Cblokas,upisnd_codec symbol:adau1961_set_vgnd_shorted symbol:adau1961_is_hp_capless
snd_soc_core regmap_i2c snd snd_pcm

kernel/sound/drivers/upisnd/snd-soc-upisnd-ctrl.ko.xz of:N*T*Cblokas,pisound_microC* of:N*T*Cblokas,pisound_micro of:N*T*Cblokas,upisnd_ctrlC* of:N*T*Cblokas,upisnd_ctrl i2c:blokas,upisnd_ctrl
snd_soc_upisnd_codec snd_rawmidi snd_soc_core snd crc8

kernel/sound/drivers/snd-aloop.ko.xz
snd_timer snd snd_pcm

kernel/sound/drivers/snd-serial-u16550.ko.xz
snd_rawmidi snd

kernel/sound/drivers/mpu401/snd-mpu401.ko.xz
snd snd_mpu401_uart

kernel/sound/drivers/mpu401/snd-mpu401-uart.ko.xz symbol:snd_mpu401_uart_interrupt symbol:snd_mpu401_uart_interrupt_tx symbol:snd_mpu401_uart_new
snd_rawmidi snd

kernel/sound/drivers/snd-pimidi.ko.xz i2c:pimidi of:N*T*Cblokaslabs,pimidiC* of:N*T*Cblokaslabs,pimidi
snd_rawmidi snd crc8

kernel/sound/usb/6fire/snd-usb-6fire.ko.xz usb:v0CCDp0080d*dc*dsc*dp*ic*isc*ip*in*
snd_rawmidi snd snd_pcm

kernel/sound/usb/snd-usb-audio.ko.xz usb:v*p*d*dc*dsc*dp*ic01isc01ip*in* usb:v2A39p3FA0d*dc*dsc*dp*icFFisc*ip*in00* usb:v2A39p3F8Cd*dc*dsc*dp*icFFisc*ip*in00* usb:vFFADpA001d*dc*dsc*dp*icFFisc*ip*in* usb:v2B53p0031d*dc*dsc*dp*ic*isc*ip*in* usb:v2B53p0024d*dc*dsc*dp*ic*isc*ip*in* usb:v2B53p0023d*dc*dsc*dp*ic*isc*ip*in* usb:v1395p0300d*dc*dsc*dp*ic*isc*ip*in* usb:v2B73p0013d*dc*dsc*dp*icFFisc*ip*in* usb:v08E4p0163d*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p001Bd*dc*dsc*dp*icFFisc*ip*in* usb:v08E4p017Fd*dc*dsc*dp*icFFisc*ip*in* usb:v534Dp2109d*dc*dsc*dp*ic01isc01ip*in* usb:v534Dp0021d*dc*dsc*dp*ic01isc01ip*in* usb:v2B73p0029d*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p000Ad*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p001Ed*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p000Dd*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p000Ed*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p0017d*dc*dsc*dp*icFFisc*ip*in* usb:v2B73p0023d*dc*dsc*dp*icFFisc*ip*in* usb:v07FDp0004d*dc*dsc*dp*icFFisc*ip*in* usb:v19B5p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v13E5p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v*p*d*dc*dsc*dp*ic01isc03ip*in* usb:v1686p00DDd*dc*dsc*dp*ic*isc*ip*in* usb:v200Cp100Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0283d*dc*dsc*dp*ic*isc*ip*in* usb:v154Ep500Ed*dc*dsc*dp*ic01isc01ip*in* usb:v0644p8021d*dc*dsc*dp*icFFisc*ip*in* usb:v0DBAp5000d*dc*dsc*dp*ic*isc*ip*in* usb:v0DBAp3000d*dc*dsc*dp*ic*isc*ip*in* usb:v0DBAp1000d*dc*dsc*dp*ic*isc*ip*in* usb:v7104p2202d*dc*dsc*dp*ic*isc*ip*in* usb:v4752p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v1F38p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1A86p752Dd*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1020d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1010d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1000d*dc*dsc*dp*ic*isc*ip*in* usb:v133Ep0815d*dc*dsc*dp*icFFisc*ip*in* usb:v1235p4661d*dc*dsc*dp*icFFisc*ip*in* usb:v1235p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v1235p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v1235p000Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1235p000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1235p0002d*dc*dsc*dp*icFFisc*ip*in* usb:v1235p0001d*dc*dsc*dp*icFFisc*ip*in* usb:v103Dp0101d*dc*dsc*dp*ic*isc*ip*in* usb:v103Dp0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0035d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0014d*dc*dsc*dp*icFFisc*ip*in* usb:v0CCDp0013d*dc*dsc*dp*icFFisc*ip*in* usb:v0CCDp0012d*dc*dsc*dp*icFFisc*ip*in* usb:v0A4Ep4040d*dc*dsc*dp*icFFisc*ip*in* usb:v0A4Ep2040d*dc*dsc*dp*icFFisc*ip*in* usb:v09E8p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v09E8p0062d*dc*dsc*dp*ic*isc*ip*in* usb:v0944p0204d*dc*dsc*dp*icFFisc*ip*in* usb:v0944p0201d*dc*dsc*dp*icFFisc*ip*in* usb:v0944p0200d*dc*dsc*dp*icFFisc*ip*in* usb:v086Ap0003d*dc*dsc*dp*ic*isc*ip*in* usb:v086Ap0002d*dc*dsc*dp*ic*isc*ip*in* usb:v086Ap0001d*dc*dsc*dp*ic*isc*ip*in* usb:v07FDp0001d*dc*dsc02dp*ic*isc*ip*in* usb:v07CFp6802d*dc*dsc*dp*ic*isc*ip*in* usb:v07CFp6801d*dc*dsc*dp*ic*isc*ip*in* usb:v0763p2081d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2080d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2031d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2030d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p201Ad*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2019d*dc*dsc*dp*ic*isc*ip*in* usb:v0763p200Dd*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2008d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2003d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p2001d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1041d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1033d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1031d010dc*dsc*dp*ic*isc*ip*in* usb:v0763p1021d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1015d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1011d*dc*dsc*dp*icFFisc*ip*in* usb:v0763p1002d*dc*dsc*dp*icFFisc*ip*in* usb:v06F8pB000d*dc*dsc*dp*icFFisc*ip*in* usb:v0582p*d*dc*dsc*dp*icFFisc*ip*in* usb:v0582p008Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p007Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0044d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0159d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p012Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0120d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0113d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0108d*dc*dsc*dp*icFFisc*ip*in* usb:v0582p00E6d*dc*dsc*dp*icFFisc*ip*in* usb:v0582p00C4d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p00A3d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p008Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0080d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p007Ad*dc*dsc*dp*icFFisc*ip*in* usb:v0582p0075d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0074d*dc*dsc*dp*icFFisc*ip*in* usb:v0582p006Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0065d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0064d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0060d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0052d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0050d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p004Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p004Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0048d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0047d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0042d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0040d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p003Bd*dc*dsc*dp*icFFisc*ip*in* usb:v0582p0037d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0033d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p002Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p002Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p002Bd*dc*dsc*dp*icFFisc*ip*in* usb:v0582p0029d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0027d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0025d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0023d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p001Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p001Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0016d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0014d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p000Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0007d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0000d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p*d*dc*dsc*dp*icFFisc*ip*in* usb:v0499p7010d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p7000d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p500Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5009d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5008d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5007d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5006d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5005d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5004d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5003d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5002d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5001d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p5000d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p2003d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p2001d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1718d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p150Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p150Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1509d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1507d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1503d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p105Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p105Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p105Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p105Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1059d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1058d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1057d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1056d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1055d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1054d*dc*dsc*dp*icFFisc*ip*in* usb:v0499p1053d*dc*dsc*dp*icFFisc*ip*in* usb:v0499p1052d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1051d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1050d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p104Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p104Ed*dc*dsc*dp*icFFisc*ip*in* usb:v0499p1045d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1044d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1043d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1042d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1041d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1040d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p103Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1039d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1038d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1037d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1036d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1035d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1034d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1033d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1032d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1031d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1030d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p102Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0499p102Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p102Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1029d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1028d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1027d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1026d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1025d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1024d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1023d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1022d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1021d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1020d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p101Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1019d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1018d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1017d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1016d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1015d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1014d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1013d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1012d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1011d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1010d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p100Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p100Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0499p100Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p100Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0499p100Ad*dc*dsc*dp*icFFisc*ip*in* usb:v0499p1009d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1008d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1007d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1006d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1005d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1004d*dc*dsc*dp*icFFisc*ip*in* usb:v0499p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0499p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0990d*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp08F6d*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp08F5d*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp08F0d*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp08C6d*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp08AEd*dc*dsc*dp*ic01isc01ip*in* usb:v046Dp0850d*dc*dsc*dp*ic01isc01ip*in* usb:v0424pB832d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4095d*dc*dsc*dp*ic01isc01ip*in* usb:v31B2p0011d*dc*dsc*dp*icFFisc*ip*in* usb:v041Ep3F19d*dc*dsc*dp*icFFisc*ip*in* usb:v041Ep3F0Ad*dc*dsc*dp*icFFisc*ip*in* usb:v041Ep3F04d*dc*dsc*dp*icFFisc*ip*in* usb:v041Ep3F02d*dc*dsc*dp*icFFisc*ip*in* usb:v041Ep0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pB8D8d*dc*dsc*dp*ic*isc*ip*in*
mc snd snd_pcm snd_usbmidi_lib snd_hwdep

kernel/sound/usb/caiaq/snd-usb-caiaq.ko.xz usb:v17CCp0808d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp041Dd*dc*dsc*dp*ic*isc*ip*in* usb:v17CCpBAFFd*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp2305d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp041Cd*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp0839d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp0D8Dd*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1915d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1978d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp0815d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp4712d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp4711d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1940d*dc*dsc*dp*ic*isc*ip*in* usb:v17CCp1969d*dc*dsc*dp*ic*isc*ip*in*
snd_rawmidi snd_pcm snd

kernel/sound/usb/snd-usbmidi-lib.ko.xz symbol:snd_usbmidi_disconnect symbol:snd_usbmidi_input_stop symbol:snd_usbmidi_input_start symbol:snd_usbmidi_suspend symbol:snd_usbmidi_resume symbol:__snd_usbmidi_create
snd_rawmidi snd

kernel/sound/usb/hiface/snd-usb-hiface.ko.xz usb:v25C6p9002d*dc*dsc*dp*ic*isc*ip*in* usb:v245Fp931Cd*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp932Cd*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp931Cd*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp9008d*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp9006d*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp9002d*dc*dsc*dp*ic*isc*ip*in* usb:v249Cp9001d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p9321d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p9320d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p931Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p931Ed*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p931Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p931Cd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p931Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p930Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p0384d*dc*dsc*dp*ic*isc*ip*in*
snd_pcm snd

kernel/sound/usb/line6/snd-usb-line6.ko.xz symbol:line6_midi_id symbol:line6_send_raw_message symbol:line6_send_raw_message_async symbol:line6_version_request_async symbol:line6_send_sysex_message symbol:line6_alloc_sysex_buffer symbol:line6_read_data symbol:line6_write_data symbol:line6_read_serial_number symbol:line6_probe symbol:line6_disconnect symbol:line6_suspend symbol:line6_resume symbol:line6_init_midi symbol:line6_pcm_acquire symbol:line6_pcm_release symbol:line6_init_pcm
snd_rawmidi snd snd_pcm snd_hwdep

kernel/sound/usb/line6/snd-usb-toneport.ko.xz usb:v0E41p4142d*dc*dsc*dp*ic*isc*ip*in00* usb:v0E41p4141d*dc*dsc*dp*ic*isc*ip*in* usb:v0E41p4147d*dc*dsc*dp*ic*isc*ip*in* usb:v0E41p4151d*dc*dsc*dp*ic*isc*ip*in00* usb:v0E41p4150d*dc*dsc*dp*ic*isc*ip*in* usb:v0E41p4153d*dc*dsc*dp*ic*isc*ip*in* usb:v0E41p4750d*dc*dsc*dp*ic*isc*ip*in*
snd snd_usb_line6

kernel/sound/usb/misc/snd-ua101.ko.xz usb:v0582p008Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p007Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0582p0044d*dc*dsc*dp*ic*isc*ip*in*
snd_pcm snd snd_usbmidi_lib

kernel/arch/arm64/crypto/poly1305-neon.ko.xz crypto_poly1305_neon poly1305_neon crypto_poly1305 poly1305 symbol:poly1305_init_arch symbol:poly1305_update_arch symbol:poly1305_final_arch

kernel/arch/arm64/crypto/sha2-ce.ko.xz crypto_sha256 sha256 crypto_sha224 sha224 cpu:type:*:feature:*0006*
sha256_arm64

kernel/arch/arm64/crypto/sm4-ce-cipher.ko.xz crypto_sm4_ce sm4_ce crypto_sm4 sm4 cpu:type:*:feature:*0013*
sm4

kernel/arch/arm64/crypto/aes-neon-blk.ko.xz symbol:neon_aes_ecb_encrypt symbol:neon_aes_cbc_encrypt symbol:neon_aes_ctr_encrypt symbol:neon_aes_xts_encrypt symbol:neon_aes_xts_decrypt
libaes

kernel/arch/arm64/crypto/aes-arm64.ko.xz crypto_aes aes crypto_cbcmac(aes) cbcmac(aes) crypto_xcbc(aes) xcbc(aes) crypto_cmac(aes) cmac(aes) crypto_essiv(cbc(aes),sha256) essiv(cbc(aes),sha256) crypto_cts(cbc(aes)) cts(cbc(aes)) crypto_xctr(aes) xctr(aes) crypto_xts(aes) xts(aes) crypto_ctr(aes) ctr(aes) crypto_cbc(aes) cbc(aes) crypto_ecb(aes) ecb(aes)
aes_generic libaes

kernel/arch/arm64/crypto/aes-ce-blk.ko.xz crypto_cbcmac(aes) cbcmac(aes) crypto_xcbc(aes) xcbc(aes) crypto_cmac(aes) cmac(aes) crypto_essiv(cbc(aes),sha256) essiv(cbc(aes),sha256) crypto_cts(cbc(aes)) cts(cbc(aes)) crypto_xctr(aes) xctr(aes) crypto_xts(aes) xts(aes) crypto_ctr(aes) ctr(aes) crypto_cbc(aes) cbc(aes) crypto_ecb(aes) ecb(aes) cpu:type:*:feature:*0003* symbol:ce_aes_mac_update
aes_ce_cipher libaes

kernel/arch/arm64/crypto/aes-ce-ccm.ko.xz crypto_ccm(aes) ccm(aes)
aes_ce_cipher aes_ce_blk

kernel/arch/arm64/crypto/sm3-ce.ko.xz cpu:type:*:feature:*0012*
sm3

kernel/arch/arm64/crypto/sha512-arm64.ko.xz crypto_sha512 sha512 crypto_sha384 sha384 symbol:sha512_block_data_order

kernel/arch/arm64/crypto/sha1-ce.ko.xz crypto_sha1 sha1 cpu:type:*:feature:*0005*
sha1_generic

kernel/arch/arm64/crypto/aes-ce-cipher.ko.xz cpu:type:*:feature:*0003* symbol:ce_aes_expandkey symbol:ce_aes_setkey
libaes

kernel/arch/arm64/crypto/sha3-ce.ko.xz crypto_sha3_512 sha3_512 crypto_sha3_384 sha3_384 crypto_sha3_256 sha3_256 crypto_sha3_224 sha3_224 cpu:type:*:feature:*0011*
sha3_generic

kernel/arch/arm64/crypto/sha256-arm64.ko.xz crypto_sha256 sha256 crypto_sha224 sha224 symbol:sha256_block_data_order

kernel/arch/arm64/crypto/nhpoly1305-neon.ko.xz crypto_nhpoly1305_neon nhpoly1305_neon crypto_nhpoly1305 nhpoly1305
nhpoly1305

kernel/arch/arm64/crypto/ghash-ce.ko.xz crypto_ghash ghash cpu:type:*:feature:*0004*
libaes gf128mul

kernel/arch/arm64/crypto/sha512-ce.ko.xz crypto_sha512 sha512 crypto_sha384 sha384 cpu:type:*:feature:*0015*
sha512_arm64

kernel/arch/arm64/crypto/chacha-neon.ko.xz crypto_xchacha12_neon xchacha12_neon crypto_xchacha12 xchacha12 crypto_xchacha20_neon xchacha20_neon crypto_xchacha20 xchacha20 crypto_chacha20_neon chacha20_neon crypto_chacha20 chacha20 symbol:hchacha_block_arch symbol:chacha_init_arch symbol:chacha_crypt_arch
libchacha

kernel/arch/arm64/crypto/aes-neon-bs.ko.xz
libaes aes_neon_blk

kernel/arch/arm64/lib/xor-neon.ko.xz symbol:xor_block_inner_neon

kernel/crypto/lz4hc.ko.xz crypto_lz4hc lz4hc
lz4hc_compress

kernel/crypto/cast_common.ko.xz symbol:cast_s1 symbol:cast_s2 symbol:cast_s3 symbol:cast_s4

kernel/crypto/authenc.ko.xz crypto_authenc authenc symbol:crypto_authenc_extractkeys
crypto_null

kernel/crypto/sha3_generic.ko.xz crypto_sha3_512_generic sha3_512_generic crypto_sha3_512 sha3_512 crypto_sha3_384_generic sha3_384_generic crypto_sha3_384 sha3_384 crypto_sha3_256_generic sha3_256_generic crypto_sha3_256 sha3_256 crypto_sha3_224_generic sha3_224_generic crypto_sha3_224 sha3_224 symbol:crypto_sha3_init symbol:crypto_sha3_update symbol:crypto_sha3_final

kernel/crypto/chacha_generic.ko.xz crypto_xchacha12_generic xchacha12_generic crypto_xchacha12 xchacha12 crypto_xchacha20_generic xchacha20_generic crypto_xchacha20 xchacha20 crypto_chacha20_generic chacha20_generic crypto_chacha20 chacha20
libchacha

kernel/crypto/lz4.ko.xz crypto_lz4 lz4
lz4_compress

kernel/crypto/algif_hash.ko.xz
af_alg

kernel/crypto/adiantum.ko.xz crypto_adiantum adiantum
libpoly1305

kernel/crypto/async_tx/async_pq.ko.xz symbol:async_gen_syndrome symbol:async_syndrome_val
async_tx raid6_pq async_xor

kernel/crypto/async_tx/async_xor.ko.xz symbol:async_xor_offs symbol:async_xor symbol:async_xor_val_offs symbol:async_xor_val
async_tx xor

kernel/crypto/async_tx/async_memcpy.ko.xz symbol:async_memcpy
async_tx

kernel/crypto/async_tx/async_tx.ko.xz symbol:__async_tx_find_channel symbol:async_tx_submit symbol:async_trigger_callback symbol:async_tx_quiesce

kernel/crypto/async_tx/async_raid6_recov.ko.xz symbol:async_raid6_2data_recov symbol:async_raid6_datap_recov
async_tx raid6_pq

kernel/crypto/crypto_null.ko.xz crypto_cipher_null cipher_null crypto_digest_null digest_null crypto_compress_null compress_null symbol:crypto_get_default_null_skcipher symbol:crypto_put_default_null_skcipher

kernel/crypto/sm3.ko.xz symbol:sm3_update symbol:sm3_final

kernel/crypto/aes_generic.ko.xz crypto_aes_generic aes_generic crypto_aes aes symbol:crypto_ft_tab symbol:crypto_it_tab symbol:crypto_aes_set_key
libaes

kernel/crypto/sm4.ko.xz symbol:crypto_sm4_fk symbol:crypto_sm4_ck symbol:crypto_sm4_sbox symbol:sm4_expandkey symbol:sm4_crypt_block

kernel/crypto/drbg.ko.xz crypto_stdrng stdrng crypto_drbg_nopr_hmac_sha256 drbg_nopr_hmac_sha256 crypto_drbg_pr_hmac_sha256 drbg_pr_hmac_sha256 crypto_drbg_nopr_hmac_sha384 drbg_nopr_hmac_sha384 crypto_drbg_pr_hmac_sha384 drbg_pr_hmac_sha384 crypto_drbg_nopr_hmac_sha512 drbg_nopr_hmac_sha512 crypto_drbg_pr_hmac_sha512 drbg_pr_hmac_sha512

kernel/crypto/wp512.ko.xz crypto_wp256 wp256 crypto_wp384 wp384 crypto_wp512 wp512

kernel/crypto/twofish_common.ko.xz symbol:__twofish_setkey symbol:twofish_setkey

kernel/crypto/sha1_generic.ko.xz crypto_sha1_generic sha1_generic crypto_sha1 sha1 symbol:sha1_zero_message_hash symbol:crypto_sha1_update symbol:crypto_sha1_finup

kernel/crypto/echainiv.ko.xz crypto_echainiv echainiv
geniv

kernel/crypto/essiv.ko.xz crypto_essiv essiv
authenc

kernel/crypto/asymmetric_keys/pkcs8_key_parser.ko.xz

kernel/crypto/cryptd.ko.xz crypto_cryptd cryptd symbol:cryptd_alloc_skcipher symbol:cryptd_skcipher_child symbol:cryptd_skcipher_queued symbol:cryptd_free_skcipher symbol:cryptd_alloc_ahash symbol:cryptd_ahash_child symbol:cryptd_shash_desc symbol:cryptd_ahash_queued symbol:cryptd_free_ahash symbol:cryptd_alloc_aead symbol:cryptd_aead_child symbol:cryptd_aead_queued symbol:cryptd_free_aead

kernel/crypto/af_alg.ko.xz net_pf_38 symbol:af_alg_register_type symbol:af_alg_unregister_type symbol:af_alg_release symbol:af_alg_release_parent symbol:af_alg_accept symbol:af_alg_free_sg symbol:af_alg_count_tsgl symbol:af_alg_pull_tsgl symbol:af_alg_wmem_wakeup symbol:af_alg_wait_for_data symbol:af_alg_sendmsg symbol:af_alg_free_resources symbol:af_alg_async_cb symbol:af_alg_poll symbol:af_alg_alloc_areq symbol:af_alg_get_rsgl

kernel/crypto/ctr.ko.xz crypto_ctr ctr crypto_rfc3686 rfc3686

kernel/crypto/geniv.ko.xz symbol:aead_geniv_alloc symbol:aead_init_geniv symbol:aead_exit_geniv
crypto_null

kernel/crypto/twofish_generic.ko.xz crypto_twofish_generic twofish_generic crypto_twofish twofish
twofish_common

kernel/crypto/md5.ko.xz crypto_md5 md5 symbol:md5_zero_message_hash

kernel/crypto/chacha20poly1305.ko.xz crypto_rfc7539esp rfc7539esp crypto_rfc7539 rfc7539

kernel/crypto/poly1305_generic.ko.xz crypto_poly1305_generic poly1305_generic crypto_poly1305 poly1305
libpoly1305

kernel/crypto/xcbc.ko.xz crypto_xcbc xcbc

kernel/crypto/zstd.ko.xz crypto_zstd zstd

kernel/crypto/algif_rng.ko.xz
af_alg

kernel/crypto/xor.ko.xz symbol:xor_blocks
xor_neon

kernel/crypto/ccm.ko.xz crypto_cbcmac cbcmac crypto_ccm ccm crypto_rfc4309 rfc4309 crypto_ccm_base ccm_base

kernel/crypto/nhpoly1305.ko.xz crypto_nhpoly1305_generic nhpoly1305_generic crypto_nhpoly1305 nhpoly1305 symbol:crypto_nhpoly1305_setkey symbol:crypto_nhpoly1305_init symbol:crypto_nhpoly1305_update_helper symbol:crypto_nhpoly1305_update symbol:crypto_nhpoly1305_final_helper symbol:crypto_nhpoly1305_final
libpoly1305

kernel/crypto/xxhash_generic.ko.xz crypto_xxhash64_generic xxhash64_generic crypto_xxhash64 xxhash64

kernel/crypto/authencesn.ko.xz crypto_authencesn authencesn
authenc crypto_null

kernel/crypto/algif_skcipher.ko.xz
af_alg

kernel/crypto/blake2b_generic.ko.xz crypto_blake2b_512_generic blake2b_512_generic crypto_blake2b_512 blake2b_512 crypto_blake2b_384_generic blake2b_384_generic crypto_blake2b_384 blake2b_384 crypto_blake2b_256_generic blake2b_256_generic crypto_blake2b_256 blake2b_256 crypto_blake2b_160_generic blake2b_160_generic crypto_blake2b_160 blake2b_160 symbol:blake2b_compress_generic

kernel/crypto/md4.ko.xz crypto_md4 md4

kernel/crypto/cast5_generic.ko.xz crypto_cast5_generic cast5_generic crypto_cast5 cast5 symbol:__cast5_encrypt symbol:__cast5_decrypt symbol:cast5_setkey
cast_common

kernel/crypto/algif_aead.ko.xz
af_alg crypto_null

kernel/crypto/ecdh_generic.ko.xz crypto_ecdh ecdh symbol:crypto_ecdh_key_len symbol:crypto_ecdh_encode_key symbol:crypto_ecdh_decode_key
ecc

kernel/crypto/ghash-generic.ko.xz crypto_ghash_generic ghash_generic crypto_ghash ghash
gf128mul

kernel/crypto/jitterentropy_rng.ko.xz crypto_jitterentropy_rng jitterentropy_rng

kernel/crypto/gcm.ko.xz crypto_gcm gcm crypto_rfc4543 rfc4543 crypto_rfc4106 rfc4106 crypto_gcm_base gcm_base
crypto_null

kernel/crypto/ecc.ko.xz symbol:ecc_get_curve25519 symbol:ecc_get_curve symbol:ecc_digits_from_bytes symbol:ecc_alloc_point symbol:ecc_free_point symbol:vli_is_zero symbol:vli_num_bits symbol:vli_from_be64 symbol:vli_from_le64 symbol:vli_cmp symbol:vli_sub symbol:vli_mod_mult_slow symbol:vli_mod_inv symbol:ecc_point_is_zero symbol:ecc_point_mult_shamir symbol:ecc_is_key_valid symbol:ecc_gen_privkey symbol:ecc_make_pub_key symbol:ecc_is_pubkey_valid_partial symbol:ecc_is_pubkey_valid_full symbol:crypto_ecdh_shared_secret

kernel/crypto/crypto_user.ko.xz net_pf_16_proto_21

kernel/crypto/cbc.ko.xz crypto_cbc cbc

kernel/crypto/cmac.ko.xz crypto_cmac cmac

kernel/crypto/seqiv.ko.xz crypto_seqiv seqiv
geniv

kernel/crypto/deflate.ko.xz crypto_deflate_generic deflate_generic crypto_deflate deflate

kernel/crypto/sha512_generic.ko.xz crypto_sha512_generic sha512_generic crypto_sha512 sha512 crypto_sha384_generic sha384_generic crypto_sha384 sha384 symbol:sha384_zero_message_hash symbol:sha512_zero_message_hash symbol:crypto_sha512_update symbol:crypto_sha512_finup

kernel/net/mpls/mpls_gso.ko.xz

kernel/net/netrom/netrom.ko.xz net_pf_6
ax25

kernel/net/core/pktgen.ko.xz

kernel/net/ipv4/esp4.ko.xz xfrm_type_2_50 symbol:esp_output_head symbol:esp_output_tail symbol:esp_input_done2
xfrm_algo

kernel/net/ipv4/tcp_westwood.ko.xz

kernel/net/ipv4/ip_vti.ko.xz netdev_ip_vti0 rtnl_link_vti
tunnel4 ip_tunnel ipv6

kernel/net/ipv4/ipip.ko.xz netdev_tunl0 rtnl_link_ipip
tunnel4 ip_tunnel

kernel/net/ipv4/gre.ko.xz symbol:gre_add_protocol symbol:gre_del_protocol symbol:gre_parse_header

kernel/net/ipv4/inet_diag.ko.xz net_pf_16_proto_4_type_10 net_pf_16_proto_4_type_2 symbol:inet_diag_msg_common_fill symbol:inet_diag_msg_attrs_fill symbol:inet_sk_diag_fill symbol:inet_diag_find_one_icsk symbol:inet_diag_dump_one_icsk symbol:inet_diag_bc_sk symbol:inet_diag_dump_icsk symbol:inet_diag_register symbol:inet_diag_unregister

kernel/net/ipv4/tcp_diag.ko.xz net_pf_16_proto_4_type_2_6
inet_diag

kernel/net/ipv4/tcp_htcp.ko.xz

kernel/net/ipv4/tunnel4.ko.xz symbol:xfrm4_tunnel_register symbol:xfrm4_tunnel_deregister

kernel/net/ipv4/ip_gre.ko.xz netdev_erspan0 netdev_gretap0 netdev_gre0 rtnl_link_erspan rtnl_link_gretap rtnl_link_gre symbol:gretap_fb_dev_create
ip_tunnel gre ipv6

kernel/net/ipv4/ah4.ko.xz xfrm_type_2_51
xfrm_algo

kernel/net/ipv4/ipcomp.ko.xz xfrm_type_2_108
xfrm_ipcomp

kernel/net/ipv4/xfrm4_tunnel.ko.xz xfrm_type_2_4
tunnel4

kernel/net/ipv4/tcp_bbr.ko.xz

kernel/net/ipv4/udp_tunnel.ko.xz symbol:udp_sock_create4 symbol:setup_udp_tunnel_sock symbol:udp_tunnel_push_rx_port symbol:udp_tunnel_drop_rx_port symbol:udp_tunnel_notify_add_rx_port symbol:udp_tunnel_notify_del_rx_port symbol:udp_tunnel_xmit_skb symbol:udp_tunnel_sock_release symbol:udp_tun_rx_dst symbol:udp_tunnel_dst_lookup

kernel/net/ipv4/tcp_bic.ko.xz

kernel/net/ipv4/netfilter/nf_dup_ipv4.ko.xz symbol:nf_dup_ipv4

kernel/net/ipv4/netfilter/arpt_mangle.ko.xz
x_tables

kernel/net/ipv4/netfilter/ipt_ah.ko.xz
x_tables

kernel/net/ipv4/netfilter/ipt_rpfilter.ko.xz
x_tables

kernel/net/ipv4/netfilter/nft_reject_ipv4.ko.xz nft_expr_2_reject
nf_tables nf_reject_ipv4 nft_reject

kernel/net/ipv4/netfilter/ipt_ECN.ko.xz
x_tables

kernel/net/ipv4/netfilter/ipt_SYNPROXY.ko.xz
x_tables nf_synproxy_core nf_conntrack

kernel/net/ipv4/netfilter/nf_reject_ipv4.ko.xz symbol:nf_reject_skb_v4_tcp_reset symbol:nf_reject_skb_v4_unreach symbol:nf_reject_ip_tcphdr_get symbol:nf_reject_iphdr_put symbol:nf_reject_ip_tcphdr_put symbol:nf_send_reset symbol:nf_send_unreach

kernel/net/ipv4/netfilter/nf_nat_h323.ko.xz ip_nat_h323
nf_conntrack_h323 nf_conntrack nf_nat

kernel/net/ipv4/netfilter/nf_socket_ipv4.ko.xz symbol:nf_sk_lookup_slow_v4

kernel/net/ipv4/netfilter/ipt_REJECT.ko.xz
x_tables nf_reject_ipv4

kernel/net/ipv4/netfilter/arp_tables.ko.xz symbol:arpt_alloc_initial_table symbol:arpt_unregister_table_pre_exit symbol:arpt_register_table symbol:arpt_unregister_table symbol:arpt_do_table
x_tables

kernel/net/ipv4/netfilter/nf_tproxy_ipv4.ko.xz symbol:nf_tproxy_handle_time_wait4 symbol:nf_tproxy_laddr4 symbol:nf_tproxy_get_sock_v4

kernel/net/ipv4/netfilter/nf_defrag_ipv4.ko.xz symbol:nf_defrag_ipv4_enable symbol:nf_defrag_ipv4_disable

kernel/net/ipv4/netfilter/ip_tables.ko.xz symbol:ipt_alloc_initial_table symbol:ipt_register_table symbol:ipt_unregister_table_pre_exit symbol:ipt_unregister_table_exit symbol:ipt_do_table
x_tables

kernel/net/ipv4/netfilter/iptable_mangle.ko.xz
ip_tables x_tables

kernel/net/ipv4/netfilter/arptable_filter.ko.xz
arp_tables x_tables

kernel/net/ipv4/netfilter/iptable_raw.ko.xz
ip_tables x_tables

kernel/net/ipv4/netfilter/nf_nat_snmp_basic.ko.xz nfct_helper_snmp_trap ip_nat_snmp_basic
nf_conntrack nf_conntrack_snmp

kernel/net/ipv4/netfilter/iptable_nat.ko.xz
x_tables ip_tables nf_nat

kernel/net/ipv4/netfilter/iptable_filter.ko.xz
ip_tables x_tables

kernel/net/ipv4/netfilter/nf_nat_pptp.ko.xz ip_nat_pptp
nf_conntrack_pptp nf_nat nf_conntrack

kernel/net/ipv4/netfilter/nft_fib_ipv4.ko.xz nft_expr_2_fib symbol:nft_fib4_eval_type symbol:nft_fib4_eval
nf_tables nft_fib

kernel/net/ipv4/netfilter/nft_dup_ipv4.ko.xz nft_expr_2_dup
nf_tables nf_dup_ipv4

kernel/net/ipv4/ip_tunnel.ko.xz symbol:ip_tunnel_lookup symbol:ip_tunnel_md_udp_encap symbol:ip_tunnel_rcv symbol:ip_tunnel_encap_add_ops symbol:ip_tunnel_encap_del_ops symbol:ip_tunnel_encap_setup symbol:ip_md_tunnel_xmit symbol:ip_tunnel_xmit symbol:ip_tunnel_ctl symbol:ip_tunnel_parm_from_user symbol:ip_tunnel_parm_to_user symbol:ip_tunnel_siocdevprivate symbol:__ip_tunnel_change_mtu symbol:ip_tunnel_change_mtu symbol:ip_tunnel_dellink symbol:ip_tunnel_get_link_net symbol:ip_tunnel_get_iflink symbol:ip_tunnel_init_net symbol:ip_tunnel_delete_nets symbol:ip_tunnel_newlink symbol:ip_tunnel_changelink symbol:ip_tunnel_init symbol:ip_tunnel_uninit symbol:ip_tunnel_setup

kernel/net/ipv4/fou.ko.xz symbol:fou_encap_hlen symbol:gue_encap_hlen symbol:__fou_build_header symbol:__gue_build_header
ip_tunnel udp_tunnel ip6_udp_tunnel

kernel/net/ceph/libceph.ko.xz symbol:libceph_compatible symbol:ceph_msg_type_name symbol:ceph_check_fsid symbol:ceph_compare_options symbol:ceph_parse_fsid symbol:ceph_alloc_options symbol:ceph_destroy_options symbol:ceph_parse_mon_ips symbol:ceph_parse_param symbol:ceph_print_client_options symbol:ceph_client_addr symbol:ceph_client_gid symbol:ceph_create_client symbol:ceph_destroy_client symbol:ceph_reset_client_addr symbol:__ceph_open_session symbol:ceph_open_session symbol:ceph_wait_for_latest_osdmap symbol:ceph_pr_addr symbol:ceph_msgr_flush symbol:ceph_con_close symbol:ceph_con_open symbol:ceph_con_init symbol:ceph_addr_is_blank symbol:ceph_con_send symbol:ceph_con_keepalive symbol:ceph_msg_data_add_pages symbol:ceph_msg_data_add_pagelist symbol:ceph_msg_data_add_bio symbol:ceph_msg_data_add_bvecs symbol:ceph_msg_new2 symbol:ceph_msg_new symbol:ceph_msg_get symbol:ceph_msg_put symbol:ceph_msg_dump symbol:ceph_buffer_new symbol:ceph_buffer_release symbol:ceph_pagelist_alloc symbol:ceph_pagelist_release symbol:ceph_pagelist_append symbol:ceph_pagelist_reserve symbol:ceph_pagelist_free_reserve symbol:ceph_pagelist_set_cursor symbol:ceph_pagelist_truncate symbol:ceph_monc_want_map symbol:ceph_monc_got_map symbol:ceph_monc_renew_subs symbol:ceph_monc_wait_osdmap symbol:ceph_monc_open_session symbol:ceph_monc_do_statfs symbol:ceph_monc_get_version symbol:ceph_monc_get_version_async symbol:ceph_monc_blocklist_add symbol:ceph_monc_init symbol:ceph_monc_stop symbol:ceph_monc_validate_auth symbol:ceph_decode_entity_addr symbol:ceph_decode_entity_addrvec symbol:ceph_cls_lock symbol:ceph_cls_unlock symbol:ceph_cls_break_lock symbol:ceph_cls_set_cookie symbol:ceph_free_lockers symbol:ceph_cls_lock_info symbol:ceph_cls_assert_locked symbol:osd_req_op_extent_osd_data symbol:osd_req_op_raw_data_in_pages symbol:osd_req_op_extent_osd_data_pages symbol:osd_req_op_extent_osd_data_pagelist symbol:osd_req_op_extent_osd_data_bio symbol:osd_req_op_extent_osd_data_bvecs symbol:osd_req_op_extent_osd_data_bvec_pos symbol:osd_req_op_extent_osd_iter symbol:osd_req_op_cls_request_data_pagelist symbol:osd_req_op_cls_request_data_pages symbol:osd_req_op_cls_request_data_bvecs symbol:osd_req_op_cls_response_data_pages symbol:ceph_osdc_get_request symbol:ceph_osdc_put_request symbol:ceph_osdc_alloc_request symbol:ceph_osdc_alloc_messages symbol:osd_req_op_init symbol:osd_req_op_extent_init symbol:osd_req_op_extent_update symbol:osd_req_op_extent_dup_last symbol:osd_req_op_cls_init symbol:osd_req_op_xattr_init symbol:osd_req_op_alloc_hint_init symbol:ceph_osdc_new_request symbol:__ceph_alloc_sparse_ext_map symbol:ceph_osdc_abort_requests symbol:ceph_osdc_clear_abort_err symbol:ceph_osdc_update_epoch_barrier symbol:ceph_osdc_start_request symbol:ceph_osdc_cancel_request symbol:ceph_osdc_wait_request symbol:ceph_osdc_sync symbol:ceph_osdc_watch symbol:ceph_osdc_unwatch symbol:ceph_osdc_notify_ack symbol:ceph_osdc_notify symbol:ceph_osdc_list_watchers symbol:ceph_osdc_flush_notifies symbol:ceph_osdc_maybe_request_map symbol:ceph_osdc_call symbol:osd_req_op_copy_from_init symbol:ceph_pg_pool_name_by_id symbol:ceph_pg_poolid_by_name symbol:ceph_pg_pool_flags symbol:ceph_oloc_copy symbol:ceph_oloc_destroy symbol:ceph_oid_copy symbol:ceph_oid_printf symbol:ceph_oid_aprintf symbol:ceph_oid_destroy symbol:ceph_object_locator_to_pg symbol:ceph_pg_to_acting_primary symbol:ceph_calc_file_object_mapping symbol:ceph_file_to_extents symbol:ceph_iterate_extents symbol:ceph_extent_to_file symbol:ceph_get_num_objects symbol:ceph_auth_is_authenticated symbol:__ceph_auth_get_authorizer symbol:ceph_auth_destroy_authorizer symbol:ceph_auth_add_authorizer_challenge symbol:ceph_auth_verify_authorizer_reply symbol:ceph_auth_invalidate_authorizer symbol:ceph_auth_get_authorizer symbol:ceph_auth_handle_svc_reply_more symbol:ceph_auth_handle_svc_reply_done symbol:ceph_auth_handle_bad_authorizer symbol:ceph_entity_type_name symbol:ceph_str_hash symbol:ceph_str_hash_name symbol:ceph_put_page_vector symbol:ceph_release_page_vector symbol:ceph_alloc_page_vector symbol:ceph_copy_user_to_page_vector symbol:ceph_copy_to_page_vector symbol:ceph_copy_from_page_vector symbol:ceph_zero_page_vector_range symbol:ceph_create_snap_context symbol:ceph_get_snap_context symbol:ceph_put_snap_context symbol:ceph_find_or_create_string symbol:ceph_release_string

kernel/net/vmw_vsock/vsock_diag.ko.xz net_pf_16_proto_4_type_40
vsock

kernel/net/vmw_vsock/vsock.ko.xz symbol:vsock_bind_table symbol:vsock_connected_table symbol:vsock_table_lock symbol:vsock_insert_connected symbol:vsock_remove_bound symbol:vsock_remove_connected symbol:vsock_find_bound_socket symbol:vsock_find_connected_socket symbol:vsock_remove_sock symbol:vsock_for_each_connected_socket symbol:vsock_add_pending symbol:vsock_remove_pending symbol:vsock_enqueue_accept symbol:vsock_assign_transport symbol:vsock_find_cid symbol:vsock_create_connected symbol:vsock_stream_has_data symbol:vsock_connectible_has_data symbol:vsock_stream_has_space symbol:vsock_data_ready symbol:vsock_dgram_recvmsg symbol:vsock_connectible_recvmsg symbol:vsock_core_get_transport symbol:vsock_core_register symbol:vsock_core_unregister symbol:vsock_add_tap symbol:vsock_remove_tap symbol:vsock_deliver_tap symbol:vsock_addr_init symbol:vsock_addr_validate symbol:vsock_addr_bound symbol:vsock_addr_unbind symbol:vsock_addr_equals_addr symbol:vsock_addr_cast

kernel/net/vmw_vsock/vsock_loopback.ko.xz net_pf_40
vsock vmw_vsock_virtio_transport_common

kernel/net/vmw_vsock/vmw_vsock_virtio_transport_common.ko.xz symbol:virtio_transport_deliver_tap_pkt symbol:virtio_transport_inc_tx_pkt symbol:virtio_transport_consume_skb_sent symbol:virtio_transport_get_credit symbol:virtio_transport_put_credit symbol:virtio_transport_stream_dequeue symbol:virtio_transport_seqpacket_dequeue symbol:virtio_transport_seqpacket_enqueue symbol:virtio_transport_dgram_dequeue symbol:virtio_transport_stream_has_data symbol:virtio_transport_seqpacket_has_data symbol:virtio_transport_stream_has_space symbol:virtio_transport_do_socket_init symbol:virtio_transport_notify_buffer_size symbol:virtio_transport_notify_poll_in symbol:virtio_transport_notify_poll_out symbol:virtio_transport_notify_recv_init symbol:virtio_transport_notify_recv_pre_block symbol:virtio_transport_notify_recv_pre_dequeue symbol:virtio_transport_notify_recv_post_dequeue symbol:virtio_transport_notify_send_init symbol:virtio_transport_notify_send_pre_block symbol:virtio_transport_notify_send_pre_enqueue symbol:virtio_transport_notify_send_post_enqueue symbol:virtio_transport_stream_rcvhiwat symbol:virtio_transport_stream_is_active symbol:virtio_transport_stream_allow symbol:virtio_transport_dgram_bind symbol:virtio_transport_dgram_allow symbol:virtio_transport_connect symbol:virtio_transport_shutdown symbol:virtio_transport_dgram_enqueue symbol:virtio_transport_stream_enqueue symbol:virtio_transport_destruct symbol:virtio_transport_unsent_bytes symbol:virtio_transport_release symbol:virtio_transport_recv_pkt symbol:virtio_transport_purge_skbs symbol:virtio_transport_read_skb symbol:virtio_transport_notify_set_rcvlowat
vsock

kernel/net/rose/rose.ko.xz net_pf_11
ax25

kernel/net/appletalk/appletalk.ko.xz net_pf_5 symbol:aarp_send_ddp symbol:atrtr_get_dev symbol:atalk_find_dev_addr symbol:alloc_ltalkdev
psnap

kernel/net/llc/llc.ko.xz symbol:llc_sap_list symbol:llc_sap_find symbol:llc_sap_open symbol:llc_sap_close symbol:llc_add_pack symbol:llc_remove_pack symbol:llc_set_station_handler symbol:llc_mac_hdr_init symbol:llc_build_and_send_ui_pkt

kernel/net/batman-adv/batman-adv.ko.xz net_pf_16_proto_16_family_batadv rtnl_link_batadv
cfg80211 bridge

kernel/net/openvswitch/vport-vxlan.ko.xz vport_type_4
openvswitch vxlan

kernel/net/openvswitch/openvswitch.ko.xz net_pf_16_proto_16_family_ovs_ct_limit net_pf_16_proto_16_family_ovs_meter net_pf_16_proto_16_family_ovs_packet net_pf_16_proto_16_family_ovs_flow net_pf_16_proto_16_family_ovs_vport net_pf_16_proto_16_family_ovs_datapath symbol:__ovs_vport_ops_register symbol:ovs_vport_ops_unregister symbol:ovs_vport_alloc symbol:ovs_vport_free symbol:ovs_netdev_link symbol:ovs_netdev_tunnel_destroy
nf_conntrack nsh nf_nat nf_conncount

kernel/net/openvswitch/vport-gre.ko.xz vport_type_3
openvswitch ip_gre

kernel/net/ax25/ax25.ko.xz net_pf_3 symbol:ax25_bcast symbol:ax25_defaddr symbol:null_ax25_address symbol:ax2asc symbol:asc2ax symbol:ax25cmp symbol:ax25_register_pid symbol:ax25_protocol_release symbol:ax25_linkfail_register symbol:ax25_linkfail_release symbol:ax25_listen_register symbol:ax25_listen_release symbol:ax25_header_ops symbol:ax25_ip_xmit symbol:ax25_send_frame symbol:ax25_display_timer symbol:ax25_uid_policy symbol:ax25_findbyuid symbol:ax25_find_cb

kernel/net/l2tp/l2tp_eth.ko.xz net_l2tp_type_5
l2tp_netlink l2tp_core

kernel/net/l2tp/l2tp_ip.ko.xz net_pf_2_proto_115 net_pf_2_proto_115_type_2 symbol:l2tp_ioctl
l2tp_core

kernel/net/l2tp/l2tp_netlink.ko.xz net_pf_16_proto_16_family_l2tp symbol:l2tp_nl_register_ops symbol:l2tp_nl_unregister_ops
l2tp_core

kernel/net/l2tp/l2tp_ip6.ko.xz net_pf_10_proto_115 net_pf_10_proto_115_type_2
ipv6 l2tp_core l2tp_ip

kernel/net/l2tp/l2tp_core.ko.xz symbol:l2tp_sk_to_tunnel symbol:l2tp_tunnel_put symbol:l2tp_session_put symbol:l2tp_tunnel_get symbol:l2tp_tunnel_get_next symbol:l2tp_v3_session_get symbol:l2tp_v2_session_get symbol:l2tp_session_get symbol:l2tp_session_get_next symbol:l2tp_session_get_by_ifname symbol:l2tp_session_register symbol:l2tp_recv_common symbol:l2tp_udp_encap_recv symbol:l2tp_xmit_skb symbol:l2tp_tunnel_create symbol:l2tp_tunnel_register symbol:l2tp_tunnel_delete symbol:l2tp_session_delete symbol:l2tp_session_set_header_len symbol:l2tp_session_create
ipv6 ip6_udp_tunnel udp_tunnel

kernel/net/l2tp/l2tp_ppp.ko.xz net_l2tp_type_7 net_pf_24_proto_1
pppox l2tp_netlink l2tp_core ppp_generic

kernel/net/nfc/nfc.ko.xz net_pf_16_proto_16_family_nfc net_pf_39 symbol:nfc_fw_download_done symbol:nfc_dep_link_is_up symbol:nfc_find_se symbol:nfc_set_remote_general_bytes symbol:nfc_get_local_general_bytes symbol:nfc_tm_data_received symbol:nfc_tm_activated symbol:nfc_tm_deactivated symbol:nfc_alloc_recv_skb symbol:nfc_targets_found symbol:nfc_target_lost symbol:nfc_driver_failure symbol:nfc_add_se symbol:nfc_remove_se symbol:nfc_se_transaction symbol:nfc_se_connectivity symbol:nfc_class symbol:nfc_allocate_device symbol:nfc_register_device symbol:nfc_unregister_device symbol:__nfc_alloc_vendor_cmd_reply_skb symbol:nfc_vendor_cmd_reply symbol:nfc_proto_register symbol:nfc_proto_unregister symbol:nfc_send_to_raw_sock
rfkill

kernel/net/key/af_key.ko.xz net_pf_15
xfrm_algo

kernel/net/bluetooth/bnep/bnep.ko.xz bt_proto_4
bluetooth

kernel/net/bluetooth/bluetooth_6lowpan.ko.xz
bluetooth 6lowpan ipv6

kernel/net/bluetooth/rfcomm/rfcomm.ko.xz bt_proto_3
bluetooth

kernel/net/bluetooth/bluetooth.ko.xz net_pf_31 symbol:bt_sock_reclassify_lock symbol:bt_sock_register symbol:bt_sock_unregister symbol:bt_sock_alloc symbol:bt_sock_link symbol:bt_sock_unlink symbol:bt_sock_linked symbol:bt_accept_enqueue symbol:bt_accept_unlink symbol:bt_accept_dequeue symbol:bt_sock_recvmsg symbol:bt_sock_stream_recvmsg symbol:bt_sock_poll symbol:bt_sock_ioctl symbol:bt_sock_wait_state symbol:bt_sock_wait_ready symbol:bt_procfs_init symbol:bt_procfs_cleanup symbol:bt_debugfs symbol:hci_alloc_dev_priv symbol:hci_free_dev symbol:hci_register_dev symbol:hci_unregister_dev symbol:hci_release_dev symbol:hci_suspend_dev symbol:hci_resume_dev symbol:hci_reset_dev symbol:hci_recv_frame symbol:hci_recv_diag symbol:hci_set_hw_info symbol:hci_set_fw_info symbol:hci_register_cb symbol:hci_unregister_cb symbol:__hci_cmd_send symbol:hci_get_route symbol:hci_conn_security symbol:hci_conn_check_secure symbol:hci_conn_switch_role symbol:hci_mgmt_chan_register symbol:hci_mgmt_chan_unregister symbol:l2cap_add_psm symbol:l2cap_chan_create symbol:l2cap_chan_hold symbol:l2cap_chan_put symbol:l2cap_chan_set_defaults symbol:l2cap_chan_del symbol:l2cap_chan_list symbol:l2cap_chan_close symbol:l2cap_register_user symbol:l2cap_unregister_user symbol:l2cap_conn_get symbol:l2cap_conn_put symbol:l2cap_chan_send symbol:l2cap_chan_connect symbol:l2cap_is_socket symbol:baswap symbol:bt_to_errno symbol:bt_status symbol:bt_info symbol:bt_warn symbol:bt_err symbol:bt_warn_ratelimited symbol:bt_err_ratelimited symbol:__hci_cmd_sync_sk symbol:__hci_cmd_sync symbol:hci_cmd_sync symbol:__hci_cmd_sync_ev symbol:__hci_cmd_sync_status_sk symbol:__hci_cmd_sync_status symbol:hci_cmd_sync_status symbol:hci_cmd_sync_cancel symbol:hci_cmd_sync_cancel_sync symbol:hci_cmd_sync_submit symbol:hci_cmd_sync_queue symbol:hci_cmd_sync_queue_once symbol:hci_cmd_sync_run symbol:hci_cmd_sync_run_once symbol:hci_cmd_sync_lookup_entry symbol:hci_cmd_sync_cancel_entry symbol:hci_cmd_sync_dequeue_once symbol:hci_cmd_sync_dequeue symbol:hci_devcd_rx symbol:hci_devcd_timeout symbol:hci_devcd_register symbol:hci_devcd_init symbol:hci_devcd_append symbol:hci_devcd_append_pattern symbol:hci_devcd_complete symbol:hci_devcd_abort
ecdh_generic rfkill libaes

kernel/net/bluetooth/hidp/hidp.ko.xz bt_proto_6
bluetooth

kernel/net/ieee802154/ieee802154_socket.ko.xz net_pf_36
ieee802154

kernel/net/ieee802154/6lowpan/ieee802154_6lowpan.ko.xz rtnl_link_lowpan
ieee802154 6lowpan ipv6

kernel/net/ieee802154/ieee802154.ko.xz symbol:wpan_phy_find symbol:wpan_phy_for_each symbol:wpan_phy_new symbol:wpan_phy_register symbol:wpan_phy_unregister symbol:wpan_phy_free symbol:ieee802154_hdr_push symbol:ieee802154_mac_cmd_push symbol:ieee802154_beacon_push symbol:ieee802154_hdr_pull symbol:ieee802154_mac_cmd_pl_pull symbol:ieee802154_hdr_peek_addrs symbol:ieee802154_hdr_peek symbol:ieee802154_max_payload symbol:nl802154_scan_event symbol:nl802154_scan_started symbol:nl802154_scan_done symbol:nl802154_beaconing_done symbol:cfg802154_device_is_parent symbol:cfg802154_device_is_child symbol:cfg802154_get_free_short_addr symbol:cfg802154_set_max_associations

kernel/net/wireless/lib80211.ko.xz symbol:lib80211_crypt_info_init symbol:lib80211_crypt_info_free symbol:lib80211_crypt_delayed_deinit symbol:lib80211_register_crypto_ops symbol:lib80211_unregister_crypto_ops symbol:lib80211_get_crypto_ops

kernel/net/wireless/cfg80211.ko.xz net_pf_16_proto_16_family_nl80211 symbol:cfg80211_shutdown_all_interfaces symbol:wiphy_new_nm symbol:wiphy_register symbol:wiphy_rfkill_start_polling symbol:wiphy_unregister symbol:wiphy_free symbol:wiphy_rfkill_set_hw_state_reason symbol:cfg80211_unregister_wdev symbol:cfg80211_stop_iface symbol:cfg80211_register_netdevice symbol:wiphy_work_queue symbol:wiphy_work_cancel symbol:wiphy_work_flush symbol:wiphy_delayed_work_timer symbol:wiphy_delayed_work_queue symbol:wiphy_delayed_work_cancel symbol:wiphy_delayed_work_flush symbol:wiphy_delayed_work_pending symbol:wiphy_hrtimer_work_timer symbol:wiphy_hrtimer_work_queue symbol:wiphy_hrtimer_work_cancel symbol:wiphy_hrtimer_work_flush symbol:wiphy_hrtimer_work_pending symbol:ieee80211_radiotap_iterator_init symbol:ieee80211_radiotap_iterator_next symbol:ieee80211_get_response_rate symbol:ieee80211_mandatory_rates symbol:ieee80211_channel_to_freq_khz symbol:ieee80211_s1g_channel_width symbol:ieee80211_freq_khz_to_channel symbol:ieee80211_get_channel_khz symbol:ieee80211_hdrlen symbol:ieee80211_get_hdrlen_from_skb symbol:ieee80211_get_mesh_hdrlen symbol:ieee80211_get_8023_tunnel_proto symbol:ieee80211_strip_8023_mesh_hdr symbol:ieee80211_data_to_8023_exthdr symbol:ieee80211_is_valid_amsdu symbol:ieee80211_amsdu_to_8023s symbol:cfg80211_classify8021d symbol:ieee80211_bss_get_elem symbol:cfg80211_calculate_bitrate symbol:cfg80211_get_p2p_attr symbol:ieee80211_ie_split_ric symbol:ieee80211_fragment_element symbol:ieee80211_operating_class_to_band symbol:ieee80211_operating_class_to_chandef symbol:ieee80211_chandef_to_operating_class symbol:cfg80211_iter_combinations symbol:cfg80211_check_combinations symbol:ieee80211_get_num_supported_channels symbol:cfg80211_get_station symbol:cfg80211_free_nan_func symbol:cfg80211_sinfo_alloc_tid_stats symbol:rfc1042_header symbol:bridge_tunnel_header symbol:cfg80211_send_layer2_update symbol:ieee80211_get_vht_max_nss symbol:cfg80211_iftype_allowed symbol:cfg80211_get_iftype_ext_capa symbol:cfg80211_radio_chandef_valid symbol:get_wiphy_regdom symbol:reg_query_regdb_wmm symbol:freq_reg_info symbol:reg_initiator_name symbol:wiphy_apply_custom_regulatory symbol:regulatory_hint symbol:regulatory_set_wiphy_regd symbol:regulatory_set_wiphy_regd_sync symbol:regulatory_pre_cac_allowed symbol:cfg80211_is_element_inherited symbol:cfg80211_iter_rnr symbol:cfg80211_scan_done symbol:cfg80211_sched_scan_results symbol:cfg80211_sched_scan_stopped_locked symbol:cfg80211_sched_scan_stopped symbol:cfg80211_bss_flush symbol:cfg80211_find_elem_match symbol:cfg80211_find_vendor_elem symbol:__cfg80211_get_bss symbol:cfg80211_get_ies_channel_number symbol:cfg80211_merge_profile symbol:cfg80211_defragment_element symbol:cfg80211_inform_bss_data symbol:cfg80211_inform_bss_frame_data symbol:cfg80211_ref_bss symbol:cfg80211_put_bss symbol:cfg80211_unlink_bss symbol:cfg80211_bss_iter symbol:nl80211_send_chandef symbol:cfg80211_check_station_change symbol:__cfg80211_alloc_event_skb symbol:__cfg80211_send_event_skb symbol:cfg80211_nan_match symbol:cfg80211_nan_func_terminated symbol:__cfg80211_alloc_reply_skb symbol:cfg80211_vendor_cmd_reply symbol:cfg80211_vendor_cmd_get_sender symbol:cfg80211_rx_unprot_mlme_mgmt symbol:cfg80211_links_removed symbol:cfg80211_notify_new_peer_candidate symbol:cfg80211_assoc_comeback symbol:cfg80211_ready_on_channel symbol:cfg80211_remain_on_channel_expired symbol:cfg80211_tx_mgmt_expired symbol:cfg80211_new_sta symbol:cfg80211_del_sta_sinfo symbol:cfg80211_conn_failed symbol:cfg80211_rx_spurious_frame symbol:cfg80211_rx_unexpected_4addr_frame symbol:cfg80211_control_port_tx_status symbol:cfg80211_mgmt_tx_status_ext symbol:cfg80211_rx_control_port symbol:cfg80211_cqm_rssi_notify symbol:cfg80211_cqm_txe_notify symbol:cfg80211_cqm_pktloss_notify symbol:cfg80211_cqm_beacon_loss_notify symbol:cfg80211_gtk_rekey_notify symbol:cfg80211_pmksa_candidate_notify symbol:cfg80211_ch_switch_notify symbol:cfg80211_ch_switch_started_notify symbol:cfg80211_bss_color_notify symbol:cfg80211_sta_opmode_change_notify symbol:cfg80211_probe_status symbol:cfg80211_report_obss_beacon_khz symbol:cfg80211_report_wowlan_wakeup symbol:cfg80211_tdls_oper_request symbol:cfg80211_ft_event symbol:cfg80211_crit_proto_stopped symbol:cfg80211_external_auth_request symbol:cfg80211_update_owe_info_event symbol:cfg80211_schedule_channels_check symbol:cfg80211_rx_assoc_resp symbol:cfg80211_rx_mlme_mgmt symbol:cfg80211_auth_timeout symbol:cfg80211_assoc_failure symbol:cfg80211_tx_mlme_mgmt symbol:cfg80211_michael_mic_failure symbol:cfg80211_rx_mgmt_ext symbol:__cfg80211_radar_event symbol:cfg80211_cac_event symbol:cfg80211_background_cac_abort symbol:cfg80211_ibss_joined symbol:cfg80211_connect_done symbol:cfg80211_roamed symbol:cfg80211_port_authorized symbol:cfg80211_disconnected symbol:cfg80211_chandef_create symbol:nl80211_chan_width_to_mhz symbol:cfg80211_chandef_valid symbol:cfg80211_chandef_primary symbol:cfg80211_chandef_compatible symbol:cfg80211_chandef_dfs_required symbol:cfg80211_chandef_dfs_usable symbol:cfg80211_chandef_dfs_cac_time symbol:cfg80211_chandef_usable symbol:cfg80211_reg_check_beaconing symbol:cfg80211_any_usable_channels symbol:wdev_chandef symbol:cfg80211_get_drvinfo symbol:cfg80211_pmsr_complete symbol:cfg80211_pmsr_report symbol:wiphy_read_of_freq_limits
rfkill

kernel/net/8021q/8021q.ko.xz rtnl_link_vlan
garp

kernel/net/sctp/sctp_diag.ko.xz net_pf_16_proto_4_type_2_132
sctp inet_diag

kernel/net/sctp/sctp.ko.xz net_pf_10_proto_132 net_pf_2_proto_132 symbol:sctp_get_sctp_info symbol:sctp_for_each_endpoint symbol:sctp_transport_lookup_process symbol:sctp_transport_traverse_process symbol:sctp_do_peeloff
ipv6 udp_tunnel ip6_udp_tunnel

kernel/net/xfrm/xfrm_algo.ko.xz symbol:xfrm_aalg_get_byid symbol:xfrm_ealg_get_byid symbol:xfrm_calg_get_byid symbol:xfrm_aalg_get_byname symbol:xfrm_ealg_get_byname symbol:xfrm_calg_get_byname symbol:xfrm_aead_get_byname symbol:xfrm_aalg_get_byidx symbol:xfrm_ealg_get_byidx symbol:xfrm_probe_algs symbol:xfrm_count_pfkey_auth_supported symbol:xfrm_count_pfkey_enc_supported

kernel/net/xfrm/xfrm_ipcomp.ko.xz symbol:ipcomp_input symbol:ipcomp_output symbol:ipcomp_destroy symbol:ipcomp_init_state
xfrm_algo

kernel/net/xfrm/xfrm_interface.ko.xz netdev_xfrm0 rtnl_link_xfrm
ipv6 tunnel6 tunnel4 xfrm6_tunnel

kernel/net/xfrm/xfrm_user.ko.xz net_pf_16_proto_6 symbol:xfrm_msg_min symbol:xfrma_policy
xfrm_algo

kernel/net/6lowpan/nhc_ipv6.ko.xz
6lowpan

kernel/net/6lowpan/6lowpan.ko.xz symbol:lowpan_register_netdevice symbol:lowpan_register_netdev symbol:lowpan_unregister_netdevice symbol:lowpan_unregister_netdev symbol:lowpan_header_decompress symbol:lowpan_header_compress symbol:lowpan_nhc_add symbol:lowpan_nhc_del
ipv6

kernel/net/6lowpan/nhc_dest.ko.xz
6lowpan

kernel/net/6lowpan/nhc_fragment.ko.xz
6lowpan

kernel/net/6lowpan/nhc_udp.ko.xz
6lowpan

kernel/net/6lowpan/nhc_routing.ko.xz
6lowpan

kernel/net/6lowpan/nhc_mobility.ko.xz
6lowpan

kernel/net/6lowpan/nhc_hop.ko.xz
6lowpan

kernel/net/mac80211/mac80211.ko.xz symbol:ieee80211_emulate_add_chanctx symbol:ieee80211_emulate_remove_chanctx symbol:ieee80211_emulate_change_chanctx symbol:ieee80211_emulate_switch_vif_chanctx symbol:ieee80211_restart_hw symbol:ieee80211_alloc_hw_nm symbol:ieee80211_register_hw symbol:ieee80211_unregister_hw symbol:ieee80211_free_hw symbol:ieee80211_tx_status_irqsafe symbol:ieee80211_tx_status_skb symbol:ieee80211_tx_status_ext symbol:ieee80211_tx_rate_update symbol:ieee80211_report_low_ack symbol:ieee80211_free_txskb symbol:ieee80211_purge_tx_queue symbol:ieee80211_find_sta_by_link_addrs symbol:ieee80211_find_sta_by_ifaddr symbol:ieee80211_find_sta symbol:ieee80211_sta_block_awake symbol:ieee80211_sta_eosp symbol:ieee80211_send_eosp_nullfunc symbol:ieee80211_sta_set_buffered symbol:ieee80211_sta_register_airtime symbol:ieee80211_sta_recalc_aggregates symbol:ieee80211_scan_completed symbol:ieee80211_sched_scan_results symbol:ieee80211_sched_scan_stopped symbol:ieee80211_ready_on_channel symbol:ieee80211_remain_on_channel_expired symbol:ieee80211_request_smps symbol:ieee80211_send_bar symbol:ieee80211_refresh_tx_agg_session_timer symbol:ieee80211_start_tx_ba_session symbol:ieee80211_start_tx_ba_cb_irqsafe symbol:ieee80211_stop_tx_ba_session symbol:ieee80211_stop_tx_ba_cb_irqsafe symbol:ieee80211_stop_rx_ba_session symbol:ieee80211_manage_rx_ba_offl symbol:ieee80211_rx_ba_timer_expired symbol:ieee80211_update_mu_groups symbol:ieee80211_set_active_links symbol:ieee80211_set_active_links_async symbol:ieee80211_rate_control_register symbol:ieee80211_rate_control_unregister symbol:ieee80211_get_tx_rates symbol:rate_control_set_rates symbol:ieee80211_tkip_add_iv symbol:ieee80211_get_tkip_p1k_iv symbol:ieee80211_get_tkip_rx_p1k symbol:ieee80211_get_tkip_p2k symbol:ieee80211_csa_finish symbol:ieee80211_channel_switch_disconnect symbol:ieee80211_nan_func_terminated symbol:ieee80211_nan_func_match symbol:ieee80211_color_change_finish symbol:ieee80211_obss_color_collision_notify symbol:ieee80211_sta_ps_transition symbol:ieee80211_sta_pspoll symbol:ieee80211_sta_uapsd_trigger symbol:ieee80211_mark_rx_ba_filtered_frames symbol:ieee80211_rx_list symbol:ieee80211_rx_napi symbol:ieee80211_rx_irqsafe symbol:ieee80211_tx_prepare_skb symbol:ieee80211_tx_dequeue symbol:ieee80211_next_txq symbol:__ieee80211_schedule_txq symbol:ieee80211_txq_airtime_check symbol:ieee80211_txq_may_transmit symbol:ieee80211_txq_schedule_start symbol:ieee80211_beacon_update_cntdwn symbol:ieee80211_beacon_set_cntdwn symbol:ieee80211_beacon_cntdwn_is_complete symbol:ieee80211_beacon_get_template symbol:ieee80211_beacon_get_template_ema_index symbol:ieee80211_beacon_free_ema_list symbol:ieee80211_beacon_get_template_ema_list symbol:ieee80211_beacon_get_tim symbol:ieee80211_proberesp_get symbol:ieee80211_get_fils_discovery_tmpl symbol:ieee80211_get_unsol_bcast_probe_resp_tmpl symbol:ieee80211_pspoll_get symbol:ieee80211_nullfunc_get symbol:ieee80211_probereq_get symbol:ieee80211_rts_get symbol:ieee80211_ctstoself_get symbol:ieee80211_get_buffered_bc symbol:ieee80211_reserve_tid symbol:ieee80211_unreserve_tid symbol:ieee80211_iter_keys symbol:ieee80211_iter_keys_rcu symbol:ieee80211_gtk_rekey_notify symbol:ieee80211_get_key_rx_seq symbol:ieee80211_set_key_rx_seq symbol:ieee80211_remove_key symbol:ieee80211_gtk_rekey_add symbol:ieee80211_key_mic_failure symbol:ieee80211_key_replay symbol:wiphy_to_ieee80211_hw symbol:ieee80211_get_bssid symbol:ieee80211_generic_frame_duration symbol:ieee80211_rts_duration symbol:ieee80211_ctstoself_duration symbol:ieee80211_handle_wake_tx_queue symbol:ieee80211_wake_queue symbol:ieee80211_stop_queue symbol:ieee80211_stop_queues symbol:ieee80211_queue_stopped symbol:ieee80211_wake_queues symbol:ieee80211_iterate_interfaces symbol:ieee80211_iterate_active_interfaces_atomic symbol:ieee80211_iterate_active_interfaces_mtx symbol:ieee80211_iterate_stations_atomic symbol:ieee80211_iterate_stations_mtx symbol:wdev_to_ieee80211_vif symbol:ieee80211_vif_to_wdev symbol:ieee80211_queue_work symbol:ieee80211_queue_delayed_work symbol:ieee80211_hw_restart_disconnect symbol:ieee80211_resume_disconnect symbol:ieee80211_ave_rssi symbol:ieee80211_radar_detected symbol:ieee80211_update_p2p_noa symbol:ieee80211_parse_p2p_noa symbol:ieee80211_txq_get_depth symbol:ieee80211_iter_chan_contexts_atomic symbol:ieee80211_chswitch_done symbol:ieee80211_ap_probereq_get symbol:ieee80211_beacon_loss symbol:ieee80211_connection_loss symbol:ieee80211_disconnect symbol:ieee80211_send_teardown_neg_ttlm symbol:ieee80211_cqm_rssi_notify symbol:ieee80211_cqm_beacon_loss_notify symbol:ieee80211_enable_rssi_reports symbol:ieee80211_disable_rssi_reports symbol:ieee80211_tdls_oper_request symbol:ieee80211_calc_rx_airtime symbol:ieee80211_calc_tx_airtime symbol:__ieee80211_get_radio_led_name symbol:__ieee80211_get_assoc_led_name symbol:__ieee80211_get_tx_led_name symbol:__ieee80211_get_rx_led_name symbol:__ieee80211_create_tpt_led_trigger symbol:ieee80211_report_wowlan_wakeup
cfg80211 libarc4

kernel/net/dsa/dsa_core.ko.xz platform:dsa symbol:dsa_devlink_param_get symbol:dsa_devlink_param_set symbol:dsa_devlink_params_register symbol:dsa_devlink_params_unregister symbol:dsa_devlink_resource_register symbol:dsa_devlink_resources_unregister symbol:dsa_devlink_resource_occ_get_register symbol:dsa_devlink_resource_occ_get_unregister symbol:dsa_devlink_region_create symbol:dsa_devlink_port_region_create symbol:dsa_devlink_region_destroy symbol:dsa_flush_workqueue symbol:dsa_switch_find symbol:dsa_register_switch symbol:dsa_unregister_switch symbol:dsa_switch_shutdown symbol:dsa_port_from_netdev symbol:dsa_fdb_present_in_other_db symbol:dsa_mdb_present_in_other_db symbol:dsa_supports_eee symbol:dsa_tag_drivers_register symbol:dsa_tag_drivers_unregister symbol:dsa_tag_8021q_bridge_vid symbol:dsa_tag_8021q_standalone_vid symbol:dsa_8021q_rx_switch_id symbol:dsa_8021q_rx_source_port symbol:vid_is_dsa_8021q symbol:dsa_tag_8021q_bridge_join symbol:dsa_tag_8021q_bridge_leave symbol:dsa_tag_8021q_register symbol:dsa_tag_8021q_unregister symbol:dsa_8021q_xmit symbol:dsa_tag_8021q_find_user symbol:dsa_8021q_rcv symbol:dsa_enqueue_skb symbol:dsa_port_phylink_mac_change symbol:dsa_user_dev_check
bridge

kernel/net/sched/act_skbedit.ko.xz net_act_skbedit

kernel/net/sched/sch_pie.ko.xz net_sch_pie symbol:pie_drop_early symbol:pie_process_dequeue symbol:pie_calculate_probability

kernel/net/sched/sch_ingress.ko.xz net_sch_clsact net_sch_ingress

kernel/net/sched/sch_fq.ko.xz net_sch_fq

kernel/net/sched/act_csum.ko.xz net_act_csum

kernel/net/sched/cls_matchall.ko.xz net_cls_matchall

kernel/net/sched/sch_netem.ko.xz net_sch_netem

kernel/net/sched/sch_mqprio.ko.xz net_sch_mqprio
sch_mqprio_lib

kernel/net/sched/em_ipset.ko.xz ematch_kind_8
ip_set

kernel/net/sched/act_gact.ko.xz net_act_gact

kernel/net/sched/act_simple.ko.xz net_act_simple

kernel/net/sched/sch_tbf.ko.xz net_sch_tbf

kernel/net/sched/em_text.ko.xz ematch_kind_5

kernel/net/sched/cls_u32.ko.xz net_cls_u32

kernel/net/sched/sch_red.ko.xz net_sch_red

kernel/net/sched/sch_htb.ko.xz net_sch_htb

kernel/net/sched/sch_multiq.ko.xz net_sch_multiq

kernel/net/sched/sch_plug.ko.xz net_sch_plug

kernel/net/sched/sch_gred.ko.xz net_sch_gred

kernel/net/sched/cls_flower.ko.xz net_cls_flower

kernel/net/sched/sch_choke.ko.xz net_sch_choke

kernel/net/sched/sch_fq_codel.ko.xz net_sch_fq_codel

kernel/net/sched/act_police.ko.xz net_act_police

kernel/net/sched/em_meta.ko.xz ematch_kind_4

kernel/net/sched/cls_route.ko.xz net_cls_route

kernel/net/sched/sch_cake.ko.xz net_sch_cake

kernel/net/sched/sch_teql.ko.xz

kernel/net/sched/em_u32.ko.xz ematch_kind_3

kernel/net/sched/sch_prio.ko.xz net_sch_prio

kernel/net/sched/sch_qfq.ko.xz net_sch_qfq

kernel/net/sched/cls_fw.ko.xz net_cls_fw

kernel/net/sched/sch_sfb.ko.xz net_sch_sfb

kernel/net/sched/act_pedit.ko.xz net_act_pedit

kernel/net/sched/cls_cgroup.ko.xz net_cls_cgroup

kernel/net/sched/em_cmp.ko.xz ematch_kind_1

kernel/net/sched/act_mirred.ko.xz net_act_mirred

kernel/net/sched/sch_hfsc.ko.xz net_sch_hfsc

kernel/net/sched/sch_drr.ko.xz net_sch_drr

kernel/net/sched/em_nbyte.ko.xz ematch_kind_2

kernel/net/sched/sch_codel.ko.xz net_sch_codel

kernel/net/sched/sch_sfq.ko.xz net_sch_sfq

kernel/net/sched/sch_mqprio_lib.ko.xz symbol:mqprio_validate_qopt symbol:mqprio_qopt_reconstruct symbol:mqprio_fp_to_offload

kernel/net/sched/cls_basic.ko.xz net_cls_basic

kernel/net/sched/sch_hhf.ko.xz net_sch_hhf

kernel/net/sched/cls_flow.ko.xz net_cls_flow

kernel/net/sched/act_nat.ko.xz net_act_nat

kernel/net/can/j1939/can-j1939.ko.xz can_proto_7
can

kernel/net/can/can-bcm.ko.xz can_proto_2
can

kernel/net/can/can-isotp.ko.xz can_proto_6
can

kernel/net/can/can-gw.ko.xz can_gw
can

kernel/net/can/can-raw.ko.xz can_proto_1
can

kernel/net/can/can.ko.xz net_pf_29 symbol:can_sock_destruct symbol:can_send symbol:can_rx_register symbol:can_rx_unregister symbol:can_proto_register symbol:can_proto_unregister

kernel/net/atm/atm.ko.xz net_pf_20 net_pf_8 symbol:register_atm_ioctl symbol:deregister_atm_ioctl symbol:vcc_hash symbol:vcc_sklist_lock symbol:vcc_insert_socket symbol:vcc_release_async symbol:vcc_process_recv_queue symbol:atm_dev_signal_change symbol:atm_dev_release_vccs symbol:register_atmdevice_notifier symbol:unregister_atmdevice_notifier symbol:atm_charge symbol:atm_alloc_charge symbol:atm_pcr_goal symbol:sonet_copy_stats symbol:sonet_subtract_stats symbol:atm_init_aal5 symbol:atm_dev_lookup symbol:atm_dev_register symbol:atm_dev_deregister symbol:atm_proc_root

kernel/net/atm/pppoatm.ko.xz
atm ppp_generic

kernel/net/802/stp.ko.xz symbol:stp_proto_register symbol:stp_proto_unregister
llc

kernel/net/802/psnap.ko.xz symbol:register_snap_client symbol:unregister_snap_client
llc

kernel/net/802/garp.ko.xz symbol:garp_request_join symbol:garp_request_leave symbol:garp_init_applicant symbol:garp_uninit_applicant symbol:garp_register_application symbol:garp_unregister_application
stp llc

kernel/net/802/p8022.ko.xz symbol:register_8022_client symbol:unregister_8022_client
llc

kernel/net/9p/9pnet.ko.xz symbol:v9fs_register_trans symbol:v9fs_unregister_trans symbol:v9fs_get_trans_by_name symbol:v9fs_get_default_trans symbol:p9_is_proto_dotl symbol:p9_is_proto_dotu symbol:p9_show_client_options symbol:p9_fcall_fini symbol:p9_tag_lookup symbol:p9_req_put symbol:p9_client_cb symbol:p9_parse_header symbol:__tracepoint_9p_fid_ref symbol:__traceiter_9p_fid_ref symbol:__SCK__tp_func_9p_fid_ref symbol:do_trace_9p_fid_get symbol:do_trace_9p_fid_put symbol:p9_client_create symbol:p9_client_destroy symbol:p9_client_disconnect symbol:p9_client_begin_disconnect symbol:p9_client_attach symbol:p9_client_walk symbol:p9_client_open symbol:p9_client_create_dotl symbol:p9_client_fcreate symbol:p9_client_symlink symbol:p9_client_link symbol:p9_client_fsync symbol:p9_client_clunk symbol:p9_client_remove symbol:p9_client_unlinkat symbol:p9_client_read symbol:p9_client_read_once symbol:p9_client_write symbol:p9_client_write_subreq symbol:p9_client_stat symbol:p9_client_getattr_dotl symbol:p9_client_wstat symbol:p9_client_setattr symbol:p9_client_statfs symbol:p9_client_rename symbol:p9_client_renameat symbol:p9_client_xattrwalk symbol:p9_client_xattrcreate symbol:p9_client_readdir symbol:p9_client_mknod_dotl symbol:p9_client_mkdir_dotl symbol:p9_client_lock_dotl symbol:p9_client_getlock_dotl symbol:p9_client_readlink symbol:p9_error_init symbol:p9_errstr2errno symbol:p9stat_free symbol:p9stat_read symbol:p9dirent_read symbol:p9_release_pages
netfs

kernel/net/9p/9pnet_fd.ko.xz 9p_fd 9p_unix 9p_tcp
9pnet

kernel/net/netfilter/xt_hl.ko.xz ip6t_hl ipt_ttl
x_tables

kernel/net/netfilter/nft_reject.ko.xz symbol:nft_reject_policy symbol:nft_reject_validate symbol:nft_reject_init symbol:nft_reject_dump symbol:nft_reject_icmp_code symbol:nft_reject_icmpv6_code
nf_tables

kernel/net/netfilter/xt_CT.ko.xz ip6t_NOTRACK ipt_NOTRACK ip6t_CT ipt_CT
x_tables nf_conntrack

kernel/net/netfilter/nft_ct.ko.xz nft_obj_9 nft_obj_7 nft_obj_3 nft_expr_notrack nft_expr_ct
nf_tables nf_conntrack

kernel/net/netfilter/nft_fib.ko.xz symbol:nft_fib_policy symbol:nft_fib_validate symbol:nft_fib_init symbol:nft_fib_dump symbol:nft_fib_store_result symbol:nft_fib_reduce
nf_tables

kernel/net/netfilter/nft_numgen.ko.xz nft_expr_numgen
nf_tables

kernel/net/netfilter/nfnetlink_queue.ko.xz nfnetlink_subsys_3
nfnetlink

kernel/net/netfilter/nf_tables.ko.xz nfnetlink_subsys_10 symbol:nft_do_chain symbol:nft_reg_track_update symbol:nft_reg_track_cancel symbol:__nft_reg_track_cancel symbol:nft_request_module symbol:nft_register_chain_type symbol:nft_unregister_chain_type symbol:nft_register_expr symbol:nft_unregister_expr symbol:nft_chain_validate symbol:nft_set_lookup_global symbol:nf_tables_bind_set symbol:nf_tables_activate_set symbol:nf_tables_deactivate_set symbol:nf_tables_destroy_set symbol:nft_set_elem_destroy symbol:nft_set_catchall_lookup symbol:nft_register_obj symbol:nft_unregister_obj symbol:nft_obj_lookup symbol:nft_obj_notify symbol:nft_register_flowtable_type symbol:nft_unregister_flowtable_type symbol:nft_flowtable_lookup symbol:nf_tables_deactivate_flowtable symbol:nf_tables_trans_destroy_flush_work symbol:nft_chain_validate_dependency symbol:nft_chain_validate_hooks symbol:nft_parse_u32_check symbol:nft_dump_register symbol:nft_parse_register_load symbol:nft_parse_register_store symbol:nft_data_init symbol:nft_data_release symbol:nft_data_dump symbol:__nft_release_basechain symbol:nft_trace_enabled symbol:nft_expr_reduce_bitwise symbol:nft_set_do_lookup symbol:nft_meta_get_eval symbol:nft_meta_set_eval symbol:nft_meta_policy symbol:nft_meta_get_init symbol:nft_meta_set_validate symbol:nft_meta_set_init symbol:nft_meta_get_dump symbol:nft_meta_set_dump symbol:nft_meta_set_destroy symbol:nft_meta_get_reduce symbol:nft_meta_inner_eval
nfnetlink

kernel/net/netfilter/xt_rateest.ko.xz ip6t_rateest ipt_rateest
x_tables xt_RATEEST

kernel/net/netfilter/xt_ecn.ko.xz ip6t_ecn ipt_ecn
x_tables

kernel/net/netfilter/xt_sctp.ko.xz ip6t_sctp ipt_sctp
x_tables

kernel/net/netfilter/xt_iprange.ko.xz ip6t_iprange ipt_iprange
x_tables

kernel/net/netfilter/xt_tcpudp.ko.xz ip6t_icmp6 ipt_icmp ip6t_tcp ip6t_udp ipt_tcp ipt_udp xt_udp xt_tcp
x_tables

kernel/net/netfilter/nft_limit.ko.xz nft_obj_4 nft_expr_limit
nf_tables

kernel/net/netfilter/nf_conntrack_broadcast.ko.xz symbol:nf_conntrack_broadcast_help
nf_conntrack

kernel/net/netfilter/nf_conntrack_netbios_ns.ko.xz nfct_helper_netbios_ns ip_conntrack_netbios_ns
nf_conntrack nf_conntrack_broadcast

kernel/net/netfilter/xt_recent.ko.xz ip6t_recent ipt_recent
x_tables

kernel/net/netfilter/ipvs/ip_vs_wrr.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_pe_sip.ko.xz
ip_vs nf_conntrack_sip

kernel/net/netfilter/ipvs/ip_vs_lc.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_rr.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs.ko.xz net_pf_16_proto_16_family_IPVS symbol:ip_vs_conn_in_get_proto symbol:ip_vs_conn_out_get_proto symbol:register_ip_vs_scheduler symbol:unregister_ip_vs_scheduler symbol:ip_vs_proto_name symbol:ip_vs_conn_new symbol:ip_vs_conn_in_get symbol:ip_vs_conn_out_get symbol:ip_vs_tcp_conn_listen symbol:ip_vs_conn_put symbol:ip_vs_new_conn_out symbol:ip_vs_scheduler_err symbol:register_ip_vs_app symbol:unregister_ip_vs_app symbol:register_ip_vs_app_inc symbol:ip_vs_proto_get symbol:ip_vs_proto_data_get symbol:register_ip_vs_pe symbol:unregister_ip_vs_pe symbol:ip_vs_nfct_expect_related
nf_conntrack ipv6 nf_defrag_ipv6

kernel/net/netfilter/ipvs/ip_vs_nq.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_lblc.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_dh.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_ftp.ko.xz
ip_vs nf_nat

kernel/net/netfilter/ipvs/ip_vs_sed.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_lblcr.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_wlc.ko.xz
ip_vs

kernel/net/netfilter/ipvs/ip_vs_sh.ko.xz
ip_vs

kernel/net/netfilter/ipset/ip_set_hash_ipport.ko.xz ip_set_hash:ip,port
ip_set

kernel/net/netfilter/ipset/ip_set_hash_ipportip.ko.xz ip_set_hash:ip,port,ip
ip_set

kernel/net/netfilter/ipset/ip_set_hash_net.ko.xz ip_set_hash:net
ip_set

kernel/net/netfilter/ipset/ip_set_bitmap_ipmac.ko.xz ip_set_bitmap:ip,mac
ip_set

kernel/net/netfilter/ipset/ip_set_hash_ipportnet.ko.xz ip_set_hash:ip,port,net
ip_set

kernel/net/netfilter/ipset/ip_set_list_set.ko.xz ip_set_list:set
ip_set

kernel/net/netfilter/ipset/ip_set_hash_ip.ko.xz ip_set_hash:ip
ip_set

kernel/net/netfilter/ipset/ip_set_bitmap_port.ko.xz ip_set_bitmap:port
ip_set

kernel/net/netfilter/ipset/ip_set_hash_netport.ko.xz ip_set_hash:net,port
ip_set

kernel/net/netfilter/ipset/ip_set.ko.xz nfnetlink_subsys_6 symbol:ip_set_type_register symbol:ip_set_type_unregister symbol:ip_set_alloc symbol:ip_set_free symbol:ip_set_get_ipaddr4 symbol:ip_set_get_ipaddr6 symbol:ip_set_init_comment symbol:ip_set_extensions symbol:ip_set_elem_len symbol:ip_set_get_extensions symbol:ip_set_put_extensions symbol:ip_set_match_extensions symbol:ip_set_test symbol:ip_set_add symbol:ip_set_del symbol:ip_set_get_byname symbol:ip_set_put_byindex symbol:ip_set_name_byindex symbol:ip_set_nfnl_get_byindex symbol:ip_set_nfnl_put symbol:ip_set_put_flags symbol:ip_set_get_ip4_port symbol:ip_set_get_ip6_port symbol:ip_set_netmask_map symbol:ip_set_hostmask_map symbol:ip_set_range_to_cidr
nfnetlink

kernel/net/netfilter/ipset/ip_set_bitmap_ip.ko.xz ip_set_bitmap:ip
ip_set

kernel/net/netfilter/ipset/ip_set_hash_netiface.ko.xz ip_set_hash:net,iface
ip_set

kernel/net/netfilter/xt_DSCP.ko.xz ip6t_TOS ipt_TOS ip6t_DSCP ipt_DSCP
x_tables

kernel/net/netfilter/nfnetlink_acct.ko.xz nfnetlink_subsys_7 symbol:nfnl_acct_find_get symbol:nfnl_acct_put symbol:nfnl_acct_update symbol:nfnl_acct_overquota
nfnetlink

kernel/net/netfilter/nf_conntrack_snmp.ko.xz nfct_helper_snmp symbol:nf_nat_snmp_hook
nf_conntrack nf_conntrack_broadcast

kernel/net/netfilter/xt_LOG.ko.xz ip6t_LOG ipt_LOG
x_tables

kernel/net/netfilter/xt_osf.ko.xz ip6t_osf ipt_osf
x_tables nfnetlink_osf

kernel/net/netfilter/xt_length.ko.xz ip6t_length ipt_length
x_tables

kernel/net/netfilter/xt_policy.ko.xz ip6t_policy ipt_policy
x_tables

kernel/net/netfilter/nf_conntrack_ftp.ko.xz nfct_helper_ftp ip_conntrack_ftp symbol:nf_nat_ftp_hook
nf_conntrack

kernel/net/netfilter/xt_connbytes.ko.xz ip6t_connbytes ipt_connbytes
x_tables nf_conntrack

kernel/net/netfilter/xt_connlimit.ko.xz ip6t_connlimit ipt_connlimit
x_tables nf_conncount nf_conntrack

kernel/net/netfilter/xt_limit.ko.xz ip6t_limit ipt_limit
x_tables

kernel/net/netfilter/xt_u32.ko.xz ip6t_u32 ipt_u32
x_tables

kernel/net/netfilter/xt_NFQUEUE.ko.xz arpt_NFQUEUE ip6t_NFQUEUE ipt_NFQUEUE
x_tables

kernel/net/netfilter/nft_synproxy.ko.xz nft_obj_10 nft_expr_synproxy
nf_tables nf_synproxy_core nf_conntrack

kernel/net/netfilter/nft_chain_nat.ko.xz nft_chain_1_nat nft_chain_10_nat nft_chain_2_nat
nf_tables nf_nat

kernel/net/netfilter/xt_dscp.ko.xz ip6t_tos ipt_tos ip6t_dscp ipt_dscp
x_tables

kernel/net/netfilter/nft_socket.ko.xz nft_expr_socket
nf_tables nf_socket_ipv4 nf_socket_ipv6

kernel/net/netfilter/nf_conntrack_h323.ko.xz nfct_helper_H.245 nfct_helper_Q.931 nfct_helper_RAS ip_conntrack_h323 symbol:nfct_h323_nat_hook symbol:get_h225_addr
nf_conntrack

kernel/net/netfilter/nft_flow_offload.ko.xz nft_expr_flow_offload
nf_tables nf_conntrack nf_flow_table

kernel/net/netfilter/xt_TRACE.ko.xz ip6t_TRACE ipt_TRACE
x_tables

kernel/net/netfilter/xt_multiport.ko.xz ip6t_multiport ipt_multiport
x_tables

kernel/net/netfilter/nft_queue.ko.xz nft_expr_queue
nf_tables

kernel/net/netfilter/nft_connlimit.ko.xz nft_obj_5 nft_expr_connlimit
nf_tables nf_conncount nf_conntrack

kernel/net/netfilter/xt_time.ko.xz ip6t_time ipt_time
x_tables

kernel/net/netfilter/xt_TCPOPTSTRIP.ko.xz ip6t_TCPOPTSTRIP ipt_TCPOPTSTRIP
x_tables

kernel/net/netfilter/xt_conntrack.ko.xz ip6t_conntrack ipt_conntrack
x_tables nf_conntrack

kernel/net/netfilter/nft_reject_inet.ko.xz nft_expr_1_reject
nf_tables nf_reject_ipv6 nf_reject_ipv4 nft_reject

kernel/net/netfilter/xt_HL.ko.xz ip6t_HL ipt_TTL
x_tables

kernel/net/netfilter/xt_connlabel.ko.xz ip6t_connlabel ipt_connlabel
x_tables nf_conntrack

kernel/net/netfilter/xt_TPROXY.ko.xz ip6t_TPROXY ipt_TPROXY
x_tables nf_defrag_ipv6 nf_defrag_ipv4 nf_tproxy_ipv6 nf_tproxy_ipv4

kernel/net/netfilter/nfnetlink_osf.ko.xz nfnetlink_subsys_5 symbol:nf_osf_fingers symbol:nf_osf_match symbol:nf_osf_find
nfnetlink

kernel/net/netfilter/nf_flow_table.ko.xz symbol:flow_offload_alloc symbol:flow_offload_route_init symbol:flow_offload_free symbol:flow_offload_add symbol:flow_offload_refresh symbol:flow_offload_teardown symbol:flow_offload_lookup symbol:nf_flow_snat_port symbol:nf_flow_dnat_port symbol:nf_flow_table_init symbol:nf_flow_table_cleanup symbol:nf_flow_table_free symbol:nf_flow_offload_ip_hook symbol:nf_flow_offload_ipv6_hook symbol:nf_flow_rule_route_ipv4 symbol:nf_flow_rule_route_ipv6 symbol:nf_flow_table_offload_setup
nf_conntrack

kernel/net/netfilter/xt_realm.ko.xz ipt_realm
x_tables

kernel/net/netfilter/nf_conntrack_tftp.ko.xz nfct_helper_tftp ip_conntrack_tftp symbol:nf_nat_tftp_hook
nf_conntrack

kernel/net/netfilter/xt_REDIRECT.ko.xz ipt_REDIRECT ip6t_REDIRECT
x_tables nf_conntrack nf_nat

kernel/net/netfilter/nf_conntrack_pptp.ko.xz nfct_helper_pptp ip_conntrack_pptp symbol:nf_nat_pptp_hook
nf_conntrack

kernel/net/netfilter/xt_mark.ko.xz arpt_MARK ip6t_MARK ipt_MARK ip6t_mark ipt_mark
x_tables

kernel/net/netfilter/nf_conntrack_amanda.ko.xz nfct_helper_amanda ip_conntrack_amanda symbol:nf_nat_amanda_hook
nf_conntrack

kernel/net/netfilter/nf_flow_table_inet.ko.xz nf_flowtable_1 nf_flowtable_10 nf_flowtable_2
nf_tables nf_flow_table

kernel/net/netfilter/nft_compat.ko.xz nft_expr_target nft_expr_match nfnetlink_subsys_11
nf_tables nfnetlink x_tables

kernel/net/netfilter/nf_nat_ftp.ko.xz ip_nat_ftp
nf_conntrack_ftp nf_conntrack nf_nat

kernel/net/netfilter/nft_masq.ko.xz nft_expr_masq
nf_tables nf_nat nf_conntrack

kernel/net/netfilter/xt_bpf.ko.xz ip6t_bpf ipt_bpf
x_tables

kernel/net/netfilter/xt_state.ko.xz ip6t_state ipt_state
x_tables nf_conntrack

kernel/net/netfilter/xt_IDLETIMER.ko.xz ip6t_IDLETIMER ipt_IDLETIMER
x_tables

kernel/net/netfilter/nf_nat_tftp.ko.xz ip_nat_tftp
nf_conntrack_tftp nf_conntrack nf_nat

kernel/net/netfilter/xt_NETMAP.ko.xz ipt_NETMAP ip6t_NETMAP
x_tables nf_conntrack nf_nat

kernel/net/netfilter/nft_redir.ko.xz nft_expr_redir
nf_tables nf_conntrack nf_nat

kernel/net/netfilter/xt_connmark.ko.xz ip6t_connmark ipt_connmark ip6t_CONNMARK ipt_CONNMARK
x_tables nf_conntrack

kernel/net/netfilter/nfnetlink.ko.xz net_pf_16_proto_12 symbol:nfnl_lock symbol:nfnl_unlock symbol:nfnetlink_subsys_register symbol:nfnetlink_subsys_unregister symbol:nfnetlink_has_listeners symbol:nfnetlink_send symbol:nfnetlink_set_err symbol:nfnetlink_unicast symbol:nfnetlink_broadcast

kernel/net/netfilter/xt_TCPMSS.ko.xz ip6t_TCPMSS ipt_TCPMSS
x_tables

kernel/net/netfilter/nft_quota.ko.xz nft_obj_2 nft_expr_quota
nf_tables

kernel/net/netfilter/nft_tunnel.ko.xz nft_obj_6 nft_expr_tunnel
nf_tables

kernel/net/netfilter/xt_set.ko.xz ip6t_SET ipt_SET ip6t_set ipt_set xt_SET
x_tables ip_set

kernel/net/netfilter/xt_nfacct.ko.xz ip6t_nfacct ipt_nfacct
x_tables nfnetlink_acct

kernel/net/netfilter/xt_addrtype.ko.xz ip6t_addrtype ipt_addrtype
x_tables

kernel/net/netfilter/nft_fib_inet.ko.xz nft_expr_1_fib
nf_tables nft_fib_ipv6 nft_fib_ipv4 nft_fib

kernel/net/netfilter/xt_string.ko.xz ebt_string ip6t_string ipt_string
x_tables

kernel/net/netfilter/x_tables.ko.xz symbol:xt_register_target symbol:xt_unregister_target symbol:xt_register_targets symbol:xt_unregister_targets symbol:xt_register_match symbol:xt_unregister_match symbol:xt_register_matches symbol:xt_unregister_matches symbol:xt_find_match symbol:xt_request_find_match symbol:xt_request_find_target symbol:xt_data_to_user symbol:xt_match_to_user symbol:xt_target_to_user symbol:xt_find_revision symbol:xt_check_proc_name symbol:xt_check_match symbol:xt_check_table_hooks symbol:xt_compat_add_offset symbol:xt_compat_flush_offsets symbol:xt_compat_calc_jump symbol:xt_compat_init_offsets symbol:xt_compat_match_offset symbol:xt_compat_match_from_user symbol:xt_compat_match_to_user symbol:xt_compat_check_entry_offsets symbol:xt_check_entry_offsets symbol:xt_alloc_entry_offsets symbol:xt_find_jump_offset symbol:xt_check_target symbol:xt_copy_counters symbol:xt_compat_target_offset symbol:xt_compat_target_from_user symbol:xt_compat_target_to_user symbol:xt_alloc_table_info symbol:xt_free_table_info symbol:xt_find_table symbol:xt_find_table_lock symbol:xt_request_find_table_lock symbol:xt_table_unlock symbol:xt_compat_lock symbol:xt_compat_unlock symbol:xt_recseq symbol:xt_tee_enabled symbol:xt_counters_alloc symbol:xt_replace_table symbol:xt_register_table symbol:xt_unregister_table symbol:xt_hook_ops_alloc symbol:xt_register_template symbol:xt_unregister_template symbol:xt_proto_init symbol:xt_proto_fini symbol:xt_percpu_counter_alloc symbol:xt_percpu_counter_free

kernel/net/netfilter/xt_nat.ko.xz ip6t_DNAT ip6t_SNAT ipt_DNAT ipt_SNAT
x_tables nf_nat nf_conntrack

kernel/net/netfilter/nft_dup_netdev.ko.xz nft_expr_5_dup
nf_tables nf_dup_netdev

kernel/net/netfilter/xt_ipvs.ko.xz ip6t_ipvs ipt_ipvs
x_tables ip_vs

kernel/net/netfilter/nft_fib_netdev.ko.xz nft_expr_5_fib
nf_tables ipv6 nft_fib_ipv6 nft_fib_ipv4 nft_fib

kernel/net/netfilter/nft_nat.ko.xz nft_expr_nat
nf_tables nf_conntrack nf_nat

kernel/net/netfilter/xt_HMARK.ko.xz ip6t_HMARK ipt_HMARK
x_tables

kernel/net/netfilter/xt_socket.ko.xz ip6t_socket ipt_socket
x_tables nf_socket_ipv6 nf_defrag_ipv6 nf_defrag_ipv4 nf_socket_ipv4

kernel/net/netfilter/nf_log_syslog.ko.xz nf_logger_10_0 nf_logger_5_0 nf_logger_3_0 nf_logger_2_0 nf_logger_7_0 nf_log_netdev nf_log_ipv6 nf_log_ipv4 nf_log_bridge nf_log_arp

kernel/net/netfilter/nf_nat_amanda.ko.xz ip_nat_amanda
nf_conntrack_amanda nf_conntrack nf_nat

kernel/net/netfilter/xt_MASQUERADE.ko.xz ipt_MASQUERADE ip6t_MASQUERADE
x_tables nf_nat nf_conntrack

kernel/net/netfilter/xt_tcpmss.ko.xz ip6t_tcpmss ipt_tcpmss
x_tables

kernel/net/netfilter/xt_comment.ko.xz ip6t_comment ipt_comment
x_tables

kernel/net/netfilter/nf_synproxy_core.ko.xz symbol:synproxy_net_id symbol:synproxy_parse_options symbol:synproxy_init_timestamp_cookie symbol:synproxy_send_client_synack symbol:synproxy_recv_client_ack symbol:ipv4_synproxy_hook symbol:nf_synproxy_ipv4_init symbol:nf_synproxy_ipv4_fini symbol:synproxy_send_client_synack_ipv6 symbol:synproxy_recv_client_ack_ipv6 symbol:ipv6_synproxy_hook symbol:nf_synproxy_ipv6_init symbol:nf_synproxy_ipv6_fini
nf_conntrack

kernel/net/netfilter/xt_TEE.ko.xz ip6t_TEE ipt_TEE
x_tables nf_dup_ipv6 nf_dup_ipv4

kernel/net/netfilter/xt_l2tp.ko.xz ip6t_l2tp ipt_l2tp
x_tables

kernel/net/netfilter/nf_conntrack.ko.xz nf_conntrack_10 nf_conntrack_2 ip_conntrack symbol:nf_conntrack_locks symbol:nf_conntrack_expect_lock symbol:nf_conntrack_hash symbol:nf_conntrack_lock symbol:nf_conntrack_htable_size symbol:nf_conntrack_max symbol:nf_ct_get_tuplepr symbol:nf_ct_invert_tuple symbol:nf_ct_get_id symbol:nf_ct_tmpl_alloc symbol:nf_ct_tmpl_free symbol:nf_ct_destroy symbol:nf_ct_delete symbol:nf_conntrack_find_get symbol:nf_conntrack_hash_check_insert symbol:nf_ct_acct_add symbol:__nf_conntrack_confirm symbol:nf_conntrack_tuple_taken symbol:nf_conntrack_alloc symbol:nf_conntrack_free symbol:nf_conntrack_in symbol:__nf_ct_refresh_acct symbol:nf_ct_kill_acct symbol:nf_ct_port_tuple_to_nlattr symbol:nf_ct_port_nla_policy symbol:nf_ct_port_nlattr_to_tuple symbol:nf_ct_port_nlattr_tuple_size symbol:nf_ct_iterate_cleanup_net symbol:nf_ct_iterate_destroy symbol:nf_ct_alloc_hashtable symbol:__nf_ct_change_timeout symbol:__nf_ct_change_status symbol:nf_ct_change_status_common symbol:nf_conntrack_count symbol:nf_ct_expect_hsize symbol:nf_ct_expect_hash symbol:nf_ct_unlink_expect_report symbol:nf_ct_remove_expect symbol:__nf_ct_expect_find symbol:nf_ct_expect_find_get symbol:nf_ct_remove_expectations symbol:nf_ct_unexpect_related symbol:nf_ct_expect_alloc symbol:nf_ct_expect_init symbol:nf_ct_expect_put symbol:nf_ct_expect_related_report symbol:nf_ct_expect_iterate_destroy symbol:nf_ct_expect_iterate_net symbol:nf_ct_helper_hash symbol:nf_ct_helper_hsize symbol:__nf_conntrack_helper_find symbol:nf_conntrack_helper_try_module_get symbol:nf_conntrack_helper_put symbol:nf_nat_helper_try_module_get symbol:nf_nat_helper_put symbol:nf_ct_helper_ext_add symbol:__nf_ct_try_assign_helper symbol:nf_ct_helper_expectfn_register symbol:nf_ct_helper_expectfn_unregister symbol:nf_ct_helper_expectfn_find_by_name symbol:nf_ct_helper_expectfn_find_by_symbol symbol:nf_ct_helper_log symbol:nf_conntrack_helper_register symbol:nf_conntrack_helper_unregister symbol:nf_ct_helper_init symbol:nf_conntrack_helpers_register symbol:nf_conntrack_helpers_unregister symbol:nf_nat_helper_register symbol:nf_nat_helper_unregister symbol:nf_l4proto_log_invalid symbol:nf_ct_l4proto_log_invalid symbol:nf_ct_l4proto_find symbol:nf_confirm symbol:nf_ct_netns_get symbol:nf_ct_netns_put symbol:nf_ct_bridge_register symbol:nf_ct_bridge_unregister symbol:nf_ct_ext_add symbol:__nf_ct_ext_find symbol:nf_ct_seqadj_init symbol:nf_ct_seqadj_set symbol:nf_ct_tcp_seqadj_set symbol:nf_ct_seq_adjust symbol:nf_ct_seq_offset symbol:nf_conn_pernet_ecache symbol:nf_conntrack_eventmask_report symbol:nf_ct_deliver_cached_events symbol:nf_conntrack_register_notifier symbol:nf_conntrack_unregister_notifier symbol:nf_ct_ecache_ext_add symbol:nf_connlabels_replace symbol:nf_connlabels_get symbol:nf_connlabels_put symbol:nf_ct_helper symbol:nf_ct_add_helper symbol:nf_ct_skb_network_trim symbol:nf_ct_handle_fragments symbol:nf_ct_gre_keymap_add symbol:nf_ct_gre_keymap_destroy
nf_defrag_ipv4 nf_defrag_ipv6

kernel/net/netfilter/xt_mac.ko.xz ip6t_mac ipt_mac
x_tables

kernel/net/netfilter/nf_nat.ko.xz symbol:nf_ct_nat_ext_add symbol:nf_nat_setup_info symbol:nf_nat_alloc_null_binding symbol:nf_nat_packet symbol:nf_nat_inet_fn symbol:nf_nat_icmp_reply_translation symbol:nf_nat_ipv4_register_fn symbol:nf_nat_ipv4_unregister_fn symbol:nf_nat_icmpv6_reply_translation symbol:nf_nat_ipv6_register_fn symbol:nf_nat_ipv6_unregister_fn symbol:nf_nat_inet_register_fn symbol:nf_nat_inet_unregister_fn symbol:__nf_nat_mangle_tcp_packet symbol:nf_nat_mangle_udp_packet symbol:nf_nat_follow_master symbol:nf_nat_exp_find_port symbol:nf_nat_redirect_ipv4 symbol:nf_nat_redirect_ipv6 symbol:nf_nat_masquerade_ipv4 symbol:nf_nat_masquerade_ipv6 symbol:nf_nat_masquerade_inet_register_notifiers symbol:nf_nat_masquerade_inet_unregister_notifiers symbol:nf_ct_nat
nf_conntrack

kernel/net/netfilter/nft_tproxy.ko.xz nft_expr_tproxy
nf_tables nf_defrag_ipv4 nf_defrag_ipv6 nf_tproxy_ipv6 nf_tproxy_ipv4

kernel/net/netfilter/xt_dccp.ko.xz ip6t_dccp ipt_dccp
x_tables

kernel/net/netfilter/nf_conncount.ko.xz symbol:nf_conncount_add_skb symbol:nf_conncount_list_init symbol:nf_conncount_gc_list symbol:nf_conncount_count_skb symbol:nf_conncount_init symbol:nf_conncount_cache_free symbol:nf_conncount_destroy
nf_conntrack

kernel/net/netfilter/nft_xfrm.ko.xz nft_expr_xfrm
nf_tables

kernel/net/netfilter/nf_conntrack_netlink.ko.xz nfnetlink_subsys_2 nfnetlink_subsys_1 ip_conntrack_netlink
nfnetlink nf_conntrack

kernel/net/netfilter/xt_LED.ko.xz ip6t_LED ipt_LED
x_tables

kernel/net/netfilter/nf_conntrack_sip.ko.xz nfct_helper_sip ip_conntrack_sip symbol:nf_nat_sip_hooks symbol:ct_sip_parse_request symbol:ct_sip_get_header symbol:ct_sip_parse_header_uri symbol:ct_sip_parse_address_param symbol:ct_sip_parse_numerical_param symbol:ct_sip_get_sdp_header
nf_conntrack

kernel/net/netfilter/nft_hash.ko.xz nft_expr_hash
nf_tables

kernel/net/netfilter/xt_owner.ko.xz ip6t_owner ipt_owner
x_tables

kernel/net/netfilter/xt_CLASSIFY.ko.xz arpt_CLASSIFY ip6t_CLASSIFY ipt_CLASSIFY
x_tables

kernel/net/netfilter/xt_esp.ko.xz ip6t_esp ipt_esp
x_tables

kernel/net/netfilter/xt_CHECKSUM.ko.xz ip6t_CHECKSUM ipt_CHECKSUM
x_tables

kernel/net/netfilter/xt_RATEEST.ko.xz ip6t_RATEEST ipt_RATEEST symbol:xt_rateest_lookup symbol:xt_rateest_put
x_tables

kernel/net/netfilter/nfnetlink_log.ko.xz nf_logger_5_1 nf_logger_3_1 nf_logger_7_1 nf_logger_10_1 nf_logger_2_1 nfnetlink_subsys_4
nfnetlink

kernel/net/netfilter/nf_conntrack_sane.ko.xz nfct_helper_sane
nf_conntrack

kernel/net/netfilter/xt_statistic.ko.xz ip6t_statistic ipt_statistic
x_tables

kernel/net/netfilter/xt_hashlimit.ko.xz ip6t_hashlimit ipt_hashlimit
x_tables

kernel/net/netfilter/nf_dup_netdev.ko.xz symbol:nf_fwd_netdev_egress symbol:nf_dup_netdev_egress symbol:nft_fwd_dup_netdev_offload

kernel/net/netfilter/nft_log.ko.xz nft_expr_log
nf_tables

kernel/net/netfilter/nft_osf.ko.xz nft_expr_osf
nf_tables nfnetlink_osf

kernel/net/netfilter/xt_pkttype.ko.xz ip6t_pkttype ipt_pkttype
x_tables

kernel/net/netfilter/xt_physdev.ko.xz ip6t_physdev ipt_physdev
x_tables

kernel/net/netfilter/xt_cluster.ko.xz ip6t_cluster ipt_cluster
x_tables nf_conntrack

kernel/net/netfilter/xt_quota.ko.xz ip6t_quota ipt_quota
x_tables

kernel/net/netfilter/xt_cpu.ko.xz ip6t_cpu ipt_cpu
x_tables

kernel/net/netfilter/nf_conntrack_irc.ko.xz nfct_helper_irc ip_conntrack_irc symbol:nf_nat_irc_hook
nf_conntrack

kernel/net/netfilter/nft_fwd_netdev.ko.xz nft_expr_5_fwd
nf_tables nf_dup_netdev

kernel/net/netfilter/xt_devgroup.ko.xz ip6t_devgroup ipt_devgroup
x_tables

kernel/net/netfilter/xt_helper.ko.xz ip6t_helper ipt_helper
x_tables nf_conntrack

kernel/net/netfilter/nf_nat_sip.ko.xz ip_nat_sip
nf_conntrack_sip nf_conntrack nf_nat

kernel/net/netfilter/nf_nat_irc.ko.xz ip_nat_irc
nf_conntrack_irc nf_conntrack nf_nat

kernel/net/netfilter/xt_NFLOG.ko.xz ip6t_NFLOG ipt_NFLOG
x_tables

kernel/net/rfkill/rfkill.ko.xz devname:rfkill char_major_10_242 symbol:rfkill_get_led_trigger_name symbol:rfkill_set_led_trigger_name symbol:rfkill_set_hw_state_reason symbol:rfkill_set_sw_state symbol:rfkill_init_sw_state symbol:rfkill_set_states symbol:rfkill_find_type symbol:rfkill_pause_polling symbol:rfkill_resume_polling symbol:rfkill_blocked symbol:rfkill_soft_blocked symbol:rfkill_alloc symbol:rfkill_register symbol:rfkill_unregister symbol:rfkill_destroy

kernel/net/ipv6/ip6_tunnel.ko.xz netdev_ip6tnl0 rtnl_link_ip6tnl symbol:ip6_tnl_parse_tlv_enc_lim symbol:ip6_tnl_get_cap symbol:ip6_tnl_rcv_ctl symbol:ip6_tnl_rcv symbol:ip6_tnl_xmit_ctl symbol:ip6_tnl_xmit symbol:ip6_tnl_change_mtu symbol:ip6_tnl_get_iflink symbol:ip6_tnl_encap_add_ops symbol:ip6_tnl_encap_del_ops symbol:ip6_tnl_encap_setup symbol:ip6_tnl_get_link_net
ipv6 tunnel6

kernel/net/ipv6/sit.ko.xz netdev_sit0 rtnl_link_sit
tunnel4 ipv6 ip_tunnel

kernel/net/ipv6/ila/ila.ko.xz
ipv6

kernel/net/ipv6/ah6.ko.xz xfrm_type_10_51
ipv6 xfrm_algo

kernel/net/ipv6/ip6_vti.ko.xz netdev_ip6_vti0 rtnl_link_vti6
ipv6 tunnel6 ip6_tunnel xfrm6_tunnel

kernel/net/ipv6/xfrm6_tunnel.ko.xz xfrm_type_10_41 symbol:xfrm6_tunnel_spi_lookup symbol:xfrm6_tunnel_alloc_spi
tunnel6 ipv6

kernel/net/ipv6/ip6_gre.ko.xz netdev_ip6gre0 rtnl_link_ip6erspan rtnl_link_ip6gretap rtnl_link_ip6gre
ip6_tunnel ipv6 gre

kernel/net/ipv6/esp6.ko.xz xfrm_type_10_50 symbol:esp6_output_head symbol:esp6_output_tail symbol:esp6_input_done2
ipv6 xfrm_algo

kernel/net/ipv6/tunnel6.ko.xz symbol:xfrm6_tunnel_register symbol:xfrm6_tunnel_deregister

kernel/net/ipv6/esp6_offload.ko.xz xfrm_offload_10_50
esp6

kernel/net/ipv6/netfilter/ip6t_NPT.ko.xz ip6t_DNPT ip6t_SNPT
x_tables

kernel/net/ipv6/netfilter/ip6t_eui64.ko.xz
x_tables

kernel/net/ipv6/netfilter/nf_dup_ipv6.ko.xz symbol:nf_dup_ipv6
ipv6

kernel/net/ipv6/netfilter/ip6t_frag.ko.xz
x_tables

kernel/net/ipv6/netfilter/ip6t_SYNPROXY.ko.xz
x_tables nf_synproxy_core nf_conntrack

kernel/net/ipv6/netfilter/nf_socket_ipv6.ko.xz symbol:nf_sk_lookup_slow_v6
ipv6

kernel/net/ipv6/netfilter/nf_defrag_ipv6.ko.xz symbol:nf_defrag_ipv6_enable symbol:nf_defrag_ipv6_disable symbol:nf_ct_frag6_gather

kernel/net/ipv6/netfilter/ip6t_hbh.ko.xz ip6t_dst
x_tables

kernel/net/ipv6/netfilter/ip6_tables.ko.xz symbol:ip6t_alloc_initial_table symbol:ip6t_register_table symbol:ip6t_unregister_table_pre_exit symbol:ip6t_unregister_table_exit symbol:ip6t_do_table
x_tables

kernel/net/ipv6/netfilter/ip6t_ipv6header.ko.xz
x_tables

kernel/net/ipv6/netfilter/ip6table_nat.ko.xz
x_tables ip6_tables nf_nat

kernel/net/ipv6/netfilter/ip6table_filter.ko.xz
ip6_tables x_tables

kernel/net/ipv6/netfilter/ip6t_REJECT.ko.xz
x_tables nf_reject_ipv6

kernel/net/ipv6/netfilter/nft_fib_ipv6.ko.xz nft_expr_10_fib symbol:nft_fib6_eval_type symbol:nft_fib6_eval
nf_tables nft_fib ipv6

kernel/net/ipv6/netfilter/nf_reject_ipv6.ko.xz symbol:nf_reject_skb_v6_tcp_reset symbol:nf_reject_skb_v6_unreach symbol:nf_reject_ip6_tcphdr_get symbol:nf_reject_ip6hdr_put symbol:nf_reject_ip6_tcphdr_put symbol:nf_send_reset6 symbol:nf_send_unreach6
ipv6

kernel/net/ipv6/netfilter/ip6table_raw.ko.xz
ip6_tables x_tables

kernel/net/ipv6/netfilter/ip6table_mangle.ko.xz
ip6_tables ipv6 x_tables

kernel/net/ipv6/netfilter/nft_dup_ipv6.ko.xz nft_expr_10_dup
nf_tables nf_dup_ipv6

kernel/net/ipv6/netfilter/ip6table_security.ko.xz
ip6_tables x_tables

kernel/net/ipv6/netfilter/ip6t_rt.ko.xz
x_tables

kernel/net/ipv6/netfilter/nft_reject_ipv6.ko.xz nft_expr_10_reject
nf_tables nf_reject_ipv6 nft_reject

kernel/net/ipv6/netfilter/ip6t_srh.ko.xz
x_tables

kernel/net/ipv6/netfilter/ip6t_rpfilter.ko.xz
x_tables ipv6

kernel/net/ipv6/netfilter/ip6t_mh.ko.xz
x_tables

kernel/net/ipv6/netfilter/nf_tproxy_ipv6.ko.xz symbol:nf_tproxy_laddr6 symbol:nf_tproxy_handle_time_wait6 symbol:nf_tproxy_get_sock_v6
ipv6

kernel/net/ipv6/netfilter/ip6t_ah.ko.xz
x_tables

kernel/net/ipv6/ipv6.ko.xz net_pf_10 symbol:ipv6_mod_enabled symbol:inet6_sock_destruct symbol:inet6_bind symbol:inet6_release symbol:inet6_cleanup_sock symbol:inet6_getname symbol:inet6_ioctl symbol:inet6_compat_ioctl symbol:inet6_register_protosw symbol:inet6_unregister_protosw symbol:inet6_sk_rebuild_header symbol:ipv6_opt_accepted symbol:ip6_output symbol:ip6_xmit symbol:ip6_fraglist_init symbol:ip6_fraglist_prepare symbol:ip6_frag_init symbol:ip6_frag_next symbol:ip6_dst_lookup symbol:ip6_dst_lookup_flow symbol:ip6_sk_dst_lookup_flow symbol:ip6_append_data symbol:ip6_push_pending_frames symbol:ip6_flush_pending_frames symbol:ip6_input symbol:ipv6_dev_get_saddr symbol:ipv6_chk_addr symbol:ipv6_chk_addr_and_flags symbol:ipv6_chk_custom_prefix symbol:ipv6_chk_prefix symbol:ipv6_dev_find symbol:addrconf_prefix_rcv_add_addr symbol:addrconf_add_linklocal symbol:__tracepoint_fib6_table_lookup symbol:__traceiter_fib6_table_lookup symbol:__SCK__tp_func_fib6_table_lookup symbol:ip6_dst_alloc symbol:ip6_route_lookup symbol:rt6_lookup symbol:ip6_pol_route symbol:ip6_route_input_lookup symbol:ip6_route_output_flags symbol:ip6_update_pmtu symbol:ip6_sk_update_pmtu symbol:ip6_redirect symbol:ip6_sk_redirect symbol:fib6_info_hw_flags_set symbol:fib6_info_destroy_rcu symbol:fib6_new_table symbol:fib6_get_table symbol:ipv6_setsockopt symbol:ipv6_getsockopt symbol:nd_tbl symbol:__ndisc_fill_addr_option symbol:ndisc_mc_map symbol:ndisc_send_skb symbol:ndisc_ns_create symbol:__udp6_lib_lookup symbol:udp6_lib_lookup symbol:udpv6_encap_enable symbol:udpv6_sendmsg symbol:udp6_seq_ops symbol:raw_v6_hashinfo symbol:raw_v6_match symbol:icmp6_send symbol:ip6_err_gen_icmpv6_unreach symbol:icmpv6_err_convert symbol:ipv6_sock_mc_join symbol:ipv6_sock_mc_drop symbol:ipv6_dev_mc_inc symbol:ipv6_dev_mc_dec symbol:tcpv6_prot symbol:pingv6_prot symbol:ipv6_push_frag_opts symbol:ipv6_dup_options symbol:__ipv6_fixup_options symbol:fl6_update_dst symbol:ip6_datagram_release_cb symbol:__ip6_datagram_connect symbol:ip6_datagram_connect symbol:ip6_datagram_connect_v6_only symbol:ipv6_icmp_error symbol:ipv6_recv_error symbol:ip6_datagram_recv_ctl symbol:ip6_datagram_send_ctl symbol:ipv6_flowlabel_exclusive symbol:__fl6_sock_lookup symbol:fl6_merge_options symbol:inet6_csk_route_req symbol:inet6_csk_addr2sockaddr symbol:inet6_csk_xmit symbol:inet6_csk_update_pmtu symbol:ip6mr_rule_default symbol:mroute6_is_socket symbol:xfrm6_rcv_spi symbol:xfrm6_rcv_tnl symbol:xfrm6_rcv symbol:xfrm6_input_addr symbol:xfrm6_rcv_encap symbol:xfrm6_protocol_register symbol:xfrm6_protocol_deregister symbol:ip6_route_me_harder symbol:__nf_ip6_route symbol:br_ip6_fragment symbol:fib6_rule_default symbol:__cookie_v6_init_sequence symbol:__cookie_v6_check

kernel/net/ipv6/ipcomp6.ko.xz xfrm_type_10_108
ipv6 xfrm_ipcomp xfrm6_tunnel

kernel/net/ipv6/fou6.ko.xz
ip6_tunnel fou

kernel/net/ipv6/ip6_udp_tunnel.ko.xz symbol:udp_sock_create6 symbol:udp_tunnel6_xmit_skb symbol:udp_tunnel6_dst_lookup

kernel/net/bridge/br_netfilter.ko.xz
bridge ipv6

kernel/net/bridge/bridge.ko.xz rtnl_link_bridge symbol:nf_br_ops symbol:br_fdb_find_port symbol:br_fdb_clear_offload symbol:br_dev_queue_push_xmit symbol:br_forward_finish symbol:br_forward symbol:br_port_flag_is_set symbol:br_handle_frame_finish symbol:br_port_get_stp_state symbol:br_get_ageing_time symbol:br_multicast_enabled symbol:br_multicast_router symbol:br_multicast_list_adjacent symbol:br_multicast_has_querier_anywhere symbol:br_multicast_has_querier_adjacent symbol:br_multicast_has_router_adjacent symbol:br_vlan_enabled symbol:br_vlan_get_proto symbol:br_vlan_get_pvid symbol:br_vlan_get_pvid_rcu symbol:br_vlan_get_info symbol:br_vlan_get_info_rcu symbol:br_mst_enabled symbol:br_mst_get_info symbol:br_mst_get_state
ipv6 llc stp

kernel/net/bridge/netfilter/ebt_log.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_arpreply.ko.xz
x_tables

kernel/net/bridge/netfilter/ebtables.ko.xz symbol:ebt_register_template symbol:ebt_unregister_template symbol:ebt_unregister_table_pre_exit symbol:ebt_register_table symbol:ebt_unregister_table symbol:ebt_do_table
x_tables

kernel/net/bridge/netfilter/ebtable_broute.ko.xz
ebtables

kernel/net/bridge/netfilter/ebtable_nat.ko.xz
ebtables

kernel/net/bridge/netfilter/ebt_dnat.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_mark.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_stp.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_among.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_802_3.ko.xz
x_tables

kernel/net/bridge/netfilter/nft_reject_bridge.ko.xz nft_expr_7_reject
nf_tables nf_reject_ipv4 bridge nf_reject_ipv6 nft_reject

kernel/net/bridge/netfilter/ebt_ip6.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_mark_m.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_snat.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_nflog.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_arp.ko.xz
x_tables

kernel/net/bridge/netfilter/ebtable_filter.ko.xz
ebtables

kernel/net/bridge/netfilter/ebt_pkttype.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_redirect.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_vlan.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_limit.ko.xz
x_tables

kernel/net/bridge/netfilter/ebt_ip.ko.xz
x_tables

kernel/net/mptcp/mptcp_diag.ko.xz net_pf_16_proto_4_type_2_262
inet_diag

kernel/net/nsh/nsh.ko.xz symbol:nsh_push symbol:nsh_pop

kernel/net/mac802154/mac802154.ko.xz symbol:ieee802154_alloc_hw symbol:ieee802154_configure_durations symbol:ieee802154_free_hw symbol:ieee802154_register_hw symbol:ieee802154_unregister_hw symbol:ieee802154_rx_irqsafe symbol:ieee802154_xmit_complete symbol:ieee802154_xmit_error symbol:ieee802154_xmit_hw_error
ieee802154 crc_ccitt

kernel/lib/crypto/libcurve25519.ko.xz

kernel/lib/crypto/libaes.ko.xz symbol:crypto_aes_sbox symbol:crypto_aes_inv_sbox symbol:aes_expandkey symbol:aes_encrypt symbol:aes_decrypt

kernel/lib/crypto/libarc4.ko.xz symbol:arc4_setkey symbol:arc4_crypt

kernel/lib/crypto/libchacha20poly1305.ko.xz symbol:chacha20poly1305_encrypt symbol:xchacha20poly1305_encrypt symbol:chacha20poly1305_decrypt symbol:xchacha20poly1305_decrypt symbol:chacha20poly1305_encrypt_sg_inplace symbol:chacha20poly1305_decrypt_sg_inplace
poly1305_neon chacha_neon

kernel/lib/crypto/libcurve25519-generic.ko.xz symbol:curve25519_null_point symbol:curve25519_base_point symbol:curve25519_generic

kernel/lib/crypto/libchacha.ko.xz symbol:chacha_crypt_generic

kernel/lib/crypto/libpoly1305.ko.xz symbol:poly1305_core_setkey symbol:poly1305_core_blocks symbol:poly1305_core_emit symbol:poly1305_init_generic symbol:poly1305_update_generic symbol:poly1305_final_generic

kernel/lib/crypto/gf128mul.ko.xz symbol:gf128mul_x8_ble symbol:gf128mul_lle symbol:gf128mul_bbe symbol:gf128mul_init_64k_bbe symbol:gf128mul_free_64k symbol:gf128mul_64k_bbe symbol:gf128mul_init_4k_lle symbol:gf128mul_init_4k_bbe symbol:gf128mul_4k_lle symbol:gf128mul_4k_bbe

kernel/lib/crc7.ko.xz symbol:crc7_be_syndrome_table symbol:crc7_be

kernel/lib/math/cordic.ko.xz symbol:cordic_calc_iq

kernel/lib/ts_kmp.ko.xz

kernel/lib/ts_fsm.ko.xz

kernel/lib/lz4/lz4_compress.ko.xz symbol:LZ4_compress_fast symbol:LZ4_compress_default symbol:LZ4_compress_destSize symbol:LZ4_loadDict symbol:LZ4_saveDict symbol:LZ4_compress_fast_continue

kernel/lib/lz4/lz4hc_compress.ko.xz symbol:LZ4_compress_HC symbol:LZ4_resetStreamHC symbol:LZ4_loadDictHC symbol:LZ4_compress_HC_continue symbol:LZ4_saveDictHC

kernel/lib/lru_cache.ko.xz symbol:lc_create symbol:lc_reset symbol:lc_destroy symbol:lc_del symbol:lc_try_get symbol:lc_find symbol:lc_get symbol:lc_put symbol:lc_committed symbol:lc_element_by_index symbol:lc_seq_printf_stats symbol:lc_seq_dump_details symbol:lc_try_lock symbol:lc_is_used symbol:lc_get_cumulative

kernel/lib/raid6/raid6_pq.ko.xz symbol:raid6_empty_zero_page symbol:raid6_call symbol:raid6_2data_recov symbol:raid6_datap_recov symbol:raid6_gfmul symbol:raid6_vgfmul symbol:raid6_gfexp symbol:raid6_gflog symbol:raid6_gfinv symbol:raid6_gfexi

kernel/lib/crc8.ko.xz symbol:crc8_populate_msb symbol:crc8_populate_lsb symbol:crc8

kernel/lib/crc-ccitt.ko.xz symbol:crc_ccitt_table symbol:crc_ccitt

kernel/lib/ts_bm.ko.xz

kernel/drivers/uio/uio_pdrv_genirq.ko.xz platform:uio_pdrv_genirq of:N*T*C* of:N*T*
uio

kernel/drivers/uio/uio.ko.xz symbol:uio_event_notify symbol:__uio_register_device symbol:__devm_uio_register_device symbol:uio_unregister_device

kernel/drivers/hid/hid-roccat-pyra.ko.xz hid:b0003g*v00001E7Dp00002CF6 hid:b0003g*v00001E7Dp00002C24
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-ezkey.ko.xz hid:b0003g*v00000518p00000002

kernel/drivers/hid/hid-led.ko.xz hid:b0003g*v000004D8p0000F372 hid:b0003g*v00000FC5p0000B080 hid:b0003g*v000027B8p000001ED hid:b0003g*v00001D34p0000000A hid:b0003g*v00001D34p00000004 hid:b0003g*v00001294p00001320

kernel/drivers/hid/hid-topseed.ko.xz hid:b0005g*v000004F2p00001408 hid:b0003g*v000004F2p00000618 hid:b0003g*v00001784p00000004 hid:b0003g*v0000046Ep00005577 hid:b0003g*v0000046Ep00005578 hid:b0003g*v00000766p00000204

kernel/drivers/hid/hid-roccat-kovaplus.ko.xz hid:b0003g*v00001E7Dp00002D50
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-gyration.ko.xz hid:b0003g*v00000C16p00000008 hid:b0003g*v00000C16p00000003 hid:b0003g*v00000C16p00000002

kernel/drivers/hid/hid-roccat-arvo.ko.xz hid:b0003g*v00001E7Dp000030D4
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-emsff.ko.xz hid:b0003g*v00002006p00000118
ff_memless

kernel/drivers/hid/hid-uclogic.ko.xz hid:b0003g*v000028BDp00000078 hid:b0003g*v000028BDp00000933 hid:b0003g*v000028BDp00000909 hid:b0003g*v000028BDp00000934 hid:b0003g*v000028BDp00000935 hid:b0003g*v000028BDp00000905 hid:b0003g*v000028BDp00000042 hid:b0003g*v000028BDp00000094 hid:b0003g*v000028BDp00000075 hid:b0003g*v000028BDp00000055 hid:b0003g*v000028BDp00000071 hid:b0003g*v000028BDp00000074 hid:b0003g*v000028BDp00001903 hid:b0003g*v00002179p00000077 hid:b0003g*v00002179p00000053 hid:b0003g*v00005543p00003031 hid:b0003g*v00005543p00000047 hid:b0003g*v00005543p00000045 hid:b0003g*v00005543p00000081 hid:b0003g*v00005543p0000004D hid:b0003g*v00005543p0000006E hid:b0003g*v0000145Fp00000212 hid:b0003g*v0000256Cp0000006D hid:b0003g*v0000256Cp0000006E hid:b0003g*v00005543p00000781 hid:b0003g*v00005543p00000522 hid:b0003g*v00005543p00000064 hid:b0003g*v00005543p00000005 hid:b0003g*v00005543p00000004 hid:b0003g*v00005543p00000003 hid:b0003g*v00005543p00000042

kernel/drivers/hid/hid-roccat-savu.ko.xz hid:b0003g*v00001E7Dp00002D5A
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-holtek-mouse.ko.xz hid:b0003g*v000004D9p0000A0C2 hid:b0003g*v000004D9p0000A081 hid:b0003g*v000004D9p0000A072 hid:b0003g*v000004D9p0000A04A hid:b0003g*v000004D9p0000A070 hid:b0003g*v000004D9p0000A067

kernel/drivers/hid/hid-logitech-hidpp.ko.xz hid:b0005g*v0000046Dp0000B038 hid:b0005g*v0000046Dp0000B034 hid:b0005g*v0000046Dp0000B025 hid:b0005g*v0000046Dp0000B023 hid:b0005g*v0000046Dp0000B02A hid:b0005g*v0000046Dp0000B020 hid:b0005g*v0000046Dp0000B01E hid:b0005g*v0000046Dp0000B01D hid:b0005g*v0000046Dp0000B019 hid:b0005g*v0000046Dp0000B015 hid:b0005g*v0000046Dp0000B012 hid:b0005g*v0000046Dp0000B008 hid:b0005g*v0000046Dp0000B35F hid:b0005g*v0000046Dp0000B30B hid:b0005g*v0000046Dp0000B309 hid:b0005g*v0000046Dp0000B305 hid:b0003g*v0000046Dp00000A87 hid:b0003g*v0000046Dp0000C09A hid:b0003g*v0000046Dp0000C09B hid:b0003g*v0000046Dp0000C094 hid:b0003g*v0000046Dp0000C26E hid:b0003g*v0000046Dp0000C262 hid:b0003g*v0000046Dp0000C343 hid:b0003g*v0000046Dp0000C091 hid:b0003g*v0000046Dp0000C090 hid:b0003g*v0000046Dp0000C08A hid:b0003g*v0000046Dp0000C088 hid:b0003g*v0000046Dp0000C086 hid:b0003g*v0000046Dp0000C081 hid:b0003g*v0000046Dp0000C087 hid:b0003g*v0000046Dp0000C08D hid:b0003g*v0000046Dp0000C082 hid:b0003g0104v0000046Dp* hid:b0003g0104v0000046Dp000000FE hid:b0003g0104v0000046Dp0000005C hid:b0003g0104v0000046Dp00000057 hid:b0003g0104v0000046Dp00000049 hid:b0003g0102v0000046Dp* hid:b0003g0102v0000046Dp0000407F hid:b0003g0102v0000046Dp0000B30B hid:b0003g0102v0000046Dp0000B309 hid:b0003g0102v0000046Dp0000B305 hid:b0003g0102v0000046Dp00004002 hid:b0003g0102v0000046Dp00004024 hid:b0003g0102v0000046Dp0000101A hid:b0003g0102v0000046Dp0000101B hid:b0003g0102v0000046Dp0000402D hid:b0003g0102v0000046Dp00001017 hid:b0005g*v0000046Dp0000B00C hid:b0003g0102v0000046Dp00004101 hid:b0003g0102v0000046Dp00004011

kernel/drivers/hid/hid-roccat-koneplus.ko.xz hid:b0003g*v00001E7Dp00002E22 hid:b0003g*v00001E7Dp00002D51
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-speedlink.ko.xz hid:b0003g*v00001AE7p00009001

kernel/drivers/hid/hid-magicmouse.ko.xz hid:b0003g*v000005ACp00000324 hid:b0005g*v0000004Cp00000324 hid:b0003g*v000005ACp00000265 hid:b0005g*v0000004Cp00000265 hid:b0005g*v000005ACp0000030E hid:b0003g*v000005ACp00000269 hid:b0005g*v0000004Cp00000269 hid:b0005g*v000005ACp0000030D

kernel/drivers/hid/hid-microsoft.ko.xz hid:b0005g*v0000045Ep000002E0 hid:b0005g*v0000045Ep00000B22 hid:b0005g*v0000045Ep00000B05 hid:b0005g*v0000045Ep00000B13 hid:b0005g*v0000045Ep00000B20 hid:b0005g*v0000045Ep000002FD hid:b0005g*v0000045Ep0000091B hid:b0005g*v0000045Ep00000701 hid:b0003g*v0000045Ep000000E3 hid:b0003g*v0000045Ep000007DA hid:b0003g*v0000045Ep0000076C hid:b0003g*v0000045Ep0000009D hid:b0003g*v0000045Ep00000732 hid:b0003g*v0000045Ep00000750 hid:b0003g*v0000045Ep000000B4 hid:b0003g*v0000045Ep00000730 hid:b0003g*v0000045Ep00000713 hid:b0003g*v0000045Ep000000F9 hid:b0003g*v0000045Ep0000071D hid:b0003g*v0000045Ep000000DC hid:b0003g*v0000045Ep000000DB hid:b0003g*v0000045Ep00000048 hid:b0003g*v0000045Ep0000003B
ff_memless

kernel/drivers/hid/hid-thrustmaster.ko.xz hid:b0003g*v0000044Fp0000B65D

kernel/drivers/hid/hid-roccat-isku.ko.xz hid:b0003g*v00001E7Dp00003264 hid:b0003g*v00001E7Dp0000319C
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-keytouch.ko.xz hid:b0003g*v00000926p00003333

kernel/drivers/hid/i2c-hid/i2c-hid.ko.xz symbol:i2c_hid_core_probe symbol:i2c_hid_core_remove symbol:i2c_hid_core_shutdown symbol:i2c_hid_core_pm
drm

kernel/drivers/hid/i2c-hid/i2c-hid-of.ko.xz of:N*T*Chid_over_i2cC* of:N*T*Chid_over_i2c i2c:hid_over_i2c i2c:hid
i2c_hid

kernel/drivers/hid/hid-petalynx.ko.xz hid:b0003g*v000018B1p00000037

kernel/drivers/hid/uhid.ko.xz devname:uhid char_major_10_239

kernel/drivers/hid/hid-holtekff.ko.xz hid:b0003g*v00001241p00005015

kernel/drivers/hid/hid-steam.ko.xz hid:b0003g*v000028DEp00001205 hid:b0003g*v000028DEp00001142 hid:b0003g*v000028DEp00001102

kernel/drivers/hid/hid-playstation.ko.xz hid:b0003g*v0000054Cp00000DF2 hid:b0005g*v0000054Cp00000DF2 hid:b0003g*v0000054Cp00000CE6 hid:b0005g*v0000054Cp00000CE6 hid:b0003g*v0000054Cp00000BA0 hid:b0003g*v0000054Cp000009CC hid:b0005g*v0000054Cp000009CC hid:b0003g*v0000054Cp000005C4 hid:b0005g*v0000054Cp000005C4
led_class_multicolor ff_memless

kernel/drivers/hid/hid-bigbenff.ko.xz hid:b0003g*v0000146Bp00000902
ff_memless

kernel/drivers/hid/hid-sunplus.ko.xz hid:b0003g*v000004FCp000005D8

kernel/drivers/hid/hid-asus.ko.xz hid:b0003g0001v00000B05p0000183D hid:b0003g0001v00000B05p00001A30 hid:b0003g*v0000048Dp0000CE50 hid:b0005g*v00000B05p00008502 hid:b0003g*v00000C45p00005112 hid:b0003g*v0000062Ap00005110 hid:b0003g*v000004F2p00001125 hid:b0003g*v00000B05p00001807 hid:b0003g*v00000B05p000017E0 hid:b0003g*v00000B05p0000196B hid:b0003g*v00000B05p00001B4C hid:b0003g*v00000B05p00001ABE hid:b0003g*v00000B05p000018C6 hid:b0003g*v00000B05p000019B6 hid:b0003g*v00000B05p00001866 hid:b0003g*v00000B05p00001869 hid:b0003g*v00000B05p00001822 hid:b0003g*v00000B05p00001837 hid:b0003g*v00000B05p00001854 hid:b0018g*v00000B05p00000101 hid:b0018g*v00000B05p00008585

kernel/drivers/hid/hid-roccat-kone.ko.xz hid:b0003g*v00001E7Dp00002CED
hid_roccat

kernel/drivers/hid/hid-logitech.ko.xz hid:b0003g*v0000046Dp0000C623 hid:b0003g*v0000046Dp0000C626 hid:b0003g*v0000046Dp0000C287 hid:b0003g*v0000046Dp0000C218 hid:b0003g*v0000046Dp0000C293 hid:b0003g*v0000046Dp0000C20E hid:b0003g*v0000046Dp0000C29C hid:b0003g*v0000046Dp0000C298 hid:b0003g*v0000046Dp0000C29B hid:b0003g*v0000046Dp0000C29A hid:b0003g*v0000046Dp0000C299 hid:b0003g*v0000046Dp0000CA04 hid:b0003g*v0000046Dp0000CA03 hid:b0003g*v0000046Dp0000C295 hid:b0003g*v0000046Dp0000C286 hid:b0003g*v0000046Dp0000C283 hid:b0003g*v0000046Dp0000C24F hid:b0003g*v0000046Dp0000C219 hid:b0003g*v0000046Dp0000C211 hid:b0003g*v0000046Dp0000C20A hid:b0003g*v0000046Dp0000C294 hid:b0003g*v0000046Dp0000C216 hid:b0003g*v0000046Dp0000C215 hid:b0003g*v0000046Dp0000C512 hid:b0003g*v0000046Dp0000C30A hid:b0003g*v0000046Dp0000C704 hid:b0003g*v0000046Dp0000C101 hid:b0003g*v0000046Dp0000C50C
ff_memless

kernel/drivers/hid/hid-sjoy.ko.xz hid:b0003g*v00000B43p00000003 hid:b0003g*v00000925p00008866 hid:b0003g*v00000925p00008888 hid:b0003g*v00000925p00000005 hid:b0003g*v00006666p00008804 hid:b0003g*v00006666p00008802 hid:b0003g*v00006666p00008801

kernel/drivers/hid/hid-ortek.ko.xz hid:b0003g*v00001223p00003F07 hid:b0003g*v000005A4p00008003 hid:b0003g*v000005A4p00002000 hid:b0003g*v000005A4p00001700

kernel/drivers/hid/wacom.ko.xz hid:b0005g0101v0000056Ap* hid:b0001g0101v0000056Ap* hid:b0018g0101v0000056Ap* hid:b0003g0101v0000056Ap* hid:b0003g*v000017EFp00006004 hid:b0003g0101v0000056Ap00005002 hid:b0003g0101v0000056Ap00005000 hid:b0003g0101v0000056Ap00004004 hid:b0003g0101v0000056Ap00004001 hid:b0005g0101v0000056Ap000003DD hid:b0005g0101v0000056Ap000003C8 hid:b0005g0101v0000056Ap000003C6 hid:b0005g0101v0000056Ap00000393 hid:b0003g0101v0000056Ap0000037B hid:b0003g0101v0000056Ap0000037A hid:b0005g0101v0000056Ap00000379 hid:b0005g0101v0000056Ap00000377 hid:b0005g0101v0000056Ap00000361 hid:b0005g0101v0000056Ap00000360 hid:b0003g0101v0000056Ap00000343 hid:b0003g0101v0000056Ap0000033E hid:b0003g0101v0000056Ap0000033D hid:b0003g0101v0000056Ap0000033C hid:b0003g0101v0000056Ap0000033B hid:b0003g0101v0000056Ap00000336 hid:b0003g0101v0000056Ap00000335 hid:b0003g0101v0000056Ap00000333 hid:b0003g0101v0000056Ap00000331 hid:b0003g0101v0000056Ap0000032F hid:b0003g0101v0000056Ap0000032C hid:b0003g0101v0000056Ap0000032B hid:b0003g0101v0000056Ap0000032A hid:b0003g0101v0000056Ap00000326 hid:b0003g0101v0000056Ap00000325 hid:b0003g0101v0000056Ap00000323 hid:b0003g0101v0000056Ap00000319 hid:b0003g0101v0000056Ap00000318 hid:b0003g0101v0000056Ap00000317 hid:b0003g0101v0000056Ap00000315 hid:b0003g0101v0000056Ap00000314 hid:b0003g0101v0000056Ap0000030E hid:b0003g0101v0000056Ap0000030C hid:b0003g0101v0000056Ap0000030A hid:b0003g0101v0000056Ap00000309 hid:b0003g0101v0000056Ap00000307 hid:b0003g0101v0000056Ap00000304 hid:b0003g0101v0000056Ap00000303 hid:b0003g0101v0000056Ap00000302 hid:b0003g0101v0000056Ap00000301 hid:b0003g0101v0000056Ap00000300 hid:b0003g0101v0000056Ap0000012C hid:b0003g0101v0000056Ap00000116 hid:b0003g0101v0000056Ap0000010F hid:b0003g0101v0000056Ap0000010E hid:b0003g0101v0000056Ap0000010D hid:b0003g0101v0000056Ap00000101 hid:b0003g0101v0000056Ap00000100 hid:b0003g0101v0000056Ap000000FB hid:b0003g0101v0000056Ap000000FA hid:b0003g0101v0000056Ap000000F8 hid:b0003g0101v0000056Ap000000F6 hid:b0003g0101v0000056Ap000000F4 hid:b0003g0101v0000056Ap000000F0 hid:b0003g0101v0000056Ap000000EF hid:b0003g0101v0000056Ap000000ED hid:b0003g0101v0000056Ap000000EC hid:b0003g0101v0000056Ap000000E6 hid:b0003g0101v0000056Ap000000E5 hid:b0003g0101v0000056Ap000000E3 hid:b0003g0101v0000056Ap000000E2 hid:b0003g0101v0000056Ap000000DF hid:b0003g0101v0000056Ap000000DE hid:b0003g0101v0000056Ap000000DD hid:b0003g0101v0000056Ap000000DB hid:b0003g0101v0000056Ap000000DA hid:b0003g0101v0000056Ap000000D8 hid:b0003g0101v0000056Ap000000D7 hid:b0003g0101v0000056Ap000000D6 hid:b0003g0101v0000056Ap000000D5 hid:b0003g0101v0000056Ap000000D4 hid:b0003g0101v0000056Ap000000D3 hid:b0003g0101v0000056Ap000000D2 hid:b0003g0101v0000056Ap000000D1 hid:b0003g0101v0000056Ap000000D0 hid:b0003g0101v0000056Ap000000CE hid:b0003g0101v0000056Ap000000CC hid:b0003g0101v0000056Ap000000C7 hid:b0003g0101v0000056Ap000000C6 hid:b0003g0101v0000056Ap000000C5 hid:b0003g0101v0000056Ap000000C4 hid:b0003g0101v0000056Ap000000C2 hid:b0003g0101v0000056Ap000000C0 hid:b0005g0101v0000056Ap000000BD hid:b0003g0101v0000056Ap000000BC hid:b0003g0101v0000056Ap000000BB hid:b0003g0101v0000056Ap000000BA hid:b0003g0101v0000056Ap000000B9 hid:b0003g0101v0000056Ap000000B8 hid:b0003g0101v0000056Ap000000B7 hid:b0003g0101v0000056Ap000000B5 hid:b0003g0101v0000056Ap000000B4 hid:b0003g0101v0000056Ap000000B3 hid:b0003g0101v0000056Ap000000B2 hid:b0003g0101v0000056Ap000000B1 hid:b0003g0101v0000056Ap000000B0 hid:b0003g0101v0000056Ap0000009F hid:b0003g0101v0000056Ap0000009A hid:b0003g0101v0000056Ap00000097 hid:b0003g0101v0000056Ap00000094 hid:b0003g0101v0000056Ap00000093 hid:b0003g0101v0000056Ap00000090 hid:b0003g0101v0000056Ap00000084 hid:b0005g0101v0000056Ap00000081 hid:b0003g0101v0000056Ap0000006B hid:b0003g0101v0000056Ap0000006A hid:b0003g0101v0000056Ap00000069 hid:b0003g0101v0000056Ap00000065 hid:b0003g0101v0000056Ap00000064 hid:b0003g0101v0000056Ap00000063 hid:b0003g0101v0000056Ap00000062 hid:b0003g0101v0000056Ap00000061 hid:b0003g0101v0000056Ap00000060 hid:b0003g0101v0000056Ap0000005E hid:b0003g0101v0000056Ap0000005D hid:b0003g0101v0000056Ap0000005B hid:b0003g0101v0000056Ap00000059 hid:b0003g0101v0000056Ap00000057 hid:b0003g0101v0000056Ap00000047 hid:b0003g0101v0000056Ap00000045 hid:b0003g0101v0000056Ap00000044 hid:b0003g0101v0000056Ap00000043 hid:b0003g0101v0000056Ap00000042 hid:b0003g0101v0000056Ap00000041 hid:b0003g0101v0000056Ap0000003F hid:b0003g0101v0000056Ap00000039 hid:b0003g0101v0000056Ap00000038 hid:b0003g0101v0000056Ap00000037 hid:b0003g0101v0000056Ap00000035 hid:b0003g0101v0000056Ap00000034 hid:b0003g0101v0000056Ap00000033 hid:b0003g0101v0000056Ap00000032 hid:b0003g0101v0000056Ap00000031 hid:b0003g0101v0000056Ap00000030 hid:b0003g0101v0000056Ap0000002A hid:b0003g0101v0000056Ap00000029 hid:b0003g0101v0000056Ap00000028 hid:b0003g0101v0000056Ap00000027 hid:b0003g0101v0000056Ap00000026 hid:b0003g0101v0000056Ap00000024 hid:b0003g0101v0000056Ap00000023 hid:b0003g0101v0000056Ap00000022 hid:b0003g0101v0000056Ap00000021 hid:b0003g0101v0000056Ap00000020 hid:b0003g0101v0000056Ap00000019 hid:b0003g0101v0000056Ap00000018 hid:b0003g0101v0000056Ap00000017 hid:b0003g0101v0000056Ap00000016 hid:b0003g0101v0000056Ap00000015 hid:b0003g0101v0000056Ap00000014 hid:b0003g0101v0000056Ap00000013 hid:b0003g0101v0000056Ap00000012 hid:b0003g0101v0000056Ap00000011 hid:b0003g0101v0000056Ap00000010 hid:b0003g0101v0000056Ap00000003 hid:b0003g0101v0000056Ap00000000

kernel/drivers/hid/hid-roccat-konepure.ko.xz hid:b0003g*v00001E7Dp00002DB4 hid:b0003g*v00001E7Dp00002DBE
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-twinhan.ko.xz hid:b0003g*v00006253p00000100

kernel/drivers/hid/hid-cypress.ko.xz hid:b0003g*v000004B4p000007B1 hid:b0003g*v000004B4p00000001 hid:b0003g*v000004B4p0000ED81 hid:b0003g*v000004B4p0000BCA1 hid:b0003g*v000004B4p0000DE64 hid:b0003g*v000004B4p0000DE61

kernel/drivers/hid/hid-zpff.ko.xz hid:b0003g*v00000C12p00000030 hid:b0003g*v00000C12p00000005

kernel/drivers/hid/hid-waltop.ko.xz hid:b0003g*v0000172Fp00000502 hid:b0003g*v0000172Fp00000500 hid:b0003g*v0000172Fp00000501 hid:b0003g*v0000172Fp00000038 hid:b0003g*v0000172Fp00000037 hid:b0003g*v0000172Fp00000034 hid:b0003g*v0000172Fp00000032

kernel/drivers/hid/hid-samsung.ko.xz hid:b0005g*v000004E8p0000A064 hid:b0005g*v000004E8p0000A006 hid:b0005g*v000004E8p0000A004 hid:b0005g*v000004E8p0000A000 hid:b0005g*v000004E8p00007021 hid:b0003g*v00000419p00000600 hid:b0003g*v00000419p00000001

kernel/drivers/hid/hid-elo.ko.xz hid:b0003g*v000004E7p00000030 hid:b0003g*v000004E7p00000009

kernel/drivers/hid/hid-chicony.ko.xz hid:b0003g*v000004F2p00001421 hid:b0003g*v000004F2p00001236 hid:b0003g*v000004F2p00001123 hid:b0003g*v000004F2p00000418

kernel/drivers/hid/hid-axff.ko.xz hid:b0003g*v00001A34p0000F705 hid:b0003g*v00001A34p00000802

kernel/drivers/hid/hid-monterey.ko.xz hid:b0003g*v00000566p00003004

kernel/drivers/hid/hid-elecom.ko.xz hid:b0003g*v0000056Ep0000011C hid:b0003g*v0000056Ep0000010D hid:b0003g*v0000056Ep0000010C hid:b0003g*v0000056Ep000000FF hid:b0003g*v0000056Ep000000FE hid:b0003g*v0000056Ep000000FD hid:b0003g*v0000056Ep000000FC hid:b0003g*v0000056Ep0000018F hid:b0003g*v0000056Ep000000FB hid:b0003g*v0000056Ep000000E6 hid:b0005g*v0000056Ep00000061

kernel/drivers/hid/hid-cherry.ko.xz hid:b0003g*v0000046Ap00000027 hid:b0003g*v0000046Ap00000023

kernel/drivers/hid/hid-apple.ko.xz hid:b0003g*v000005ACp00008102 hid:b0005g*v0000004Cp0000029F hid:b0003g*v000005ACp0000029F hid:b0005g*v0000004Cp0000029A hid:b0003g*v000005ACp0000029A hid:b0005g*v0000004Cp00000320 hid:b0003g*v000005ACp00000320 hid:b0005g*v0000004Cp0000029C hid:b0003g*v000005ACp0000029C hid:b0003g*v000005ACp0000030B hid:b0003g*v000005ACp0000030A hid:b0005g*v000005ACp0000023B hid:b0005g*v000005ACp0000023A hid:b0005g*v000005ACp00000239 hid:b0003g*v000005ACp00000340 hid:b0003g*v000005ACp00000280 hid:b0003g*v000005ACp0000027F hid:b0003g*v000005ACp0000027E hid:b0003g*v000005ACp0000027D hid:b0003g*v000005ACp0000027C hid:b0003g*v000005ACp0000027B hid:b0003g*v000005ACp0000027A hid:b0003g*v000005ACp00000274 hid:b0003g*v000005ACp00000273 hid:b0003g*v000005ACp00000272 hid:b0003g*v000005ACp00000292 hid:b0003g*v000005ACp00000291 hid:b0003g*v000005ACp00000290 hid:b0003g*v000005ACp0000025B hid:b0003g*v000005ACp0000025A hid:b0003g*v000005ACp00000259 hid:b0003g*v000005ACp00000264 hid:b0003g*v000005ACp00000263 hid:b0003g*v000005ACp00000262 hid:b0003g*v000005ACp00000254 hid:b0003g*v000005ACp00000253 hid:b0003g*v000005ACp00000252 hid:b0003g*v000005ACp0000024B hid:b0003g*v000005ACp0000024A hid:b0003g*v000005ACp00000249 hid:b0003g*v000005ACp0000024E hid:b0003g*v000005ACp0000024D hid:b0003g*v000005ACp0000024C hid:b0003g*v000005ACp00000247 hid:b0003g*v000005ACp00000246 hid:b0003g*v000005ACp00000245 hid:b0003g*v000005ACp00000244 hid:b0003g*v000005ACp00000243 hid:b0003g*v000005ACp00000242 hid:b0003g*v000005ACp00000241 hid:b0003g*v000005ACp00000240 hid:b0003g*v000005ACp0000023F hid:b0003g*v000005ACp00000238 hid:b0003g*v000005ACp00000237 hid:b0003g*v000005ACp00000236 hid:b0003g*v000005ACp00000232 hid:b0003g*v000005ACp00000231 hid:b0003g*v000005ACp00000230 hid:b0003g*v000005ACp00000225 hid:b0003g*v000005ACp00000224 hid:b0003g*v000005ACp00000223 hid:b0005g*v0000004Cp0000026C hid:b0003g*v000005ACp0000026C hid:b0005g*v0000004Cp00000267 hid:b0003g*v000005ACp00000267 hid:b0005g*v000005ACp0000022E hid:b0005g*v000005ACp00000257 hid:b0005g*v000005ACp00000255 hid:b0005g*v000005ACp00000256 hid:b0005g*v000005ACp0000022D hid:b0005g*v000005ACp0000022C hid:b0003g*v000005ACp00000251 hid:b0005g*v000005ACp00000250 hid:b0003g*v000005ACp00000250 hid:b0005g*v000005ACp0000024F hid:b0003g*v000005ACp0000024F hid:b0003g*v000005ACp0000022B hid:b0003g*v000005ACp0000022A hid:b0003g*v000005ACp00000229 hid:b0003g*v000005ACp00000222 hid:b0003g*v000005ACp00000221 hid:b0003g*v000005ACp00000220 hid:b0003g*v000005ACp0000021F hid:b0003g*v000005ACp0000021E hid:b0003g*v000005ACp0000021D hid:b0003g*v000005ACp0000021C hid:b0003g*v000005ACp0000021B hid:b0003g*v000005ACp0000021A hid:b0003g*v000005ACp00000219 hid:b0003g*v000005ACp00000218 hid:b0003g*v000005ACp00000217 hid:b0003g*v000005ACp00000216 hid:b0003g*v000005ACp00000215 hid:b0003g*v000005ACp00000214 hid:b0003g*v000005ACp0000020F hid:b0003g*v000005ACp0000020E hid:b0003g*v000005ACp00000304

kernel/drivers/hid/hid-lg-g15.ko.xz hid:b0003g*v0000046Dp00000A07 hid:b0003g*v0000046Dp0000C22E hid:b0003g*v0000046Dp0000C22D hid:b0003g*v0000046Dp0000C227 hid:b0003g*v0000046Dp0000C222 hid:b0003g*v0000046Dp0000C225

kernel/drivers/hid/hid-kye.ko.xz hid:b0003g*v00000458p0000501B hid:b0003g*v00000458p0000501A hid:b0003g*v00000458p00005019 hid:b0003g*v00000458p00005017 hid:b0003g*v00000458p00005016 hid:b0003g*v00000458p00005015 hid:b0003g*v00000458p00005014 hid:b0003g*v00000458p00005013 hid:b0003g*v00000458p00005012 hid:b0003g*v00000458p00005011 hid:b0003g*v00000458p00005010 hid:b0003g*v00000458p0000500F hid:b0003g*v00000458p00005005 hid:b0003g*v00000458p00004018 hid:b0003g*v00000458p00000153 hid:b0003g*v00000458p00000138 hid:b0003g*v00000458p00000087

kernel/drivers/hid/hid-nintendo.ko.xz hid:b0005g*v0000057Ep00002019 hid:b0005g*v0000057Ep0000201E hid:b0005g*v0000057Ep00002017 hid:b0005g*v0000057Ep00002007 hid:b0005g*v0000057Ep00002006 hid:b0003g*v0000057Ep0000200E hid:b0005g*v0000057Ep00002009 hid:b0003g*v0000057Ep00002019 hid:b0003g*v0000057Ep0000201E hid:b0003g*v0000057Ep00002017 hid:b0003g*v0000057Ep00002009
ff_memless

kernel/drivers/hid/hid-xinmo.ko.xz hid:b0003g*v000016C0p000075E1 hid:b0003g*v000016C0p000005E1

kernel/drivers/hid/hid-roccat.ko.xz symbol:roccat_report_event symbol:roccat_connect symbol:roccat_disconnect

kernel/drivers/hid/hid-sony.ko.xz hid:b0003g*v00001430p000007BB hid:b0003g*v000012BAp00000100 hid:b0003g*v00001430p0000474C hid:b0003g*v000012BAp0000074B hid:b0005g*v00000609p00000369 hid:b0005g*v00000609p00000368 hid:b0003g*v00001345p00003008 hid:b0005g*v00000609p00000306 hid:b0005g*v0000046Dp00000306 hid:b0005g*v0000054Cp00000306 hid:b0003g*v0000054Cp00001000 hid:b0003g*v0000054Cp00000002 hid:b0003g*v0000054Cp00000374 hid:b0003g*v0000054Cp0000024B hid:b0005g*v0000054Cp00000268 hid:b0005g*v0000054Cp000003D5 hid:b0003g*v0000054Cp000003D5 hid:b0005g*v0000054Cp0000042F hid:b0003g*v0000054Cp0000042F hid:b0003g*v0000054Cp00000268
ff_memless

kernel/drivers/hid/hid-wiimote.ko.xz hid:b0005g*v0000057Ep00000330 hid:b0005g*v0000057Ep00000306
ff_memless

kernel/drivers/hid/hid-ntrig.ko.xz hid:b0003g*v00001B96p00000014 hid:b0003g*v00001B96p00000013 hid:b0003g*v00001B96p00000012 hid:b0003g*v00001B96p00000011 hid:b0003g*v00001B96p00000010 hid:b0003g*v00001B96p0000000F hid:b0003g*v00001B96p0000000E hid:b0003g*v00001B96p0000000D hid:b0003g*v00001B96p0000000C hid:b0003g*v00001B96p0000000B hid:b0003g*v00001B96p0000000A hid:b0003g*v00001B96p00000009 hid:b0003g*v00001B96p00000008 hid:b0003g*v00001B96p00000007 hid:b0003g*v00001B96p00000006 hid:b0003g*v00001B96p00000005 hid:b0003g*v00001B96p00000004 hid:b0003g*v00001B96p00000003 hid:b0003g*v00001B96p00000001

kernel/drivers/hid/hid-kensington.ko.xz hid:b0003g*v0000047Dp00002041

kernel/drivers/hid/hid-pl.ko.xz hid:b0003g*v00000F30p00000111 hid:b0003g*v00000E8Fp00000003 hid:b0003g*v00000810p00000002 hid:b0003g*v00000810p00000001

kernel/drivers/hid/hid-gembird.ko.xz hid:b0003g*v000011FFp00003331

kernel/drivers/hid/hid-holtek-kbd.ko.xz hid:b0003g*v000004D9p0000A055

kernel/drivers/hid/hid-dr.ko.xz hid:b0003g*v00000079p00000011 hid:b0003g*v00000079p00000006

kernel/drivers/hid/hid-zydacron.ko.xz hid:b0003g*v000013ECp00000006

kernel/drivers/hid/hid-roccat-ryos.ko.xz hid:b0003g*v00001E7Dp00003232 hid:b0003g*v00001E7Dp000031CE hid:b0003g*v00001E7Dp00003138
hid_roccat hid_roccat_common

kernel/drivers/hid/hid-picolcd.ko.xz hid:b0003g*v000004D8p0000F002 hid:b0003g*v000004D8p0000C002

kernel/drivers/hid/hid-a4tech.ko.xz hid:b0003g*v000009DAp0000022B hid:b0003g*v000009DAp0000001A hid:b0003g*v000009DAp0000000A hid:b0003g*v000009DAp00000006

kernel/drivers/hid/hid-roccat-common.ko.xz symbol:roccat_common2_receive symbol:roccat_common2_send symbol:roccat_common2_send_with_status symbol:roccat_common2_device_init_struct symbol:roccat_common2_sysfs_read symbol:roccat_common2_sysfs_write

kernel/drivers/hid/hid-tmff.ko.xz hid:b0003g*v0000044Fp0000B65A hid:b0003g*v0000044Fp0000B654 hid:b0003g*v0000044Fp0000B653 hid:b0003g*v0000044Fp0000B651 hid:b0003g*v0000044Fp0000B605 hid:b0003g*v0000044Fp0000B324 hid:b0003g*v0000044Fp0000B323 hid:b0003g*v0000044Fp0000B320 hid:b0003g*v0000044Fp0000B304 hid:b0003g*v0000044Fp0000B300

kernel/drivers/hid/hid-roccat-lua.ko.xz hid:b0003g*v00001E7Dp00002C2E
hid_roccat_common

kernel/drivers/hid/hid-multitouch.ko.xz hid:b*g0004v*p* hid:b*g0002v*p* hid:b0018g0004v00000911p00005288 hid:b*g*v00000457p* hid:b0003g0004v000018D1p00005030 hid:b*g*v000018D1p00005028 hid:b0003g0002v00001477p00001025 hid:b0003g0002v00001477p00001026 hid:b0003g0002v00001477p00001024 hid:b0003g0002v00001477p00001022 hid:b0003g0002v00001477p00001023 hid:b0003g0002v00001477p00001021 hid:b0003g0002v00001477p0000100E hid:b0003g0002v00001477p00001007 hid:b0003g0002v00001477p00001006 hid:b0003g0002v00002505p00000220 hid:b0003g0002v00000FB8p00001109 hid:b*g0004v00000416p0000C168 hid:b0003g0002v00000306p0000FF3F hid:b0003g0002v0000227Dp00000A19 hid:b0003g0002v0000227Dp00000709 hid:b0003g0002v00001E5Ep00000313 hid:b0003g0002v00001784p00000016 hid:b0018g0004v000006CBp0000CE09 hid:b0018g0004v000006CBp0000CE08 hid:b0018g0004v000006CBp0000CDDC hid:b0018g0004v000006CBp0000CD7E hid:b0003g0002v00000483p00003261 hid:b0003g0002v00000B8Cp00000092 hid:b0018g0004v000006CBp00008323 hid:b0003g0002v00000408p00003001 hid:b0003g0002v00002087p00000703 hid:b0003g0002v0000093Ap00008003 hid:b0003g0002v0000093Ap00008002 hid:b0003g0002v0000093Ap00008001 hid:b0003g0002v000004DAp0000104D hid:b0003g0002v000004DAp00001044 hid:b0018g0004v00001B96p00001B05 hid:b0003g0002v00000603p00000600 hid:b0003g0002v0000062Ap00007100 hid:b0003g0002v00000486p00000186 hid:b0003g0002v00000486p00000185 hid:b0003g0004v0000046Dp0000C548 hid:b0005g0004v0000046Dp0000BB00 hid:b0003g0004v000017EFp000061AE hid:b0003g0004v000017EFp000060FE hid:b0003g0004v000017EFp000060B5 hid:b0003g0004v000017EFp000060A4 hid:b0003g0004v000017EFp000060A3 hid:b0018g0001v00001FD2p00007010 hid:b0003g*v00001FD2p00006007 hid:b0003g0002v0000222Ap00000001 hid:b0018g0004v000035CCp00000104 hid:b0018g0004v0000347Dp00007853 hid:b0003g0002v000022EDp00001010 hid:b0003g0002v00001AADp0000000F hid:b0018g*v000027C6p000001E9 hid:b0018g*v000027C6p000001E8 hid:b0005g0002v000025B6p00000002 hid:b0003g0002v00000DFCp0000E100 hid:b0003g0002v00000DFCp0000010A hid:b0003g0002v00000DFCp00000106 hid:b0003g0002v00000DFCp00000102 hid:b0003g0002v00000DFCp00000101 hid:b0003g0002v00000DFCp00000100 hid:b0003g0002v00000DFCp00000003 hid:b0003g0002v000010C4p000081B9 hid:b0003g0002v000025B5p00000002 hid:b0003g0002v000003FCp000005D8 hid:b0018g0004v000004F3p000032AE hid:b0018g0004v000004F3p00003148 hid:b0018g0004v000004F3p0000313A hid:b0003g0002v00000EEFp0000C002 hid:b0003g0002v00000EEFp0000A001 hid:b0003g0002v00000EEFp000073F7 hid:b0003g0002v00000EEFp00007349 hid:b0003g0002v00000EEFp00007302 hid:b0003g0002v00000EEFp000072FA hid:b0003g*v00000EEFp000072D0 hid:b0003g*v00000EEFp000072C4 hid:b0003g0002v00000EEFp000072AA hid:b0003g0002v00000EEFp000072A1 hid:b0003g0002v00000EEFp0000726B hid:b0003g0002v00000EEFp00007262 hid:b0003g0002v00000EEFp0000725E hid:b0003g0002v00000EEFp0000722A hid:b0003g0002v00000EEFp00007224 hid:b0003g0002v00000EEFp0000720C hid:b0003g0002v00000EEFp00007207 hid:b0003g0002v00000EEFp0000480E hid:b0003g0002v00000EEFp0000480D hid:b0003g0002v00000EEFp00000001 hid:b0003g0002v00001FF7p00000013 hid:b0003g0002v000024B8p00000040 hid:b0003g0002v000024B8p00000020 hid:b0003g0002v00002247p00000001 hid:b0003g0002v00002087p00000F01 hid:b0003g0002v00002087p00000A01 hid:b0003g0002v00002453p00000100 hid:b0003g0002v000003EBp00002118 hid:b0003g0004v00000B05p0000184A hid:b0003g0004v00000B05p0000183D hid:b0003g0002v00001130p00003101 hid:b0003g0002v00000596p00000506 hid:b0003g0002v00000596p00000502 hid:b0003g0002v00000596p00000500

kernel/drivers/hid/hid-logitech-dj.ko.xz hid:b0003g*v0000046Dp0000C71F hid:b0003g*v0000046Dp0000C71E hid:b0003g*v0000046Dp0000C714 hid:b0003g*v0000046Dp0000C713 hid:b0003g*v0000046Dp0000C71C hid:b0003g*v0000046Dp0000C71B hid:b0003g*v0000046Dp0000C70A hid:b0003g*v0000046Dp0000C70E hid:b0003g*v0000046Dp0000C51B hid:b0003g*v0000046Dp0000C517 hid:b0003g*v0000046Dp0000C513 hid:b0003g*v0000046Dp0000C543 hid:b0003g*v0000046Dp0000C53F hid:b0003g*v0000046Dp0000C53A hid:b0003g*v0000046Dp0000C539 hid:b0003g*v0000046Dp0000C537 hid:b0003g*v0000046Dp0000C531 hid:b0003g*v0000046Dp0000C534 hid:b0003g*v0000046Dp0000C52F hid:b0003g*v0000046Dp0000C532 hid:b0003g*v0000046Dp0000C52B

kernel/drivers/hid/hid-betopff.ko.xz hid:b0003g*v000020BCp00005500 hid:b0003g*v00008380p00001850 hid:b0003g*v000011C0p00005506 hid:b0003g*v000011C2p00002208
ff_memless

kernel/drivers/hid/hid-gaff.ko.xz hid:b0003g*v00000E8Fp00000012

kernel/drivers/hid/hid-belkin.ko.xz hid:b0003g*v00001020p00000006 hid:b0003g*v0000050Dp00003201

kernel/drivers/hid/hid-lcpower.ko.xz hid:b0003g*v00001241p0000F767

kernel/drivers/mfd/arizona-spi.ko.xz spi:cs47l24 spi:wm1831 spi:wm8280 spi:wm5110 spi:wm5102 of:N*T*Ccirrus,cs47l24C* of:N*T*Ccirrus,cs47l24 of:N*T*Cwlf,wm1831C* of:N*T*Cwlf,wm1831 of:N*T*Cwlf,wm8280C* of:N*T*Cwlf,wm8280 of:N*T*Cwlf,wm5110C* of:N*T*Cwlf,wm5110 of:N*T*Cwlf,wm5102C* of:N*T*Cwlf,wm5102
arizona regmap_spi

kernel/drivers/mfd/wl1273-core.ko.xz i2c:wl1273_fm

kernel/drivers/mfd/simple-mfd-i2c.ko.xz of:N*T*Craspberrypi,sensehatC* of:N*T*Craspberrypi,sensehat of:N*T*Craspberrypi,poe_coreC* of:N*T*Craspberrypi,poe_core of:N*T*Cmaxim,max5978C* of:N*T*Cmaxim,max5978 of:N*T*Cmaxim,max5970C* of:N*T*Cmaxim,max5970 of:N*T*Csilergy,sy7636aC* of:N*T*Csilergy,sy7636a of:N*T*Ckontron,sl28cpldC* of:N*T*Ckontron,sl28cpld
regmap_i2c

kernel/drivers/mfd/arizona-i2c.ko.xz i2c:wm1814 i2c:wm8998 i2c:wm8997 i2c:wm8280 i2c:wm5110 i2c:wm5102 of:N*T*Cwlf,wm1814C* of:N*T*Cwlf,wm1814 of:N*T*Cwlf,wm8998C* of:N*T*Cwlf,wm8998 of:N*T*Cwlf,wm8997C* of:N*T*Cwlf,wm8997 of:N*T*Cwlf,wm8280C* of:N*T*Cwlf,wm8280 of:N*T*Cwlf,wm5110C* of:N*T*Cwlf,wm5110 of:N*T*Cwlf,wm5102C* of:N*T*Cwlf,wm5102
arizona regmap_i2c

kernel/drivers/mfd/arizona.ko.xz symbol:arizona_clk32k_enable symbol:arizona_clk32k_disable symbol:arizona_pm_ops symbol:arizona_dev_init symbol:arizona_dev_exit symbol:arizona_request_irq symbol:arizona_free_irq symbol:arizona_set_irq_wake symbol:wm5102_spi_regmap symbol:wm5102_i2c_regmap

kernel/drivers/vhost/vhost_iotlb.ko.xz symbol:vhost_iotlb_map_free symbol:vhost_iotlb_add_range_ctx symbol:vhost_iotlb_add_range symbol:vhost_iotlb_del_range symbol:vhost_iotlb_init symbol:vhost_iotlb_alloc symbol:vhost_iotlb_reset symbol:vhost_iotlb_free symbol:vhost_iotlb_itree_first symbol:vhost_iotlb_itree_next

kernel/drivers/vhost/vhost.ko.xz symbol:vhost_work_init symbol:vhost_poll_init symbol:vhost_poll_start symbol:vhost_poll_stop symbol:vhost_vq_work_queue symbol:vhost_dev_flush symbol:vhost_vq_has_work symbol:vhost_poll_queue symbol:vhost_vq_is_setup symbol:vhost_exceeds_weight symbol:vhost_dev_init symbol:vhost_dev_check_owner symbol:vhost_dev_has_owner symbol:vhost_worker_ioctl symbol:vhost_dev_set_owner symbol:vhost_dev_reset_owner_prepare symbol:vhost_dev_reset_owner symbol:vhost_dev_stop symbol:vhost_clear_msg symbol:vhost_dev_cleanup symbol:vhost_chr_write_iter symbol:vhost_chr_poll symbol:vhost_chr_read_iter symbol:vq_meta_prefetch symbol:vhost_log_access_ok symbol:vhost_vq_access_ok symbol:vhost_vring_ioctl symbol:vhost_init_device_iotlb symbol:vhost_dev_ioctl symbol:vhost_log_write symbol:vhost_vq_init_access symbol:vhost_get_vq_desc symbol:vhost_discard_vq_desc symbol:vhost_add_used symbol:vhost_add_used_n symbol:vhost_signal symbol:vhost_add_used_and_signal symbol:vhost_add_used_and_signal_n symbol:vhost_vq_avail_empty symbol:vhost_enable_notify symbol:vhost_disable_notify symbol:vhost_new_msg symbol:vhost_enqueue_msg symbol:vhost_dequeue_msg symbol:vhost_set_backend_features
vhost_iotlb

kernel/drivers/vhost/vhost_vsock.ko.xz devname:vhost_vsock char_major_10_241
vhost vmw_vsock_virtio_transport_common vsock

kernel/drivers/vhost/vhost_net.ko.xz devname:vhost_net char_major_10_238
vhost tap tun

kernel/drivers/mailbox/rp1-mailbox.ko.xz of:N*T*Craspberrypi,rp1_mboxC* of:N*T*Craspberrypi,rp1_mbox

kernel/drivers/net/veth.ko.xz rtnl_link_veth

kernel/drivers/net/mdio.ko.xz symbol:mdio45_probe symbol:mdio_set_flag symbol:mdio45_links_ok symbol:mdio45_nway_restart symbol:mdio45_ethtool_gset_npage symbol:mdio45_ethtool_ksettings_get_npage symbol:mdio_mii_ioctl

kernel/drivers/net/ipvlan/ipvlan.ko.xz rtnl_link_ipvlan symbol:ipvlan_count_rx symbol:ipvlan_link_new symbol:ipvlan_link_delete symbol:ipvlan_link_setup symbol:ipvlan_link_register
ipv6

kernel/drivers/net/netconsole.ko.xz

kernel/drivers/net/ppp/bsd_comp.ko.xz ppp_compress_21
ppp_generic

kernel/drivers/net/ppp/ppp_synctty.ko.xz tty_ldisc_14
ppp_generic

kernel/drivers/net/ppp/pppoe.ko.xz net_pf_24_proto_0
pppox ppp_generic

kernel/drivers/net/ppp/ppp_deflate.ko.xz ppp_compress_24 ppp_compress_26
ppp_generic

kernel/drivers/net/ppp/ppp_generic.ko.xz devname:ppp rtnl_link_ppp char_major_108_0 symbol:ppp_register_net_channel symbol:ppp_register_channel symbol:ppp_unregister_channel symbol:ppp_channel_index symbol:ppp_unit_number symbol:ppp_dev_name symbol:ppp_input symbol:ppp_input_error symbol:ppp_output_wakeup symbol:ppp_register_compressor symbol:ppp_unregister_compressor
slhc

kernel/drivers/net/ppp/ppp_mppe.ko.xz ppp_compress_18
ppp_generic libarc4

kernel/drivers/net/ppp/pppox.ko.xz net_pf_24 symbol:register_pppox_proto symbol:unregister_pppox_proto symbol:pppox_unbind_sock symbol:pppox_ioctl symbol:pppox_compat_ioctl
ppp_generic

kernel/drivers/net/ppp/ppp_async.ko.xz tty_ldisc_3
crc_ccitt ppp_generic

kernel/drivers/net/dummy.ko.xz rtnl_link_dummy

kernel/drivers/net/wireguard/wireguard.ko.xz net_pf_16_proto_16_family_wireguard rtnl_link_wireguard
libcurve25519_generic udp_tunnel ip6_udp_tunnel libchacha20poly1305 ipv6

kernel/drivers/net/ieee802154/at86rf230.ko.xz of:N*T*Catmel,at86rf212C* of:N*T*Catmel,at86rf212 of:N*T*Catmel,at86rf233C* of:N*T*Catmel,at86rf233 of:N*T*Catmel,at86rf231C* of:N*T*Catmel,at86rf231 of:N*T*Catmel,at86rf230C* of:N*T*Catmel,at86rf230 spi:at86rf212 spi:at86rf233 spi:at86rf231 spi:at86rf230
mac802154 regmap_spi

kernel/drivers/net/ieee802154/mrf24j40.ko.xz of:N*T*Cmicrochip,mrf24j40mcC* of:N*T*Cmicrochip,mrf24j40mc of:N*T*Cmicrochip,mrf24j40maC* of:N*T*Cmicrochip,mrf24j40ma of:N*T*Cmicrochip,mrf24j40C* of:N*T*Cmicrochip,mrf24j40 spi:mrf24j40mc spi:mrf24j40ma spi:mrf24j40
mac802154 regmap_spi

kernel/drivers/net/ieee802154/cc2520.ko.xz spi:cc2520 of:N*T*Cti,cc2520C* of:N*T*Cti,cc2520
mac802154 crc_ccitt

kernel/drivers/net/wireless/atmel/at76c50x-usb.ko.xz usb:v03EBp7615d*dc*dsc*dp*ic*isc*ip*in* usb:v1557p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0701d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7617d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7614d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p1020d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp7613d*dc*dsc*dp*ic*isc*ip*in* usb:v12FDp1001d*dc*dsc*dp*ic*isc*ip*in* usb:v1915p2233d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p0014d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7613d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7606d*dc*dsc*dp*ic*isc*ip*in* usb:v0D5CpA002d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap3501d*dc*dsc*dp*ic*isc*ip*in* usb:v05DDpFF35d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0018d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0011d*dc*dsc*dp*ic*isc*ip*in* usb:v049Fp0032d*dc*dsc*dp*ic*isc*ip*in* usb:v2019p3220d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p8003d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB000d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0050d*dc*dsc*dp*ic*isc*ip*in* usb:v0681p001Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0506p0A01d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p5743d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp4102d*dc*dsc*dp*ic*isc*ip*in* usb:v1668p7605d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3200d*dc*dsc*dp*ic*isc*ip*in* usb:v0864p4102d*dc*dsc*dp*ic*isc*ip*in* usb:v077Bp2227d*dc*dsc*dp*ic*isc*ip*in* usb:v077Bp2219d*dc*dsc*dp*ic*isc*ip*in* usb:v069Ap0321d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7605d*dc*dsc*dp*ic*isc*ip*in* usb:v055DpA000d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7604d*dc*dsc*dp*ic*isc*ip*in* usb:v069Ap0821d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0919d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7110d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7100d*dc*dsc*dp*ic*isc*ip*in* usb:v8086p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v05DDpFF31d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v0D5CpA001d*dc*dsc*dp*ic*isc*ip*in* usb:v069Ap0320d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p011Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0B3Bp1612d*dc*dsc*dp*ic*isc*ip*in* usb:v0864p4100d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2211d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp7603d*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211

kernel/drivers/net/wireless/marvell/libertas_tf/libertas_tf_usb.ko.xz usb:v05A3p8388d*dc*dsc*dp*ic*isc*ip*in* usb:v1286p2001d*dc*dsc*dp*ic*isc*ip*in*
libertas_tf

kernel/drivers/net/wireless/marvell/libertas_tf/libertas_tf.ko.xz symbol:lbtf_debug symbol:lbtf_rx symbol:lbtf_add_card symbol:lbtf_remove_card symbol:lbtf_send_tx_feedback symbol:lbtf_bcn_sent symbol:lbtf_cmd_copyback symbol:__lbtf_cmd symbol:lbtf_cmd_response_rx
mac80211

kernel/drivers/net/wireless/marvell/libertas/libertas.ko.xz symbol:lbs_cmd_copyback symbol:lbs_host_sleep_cfg symbol:__lbs_cmd symbol:lbs_debug symbol:lbs_host_to_card_done symbol:lbs_suspend symbol:lbs_resume symbol:lbs_add_card symbol:lbs_remove_card symbol:lbs_start_card symbol:lbs_stop_card symbol:lbs_queue_event symbol:lbs_notify_command_response symbol:lbs_process_rxed_packet symbol:lbs_send_tx_feedback symbol:lbs_get_firmware_async symbol:lbs_get_firmware
cfg80211

kernel/drivers/net/wireless/marvell/libertas/libertas_sdio.ko.xz sdio:c*v02DFd9104* sdio:c*v02DFd9103*
libertas

kernel/drivers/net/wireless/marvell/libertas/usb8xxx.ko.xz usb:v05A3p8388d*dc*dsc*dp*ic*isc*ip*in* usb:v1286p2001d*dc*dsc*dp*ic*isc*ip*in*
libertas

kernel/drivers/net/wireless/marvell/mwifiex/mwifiex.ko.xz symbol:mwifiex_queue_main_work symbol:mwifiex_main_process symbol:mwifiex_multi_chan_resync symbol:mwifiex_upload_device_dump symbol:mwifiex_drv_info_dump symbol:mwifiex_prepare_fw_dump_info symbol:mwifiex_shutdown_sw symbol:mwifiex_reinit_sw symbol:mwifiex_add_card symbol:mwifiex_remove_card symbol:_mwifiex_dbg symbol:mwifiex_dnld_fw symbol:mwifiex_process_hs_config symbol:mwifiex_process_sleep_confirm_resp symbol:mwifiex_init_shutdown_fw symbol:mwifiex_alloc_dma_align_buf symbol:mwifiex_fw_dump_event symbol:mwifiex_handle_rx_packet symbol:mwifiex_write_data_complete symbol:mwifiex_deauthenticate_all symbol:mwifiex_cancel_hs symbol:mwifiex_enable_hs symbol:mwifiex_disable_auto_ds symbol:mwifiex_add_virtual_intf symbol:mwifiex_del_virtual_intf
cfg80211

kernel/drivers/net/wireless/marvell/mwifiex/mwifiex_sdio.ko.xz sdio:c*v02DFd9141* sdio:c*v02DFd9149* sdio:c*v02DFd9159* sdio:c*v02DFd9145* sdio:c*v02DFd9139* sdio:c*v02DFd9135* sdio:c*v02DFd912D* sdio:c*v02DFd9129* sdio:c*v02DFd9119* sdio:c*v02DFd9116*
mwifiex

kernel/drivers/net/wireless/ath/carl9170/carl9170.ko.xz arusb_lnx ar9170usb usb:v1B75p9170d*dc*dsc*dp*ic*isc*ip*in* usb:v1668p1200d*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8402d*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8401d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p02B4d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p0249d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp093Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2019p5304d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApF522d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0027d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0026d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0023d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3417d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0326d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0804d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1221d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9010d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9040d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3A0Fd*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3A09d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C10d*dc*dsc*dp*ic*isc*ip*in* usb:vCACEp0300d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p1011d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p1010d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p9170d*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211 ath

kernel/drivers/net/wireless/ath/ath.ko.xz symbol:ath_rxbuf_alloc symbol:ath_is_mybeacon symbol:ath_printk symbol:ath_bus_type_strings symbol:ath_is_world_regd symbol:ath_is_49ghz_allowed symbol:ath_regd_find_country_by_name symbol:ath_reg_notifier_apply symbol:ath_regd_init symbol:ath_regd_get_band_ctl symbol:ath_hw_setbssidmask symbol:ath_hw_cycle_counters_update symbol:ath_hw_get_listen_time symbol:ath_hw_keyreset symbol:ath_hw_keysetmac symbol:ath_key_config symbol:ath_key_delete symbol:dfs_pattern_detector_init
cfg80211

kernel/drivers/net/wireless/ath/ath9k/ath9k.ko.xz pci:v0000168Cd00000036sv*sd*bc*sc*i* pci:v0000168Cd00000036sv00001028sd0000020Ebc*sc*i* pci:v0000168Cd00000036sv00001043sd000085F2bc*sc*i* pci:v0000168Cd00000036sv000017AAsd00004026bc*sc*i* pci:v0000168Cd00000036sv000017AAsd00003026bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E099bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E091bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E081bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E08Fbc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E07Fbc*sc*i* pci:v0000168Cd00000036sv0000185Fsd0000A120bc*sc*i* pci:v0000168Cd00000036sv0000185Fsd00003027bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd000028A4bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd000028A2bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd00002813bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd00002810bc*sc*i* pci:v0000168Cd00000036sv0000144Fsd00007202bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd00002F82bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000218Cbc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000218Bbc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd00002182bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000213Bbc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd00002130bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000813bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000803bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000692bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00001832bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000832bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000612bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000652bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000642bc*sc*i* pci:v0000168Cd00000036sv0000168Csd0000302Cbc*sc*i* pci:v0000168Cd00000036sv0000168Csd00003027bc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000412Abc*sc*i* pci:v0000168Cd00000036sv0000144Dsd00004129bc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000411Ebc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000411Dbc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000411Cbc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000411Bbc*sc*i* pci:v0000168Cd00000036sv0000144Dsd0000411Abc*sc*i* pci:v0000168Cd00000036sv00001028sd0000020Cbc*sc*i* pci:v0000168Cd00000036sv0000103Csd00002005bc*sc*i* pci:v0000168Cd00000036sv0000103Csd0000217Fbc*sc*i* pci:v0000168Cd00000036sv0000103Csd000018E3bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000213Cbc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000213Abc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000682bc*sc*i* pci:v0000168Cd00000036sv000011ADsd000006A2bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000662bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000672bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000622bc*sc*i* pci:v0000168Cd00000036sv0000185Fsd00003028bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E069bc*sc*i* pci:v0000168Cd00000036sv0000168Csd0000302Bbc*sc*i* pci:v0000168Cd00000036sv0000168Csd00003026bc*sc*i* pci:v0000168Cd00000036sv0000168Csd00003025bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd00002F8Abc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd0000218Abc*sc*i* pci:v0000168Cd00000036sv00001B9Asd000028A3bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd000028A1bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd00002812bc*sc*i* pci:v0000168Cd00000036sv00001B9Asd00002811bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00006671bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00001842bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000842bc*sc*i* pci:v0000168Cd00000036sv000011ADsd000006B2bc*sc*i* pci:v0000168Cd00000036sv000011ADsd00000632bc*sc*i* pci:v0000168Cd00000036sv0000185Fsd0000A119bc*sc*i* pci:v0000168Cd00000036sv0000105Bsd0000E068bc*sc*i* pci:v0000168Cd00000036sv00001A3Bsd00002176bc*sc*i* pci:v0000168Cd00000036sv0000168Csd00003028bc*sc*i* pci:v0000168Cd00000037sv*sd*bc*sc*i* pci:v0000168Cd00000034sv*sd*bc*sc*i* pci:v0000168Cd00000030sv00001A56sd00002003bc*sc*i* pci:v0000168Cd00000034sv00001028sd00000300bc*sc*i* pci:v0000168Cd00000034sv00001028sd0000020Bbc*sc*i* pci:v0000168Cd00000034sv000010CFsd00001783bc*sc*i* pci:v0000168Cd00000034sv000014CDsd00000064bc*sc*i* pci:v0000168Cd00000034sv000014CDsd00000063bc*sc*i* pci:v0000168Cd00000034sv0000103Csd00001864bc*sc*i* pci:v0000168Cd00000034sv000011ADsd00006641bc*sc*i* pci:v0000168Cd00000034sv000011ADsd00006631bc*sc*i* pci:v0000168Cd00000034sv00001043sd0000850Ebc*sc*i* pci:v0000168Cd00000034sv00001A3Bsd00002110bc*sc*i* pci:v0000168Cd00000034sv00001969sd00000091bc*sc*i* pci:v0000168Cd00000034sv000017AAsd00003214bc*sc*i* pci:v0000168Cd00000034sv0000168Csd00003117bc*sc*i* pci:v0000168Cd00000034sv000011ADsd00006661bc*sc*i* pci:v0000168Cd00000034sv00001A3Bsd00002116bc*sc*i* pci:v0000168Cd00000033sv*sd*bc*sc*i* pci:v0000168Cd00000032sv*sd*bc*sc*i* pci:v0000168Cd00000032sv00001043sd0000850Dbc*sc*i* pci:v0000168Cd00000032sv00001B9Asd00001C01bc*sc*i* pci:v0000168Cd00000032sv00001B9Asd00001C00bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00001F95bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00001195bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00001F86bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00001186bc*sc*i* pci:v0000168Cd00000032sv00001B9Asd00002001bc*sc*i* pci:v0000168Cd00000032sv00001B9Asd00002000bc*sc*i* pci:v0000168Cd00000032sv0000144Fsd00007197bc*sc*i* pci:v0000168Cd00000032sv0000105Bsd0000E04Fbc*sc*i* pci:v0000168Cd00000032sv0000105Bsd0000E04Ebc*sc*i* pci:v0000168Cd00000032sv000011ADsd00006628bc*sc*i* pci:v0000168Cd00000032sv000011ADsd00006627bc*sc*i* pci:v0000168Cd00000032sv00001C56sd00004001bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00002100bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00002C97bc*sc*i* pci:v0000168Cd00000032sv000017AAsd00003219bc*sc*i* pci:v0000168Cd00000032sv000017AAsd00003218bc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000C708bc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000C680bc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000C706bc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000410Fbc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000410Ebc*sc*i* pci:v0000168Cd00000032sv0000144Dsd0000410Dbc*sc*i* pci:v0000168Cd00000032sv0000144Dsd00004106bc*sc*i* pci:v0000168Cd00000032sv0000144Dsd00004105bc*sc*i* pci:v0000168Cd00000032sv0000185Fsd00003027bc*sc*i* pci:v0000168Cd00000032sv0000185Fsd00003119bc*sc*i* pci:v0000168Cd00000032sv0000168Csd00003122bc*sc*i* pci:v0000168Cd00000032sv0000168Csd00003119bc*sc*i* pci:v0000168Cd00000032sv0000105Bsd0000E075bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00002152bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd0000126Abc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00002126bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00001237bc*sc*i* pci:v0000168Cd00000032sv00001A3Bsd00002086bc*sc*i* pci:v0000168Cd00000030sv*sd*bc*sc*i* pci:v0000168Cd00000030sv00001A56sd00002001bc*sc*i* pci:v0000168Cd00000030sv00001A56sd00002000bc*sc*i* pci:v0000168Cd0000002Esv*sd*bc*sc*i* pci:v0000168Cd0000002Dsv*sd*bc*sc*i* pci:v0000168Cd0000002Csv*sd*bc*sc*i* pci:v0000168Cd0000002Bsv*sd*bc*sc*i* pci:v0000168Cd0000002Bsv00001A3Bsd00002C37bc*sc*i* pci:v0000168Cd0000002Asv*sd*bc*sc*i* pci:v0000168Cd0000002Asv000010CFsd00001536bc*sc*i* pci:v0000168Cd0000002Asv000010CFsd0000147Dbc*sc*i* pci:v0000168Cd0000002Asv000010CFsd0000147Cbc*sc*i* pci:v0000168Cd0000002Asv0000185Fsd0000309Dbc*sc*i* pci:v0000168Cd0000002Asv00001A32sd00000306bc*sc*i* pci:v0000168Cd0000002Asv000011ADsd00006642bc*sc*i* pci:v0000168Cd0000002Asv000011ADsd00006632bc*sc*i* pci:v0000168Cd0000002Asv0000105Bsd0000E01Fbc*sc*i* pci:v0000168Cd0000002Asv00001A3Bsd00001C71bc*sc*i* pci:v0000168Cd00000029sv*sd*bc*sc*i* pci:v0000168Cd00000029sv0000168Csd00002096bc*sc*i* pci:v0000168Cd00000027sv*sd*bc*sc*i* pci:v0000168Cd00000024sv*sd*bc*sc*i* pci:v0000168Cd00000023sv*sd*bc*sc*i*
ath9k_hw mac80211 ath ath9k_common cfg80211 rfkill

kernel/drivers/net/wireless/ath/ath9k/ath9k_common.ko.xz symbol:ath9k_cmn_rx_accept symbol:ath9k_cmn_rx_skb_postprocess symbol:ath9k_cmn_process_rate symbol:ath9k_cmn_process_rssi symbol:ath9k_cmn_get_hw_crypto_keytype symbol:ath9k_cmn_get_channel symbol:ath9k_cmn_count_streams symbol:ath9k_cmn_update_txpow symbol:ath9k_cmn_init_crypto symbol:ath9k_cmn_init_channels_rates symbol:ath9k_cmn_setup_ht_cap symbol:ath9k_cmn_reload_chainmask symbol:ath9k_cmn_beacon_config_sta symbol:ath9k_cmn_beacon_config_adhoc symbol:ath9k_cmn_beacon_config_ap
ath9k_hw ath cfg80211

kernel/drivers/net/wireless/ath/ath9k/ath9k_hw.ko.xz symbol:ath9k_hw_wait symbol:ath9k_hw_computetxtime symbol:ath9k_hw_init symbol:ar9003_get_pll_sqsum_dvc symbol:ath9k_hw_init_global_settings symbol:ath9k_hw_deinit symbol:ath9k_hw_check_nav symbol:ath9k_hw_check_alive symbol:ath9k_hw_get_tsf_offset symbol:ath9k_hw_reset symbol:ath9k_hw_setpower symbol:ath9k_hw_beaconinit symbol:ath9k_hw_set_sta_beacon_timers symbol:ath9k_hw_gpio_request_in symbol:ath9k_hw_gpio_request_out symbol:ath9k_hw_gpio_free symbol:ath9k_hw_gpio_get symbol:ath9k_hw_set_gpio symbol:ath9k_hw_setantenna symbol:ath9k_hw_getrxfilter symbol:ath9k_hw_setrxfilter symbol:ath9k_hw_phy_disable symbol:ath9k_hw_disable symbol:ath9k_hw_set_txpowerlimit symbol:ath9k_hw_setopmode symbol:ath9k_hw_setmcastfilter symbol:ath9k_hw_write_associd symbol:ath9k_hw_gettsf64 symbol:ath9k_hw_settsf64 symbol:ath9k_hw_reset_tsf symbol:ath9k_hw_set_tsfadjust symbol:ath9k_hw_gettsf32 symbol:ath_gen_timer_alloc symbol:ath9k_hw_gen_timer_start symbol:ath9k_hw_gen_timer_stop symbol:ath_gen_timer_free symbol:ath_gen_timer_isr symbol:ath9k_hw_name symbol:ar9003_hw_bb_watchdog_check symbol:ar9003_hw_bb_watchdog_dbg_info symbol:ar9003_hw_disable_phy_restart symbol:ath9k_hw_getchan_noise symbol:ath9k_hw_reset_calvalid symbol:ath9k_hw_loadnf symbol:ath9k_hw_getnf symbol:ath9k_hw_bstuck_nfcal symbol:ath9k_hw_ani_monitor symbol:ath9k_hw_disable_mib_counters symbol:ath9k_hw_gettxbuf symbol:ath9k_hw_puttxbuf symbol:ath9k_hw_txstart symbol:ath9k_hw_numtxpending symbol:ath9k_hw_updatetxtriglevel symbol:ath9k_hw_abort_tx_dma symbol:ath9k_hw_stop_dma_queue symbol:ath9k_hw_set_txq_props symbol:ath9k_hw_get_txq_props symbol:ath9k_hw_setuptxqueue symbol:ath9k_hw_releasetxqueue symbol:ath9k_hw_resettxqueue symbol:ath9k_hw_rxprocdesc symbol:ath9k_hw_setrxabort symbol:ath9k_hw_putrxbuf symbol:ath9k_hw_startpcureceive symbol:ath9k_hw_abortpcurecv symbol:ath9k_hw_stopdmarecv symbol:ath9k_hw_beaconq_setup symbol:ath9k_hw_intrpend symbol:ath9k_hw_kill_interrupts symbol:ath9k_hw_disable_interrupts symbol:ath9k_hw_resume_interrupts symbol:ath9k_hw_enable_interrupts symbol:ath9k_hw_set_interrupts symbol:ath9k_hw_set_tx_filter symbol:ath9k_hw_setuprxdesc symbol:ath9k_hw_set_rx_bufsize symbol:ath9k_hw_addrxbuf_edma symbol:ath9k_hw_process_rxdesc_edma symbol:ath9k_hw_setup_statusring symbol:ar9003_paprd_enable symbol:ar9003_paprd_populate_single_table symbol:ar9003_paprd_setup_gain_table symbol:ar9003_paprd_create_curve symbol:ar9003_paprd_init_table symbol:ar9003_paprd_is_done symbol:ar9003_is_paprd_enabled symbol:ath9k_hw_init_btcoex_hw symbol:ath9k_hw_btcoex_init_scheme symbol:ath9k_hw_btcoex_init_2wire symbol:ath9k_hw_btcoex_init_3wire symbol:ath9k_hw_btcoex_deinit symbol:ath9k_hw_btcoex_init_mci symbol:ath9k_hw_btcoex_set_weight symbol:ath9k_hw_btcoex_enable symbol:ath9k_hw_btcoex_disable symbol:ath9k_hw_btcoex_bt_stomp symbol:ath9k_hw_btcoex_set_concur_txprio symbol:ar9003_mci_get_interrupt symbol:ar9003_mci_send_message symbol:ar9003_mci_setup symbol:ar9003_mci_cleanup symbol:ar9003_mci_state symbol:ar9003_mci_get_next_gpm_offset symbol:ar9003_mci_set_bt_version symbol:ar9003_mci_send_wlan_channels
ath

kernel/drivers/net/wireless/ath/ath9k/ath9k_htc.ko.xz usb:v0CF3p20FFd*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0A08d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp3904d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0197d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p017Fd*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA704d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9018d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p7010d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p7015d*dc*dsc*dp*ic*isc*ip*in* usb:v1EDAp2315d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p209Ed*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8403d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pB002d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pB003d*dc*dsc*dp*ic*isc*ip*in* usb:v040Dp3801d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp4605d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3350d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3349d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3348d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3346d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3328d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3327d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3A10d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p9271d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9030d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p1006d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p9271d*dc*dsc*dp*ic*isc*ip*in*
ath9k_hw ath ath9k_common mac80211 cfg80211 rfkill

kernel/drivers/net/wireless/ath/ar5523/ar5523.ko.xz usb:v1385p5F03d*dc*dsc*dp*ic*isc*ip*in* usb:v1385p5F02d*dc*dsc*dp*ic*isc*ip*in* usb:v1385p5F01d*dc*dsc*dp*ic*isc*ip*in* usb:v1385p5F00d*dc*dsc*dp*ic*isc*ip*in* usb:v1385p4251d*dc*dsc*dp*ic*isc*ip*in* usb:v1385p4250d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0013d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0012d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0829d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0828d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0827d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0826d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3206d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3205d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3007d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3006d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4507d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4506d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p5F01d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p5F00d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4251d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4250d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4301d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4300d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7803d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7802d*dc*dsc*dp*ic*isc*ip*in* usb:v16ABp7812d*dc*dsc*dp*ic*isc*ip*in* usb:v16ABp7811d*dc*dsc*dp*ic*isc*ip*in* usb:v16ABp7802d*dc*dsc*dp*ic*isc*ip*in* usb:v16ABp7801d*dc*dsc*dp*ic*isc*ip*in* usb:v129Bp160Cd*dc*dsc*dp*ic*isc*ip*in* usb:v129Bp160Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0711d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0710d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0713d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0712d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3A08d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3A07d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A05d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A04d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A03d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A02d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A01d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3A00d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7812d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7811d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep7801d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v168Cp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v168Cp0001d*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211

kernel/drivers/net/wireless/ath/ath6kl/ath6kl_usb.ko.xz usb:v04DAp390Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p9374d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p9375d*dc*dsc*dp*ic*isc*ip*in*
ath6kl_core

kernel/drivers/net/wireless/ath/ath6kl/ath6kl_core.ko.xz symbol:ath6kl_printk symbol:ath6kl_info symbol:ath6kl_err symbol:ath6kl_warn symbol:ath6kl_read_tgt_stats symbol:ath6kl_hif_rw_comp_handler symbol:ath6kl_hif_intr_bh_handler symbol:ath6kl_cfg80211_suspend symbol:ath6kl_cfg80211_resume symbol:ath6kl_stop_txrx symbol:ath6kl_core_tx_complete symbol:ath6kl_core_rx_complete symbol:ath6kl_core_init symbol:ath6kl_core_create symbol:ath6kl_core_cleanup symbol:ath6kl_core_destroy
cfg80211

kernel/drivers/net/wireless/mediatek/mt7601u/mt7601u.ko.xz usb:v7392p7710d*dc*dsc*dp*ic*isc*ip*in* usb:v2A5Fp1000d*dc*dsc*dp*ic*isc*ip*in* usb:v2955p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v2955p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v2955p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v2717p4106d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3D04d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp760Dd*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp760Cd*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp760Bd*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp760Ad*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp7601d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3434d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3431d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp760Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp760Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17D3d*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt76-connac-lib.ko.xz symbol:mt76_connac_mcu_start_firmware symbol:mt76_connac_mcu_patch_sem_ctrl symbol:mt76_connac_mcu_start_patch symbol:mt76_connac_mcu_init_download symbol:mt76_connac_mcu_set_channel_domain symbol:mt76_connac_mcu_set_mac_enable symbol:mt76_connac_mcu_set_vif_ps symbol:mt76_connac_mcu_set_rts_thresh symbol:mt76_connac_mcu_beacon_loss_iter symbol:mt76_connac_mcu_add_nested_tlv symbol:__mt76_connac_mcu_alloc_sta_req symbol:mt76_connac_mcu_alloc_wtbl_req symbol:mt76_connac_mcu_bss_omac_tlv symbol:mt76_connac_mcu_sta_basic_tlv symbol:mt76_connac_mcu_sta_uapsd symbol:mt76_connac_mcu_wtbl_hdr_trans_tlv symbol:mt76_connac_mcu_sta_update_hdr_trans symbol:mt76_connac_mcu_wtbl_update_hdr_trans symbol:mt76_connac_mcu_wtbl_generic_tlv symbol:mt76_connac_mcu_sta_he_tlv_v2 symbol:mt76_connac_get_phy_mode_v2 symbol:mt76_connac_mcu_sta_tlv symbol:mt76_connac_mcu_wtbl_smps_tlv symbol:mt76_connac_mcu_wtbl_ht_tlv symbol:mt76_connac_mcu_sta_cmd symbol:mt76_connac_mcu_wtbl_ba_tlv symbol:mt76_connac_mcu_uni_add_dev symbol:mt76_connac_mcu_sta_ba_tlv symbol:mt76_connac_mcu_sta_wed_update symbol:mt76_connac_mcu_sta_ba symbol:mt76_connac_get_phy_mode symbol:mt76_connac_get_phy_mode_ext symbol:mt76_connac_get_he_phy_cap symbol:mt76_connac_get_eht_phy_cap symbol:mt76_connac_mcu_uni_set_chctx symbol:mt76_connac_mcu_uni_add_bss symbol:mt76_connac_mcu_hw_scan symbol:mt76_connac_mcu_cancel_hw_scan symbol:mt76_connac_mcu_sched_scan_req symbol:mt76_connac_mcu_sched_scan_enable symbol:mt76_connac_mcu_chip_config symbol:mt76_connac_mcu_set_deep_sleep symbol:mt76_connac_sta_state_dp symbol:mt76_connac_mcu_coredump_event symbol:mt76_connac_get_ch_power symbol:mt76_connac_mcu_set_rate_txpower symbol:mt76_connac_mcu_update_arp_filter symbol:mt76_connac_mcu_set_p2p_oppps symbol:mt76_connac_wowlan_support symbol:mt76_connac_mcu_update_gtk_rekey symbol:mt76_connac_mcu_set_gtk_rekey symbol:mt76_connac_mcu_set_suspend_mode symbol:mt76_connac_mcu_set_wow_ctrl symbol:mt76_connac_mcu_set_hif_suspend symbol:mt76_connac_mcu_set_suspend_iter symbol:mt76_connac_mcu_reg_rr symbol:mt76_connac_mcu_reg_wr symbol:mt76_connac_mcu_add_key symbol:mt76_connac_mcu_bss_ext_tlv symbol:mt76_connac_mcu_bss_basic_tlv symbol:mt76_connac_mcu_set_pm symbol:mt76_connac_mcu_restart symbol:mt76_connac_mcu_del_wtbl_all symbol:mt76_connac_mcu_rdd_cmd symbol:mt76_connac2_load_ram symbol:mt76_connac2_load_patch symbol:mt76_connac2_mcu_fill_message symbol:mt76_connac_gen_ppe_thresh symbol:mt76_connac_pm_wake symbol:mt76_connac_power_save_sched symbol:mt76_connac_free_pending_tx_skbs symbol:mt76_connac_pm_queue_skb symbol:mt76_connac_pm_dequeue_skbs symbol:mt76_connac_tx_complete_skb symbol:mt76_connac_write_hw_txp symbol:mt76_connac_txp_skb_unmap symbol:mt76_connac_init_tx_queues symbol:mt76_connac2_mac_tx_rate_val symbol:mt76_connac2_mac_write_txwi symbol:mt76_connac2_mac_fill_txs symbol:mt76_connac2_mac_add_txs_skb symbol:mt76_connac2_mac_decode_he_radiotap symbol:mt76_connac2_reverse_frag0_hdr_trans symbol:mt76_connac2_mac_fill_rx_rate symbol:mt76_connac2_tx_check_aggr symbol:mt76_connac2_txwi_free symbol:mt76_connac2_tx_token_put symbol:mt76_connac3_mac_decode_he_radiotap symbol:mt76_connac3_mac_decode_eht_radiotap
mt76 mac80211 cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt76x0/mt76x0u.ko.xz usb:v0E8Dp7650d*dc*dsc*dp*icFFisc02ipFFin* usb:v0E8Dp7630d*dc*dsc*dp*icFFisc02ipFFin* usb:v2357p0105d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p010Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2357p0123d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0079d*dc*dsc*dp*ic*isc*ip*in* usb:v7392pC711d*dc*dsc*dp*ic*isc*ip*in* usb:v20F4p806Bd*dc*dsc*dp*ic*isc*ip*in* usb:v293Cp5702d*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8502d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0951d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p7610d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3425d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3D02d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB31d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0075d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17DBd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17D1d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp760Ad*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp761Ad*dc*dsc*dp*ic*isc*ip*in* usb:v7392pB711d*dc*dsc*dp*ic*isc*ip*in* usb:v7392pA711d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp7610d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p003Ed*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp7610d*dc*dsc*dp*ic*isc*ip*in*
mt76x02_usb mt76x0_common mt76x02_lib mt76 mac80211 mt76_usb

kernel/drivers/net/wireless/mediatek/mt76/mt76x0/mt76x0-common.ko.xz symbol:mt76x0_chip_onoff symbol:mt76x0_mac_stop symbol:mt76x0_init_hardware symbol:mt76x0_register_device symbol:mt76x0_set_channel symbol:mt76x0_set_sar_specs symbol:mt76x0_config symbol:mt76x0_phy_calibrate
mt76 mt76x02_lib cfg80211 mac80211

kernel/drivers/net/wireless/mediatek/mt76/mt7925/mt7925u.ko.xz usb:v0846p9072d*dc*dsc*dp*icFFiscFFipFFin* usb:v0E8Dp7925d*dc*dsc*dp*icFFiscFFipFFin*
mt76_usb mt792x_usb mt7925_common mt76 mt792x_lib mt76_connac_lib

kernel/drivers/net/wireless/mediatek/mt76/mt7925/mt7925e.ko.xz pci:v000014C3d00000717sv*sd*bc*sc*i* pci:v000014C3d00007925sv*sd*bc*sc*i*
mt792x_lib mt76_connac_lib mt76 mt7925_common

kernel/drivers/net/wireless/mediatek/mt76/mt7925/mt7925-common.ko.xz symbol:mt7925_mac_write_txwi symbol:mt7925_txwi_free symbol:mt7925_rx_check symbol:mt7925_queue_rx_skb symbol:mt7925_usb_sdio_tx_prepare_skb symbol:mt7925_usb_sdio_tx_complete_skb symbol:mt7925_usb_sdio_tx_status_data symbol:mt7925_mcu_parse_response symbol:mt7925_mcu_regval symbol:mt7925_mcu_set_deep_sleep symbol:mt7925_mcu_set_thermal_protect symbol:mt7925_run_firmware symbol:mt7925_mcu_set_eeprom symbol:mt7925_mcu_hw_scan symbol:mt7925_mcu_sched_scan_req symbol:mt7925_mcu_cancel_hw_scan symbol:mt7925_mcu_set_channel_domain symbol:mt7925_mcu_fill_message symbol:__mt7925_start symbol:mt7925_roc_abort_sync symbol:mt7925_mac_sta_add symbol:mt7925_mac_sta_event symbol:mt7925_mac_sta_remove symbol:mt7925_ops symbol:mt7925_regd_update symbol:mt7925_mac_init symbol:mt7925_register_device
mt76_connac_lib mac80211 mt792x_lib mt76 cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt76-usb.ko.xz symbol:__mt76u_vendor_request symbol:mt76u_vendor_request symbol:___mt76u_rr symbol:___mt76u_wr symbol:mt76u_read_copy symbol:mt76u_single_wr symbol:mt76u_alloc_mcu_queue symbol:mt76u_stop_rx symbol:mt76u_resume_rx symbol:mt76u_stop_tx symbol:mt76u_queues_deinit symbol:mt76u_alloc_queues symbol:__mt76u_init symbol:mt76u_init
mt76

kernel/drivers/net/wireless/mediatek/mt76/mt792x-lib.ko.xz symbol:mt792x_tx symbol:mt792x_stop symbol:mt792x_mac_link_bss_remove symbol:mt792x_remove_interface symbol:mt792x_conf_tx symbol:mt792x_get_stats symbol:mt792x_get_tsf symbol:mt792x_set_tsf symbol:mt792x_tx_worker symbol:mt792x_roc_timer symbol:mt792x_flush symbol:mt792x_assign_vif_chanctx symbol:mt792x_unassign_vif_chanctx symbol:mt792x_set_wakeup symbol:mt792x_get_et_strings symbol:mt792x_get_et_sset_count symbol:mt792x_get_et_stats symbol:mt792x_sta_statistics symbol:mt792x_set_coverage_class symbol:mt792x_init_wiphy symbol:mt792x_get_mac80211_ops symbol:mt792x_init_wcid symbol:mt792x_mcu_drv_pmctrl symbol:mt792x_mcu_fw_pmctrl symbol:__mt792xe_mcu_drv_pmctrl symbol:mt792xe_mcu_drv_pmctrl symbol:mt792xe_mcu_fw_pmctrl symbol:mt792x_load_firmware symbol:mt792x_mac_work symbol:mt792x_mac_set_timeing symbol:mt792x_mac_update_mib_stats symbol:mt792x_rx_get_wcid symbol:mt792x_mac_assoc_rssi symbol:mt792x_mac_reset_counters symbol:mt792x_update_channel symbol:mt792x_reset symbol:mt792x_mac_init_band symbol:mt792x_pm_wake_work symbol:mt792x_pm_power_save_work symbol:__tracepoint_lp_event symbol:__traceiter_lp_event symbol:__SCK__tp_func_lp_event symbol:mt792x_tx_stats_show symbol:mt792x_queues_acq symbol:mt792x_queues_read symbol:mt792x_pm_stats symbol:mt792x_pm_idle_timeout_set symbol:mt792x_pm_idle_timeout_get symbol:mt792x_irq_handler symbol:mt792x_irq_tasklet symbol:mt792x_rx_poll_complete symbol:mt792x_dma_enable symbol:mt792x_wpdma_reset symbol:mt792x_wpdma_reinit_cond symbol:mt792x_dma_disable symbol:mt792x_dma_cleanup symbol:mt792x_poll_tx symbol:mt792x_poll_rx symbol:mt792x_wfsys_reset
mt76 mt76_connac_lib mac80211

kernel/drivers/net/wireless/mediatek/mt76/mt76x02-usb.ko.xz symbol:mt76x02u_mcu_fw_reset symbol:mt76x02u_mcu_fw_send_data symbol:mt76x02u_init_mcu symbol:mt76x02u_tx_complete_skb symbol:mt76x02u_mac_start symbol:mt76x02u_tx_prepare_skb symbol:mt76x02u_init_beacon_config symbol:mt76x02u_exit_beacon_config
mt76x02_lib mt76 mt76_usb cfg80211 mac80211

kernel/drivers/net/wireless/mediatek/mt76/mt76.ko.xz symbol:mt76_set_irq_mask symbol:mt76_mmio_init symbol:__mt76_poll symbol:____mt76_poll_msec symbol:mt76_wcid_alloc symbol:mt76_get_min_avg_rssi symbol:__mt76_worker_fn symbol:__tracepoint_mac_txdone symbol:__traceiter_mac_txdone symbol:__SCK__tp_func_mac_txdone symbol:__tracepoint_dev_irq symbol:__traceiter_dev_irq symbol:__SCK__tp_func_dev_irq symbol:mt76_get_rxwi symbol:mt76_put_txwi symbol:mt76_put_rxwi symbol:mt76_free_pending_rxwi symbol:mt76_dma_rx_poll symbol:mt76_dma_attach symbol:mt76_dma_cleanup symbol:mt76_rates symbol:mt76_set_stream_caps symbol:mt76_alloc_phy symbol:mt76_register_phy symbol:mt76_unregister_phy symbol:mt76_create_page_pool symbol:mt76_alloc_device symbol:mt76_register_device symbol:mt76_unregister_device symbol:mt76_free_device symbol:mt76_rx symbol:mt76_has_tx_pending symbol:mt76_update_survey_active_time symbol:mt76_update_survey symbol:mt76_update_channel symbol:mt76_get_survey symbol:mt76_wcid_key_setup symbol:mt76_rx_signal symbol:mt76_rx_poll_complete symbol:__mt76_sta_remove symbol:mt76_sta_state symbol:mt76_sta_pre_rcu_remove symbol:mt76_wcid_init symbol:mt76_wcid_cleanup symbol:mt76_get_txpower symbol:mt76_init_sar_power symbol:mt76_get_sar_power symbol:mt76_csa_finish symbol:mt76_csa_check symbol:mt76_set_tim symbol:mt76_insert_ccmp_hdr symbol:mt76_get_rate symbol:mt76_sw_scan symbol:mt76_sw_scan_complete symbol:mt76_get_antenna symbol:mt76_init_queue symbol:mt76_calculate_default_rate symbol:mt76_ethtool_worker symbol:mt76_ethtool_page_pool_stats symbol:mt76_phy_dfs_state symbol:mt76_queues_read symbol:mt76_seq_puts_array symbol:mt76_register_debugfs_fops symbol:mt76_get_of_data_from_mtd symbol:mt76_get_of_data_from_nvmem symbol:mt76_eeprom_override symbol:mt76_find_power_limits_node symbol:mt76_find_channel_node symbol:mt76_get_rate_power_limits symbol:mt76_eeprom_init symbol:mt76_tx_check_agg_ssn symbol:mt76_tx_status_lock symbol:mt76_tx_status_unlock symbol:mt76_tx_status_skb_done symbol:mt76_tx_status_skb_add symbol:mt76_tx_status_skb_get symbol:mt76_tx_status_check symbol:__mt76_tx_complete_skb symbol:mt76_tx symbol:mt76_release_buffered_frames symbol:mt76_txq_schedule symbol:mt76_txq_schedule_all symbol:mt76_tx_worker_run symbol:mt76_stop_tx_queues symbol:mt76_wake_tx_queue symbol:mt76_ac_to_hwq symbol:mt76_skb_adjust_pad symbol:mt76_queue_tx_complete symbol:__mt76_set_tx_blocked symbol:mt76_token_consume symbol:mt76_rx_token_consume symbol:mt76_token_release symbol:mt76_rx_token_release symbol:mt76_rx_aggr_start symbol:mt76_rx_aggr_stop symbol:__mt76_mcu_msg_alloc symbol:mt76_mcu_get_response symbol:mt76_mcu_rx_event symbol:mt76_mcu_send_and_get_msg symbol:mt76_mcu_skb_send_and_get_msg symbol:__mt76_mcu_send_firmware symbol:mt76_wed_release_rx_buf symbol:mt76_wed_offload_disable symbol:mt76_wed_reset_complete symbol:mt76_wed_net_setup_tc symbol:mt76_wed_dma_reset symbol:mt76_pci_disable_aspm symbol:mt76_pci_aspm_supported
mac80211 cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt76x2/mt76x2u.ko.xz usb:v2357p0137d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep02FEd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep02E6d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9053d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9014d*dc*dsc*dp*ic*isc*ip*in* usb:v2C4Ep0103d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p7600d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2126d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp7632d*dc*dsc*dp*ic*isc*ip*in* usb:v7392pB711d*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8503d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp7612d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p180Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17EBd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1833d*dc*dsc*dp*ic*isc*ip*in*
mt76x02_usb mt76 mt76x02_lib mt76x2_common mac80211 mt76_usb

kernel/drivers/net/wireless/mediatek/mt76/mt76x2/mt76x2-common.ko.xz symbol:mt76x2_read_rx_gain symbol:mt76x2_get_rate_power symbol:mt76x2_get_power_info symbol:mt76x2_get_temp_comp symbol:mt76x2_eeprom_init symbol:mt76x2_mac_stop symbol:mt76x2_set_sar_specs symbol:mt76x2_reset_wlan symbol:mt76_write_mac_initvals symbol:mt76x2_init_txpower symbol:mt76x2_apply_gain_adj symbol:mt76x2_phy_set_txpower_regs symbol:mt76x2_phy_set_txpower symbol:mt76x2_configure_tx_delay symbol:mt76x2_phy_tssi_compensate symbol:mt76x2_phy_update_channel_gain symbol:mt76x2_mcu_set_channel symbol:mt76x2_mcu_load_cr symbol:mt76x2_mcu_init_gain symbol:mt76x2_mcu_tssi_comp
mt76 mt76x02_lib cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt7921/mt7921-common.ko.xz symbol:mt7921_rx_check symbol:mt7921_queue_rx_skb symbol:mt7921_usb_sdio_tx_prepare_skb symbol:mt7921_usb_sdio_tx_complete_skb symbol:mt7921_usb_sdio_tx_status_data symbol:mt7921_mcu_parse_response symbol:mt7921_run_firmware symbol:mt7921_mcu_radio_led_ctrl symbol:mt7921_mcu_set_eeprom symbol:__mt7921_start symbol:mt7921_roc_abort_sync symbol:mt7921_set_channel symbol:mt7921_mac_sta_add symbol:mt7921_mac_sta_event symbol:mt7921_mac_sta_remove symbol:mt7921_ops symbol:mt7921_regd_update symbol:mt7921_mac_init symbol:mt7921_register_device
mt76_connac_lib mt76 mac80211 mt792x_lib cfg80211

kernel/drivers/net/wireless/mediatek/mt76/mt7921/mt7921u.ko.xz usb:v35BCp0107d*dc*dsc*dp*icFFiscFFipFFin* usb:v0846p9065d*dc*dsc*dp*icFFiscFFipFFin* usb:v0846p9060d*dc*dsc*dp*icFFiscFFipFFin* usb:v3574p6211d*dc*dsc*dp*icFFiscFFipFFin* usb:v0E8Dp7961d*dc*dsc*dp*icFFiscFFipFFin*
mt76_usb mt792x_usb mt7921_common mt76 mt76_connac_lib mt792x_lib

kernel/drivers/net/wireless/mediatek/mt76/mt792x-usb.ko.xz symbol:mt792xu_rr symbol:mt792xu_wr symbol:mt792xu_rmw symbol:mt792xu_copy symbol:mt792xu_mcu_power_on symbol:mt792xu_dma_init symbol:mt792xu_wfsys_reset symbol:mt792xu_init_reset symbol:mt792xu_stop symbol:mt792xu_disconnect
mt792x_lib mt76_usb mt76

kernel/drivers/net/wireless/mediatek/mt76/mt76x02-lib.ko.xz symbol:mt76x02_rates symbol:mt76x02_init_device symbol:mt76x02_configure_filter symbol:mt76x02_sta_add symbol:mt76x02_sta_remove symbol:mt76x02_add_interface symbol:mt76x02_remove_interface symbol:mt76x02_ampdu_action symbol:mt76x02_set_key symbol:mt76x02_conf_tx symbol:mt76x02_set_tx_ackto symbol:mt76x02_set_coverage_class symbol:mt76x02_set_rts_threshold symbol:mt76x02_sta_rate_tbl_update symbol:mt76x02_remove_hdr_pad symbol:mt76x02_sw_scan_complete symbol:mt76x02_sta_ps symbol:mt76x02_bss_info_changed symbol:mt76x02_config_mac_addr_list symbol:mt76x02_mac_reset_counters symbol:mt76x02_mac_shared_key_setup symbol:mt76x02_mac_wcid_setup symbol:mt76x02_mac_write_txwi symbol:mt76x02_mac_setaddr symbol:mt76x02_tx_complete_skb symbol:mt76x02_update_channel symbol:mt76x02_edcca_init symbol:mt76x02_mac_cc_reset symbol:mt76x02_mcu_parse_response symbol:mt76x02_mcu_msg_send symbol:mt76x02_mcu_function_select symbol:mt76x02_mcu_set_radio_state symbol:mt76x02_mcu_calibrate symbol:mt76x02_mcu_cleanup symbol:mt76x02_set_ethtool_fwver symbol:mt76x02_eeprom_copy symbol:mt76x02_get_efuse_data symbol:mt76x02_eeprom_parse_hw_cap symbol:mt76x02_ext_pa_enabled symbol:mt76x02_get_rx_gain symbol:mt76x02_get_lna_gain symbol:mt76x02_phy_set_rxpath symbol:mt76x02_phy_set_txdac symbol:mt76x02_get_max_rate_power symbol:mt76x02_limit_rate_power symbol:mt76x02_add_rate_power_offset symbol:mt76x02_phy_set_txpower symbol:mt76x02_phy_set_bw symbol:mt76x02_phy_set_band symbol:mt76x02_phy_adjust_vga_gain symbol:mt76x02_init_agc_gain symbol:mt76x02e_init_beacon_config symbol:mt76x02_dma_init symbol:mt76x02_rx_poll_complete symbol:mt76x02_irq_handler symbol:mt76x02_dma_disable symbol:mt76x02_mac_start symbol:mt76x02_reconfig_complete symbol:mt76x02_tx symbol:mt76x02_queue_rx_skb symbol:mt76x02_tx_set_txpwr_auto symbol:mt76x02_tx_status_data symbol:mt76x02_tx_prepare_skb symbol:mt76x02_init_debugfs symbol:mt76x02_phy_dfs_adjust_agc symbol:mt76x02_dfs_init_params symbol:mt76x02_mac_set_beacon symbol:mt76x02_resync_beacon_timer symbol:mt76x02_update_beacon_iter symbol:mt76x02_enqueue_buffered_bc symbol:mt76x02_init_beacon_config
mac80211 mt76 cfg80211

kernel/drivers/net/wireless/intel/iwlwifi/iwlwifi.ko.xz pci:v00008086d0000272Fsv*sd*bc*sc*i* pci:v00008086d00006E70sv*sd*bc*sc*i* pci:v00008086d0000D340sv*sd*bc*sc*i* pci:v00008086d0000E340sv*sd*bc*sc*i* pci:v00008086d0000E440sv*sd*bc*sc*i* pci:v00008086d00004D40sv*sd*bc*sc*i* pci:v00008086d00007740sv*sd*bc*sc*i* pci:v00008086d0000A840sv*sd00004314bc*sc*i* pci:v00008086d0000A840sv*sd00004110bc*sc*i* pci:v00008086d0000A840sv*sd000040E0bc*sc*i* pci:v00008086d0000A840sv*sd000040C4bc*sc*i* pci:v00008086d0000A840sv*sd00004090bc*sc*i* pci:v00008086d0000A840sv*sd00001792bc*sc*i* pci:v00008086d0000A840sv*sd00001791bc*sc*i* pci:v00008086d0000A840sv*sd00001772bc*sc*i* pci:v00008086d0000A840sv*sd00001771bc*sc*i* pci:v00008086d0000A840sv*sd00001672bc*sc*i* pci:v00008086d0000A840sv*sd00001671bc*sc*i* pci:v00008086d0000A840sv*sd00000A10bc*sc*i* pci:v00008086d0000A840sv*sd00000510bc*sc*i* pci:v00008086d0000A840sv*sd00000314bc*sc*i* pci:v00008086d0000A840sv*sd00000310bc*sc*i* pci:v00008086d0000A840sv*sd0000011Cbc*sc*i* pci:v00008086d0000A840sv*sd00000118bc*sc*i* pci:v00008086d0000A840sv*sd00000114bc*sc*i* pci:v00008086d0000A840sv*sd00000110bc*sc*i* pci:v00008086d0000A840sv*sd00000100bc*sc*i* pci:v00008086d0000A840sv*sd000000ECbc*sc*i* pci:v00008086d0000A840sv*sd000000E8bc*sc*i* pci:v00008086d0000A840sv*sd000000E4bc*sc*i* pci:v00008086d0000A840sv*sd000000E0bc*sc*i* pci:v00008086d0000A840sv*sd000000C4bc*sc*i* pci:v00008086d0000A840sv*sd000000C0bc*sc*i* pci:v00008086d0000A840sv*sd0000009Cbc*sc*i* pci:v00008086d0000A840sv*sd00000098bc*sc*i* pci:v00008086d0000A840sv*sd00000094bc*sc*i* pci:v00008086d0000A840sv*sd00000090bc*sc*i* pci:v00008086d0000A840sv*sd00000000bc*sc*i* pci:v00008086d0000272Bsv*sd*bc*sc*i* pci:v00008086d00007E40sv*sd*bc*sc*i* pci:v00008086d00002729sv*sd*bc*sc*i* pci:v00008086d00007F70sv*sd*bc*sc*i* pci:v00008086d000054F0sv*sd*bc*sc*i* pci:v00008086d000051F1sv*sd*bc*sc*i* pci:v00008086d000051F0sv*sd*bc*sc*i* pci:v00008086d00007AF0sv*sd*bc*sc*i* pci:v00008086d00007A70sv*sd*bc*sc*i* pci:v00008086d00002725sv*sd*bc*sc*i* pci:v00008086d00002723sv*sd*bc*sc*i* pci:v00008086d0000A0F0sv*sd*bc*sc*i* pci:v00008086d000043F0sv*sd*bc*sc*i* pci:v00008086d00004DF0sv*sd*bc*sc*i* pci:v00008086d00003DF0sv*sd*bc*sc*i* pci:v00008086d000034F0sv*sd*bc*sc*i* pci:v00008086d000006F0sv*sd*bc*sc*i* pci:v00008086d000002F0sv*sd*bc*sc*i* pci:v00008086d0000A370sv*sd*bc*sc*i* pci:v00008086d00009DF0sv*sd*bc*sc*i* pci:v00008086d000031DCsv*sd*bc*sc*i* pci:v00008086d000030DCsv*sd*bc*sc*i* pci:v00008086d0000271Csv*sd*bc*sc*i* pci:v00008086d0000271Bsv*sd*bc*sc*i* pci:v00008086d00002526sv*sd*bc*sc*i* pci:v00008086d000024FDsv*sd00009074bc*sc*i* pci:v00008086d000024FDsv*sd00000014bc*sc*i* pci:v00008086d000024FDsv*sd00000012bc*sc*i* pci:v00008086d000024FDsv*sd00001012bc*sc*i* pci:v00008086d000024FDsv*sd00003E01bc*sc*i* pci:v00008086d000024FDsv*sd00003E02bc*sc*i* pci:v00008086d000024FDsv*sd00001014bc*sc*i* pci:v00008086d000024FDsv*sd00000850bc*sc*i* pci:v00008086d000024FDsv*sd00000950bc*sc*i* pci:v00008086d000024FDsv*sd00000930bc*sc*i* pci:v00008086d000024FDsv*sd00000910bc*sc*i* pci:v00008086d000024FDsv*sd00008130bc*sc*i* pci:v00008086d000024FDsv*sd00009110bc*sc*i* pci:v00008086d000024FDsv*sd00000810bc*sc*i* pci:v00008086d000024FDsv*sd00008010bc*sc*i* pci:v00008086d000024FDsv*sd00008050bc*sc*i* pci:v00008086d000024FDsv*sd00008110bc*sc*i* pci:v00008086d000024FDsv*sd00009010bc*sc*i* pci:v00008086d000024FDsv*sd00000150bc*sc*i* pci:v00008086d000024FDsv*sd00000050bc*sc*i* pci:v00008086d000024FDsv*sd000010D0bc*sc*i* pci:v00008086d000024FDsv*sd00001010bc*sc*i* pci:v00008086d000024FDsv*sd00000130bc*sc*i* pci:v00008086d000024FDsv*sd00001130bc*sc*i* pci:v00008086d000024FDsv*sd00001110bc*sc*i* pci:v00008086d000024FDsv*sd00000110bc*sc*i* pci:v00008086d000024FDsv*sd00000010bc*sc*i* pci:v00008086d000024F3sv*sd00004010bc*sc*i* pci:v00008086d000024F3sv*sd00000000bc*sc*i* pci:v00008086d000024F3sv*sd00000930bc*sc*i* pci:v00008086d000024F3sv*sd00000950bc*sc*i* pci:v00008086d000024F3sv*sd00000850bc*sc*i* pci:v00008086d000024F3sv*sd00000910bc*sc*i* pci:v00008086d000024F3sv*sd00000810bc*sc*i* pci:v00008086d000024F6sv*sd00000030bc*sc*i* pci:v00008086d000024F5sv*sd00000010bc*sc*i* pci:v00008086d000024F3sv*sd00000044bc*sc*i* pci:v00008086d000024F3sv*sd00000004bc*sc*i* pci:v00008086d000024F3sv*sd00009150bc*sc*i* pci:v00008086d000024F3sv*sd00009050bc*sc*i* pci:v00008086d000024F3sv*sd00008150bc*sc*i* pci:v00008086d000024F3sv*sd00008050bc*sc*i* pci:v00008086d000024F3sv*sd00009132bc*sc*i* pci:v00008086d000024F3sv*sd00008132bc*sc*i* pci:v00008086d000024F3sv*sd00009130bc*sc*i* pci:v00008086d000024F3sv*sd00008130bc*sc*i* pci:v00008086d000024F4sv*sd0000D030bc*sc*i* pci:v00008086d000024F4sv*sd0000C030bc*sc*i* pci:v00008086d000024F4sv*sd00009030bc*sc*i* pci:v00008086d000024F4sv*sd00008030bc*sc*i* pci:v00008086d000024F3sv*sd00009110bc*sc*i* pci:v00008086d000024F3sv*sd00009010bc*sc*i* pci:v00008086d000024F3sv*sd00008110bc*sc*i* pci:v00008086d000024F3sv*sd00008010bc*sc*i* pci:v00008086d000024F3sv*sd0000B0B0bc*sc*i* pci:v00008086d000024F3sv*sd0000D0B0bc*sc*i* pci:v00008086d000024F3sv*sd0000D050bc*sc*i* pci:v00008086d000024F3sv*sd0000C050bc*sc*i* pci:v00008086d000024F3sv*sd0000D010bc*sc*i* pci:v00008086d000024F3sv*sd0000C110bc*sc*i* pci:v00008086d000024F3sv*sd0000C010bc*sc*i* pci:v00008086d000024F4sv*sd00001030bc*sc*i* pci:v00008086d000024F4sv*sd00000030bc*sc*i* pci:v00008086d000024F3sv*sd00001150bc*sc*i* pci:v00008086d000024F3sv*sd00000150bc*sc*i* pci:v00008086d000024F3sv*sd00001050bc*sc*i* pci:v00008086d000024F3sv*sd00000250bc*sc*i* pci:v00008086d000024F3sv*sd00000050bc*sc*i* pci:v00008086d000024F3sv*sd00001110bc*sc*i* pci:v00008086d000024F3sv*sd00001012bc*sc*i* pci:v00008086d000024F3sv*sd00000012bc*sc*i* pci:v00008086d000024F3sv*sd000001F0bc*sc*i* pci:v00008086d000024F3sv*sd00000110bc*sc*i* pci:v00008086d000024F3sv*sd00001132bc*sc*i* pci:v00008086d000024F3sv*sd00000132bc*sc*i* pci:v00008086d000024F3sv*sd00001130bc*sc*i* pci:v00008086d000024F3sv*sd00000130bc*sc*i* pci:v00008086d000024F3sv*sd000010B0bc*sc*i* pci:v00008086d000024F3sv*sd00001010bc*sc*i* pci:v00008086d000024F3sv*sd00000010bc*sc*i* pci:v00008086d0000095Asv*sd00009E10bc*sc*i* pci:v00008086d0000095Asv*sd00009400bc*sc*i* pci:v00008086d0000095Asv*sd00009000bc*sc*i* pci:v00008086d0000095Bsv*sd0000520Abc*sc*i* pci:v00008086d0000095Bsv*sd00005212bc*sc*i* pci:v00008086d0000095Asv*sd00005F10bc*sc*i* pci:v00008086d0000095Asv*sd00005490bc*sc*i* pci:v00008086d0000095Bsv*sd00005290bc*sc*i* pci:v00008086d0000095Asv*sd00005590bc*sc*i* pci:v00008086d0000095Asv*sd00005190bc*sc*i* pci:v00008086d0000095Asv*sd00005090bc*sc*i* pci:v00008086d0000095Asv*sd00005420bc*sc*i* pci:v00008086d0000095Asv*sd0000502Abc*sc*i* pci:v00008086d0000095Asv*sd00005020bc*sc*i* pci:v00008086d0000095Asv*sd00009410bc*sc*i* pci:v00008086d0000095Bsv*sd00009310bc*sc*i* pci:v00008086d0000095Asv*sd00009510bc*sc*i* pci:v00008086d0000095Bsv*sd00009200bc*sc*i* pci:v00008086d0000095Bsv*sd00009210bc*sc*i* pci:v00008086d0000095Asv*sd00009112bc*sc*i* pci:v00008086d0000095Asv*sd00009110bc*sc*i* pci:v00008086d0000095Asv*sd0000900Abc*sc*i* pci:v00008086d0000095Asv*sd00009012bc*sc*i* pci:v00008086d0000095Asv*sd00009010bc*sc*i* pci:v00008086d0000095Bsv*sd00005202bc*sc*i* pci:v00008086d0000095Asv*sd00005102bc*sc*i* pci:v00008086d0000095Asv*sd00005002bc*sc*i* pci:v00008086d0000095Bsv*sd00005200bc*sc*i* pci:v00008086d0000095Asv*sd0000500Abc*sc*i* pci:v00008086d0000095Asv*sd00005000bc*sc*i* pci:v00008086d0000095Asv*sd00001010bc*sc*i* pci:v00008086d0000095Asv*sd00005400bc*sc*i* pci:v00008086d0000095Asv*sd00005510bc*sc*i* pci:v00008086d0000095Asv*sd00005410bc*sc*i* pci:v00008086d0000095Asv*sd00005412bc*sc*i* pci:v00008086d0000095Asv*sd00005012bc*sc*i* pci:v00008086d0000095Asv*sd00005C10bc*sc*i* pci:v00008086d0000095Bsv*sd00005210bc*sc*i* pci:v00008086d0000095Bsv*sd00005302bc*sc*i* pci:v00008086d0000095Bsv*sd00005310bc*sc*i* pci:v00008086d0000095Asv*sd00005100bc*sc*i* pci:v00008086d0000095Asv*sd00005110bc*sc*i* pci:v00008086d0000095Asv*sd00005010bc*sc*i* pci:v00008086d000024FBsv*sd00000000bc*sc*i* pci:v00008086d000024FBsv*sd00002150bc*sc*i* pci:v00008086d000024FBsv*sd00002050bc*sc*i* pci:v00008086d000024FBsv*sd00002110bc*sc*i* pci:v00008086d000024FBsv*sd00002010bc*sc*i* pci:v00008086d00003165sv*sd00008110bc*sc*i* pci:v00008086d00003165sv*sd00008010bc*sc*i* pci:v00008086d00003166sv*sd00004210bc*sc*i* pci:v00008086d00003166sv*sd00004310bc*sc*i* pci:v00008086d00003165sv*sd00004110bc*sc*i* pci:v00008086d00003165sv*sd00004510bc*sc*i* pci:v00008086d00003165sv*sd00004410bc*sc*i* pci:v00008086d00003166sv*sd00004212bc*sc*i* pci:v00008086d00003165sv*sd00004012bc*sc*i* pci:v00008086d00003165sv*sd00004010bc*sc*i* pci:v00008086d000008B3sv*sd00001170bc*sc*i* pci:v00008086d000008B3sv*sd00001070bc*sc*i* pci:v00008086d000008B3sv*sd00008570bc*sc*i* pci:v00008086d000008B3sv*sd00008470bc*sc*i* pci:v00008086d000008B4sv*sd00008272bc*sc*i* pci:v00008086d000008B4sv*sd00008370bc*sc*i* pci:v00008086d000008B4sv*sd00008270bc*sc*i* pci:v00008086d000008B3sv*sd00008062bc*sc*i* pci:v00008086d000008B3sv*sd00008060bc*sc*i* pci:v00008086d000008B3sv*sd00008172bc*sc*i* pci:v00008086d000008B3sv*sd00008170bc*sc*i* pci:v00008086d000008B3sv*sd00008072bc*sc*i* pci:v00008086d000008B3sv*sd00008070bc*sc*i* pci:v00008086d000008B4sv*sd00000370bc*sc*i* pci:v00008086d000008B3sv*sd00000472bc*sc*i* pci:v00008086d000008B3sv*sd00000470bc*sc*i* pci:v00008086d000008B4sv*sd00000272bc*sc*i* pci:v00008086d000008B4sv*sd00000270bc*sc*i* pci:v00008086d000008B3sv*sd00000062bc*sc*i* pci:v00008086d000008B3sv*sd00000060bc*sc*i* pci:v00008086d000008B3sv*sd00000172bc*sc*i* pci:v00008086d000008B3sv*sd00000170bc*sc*i* pci:v00008086d000008B3sv*sd00000072bc*sc*i* pci:v00008086d000008B3sv*sd00000070bc*sc*i* pci:v00008086d000008B1sv*sd0000C420bc*sc*i* pci:v00008086d000008B2sv*sd0000C220bc*sc*i* pci:v00008086d000008B1sv*sd0000C02Abc*sc*i* pci:v00008086d000008B1sv*sd0000C020bc*sc*i* pci:v00008086d000008B1sv*sd0000C360bc*sc*i* pci:v00008086d000008B2sv*sd0000C370bc*sc*i* pci:v00008086d000008B1sv*sd0000C560bc*sc*i* pci:v00008086d000008B1sv*sd0000C570bc*sc*i* pci:v00008086d000008B1sv*sd0000C462bc*sc*i* pci:v00008086d000008B1sv*sd0000C460bc*sc*i* pci:v00008086d000008B1sv*sd0000C472bc*sc*i* pci:v00008086d000008B1sv*sd0000C470bc*sc*i* pci:v00008086d000008B2sv*sd0000C262bc*sc*i* pci:v00008086d000008B2sv*sd0000C26Abc*sc*i* pci:v00008086d000008B2sv*sd0000C260bc*sc*i* pci:v00008086d000008B2sv*sd0000C272bc*sc*i* pci:v00008086d000008B1sv*sd0000CC60bc*sc*i* pci:v00008086d000008B1sv*sd0000CC70bc*sc*i* pci:v00008086d000008B2sv*sd0000C270bc*sc*i* pci:v00008086d000008B1sv*sd0000C760bc*sc*i* pci:v00008086d000008B1sv*sd0000C770bc*sc*i* pci:v00008086d000008B1sv*sd0000C162bc*sc*i* pci:v00008086d000008B1sv*sd0000C062bc*sc*i* pci:v00008086d000008B1sv*sd0000C160bc*sc*i* pci:v00008086d000008B1sv*sd0000C06Abc*sc*i* pci:v00008086d000008B1sv*sd0000C060bc*sc*i* pci:v00008086d000008B1sv*sd0000C170bc*sc*i* pci:v00008086d000008B1sv*sd0000C072bc*sc*i* pci:v00008086d000008B1sv*sd0000C070bc*sc*i* pci:v00008086d000008B1sv*sd00004420bc*sc*i* pci:v00008086d000008B2sv*sd00004220bc*sc*i* pci:v00008086d000008B1sv*sd0000402Abc*sc*i* pci:v00008086d000008B1sv*sd00004020bc*sc*i* pci:v00008086d000008B1sv*sd00005770bc*sc*i* pci:v00008086d000008B1sv*sd00005170bc*sc*i* pci:v00008086d000008B1sv*sd00005072bc*sc*i* pci:v00008086d000008B1sv*sd00005070bc*sc*i* pci:v00008086d000008B2sv*sd00004360bc*sc*i* pci:v00008086d000008B2sv*sd00004370bc*sc*i* pci:v00008086d000008B1sv*sd00004560bc*sc*i* pci:v00008086d000008B1sv*sd00004570bc*sc*i* pci:v00008086d000008B1sv*sd00004A6Cbc*sc*i* pci:v00008086d000008B1sv*sd00004A6Ebc*sc*i* pci:v00008086d000008B1sv*sd00004A70bc*sc*i* pci:v00008086d000008B1sv*sd0000486Ebc*sc*i* pci:v00008086d000008B1sv*sd00004870bc*sc*i* pci:v00008086d000008B1sv*sd00004462bc*sc*i* pci:v00008086d000008B1sv*sd0000446Abc*sc*i* pci:v00008086d000008B1sv*sd00004460bc*sc*i* pci:v00008086d000008B1sv*sd00004472bc*sc*i* pci:v00008086d000008B1sv*sd00004470bc*sc*i* pci:v00008086d000008B2sv*sd00004262bc*sc*i* pci:v00008086d000008B2sv*sd0000426Abc*sc*i* pci:v00008086d000008B2sv*sd00004260bc*sc*i* pci:v00008086d000008B2sv*sd00004272bc*sc*i* pci:v00008086d000008B2sv*sd00004270bc*sc*i* pci:v00008086d000008B1sv*sd00004162bc*sc*i* pci:v00008086d000008B1sv*sd00004062bc*sc*i* pci:v00008086d000008B1sv*sd00004160bc*sc*i* pci:v00008086d000008B1sv*sd0000406Abc*sc*i* pci:v00008086d000008B1sv*sd00004060bc*sc*i* pci:v00008086d000008B1sv*sd00004C70bc*sc*i* pci:v00008086d000008B1sv*sd00004C60bc*sc*i* pci:v00008086d000008B1sv*sd00004170bc*sc*i* pci:v00008086d000008B1sv*sd00004072bc*sc*i* pci:v00008086d000008B1sv*sd00004070bc*sc*i* pci:v00008086d00000892sv*sd00000462bc*sc*i* pci:v00008086d00000893sv*sd00000262bc*sc*i* pci:v00008086d00000892sv*sd00000062bc*sc*i* pci:v00008086d00000894sv*sd00000822bc*sc*i* pci:v00008086d00000894sv*sd00000422bc*sc*i* pci:v00008086d00000895sv*sd00000222bc*sc*i* pci:v00008086d00000894sv*sd00000022bc*sc*i* pci:v00008086d0000088Fsv*sd00005260bc*sc*i* pci:v00008086d0000088Esv*sd00004860bc*sc*i* pci:v00008086d0000088Esv*sd0000446Abc*sc*i* pci:v00008086d0000088Esv*sd00004460bc*sc*i* pci:v00008086d0000088Fsv*sd0000426Abc*sc*i* pci:v00008086d0000088Fsv*sd00004260bc*sc*i* pci:v00008086d0000088Esv*sd0000406Abc*sc*i* pci:v00008086d0000088Esv*sd00004060bc*sc*i* pci:v00008086d00000887sv*sd00004462bc*sc*i* pci:v00008086d00000888sv*sd00004262bc*sc*i* pci:v00008086d00000887sv*sd00004062bc*sc*i* pci:v00008086d00000890sv*sd00004822bc*sc*i* pci:v00008086d00000890sv*sd00004422bc*sc*i* pci:v00008086d00000891sv*sd00004222bc*sc*i* pci:v00008086d00000890sv*sd00004022bc*sc*i* pci:v00008086d00000896sv*sd00005027bc*sc*i* pci:v00008086d00000896sv*sd00005025bc*sc*i* pci:v00008086d00000897sv*sd00005017bc*sc*i* pci:v00008086d00000897sv*sd00005015bc*sc*i* pci:v00008086d00000896sv*sd00005007bc*sc*i* pci:v00008086d00000896sv*sd00005005bc*sc*i* pci:v00008086d000008AEsv*sd00001027bc*sc*i* pci:v00008086d000008AEsv*sd00001025bc*sc*i* pci:v00008086d000008AFsv*sd00001017bc*sc*i* pci:v00008086d000008AFsv*sd00001015bc*sc*i* pci:v00008086d000008AEsv*sd00001007bc*sc*i* pci:v00008086d000008AEsv*sd00001005bc*sc*i* pci:v00008086d00000084sv*sd00001316bc*sc*i* pci:v00008086d00000084sv*sd00001216bc*sc*i* pci:v00008086d00000083sv*sd00001326bc*sc*i* pci:v00008086d00000083sv*sd00001226bc*sc*i* pci:v00008086d00000083sv*sd00001306bc*sc*i* pci:v00008086d00000083sv*sd00001206bc*sc*i* pci:v00008086d00000084sv*sd00001315bc*sc*i* pci:v00008086d00000084sv*sd00001215bc*sc*i* pci:v00008086d00000083sv*sd00001325bc*sc*i* pci:v00008086d00000083sv*sd00001225bc*sc*i* pci:v00008086d00000083sv*sd00001305bc*sc*i* pci:v00008086d00000083sv*sd00001205bc*sc*i* pci:v00008086d00000886sv*sd00001317bc*sc*i* pci:v00008086d00000886sv*sd00001315bc*sc*i* pci:v00008086d00000885sv*sd00001327bc*sc*i* pci:v00008086d00000885sv*sd00001325bc*sc*i* pci:v00008086d00000885sv*sd00001307bc*sc*i* pci:v00008086d00000885sv*sd00001305bc*sc*i* pci:v00008086d00000089sv*sd00001316bc*sc*i* pci:v00008086d00000089sv*sd00001311bc*sc*i* pci:v00008086d00000087sv*sd00001326bc*sc*i* pci:v00008086d00000087sv*sd00001321bc*sc*i* pci:v00008086d00000087sv*sd00001306bc*sc*i* pci:v00008086d00000087sv*sd00001301bc*sc*i* pci:v00008086d00000091sv*sd00005226bc*sc*i* pci:v00008086d00000091sv*sd00005225bc*sc*i* pci:v00008086d00000091sv*sd00005221bc*sc*i* pci:v00008086d00000091sv*sd00005207bc*sc*i* pci:v00008086d00000091sv*sd00005206bc*sc*i* pci:v00008086d00000091sv*sd00005205bc*sc*i* pci:v00008086d00000091sv*sd00005201bc*sc*i* pci:v00008086d00000090sv*sd00005216bc*sc*i* pci:v00008086d00000090sv*sd00005215bc*sc*i* pci:v00008086d00000090sv*sd00005211bc*sc*i* pci:v00008086d0000008Bsv*sd00005317bc*sc*i* pci:v00008086d0000008Bsv*sd00005315bc*sc*i* pci:v00008086d0000008Asv*sd00005327bc*sc*i* pci:v00008086d0000008Asv*sd00005325bc*sc*i* pci:v00008086d0000008Asv*sd00005307bc*sc*i* pci:v00008086d0000008Asv*sd00005305bc*sc*i* pci:v00008086d00000082sv*sd00001305bc*sc*i* pci:v00008086d00000082sv*sd00001304bc*sc*i* pci:v00008086d00000082sv*sd00004820bc*sc*i* pci:v00008086d00000085sv*sd0000C228bc*sc*i* pci:v00008086d00000085sv*sd0000C220bc*sc*i* pci:v00008086d00000082sv*sd0000C020bc*sc*i* pci:v00008086d00000085sv*sd00001316bc*sc*i* pci:v00008086d00000085sv*sd00001318bc*sc*i* pci:v00008086d00000085sv*sd00001311bc*sc*i* pci:v00008086d00000082sv*sd00001328bc*sc*i* pci:v00008086d00000082sv*sd00001326bc*sc*i* pci:v00008086d00000082sv*sd00001321bc*sc*i* pci:v00008086d00000082sv*sd00001308bc*sc*i* pci:v00008086d00000082sv*sd00001307bc*sc*i* pci:v00008086d00000082sv*sd00001306bc*sc*i* pci:v00008086d00000082sv*sd00001301bc*sc*i* pci:v00008086d00004239sv*sd00001316bc*sc*i* pci:v00008086d00004239sv*sd00001311bc*sc*i* pci:v00008086d00004238sv*sd00001118bc*sc*i* pci:v00008086d00004238sv*sd00001111bc*sc*i* pci:v00008086d0000422Csv*sd00001326bc*sc*i* pci:v00008086d0000422Csv*sd00001321bc*sc*i* pci:v00008086d0000422Csv*sd00001307bc*sc*i* pci:v00008086d0000422Csv*sd00001306bc*sc*i* pci:v00008086d0000422Csv*sd00001301bc*sc*i* pci:v00008086d0000422Bsv*sd00001128bc*sc*i* pci:v00008086d0000422Bsv*sd00001121bc*sc*i* pci:v00008086d0000422Bsv*sd00001108bc*sc*i* pci:v00008086d0000422Bsv*sd00001101bc*sc*i* pci:v00008086d0000423Dsv*sd00001316bc*sc*i* pci:v00008086d0000423Dsv*sd00001216bc*sc*i* pci:v00008086d0000423Dsv*sd00001311bc*sc*i* pci:v00008086d0000423Dsv*sd00001211bc*sc*i* pci:v00008086d0000423Csv*sd00001326bc*sc*i* pci:v00008086d0000423Csv*sd00001321bc*sc*i* pci:v00008086d0000423Csv*sd00001221bc*sc*i* pci:v00008086d0000423Csv*sd00001306bc*sc*i* pci:v00008086d0000423Csv*sd00001206bc*sc*i* pci:v00008086d0000423Csv*sd00001301bc*sc*i* pci:v00008086d0000423Csv*sd00001201bc*sc*i* pci:v00008086d0000423Bsv*sd00001011bc*sc*i* pci:v00008086d0000423Asv*sd00001021bc*sc*i* pci:v00008086d0000423Asv*sd00001001bc*sc*i* pci:v00008086d00004236sv*sd00001114bc*sc*i* pci:v00008086d00004236sv*sd00001014bc*sc*i* pci:v00008086d00004236sv*sd00001111bc*sc*i* pci:v00008086d00004236sv*sd00001011bc*sc*i* pci:v00008086d00004235sv*sd00001104bc*sc*i* pci:v00008086d00004235sv*sd00001004bc*sc*i* pci:v00008086d00004235sv*sd00001101bc*sc*i* pci:v00008086d00004235sv*sd00001001bc*sc*i* pci:v00008086d00004235sv*sd00001124bc*sc*i* pci:v00008086d00004235sv*sd00001024bc*sc*i* pci:v00008086d00004235sv*sd00001121bc*sc*i* pci:v00008086d00004235sv*sd00001021bc*sc*i* pci:v00008086d00004237sv*sd00001316bc*sc*i* pci:v00008086d00004237sv*sd00001216bc*sc*i* pci:v00008086d00004237sv*sd00001315bc*sc*i* pci:v00008086d00004237sv*sd00001215bc*sc*i* pci:v00008086d00004237sv*sd00001314bc*sc*i* pci:v00008086d00004237sv*sd00001214bc*sc*i* pci:v00008086d00004237sv*sd00001311bc*sc*i* pci:v00008086d00004237sv*sd00001211bc*sc*i* pci:v00008086d00004232sv*sd00001326bc*sc*i* pci:v00008086d00004232sv*sd00001226bc*sc*i* pci:v00008086d00004232sv*sd00001325bc*sc*i* pci:v00008086d00004232sv*sd00001225bc*sc*i* pci:v00008086d00004232sv*sd00001324bc*sc*i* pci:v00008086d00004232sv*sd00001224bc*sc*i* pci:v00008086d00004232sv*sd00001321bc*sc*i* pci:v00008086d00004232sv*sd00001221bc*sc*i* pci:v00008086d00004232sv*sd00001306bc*sc*i* pci:v00008086d00004232sv*sd00001206bc*sc*i* pci:v00008086d00004232sv*sd00001305bc*sc*i* pci:v00008086d00004232sv*sd00001205bc*sc*i* pci:v00008086d00004232sv*sd00001304bc*sc*i* pci:v00008086d00004232sv*sd00001204bc*sc*i* pci:v00008086d00004232sv*sd00001301bc*sc*i* pci:v00008086d00004232sv*sd00001201bc*sc*i* symbol:iwl_write8 symbol:iwl_write32 symbol:iwl_write64 symbol:iwl_read32 symbol:iwl_poll_bit symbol:iwl_read_direct32 symbol:iwl_write_direct32 symbol:iwl_write_direct64 symbol:iwl_poll_direct_bit symbol:iwl_read_prph_no_grab symbol:iwl_write_prph_no_grab symbol:iwl_write_prph64_no_grab symbol:iwl_read_prph symbol:iwl_write_prph_delay symbol:iwl_set_bits_prph symbol:iwl_set_bits_mask_prph symbol:iwl_clear_bits_prph symbol:iwl_force_nmi symbol:iwl_finish_nic_init symbol:iwl_drv_get_fwname_pre symbol:iwlwifi_mod_params symbol:iwl_opmode_register symbol:iwl_opmode_deregister symbol:__iwl_warn symbol:__iwl_info symbol:__iwl_crit symbol:__iwl_err symbol:__iwl_dbg symbol:iwl_init_sband_channels symbol:iwl_init_ht_hw_capab symbol:iwl_phy_db_init symbol:iwl_phy_db_free symbol:iwl_phy_db_set_section symbol:iwl_send_phy_db_data symbol:iwl_reinit_cab symbol:iwl_parse_mei_nvm_data symbol:iwl_parse_nvm_data symbol:iwl_parse_nvm_mcc_info symbol:iwl_nvm_fixups symbol:iwl_read_external_nvm symbol:iwl_get_nvm symbol:iwl_trans_pcie_send_hcmd symbol:iwl_trans_pcie_remove symbol:iwl_dbg_tlv_del_timers symbol:_iwl_dbg_tlv_time_point symbol:iwl_trans_send_cmd symbol:iwl_get_cmd_string symbol:iwl_cmd_groups_verify_sorted symbol:iwl_trans_configure symbol:iwl_trans_start_hw symbol:iwl_trans_op_mode_leave symbol:iwl_trans_write8 symbol:iwl_trans_write32 symbol:iwl_trans_read32 symbol:iwl_trans_read_prph symbol:iwl_trans_write_prph symbol:iwl_trans_read_mem symbol:iwl_trans_write_mem symbol:iwl_trans_set_pmi symbol:iwl_trans_sw_reset symbol:iwl_trans_dump_data symbol:iwl_trans_d3_suspend symbol:iwl_trans_d3_resume symbol:iwl_trans_interrupts symbol:iwl_trans_sync_nmi symbol:iwl_trans_write_imr_mem symbol:iwl_trans_set_bits_mask symbol:iwl_trans_read_config32 symbol:_iwl_trans_grab_nic_access symbol:iwl_trans_release_nic_access symbol:iwl_trans_fw_alive symbol:iwl_trans_start_fw symbol:iwl_trans_stop_device symbol:iwl_trans_tx symbol:iwl_trans_reclaim symbol:iwl_trans_txq_disable symbol:iwl_trans_txq_enable_cfg symbol:iwl_trans_wait_txq_empty symbol:iwl_trans_wait_tx_queues_empty symbol:iwl_trans_freeze_txq_timer symbol:iwl_trans_txq_set_shared_mode symbol:iwl_trans_set_q_ptrs symbol:iwl_trans_txq_alloc symbol:iwl_trans_txq_free symbol:iwl_trans_get_rxq_dma_data symbol:iwl_trans_load_pnvm symbol:iwl_trans_set_pnvm symbol:iwl_trans_load_reduce_power symbol:iwl_trans_set_reduce_power symbol:iwl_fw_lookup_cmd_ver symbol:iwl_fw_lookup_notif_ver symbol:iwl_fw_lookup_assert_desc symbol:iwl_notification_wait_init symbol:iwl_notification_wait symbol:iwl_abort_notification_waits symbol:iwl_init_notification_wait symbol:iwl_remove_notification symbol:iwl_wait_notification symbol:iwl_fw_rate_idx_to_plcp symbol:iwl_rate_mcs symbol:iwl_rs_pretty_ant symbol:iwl_rs_pretty_bw symbol:iwl_new_rate_from_v1 symbol:rs_pretty_print_rate symbol:iwl_he_is_sgi symbol:iwl_dump_desc_assert symbol:iwl_fw_dbg_collect_desc symbol:iwl_fw_dbg_error_collect symbol:iwl_fw_dbg_collect symbol:iwl_fw_dbg_collect_trig symbol:iwl_fw_start_dbg_conf symbol:iwl_fw_dbg_read_d3_debug_data symbol:iwl_fw_dbg_stop_sync symbol:iwl_fw_dbg_stop_restart_recording symbol:iwl_fw_disable_dbg_asserts symbol:iwl_fw_dbg_clear_monitor_buf symbol:iwl_pnvm_load symbol:iwl_fwrt_dump_error_logs symbol:iwl_bios_get_wrds_table symbol:iwl_bios_get_ewrd_table symbol:iwl_bios_get_wgds_table symbol:iwl_bios_get_ppag_table symbol:iwl_bios_get_tas_table symbol:iwl_bios_get_pwr_limit symbol:iwl_bios_get_mcc symbol:iwl_bios_get_eckv symbol:iwl_bios_get_wbem symbol:iwl_sar_geo_support symbol:iwl_sar_geo_fill_table symbol:iwl_sar_fill_profile symbol:iwl_fill_ppag_table symbol:iwl_is_ppag_approved symbol:iwl_is_tas_approved symbol:iwl_fill_lari_config symbol:iwl_bios_get_dsm symbol:iwl_puncturing_is_allowed_in_bios symbol:iwl_free_fw_paging symbol:iwl_init_paging symbol:iwl_get_shared_mem_conf symbol:iwl_fw_runtime_init symbol:iwl_fw_runtime_suspend symbol:iwl_fw_runtime_resume symbol:iwl_set_soc_latency symbol:iwl_configure_rxq symbol:iwl_uefi_get_step_table symbol:iwl_uefi_get_sgom_table symbol:iwl_uefi_get_uats_table symbol:iwl_uefi_get_puncturing symbol:__tracepoint_iwlwifi_dev_ucode_event symbol:__traceiter_iwlwifi_dev_ucode_event symbol:__SCK__tp_func_iwlwifi_dev_ucode_event symbol:__tracepoint_iwlwifi_dev_ucode_cont_event symbol:__traceiter_iwlwifi_dev_ucode_cont_event symbol:__SCK__tp_func_iwlwifi_dev_ucode_cont_event symbol:__tracepoint_iwlwifi_dev_ucode_wrap_event symbol:__traceiter_iwlwifi_dev_ucode_wrap_event symbol:__SCK__tp_func_iwlwifi_dev_ucode_wrap_event
cfg80211

kernel/drivers/net/wireless/intel/iwlwifi/dvm/iwldvm.ko.xz
iwlwifi mac80211 cfg80211

kernel/drivers/net/wireless/intel/iwlwifi/mvm/iwlmvm.ko.xz
mac80211 iwlwifi cfg80211 rfkill

kernel/drivers/net/wireless/virtual/mac80211_hwsim.ko.xz
mac80211 cfg80211

kernel/drivers/net/wireless/intersil/p54/p54common.ko.xz prism54common symbol:p54_parse_eeprom symbol:p54_read_eeprom symbol:p54_parse_firmware symbol:p54_free_skb symbol:p54_rx symbol:p54_init_common symbol:p54_register_common symbol:p54_free_common symbol:p54_unregister_common
mac80211 cfg80211 crc_ccitt

kernel/drivers/net/wireless/intersil/p54/p54usb.ko.xz prism54usb usb:v413Cp8104d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8102d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp5513d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3705d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3704d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v1668p1050d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0427d*dc*dsc*dp*ic*isc*ip*in* usb:v1413p5400d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1260pEE22d*dc*dsc*dp*ic*isc*ip*in* usb:v124Ap4025d*dc*dsc*dp*ic*isc*ip*in* usb:v0D8Ep3762d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0015d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0008d*dc*dsc*dp*ic*isc*ip*in* usb:v0BF8p1009d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp0118d*dc*dsc*dp*ic*isc*ip*in* usb:v0915p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v0915p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4240d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApF503d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApC501d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4531d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4521d*dc*dsc*dp*ic*isc*ip*in* usb:v0803p4310d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0020d*dc*dsc*dp*ic*isc*ip*in* usb:v0707pEE13d*dc*dsc*dp*ic*isc*ip*in* usb:v06B9p0121d*dc*dsc*dp*ic*isc*ip*in* usb:v06A9p000Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0572p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp7050d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p1230d*dc*dsc*dp*ic*isc*ip*in* usb:v5041p2235d*dc*dsc*dp*ic*isc*ip*in* usb:v5041p2234d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3762d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3703d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3701d*dc*dsc*dp*ic*isc*ip*in* usb:v1915p2235d*dc*dsc*dp*ic*isc*ip*in* usb:v1915p2234d*dc*dsc*dp*ic*isc*ip*in* usb:v182Dp096Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1630p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v15A9p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0210d*dc*dsc*dp*ic*isc*ip*in* usb:v124Ap4026d*dc*dsc*dp*ic*isc*ip*in* usb:v124Ap4023d*dc*dsc*dp*ic*isc*ip*in* usb:v107Bp55F2d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6826d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0006d*dc*dsc*dp*ic*isc*ip*in* usb:v0BF8p1007d*dc*dsc*dp*ic*isc*ip*in* usb:v09AAp1000d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4220d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4210d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4200d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap5501d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4502d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4501d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp001Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0707pEE06d*dc*dsc*dp*ic*isc*ip*in* usb:v06B9p0120d*dc*dsc*dp*ic*isc*ip*in* usb:v0675p0530d*dc*dsc*dp*ic*isc*ip*in* usb:v0506p0A11d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00C2d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0050d*dc*dsc*dp*ic*isc*ip*in*
p54common mac80211

kernel/drivers/net/wireless/ralink/rt2x00/rt2800lib.ko.xz symbol:rt2800_mcu_request symbol:rt2800_wait_csr_ready symbol:rt2800_wait_wpdma_ready symbol:rt2800_disable_wpdma symbol:rt2800_get_txwi_rxwi_size symbol:rt2800_check_firmware symbol:rt2800_load_firmware symbol:rt2800_write_tx_data symbol:rt2800_process_rxwi symbol:rt2800_txdone_entry symbol:rt2800_txdone symbol:rt2800_txstatus_timeout symbol:rt2800_txstatus_pending symbol:rt2800_txdone_nostatus symbol:rt2800_watchdog symbol:rt2800_write_beacon symbol:rt2800_clear_beacon symbol:rt2800_rfkill_poll symbol:rt2800_config_shared_key symbol:rt2800_config_pairwise_key symbol:rt2800_sta_add symbol:rt2800_sta_remove symbol:rt2800_pre_reset_hw symbol:rt2800_config_filter symbol:rt2800_config_intf symbol:rt2800_config_erp symbol:rt2800_config_ant symbol:rt2800_gain_calibration symbol:rt2800_vco_calibration symbol:rt2800_config symbol:rt2800_link_stats symbol:rt2800_reset_tuner symbol:rt2800_link_tuner symbol:rt2800_enable_radio symbol:rt2800_disable_radio symbol:rt2800_efuse_detect symbol:rt2800_read_eeprom_efuse symbol:rt2800_probe_hw symbol:rt2800_get_key_seq symbol:rt2800_set_rts_threshold symbol:rt2800_conf_tx symbol:rt2800_get_tsf symbol:rt2800_ampdu_action symbol:rt2800_get_survey
crc_ccitt rt2x00lib mac80211

kernel/drivers/net/wireless/ralink/rt2x00/rt2x00lib.ko.xz symbol:rt2x00lib_get_bssidx symbol:rt2x00lib_beacondone symbol:rt2x00lib_pretbtt symbol:rt2x00lib_dmastart symbol:rt2x00lib_dmadone symbol:rt2x00lib_txdone_nomatch symbol:rt2x00lib_txdone symbol:rt2x00lib_txdone_noinfo symbol:rt2x00lib_rxdone symbol:rt2x00lib_set_mac_address symbol:rt2x00lib_probe_dev symbol:rt2x00lib_remove_dev symbol:rt2x00lib_suspend symbol:rt2x00lib_resume symbol:rt2x00mac_tx symbol:rt2x00mac_start symbol:rt2x00mac_stop symbol:rt2x00mac_reconfig_complete symbol:rt2x00mac_add_interface symbol:rt2x00mac_remove_interface symbol:rt2x00mac_config symbol:rt2x00mac_configure_filter symbol:rt2x00mac_set_tim symbol:rt2x00mac_set_key symbol:rt2x00mac_sw_scan_start symbol:rt2x00mac_sw_scan_complete symbol:rt2x00mac_get_stats symbol:rt2x00mac_bss_info_changed symbol:rt2x00mac_conf_tx symbol:rt2x00mac_rfkill_poll symbol:rt2x00mac_flush symbol:rt2x00mac_set_antenna symbol:rt2x00mac_get_antenna symbol:rt2x00mac_get_ringparam symbol:rt2x00mac_tx_frames_pending symbol:rt2x00queue_map_txskb symbol:rt2x00queue_unmap_skb symbol:rt2x00queue_for_each_entry symbol:rt2x00queue_get_entry symbol:rt2x00queue_pause_queue symbol:rt2x00queue_unpause_queue symbol:rt2x00queue_start_queue symbol:rt2x00queue_stop_queue symbol:rt2x00queue_flush_queue symbol:rt2x00queue_start_queues symbol:rt2x00queue_stop_queues symbol:rt2x00queue_flush_queues
mac80211 cfg80211 rfkill

kernel/drivers/net/wireless/ralink/rt2x00/rt2800usb.ko.xz usb:vF201p5370d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0254d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApF511d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApD522d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApC522d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA512d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0078d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p006Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0069d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0053d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p004Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p004Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p003Cd*dc*dsc*dp*ic*isc*ip*in* usb:v08B9p1197d*dc*dsc*dp*ic*isc*ip*in* usb:v18E8p6259d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB29d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB24d*dc*dsc*dp*ic*isc*ip*in* usb:v1D4Dp0010d*dc*dsc*dp*ic*isc*ip*in* usb:v05A6p0101d*dc*dsc*dp*ic*isc*ip*in* usb:v100Dp9032d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0169d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0168d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p0615d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p0605d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp094Bd*dc*dsc*dp*ic*isc*ip*in* usb:v148FpF101d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE036d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p800Cd*dc*dsc*dp*ic*isc*ip*in* usb:v15A9p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p0602d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p0600d*dc*dsc*dp*ic*isc*ip*in* usb:v203Dp14A1d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C0Bd*dc*dsc*dp*ic*isc*ip*in* usb:v18C5p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0042d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0041d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0150d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0148d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p012Ed*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp1003d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3401d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3400d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3399d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3340d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3322d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3284d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3262d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17A7d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1790d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1761d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1760d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p166Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0E0Bp9041d*dc*dsc*dp*ic*isc*ip*in* usb:v0E0Bp9031d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C11d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C08d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p3074d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p3073d*dc*dsc*dp*ic*isc*ip*in* usb:v20F4p724Ad*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp5572d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep7A13d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C21d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0253d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0241d*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp8501d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep7A32d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp5372d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp5370d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2182d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2181d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2180d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2126d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2104d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp23F6d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp1800d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp1801d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep7A42d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep7A22d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C23d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C22d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C20d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C19d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C15d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3365d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3329d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17E8d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep7A12d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3421d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p006Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p006Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0067d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3573d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pED19d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pED14d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9019d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9013d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9012d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p016Bd*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p003Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp094Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7733d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Fd*dc*dsc*dp*ic*isc*ip*in* usb:v148FpF301d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp1103d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17ADd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17BCd*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p7733d*dc*dsc*dp*ic*isc*ip*in* usb:v5A57p0284d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0A07d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0068d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0066d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0065d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0062d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0041d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3572d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0170d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0079d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p002Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0944d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9801d*dc*dsc*dp*ic*isc*ip*in* usb:v167Bp4001d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p179Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0764d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0761d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0744d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p3572d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0165d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0163d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0050d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp8070d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3370d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p20DDd*dc*dsc*dp*ic*isc*ip*in* usb:v083ApB512d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApB511d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C17d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp945Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0586p343Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0586p341Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0586p341Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3418d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3416d*dc*dsc*dp*ic*isc*ip*in* usb:v5A57p5257d*dc*dsc*dp*ic*isc*ip*in* usb:v5A57p0283d*dc*dsc*dp*ic*isc*ip*in* usb:v5A57p0282d*dc*dsc*dp*ic*isc*ip*in* usb:v5A57p0280d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0025d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp0022d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3013d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep300Ed*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp1163d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0324d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0323d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0313d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0302d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0164d*dc*dsc*dp*ic*isc*ip*in* usb:v177Fp0153d*dc*dsc*dp*ic*isc*ip*in* usb:v15A9p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApB522d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA703d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA702d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA701d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApA618d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap8522d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap7522d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap7512d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap7511d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap6618d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0060d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p005Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0051d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0048d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0047d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0042d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0040d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p003Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p003Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p003Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p003Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0039d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p002Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p002Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p002Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0017d*dc*dsc*dp*ic*isc*ip*in* usb:v129Bp1828d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p2018d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3072d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3071d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp3070d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2870d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2770d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2070d*dc*dsc*dp*ic*isc*ip*in* usb:v1A32p0304d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pED06d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB25d*dc*dsc*dp*ic*isc*ip*in* usb:v2019p5201d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p200Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1D4Dp0011d*dc*dsc*dp*ic*isc*ip*in* usb:v1D4Dp000Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1D4Dp000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1D4Dp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v20B8p8888d*dc*dsc*dp*ic*isc*ip*in* usb:v1B75pA200d*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p3072d*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p3071d*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p3070d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p899Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p871Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p871Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p871Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p870Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p822Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p822Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p822Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p821Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6899d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p3871d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p3870d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p3822d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p3821d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p3820d*dc*dsc*dp*ic*isc*ip*in* usb:v100Dp9031d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0166d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0164d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0163d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0162d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0078d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0077d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0071d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0070d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0031d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0948d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0947d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0945d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0017d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p000Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p800Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1044p800Bd*dc*dsc*dp*ic*isc*ip*in* usb:v15A9p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9709d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9708d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9707d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9706d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9705d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9703d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9702d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p9701d*dc*dsc*dp*ic*isc*ip*in* usb:v203Dp14A9d*dc*dsc*dp*ic*isc*ip*in* usb:v203Dp1480d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7722d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7718d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7717d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7711d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p4085d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pB307d*dc*dsc*dp*ic*isc*ip*in* usb:v07FAp7712d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C25d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C1Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3317d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C17d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C16d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C15d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C13d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C11d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C0Fd*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C0Ed*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C0Dd*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C0Ad*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C09d*dc*dsc*dp*ic*isc*ip*in* usb:v18C5p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp003Fd*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp003Cd*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp002Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p01FDd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p01A8d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p01EEd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p01A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p016Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p015Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0158d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00E8d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp935Bd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp935Ad*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp825Bd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp825Ad*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp815Cd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp805Cd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp8053d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3321d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3307d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3305d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3273d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3247d*dc*dsc*dp*ic*isc*ip*in* usb:v1761p0B05d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1784d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1742d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1732d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1731d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0740d*dc*dsc*dp*ic*isc*ip*in* usb:v15C5p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C2Cd*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C28d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C27d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C25d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C23d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C12d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C09d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C07d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C06d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p3072d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p3071d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p3070d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p2870d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p2770d*dc*dsc*dp*ic*isc*ip*in* usb:v8516p2070d*dc*dsc*dp*ic*isc*ip*in* usb:v1EDAp2310d*dc*dsc*dp*ic*isc*ip*in* usb:v1EDAp2210d*dc*dsc*dp*ic*isc*ip*in* usb:v1EDAp2012d*dc*dsc*dp*ic*isc*ip*in* usb:v1482p3C09d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p3072d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p3071d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p3070d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p2770d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p2870d*dc*dsc*dp*ic*isc*ip*in*
rt2x00usb rt2x00lib rt2800lib mac80211

kernel/drivers/net/wireless/ralink/rt2x00/rt2x00usb.ko.xz symbol:rt2x00usb_vendor_request symbol:rt2x00usb_vendor_req_buff_lock symbol:rt2x00usb_vendor_request_buff symbol:rt2x00usb_regbusy_read symbol:rt2x00usb_register_read_async symbol:rt2x00usb_kick_queue symbol:rt2x00usb_flush_queue symbol:rt2x00usb_watchdog symbol:rt2x00usb_disable_radio symbol:rt2x00usb_clear_entry symbol:rt2x00usb_initialize symbol:rt2x00usb_uninitialize symbol:rt2x00usb_probe symbol:rt2x00usb_disconnect symbol:rt2x00usb_suspend symbol:rt2x00usb_resume
rt2x00lib mac80211

kernel/drivers/net/wireless/ralink/rt2x00/rt2500usb.ko.xz usb:v5A57p0260d*dc*dsc*dp*ic*isc*ip*in* usb:v0F88p3012d*dc*dsc*dp*ic*isc*ip*in* usb:v0EB0p9020d*dc*dsc*dp*ic*isc*ip*in* usb:v0769p11F3d*dc*dsc*dp*ic*isc*ip*in* usb:v114Bp0110d*dc*dsc*dp*ic*isc*ip*in* usb:v0707pEE13d*dc*dsc*dp*ic*isc*ip*in* usb:v0681p3C06d*dc*dsc*dp*ic*isc*ip*in* usb:v079Bp004Bd*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp9020d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2570d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp1706d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6869d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6865d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6861d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0097d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p008Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0067d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0066d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p005Ed*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE000d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p8007d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C00d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C02d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p001Ad*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp7051d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp7050d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1707d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1706d*dc*dsc*dp*ic*isc*ip*in*
rt2x00usb rt2x00lib mac80211

kernel/drivers/net/wireless/ralink/rt2x00/rt73usb.ko.xz usb:v0586p3415d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp001Cd*dc*dsc*dp*ic*isc*ip*in* usb:v7167p3840d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB50d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB01d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p200Ad*dc*dsc*dp*ic*isc*ip*in* usb:v6933p5001d*dc*dsc*dp*ic*isc*ip*in* usb:v0769p31F3d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p9712d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p90ACd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p002Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0027d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0024d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p7100d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p4471d*dc*dsc*dp*ic*isc*ip*in* usb:v18E8p6238d*dc*dsc*dp*ic*isc*ip*in* usb:v18E8p6229d*dc*dsc*dp*ic*isc*ip*in* usb:v18E8p6196d*dc*dsc*dp*ic*isc*ip*in* usb:v0812p3101d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2671d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp2573d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp093Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p7318d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0pA874d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0pA861d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6874d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p6877d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p4600d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0028d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0023d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE020d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE010d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE002d*dc*dsc*dp*ic*isc*ip*in* usb:v1472p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p800Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1044p8008d*dc*dsc*dp*ic*isc*ip*in* usb:v15A9p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p3701d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7618d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7318d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C07d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C06d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C04d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C03d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp002Ed*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C22d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p9032d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p9022d*dc*dsc*dp*ic*isc*ip*in* usb:v178Dp02BEd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0137d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0119d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0116d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00F4d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00E6d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00D9d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00D8d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp0120d*dc*dsc*dp*ic*isc*ip*in* usb:v1631pC019d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp905Cd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp905Bd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp705Ad*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp7050d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1724d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1723d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0722d*dc*dsc*dp*ic*isc*ip*in* usb:v18C5p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0EB0p9021d*dc*dsc*dp*ic*isc*ip*in* usb:v148Fp9021d*dc*dsc*dp*ic*isc*ip*in* usb:v14B2p3C10d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB21Fd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB21Ed*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB21Dd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB21Cd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pB21Bd*dc*dsc*dp*ic*isc*ip*in*
rt2x00usb rt2x00lib mac80211

kernel/drivers/net/wireless/broadcom/brcm80211/brcmutil/brcmutil.ko.xz symbol:brcmu_pkt_buf_get_skb symbol:brcmu_pkt_buf_free_skb symbol:brcmu_pktq_penq symbol:brcmu_pktq_penq_head symbol:brcmu_pktq_pdeq symbol:brcmu_pktq_pdeq_match symbol:brcmu_pktq_pdeq_tail symbol:brcmu_pktq_pflush symbol:brcmu_pktq_flush symbol:brcmu_pktq_init symbol:brcmu_pktq_peek_tail symbol:brcmu_pktq_mlen symbol:brcmu_pktq_mdeq symbol:brcmu_boardrev_str symbol:brcmu_dotrev_str symbol:brcmu_prpkt symbol:brcmu_dbg_hex_dump symbol:brcmu_d11_attach

kernel/drivers/net/wireless/broadcom/brcm80211/brcmfmac/brcmfmac.ko.xz usb:v04B4p0BDCd*dc*dsc*dp*ic*isc*ip*in* usb:v0A5Cp0BDCd*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep3101d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4pBD29d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0039d*dc*dsc*dp*ic*isc*ip*in* usb:v0A5CpBD27d*dc*dsc*dp*ic*isc*ip*in* usb:v0A5CpBD1Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0A5CpBD17d*dc*dsc*dp*ic*isc*ip*in* usb:v0A5CpBD1Ed*dc*dsc*dp*ic*isc*ip*in* sdio:c*v04B4dBD3D* sdio:c*v02D0d4355* sdio:c*v02D0dAAE8* sdio:c*v02D0dA804* sdio:c*v02D0d4373* sdio:c*v02D0d4359* sdio:c*v02D0d4356* sdio:c*v02D0d4354* sdio:c*v02D0dA9BF* sdio:c*v02D0d4345* sdio:c*v02D0dA9AF* sdio:c*v02D0dA9A6* sdio:c*v02D0d4339* sdio:c*v02D0d4335* sdio:c*v02D0dA9A4* sdio:c*v02D0dA962* sdio:c*v02D0dA94D* sdio:c*v02D0dA94C* sdio:c*v02D0d4334* sdio:c*v02D0d4330* sdio:c*v02D0d4329* sdio:c*v02D0d4324* sdio:c*v02D0dA887* symbol:brcmf_set_wsec symbol:brcmf_fil_cmd_data_set symbol:brcmf_fil_cmd_data_get symbol:brcmf_fil_iovar_data_set symbol:brcmf_fil_iovar_data_get symbol:brcmf_fil_bsscfg_data_set symbol:brcmf_fil_bsscfg_data_get symbol:brcmf_fil_xtlv_data_set symbol:brcmf_fil_xtlv_data_get symbol:brcmf_fwvid_register_vendor symbol:brcmf_fwvid_unregister_vendor
brcmutil cfg80211

kernel/drivers/net/wireless/broadcom/brcm80211/brcmfmac/bca/brcmfmac-bca.ko.xz
brcmfmac

kernel/drivers/net/wireless/broadcom/brcm80211/brcmfmac/cyw/brcmfmac-cyw.ko.xz
brcmfmac

kernel/drivers/net/wireless/broadcom/brcm80211/brcmfmac/wcc/brcmfmac-wcc.ko.xz
brcmfmac

kernel/drivers/net/wireless/broadcom/b43legacy/b43legacy.ko.xz ssb:v4243id0812rev04* ssb:v4243id0812rev02*
cfg80211 ssb mac80211

kernel/drivers/net/wireless/broadcom/b43/b43.ko.xz ssb:v4243id0812rev10* ssb:v4243id0812rev0F* ssb:v4243id0812rev0D* ssb:v4243id0812rev0C* ssb:v4243id0812rev0B* ssb:v4243id0812rev0A* ssb:v4243id0812rev09* ssb:v4243id0812rev07* ssb:v4243id0812rev06* ssb:v4243id0812rev05* bcma:m04BFid0812rev2Acl* bcma:m04BFid0812rev28cl* bcma:m04BFid0812rev1Ecl* bcma:m04BFid0812rev1Dcl* bcma:m04BFid0812rev1Ccl* bcma:m04BFid0812rev18cl* bcma:m04BFid0812rev17cl* bcma:m04BFid0812rev15cl* bcma:m04BFid0812rev11cl*
cfg80211 mac80211 bcma ssb

kernel/drivers/net/wireless/zydas/zd1211rw/zd1211rw.ko.xz usb:v0ACEp20FFd*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp2011d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pED01d*dc*dsc*dp*ic*isc*ip*in* usb:v2019p5303d*dc*dsc*dp*ic*isc*ip*in* usb:v1582p6003d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep300Dd*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0024d*dc*dsc*dp*ic*isc*ip*in* usb:v129Bp1667d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0036d*dc*dsc*dp*ic*isc*ip*in* usb:v0CDEp001Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp0121d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p171Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEpB215d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1215d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApE506d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApE503d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApE501d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap4505d*dc*dsc*dp*ic*isc*ip*in* usb:v07FAp1196d*dc*dsc*dp*ic*isc*ip*in* usb:v079Bp0062d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3413d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3412d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3410d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p340Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0586p340Ad*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0257d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp705Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p1237d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p1236d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p00DAd*dc*dsc*dp*ic*isc*ip*in* usb:v0409p0248d*dc*dsc*dp*ic*isc*ip*in* usb:v0053p5301d*dc*dsc*dp*ic*isc*ip*in* usb:v6891pA727d*dc*dsc*dp*ic*isc*ip*in* usb:v1740p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3207d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep3204d*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep300Bd*dc*dsc*dp*ic*isc*ip*in* usb:v157Ep300Ad*dc*dsc*dp*ic*isc*ip*in* usb:v14EApAB13d*dc*dsc*dp*ic*isc*ip*in* usb:v14EApAB10d*dc*dsc*dp*ic*isc*ip*in* usb:v1435p0711d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p001Ed*dc*dsc*dp*ic*isc*ip*in* usb:v129Bp1666d*dc*dsc*dp*ic*isc*ip*in* usb:v126FpA006d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p9075d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p9071d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3Bp5630d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3Bp1630d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p170Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEpA211d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1211d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v079Bp004Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3409d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3407d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3402d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p3401d*dc*dsc*dp*ic*isc*ip*in* usb:v0105p145Fd*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211

kernel/drivers/net/wireless/realtek/rtlwifi/rtlwifi.ko.xz symbol:rtl_tid_to_ac symbol:rtl_deinit_deferred_work symbol:rtl_init_rfkill symbol:rtl_deinit_rfkill symbol:rtl_init_core symbol:rtl_deinit_core symbol:rtl_init_rx_config symbol:rtl_mrate_idx_to_arfr_id symbol:rtlwifi_rate_mapping symbol:rtl_get_tcb_desc symbol:rtl_tx_mgmt_proc symbol:rtl_action_proc symbol:rtl_is_special_data symbol:rtl_tx_ackqueue symbol:rtl_set_tx_report symbol:rtl_tx_report_handler symbol:rtl_get_hal_edca_param symbol:rtl_rx_ampdu_apply symbol:rtl_beacon_statistic symbol:rtl_collect_scan_list symbol:rtl_c2hcmd_enqueue symbol:rtl_send_smps_action symbol:rtl_phy_scan_operation_backup symbol:rtl_recognize_peer symbol:rtl_cam_add_one_entry symbol:rtl_cam_delete_one_entry symbol:rtl_cam_reset_all_entry symbol:rtl_cam_mark_invalid symbol:rtl_cam_empty_entry symbol:rtl_cam_get_free_entry symbol:rtl_cam_del_entry symbol:channel5g symbol:channel5g_80m symbol:rtl_addr_delay symbol:rtl_rfreg_delay symbol:rtl_bb_delay symbol:rtl_fw_cb symbol:rtl_wowlan_fw_cb symbol:rtl_update_beacon_work_callback symbol:rtl_hal_pwrseqcmdparsing symbol:rtl_cmd_send_packet symbol:rtl_init_sw_leds symbol:rtl_ops symbol:rtl_btc_status_false symbol:rtl_dm_diginit symbol:_rtl_dbg_print symbol:_rtl_dbg_print_data symbol:rtl_debug_add_one symbol:rtl_debug_remove_one symbol:efuse_read_1byte symbol:read_efuse_byte symbol:efuse_shadow_read symbol:rtl_efuse_shadow_map_update symbol:efuse_one_byte_read symbol:efuse_power_switch symbol:rtl_get_hwinfo symbol:rtl_fw_block_write symbol:rtl_fw_page_write symbol:rtl_fill_dummy symbol:rtl_efuse_ops_init symbol:rtl_ps_enable_nic symbol:rtl_ps_disable_nic symbol:rtl_ips_nic_on symbol:rtl_swlps_beacon symbol:rtl_lps_change_work_callback symbol:rtl_lps_enter symbol:rtl_lps_leave symbol:rtl_p2p_info symbol:rtl_query_rxpwrpercentage symbol:rtl_evm_db_to_percentage symbol:rtl_signal_scale_mapping symbol:rtl_process_phyinfo
mac80211 cfg80211 rfkill

kernel/drivers/net/wireless/realtek/rtlwifi/rtl8192c/rtl8192c-common.ko.xz symbol:dm_restorepowerindex symbol:dm_writepowerindex symbol:dm_savepowerindex symbol:rtl92c_dm_write_dig symbol:rtl92c_dm_init_edca_turbo symbol:rtl92c_dm_check_txpower_tracking symbol:rtl92c_dm_init_rate_adaptive_mask symbol:rtl92c_dm_rf_saving symbol:rtl92c_dm_init symbol:rtl92c_dm_watchdog symbol:rtl92c_bt_rssi_state_change symbol:rtl92c_dm_bt_coexist symbol:rtl92c_download_fw symbol:rtl92c_fill_h2c_cmd symbol:rtl92c_firmware_selfreset symbol:rtl92c_set_fw_pwrmode_cmd symbol:rtl92c_set_fw_rsvdpagepkt symbol:rtl92c_set_fw_joinbss_report_cmd symbol:rtl92c_set_p2p_ps_offload_cmd symbol:rtl92c_phy_query_bb_reg symbol:rtl92c_phy_set_bb_reg symbol:_rtl92c_phy_fw_rf_serial_read symbol:_rtl92c_phy_fw_rf_serial_write symbol:_rtl92c_phy_rf_serial_read symbol:_rtl92c_phy_rf_serial_write symbol:rtl92c_phy_rf_config symbol:_rtl92c_phy_bb8192c_config_parafile symbol:_rtl92c_store_pwrindex_diffrate_offset symbol:_rtl92c_phy_init_bb_rf_register_definition symbol:rtl92c_phy_set_txpower_level symbol:rtl92c_phy_update_txpower_dbm symbol:_rtl92c_phy_dbm_to_txpwr_idx symbol:_rtl92c_phy_txpwr_idx_to_dbm symbol:rtl92c_phy_set_bw_mode symbol:rtl92c_phy_sw_chnl_callback symbol:rtl92c_phy_sw_chnl symbol:rtl8192_phy_check_is_legal_rfpath symbol:rtl92c_phy_iq_calibrate symbol:rtl92c_phy_lc_calibrate symbol:rtl92c_phy_ap_calibrate symbol:rtl92c_phy_set_rfpath_switch symbol:rtl92c_phy_set_io_cmd symbol:rtl92c_phy_set_io symbol:rtl92ce_phy_set_rf_on symbol:_rtl92c_phy_set_rf_sleep
rtlwifi

kernel/drivers/net/wireless/realtek/rtlwifi/rtl8192cu/rtl8192cu.ko.xz usb:v7392p7822d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v20F4p624Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB2Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p330Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p330Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3309d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3307d*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p0019d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0061d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8186d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17ABd*dc*dsc*dp*ic*isc*ip*in* usb:v0846pF001d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9021d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p8178d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0056d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p341Fd*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp2103d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp2102d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp1004d*dc*dsc*dp*ic*isc*ip*in* usb:v2019p1201d*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFFCd*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFFBd*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFF8d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9042d*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFFAd*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFF9d*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFF7d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp317Fd*dc*dsc*dp*ic*isc*ip*in* usb:v9846p9041d*dc*dsc*dp*ic*isc*ip*in* usb:v4855p0091d*dc*dsc*dp*ic*isc*ip*in* usb:v4855p0090d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3359d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3358d*dc*dsc*dp*ic*isc*ip*in* usb:v7392p7811d*dc*dsc*dp*ic*isc*ip*in* usb:v20F4p648Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2019pED17d*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB2Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2019pAB2Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2019p4902d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3308d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3357d*dc*dsc*dp*ic*isc*ip*in* usb:v103Cp1629d*dc*dsc*dp*ic*isc*ip*in* usb:v4856p0091d*dc*dsc*dp*ic*isc*ip*in* usb:v0EB0p9071d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0077d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0070d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p005Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0052d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp5088d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17BAd*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9043d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p9041d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p8189d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8pE033d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp11F2d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp1102d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8178d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8754d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp819Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp818Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp817Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8177d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8176d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8170d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp018Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8191d*dc*dsc*dp*ic*isc*ip*in*
rtlwifi rtl8192c_common rtl_usb mac80211

kernel/drivers/net/wireless/realtek/rtlwifi/rtl_usb.ko.xz symbol:rtl_usb_probe symbol:rtl_usb_disconnect symbol:rtl_usb_suspend symbol:rtl_usb_resume
rtlwifi mac80211

kernel/drivers/net/wireless/realtek/rtl8xxxu/rtl8xxxu.ko.xz usb:v2001p3328d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0135d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp318Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pB722d*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p18F1d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApF192d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp2005d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB711d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApFFEFd*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pB811d*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p18F0d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C4Ep0102d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0111d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p010Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v056Ep4008d*dc*dsc*dp*icFFiscFFipFFin* usb:v07B8p8179d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p331Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p3310d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p330Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p3311d*dc*dsc*dp*icFFiscFFipFFin* usb:v0DF6p0076d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp0179d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp8179d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApF179d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pA611d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB720d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0109d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p3319d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0108d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp818Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp0724d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp1724d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp8724d*dc*dsc*dp*icFFiscFFipFFin*
mac80211 cfg80211

kernel/drivers/net/wireless/realtek/rtw88/rtw88_usb.ko.xz symbol:rtw_usb_probe symbol:rtw_usb_disconnect
rtw88_core mac80211

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8723x.ko.xz symbol:rtw8723x_common
rtw88_core

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8723de.ko.xz pci:v000010ECd0000D723sv*sd*bc*sc*i*
rtw88_pci rtw88_8723d

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822ce.ko.xz pci:v000010ECd0000C82Fsv*sd*bc*sc*i* pci:v000010ECd0000C822sv*sd*bc*sc*i*
rtw88_pci rtw88_8822c

kernel/drivers/net/wireless/realtek/rtw88/rtw88_core.ko.xz symbol:rtw_disable_lps_deep_mode symbol:rtw_debug_mask symbol:rtw_dump_fw symbol:rtw_dump_reg symbol:rtw_set_rx_freq_band symbol:rtw_chip_info_setup symbol:rtw_core_init symbol:rtw_core_deinit symbol:rtw_register_hw symbol:rtw_unregister_hw symbol:rtw_ops symbol:check_hw_ready symbol:rtw_restore_reg symbol:rtw_tx_fill_tx_desc symbol:rtw_tx_report_enqueue symbol:rtw_tx_write_data_rsvd_page_get symbol:rtw_tx_write_data_h2c_get symbol:rtw_tx_ac_to_hwq symbol:rtw_tx_queue_mapping symbol:rtw_rx_stats symbol:rtw_update_rx_freq_from_ie symbol:rtw_rx_fill_rx_status symbol:rtw_set_channel_mac symbol:rtw_write_firmware_page symbol:rtw_rate_section symbol:rtw_rate_size symbol:rtw_phy_set_edcca_th symbol:rtw_phy_init symbol:rtw_phy_parsing_cfo symbol:rtw_phy_rf_power_2_rssi symbol:rtw_phy_read_rf symbol:rtw_phy_read_rf_sipi symbol:rtw_phy_write_rf_reg_sipi symbol:rtw_phy_write_rf_reg_mix symbol:rtw_parse_tbl_phy_cond symbol:rtw_parse_tbl_bb_pg symbol:rtw_parse_tbl_txpwr_lmt symbol:rtw_phy_cfg_mac symbol:rtw_phy_cfg_agc symbol:rtw_phy_cfg_bb symbol:rtw_phy_cfg_rf symbol:rtw_phy_load_tables symbol:rtw_phy_get_tx_power_index symbol:rtw_phy_set_tx_power_level symbol:rtw_phy_config_swing_table symbol:rtw_phy_pwrtrack_avg symbol:rtw_phy_pwrtrack_thermal_changed symbol:rtw_phy_pwrtrack_get_delta symbol:rtw_phy_pwrtrack_get_pwridx symbol:rtw_phy_pwrtrack_need_lck symbol:rtw_phy_pwrtrack_need_iqk symbol:rtw_coex_write_scbd symbol:rtw_coex_read_indirect_reg symbol:rtw_coex_write_indirect_reg symbol:rtw_read8_physical_efuse symbol:rtw_fw_c2h_cmd_rx_irqsafe symbol:rtw_fw_c2h_cmd_isr symbol:rtw_fw_do_iqk symbol:rtw_fw_inform_rfk_status symbol:rtw_power_mode_change symbol:rtw_bf_enable_bfee_su symbol:rtw_bf_enable_bfee_mu symbol:rtw_bf_remove_bfee_su symbol:rtw_bf_remove_bfee_mu symbol:rtw_bf_set_gid_table symbol:rtw_bf_phy_init symbol:rtw_bf_cfg_csi_rate symbol:rtw_regd_get symbol:rtw_regd_srrc
mac80211 cfg80211

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8723du.ko.xz usb:v7392pD611d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApD723d*dc*dsc*dp*icFFiscFFipFFin*
rtw88_usb rtw88_8723d

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8821cu.ko.xz usb:v7392pD811d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pC811d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p331Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC82Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC82Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC821d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC820d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC811d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC80Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB82Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB820d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp8811d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp8731d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp2006d*dc*dsc*dp*icFFiscFFipFFin*
rtw88_usb rtw88_8821c

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822c.ko.xz symbol:rtw8822c_hw_spec
rtw88_core

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8723d.ko.xz symbol:rtw8723d_hw_spec
rtw88_core rtw88_8723x

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822bu.ko.xz usb:v20F4p808Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v04CAp8602d*dc*dsc*dp*icFFiscFFipFFin* usb:v0E66p0025d*dc*dsc*dp*icFFiscFFipFFin* usb:v0846p9055d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0117d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0116d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p012Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0115d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p0138d*dc*dsc*dp*icFFiscFFipFFin* usb:v2357p012Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v13B1p0045d*dc*dsc*dp*icFFiscFFipFFin* usb:v13B1p0043d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p331Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p331Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p331Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p1874d*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p1870d*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p19AAd*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p184Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v0B05p1841d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB81Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pF822d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pE822d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pD822d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pC822d*dc*dsc*dp*icFFiscFFipFFin* usb:v7392pB822d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDAp2102d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB82Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApB812d*dc*dsc*dp*icFFiscFFipFFin*
rtw88_usb rtw88_8822b

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822be.ko.xz pci:v000010ECd0000B822sv*sd*bc*sc*i*
rtw88_pci rtw88_8822b

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822cu.ko.xz usb:v2001p3329d*dc*dsc*dp*icFFiscFFipFFin* usb:v13B1p0043d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApD82Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApD820d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC82Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC812d*dc*dsc*dp*icFFiscFFipFFin* usb:v0BDApC82Cd*dc*dsc*dp*icFFiscFFipFFin*
rtw88_usb rtw88_8822c

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8821ce.ko.xz pci:v000010ECd0000C821sv*sd*bc*sc*i* pci:v000010ECd0000B821sv*sd*bc*sc*i*
rtw88_pci rtw88_8821c

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8821c.ko.xz symbol:rtw8821c_hw_spec
rtw88_core

kernel/drivers/net/wireless/realtek/rtw88/rtw88_pci.ko.xz symbol:rtw_pm_ops symbol:rtw_pci_probe symbol:rtw_pci_remove symbol:rtw_pci_shutdown
rtw88_core mac80211

kernel/drivers/net/wireless/realtek/rtw88/rtw88_8822b.ko.xz symbol:rtw8822b_hw_spec
rtw88_core

kernel/drivers/net/wireless/realtek/rtl818x/rtl8187/rtl8187.ko.xz usb:v1737p0073d*dc*dsc*dp*ic*isc*ip*in* usb:v1B75p8187d*dc*dsc*dp*ic*isc*ip*in* usb:v18E8p6232d*dc*dsc*dp*ic*isc*ip*in* usb:v13D1pABE6d*dc*dsc*dp*ic*isc*ip*in* usb:v1371p9401d*dc*dsc*dp*ic*isc*ip*in* usb:v114Bp0150d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0029d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0028d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0pCA02d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p4260d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p6A00d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p6100d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p010Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0769p11F2d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8198d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8197d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8189d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8187d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp705Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p171Dd*dc*dsc*dp*ic*isc*ip*in*
mac80211 rfkill eeprom_93cx6 cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852a.ko.xz symbol:rtw8852a_chip_info
rtw89_core cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852ce.ko.xz pci:v000010ECd0000C852sv*sd*bc*sc*i*
rtw89_8852c rtw89_pci

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852be.ko.xz pci:v000010ECd0000B85Bsv*sd*bc*sc*i* pci:v000010ECd0000B852sv*sd*bc*sc*i*
rtw89_pci rtw89_8852b

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852b_common.ko.xz symbol:rtw8852bx_info
rtw89_core cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852b.ko.xz symbol:rtw8852b_chip_info
rtw89_core rtw89_8852b_common

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852bt.ko.xz symbol:rtw8852bt_chip_info
rtw89_core rtw89_8852b_common

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8851be.ko.xz pci:v000010ECd0000B851sv*sd*bc*sc*i*
rtw89_pci rtw89_8851b

kernel/drivers/net/wireless/realtek/rtw89/rtw89_core.ko.xz symbol:rtw89_core_fill_txdesc symbol:rtw89_core_fill_txdesc_v1 symbol:rtw89_core_fill_txdesc_v2 symbol:rtw89_core_fill_txdesc_fwcmd_v1 symbol:rtw89_core_fill_txdesc_fwcmd_v2 symbol:rtw89_core_query_rxdesc symbol:rtw89_core_query_rxdesc_v2 symbol:rtw89_core_rx symbol:rtw89_core_napi_start symbol:rtw89_core_napi_stop symbol:rtw89_core_napi_init symbol:rtw89_core_napi_deinit symbol:rtw89_check_quirks symbol:rtw89_core_init symbol:rtw89_core_deinit symbol:rtw89_chip_info_setup symbol:rtw89_core_register symbol:rtw89_core_unregister symbol:rtw89_alloc_ieee80211_hw symbol:rtw89_free_ieee80211_hw symbol:rtw89_ops symbol:rtw89_mac_get_err_status symbol:rtw89_mac_set_err_status symbol:rtw89_mac_size symbol:rtw89_mac_stop_sch_tx symbol:rtw89_mac_stop_sch_tx_v1 symbol:rtw89_mac_resume_sch_tx symbol:rtw89_mac_resume_sch_tx_v1 symbol:rtw89_mac_enable_bb_rf symbol:rtw89_mac_disable_bb_rf symbol:rtw89_mac_coex_init symbol:rtw89_mac_coex_init_v1 symbol:rtw89_mac_cfg_gnt symbol:rtw89_mac_cfg_gnt_v1 symbol:rtw89_mac_cfg_ctrl_path symbol:rtw89_mac_cfg_ctrl_path_v1 symbol:rtw89_mac_gen_ax symbol:rtw89_mac_cfg_gnt_v2 symbol:rtw89_mac_cfg_ctrl_path_v2 symbol:rtw89_mac_stop_sch_tx_v2 symbol:rtw89_mac_resume_sch_tx_v2 symbol:rtw89_mac_gen_be symbol:rtw89_phy_get_txsc symbol:rtw89_phy_get_txsb symbol:rtw89_phy_read_rf symbol:rtw89_phy_read_rf_v1 symbol:rtw89_phy_read_rf_v2 symbol:rtw89_phy_write_rf symbol:rtw89_phy_write_rf_v1 symbol:rtw89_phy_write_rf_v2 symbol:rtw89_phy_config_rf_reg_v1 symbol:rtw89_phy_write32_idx symbol:rtw89_phy_read32_idx symbol:rtw89_phy_set_phy_regs symbol:rtw89_phy_write_reg3_tbl symbol:rtw89_phy_load_txpwr_byrate symbol:rtw89_phy_read_txpwr_limit symbol:rtw89_phy_rfk_pre_ntfy_and_wait symbol:rtw89_phy_rfk_tssi_and_wait symbol:rtw89_phy_rfk_iqk_and_wait symbol:rtw89_phy_rfk_dpk_and_wait symbol:rtw89_phy_rfk_txgapk_and_wait symbol:rtw89_phy_rfk_dack_and_wait symbol:rtw89_phy_rfk_rxdck_and_wait symbol:rtw89_rfk_chan_lookup symbol:rtw89_rfk_parser symbol:rtw89_phy_tssi_ctrl_set_bandedge_cfg symbol:rtw89_encode_chan_idx symbol:rtw89_decode_chan_idx symbol:rtw89_phy_get_kpath symbol:rtw89_phy_get_syn_sel symbol:rtw89_phy_gen_ax symbol:rtw89_phy_gen_be symbol:rtw89_fw_blacklist_default symbol:rtw89_fw_h2c_dctl_sec_cam_v1 symbol:rtw89_fw_h2c_dctl_sec_cam_v2 symbol:rtw89_fw_h2c_default_dmac_tbl_v2 symbol:rtw89_fw_h2c_ba_cam symbol:rtw89_fw_h2c_ba_cam_v1 symbol:rtw89_fw_h2c_default_cmac_tbl symbol:rtw89_fw_h2c_default_cmac_tbl_g7 symbol:rtw89_fw_h2c_assoc_cmac_tbl symbol:rtw89_fw_h2c_assoc_cmac_tbl_g7 symbol:rtw89_fw_h2c_ampdu_cmac_tbl_g7 symbol:rtw89_fw_h2c_update_beacon symbol:rtw89_fw_h2c_update_beacon_be symbol:rtw89_fw_h2c_rf_ntfy_mcc symbol:rtw89_read_efuse_ver symbol:rtw89_efuse_read_fw_secure_be symbol:rtw89_btc_set_policy symbol:rtw89_btc_set_policy_v1 symbol:rtw89_btc_ntfy_wl_rfk symbol:__rtw89_mgnt_chan_get symbol:rtw89_ser_notify symbol:rtw89_linear_2_db symbol:rtw89_db_2_linear
mac80211 cfg80211 rfkill

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8922a.ko.xz symbol:rtw8922a_chip_info
rtw89_core cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852ae.ko.xz pci:v000010ECd0000A85Asv*sd*bc*sc*i* pci:v000010ECd00008852sv*sd*bc*sc*i*
rtw89_pci rtw89_8852a

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852c.ko.xz symbol:rtw8852c_chip_info
rtw89_core cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_pci.ko.xz symbol:rtw89_pci_recognize_intrs symbol:rtw89_pci_recognize_intrs_v1 symbol:rtw89_pci_recognize_intrs_v2 symbol:rtw89_pci_enable_intr symbol:rtw89_pci_disable_intr symbol:rtw89_pci_enable_intr_v1 symbol:rtw89_pci_disable_intr_v1 symbol:rtw89_pci_enable_intr_v2 symbol:rtw89_pci_disable_intr_v2 symbol:rtw89_pci_ch_dma_addr_set symbol:rtw89_pci_ch_dma_addr_set_v1 symbol:rtw89_pci_ch_dma_addr_set_be symbol:rtw89_pci_fill_txaddr_info symbol:rtw89_pci_fill_txaddr_info_v1 symbol:rtw89_bd_ram_table_dual symbol:rtw89_bd_ram_table_single symbol:rtw89_pci_ltr_set symbol:rtw89_pci_ltr_set_v1 symbol:rtw89_pci_config_intr_mask symbol:rtw89_pci_config_intr_mask_v1 symbol:rtw89_pci_config_intr_mask_v2 symbol:rtw89_pm_ops symbol:rtw89_pci_gen_ax symbol:rtw89_pci_probe symbol:rtw89_pci_remove symbol:rtw89_pci_ltr_set_v2 symbol:rtw89_pm_ops_be symbol:rtw89_pci_gen_be
rtw89_core mac80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8852bte.ko.xz pci:v000010ECd0000B520sv*sd*bc*sc*i*
rtw89_pci rtw89_8852bt

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8851b.ko.xz symbol:rtw8851b_chip_info
rtw89_core cfg80211

kernel/drivers/net/wireless/realtek/rtw89/rtw89_8922ae.ko.xz pci:v000010ECd00008922sv*sd*bc*sc*i*
rtw89_pci rtw89_8922a

kernel/drivers/net/macvlan.ko.xz rtnl_link_macvlan symbol:macvlan_common_setup symbol:macvlan_common_newlink symbol:macvlan_dellink symbol:macvlan_link_register

kernel/drivers/net/vxlan/vxlan.ko.xz rtnl_link_vxlan symbol:vxlan_fdb_find_uc symbol:vxlan_fdb_replay symbol:vxlan_fdb_clear_offload symbol:vxlan_dev_create
udp_tunnel ip6_udp_tunnel

kernel/drivers/net/slip/slhc.ko.xz symbol:slhc_init symbol:slhc_free symbol:slhc_remember symbol:slhc_compress symbol:slhc_uncompress symbol:slhc_toss

kernel/drivers/net/slip/slip.ko.xz tty_ldisc_1
slhc

kernel/drivers/net/vsockmon.ko.xz rtnl_link_vsockmon
vsock

kernel/drivers/net/bonding/bonding.ko.xz rtnl_link_bond
ipv6

kernel/drivers/net/can/vcan.ko.xz rtnl_link_vcan
can_dev

kernel/drivers/net/can/slcan/slcan.ko.xz tty_ldisc_17
can_dev

kernel/drivers/net/can/dev/can-dev.ko.xz rtnl_link_can symbol:can_put_echo_skb symbol:can_get_echo_skb symbol:can_free_echo_skb symbol:alloc_can_skb symbol:alloc_canfd_skb symbol:alloc_canxl_skb symbol:alloc_can_err_skb symbol:can_dropped_invalid_skb symbol:can_get_state_str symbol:can_state_get_by_berr_counter symbol:can_change_state symbol:can_bus_off symbol:alloc_candev_mqs symbol:free_candev symbol:can_change_mtu symbol:can_eth_ioctl_hwts symbol:can_ethtool_op_get_ts_info_hwts symbol:open_candev symbol:of_can_transceiver symbol:close_candev symbol:register_candev symbol:unregister_candev symbol:safe_candev_priv symbol:can_fd_dlc2len symbol:can_fd_len2dlc symbol:can_skb_get_frame_len symbol:can_rx_offload_irq_offload_timestamp symbol:can_rx_offload_irq_offload_fifo symbol:can_rx_offload_queue_timestamp symbol:can_rx_offload_get_echo_skb_queue_timestamp symbol:can_rx_offload_queue_tail symbol:can_rx_offload_get_echo_skb_queue_tail symbol:can_rx_offload_irq_finish symbol:can_rx_offload_threaded_irq_finish symbol:can_rx_offload_add_timestamp symbol:can_rx_offload_add_fifo symbol:can_rx_offload_add_manual symbol:can_rx_offload_enable symbol:can_rx_offload_del

kernel/drivers/net/can/spi/mcp251xfd/mcp251xfd.ko.xz spi:mcp251xfd spi:mcp251863 spi:mcp2518fd spi:mcp2517fd of:N*T*Cmicrochip,mcp251xfdC* of:N*T*Cmicrochip,mcp251xfd of:N*T*Cmicrochip,mcp251863C* of:N*T*Cmicrochip,mcp251863 of:N*T*Cmicrochip,mcp2518fdC* of:N*T*Cmicrochip,mcp2518fd of:N*T*Cmicrochip,mcp2517fdC* of:N*T*Cmicrochip,mcp2517fd
can_dev

kernel/drivers/net/can/spi/mcp251x.ko.xz of:N*T*Cmicrochip,mcp25625C* of:N*T*Cmicrochip,mcp25625 of:N*T*Cmicrochip,mcp2515C* of:N*T*Cmicrochip,mcp2515 of:N*T*Cmicrochip,mcp2510C* of:N*T*Cmicrochip,mcp2510 spi:mcp25625 spi:mcp2515 spi:mcp2510
can_dev

kernel/drivers/net/can/usb/ems_usb.ko.xz usb:v12D6p0444d*dc*dsc*dp*ic*isc*ip*in*
can_dev

kernel/drivers/net/can/usb/usb_8dev.ko.xz usb:v0483p1234d*dc*dsc*dp*ic*isc*ip*in*
can_dev

kernel/drivers/net/can/usb/peak_usb/peak_usb.ko.xz usb:v0C72p0014d*dc*dsc*dp*ic*isc*ip*in* usb:v0C72p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v0C72p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v0C72p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v0C72p000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0C72p000Cd*dc*dsc*dp*ic*isc*ip*in*
can_dev

kernel/drivers/net/can/usb/gs_usb.ko.xz usb:v16D0p0F30d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D0p10B8d*dc*dsc*dp*ic*isc*ip*in00* usb:v1CD2p606Fd*dc*dsc*dp*ic*isc*ip*in00* usb:v1209p2323d*dc*dsc*dp*ic*isc*ip*in00* usb:v1D50p606Fd*dc*dsc*dp*ic*isc*ip*in00*
can_dev

kernel/drivers/net/macvtap.ko.xz rtnl_link_macvtap
tap macvlan

kernel/drivers/net/hamradio/yam.ko.xz
ax25

kernel/drivers/net/hamradio/baycom_ser_fdx.ko.xz
hdlcdrv

kernel/drivers/net/hamradio/mkiss.ko.xz tty_ldisc_5
ax25

kernel/drivers/net/hamradio/bpqether.ko.xz
ax25

kernel/drivers/net/hamradio/hdlcdrv.ko.xz symbol:hdlcdrv_receiver symbol:hdlcdrv_transmitter symbol:hdlcdrv_arbitrate symbol:hdlcdrv_register symbol:hdlcdrv_unregister
ax25 crc_ccitt

kernel/drivers/net/hamradio/6pack.ko.xz tty_ldisc_7
ax25

kernel/drivers/net/hamradio/baycom_ser_hdx.ko.xz
hdlcdrv

kernel/drivers/net/tun.ko.xz devname:net/tun char_major_10_200 symbol:tun_ptr_free symbol:tun_get_socket symbol:tun_get_tx_ring

kernel/drivers/net/ethernet/vertexcom/mse102x.ko.xz spi:mse102x of:N*T*Cvertexcom,mse1022C* of:N*T*Cvertexcom,mse1022 of:N*T*Cvertexcom,mse1021C* of:N*T*Cvertexcom,mse1021 spi:mse1022 spi:mse1021

kernel/drivers/net/ethernet/microchip/lan743x.ko.xz pci:v00001055d0000A041sv*sd*bc*sc*i* pci:v00001055d0000A011sv*sd*bc*sc*i* pci:v00001055d00007431sv*sd*bc*sc*i* pci:v00001055d00007430sv*sd*bc*sc*i*

kernel/drivers/net/ethernet/microchip/enc28j60.ko.xz spi:enc28j60 of:N*T*Cmicrochip,enc28j60C* of:N*T*Cmicrochip,enc28j60

kernel/drivers/net/ethernet/wiznet/w5100.ko.xz platform:w5100 symbol:w5100_ops_priv symbol:w5100_probe symbol:w5100_remove symbol:w5100_pm_ops

kernel/drivers/net/ethernet/wiznet/w5100-spi.ko.xz of:N*T*Cwiznet,w5500C* of:N*T*Cwiznet,w5500 of:N*T*Cwiznet,w5200C* of:N*T*Cwiznet,w5200 of:N*T*Cwiznet,w5100C* of:N*T*Cwiznet,w5100 spi:w5500 spi:w5200 spi:w5100
w5100

kernel/drivers/net/ethernet/intel/i40e/i40e.ko.xz pci:v00008086d0000158Bsv*sd*bc*sc*i* pci:v00008086d0000158Asv*sd*bc*sc*i* pci:v00008086d00000D58sv*sd*bc*sc*i* pci:v00008086d00000CF8sv*sd*bc*sc*i* pci:v00008086d00001588sv*sd*bc*sc*i* pci:v00008086d00001587sv*sd*bc*sc*i* pci:v00008086d00000DDAsv*sd*bc*sc*i* pci:v00008086d000037D3sv*sd*bc*sc*i* pci:v00008086d000037D2sv*sd*bc*sc*i* pci:v00008086d000037D1sv*sd*bc*sc*i* pci:v00008086d000037D0sv*sd*bc*sc*i* pci:v00008086d000037CFsv*sd*bc*sc*i* pci:v00008086d000037CEsv*sd*bc*sc*i* pci:v00008086d0000104Fsv*sd*bc*sc*i* pci:v00008086d0000104Esv*sd*bc*sc*i* pci:v00008086d000015FFsv*sd*bc*sc*i* pci:v00008086d00001589sv*sd*bc*sc*i* pci:v00008086d00001586sv*sd*bc*sc*i* pci:v00008086d00000DD2sv*sd*bc*sc*i* pci:v00008086d00001585sv*sd*bc*sc*i* pci:v00008086d00001584sv*sd*bc*sc*i* pci:v00008086d00001583sv*sd*bc*sc*i* pci:v00008086d00001581sv*sd*bc*sc*i* pci:v00008086d00001580sv*sd*bc*sc*i* pci:v00008086d00001574sv*sd*bc*sc*i* pci:v00008086d00001572sv*sd*bc*sc*i* symbol:i40e_client_device_register symbol:i40e_client_device_unregister
libie

kernel/drivers/net/ethernet/intel/igb/igb.ko.xz pci:v00008086d000010D6sv*sd*bc*sc*i* pci:v00008086d000010A9sv*sd*bc*sc*i* pci:v00008086d000010A7sv*sd*bc*sc*i* pci:v00008086d000010E8sv*sd*bc*sc*i* pci:v00008086d00001526sv*sd*bc*sc*i* pci:v00008086d0000150Dsv*sd*bc*sc*i* pci:v00008086d000010E7sv*sd*bc*sc*i* pci:v00008086d000010E6sv*sd*bc*sc*i* pci:v00008086d00001518sv*sd*bc*sc*i* pci:v00008086d0000150Asv*sd*bc*sc*i* pci:v00008086d000010C9sv*sd*bc*sc*i* pci:v00008086d00000440sv*sd*bc*sc*i* pci:v00008086d0000043Csv*sd*bc*sc*i* pci:v00008086d0000043Asv*sd*bc*sc*i* pci:v00008086d00000438sv*sd*bc*sc*i* pci:v00008086d00001516sv*sd*bc*sc*i* pci:v00008086d00001511sv*sd*bc*sc*i* pci:v00008086d00001510sv*sd*bc*sc*i* pci:v00008086d00001527sv*sd*bc*sc*i* pci:v00008086d0000150Fsv*sd*bc*sc*i* pci:v00008086d0000150Esv*sd*bc*sc*i* pci:v00008086d00001524sv*sd*bc*sc*i* pci:v00008086d00001523sv*sd*bc*sc*i* pci:v00008086d00001522sv*sd*bc*sc*i* pci:v00008086d00001521sv*sd*bc*sc*i* pci:v00008086d0000157Csv*sd*bc*sc*i* pci:v00008086d0000157Bsv*sd*bc*sc*i* pci:v00008086d00001538sv*sd*bc*sc*i* pci:v00008086d00001537sv*sd*bc*sc*i* pci:v00008086d00001536sv*sd*bc*sc*i* pci:v00008086d00001533sv*sd*bc*sc*i* pci:v00008086d00001539sv*sd*bc*sc*i* pci:v00008086d00001F45sv*sd*bc*sc*i* pci:v00008086d00001F41sv*sd*bc*sc*i* pci:v00008086d00001F40sv*sd*bc*sc*i*
i2c_algo_bit

kernel/drivers/net/ethernet/intel/libeth/libeth.ko.xz symbol:libeth_rx_fq_create symbol:libeth_rx_fq_destroy symbol:libeth_rx_recycle_slow symbol:libeth_rx_pt_gen_hash_type

kernel/drivers/net/ethernet/intel/ixgbe/ixgbe.ko.xz pci:v00008086d000015E5sv*sd*bc*sc*i* pci:v00008086d000015E4sv*sd*bc*sc*i* pci:v00008086d000015CEsv*sd*bc*sc*i* pci:v00008086d000015C8sv*sd*bc*sc*i* pci:v00008086d000015C7sv*sd*bc*sc*i* pci:v00008086d000015C6sv*sd*bc*sc*i* pci:v00008086d000015C4sv*sd*bc*sc*i* pci:v00008086d000015C3sv*sd*bc*sc*i* pci:v00008086d000015C2sv*sd*bc*sc*i* pci:v00008086d000015AEsv*sd*bc*sc*i* pci:v00008086d000015ACsv*sd*bc*sc*i* pci:v00008086d000015ADsv*sd*bc*sc*i* pci:v00008086d000015ABsv*sd*bc*sc*i* pci:v00008086d000015B0sv*sd*bc*sc*i* pci:v00008086d000015AAsv*sd*bc*sc*i* pci:v00008086d000015D1sv*sd*bc*sc*i* pci:v00008086d00001563sv*sd*bc*sc*i* pci:v00008086d00001560sv*sd*bc*sc*i* pci:v00008086d0000154Asv*sd*bc*sc*i* pci:v00008086d00001557sv*sd*bc*sc*i* pci:v00008086d00001558sv*sd*bc*sc*i* pci:v00008086d0000154Fsv*sd*bc*sc*i* pci:v00008086d0000154Dsv*sd*bc*sc*i* pci:v00008086d00001528sv*sd*bc*sc*i* pci:v00008086d000010F8sv*sd*bc*sc*i* pci:v00008086d0000151Csv*sd*bc*sc*i* pci:v00008086d00001529sv*sd*bc*sc*i* pci:v00008086d0000152Asv*sd*bc*sc*i* pci:v00008086d000010F9sv*sd*bc*sc*i* pci:v00008086d00001514sv*sd*bc*sc*i* pci:v00008086d00001507sv*sd*bc*sc*i* pci:v00008086d000010FBsv*sd*bc*sc*i* pci:v00008086d00001517sv*sd*bc*sc*i* pci:v00008086d000010FCsv*sd*bc*sc*i* pci:v00008086d000010F7sv*sd*bc*sc*i* pci:v00008086d00001508sv*sd*bc*sc*i* pci:v00008086d000010DBsv*sd*bc*sc*i* pci:v00008086d000010F4sv*sd*bc*sc*i* pci:v00008086d000010E1sv*sd*bc*sc*i* pci:v00008086d000010F1sv*sd*bc*sc*i* pci:v00008086d000010ECsv*sd*bc*sc*i* pci:v00008086d000010DDsv*sd*bc*sc*i* pci:v00008086d0000150Bsv*sd*bc*sc*i* pci:v00008086d000010C8sv*sd*bc*sc*i* pci:v00008086d000010C7sv*sd*bc*sc*i* pci:v00008086d000010C6sv*sd*bc*sc*i* pci:v00008086d000010B6sv*sd*bc*sc*i* symbol:ixgbe_xdp_locking_key
xfrm_algo mdio

kernel/drivers/net/ethernet/intel/igc/igc.ko.xz pci:v00008086d000015FDsv*sd*bc*sc*i* pci:v00008086d0000125Fsv*sd*bc*sc*i* pci:v00008086d0000125Esv*sd*bc*sc*i* pci:v00008086d0000125Dsv*sd*bc*sc*i* pci:v00008086d0000125Csv*sd*bc*sc*i* pci:v00008086d0000125Bsv*sd*bc*sc*i* pci:v00008086d00000D9Fsv*sd*bc*sc*i* pci:v00008086d00005503sv*sd*bc*sc*i* pci:v00008086d00005502sv*sd*bc*sc*i* pci:v00008086d00003102sv*sd*bc*sc*i* pci:v00008086d00003101sv*sd*bc*sc*i* pci:v00008086d00003100sv*sd*bc*sc*i* pci:v00008086d000015F7sv*sd*bc*sc*i* pci:v00008086d000015F8sv*sd*bc*sc*i* pci:v00008086d000015F3sv*sd*bc*sc*i* pci:v00008086d000015F2sv*sd*bc*sc*i*

kernel/drivers/net/ethernet/intel/libie/libie.ko.xz symbol:libie_rx_pt_lut

kernel/drivers/net/ethernet/qualcomm/qcaspi.ko.xz of:N*T*Cqca,qca7000C* of:N*T*Cqca,qca7000 spi:qca7000
qca_7k_common

kernel/drivers/net/ethernet/qualcomm/qca_7k_common.ko.xz symbol:qcafrm_create_header symbol:qcafrm_create_footer symbol:qcafrm_fsm_decode

kernel/drivers/net/ethernet/qualcomm/qcauart.ko.xz of:N*T*Cqca,qca7000C* of:N*T*Cqca,qca7000
qca_7k_common

kernel/drivers/net/ethernet/realtek/r8169.ko.xz pci:v000010ECd00003000sv*sd*bc*sc*i* pci:v000010ECd00008126sv*sd*bc*sc*i* pci:v000010ECd00008125sv*sd*bc*sc*i* pci:v00000001d00008168sv*sd00002410bc*sc*i* pci:v00001737d00001032sv*sd00000024bc*sc*i* pci:v000016ECd00000116sv*sd*bc*sc*i* pci:v00001259d0000C107sv*sd*bc*sc*i* pci:v00001186d00004302sv*sd*bc*sc*i* pci:v00001186d00004300sv*sd*bc*sc*i* pci:v00001186d00004300sv00001186sd00004B10bc*sc*i* pci:v000010ECd00008169sv*sd*bc*sc*i* pci:v000010FFd00008168sv*sd*bc*sc*i* pci:v000010ECd00008168sv*sd*bc*sc*i* pci:v000010ECd00008167sv*sd*bc*sc*i* pci:v000010ECd00008162sv*sd*bc*sc*i* pci:v000010ECd00008161sv*sd*bc*sc*i* pci:v000010ECd00008136sv*sd*bc*sc*i* pci:v000010ECd00008129sv*sd*bc*sc*i* pci:v000010ECd00002600sv*sd*bc*sc*i* pci:v000010ECd00002502sv*sd*bc*sc*i*

kernel/drivers/net/phy/ax88796b.ko.xz mdio:0000000000111011000110000100???? mdio:00000000001110110001100010000001 mdio:00000000001110110001100001100001

kernel/drivers/net/phy/realtek.ko.xz mdio:0000000000011100110010??????????

kernel/drivers/net/mdio/mdio-bitbang.ko.xz symbol:mdiobb_read_c22 symbol:mdiobb_read_c45 symbol:mdiobb_write_c22 symbol:mdiobb_write_c45 symbol:alloc_mdio_bitbang symbol:free_mdio_bitbang

kernel/drivers/net/ifb.ko.xz rtnl_link_ifb

kernel/drivers/net/vrf.ko.xz rtnl_link_vrf
ipv6

kernel/drivers/net/usb/qmi_wwan.ko.xz usb:v1410pA021d*dc*dsc*dp*ic*isc*ip*in00* usb:v12D1p14F1d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p901Bd*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9019d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9015d*dc*dsc*dp*ic*isc*ip*in00* usb:v03F0p371Dd*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9013d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9205d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p8002d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9011d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p900Ad*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9009d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9008d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9007d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9006d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9005d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9004d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9003d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9002d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p9001d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p68A9d*dc*dsc*dp*ic*isc*ip*in00* usb:v1199p68A5d*dc*dsc*dp*ic*isc*ip*in00* usb:v0AF0p8120d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9275d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9235d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9265d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9215d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9215d*dc*dsc*dp*ic*isc*ip*in00* usb:v03F0p251Dd*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9245d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9225d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p920Bd*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp8194d*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp8186d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p9009d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9222d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9203d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9202d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9002d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9001d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2pFFF3d*dc*dsc*dp*ic*isc*ip*in03* usb:v0B05p1776d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA007d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA006d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA005d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA004d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA003d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA002d*dc*dsc*dp*ic*isc*ip*in03* usb:v1410pA001d*dc*dsc*dp*ic*isc*ip*in03* usb:v413Cp8172d*dc*dsc*dp*ic*isc*ip*in03* usb:v04DAp250Dd*dc*dsc*dp*ic*isc*ip*in03* usb:v03F0p1F1Dd*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9212d*dc*dsc*dp*ic*isc*ip*in03* usb:v2DEEp4D22d*dc*dsc*dp*ic*isc*ip*in05* usb:v33F8p0104d*dc*dsc*dp*ic*isc*ip*in04* usb:v1546p1342d*dc*dsc*dp*ic*isc*ip*in04* usb:v1546p1312d*dc*dsc*dp*ic*isc*ip*in04* usb:v2692p9025d*dc*dsc*dp*ic*isc*ip*in04* usb:v0489pE0B5d*dc*dsc*dp*ic*isc*ip*in00* usb:v0489pE0B4d*dc*dsc*dp*ic*isc*ip*in00* usb:v2CB7p0112d*dc*dsc*dp*ic*isc*ip*in00* usb:v2CB7p0104d*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp030Ed*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp0296d*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp0195d*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp0191d*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp0121d*dc*dsc*dp*ic*isc*ip*in04* usb:v1E0Ep9071d*dc*dsc*dp*ic*isc*ip*in03* usb:v1E0Ep9001d*dc*dsc*dp*ic*isc*ip*in05* usb:v22DEp9061d*dc*dsc*dp*ic*isc*ip*in03* usb:v22DEp9051d*dc*dsc*dp*ic*isc*ip*in02* usb:v03F0p9D1Dd*dc*dsc*dp*ic*isc*ip*in01* usb:v03F0p4E1Dd*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81E6d*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp81E4d*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp81E0d*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp81D7d*dc*dsc*dp*ic*isc*ip*in01* usb:v413Cp81D7d*dc*dsc*dp*ic*isc*ip*in00* usb:v413Cp81CCd*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81C2d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81B6d*dc*dsc*dp*ic*isc*ip*in0A* usb:v413Cp81B6d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81B3d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81B1d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81A9d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81A8d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81A4d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81A3d*dc*dsc*dp*ic*isc*ip*in08* usb:v413Cp81A2d*dc*dsc*dp*ic*isc*ip*in08* usb:v1E2Dp00F4d*dc*dsc*dp*ic*isc*ip*in00* usb:v1E2Dp00F3d*dc*dsc*dp*ic*isc*ip*in00* usb:v1E2Dp00B9d*dc*dsc*dp*ic*isc*ip*in00* usb:v1E2Dp00B7d*dc*dsc*dp*ic*isc*ip*in00* usb:v1E2Dp00B0d*dc*dsc*dp*ic*isc*ip*in04* usb:v1E2Dp0083d*dc*dsc*dp*ic*isc*ip*in04* usb:v1E2Dp0082d*dc*dsc*dp*ic*isc*ip*in05* usb:v1E2Dp0082d*dc*dsc*dp*ic*isc*ip*in04* usb:v1E2Dp0063d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1E2Dp0053d*dc*dsc*dp*ic*isc*ip*in04* usb:v1E2Dp006Fd*dc*dsc*dp*ic*isc*ip*in08* usb:v1E2Dp0060d*dc*dsc*dp*ic*isc*ip*in04* usb:v0B3CpC00Bd*dc*dsc*dp*ic*isc*ip*in04* usb:v0B3CpC00Ad*dc*dsc*dp*ic*isc*ip*in06* usb:v0B3CpC005d*dc*dsc*dp*ic*isc*ip*in06* usb:v0B3CpC004d*dc*dsc*dp*ic*isc*ip*in06* usb:v0B3CpC002d*dc*dsc*dp*ic*isc*ip*in04* usb:v0B3CpC001d*dc*dsc*dp*ic*isc*ip*in04* usb:v0B3CpC000d*dc*dsc*dp*ic*isc*ip*in04* usb:v1C9Ep9B3Cd*dc*dsc*dp*ic*isc*ip*in04* usb:v1C9Ep9B05d*dc*dsc*dp*ic*isc*ip*in04* usb:v1C9Ep9B01d*dc*dsc*dp*ic*isc*ip*in03* usb:v1C9Ep9803d*dc*dsc*dp*ic*isc*ip*in04* usb:v1C9Ep9801d*dc*dsc*dp*ic*isc*ip*in03* usb:v1BC7p3001d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p3000d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p1900d*dc*dsc*dp*ic*isc*ip*in01* usb:v1BC7p1261d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1260d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1250d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p1230d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1201d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1200d*dc*dsc*dp*ic*isc*ip*in05* usb:v1BC7p1101d*dc*dsc*dp*ic*isc*ip*in03* usb:v1BC7p1100d*dc*dsc*dp*ic*isc*ip*in03* usb:v1BC7p10D0d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10C8d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10C4d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10C0d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10B0d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10A9d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10A4d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p10A0d*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p1080d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1077d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1070d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1060d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1057d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1050d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1040d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p103Ad*dc*dsc*dp*ic*isc*ip*in00* usb:v1BC7p1038d*dc*dsc*dp*ic*isc*ip*in03* usb:v1BC7p1037d*dc*dsc*dp*ic*isc*ip*in04* usb:v1BC7p1034d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BC7p1031d*dc*dsc*dp*ic*isc*ip*in03* usb:v2357p9000d*dc*dsc*dp*ic*isc*ip*in04* usb:v2357p0201d*dc*dsc*dp*ic*isc*ip*in04* usb:v1BBBp0203d*dc*dsc*dp*ic*isc*ip*in02* usb:v1BBBp011Ed*dc*dsc*dp*ic*isc*ip*in04* usb:v1199pC081d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9091d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p907Bd*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p907Bd*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9079d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p9079d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9071d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p9071d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9063d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p9063d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9061d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9057d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9056d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9055d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9054d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9053d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9051d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p9041d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p9041d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p901Fd*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p901Cd*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p68C0d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p68C0d*dc*dsc*dp*ic*isc*ip*in08* usb:v1199p68A2d*dc*dsc*dp*ic*isc*ip*in13* usb:v1199p68A2d*dc*dsc*dp*ic*isc*ip*in08* usb:v114Fp68A2d*dc*dsc*dp*ic*isc*ip*in08* usb:v0F3Dp68A2d*dc*dsc*dp*ic*isc*ip*in08* usb:v2020p2060d*dc*dsc*dp*ic*isc*ip*in04* usb:v2020p2033d*dc*dsc*dp*ic*isc*ip*in04* usb:v2020p2031d*dc*dsc*dp*ic*isc*ip*in04* usb:v2001p7E3Dd*dc*dsc*dp*ic*isc*ip*in04* usb:v2001p7E35d*dc*dsc*dp*ic*isc*ip*in04* usb:v2001p7E19d*dc*dsc*dp*ic*isc*ip*in04* usb:v2001p7E16d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p2002d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1485d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p1432d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p1428d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1426d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1425d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1424d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1402d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1401d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1275d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p1270d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p1256d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1255d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1255d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p1254d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1252d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1247d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1245d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1021d*dc*dsc*dp*ic*isc*ip*in02* usb:v19D2p1018d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p1012d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1010d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p1008d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0412d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0396d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0326d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0284d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0265d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0257d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0200d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0199d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0191d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0189d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0178d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0176d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0168d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0167d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0158d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0157d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0141d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0133d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0130d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0126d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0125d*dc*dsc*dp*ic*isc*ip*in06* usb:v19D2p0124d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0123d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0121d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0118d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0113d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0104d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0063d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0058d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0055d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0052d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0049d*dc*dsc*dp*ic*isc*ip*in05* usb:v19D2p0042d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0031d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0025d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0021d*dc*dsc*dp*ic*isc*ip*in04* usb:v19D2p0019d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0017d*dc*dsc*dp*ic*isc*ip*in03* usb:v19D2p0012d*dc*dsc*dp*ic*isc*ip*in01* usb:v19D2p0002d*dc*dsc*dp*ic*isc*ip*in01* usb:v16D8p7253d*dc*dsc*dp*ic*isc*ip*in01* usb:v16D8p7252d*dc*dsc*dp*ic*isc*ip*in01* usb:v16D8p7251d*dc*dsc*dp*ic*isc*ip*in01* usb:v16D8p7213d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p7212d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p7211d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p700Ad*dc*dsc*dp*ic*isc*ip*in04* usb:v16D8p7006d*dc*dsc*dp*ic*isc*ip*in05* usb:v16D8p7004d*dc*dsc*dp*ic*isc*ip*in03* usb:v16D8p7003d*dc*dsc*dp*ic*isc*ip*in04* usb:v16D8p7002d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p7001d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p6280d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p6008d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p6007d*dc*dsc*dp*ic*isc*ip*in00* usb:v16D8p6003d*dc*dsc*dp*ic*isc*ip*in00* usb:v1690p7588d*dc*dsc*dp*ic*isc*ip*in04* usb:v1508p1001d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435pD191d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435pD182d*dc*dsc*dp*ic*isc*ip*in05* usb:v1435pD182d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435pD181d*dc*dsc*dp*ic*isc*ip*in05* usb:v1435pD181d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435pD181d*dc*dsc*dp*ic*isc*ip*in03* usb:v1435pD111d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435p3185d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435p0918d*dc*dsc*dp*ic*isc*ip*in05* usb:v1435p0918d*dc*dsc*dp*ic*isc*ip*in04* usb:v1435p0918d*dc*dsc*dp*ic*isc*ip*in03* usb:v12D1p14ACd*dc*dsc*dp*ic*isc*ip*in01* usb:v12D1p140Cd*dc*dsc*dp*ic*isc*ip*in01* usb:v0846p68D3d*dc*dsc*dp*ic*isc*ip*in08* usb:v0846p68A2d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9625d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p920Dd*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p920Dd*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p90DBd*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p90B2d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9091d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9084d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9083d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9080d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9080d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9080d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9080d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9079d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9079d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9079d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9079d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9079d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9078d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9077d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9077d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9077d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9077d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9076d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9076d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9076d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9076d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9076d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9075d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9070d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9070d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9069d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9069d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9069d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9069d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9068d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9067d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p9066d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9066d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9065d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9065d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9064d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in09* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9062d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9056d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9055d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9055d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9055d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9055d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9055d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9054d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9054d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9053d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9053d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9052d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9050d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p904Cd*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p904Cd*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p904Cd*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p904Cd*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9048d*dc*dsc*dp*ic*isc*ip*in08* usb:v05C6p9048d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9048d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9048d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9048d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9047d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9047d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9047d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9046d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9046d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9046d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9043d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p903Ed*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p903Dd*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p903Cd*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p903Bd*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9038d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9037d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9036d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9035d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9034d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p9034d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9034d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9034d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9034d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9033d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p9033d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9033d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9033d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9032d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9031d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p902Ed*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9026d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9025d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9022d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9021d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p9011d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9011d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p9010d*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p9010d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p900Fd*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p900Fd*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p900Fd*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p900Dd*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p900Cd*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p900Cd*dc*dsc*dp*ic*isc*ip*in05* usb:v05C6p900Cd*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p900Bd*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p900Ad*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9005d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p9003d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p9000d*dc*dsc*dp*ic*isc*ip*in04* usb:v05C6p8001d*dc*dsc*dp*ic*isc*ip*in06* usb:v05C6p8000d*dc*dsc*dp*ic*isc*ip*in07* usb:v05C6p7102d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p7102d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p7102d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p7101d*dc*dsc*dp*ic*isc*ip*in03* usb:v05C6p7101d*dc*dsc*dp*ic*isc*ip*in02* usb:v05C6p7101d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p7002d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p7001d*dc*dsc*dp*ic*isc*ip*in01* usb:v05C6p7000d*dc*dsc*dp*ic*isc*ip*in00* usb:v05C6p6001d*dc*dsc*dp*ic*isc*ip*in03* usb:v0408pEA42d*dc*dsc*dp*ic*isc*ip*in04* usb:v2C7Cp0801d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0800d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0620d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0512d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0306d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0125d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0122d*dc*dsc*dp*icFFiscFFipFFin* usb:v03F0p581Dd*dc*dsc*dp*icFFisc01ip07in* usb:v03F0p421Dd*dc*dsc*dp*ic02isc06ip00in* usb:v16D5p650Ad*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp819Bd*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp8196d*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp8195d*dc*dsc*dp*ic02isc06ip00in* usb:v1410p9011d*dc*dsc*dp*ic02isc06ip00in* usb:v1410p9010d*dc*dsc*dp*ic02isc06ip00in* usb:v1410pB001d*dc*dsc*dp*ic02isc06ip00in* usb:v106Cp*d*dc*dsc*dp*icFFiscF1ipFFin* usb:v106Cp*d*dc*dsc*dp*icFFiscF0ipFFin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip67in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip37in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip11in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip07in* usb:v22B8p*d*dc*dsc*dp*icFFiscFBipFFin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip69in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip39in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip09in*
cdc_wdm

kernel/drivers/net/usb/aqc111.ko.xz usb:v1C04p0015d*dc*dsc*dp*ic02isc06ip00in* usb:v1C04p0015d*dc*dsc*dp*icFFisc*ip*in* usb:v20F4pE05Ad*dc*dsc*dp*ic02isc06ip00in* usb:v20F4pE05Ad*dc*dsc*dp*icFFisc*ip*in* usb:v0B95p2791d*dc*dsc*dp*ic02isc06ip00in* usb:v0B95p2791d*dc*dsc*dp*icFFisc*ip*in* usb:v0B95p2790d*dc*dsc*dp*ic02isc06ip00in* usb:v0B95p2790d*dc*dsc*dp*icFFisc*ip*in* usb:v2ECApC101d*dc*dsc*dp*ic02isc06ip00in* usb:v2ECApC101d*dc*dsc*dp*icFFisc*ip*in*

kernel/drivers/net/usb/r8152.ko.xz usb:v0B05p1976d*dc*dsc*dp*ic*isc*ip*in* usb:v413CpB097d*dc*dsc*dp*ic*isc*ip*in* usb:v2001pB301d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p0601d*dc*dsc*dp*ic*isc*ip*in* usb:v0955p09FFd*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0041d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFpA387d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFpA359d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp721Ed*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp7214d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp720Cd*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp7205d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp3098d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp3082d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp3069d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp3062d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp3054d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp304Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04E8pA101d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0C5Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0927d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep07C6d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep07ABd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8156d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8155d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8153d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8152d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8053d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8050d*dc*dsc*dp*ic*isc*ip*in* symbol:rtl8152_get_version

kernel/drivers/net/usb/net1080.ko.xz usb:v06D0p0622d*dc*dsc*dp*ic*isc*ip*in* usb:v0525p1080d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/sierra_net.ko.xz usb:v0F3Dp68AAd*dc*dsc*dp*ic*isc*ip*in0B* usb:v0F3Dp68AAd*dc*dsc*dp*ic*isc*ip*in0A* usb:v0F3Dp68AAd*dc*dsc*dp*ic*isc*ip*in07* usb:v1199p68AAd*dc*dsc*dp*ic*isc*ip*in0B* usb:v1199p68AAd*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p68AAd*dc*dsc*dp*ic*isc*ip*in07* usb:v0F3Dp68A3d*dc*dsc*dp*ic*isc*ip*in0B* usb:v0F3Dp68A3d*dc*dsc*dp*ic*isc*ip*in0A* usb:v0F3Dp68A3d*dc*dsc*dp*ic*isc*ip*in07* usb:v1199p68A3d*dc*dsc*dp*ic*isc*ip*in0B* usb:v1199p68A3d*dc*dsc*dp*ic*isc*ip*in0A* usb:v1199p68A3d*dc*dsc*dp*ic*isc*ip*in07*

kernel/drivers/net/usb/sr9700.ko.xz usb:v0FE6p9700d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/cdc_eem.ko.xz usb:v*p*d*dc*dsc*dp*ic02isc0Cip07in*

kernel/drivers/net/usb/ipheth.ko.xz usb:v05ACp*d*dc*dsc*dp*icFFiscFDip01in*

kernel/drivers/net/usb/pegasus.ko.xz usb:v067Cp1001d*dc*dsc*dp*ic*isc*ip*in* usb:v15E8p9110d*dc*dsc*dp*ic*isc*ip*in* usb:v15E8p9100d*dc*dsc*dp*ic*isc*ip*in* usb:v0707p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v0707p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v08D1p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0B39p0901d*dc*dsc*dp*ic*isc*ip*in* usb:v0B39p0109d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p1020d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep007Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp200Cd*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp400Bd*dc*dsc*dp*ic*isc*ip*in* usb:v077Bp08B4d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2206d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2204d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2203d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2202d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep200Cd*dc*dsc*dp*ic*isc*ip*in* usb:v056EpABC1d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep400Bd*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep4005d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep4002d*dc*dsc*dp*ic*isc*ip*in* usb:v0951p000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp093Ad*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0913d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0904d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p811Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0E66p400Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1044p8002d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3000d*dc*dsc*dp*ic*isc*ip*in* usb:v1342p0304d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep4010d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB7p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v2001pABC1d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p4003d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p200Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p400Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2001p4102d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p4002d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p4001d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0004d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp8511d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp0988d*dc*dsc*dp*ic*isc*ip*in* usb:v049Fp8511d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp0987d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp0986d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0122d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0121d*dc00dsc*dp*ic*isc*ip*in* usb:v07C9pB100d*dc*dsc*dp*ic*isc*ip*in* usb:v3334p1701d*dc*dsc*dp*ic*isc*ip*in* usb:v07A6p07C2d*dc*dsc*dp*ic*isc*ip*in* usb:v07A6p0986d*dc*dsc*dp*ic*isc*ip*in* usb:v07A6p8515d*dc*dsc*dp*ic*isc*ip*in* usb:v07A6p8513d*dc*dsc*dp*ic*isc*ip*in* usb:v07A6p8511d*dc*dsc*dp*ic*isc*ip*in* usb:v083ApB004d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap5046d*dc*dsc*dp*ic*isc*ip*in* usb:v083Ap1046d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p200Cd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8pABC1d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p400Cd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p400Bd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4002d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4102d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4007d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4004d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4104d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p110Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2007d*dc*dsc*dp*ic*isc*ip*in* usb:v0506p4601d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/catc.ko.xz usb:v08D1p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0423p000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0423p000Ad*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/sr9800.ko.xz usb:v0FE6p9800d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/smsc75xx.ko.xz usb:v0424p7505d*dc*dsc*dp*ic*isc*ip*in* usb:v0424p7500d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/int51x1.ko.xz usb:v09E1p5121d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/plusb.ko.xz usb:v067Bp27A1d*dc*dsc*dp*ic*isc*ip*in* usb:v3923p7825d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp258Ad*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp25A1d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0000d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/cdc_mbim.ko.xz usb:v*p*d*dc*dsc*dp*ic02isc0Eip00in* usb:v1BC7p1081d*dc*dsc*dp*ic02isc0Eip00in* usb:v1BC7p1071d*dc*dsc*dp*ic02isc0Eip00in* usb:v1BC7p1061d*dc*dsc*dp*ic02isc0Eip00in* usb:v1BC7p1041d*dc*dsc*dp*ic02isc0Eip00in* usb:v03F0pA31Dd*dc*dsc*dp*ic02isc0Eip00in* usb:v12D1p*d*dc*dsc*dp*ic02isc0Eip00in* usb:v0BDBp*d*dc*dsc*dp*ic02isc0Eip00in* usb:v*p*d*dc*dsc*dp*ic02isc0Dip00in*
cdc_ncm cdc_wdm

kernel/drivers/net/usb/kaweth.ko.xz usb:v2001p4000d*dc*dsc*dp*ic*isc*ip*in* usb:v1668p0323d*dc*dsc*dp*ic*isc*ip*in* usb:v1645p8005d*dc*dsc*dp*ic*isc*ip*in* usb:v1645p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v1645p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v1485p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1485p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v13D2p0400d*dc*dsc*dp*ic*isc*ip*in* usb:v1342p0204d*dc*dsc*dp*ic*isc*ip*in* usb:v10BDp1427d*dc*dsc*dp*ic*isc*ip*in* usb:v095Ap3003d*dc*dsc*dp*ic*isc*ip*in* usb:v0951p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v087Dp5704d*dc*dsc*dp*ic*isc*ip*in* usb:v085Ap0009d*dc*dsc*dp*ic*isc*ip*in* usb:v085Ap0008d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v07C9pB010d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p4000d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0707p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v06E1p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v06E1p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp2202d*dc*dsc*dp*ic*isc*ip*in* usb:v05E9p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v05E9p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v0565p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0565p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0565p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p4000d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v0506p11F8d*dc*dsc*dp*ic*isc*ip*in* usb:v0506p03E8d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0901d*dc*dsc*dp*ic*isc*ip*in* usb:v03E8p0008d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/rtl8150.ko.xz usb:v0586p401Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1557p8150d*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p401Ad*dc*dsc*dp*ic*isc*ip*in* usb:v3980p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0411p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp8150d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/asix.ko.xz usb:v1D2Ap0801d*dc*dsc*dp*ic*isc*ip*in* usb:v33F7p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp20F9d*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p172Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p7E2Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0pA877d*dc*dsc*dp*ic*isc*ip*in* usb:v14EApAB11d*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p772Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp1402d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp5055d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0930d*dc*dsc*dp*ic*isc*ip*in* usb:v1737p0039d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p1A02d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p3C05d*dc*dsc*dp*ic*isc*ip*in* usb:v07D1p3C05d*dc*dsc*dp*ic*isc*ip*in* usb:v1557p7720d*dc*dsc*dp*ic*isc*ip*in* usb:v13B1p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v0789p0160d*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p1780d*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p7720d*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p772Bd*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp7203d*dc*dsc*dp*ic*isc*ip*in* usb:v04F1p3008d*dc*dsc*dp*ic*isc*ip*in* usb:v1631p6200d*dc*dsc*dp*ic*isc*ip*in* usb:v1189p0893d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp0017d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p061Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0DF6p0056d*dc*dsc*dp*ic*isc*ip*in* usb:v6189p182Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0411p006Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0411p003Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2009d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp0114d*dc*dsc*dp*ic*isc*ip*in* usb:v08DDp90FFd*dc*dsc*dp*ic*isc*ip*in* usb:v07B8p420Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B95p1720d*dc*dsc*dp*ic*isc*ip*in* usb:v2001p1A00d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p1040d*dc*dsc*dp*ic*isc*ip*in* usb:v077Bp2226d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/cdc_ether.ko.xz usb:v12D1p*d*dc*dsc*dp*ic02isc06ipFFin* usb:v*p*d*dc*dsc*dp*ic02isc0Aip00in* usb:v*p*d*dc*dsc*dp*ic02isc06ip00in* usb:v1E2Dp0069d*dc*dsc*dp*ic02isc06ip00in* usb:v1E2Dp005Bd*dc*dsc*dp*ic02isc06ip00in* usb:v1E2Dp0055d*dc*dsc*dp*ic02isc06ip00in* usb:v1E2Dp0061d*dc*dsc*dp*ic02isc06ip00in* usb:v1546p1343d*dc*dsc*dp*ic02isc06ip00in* usb:v1546p1313d*dc*dsc*dp*ic02isc06ip00in* usb:v1546p1104d*dc*dsc*dp*ic02isc06ip00in* usb:v1546p1143d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p*d*dc*dsc*dp*ic02isc06ip00in* usb:v12D1p15C1d*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp81BAd*dc*dsc*dp*ic02isc06ip00in* usb:v1BC7p*d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p1181d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p1177d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p1173d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p1015d*dc*dsc*dp*ic02isc06ip00in* usb:v19D2p1003d*dc*dsc*dp*ic02isc06ip00in* usb:v1C04p0015d*dc*dsc*dp*ic02isc06ip00in* usb:v20F4pE05Ad*dc*dsc*dp*ic02isc06ip00in* usb:v0B95p2791d*dc*dsc*dp*ic02isc06ip00in* usb:v0B95p2790d*dc*dsc*dp*ic02isc06ip00in* usb:v2ECApC101d*dc*dsc*dp*ic02isc06ip00in* usb:v17EFpA359d*dc*dsc*dp*ic02isc06ip00in* usb:v17EFp721Ed*dc*dsc*dp*ic02isc06ip00in* usb:v0BDAp8153d*dc*dsc*dp*ic02isc06ip00in* usb:v12D1p14ACd*dc*dsc*dp*ic*isc*ip*in01* usb:v16D5p650Ad*dc*dsc*dp*ic02isc06ip00in* usb:v03F0p421Dd*dc*dsc*dp*ic02isc06ip00in* usb:v1410p9011d*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp819Bd*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp8196d*dc*dsc*dp*ic02isc06ip00in* usb:v413Cp8195d*dc*dsc*dp*ic02isc06ip00in* usb:v1410p9010d*dc*dsc*dp*ic02isc06ip00in* usb:v1410pB001d*dc*dsc*dp*ic02isc06ip00in* usb:v046DpC11Fd*dc*dsc*dp*ic02isc0Aip00in* usb:v1004p61AAd*dc*dsc*dp*ic02isc06ip00in* usb:v07B4p0F02d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp9050d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp9032d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp9032d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp9031d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8007d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8007d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8006d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8006d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8005d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8005d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8004d*dc*dsc*dp*ic02isc06ip00in* symbol:usbnet_cdc_update_filter symbol:usbnet_generic_cdc_bind symbol:usbnet_ether_cdc_bind symbol:usbnet_cdc_unbind symbol:usbnet_cdc_status symbol:usbnet_cdc_bind symbol:usbnet_cdc_zte_rx_fixup

kernel/drivers/net/usb/r8153_ecm.ko.xz usb:v17EFpA359d*dc*dsc*dp*ic02isc06ip00in* usb:v17EFp721Ed*dc*dsc*dp*ic02isc06ip00in* usb:v0BDAp8153d*dc*dsc*dp*ic02isc06ip00in*
cdc_ether r8152

kernel/drivers/net/usb/ax88179_178a.ko.xz usb:v07C9p0010d*dc*dsc*dp*icFFiscFFip00in* usb:v07C9p000Fd*dc*dsc*dp*icFFiscFFip00in* usb:v07C9p000Ed*dc*dsc*dp*icFFiscFFip00in* usb:v0711p0179d*dc*dsc*dp*icFFiscFFip00in* usb:v0930p0A13d*dc*dsc*dp*icFFiscFFip00in* usb:v050Dp0128d*dc*dsc*dp*icFFiscFFip00in* usb:v17EFp304Bd*dc*dsc*dp*icFFiscFFip00in* usb:v04E8pA100d*dc*dsc*dp*icFFiscFFip00in* usb:v0DF6p0072d*dc*dsc*dp*icFFiscFFip00in* usb:v2001p4A00d*dc*dsc*dp*icFFiscFFip00in* usb:v04B4p3610d*dc*dsc*dp*icFFiscFFip00in* usb:v0B95p178Ad*dc*dsc*dp*icFFiscFFip00in* usb:v0B95p1790d*dc*dsc*dp*icFFiscFFip00in*

kernel/drivers/net/usb/mcs7830.ko.xz usb:v0DF6p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7730d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7830d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7832d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/zaurus.ko.xz usb:v046DpC11Fd*dc*dsc*dp*ic02isc0Aip00in* usb:v07B4p0F02d*dc*dsc*dp*ic02isc06ip00in* usb:v22B8p6425d*dc*dsc*dp*ic02isc0Aip00in* usb:v22B8p6027d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp9050d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp9032d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp9032d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp9031d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp9031d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8007d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8007d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8006d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8006d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8005d*dc*dsc*dp*ic02isc0Aip00in* usb:v04DDp8005d*dc*dsc*dp*ic02isc06ip00in* usb:v04DDp8004d*dc*dsc*dp*ic02isc06ip00in*
cdc_ether

kernel/drivers/net/usb/kalmia.ko.xz usb:v04E8p6889d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p689Ad*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/lg-vl600.ko.xz usb:v1004p61AAd*dc*dsc*dp*ic02isc06ip00in*
cdc_ether

kernel/drivers/net/usb/rndis_host.ko.xz usb:v*p*d*dc*dsc*dp*icEFisc04ip01in* usb:v*p*d*dc*dsc*dp*icE0isc01ip03in* usb:v*p*d*dc*dsc*dp*icEFisc01ip01in* usb:v*p*d*dc*dsc*dp*ic02isc02ipFFin* usb:v19D2p*d*dc*dsc*dp*ic02isc02ipFFin* usb:v19D2p*d*dc*dsc*dp*icE0isc01ip03in* usb:v238Bp*d*dc*dsc*dp*ic02isc02ipFFin* usb:v1630p0042d*dc*dsc*dp*ic02isc02ipFFin* symbol:rndis_status symbol:rndis_command symbol:generic_rndis_bind symbol:rndis_unbind symbol:rndis_rx_fixup symbol:rndis_tx_fixup
cdc_ether

kernel/drivers/net/usb/cdc_ncm.ko.xz usb:v*p*d*dc*dsc*dp*ic02isc0Dip00in* usb:v17E9p*d*dc*dsc*dp*ic02isc0Dip00in* usb:v8087p095Ad*dc*dsc*dp*ic02isc0Dip00in* usb:v1546p1010d*dc*dsc*dp*ic02isc0Dip00in* usb:v1519p0443d*dc*dsc*dp*ic02isc0Dip00in* usb:v12D1p*d*dc*dsc*dp*ic02isc0Dip00in* usb:v0930p*d*dc*dsc*dp*ic02isc0Dip00in* usb:v413Cp*d*dc*dsc*dp*ic02isc0Dip00in* usb:v413Cp81BCd*dc*dsc*dp*ic02isc0Dip00in* usb:v413Cp81BBd*dc*dsc*dp*ic02isc0Dip00in* usb:v1BC7p0036d*dc*dsc*dp*ic02isc0Dip00in* usb:v0BDBp*d*dc*dsc*dp*ic02isc0Dip00in* usb:v05ACp12ABd*dc*dsc*dp*ic*isc*ip*in04* usb:v05ACp12ABd*dc*dsc*dp*ic*isc*ip*in02* usb:v05ACp12A8d*dc*dsc*dp*ic*isc*ip*in04* usb:v05ACp12A8d*dc*dsc*dp*ic*isc*ip*in02* symbol:cdc_ncm_change_mtu symbol:cdc_ncm_bind_common symbol:cdc_ncm_unbind symbol:cdc_ncm_select_altsetting symbol:cdc_ncm_fill_tx_frame symbol:cdc_ncm_tx_fixup symbol:cdc_ncm_rx_verify_nth16 symbol:cdc_ncm_rx_verify_nth32 symbol:cdc_ncm_rx_verify_ndp16 symbol:cdc_ncm_rx_verify_ndp32 symbol:cdc_ncm_rx_fixup
cdc_ether

kernel/drivers/net/usb/cdc_subset.ko.xz usb:v0525pA4A2d*dc*dsc*dp*ic*isc*ip*in* usb:v1286p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v8086p07D3d*dc*dsc*dp*ic*isc*ip*in* usb:v0E7Ep1001d*dc*dsc*dp*ic*isc*ip*in* usb:v049Fp505Ad*dc*dsc*dp*ic*isc*ip*in* usb:v050Fp0190d*dc*dsc*dp*ic*isc*ip*in* usb:v0525p2888d*dc*dsc*dp*ic*isc*ip*in* usb:v0525p9901d*dc*dsc*dp*ic*isc*ip*in* usb:v056Cp8100d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0004d*dc*dsc*dp*ic*isc*ip*in* usb:v0547p2727d*dc*dsc*dp*ic*isc*ip*in* usb:v0547p2720d*dc*dsc*dp*ic*isc*ip*in* usb:v182Dp207Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0402p5632d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/cx82310_eth.ko.xz usb:v0572pCB01d*dcFFdsc00dp00ic*isc*ip*in*

kernel/drivers/net/usb/hso.ko.xz usb:v0AF0pC100d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD058d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD357d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD257d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD157d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD057d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD255d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD155d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD055d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD035d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p9200d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8900d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8800d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8600d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8400d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8304d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8302d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8300d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8201d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8200d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7A05d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7A01d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7901d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7801d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7706d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7701d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7601d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7501d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7401d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7381d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7361d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7301d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD033d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD031d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pD013d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0pC031d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7311d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7271d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7251d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7211d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7111d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7071d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7051d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7031d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7011d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6971d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6951d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6911d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6811d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6791d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6771d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6751d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6731d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6711d*dc*dsc*dp*ic*isc*ip*in*
rfkill

kernel/drivers/net/usb/gl620a.ko.xz usb:v05E3p0502d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/usb/huawei_cdc_ncm.ko.xz usb:v12D1p*d*dc*dsc*dp*icFFisc03ip16in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip76in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip46in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip16in*
cdc_ncm cdc_wdm

kernel/drivers/net/usb/dm9601.ko.xz usb:v0586p3427d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p1269d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p0269d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p9622d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p9621d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p9620d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE6p9700d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE6p8101d*dc*dsc*dp*ic*isc*ip*in* usb:v0A47p9601d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p8515d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p0268d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p6688d*dc*dsc*dp*ic*isc*ip*in* usb:v0A46p9601d*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp9601d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/net/tap.ko.xz symbol:tap_del_queues symbol:tap_handle_frame symbol:tap_get_minor symbol:tap_free_minor symbol:tap_get_socket symbol:tap_get_ptr_ring symbol:tap_queue_resize symbol:tap_create_cdev symbol:tap_destroy_cdev

kernel/drivers/clk/clk-hifiberry-dachd.ko.xz platform:clk_hifiberry_dachd i2c:dachd_clk of:N*T*Chifiberry,dachd_clkC* of:N*T*Chifiberry,dachd_clk symbol:hifiberry_pll_regmap
regmap_i2c

kernel/drivers/clk/clk-hifiberry-dacpro.ko.xz platform:clk_hifiberry_dacpro of:N*T*Callo,dac_clkC* of:N*T*Callo,dac_clk of:N*T*Chifiberry,dacpro_clkC* of:N*T*Chifiberry,dacpro_clk

kernel/drivers/ssb/ssb.ko.xz pci:v000014E4d00004351sv*sd*bc*sc*i* pci:v000014E4d00004350sv*sd*bc*sc*i* pci:v000014E4d0000432Csv*sd*bc*sc*i* pci:v000014E4d0000432Bsv*sd*bc*sc*i* pci:v000014E4d00004329sv*sd*bc*sc*i* pci:v000014E4d00004328sv*sd*bc*sc*i* pci:v000014E4d00004325sv*sd*bc*sc*i* pci:v000014E4d00004324sv*sd*bc*sc*i* pci:v000014E4d0000A8D6sv*sd*bc*sc*i* pci:v000014E4d00004322sv*sd*bc*sc*i* pci:v000014E4d00004321sv*sd*bc*sc*i* pci:v000014E4d00004320sv*sd*bc*sc*i* pci:v000014E4d00004319sv*sd*bc*sc*i* pci:v000014A4d00004318sv*sd*bc*sc*i* pci:v000014E4d00004318sv*sd*bc*sc*i* pci:v000014E4d00004315sv*sd*bc*sc*i* pci:v000014E4d00004312sv*sd*bc*sc*i* pci:v000014E4d00004311sv*sd*bc*sc*i* pci:v000014E4d00004307sv*sd*bc*sc*i* pci:v000014E4d00004306sv*sd*bc*sc*i* pci:v000014E4d00004301sv*sd*bc*sc*i* symbol:ssb_bus_resume symbol:ssb_bus_suspend symbol:ssb_bus_unregister symbol:__ssb_driver_register symbol:ssb_driver_unregister symbol:ssb_set_devtypedata symbol:ssb_clockspeed symbol:ssb_device_is_enabled symbol:ssb_device_enable symbol:ssb_device_disable symbol:ssb_dma_translation symbol:ssb_bus_may_powerdown symbol:ssb_bus_powerup symbol:ssb_commit_settings symbol:ssb_admatch_base symbol:ssb_admatch_size symbol:ssb_pcihost_register symbol:ssb_chipco_gpio_control symbol:ssb_pmu_set_ldo_voltage symbol:ssb_pmu_set_ldo_paref symbol:ssb_pmu_spuravoid_pllupdate symbol:ssb_pcicore_dev_irqvecs_enable

kernel/drivers/block/aoe/aoe.ko.xz

kernel/drivers/block/drbd/drbd.ko.xz block_major_147_* symbol:drbd_conn_str symbol:drbd_role_str symbol:drbd_disk_str symbol:drbd_set_st_err_str
lru_cache

kernel/drivers/block/rbd.ko.xz
libceph

kernel/drivers/block/zram/zram.ko.xz
lz4_compress

kernel/drivers/block/nbd.ko.xz net_pf_16_proto_16_family_nbd

kernel/drivers/leds/leds-pca9532.ko.xz i2c:pca9533 i2c:pca9532 i2c:pca9531 i2c:pca9530 of:N*T*Cnxp,pca9533C* of:N*T*Cnxp,pca9533 of:N*T*Cnxp,pca9532C* of:N*T*Cnxp,pca9532 of:N*T*Cnxp,pca9531C* of:N*T*Cnxp,pca9531 of:N*T*Cnxp,pca9530C* of:N*T*Cnxp,pca9530

kernel/drivers/leds/leds-pca963x.ko.xz i2c:pca9635 i2c:pca9634 i2c:pca9633 i2c:pca9632 of:N*T*Cnxp,pca9635C* of:N*T*Cnxp,pca9635 of:N*T*Cnxp,pca9634C* of:N*T*Cnxp,pca9634 of:N*T*Cnxp,pca9633C* of:N*T*Cnxp,pca9633 of:N*T*Cnxp,pca9632C* of:N*T*Cnxp,pca9632

kernel/drivers/leds/trigger/ledtrig-transient.ko.xz

kernel/drivers/leds/trigger/ledtrig-camera.ko.xz symbol:ledtrig_flash_ctrl symbol:ledtrig_torch_ctrl

kernel/drivers/leds/trigger/ledtrig-netdev.ko.xz ledtrig:netdev

kernel/drivers/leds/trigger/ledtrig-pattern.ko.xz

kernel/drivers/leds/leds-pca955x.ko.xz i2c:pca9553 i2c:ibm_pca9552 i2c:pca9552 i2c:pca9551 i2c:pca9550 of:N*T*Cnxp,pca9553C* of:N*T*Cnxp,pca9553 of:N*T*Cibm,pca9552C* of:N*T*Cibm,pca9552 of:N*T*Cnxp,pca9552C* of:N*T*Cnxp,pca9552 of:N*T*Cnxp,pca9551C* of:N*T*Cnxp,pca9551 of:N*T*Cnxp,pca9550C* of:N*T*Cnxp,pca9550

kernel/drivers/leds/leds-is31fl32xx.ko.xz of:N*T*Csi_en,sn3216C* of:N*T*Csi_en,sn3216 of:N*T*Cissi,is31fl3216C* of:N*T*Cissi,is31fl3216 of:N*T*Csi_en,sn3218C* of:N*T*Csi_en,sn3218 of:N*T*Cissi,is31fl3218C* of:N*T*Cissi,is31fl3218 of:N*T*Cissi,is31fl3235C* of:N*T*Cissi,is31fl3235 of:N*T*Cissi,is31fl3236C* of:N*T*Cissi,is31fl3236 i2c:sn3216 i2c:is31fl3216 i2c:sn3218 i2c:is31fl3218 i2c:is31fl3235 i2c:is31fl3236

kernel/drivers/leds/led-class-multicolor.ko.xz symbol:led_mc_calc_color_components symbol:led_classdev_multicolor_register_ext symbol:led_classdev_multicolor_unregister symbol:devm_led_classdev_multicolor_register_ext symbol:devm_led_classdev_multicolor_unregister

kernel/drivers/accessibility/speakup/speakup_soft.ko.xz
speakup

kernel/drivers/accessibility/speakup/speakup.ko.xz symbol:speakup_start_ttys symbol:synth_buffer_empty symbol:synth_buffer_getc symbol:synth_buffer_peek symbol:synth_buffer_skip_nonlatin1 symbol:synth_buffer_clear symbol:spk_var_show symbol:spk_var_store symbol:spk_ttyio_ops symbol:spk_ttyio_synth_probe symbol:spk_ttyio_release symbol:spk_ttyio_synth_immediate symbol:speakup_info symbol:spk_do_catch_up symbol:spk_do_catch_up_unicode symbol:spk_synth_flush symbol:spk_synth_get_index symbol:spk_synth_is_alive_nop symbol:spk_synth_is_alive_restart symbol:synth_printf symbol:synth_putwc symbol:synth_putwc_s symbol:synth_putws symbol:synth_putws_s symbol:synth_request_region symbol:synth_release_region symbol:synth_add symbol:synth_remove symbol:synth_current symbol:speakup_event symbol:spk_get_var_header symbol:spk_get_var symbol:spk_set_num_var

kernel/drivers/scsi/sr_mod.ko.xz scsi:t_0x04* scsi:t_0x05* block_major_11_*
cdrom

kernel/drivers/scsi/libiscsi_tcp.ko.xz symbol:iscsi_tcp_segment_unmap symbol:iscsi_tcp_segment_done symbol:iscsi_tcp_dgst_header symbol:iscsi_segment_init_linear symbol:iscsi_segment_seek_sg symbol:iscsi_tcp_hdr_recv_prep symbol:iscsi_tcp_cleanup_task symbol:iscsi_tcp_recv_segment_is_hdr symbol:iscsi_tcp_recv_skb symbol:iscsi_tcp_task_init symbol:iscsi_tcp_task_xmit symbol:iscsi_tcp_conn_setup symbol:iscsi_tcp_conn_teardown symbol:iscsi_tcp_r2tpool_alloc symbol:iscsi_tcp_r2tpool_free symbol:iscsi_tcp_set_max_r2t symbol:iscsi_tcp_conn_get_stats
libiscsi

kernel/drivers/scsi/st.ko.xz scsi:t_0x01* char_major_9_*

kernel/drivers/scsi/libiscsi.ko.xz symbol:iscsi_conn_queue_xmit symbol:iscsi_conn_queue_recv symbol:iscsi_update_cmdsn symbol:iscsi_prep_data_out_pdu symbol:iscsi_get_task symbol:__iscsi_put_task symbol:iscsi_put_task symbol:iscsi_complete_scsi_task symbol:iscsi_conn_send_pdu symbol:iscsi_itt_to_task symbol:__iscsi_complete_pdu symbol:iscsi_complete_pdu symbol:iscsi_verify_itt symbol:iscsi_itt_to_ctask symbol:iscsi_session_failure symbol:iscsi_conn_failure symbol:iscsi_requeue_task symbol:iscsi_queuecommand symbol:iscsi_target_alloc symbol:iscsi_suspend_queue symbol:iscsi_suspend_tx symbol:iscsi_suspend_rx symbol:iscsi_eh_cmd_timed_out symbol:iscsi_conn_unbind symbol:iscsi_eh_abort symbol:iscsi_eh_device_reset symbol:iscsi_session_recovery_timedout symbol:iscsi_eh_session_reset symbol:iscsi_eh_recover_target symbol:iscsi_pool_init symbol:iscsi_pool_free symbol:iscsi_host_get_max_scsi_cmds symbol:iscsi_host_add symbol:iscsi_host_alloc symbol:iscsi_host_remove symbol:iscsi_host_free symbol:iscsi_session_setup symbol:iscsi_session_remove symbol:iscsi_session_free symbol:iscsi_session_teardown symbol:iscsi_conn_setup symbol:iscsi_conn_teardown symbol:iscsi_conn_start symbol:iscsi_conn_stop symbol:iscsi_conn_bind symbol:iscsi_switch_str_param symbol:iscsi_set_param symbol:iscsi_session_get_param symbol:iscsi_conn_get_addr_param symbol:iscsi_conn_get_param symbol:iscsi_host_get_param symbol:iscsi_host_set_param

kernel/drivers/scsi/iscsi_boot_sysfs.ko.xz symbol:iscsi_boot_create_target symbol:iscsi_boot_create_initiator symbol:iscsi_boot_create_ethernet symbol:iscsi_boot_create_acpitbl symbol:iscsi_boot_create_kset symbol:iscsi_boot_create_host_kset symbol:iscsi_boot_destroy_kset

kernel/drivers/scsi/sg.ko.xz char_major_21_*

kernel/drivers/scsi/iscsi_tcp.ko.xz
libiscsi_tcp libiscsi

kernel/drivers/media/common/videobuf2/videobuf2-memops.ko.xz symbol:vb2_create_framevec symbol:vb2_destroy_framevec symbol:vb2_common_vm_ops
videobuf2_common

kernel/drivers/media/common/videobuf2/videobuf2-dma-sg.ko.xz symbol:vb2_dma_sg_memops
videobuf2_memops videobuf2_common

kernel/drivers/media/common/videobuf2/videobuf2-common.ko.xz symbol:vb2_buffer_in_use symbol:vb2_core_querybuf symbol:vb2_verify_memory_type symbol:vb2_core_reqbufs symbol:vb2_core_create_bufs symbol:vb2_plane_vaddr symbol:vb2_plane_cookie symbol:vb2_buffer_done symbol:vb2_discard_done symbol:vb2_request_object_is_buffer symbol:vb2_request_buffer_cnt symbol:vb2_core_prepare_buf symbol:vb2_core_remove_bufs symbol:vb2_core_qbuf symbol:vb2_wait_for_all_buffers symbol:vb2_core_dqbuf symbol:vb2_core_streamon symbol:vb2_queue_error symbol:vb2_core_streamoff symbol:vb2_core_expbuf_dmabuf symbol:vb2_core_expbuf symbol:vb2_mmap symbol:vb2_core_queue_init symbol:vb2_core_queue_release symbol:vb2_core_poll symbol:vb2_read symbol:vb2_write symbol:vb2_thread_start symbol:vb2_thread_stop symbol:get_vaddr_frames symbol:put_vaddr_frames symbol:frame_vector_to_pages symbol:frame_vector_to_pfns symbol:frame_vector_create symbol:frame_vector_destroy symbol:__tracepoint_vb2_buf_done symbol:__traceiter_vb2_buf_done symbol:__SCK__tp_func_vb2_buf_done symbol:__tracepoint_vb2_buf_queue symbol:__traceiter_vb2_buf_queue symbol:__SCK__tp_func_vb2_buf_queue symbol:__tracepoint_vb2_dqbuf symbol:__traceiter_vb2_dqbuf symbol:__SCK__tp_func_vb2_dqbuf symbol:__tracepoint_vb2_qbuf symbol:__traceiter_vb2_qbuf symbol:__SCK__tp_func_vb2_qbuf
mc

kernel/drivers/media/common/videobuf2/videobuf2-v4l2.ko.xz symbol:vb2_find_buffer symbol:vb2_querybuf symbol:vb2_reqbufs symbol:vb2_prepare_buf symbol:vb2_create_bufs symbol:vb2_qbuf symbol:vb2_dqbuf symbol:vb2_streamon symbol:vb2_streamoff symbol:vb2_expbuf symbol:vb2_queue_init_name symbol:vb2_queue_init symbol:vb2_queue_release symbol:vb2_queue_change_type symbol:vb2_poll symbol:vb2_ioctl_remove_bufs symbol:vb2_ioctl_reqbufs symbol:vb2_ioctl_create_bufs symbol:vb2_ioctl_prepare_buf symbol:vb2_ioctl_querybuf symbol:vb2_ioctl_qbuf symbol:vb2_ioctl_dqbuf symbol:vb2_ioctl_streamon symbol:vb2_ioctl_streamoff symbol:vb2_ioctl_expbuf symbol:vb2_fop_mmap symbol:_vb2_fop_release symbol:vb2_fop_release symbol:vb2_fop_write symbol:vb2_fop_read symbol:vb2_fop_poll symbol:vb2_video_unregister_device symbol:vb2_ops_wait_prepare symbol:vb2_ops_wait_finish symbol:vb2_request_validate symbol:vb2_request_queue
videobuf2_common videodev mc

kernel/drivers/media/common/videobuf2/videobuf2-vmalloc.ko.xz symbol:vb2_vmalloc_memops
videobuf2_memops videobuf2_common

kernel/drivers/media/common/videobuf2/videobuf2-dma-contig.ko.xz symbol:vb2_dma_contig_memops symbol:vb2_dma_contig_set_max_seg_size
videobuf2_memops videobuf2_common

kernel/drivers/media/common/cypress_firmware.ko.xz symbol:cypress_load_firmware

kernel/drivers/media/common/cx2341x.ko.xz symbol:cx2341x_mpeg_ctrls symbol:cx2341x_ctrl_query symbol:cx2341x_ctrl_get_menu symbol:cx2341x_ext_ctrls symbol:cx2341x_fill_defaults symbol:cx2341x_update symbol:cx2341x_log_status symbol:cx2341x_handler_init symbol:cx2341x_handler_set_50hz symbol:cx2341x_handler_setup symbol:cx2341x_handler_set_busy
videodev

kernel/drivers/media/common/tveeprom.ko.xz symbol:tveeprom_hauppauge_analog symbol:tveeprom_read

kernel/drivers/media/common/v4l2-tpg/v4l2-tpg.ko.xz symbol:tpg_pattern_strings symbol:tpg_aspect_strings symbol:tpg_set_font symbol:tpg_init symbol:tpg_alloc symbol:tpg_free symbol:tpg_s_fourcc symbol:tpg_s_crop_compose symbol:tpg_reset_source symbol:tpg_g_interleaved_plane symbol:tpg_gen_text symbol:tpg_g_color_order symbol:tpg_update_mv_step symbol:tpg_calc_text_basep symbol:tpg_log_status symbol:tpg_fill_plane_buffer symbol:tpg_fillbuffer

kernel/drivers/media/common/b2c2/b2c2-flexcop.ko.xz symbol:b2c2_flexcop_debug symbol:flexcop_pass_dmx_data symbol:flexcop_pass_dmx_packets symbol:flexcop_device_kmalloc symbol:flexcop_device_kfree symbol:flexcop_device_initialize symbol:flexcop_device_exit symbol:flexcop_i2c_request symbol:flexcop_sram_set_dest symbol:flexcop_wan_set_speed symbol:flexcop_sram_ctrl symbol:flexcop_eeprom_check_mac_addr symbol:flexcop_dump_reg symbol:flexcop_pid_feed_control
dvb_core cx24123 cx24113 s5h1420

kernel/drivers/media/common/uvc.ko.xz symbol:uvc_format_by_guid

kernel/drivers/media/common/siano/smsdvb.ko.xz
dvb_core mc smsmdtv

kernel/drivers/media/common/siano/smsmdtv.ko.xz symbol:smscore_translate_msg symbol:smscore_set_board_id symbol:smscore_get_board_id symbol:smscore_registry_getmode symbol:smscore_register_hotplug symbol:smscore_unregister_hotplug symbol:smscore_register_device symbol:smscore_start_device symbol:smscore_unregister_device symbol:smscore_get_device_mode symbol:smscore_onresponse symbol:smscore_getbuffer symbol:smscore_putbuffer symbol:smscore_register_client symbol:smscore_unregister_client symbol:smsclient_sendrequest symbol:sms_get_board symbol:sms_board_event symbol:sms_board_setup symbol:sms_board_power symbol:sms_board_led_feedback symbol:sms_board_lna_control symbol:sms_board_load_modules symbol:smsendian_handle_tx_message symbol:smsendian_handle_rx_message symbol:smsendian_handle_message_header

kernel/drivers/media/common/ttpci-eeprom.ko.xz symbol:ttpci_eeprom_decode_mac symbol:ttpci_eeprom_parse_mac

kernel/drivers/media/dvb-frontends/lnbp22.ko.xz symbol:lnbp22_attach

kernel/drivers/media/dvb-frontends/zl10353.ko.xz symbol:zl10353_attach

kernel/drivers/media/dvb-frontends/tda10086.ko.xz symbol:tda10086_attach

kernel/drivers/media/dvb-frontends/a8293.ko.xz i2c:a8293

kernel/drivers/media/dvb-frontends/zl10036.ko.xz symbol:zl10036_attach

kernel/drivers/media/dvb-frontends/isl6423.ko.xz symbol:isl6423_attach

kernel/drivers/media/dvb-frontends/stv090x.ko.xz i2c:stv090x symbol:stv090x_attach

kernel/drivers/media/dvb-frontends/dvb-pll.ko.xz i2c:tda665x_earthpt1 i2c:tua6034_friio i2c:dtt7520x i2c:tdee4 i2c:tbmu24112 i2c:tbdu18132 i2c:tdtc9251dh0 i2c:dtos403ih102a i2c:opera1 i2c:sd1878_tda8261 i2c:tbmv i2c:tdhu2 i2c:tded4 i2c:tda665x i2c:tua6034 i2c:env57h1xd5 i2c:tua6010xs i2c:unknown_1 i2c:z201 i2c:dtt759x i2c:dtt7579 symbol:dvb_pll_attach

kernel/drivers/media/dvb-frontends/stv0900.ko.xz symbol:stv0900_attach

kernel/drivers/media/dvb-frontends/af9033.ko.xz i2c:af9033
regmap_i2c

kernel/drivers/media/dvb-frontends/cx24113.ko.xz symbol:cx24113_agc_callback symbol:cx24113_attach

kernel/drivers/media/dvb-frontends/cxd2820r.ko.xz i2c:cxd2820r symbol:cxd2820r_attach
regmap_i2c

kernel/drivers/media/dvb-frontends/au8522_common.ko.xz symbol:au8522_writereg symbol:au8522_readreg symbol:au8522_i2c_gate_ctrl symbol:au8522_analog_i2c_gate_ctrl symbol:au8522_get_state symbol:au8522_release_state symbol:au8522_led_ctrl symbol:au8522_init symbol:au8522_sleep

kernel/drivers/media/dvb-frontends/lgs8gl5.ko.xz symbol:lgs8gl5_attach

kernel/drivers/media/dvb-frontends/ascot2e.ko.xz symbol:ascot2e_attach

kernel/drivers/media/dvb-frontends/cx22702.ko.xz symbol:cx22702_attach

kernel/drivers/media/dvb-frontends/lnbp21.ko.xz symbol:lnbh24_attach symbol:lnbp21_attach

kernel/drivers/media/dvb-frontends/cxd2099.ko.xz i2c:cxd2099
regmap_i2c

kernel/drivers/media/dvb-frontends/lgdt330x.ko.xz i2c:lgdt330x symbol:lgdt330x_attach

kernel/drivers/media/dvb-frontends/drxd.ko.xz symbol:drxd_attach

kernel/drivers/media/dvb-frontends/dib3000mb.ko.xz symbol:dib3000mb_attach

kernel/drivers/media/dvb-frontends/drxk.ko.xz symbol:drxk_attach

kernel/drivers/media/dvb-frontends/sp2.ko.xz i2c:sp2
dvb_core

kernel/drivers/media/dvb-frontends/mt352.ko.xz symbol:mt352_attach

kernel/drivers/media/dvb-frontends/tc90522.ko.xz i2c:tc90522ter i2c:tc90522sat

kernel/drivers/media/dvb-frontends/nxt6000.ko.xz symbol:nxt6000_attach

kernel/drivers/media/dvb-frontends/stv6111.ko.xz symbol:stv6111_attach

kernel/drivers/media/dvb-frontends/rtl2832_sdr.ko.xz
videodev videobuf2_common videobuf2_vmalloc videobuf2_v4l2

kernel/drivers/media/dvb-frontends/drx39xyj/drx39xyj.ko.xz symbol:drx39xxj_attach

kernel/drivers/media/dvb-frontends/itd1000.ko.xz symbol:itd1000_attach

kernel/drivers/media/dvb-frontends/ec100.ko.xz symbol:ec100_attach

kernel/drivers/media/dvb-frontends/au8522_dig.ko.xz symbol:au8522_attach
au8522_common

kernel/drivers/media/dvb-frontends/lgs8gxx.ko.xz symbol:lgs8gxx_attach

kernel/drivers/media/dvb-frontends/sp887x.ko.xz symbol:sp887x_attach

kernel/drivers/media/dvb-frontends/s5h1432.ko.xz symbol:s5h1432_attach

kernel/drivers/media/dvb-frontends/gp8psk-fe.ko.xz symbol:gp8psk_fe_attach

kernel/drivers/media/dvb-frontends/tda10048.ko.xz symbol:tda10048_attach

kernel/drivers/media/dvb-frontends/dib8000.ko.xz symbol:dib8000_attach
dibx000_common dvb_core

kernel/drivers/media/dvb-frontends/si21xx.ko.xz symbol:si21xx_attach

kernel/drivers/media/dvb-frontends/ves1820.ko.xz symbol:ves1820_attach

kernel/drivers/media/dvb-frontends/af9013.ko.xz i2c:af9013
i2c_mux

kernel/drivers/media/dvb-frontends/stv0299.ko.xz symbol:stv0299_attach
dvb_core

kernel/drivers/media/dvb-frontends/isl6421.ko.xz symbol:isl6421_attach

kernel/drivers/media/dvb-frontends/m88ds3103.ko.xz i2c:m88ds3103b i2c:m88rs6000 i2c:m88ds3103 symbol:m88ds3103_get_agc_pwm symbol:m88ds3103_attach
i2c_mux regmap_i2c

kernel/drivers/media/dvb-frontends/cx24117.ko.xz symbol:cx24117_attach

kernel/drivers/media/dvb-frontends/stv0288.ko.xz symbol:stv0288_attach

kernel/drivers/media/dvb-frontends/lgdt3306a.ko.xz i2c:lgdt3306a symbol:lgdt3306a_attach
i2c_mux

kernel/drivers/media/dvb-frontends/cxd2841er.ko.xz symbol:cxd2841er_attach_s symbol:cxd2841er_attach_t_c

kernel/drivers/media/dvb-frontends/mn88472.ko.xz i2c:mn88472
regmap_i2c

kernel/drivers/media/dvb-frontends/stv0367.ko.xz symbol:stv0367ter_attach symbol:stv0367cab_attach symbol:stv0367ddb_attach

kernel/drivers/media/dvb-frontends/lnbh25.ko.xz symbol:lnbh25_attach

kernel/drivers/media/dvb-frontends/stv0910.ko.xz symbol:stv0910_attach

kernel/drivers/media/dvb-frontends/stv0297.ko.xz symbol:stv0297_attach

kernel/drivers/media/dvb-frontends/tda10021.ko.xz symbol:tda10021_attach

kernel/drivers/media/dvb-frontends/si2168.ko.xz i2c:si2168
i2c_mux

kernel/drivers/media/dvb-frontends/ts2020.ko.xz i2c:ts2022 i2c:ts2020 symbol:ts2020_attach
regmap_i2c

kernel/drivers/media/dvb-frontends/dib0090.ko.xz symbol:dib0090_dcc_freq symbol:dib0090_pwm_gain_reset symbol:dib0090_set_dc_servo symbol:dib0090_gain_control symbol:dib0090_get_current_gain symbol:dib0090_get_wbd_target symbol:dib0090_get_wbd_offset symbol:dib0090_set_switch symbol:dib0090_set_vga symbol:dib0090_update_rframp_7090 symbol:dib0090_update_tuning_table_7090 symbol:dib0090_get_tune_state symbol:dib0090_set_tune_state symbol:dib0090_register symbol:dib0090_fw_register

kernel/drivers/media/dvb-frontends/l64781.ko.xz symbol:l64781_attach

kernel/drivers/media/dvb-frontends/lgdt3305.ko.xz symbol:lgdt3305_attach

kernel/drivers/media/dvb-frontends/mn88473.ko.xz i2c:mn88473
regmap_i2c

kernel/drivers/media/dvb-frontends/or51211.ko.xz symbol:or51211_attach

kernel/drivers/media/dvb-frontends/cx24123.ko.xz symbol:cx24123_get_tuner_i2c_adapter symbol:cx24123_attach

kernel/drivers/media/dvb-frontends/cxd2880/cxd2880.ko.xz symbol:cxd2880_attach

kernel/drivers/media/dvb-frontends/s5h1420.ko.xz symbol:s5h1420_get_tuner_i2c_adapter symbol:s5h1420_attach

kernel/drivers/media/dvb-frontends/mb86a16.ko.xz symbol:mb86a16_attach

kernel/drivers/media/dvb-frontends/tda10071.ko.xz i2c:tda10071_cx24118
regmap_i2c

kernel/drivers/media/dvb-frontends/tda10023.ko.xz symbol:tda10023_attach

kernel/drivers/media/dvb-frontends/dib3000mc.ko.xz symbol:dib3000mc_get_tuner_i2c_master symbol:dib3000mc_pid_control symbol:dib3000mc_pid_parse symbol:dib3000mc_set_config symbol:dib3000mc_i2c_enumeration symbol:dib3000mc_attach
dibx000_common

kernel/drivers/media/dvb-frontends/ves1x93.ko.xz symbol:ves1x93_attach

kernel/drivers/media/dvb-frontends/stb6100.ko.xz symbol:stb6100_attach

kernel/drivers/media/dvb-frontends/mxl692.ko.xz i2c:mxl692

kernel/drivers/media/dvb-frontends/stb6000.ko.xz symbol:stb6000_attach

kernel/drivers/media/dvb-frontends/horus3a.ko.xz symbol:horus3a_attach

kernel/drivers/media/dvb-frontends/helene.ko.xz i2c:helene symbol:helene_attach_s symbol:helene_attach

kernel/drivers/media/dvb-frontends/atbm8830.ko.xz symbol:atbm8830_attach

kernel/drivers/media/dvb-frontends/zl10039.ko.xz symbol:zl10039_attach

kernel/drivers/media/dvb-frontends/rtl2832.ko.xz i2c:rtl2832
i2c_mux regmap_i2c

kernel/drivers/media/dvb-frontends/mt312.ko.xz symbol:mt312_attach

kernel/drivers/media/dvb-frontends/si2165.ko.xz i2c:si2165
regmap_i2c

kernel/drivers/media/dvb-frontends/tda826x.ko.xz symbol:tda826x_attach

kernel/drivers/media/dvb-frontends/dib0070.ko.xz symbol:dib0070_ctrl_agc_filter symbol:dib0070_get_rf_output symbol:dib0070_set_rf_output symbol:dib0070_wbd_offset symbol:dib0070_attach

kernel/drivers/media/dvb-frontends/rtl2830.ko.xz i2c:rtl2830
i2c_mux

kernel/drivers/media/dvb-frontends/s5h1409.ko.xz symbol:s5h1409_attach

kernel/drivers/media/dvb-frontends/dib7000p.ko.xz symbol:dib7000p_attach
dibx000_common

kernel/drivers/media/dvb-frontends/lg2160.ko.xz symbol:lg2160_attach

kernel/drivers/media/dvb-frontends/as102_fe.ko.xz symbol:as102_attach

kernel/drivers/media/dvb-frontends/bcm3510.ko.xz symbol:bcm3510_attach

kernel/drivers/media/dvb-frontends/stb0899.ko.xz symbol:stb0899_attach

kernel/drivers/media/dvb-frontends/ds3000.ko.xz symbol:ds3000_attach

kernel/drivers/media/dvb-frontends/cx22700.ko.xz symbol:cx22700_attach

kernel/drivers/media/dvb-frontends/cx24110.ko.xz symbol:cx24110_attach

kernel/drivers/media/dvb-frontends/tda665x.ko.xz symbol:tda665x_attach

kernel/drivers/media/dvb-frontends/s921.ko.xz symbol:s921_attach

kernel/drivers/media/dvb-frontends/dib7000m.ko.xz symbol:dib7000m_get_i2c_master symbol:dib7000m_pid_filter_ctrl symbol:dib7000m_pid_filter symbol:dib7000m_attach
dibx000_common

kernel/drivers/media/dvb-frontends/isl6405.ko.xz symbol:isl6405_attach

kernel/drivers/media/dvb-frontends/lnbh29.ko.xz symbol:lnbh29_attach

kernel/drivers/media/dvb-frontends/mn88443x.ko.xz of:N*T*Csocionext,mn884434_1C* of:N*T*Csocionext,mn884434_1 of:N*T*Csocionext,mn884434_0C* of:N*T*Csocionext,mn884434_0 of:N*T*Csocionext,mn884433C* of:N*T*Csocionext,mn884433 i2c:mn884434_1 i2c:mn884434_0 i2c:mn884433
regmap_i2c

kernel/drivers/media/dvb-frontends/or51132.ko.xz symbol:or51132_attach

kernel/drivers/media/dvb-frontends/stv6110x.ko.xz i2c:stv6110x symbol:stv6110x_attach

kernel/drivers/media/dvb-frontends/s5h1411.ko.xz symbol:s5h1411_attach

kernel/drivers/media/dvb-frontends/tda1004x.ko.xz symbol:tda10045_attach symbol:tda10046_attach

kernel/drivers/media/dvb-frontends/tda18271c2dd.ko.xz symbol:tda18271c2dd_attach

kernel/drivers/media/dvb-frontends/stv6110.ko.xz symbol:stv6110_attach

kernel/drivers/media/dvb-frontends/dibx000_common.ko.xz symbol:dibx000_i2c_set_speed symbol:dibx000_get_i2c_adapter symbol:dibx000_reset_i2c_master symbol:dibx000_init_i2c_master symbol:dibx000_exit_i2c_master

kernel/drivers/media/dvb-frontends/dib9000.ko.xz symbol:dib9000_fw_set_component_bus_speed symbol:dib9000_get_tuner_interface symbol:dib9000_get_component_bus_interface symbol:dib9000_get_i2c_master symbol:dib9000_set_i2c_adapter symbol:dib9000_set_gpio symbol:dib9000_fw_pid_filter_ctrl symbol:dib9000_fw_pid_filter symbol:dib9000_firmware_post_pll_init symbol:dib9000_i2c_enumeration symbol:dib9000_set_slave_frontend symbol:dib9000_get_slave_frontend symbol:dib9000_attach
dibx000_common dvb_core

kernel/drivers/media/dvb-frontends/tda8261.ko.xz symbol:tda8261_attach

kernel/drivers/media/dvb-frontends/zd1301_demod.ko.xz symbol:zd1301_demod_get_dvb_frontend symbol:zd1301_demod_get_i2c_adapter

kernel/drivers/media/dvb-frontends/au8522_decoder.ko.xz i2c:au8522
videodev au8522_common mc

kernel/drivers/media/dvb-frontends/m88rs2000.ko.xz symbol:m88rs2000_attach

kernel/drivers/media/dvb-frontends/mb86a20s.ko.xz symbol:mb86a20s_attach

kernel/drivers/media/dvb-frontends/mxl5xx.ko.xz symbol:mxl5xx_attach

kernel/drivers/media/dvb-frontends/cx24116.ko.xz symbol:cx24116_attach

kernel/drivers/media/dvb-frontends/cx24120.ko.xz symbol:cx24120_attach

kernel/drivers/media/dvb-frontends/tda8083.ko.xz symbol:tda8083_attach

kernel/drivers/media/dvb-frontends/tua6100.ko.xz symbol:tua6100_attach

kernel/drivers/media/dvb-frontends/nxt200x.ko.xz symbol:nxt200x_attach

kernel/drivers/media/dvb-frontends/ix2505v.ko.xz symbol:ix2505v_attach

kernel/drivers/media/mc/mc.ko.xz symbol:media_device_register_entity symbol:media_device_unregister_entity symbol:media_device_init symbol:media_device_cleanup symbol:__media_device_register symbol:media_device_register_entity_notify symbol:media_device_unregister_entity_notify symbol:media_device_unregister symbol:media_device_pci_init symbol:__media_device_usb_init symbol:media_entity_enum_init symbol:media_entity_enum_cleanup symbol:media_entity_pads_init symbol:media_graph_walk_init symbol:media_graph_walk_cleanup symbol:media_graph_walk_start symbol:media_graph_walk_next symbol:__media_pipeline_start symbol:media_pipeline_start symbol:__media_pipeline_stop symbol:media_pipeline_stop symbol:media_pipeline_alloc_start symbol:__media_pipeline_pad_iter_next symbol:media_pipeline_entity_iter_init symbol:media_pipeline_entity_iter_cleanup symbol:__media_pipeline_entity_iter_next symbol:media_get_pad_index symbol:media_create_pad_link symbol:media_create_pad_links symbol:__media_entity_remove_links symbol:media_entity_remove_links symbol:__media_entity_setup_link symbol:media_entity_setup_link symbol:media_entity_find_link symbol:media_pad_remote_pad_first symbol:media_entity_remote_pad_unique symbol:media_pad_remote_pad_unique symbol:media_entity_get_fwnode_pad symbol:media_entity_pipeline symbol:media_pad_pipeline symbol:media_devnode_create symbol:media_devnode_remove symbol:media_create_intf_link symbol:__media_remove_intf_link symbol:media_remove_intf_link symbol:__media_remove_intf_links symbol:media_remove_intf_links symbol:media_create_ancillary_link symbol:__media_entity_next_link symbol:media_request_put symbol:media_request_get_by_fd symbol:media_request_object_find symbol:media_request_object_put symbol:media_request_object_init symbol:media_request_object_bind symbol:media_request_object_unbind symbol:media_request_object_complete symbol:media_request_manual_complete symbol:media_device_usb_allocate symbol:media_device_delete

kernel/drivers/media/platform/bcm2835/bcm2835-unicam-legacy.ko.xz of:N*T*Cbrcm,bcm2835_unicam_legacyC* of:N*T*Cbrcm,bcm2835_unicam_legacy of:N*T*Cbrcm,bcm2835_unicamC* of:N*T*Cbrcm,bcm2835_unicam
videobuf2_v4l2 videodev mc v4l2_async videobuf2_dma_contig videobuf2_common v4l2_dv_timings v4l2_fwnode

kernel/drivers/media/platform/video-mux.ko.xz of:N*T*Cvideo_muxC* of:N*T*Cvideo_mux
videodev v4l2_async mux_core mc v4l2_fwnode

kernel/drivers/media/platform/raspberrypi/pisp_be/pisp-be.ko.xz of:N*T*Craspberrypi,pispbeC* of:N*T*Craspberrypi,pispbe
videobuf2_v4l2 videodev mc videobuf2_dma_contig videobuf2_common

kernel/drivers/media/platform/raspberrypi/rp1_cfe/rp1-cfe.ko.xz of:N*T*Craspberrypi,rp1_cfeC* of:N*T*Craspberrypi,rp1_cfe
videobuf2_v4l2 videodev mc v4l2_async videobuf2_dma_contig videobuf2_common v4l2_fwnode

kernel/drivers/media/platform/raspberrypi/hevc_dec/rpi-hevc-dec.ko.xz of:N*T*Craspberrypi,hevc_decC* of:N*T*Craspberrypi,hevc_dec
v4l2_mem2mem videobuf2_v4l2 videodev mc videobuf2_dma_contig videobuf2_common

kernel/drivers/media/platform/broadcom/bcm2835-unicam.ko.xz of:N*T*Cbrcm,bcm2835_unicam_upstreamC* of:N*T*Cbrcm,bcm2835_unicam_upstream
videobuf2_v4l2 videobuf2_common videodev mc videobuf2_dma_contig v4l2_async v4l2_fwnode

kernel/drivers/media/radio/tef6862.ko.xz i2c:tef6862
videodev

kernel/drivers/media/radio/saa7706h.ko.xz i2c:saa7706h
videodev

kernel/drivers/media/radio/si4713/si4713.ko.xz i2c:si4713 of:N*T*Csilabs,si4713C* of:N*T*Csilabs,si4713
videodev

kernel/drivers/media/radio/si470x/radio-si470x-common.ko.xz symbol:si470x_set_freq symbol:si470x_start symbol:si470x_stop symbol:si470x_ctrl_ops symbol:si470x_viddev_template
videodev

kernel/drivers/media/radio/si470x/radio-si470x-usb.ko.xz usb:v12CFp7111d*dc*dsc*dp*ic03isc00ip00in* usb:v10C5p819Ad*dc*dsc*dp*ic03isc00ip00in* usb:v1B80pD700d*dc*dsc*dp*ic03isc00ip00in* usb:v06E1pA155d*dc*dsc*dp*ic03isc00ip00in* usb:v10C4p818Ad*dc*dsc*dp*ic03isc00ip00in*
radio_si470x_common videodev

kernel/drivers/media/radio/si470x/radio-si470x-i2c.ko.xz i2c:si470x of:N*T*Csilabs,si470xC* of:N*T*Csilabs,si470x
videodev radio_si470x_common

kernel/drivers/media/radio/radio-shark.ko.xz usb:v077Dp627Ad0001dc*dsc*dp*ic03isc*ip*in*
videodev tea575x

kernel/drivers/media/radio/radio-wl1273.ko.xz platform:wl1273_fm_radio
videodev

kernel/drivers/media/radio/radio-mr800.ko.xz usb:v07CApB800d*dc*dsc*dp*ic03isc00ip00in*
videodev

kernel/drivers/media/radio/shark2.ko.xz usb:v077Dp627Ad0010dc*dsc*dp*ic03isc*ip*in* symbol:radio_tea5777_init symbol:radio_tea5777_exit
videodev

kernel/drivers/media/radio/radio-ma901.ko.xz usb:v16C0p05DFd*dc*dsc*dp*ic03isc00ip00in*
videodev

kernel/drivers/media/radio/tea575x.ko.xz symbol:snd_tea575x_set_freq symbol:snd_tea575x_enum_freq_bands symbol:snd_tea575x_g_tuner symbol:snd_tea575x_s_hw_freq_seek symbol:snd_tea575x_hw_init symbol:snd_tea575x_init symbol:snd_tea575x_exit
videodev

kernel/drivers/media/radio/wl128x/fm_drv.ko.xz
videodev st_drv

kernel/drivers/media/radio/radio-keene.ko.xz usb:v046Dp0A0Ed*dc*dsc*dp*ic03isc00ip00in*
videodev

kernel/drivers/media/radio/dsbr100.ko.xz usb:v04B4p1002d*dc*dsc*dp*ic*isc*ip*in*
videodev

kernel/drivers/media/radio/radio-tea5764.ko.xz i2c:radio_tea5764
videodev

kernel/drivers/media/rc/streamzap.ko.xz usb:v0E9Cp0000d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/ir-imon-decoder.ko.xz

kernel/drivers/media/rc/ir_toy.ko.xz usb:v04D8pF58Bd*dc*dsc*dp*ic0Aisc*ip*in* usb:v04D8pFD08d*dc*dsc*dp*ic0Aisc*ip*in*

kernel/drivers/media/rc/redrat3.ko.xz usb:v112Ap0005d*dc*dsc*dp*ic*isc*ip*in* usb:v112Ap0001d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/gpio-ir-recv.ko.xz of:N*T*Cgpio_ir_receiverC* of:N*T*Cgpio_ir_receiver

kernel/drivers/media/rc/ir-sony-decoder.ko.xz

kernel/drivers/media/rc/ir-xmp-decoder.ko.xz

kernel/drivers/media/rc/mceusb.ko.xz usb:v15F4p0135d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3B2d*dc*dsc*dp*ic*isc*ip*in* usb:v03F3p0094d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0259d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB150d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB123d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB151d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB139d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB138d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB131d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB130d*dc*dsc*dp*ic*isc*ip*in* usb:v2596p8042d*dc*dsc*dp*ic*isc*ip*in* usb:v2596p8016d*dc*dsc*dp*ic*isc*ip*in* usb:v2596p8008d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A5d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A1d*dc*dsc*dp*ic*isc*ip*in* usb:v105Ap2000d*dc*dsc*dp*ic*isc*ip*in* usb:v04EBpE004d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp3082d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp3020d*dc*dsc*dp*ic*isc*ip*in* usb:v0FB8p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1019p0F38d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0225d*dc*dsc*dp*ic*isc*ip*in* usb:v1934p0702d*dc*dsc*dp*ic*isc*ip*in* usb:v1934p0602d*dc*dsc*dp*ic*isc*ip*in* usb:v1934p5168d*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE042d*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE03Ed*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE03Cd*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE03Ad*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE018d*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE017d*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE016d*dc*dsc*dp*ic*isc*ip*in* usb:v147ApE015d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00A0d*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep9803d*dc*dsc*dp*ic*isc*ip*in* usb:v1509p9242d*dc*dsc*dp*ic*isc*ip*in* usb:v195Dp7002d*dc*dsc*dp*ic*isc*ip*in* usb:v179Dp0010d*dc*dsc*dp*ic*isc*ip*in* usb:v1784p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v1784p000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1784p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v1784p0007d*dc*dsc*dp*ic*isc*ip*in* usb:v1784p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v1784p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v03EEp2501d*dc*dsc*dp*ic*isc*ip*in* usb:v107Bp3009d*dc*dsc*dp*ic*isc*ip*in* usb:v051CpC001d*dc*dsc*dp*ic*isc*ip*in* usb:v1308pC001d*dc*dsc*dp*ic*isc*ip*in* usb:v1460p9150d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p0357d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p0353d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p0338d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p0334d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p0322d*dc*dsc*dp*ic*isc*ip*in* usb:v0609p031Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0161d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2093d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p2088d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p206Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0815d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0613d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p060Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p060Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p060Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0608d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep006Dd*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/ir-rc6-decoder.ko.xz

kernel/drivers/media/rc/ir-nec-decoder.ko.xz

kernel/drivers/media/rc/ir-sharp-decoder.ko.xz

kernel/drivers/media/rc/imon.ko.xz usb:v15C2p0046d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0045d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0044d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0043d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0042d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0041d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0040d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Fd*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Ed*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Dd*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Cd*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Bd*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p003Ad*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0039d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0038d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0037d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0036d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0035d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2p0034d*dc*dsc*dp*ic*isc*ip*in* usb:v15C2pFFDCd*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/ir-rc5-decoder.ko.xz

kernel/drivers/media/rc/rc-loopback.ko.xz

kernel/drivers/media/rc/iguanair.ko.xz usb:v1781p0938d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/pwm-ir-tx.ko.xz of:N*T*Cnokia,n900_irC* of:N*T*Cnokia,n900_ir of:N*T*Cpwm_ir_txC* of:N*T*Cpwm_ir_tx

kernel/drivers/media/rc/ir-jvc-decoder.ko.xz

kernel/drivers/media/rc/ttusbir.ko.xz usb:v0B48p2003d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/ati_remote.ko.xz usb:v0BC7p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v0BC7p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v0BC7p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0BC7p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v0BC7p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0BC7p0002d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/media/rc/ir-mce_kbd-decoder.ko.xz

kernel/drivers/media/rc/gpio-ir-tx.ko.xz of:N*T*Cgpio_ir_txC* of:N*T*Cgpio_ir_tx

kernel/drivers/media/rc/ir-sanyo-decoder.ko.xz

kernel/drivers/media/cec/core/cec.ko.xz symbol:cec_allocate_adapter symbol:cec_register_adapter symbol:cec_unregister_adapter symbol:cec_delete_adapter symbol:cec_get_edid_phys_addr symbol:cec_fill_conn_info_from_drm symbol:cec_queue_pin_cec_event symbol:cec_queue_pin_hpd_event symbol:cec_queue_pin_5v_event symbol:cec_transmit_done_ts symbol:cec_transmit_attempt_done_ts symbol:cec_transmit_msg symbol:cec_received_msg_ts symbol:cec_s_phys_addr symbol:cec_s_phys_addr_from_edid symbol:cec_s_conn_info symbol:cec_s_log_addrs

kernel/drivers/media/dvb-core/dvb-core.ko.xz symbol:dvb_generic_open symbol:dvb_generic_release symbol:dvb_generic_ioctl symbol:dvb_register_device symbol:dvb_remove_device symbol:dvb_device_get symbol:dvb_unregister_device symbol:dvb_create_media_graph symbol:dvb_register_adapter symbol:dvb_unregister_adapter symbol:dvb_module_probe symbol:dvb_module_release symbol:dvb_dmxdev_init symbol:dvb_dmxdev_release symbol:dvb_dmx_swfilter_packets symbol:dvb_dmx_swfilter symbol:dvb_dmx_swfilter_204 symbol:dvb_dmx_swfilter_raw symbol:dvb_dmx_init symbol:dvb_dmx_release symbol:dvb_ca_en50221_camchange_irq symbol:dvb_ca_en50221_camready_irq symbol:dvb_ca_en50221_frda_irq symbol:dvb_ca_en50221_init symbol:dvb_ca_en50221_release symbol:dvb_frontend_reinitialise symbol:dvb_frontend_sleep_until symbol:dvb_frontend_suspend symbol:dvb_frontend_resume symbol:dvb_register_frontend symbol:dvb_unregister_frontend symbol:dvb_frontend_detach symbol:dvb_net_release symbol:dvb_net_init symbol:dvb_ringbuffer_flush symbol:dvb_ringbuffer_init symbol:dvb_ringbuffer_empty symbol:dvb_ringbuffer_free symbol:dvb_ringbuffer_avail symbol:dvb_ringbuffer_flush_spinlock_wakeup symbol:dvb_ringbuffer_read_user symbol:dvb_ringbuffer_read symbol:dvb_ringbuffer_write symbol:dvb_ringbuffer_write_user
mc

kernel/drivers/media/test-drivers/vivid/vivid.ko.xz
videobuf2_v4l2 videodev v4l2_dv_timings mc cec v4l2_tpg videobuf2_dma_contig videobuf2_common videobuf2_vmalloc

kernel/drivers/media/test-drivers/vicodec/vicodec.ko.xz
v4l2_mem2mem videobuf2_v4l2 videodev mc videobuf2_common videobuf2_vmalloc

kernel/drivers/media/test-drivers/vimc/vimc.ko.xz
videobuf2_v4l2 v4l2_tpg videodev mc videobuf2_dma_contig videobuf2_common videobuf2_vmalloc

kernel/drivers/media/test-drivers/vim2m.ko.xz mem2mem_testdev
mc v4l2_mem2mem videodev videobuf2_vmalloc videobuf2_v4l2 videobuf2_common

kernel/drivers/media/v4l2-core/v4l2-mem2mem.ko.xz symbol:v4l2_m2m_get_vq symbol:v4l2_m2m_next_buf symbol:v4l2_m2m_last_buf symbol:v4l2_m2m_buf_remove symbol:v4l2_m2m_buf_remove_by_buf symbol:v4l2_m2m_buf_remove_by_idx symbol:v4l2_m2m_get_curr_priv symbol:v4l2_m2m_try_schedule symbol:v4l2_m2m_job_finish symbol:v4l2_m2m_buf_done_and_job_finish symbol:v4l2_m2m_suspend symbol:v4l2_m2m_resume symbol:v4l2_m2m_reqbufs symbol:v4l2_m2m_querybuf symbol:v4l2_m2m_last_buffer_done symbol:v4l2_m2m_update_start_streaming_state symbol:v4l2_m2m_update_stop_streaming_state symbol:v4l2_m2m_qbuf symbol:v4l2_m2m_dqbuf symbol:v4l2_m2m_prepare_buf symbol:v4l2_m2m_create_bufs symbol:v4l2_m2m_expbuf symbol:v4l2_m2m_streamon symbol:v4l2_m2m_streamoff symbol:v4l2_m2m_poll symbol:v4l2_m2m_mmap symbol:v4l2_m2m_unregister_media_controller symbol:v4l2_m2m_register_media_controller symbol:v4l2_m2m_init symbol:v4l2_m2m_release symbol:v4l2_m2m_ctx_init symbol:v4l2_m2m_ctx_release symbol:v4l2_m2m_buf_queue symbol:v4l2_m2m_buf_copy_metadata symbol:v4l2_m2m_request_queue symbol:v4l2_m2m_ioctl_reqbufs symbol:v4l2_m2m_ioctl_create_bufs symbol:v4l2_m2m_ioctl_remove_bufs symbol:v4l2_m2m_ioctl_querybuf symbol:v4l2_m2m_ioctl_qbuf symbol:v4l2_m2m_ioctl_dqbuf symbol:v4l2_m2m_ioctl_prepare_buf symbol:v4l2_m2m_ioctl_expbuf symbol:v4l2_m2m_ioctl_streamon symbol:v4l2_m2m_ioctl_streamoff symbol:v4l2_m2m_ioctl_try_encoder_cmd symbol:v4l2_m2m_ioctl_try_decoder_cmd symbol:v4l2_m2m_encoder_cmd symbol:v4l2_m2m_decoder_cmd symbol:v4l2_m2m_ioctl_encoder_cmd symbol:v4l2_m2m_ioctl_decoder_cmd symbol:v4l2_m2m_ioctl_stateless_try_decoder_cmd symbol:v4l2_m2m_ioctl_stateless_decoder_cmd symbol:v4l2_m2m_fop_mmap symbol:v4l2_m2m_fop_poll
videobuf2_common mc videobuf2_v4l2 videodev

kernel/drivers/media/v4l2-core/tuner.ko.xz i2c:tuner
videodev mc

kernel/drivers/media/v4l2-core/v4l2-async.ko.xz symbol:v4l2_async_nf_init symbol:v4l2_async_subdev_nf_init symbol:v4l2_async_nf_register symbol:v4l2_async_nf_unregister symbol:v4l2_async_nf_cleanup symbol:__v4l2_async_nf_add_fwnode symbol:__v4l2_async_nf_add_fwnode_remote symbol:__v4l2_async_nf_add_i2c symbol:v4l2_async_subdev_endpoint_add symbol:v4l2_async_connection_unique symbol:__v4l2_async_register_subdev symbol:v4l2_async_unregister_subdev
videodev mc

kernel/drivers/media/v4l2-core/v4l2-cci.ko.xz symbol:cci_read symbol:cci_write symbol:cci_update_bits symbol:cci_multi_reg_write symbol:devm_cci_regmap_init_i2c
regmap_i2c

kernel/drivers/media/v4l2-core/v4l2-fwnode.ko.xz symbol:v4l2_fwnode_endpoint_parse symbol:v4l2_fwnode_endpoint_free symbol:v4l2_fwnode_endpoint_alloc_parse symbol:v4l2_fwnode_parse_link symbol:v4l2_fwnode_put_link symbol:v4l2_fwnode_connector_free symbol:v4l2_fwnode_connector_parse symbol:v4l2_fwnode_connector_add_link symbol:v4l2_fwnode_device_parse symbol:v4l2_async_register_subdev_sensor
v4l2_async videodev

kernel/drivers/media/v4l2-core/videodev.ko.xz char_major_81_* symbol:video_device_alloc symbol:video_device_release symbol:video_device_release_empty symbol:video_devdata symbol:v4l2_prio_init symbol:v4l2_prio_change symbol:v4l2_prio_open symbol:v4l2_prio_close symbol:v4l2_prio_max symbol:v4l2_prio_check symbol:__video_register_device symbol:video_unregister_device symbol:video_device_pipeline_start symbol:__video_device_pipeline_start symbol:video_device_pipeline_stop symbol:__video_device_pipeline_stop symbol:video_device_pipeline_alloc_start symbol:video_device_pipeline symbol:v4l2_norm_to_name symbol:v4l2_video_std_frame_period symbol:v4l2_video_std_construct symbol:v4l2_field_names symbol:v4l2_type_names symbol:v4l_printk_ioctl symbol:video_ioctl2 symbol:v4l2_device_register symbol:v4l2_device_put symbol:v4l2_device_set_name symbol:v4l2_device_disconnect symbol:v4l2_device_unregister symbol:__v4l2_device_register_subdev symbol:__v4l2_device_register_subdev_nodes symbol:v4l2_device_unregister_subdev symbol:v4l2_fh_init symbol:v4l2_fh_add symbol:v4l2_fh_open symbol:v4l2_fh_del symbol:v4l2_fh_exit symbol:v4l2_fh_release symbol:v4l2_fh_is_singular symbol:v4l2_event_dequeue symbol:v4l2_event_queue symbol:v4l2_event_queue_fh symbol:v4l2_event_pending symbol:v4l2_event_wake_all symbol:v4l2_event_subscribe symbol:v4l2_event_unsubscribe_all symbol:v4l2_event_unsubscribe symbol:v4l2_event_subdev_unsubscribe symbol:v4l2_src_change_event_subscribe symbol:v4l2_src_change_event_subdev_subscribe symbol:v4l2_subdev_call_wrappers symbol:v4l2_subdev_get_fwnode_pad_1_to_1 symbol:v4l2_subdev_link_validate_default symbol:v4l2_subdev_link_validate symbol:v4l2_subdev_has_pad_interdep symbol:__v4l2_subdev_state_alloc symbol:__v4l2_subdev_state_free symbol:__v4l2_subdev_init_finalize symbol:v4l2_subdev_cleanup symbol:__v4l2_subdev_state_get_format symbol:__v4l2_subdev_state_get_crop symbol:__v4l2_subdev_state_get_compose symbol:__v4l2_subdev_state_get_interval symbol:v4l2_subdev_get_fmt symbol:v4l2_subdev_get_frame_interval symbol:v4l2_subdev_set_routing symbol:__v4l2_subdev_next_active_route symbol:v4l2_subdev_set_routing_with_fmt symbol:v4l2_subdev_routing_find_opposite_end symbol:v4l2_subdev_state_get_opposite_stream_format symbol:v4l2_subdev_state_xlate_streams symbol:v4l2_subdev_routing_validate symbol:v4l2_subdev_enable_streams symbol:v4l2_subdev_disable_streams symbol:v4l2_subdev_s_stream_helper symbol:v4l2_subdev_init symbol:v4l2_subdev_notify_event symbol:v4l2_subdev_is_streaming symbol:v4l2_subdev_get_privacy_led symbol:v4l2_subdev_put_privacy_led symbol:v4l2_ctrl_query_fill symbol:v4l_bound_align_image symbol:__v4l2_find_nearest_size symbol:v4l2_g_parm_cap symbol:v4l2_s_parm_cap symbol:v4l2_format_info symbol:v4l2_apply_frmsize_constraints symbol:v4l2_fill_pixfmt_mp symbol:v4l2_fill_pixfmt symbol:v4l2_get_link_freq symbol:v4l2_simplify_fraction symbol:v4l2_fraction_to_interval symbol:v4l2_link_freq_to_bitmap symbol:v4l2_ctrl_type_op_equal symbol:v4l2_ctrl_type_op_init symbol:v4l2_ctrl_type_op_log symbol:v4l2_ctrl_type_op_validate symbol:v4l2_ctrl_notify symbol:v4l2_ctrl_handler_init_class symbol:v4l2_ctrl_handler_free symbol:v4l2_ctrl_find symbol:v4l2_ctrl_new_custom symbol:v4l2_ctrl_new_std symbol:v4l2_ctrl_new_std_menu symbol:v4l2_ctrl_new_std_menu_items symbol:v4l2_ctrl_new_std_compound symbol:v4l2_ctrl_new_int_menu symbol:v4l2_ctrl_add_handler symbol:v4l2_ctrl_radio_filter symbol:v4l2_ctrl_cluster symbol:v4l2_ctrl_auto_cluster symbol:v4l2_ctrl_activate symbol:__v4l2_ctrl_grab symbol:__v4l2_ctrl_handler_setup symbol:v4l2_ctrl_handler_setup symbol:v4l2_ctrl_handler_log_status symbol:v4l2_ctrl_new_fwnode_properties symbol:v4l2_g_ext_ctrls symbol:v4l2_try_ext_ctrls symbol:v4l2_s_ext_ctrls symbol:v4l2_g_ctrl symbol:v4l2_s_ctrl symbol:v4l2_ctrl_g_ctrl symbol:v4l2_ctrl_g_ctrl_int64 symbol:__v4l2_ctrl_s_ctrl symbol:__v4l2_ctrl_s_ctrl_int64 symbol:__v4l2_ctrl_s_ctrl_string symbol:__v4l2_ctrl_s_ctrl_compound symbol:__v4l2_ctrl_modify_range symbol:__v4l2_ctrl_modify_dimensions symbol:v4l2_query_ext_ctrl symbol:v4l2_queryctrl symbol:v4l2_querymenu symbol:v4l2_ctrl_log_status symbol:v4l2_ctrl_subdev_log_status symbol:v4l2_ctrl_replace symbol:v4l2_ctrl_merge symbol:v4l2_ctrl_sub_ev_ops symbol:v4l2_ctrl_subscribe_event symbol:v4l2_ctrl_subdev_subscribe_event symbol:v4l2_ctrl_poll symbol:v4l2_ctrl_request_hdl_find symbol:v4l2_ctrl_request_hdl_ctrl_find symbol:v4l2_ctrl_request_complete symbol:v4l2_ctrl_request_setup symbol:v4l2_ctrl_get_menu symbol:v4l2_ctrl_get_int_menu symbol:v4l2_ctrl_get_name symbol:v4l2_ctrl_fill symbol:v4l2_compat_ioctl32 symbol:v4l2_mc_create_media_graph symbol:v4l_enable_media_source symbol:v4l_disable_media_source symbol:v4l_vb2q_enable_media_source symbol:v4l2_create_fwnode_links_to_pad symbol:v4l2_create_fwnode_links symbol:v4l2_pipeline_pm_get symbol:v4l2_pipeline_pm_put symbol:v4l2_pipeline_link_notify symbol:v4l2_spi_subdev_init symbol:v4l2_spi_new_subdev symbol:__tracepoint_vb2_v4l2_buf_done symbol:__traceiter_vb2_v4l2_buf_done symbol:__SCK__tp_func_vb2_v4l2_buf_done symbol:__tracepoint_vb2_v4l2_buf_queue symbol:__traceiter_vb2_v4l2_buf_queue symbol:__SCK__tp_func_vb2_v4l2_buf_queue symbol:__tracepoint_vb2_v4l2_dqbuf symbol:__traceiter_vb2_v4l2_dqbuf symbol:__SCK__tp_func_vb2_v4l2_dqbuf symbol:__tracepoint_vb2_v4l2_qbuf symbol:__traceiter_vb2_v4l2_qbuf symbol:__SCK__tp_func_vb2_v4l2_qbuf symbol:v4l2_i2c_subdev_set_name symbol:v4l2_i2c_subdev_init symbol:v4l2_i2c_new_subdev_board symbol:v4l2_i2c_new_subdev symbol:v4l2_i2c_subdev_addr symbol:v4l2_i2c_tuner_addrs
mc

kernel/drivers/media/v4l2-core/v4l2-dv-timings.ko.xz symbol:v4l2_dv_timings_presets symbol:v4l2_valid_dv_timings symbol:v4l2_enum_dv_timings_cap symbol:v4l2_find_dv_timings_cap symbol:v4l2_find_dv_timings_cea861_vic symbol:v4l2_match_dv_timings symbol:v4l2_print_dv_timings symbol:v4l2_dv_timings_aspect_ratio symbol:v4l2_calc_timeperframe symbol:v4l2_detect_cvt symbol:v4l2_detect_gtf symbol:v4l2_calc_aspect_ratio symbol:v4l2_hdmi_rx_colorimetry symbol:v4l2_get_edid_phys_addr symbol:v4l2_set_edid_phys_addr symbol:v4l2_phys_addr_for_input symbol:v4l2_phys_addr_validate

kernel/drivers/media/i2c/tc358743.ko.xz i2c:tc358743 of:N*T*Ctoshiba,tc358743C* of:N*T*Ctoshiba,tc358743
cec v4l2_async videodev v4l2_dv_timings mc v4l2_fwnode

kernel/drivers/media/i2c/cs53l32a.ko.xz i2c:cs53l32a
videodev

kernel/drivers/media/i2c/video-i2c.ko.xz i2c:mlx90640 i2c:amg88xx of:N*T*Cmelexis,mlx90640C* of:N*T*Cmelexis,mlx90640 of:N*T*Cpanasonic,amg88xxC* of:N*T*Cpanasonic,amg88xx
videodev regmap_i2c videobuf2_vmalloc videobuf2_v4l2 videobuf2_common

kernel/drivers/media/i2c/tw2804.ko.xz i2c:tw2804
videodev

kernel/drivers/media/i2c/mira220.ko.xz of:N*T*Cams,mira220C* of:N*T*Cams,mira220
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/arducam-pivariety.ko.xz of:N*T*Carducam,arducam_pivarietyC* of:N*T*Carducam,arducam_pivariety
v4l2_async videodev v4l2_fwnode mc

kernel/drivers/media/i2c/arducam_64mp.ko.xz of:N*T*Carducam,64mpC* of:N*T*Carducam,64mp
videodev v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/imx219.ko.xz of:N*T*Csony,imx219C* of:N*T*Csony,imx219
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/msp3400.ko.xz i2c:msp3400
videodev mc

kernel/drivers/media/i2c/mt9v011.ko.xz i2c:mt9v011
videodev mc

kernel/drivers/media/i2c/ak7375.ko.xz of:N*T*Casahi_kasei,ak7375C* of:N*T*Casahi_kasei,ak7375 of:N*T*Casahi_kasei,ak7345C* of:N*T*Casahi_kasei,ak7345
v4l2_async videodev mc

kernel/drivers/media/i2c/imx415.ko.xz of:N*T*Csony,imx415C* of:N*T*Csony,imx415
videodev v4l2_cci v4l2_fwnode mc v4l2_async

kernel/drivers/media/i2c/ov64a40.ko.xz of:N*T*Covti,ov64a40C* of:N*T*Covti,ov64a40
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/ov5647.ko.xz i2c:ov5647 of:N*T*Covti,ov5647C* of:N*T*Covti,ov5647
v4l2_async videodev v4l2_fwnode mc

kernel/drivers/media/i2c/imx477.ko.xz of:N*T*Csony,imx378C* of:N*T*Csony,imx378 of:N*T*Csony,imx477C* of:N*T*Csony,imx477
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/tw9906.ko.xz i2c:tw9906
videodev

kernel/drivers/media/i2c/imx283.ko.xz of:N*T*Csony,imx283C* of:N*T*Csony,imx283
videodev v4l2_cci v4l2_fwnode mc v4l2_async

kernel/drivers/media/i2c/tvp5150.ko.xz i2c:tvp5150 of:N*T*Cti,tvp5150C* of:N*T*Cti,tvp5150
v4l2_fwnode mc v4l2_async videodev regmap_i2c

kernel/drivers/media/i2c/uda1342.ko.xz i2c:uda1342
videodev

kernel/drivers/media/i2c/ov7251.ko.xz of:N*T*Covti,ov7251C* of:N*T*Covti,ov7251 acpi*:INT347E:*
videodev v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/cx25840/cx25840.ko.xz i2c:cx25840
videodev mc

kernel/drivers/media/i2c/dw9807-vcm.ko.xz of:N*T*Cdongwoon,dw9817_vcmC* of:N*T*Cdongwoon,dw9817_vcm of:N*T*Cdongwoon,dw9807_vcmC* of:N*T*Cdongwoon,dw9807_vcm
v4l2_async videodev mc

kernel/drivers/media/i2c/ov2311.ko.xz of:N*T*Covti,ov2311C* of:N*T*Covti,ov2311
v4l2_async videodev v4l2_fwnode mc

kernel/drivers/media/i2c/imx290.ko.xz of:N*T*Csony,imx462llrC* of:N*T*Csony,imx462llr of:N*T*Csony,imx462lqrC* of:N*T*Csony,imx462lqr of:N*T*Csony,imx327lqrC* of:N*T*Csony,imx327lqr of:N*T*Csony,imx290llrC* of:N*T*Csony,imx290llr of:N*T*Csony,imx290lqrC* of:N*T*Csony,imx290lqr of:N*T*Csony,imx290C* of:N*T*Csony,imx290
videodev v4l2_cci v4l2_fwnode mc v4l2_async

kernel/drivers/media/i2c/sony-btf-mpx.ko.xz i2c:sony_btf_mpx
videodev

kernel/drivers/media/i2c/imx335.ko.xz of:N*T*Csony,imx335C* of:N*T*Csony,imx335
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/saa7115.ko.xz i2c:gm7113c i2c:saa7118 i2c:saa7115 i2c:saa7114 i2c:saa7113 i2c:saa7111 i2c:saa7115_auto
videodev mc

kernel/drivers/media/i2c/imx500.ko.xz of:N*T*Csony,imx500C* of:N*T*Csony,imx500 spi:imx500
videodev v4l2_cci v4l2_fwnode mc v4l2_async

kernel/drivers/media/i2c/irs1125.ko.xz of:N*T*Cinfineon,irs1125C* of:N*T*Cinfineon,irs1125
v4l2_async videodev v4l2_fwnode mc

kernel/drivers/media/i2c/bu64754.ko.xz of:N*T*Crohm,bu64754C* of:N*T*Crohm,bu64754
v4l2_cci v4l2_async videodev mc

kernel/drivers/media/i2c/wm8775.ko.xz i2c:wm8775
videodev

kernel/drivers/media/i2c/imx258.ko.xz of:N*T*Csony,imx258_pdafC* of:N*T*Csony,imx258_pdaf of:N*T*Csony,imx258C* of:N*T*Csony,imx258
videodev v4l2_cci v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/adv7180.ko.xz i2c:adv7282_m i2c:adv7282 i2c:adv7281_ma i2c:adv7281_m i2c:adv7281 i2c:adv7280_m i2c:adv7280 i2c:adv7182 i2c:adv7180st i2c:adv7180cp i2c:adv7180 of:N*T*Cadi,adv7282_mC* of:N*T*Cadi,adv7282_m of:N*T*Cadi,adv7282C* of:N*T*Cadi,adv7282 of:N*T*Cadi,adv7281_maC* of:N*T*Cadi,adv7281_ma of:N*T*Cadi,adv7281_mC* of:N*T*Cadi,adv7281_m of:N*T*Cadi,adv7281C* of:N*T*Cadi,adv7281 of:N*T*Cadi,adv7280_mC* of:N*T*Cadi,adv7280_m of:N*T*Cadi,adv7280C* of:N*T*Cadi,adv7280 of:N*T*Cadi,adv7182C* of:N*T*Cadi,adv7182 of:N*T*Cadi,adv7180stC* of:N*T*Cadi,adv7180st of:N*T*Cadi,adv7180cpC* of:N*T*Cadi,adv7180cp of:N*T*Cadi,adv7180C* of:N*T*Cadi,adv7180
videodev v4l2_async mc

kernel/drivers/media/i2c/ov9282.ko.xz of:N*T*Covti,ov9282C* of:N*T*Covti,ov9282 of:N*T*Covti,ov9281C* of:N*T*Covti,ov9281
videodev v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/imx708.ko.xz of:N*T*Csony,imx708C* of:N*T*Csony,imx708
videodev v4l2_async v4l2_fwnode mc

kernel/drivers/media/i2c/tw9903.ko.xz i2c:tw9903
videodev

kernel/drivers/media/i2c/imx296.ko.xz of:N*T*Csony,imx296lqC* of:N*T*Csony,imx296lq of:N*T*Csony,imx296llC* of:N*T*Csony,imx296ll of:N*T*Csony,imx296C* of:N*T*Csony,imx296
videodev v4l2_async regmap_i2c v4l2_fwnode mc

kernel/drivers/media/i2c/ov7640.ko.xz i2c:ov7640
videodev

kernel/drivers/media/i2c/ir-kbd-i2c.ko.xz i2c:ir_z8f0811_hdpvr i2c:ir_z8f0811_haup i2c:ir_video

kernel/drivers/media/i2c/ad5398_vcm.ko.xz i2c:ad5398 of:N*T*Cadi,ad5398C* of:N*T*Cadi,ad5398
v4l2_async videodev mc

kernel/drivers/media/i2c/imx519.ko.xz of:N*T*Csony,imx519C* of:N*T*Csony,imx519
videodev v4l2_async v4l2_fwnode mc

kernel/drivers/media/spi/cxd2880-spi.ko.xz of:N*T*Csony,cxd2880C* of:N*T*Csony,cxd2880 spi:cxd2880
dvb_core

kernel/drivers/media/usb/s2255/s2255drv.ko.xz usb:v1943p2257d*dc*dsc*dp*ic*isc*ip*in* usb:v1943p2255d*dc*dsc*dp*ic*isc*ip*in*
videodev videobuf2_common videobuf2_vmalloc videobuf2_v4l2

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-au6610.ko.xz usb:v058Fp6610d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-af9035.ko.xz usb:v0CCDp10B2d*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp1871d*dc*dsc*dp*ic*isc*ip*in* usb:v048Dp9306d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0262d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2040pF900d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6A05d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0099d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10AEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE410d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE411d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE409d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp0335d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA110d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp4835d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp3835d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp2835d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp1835d*dc*dsc*dp*ic*isc*ip*in* usb:v048Dp9006d*dc*dsc*dp*ic*isc*ip*in* usb:v048Dp9005d*dc*dsc*dp*ic*isc*ip*in* usb:v048Dp9135d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpA115d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp0337d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00AAd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1779d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp0825d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA867d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp1867d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApB835d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA835d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0093d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p9035d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2

kernel/drivers/media/usb/dvb-usb-v2/mxl111sf-demod.ko.xz symbol:mxl111sf_demod_attach

kernel/drivers/media/usb/dvb-usb-v2/dvb_usb_v2.ko.xz symbol:dvb_usbv2_probe symbol:dvb_usbv2_disconnect symbol:dvb_usbv2_suspend symbol:dvb_usbv2_resume symbol:dvb_usbv2_reset_resume symbol:dvb_usbv2_generic_rw symbol:dvb_usbv2_generic_write symbol:dvb_usbv2_generic_rw_locked symbol:dvb_usbv2_generic_write_locked
dvb_core mc

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-rtl28xxu.ko.xz usb:v5654pCA42d*dc*dsc*dp*ic*isc*ip*in* usb:v15F4p0131d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpD803d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3A4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3AFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3B0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD39Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD395d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p707Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpA803d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6A03d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpB803d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD394d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp0650d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp0620d*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p1104d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD393d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3A8d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00D7d*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p1102d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00D3d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6F12d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6F0Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6680d*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p1101d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpC803d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00B4d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00E0d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00B3d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00A9d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp2838d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp2832d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0161d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0160d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp2831d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-lmedm04.ko.xz usb:v3344p22F0d*dc*dsc*dp*ic*isc*ip*in* usb:v3344p1120d*dc*dsc*dp*ic*isc*ip*in* usb:v3344p1122d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2 dvb_core

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-ce6230.ko.xz usb:v07CApA310d*dc*dsc*dp*ic*isc*ip*in* usb:v8086p9500d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-mxl111sf.ko.xz usb:v2040pB767d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB757d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC61Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC61Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC613d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC612d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD8FFd*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD8E4d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD8E3d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD8D4d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD8D3d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD864d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD863d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD854d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD853d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB764d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB763d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB753d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB704d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB703d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB702d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB701d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB700d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC65Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC653d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC60Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC60Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC60Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC609d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC604d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC603d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC602d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC601d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC600d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2 mc tveeprom

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-af9015.ko.xz usb:v1B80pE401d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp9016d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp850Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0099d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0097d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp815Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE39Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE383d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6A04d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE402d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE39Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pC161d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE400d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p4012d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pC810d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE397d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA805d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp850Ad*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p901Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE395d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE39Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE396d*dc*dsc*dp*ic*isc*ip*in* usb:v1462p8807d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA309d*dc*dsc*dp*ic*isc*ip*in* usb:v10B9p8000d*dc*dsc*dp*ic*isc*ip*in* usb:v07CAp8150d*dc*dsc*dp*ic*isc*ip*in* usb:v1462p8801d*dc*dsc*dp*ic*isc*ip*in* usb:v1AE7p0381d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA815d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pC160d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0069d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3237d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3226d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE399d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p022Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6029d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p9016d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p9015d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2 dvb_core

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-gl861.ko.xz usb:v7A69p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v05E3pF170d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p5581d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2 dvb_core

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-az6007.ko.xz usb:v14F7p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A3d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10B4d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p0CCDd*dc*dsc*dp*ic*isc*ip*in*
dvb_core dvb_usb_v2 cypress_firmware

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-dvbsky.ko.xz usb:v0572p689Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0572pC69Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0572pC68Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0572pC699d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pC689d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pC688d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0105d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A5d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3017d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3015d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3012d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3014d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p0320d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p680Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0572p960Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0572p6831d*dc*dsc*dp*ic*isc*ip*in*
m88ds3103 dvb_usb_v2 dvb_core

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-anysee.ko.xz usb:v1C73p861Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p861Fd*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2 dvb_core

kernel/drivers/media/usb/dvb-usb-v2/dvb-usb-ec168.ko.xz usb:v18B4p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v18B4p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v18B4pFFFBd*dc*dsc*dp*ic*isc*ip*in* usb:v18B4pFFFAd*dc*dsc*dp*ic*isc*ip*in* usb:v18B4p1689d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_v2

kernel/drivers/media/usb/dvb-usb-v2/mxl111sf-tuner.ko.xz symbol:mxl111sf_tuner_attach

kernel/drivers/media/usb/uvc/uvcvideo.ko.xz usb:v*p*d*dc*dsc*dp*ic0Eisc01ip01in* usb:v*p*d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p1155d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0B5Cd*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0B5Bd*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0B3Ad*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0B07d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0B03d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0AD4d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0AD3d*dc*dsc*dp*ic0Eisc01ip00in* usb:v8086p0AD2d*dc*dsc*dp*ic0Eisc01ip00in* usb:v2E1Ap4C01d*dc*dsc*dp*ic0Eisc01ip00in* usb:v29FEp4D53d*dc*dsc*dp*ic0Eisc01ip00in* usb:v2833p0211d*dc*dsc*dp*icFFisc01ip00in* usb:v2833p0201d*dc*dsc*dp*ic0Eisc01ip00in* usb:v1FC9p009Bd*dc*dsc*dp*ic0Eisc01ip00in* usb:v1DE1pF105d*dc*dsc*dp*ic0Eisc01ip00in* usb:v1C4Fp3000d*dc*dsc*dp*ic0Eisc01ip00in* usb:v1BCFp0B40d*dc*dsc*dp*ic0Eisc01ip00in* usb:v1B3Fp2002d*dc*dsc*dp*ic0Eisc01ip00in* usb:v1B3Bp2951d*dc*dsc*dp*ic0Eisc01ip00in* usb:v19ABp1000d00*dc*dsc*dp*ic0Eisc01ip00in* usb:v19ABp1000d01[0_1]*dc*dsc*dp*ic0Eisc01ip00in* usb:v19ABp1000d012[0_6]dc*dsc*dp*ic0Eisc01ip00in* usb:v199Ep8102d*dc*dsc*dp*icFFisc01ip00in* usb:v18ECp3290d*dc*dsc*dp*ic0Eisc01ip00in* usb:v18ECp3288d*dc*dsc*dp*ic0Eisc01ip00in* usb:v18ECp3188d*dc*dsc*dp*ic0Eisc01ip00in* usb:v18CDpCAFEd*dc*dsc*dp*ic0Eisc01ip00in* usb:v1871p0516d*dc*dsc*dp*icFFisc01ip00in* usb:v1871p0306d*dc*dsc*dp*ic0Eisc01ip00in* usb:v17EFp480Bd*dc*dsc*dp*ic0Eisc01ip00in* usb:v17DCp0202d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp8A34d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp8A33d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp8A31d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp8A12d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp5931d*dc*dsc*dp*ic0Eisc01ip00in* usb:v174Fp5212d*dc*dsc*dp*ic0Eisc01ip00in* usb:v16D0p0ED1d*dc*dsc*dp*ic0Eisc01ip00in* usb:v152Dp0310d*dc*dsc*dp*ic0Eisc01ip00in* usb:v13D3p5103d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0E8Dp0004d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0C45p6366d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0BD3p0555d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0AC8p3420d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0AC8p3410d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0AC8p332Dd*dc*dsc*dp*ic0Eisc01ip00in* usb:v06F8p300Cd*dc*dsc*dp*ic0Eisc01ip00in* usb:v05E3p0505d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05C8p0403d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05ACp8600d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05ACp8514d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05ACp8501d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05A9p7670d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05A9p264Ad*dc*dsc*dp*ic0Eisc01ip00in* usb:v05A9p2643d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05A9p2641d*dc*dsc*dp*ic0Eisc01ip00in* usb:v05A9p2640d*dc*dsc*dp*ic0Eisc01ip00in* usb:v058Fp3820d*dc*dsc*dp*ic0Eisc01ip00in* usb:v04F2pB071d*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp08D3d*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp089Bd*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp087Cd*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp085Cd*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp082Dd*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp08C7d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp08C6d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp08C5d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp08C3d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp08C2d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp08C1d*dc*dsc*dp*icFFisc01ip00in* usb:v046Dp0823d*dc*dsc*dp*ic0Eisc01ip00in* usb:v046Dp0821d*dc*dsc*dp*ic0Eisc01ip00in* usb:v045Ep0723d*dc*dsc*dp*ic0Eisc01ip00in* usb:v045Ep0721d*dc*dsc*dp*ic0Eisc01ip00in* usb:v045Ep00F8d*dc*dsc*dp*ic0Eisc01ip00in* usb:v0458p706Ed*dc*dsc*dp*ic0Eisc01ip00in* usb:v0416pA91Ad*dc*dsc*dp*ic0Eisc01ip00in* usb:v0408p4035d*dc*dsc*dp*ic0Eisc01ip01in* usb:v0408p4033d*dc*dsc*dp*ic0Eisc01ip01in* usb:v03F0pE207d*dc*dsc*dp*ic0Eisc01ip00in*
videobuf2_v4l2 videodev mc uvc videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/hdpvr/hdpvr.ko.xz usb:v2040p4903d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4982d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4902d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4901d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4900d*dc*dsc*dp*ic*isc*ip*in*
videodev v4l2_dv_timings

kernel/drivers/media/usb/as102/dvb-as102.ko.xz usb:v2137p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0B89p0007d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p002Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0246d*dc*dsc*dp*ic*isc*ip*in* usb:v1BA6p0001d*dc*dsc*dp*ic*isc*ip*in*
dvb_core

kernel/drivers/media/usb/au0828/au0828.ko.xz usb:v2040p7270d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7213d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7260d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p8200d*dc*dsc*dp*ic*isc*ip*in* usb:v05E1p0480d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7281d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7211d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7201d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7280d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p721Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p721Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2040p721Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7217d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7210d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pD620d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7240d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7200d*dc*dsc*dp*ic*isc*ip*in*
videobuf2_v4l2 dvb_core videodev mc tveeprom videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/em28xx/em28xx-alsa.ko.xz
em28xx snd snd_pcm

kernel/drivers/media/usb/em28xx/em28xx-v4l.ko.xz
videobuf2_v4l2 em28xx videodev mc videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/em28xx/em28xx.ko.xz usb:v1B80pE349d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap5051d*dc*dsc*dp*ic*isc*ip*in* usb:v3275p0085d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap8179d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6F07d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p8268d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p8264d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p0264d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0264d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0259d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p8461d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0461d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p8258d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0258d*dc*dsc*dp*ic*isc*ip*in* usb:v1AE7p9004d*dc*dsc*dp*ic*isc*ip*in* usb:v1AE7p9003d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE1CCd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0251d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0242d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp1ABEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE425d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE309d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap5006d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE755d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p1605d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p024Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p024Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE34Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE346d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pA340d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap50A6d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0515d*dc*dsc*dp*ic*isc*ip*in* usb:v093BpA005d*dc*dsc*dp*ic*isc*ip*in* usb:v093BpA003d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6023d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p023Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0227d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0226d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p021Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0208d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0207d*dc*dsc*dp*ic*isc*ip*in* usb:v2001pF112d*dc*dsc*dp*ic*isc*ip*in* usb:v0438pB002d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p846Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p826Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p026Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p8265d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p0265d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p651Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p651Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2040p6517d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p6513d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p6502d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p6500d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4201d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p4200d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp2041d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp2870d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0033d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00B2d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10AFd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0096d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0084d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10B2d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10B6d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10ADd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00ACd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp008Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0043d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0042d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp005Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp004Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp004Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0036d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE304d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE302d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE359d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE357d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2801d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE355d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE350d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE323d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE320d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApA316d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApA313d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE310d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE305d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE303d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE300d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2885d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2875d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2868d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2883d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2881d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2870d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2863d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2862d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2861d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2860d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2821d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2820d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2710d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2800d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2751d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap2750d*dc*dsc*dp*ic*isc*ip*in* symbol:em28xx_read_reg symbol:em28xx_write_regs symbol:em28xx_write_reg symbol:em28xx_write_reg_bits symbol:em28xx_toggle_reg_bits symbol:em28xx_read_ac97 symbol:em28xx_write_ac97 symbol:em28xx_audio_analog_set symbol:em28xx_audio_setup symbol:em28xx_find_led symbol:em28xx_gpio_set symbol:em28xx_set_mode symbol:em28xx_uninit_usb_xfer symbol:em28xx_stop_urbs symbol:em28xx_alloc_urbs symbol:em28xx_init_usb_xfer symbol:em28xx_register_extension symbol:em28xx_unregister_extension symbol:em28xx_boards symbol:em28xx_tuner_callback symbol:em28xx_setup_xc3028 symbol:em28xx_free_device symbol:em28xx_init_camera
mc videodev tveeprom

kernel/drivers/media/usb/em28xx/em28xx-rc.ko.xz
em28xx

kernel/drivers/media/usb/em28xx/em28xx-dvb.ko.xz
em28xx dvb_core

kernel/drivers/media/usb/usbtv/usbtv.ko.xz usb:v1F71p3306d*dc*dsc*dp*ic*isc*ip*in* usb:v1F71p3301d*dc*dsc*dp*ic*isc*ip*in* usb:v1B71p3002d*dc*dsc*dp*ic*isc*ip*in*
videobuf2_v4l2 videodev snd_pcm snd videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/gspca/gspca_xirlink_cit.ko.xz usb:v0545p800Dd030Adc*dsc*dp*ic*isc*ip*in* usb:v0545p800Cd030Adc*dsc*dp*ic*isc*ip*in* usb:v0545p8002d030Adc*dsc*dp*ic*isc*ip*in* usb:v0545p8080d0301dc*dsc*dp*ic*isc*ip*in* usb:v0545p8080d030Adc*dsc*dp*ic*isc*ip*in* usb:v0545p8080d0002dc*dsc*dp*ic*isc*ip*in* usb:v0545p8080d0001dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sn9c20x.ko.xz usb:vA168p0617d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0615d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0614d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0618d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0613d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0611d*dc*dsc*dp*ic*isc*ip*in* usb:vA168p0610d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p704Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0458p704Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7045d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7029d*dc*dsc*dp*ic*isc*ip*in* usb:v145Fp013Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00F4d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p62BCd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p62BBd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p62B3d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p62B0d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p62A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p628Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p628Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p628Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6288d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6282d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6280d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p627Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p627Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p627Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6270d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6260d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6253d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6251d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p624Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p624Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p624Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6248d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6242d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6240d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sq930x.ko.xz usb:v2770p930Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2770p930Bd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4041d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep403Dd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep403Cd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4038d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_finepix.ko.xz usb:v04CBp013Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp013Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp013Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0131d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp012Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp012Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp012Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0129d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0127d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0125d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0123d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0121d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp011Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp011Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0119d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0117d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0115d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0113d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0111d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp010Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp010Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0109d*dc*dsc*dp*ic*isc*ip*in* usb:v04CBp0104d*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_spca505.ko.xz usb:v0733p0430d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep401Dd*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sonixj.ko.xz usb:v0C45p614Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6148d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6143d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6142d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p613Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p613Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p613Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p613Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6138d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6130d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p612Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p612Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p612Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p612Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6128d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p610Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p610Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p610Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p610Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6102d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6100d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60FEd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60FCd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60FBd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60ECd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60CEd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60C0d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p607Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6040d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p3008d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p3004d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0330d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0328d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0327d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00F7d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00F5d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p702Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7025d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_spca500.ko.xz usb:v8086p0630d*dc*dsc*dp*ic*isc*ip*in* usb:v2899p012Cd*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp0103d*dc*dsc*dp*ic*isc*ip*in* usb:v084Dp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v06BEp0800d*dc*dsc*dp*ic*isc*ip*in* usb:v06BDp0404d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC220d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC200d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp7333d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p300Cd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0901d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0900d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0890d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep400Ad*dc*dsc*dp*ic*isc*ip*in* usb:v040Ap0300d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_touptek.ko.xz usb:v0547p6801d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_mars.ko.xz usb:v093Ap050Fd*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_jeilinj.ko.xz usb:v0979p0270d*dc*dsc*dp*ic*isc*ip*in* usb:v0979p0280d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_cpia1.ko.xz usb:v0813p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0553p0002d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_kinect.ko.xz usb:v045Ep02BFd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep02AEd*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_sq905.ko.xz usb:v2770p9120d*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_spca501.ko.xz usb:v1776p501Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0733p0402d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p0401d*dc*dsc*dp*ic*isc*ip*in* usb:v0506p00DFd*dc*dsc*dp*ic*isc*ip*in* usb:v0497pC001d*dc*dsc*dp*ic*isc*ip*in* usb:v040Ap0002d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_topro.ko.xz usb:v06A2p6810d*dc*dsc*dp*ic*isc*ip*in* usb:v06A2p0003d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/m5602/gspca_m5602.ko.xz usb:v0402p5602d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_spca561.ko.xz usb:vABCDpCDEEd*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp7E50d*dc*dsc*dp*ic*isc*ip*in* usb:v060BpA001d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp0561d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Fd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Ed*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Dd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Cd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Bd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp092Ad*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0929d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0928d*dc*dsc*dp*ic*isc*ip*in* usb:v0461p0815d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7004d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep403Bd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep401Ad*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_spca1528.ko.xz usb:v04FCp1528d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_spca508.ko.xz usb:v8086p0110d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF9p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF9p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p0110d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4018d*dc*dsc*dp*ic*isc*ip*in* usb:v0130p0130d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_ov519.ko.xz usb:v8020pEF04d*dc*dsc*dp*ic*isc*ip*in* usb:v1046p9967d*dc*dsc*dp*ic*isc*ip*in* usb:v0E96pC001d*dc*dsc*dp*ic*isc*ip*in* usb:v0B62p0059d*dc*dsc*dp*ic*isc*ip*in* usb:v0813p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9pA518d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9pA511d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p8519d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p4519d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p2800d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p0530d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p0519d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p0518d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p0511d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0155d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0154d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep028Cd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4068d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4067d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4064d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4061d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4060d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep405Fd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4052d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4003d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_tv8532.ko.xz usb:v0923p010Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0545p8333d*dc*dsc*dp*ic*isc*ip*in* usb:v0545p808Bd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0921d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0920d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_jl2005bcd.ko.xz usb:v0979p0227d*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_etoms.ko.xz usb:v102Cp6251d*dc*dsc*dp*ic*isc*ip*in* usb:v102Cp6151d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_dtcs033.ko.xz usb:v0547p7303d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_stk014.ko.xz usb:v05E1p0893d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_ov534.ko.xz usb:v06F8p3002d*dc*dsc*dp*ic*isc*ip*in* usb:v1415p2000d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_stv0680.ko.xz usb:v041Ep4007d*dc*dsc*dp*ic*isc*ip*in* usb:v0553p0202d*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_spca506.ko.xz usb:v99FAp8988d*dc*dsc*dp*ic*isc*ip*in* usb:v0734p043Bd*dc*dsc*dp*ic*isc*ip*in* usb:v06E1pA190d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sn9c2028.ko.xz usb:v0C45p800Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p8008d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p8003d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7003d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7005d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sonixb.ko.xz usb:v0C45p60B0d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60AFd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60AAd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p60A8d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p608Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p608Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6083d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p602Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p602Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p602Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p602Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6029d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6028d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6027d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6025d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6024d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6019d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6011d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p600Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6009d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6007d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6005d*dc*dsc*dp*ic*isc*ip*in* usb:v0C45p6001d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_zc3xx.ko.xz usb:v10FDp8050d*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp804Dd*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp0128d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p307Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p305Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p303Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p301Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p0302d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v0698p2003d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpD004d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpD003d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC005d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p032Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0471p032Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0326d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0325d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08DDd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08DAd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08D9d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08D8d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08D7d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B9d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08AFd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08AEd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08ADd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08ACd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08AAd*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A9d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A7d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A6d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A3d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A2d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A1d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08A0d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp089Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0461p0A00d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p700Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0458p700Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7007d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4053d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4051d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep403Ad*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4036d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4035d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4034d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4029d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4022d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep401Fd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep401Ed*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep401Cd*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4017d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep041Ed*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1B07d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_vicam.ko.xz usb:v0602p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v04C1p009Dd*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sq905c.ko.xz usb:v2770p913Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2770p9052d*dc*dsc*dp*ic*isc*ip*in* usb:v2770p9051d*dc*dsc*dp*ic*isc*ip*in* usb:v2770p9050d*dc*dsc*dp*ic*isc*ip*in* usb:v2770p905Cd*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gl860/gspca_gl860.ko.xz usb:v05E3pF191d*dc*dsc*dp*ic*isc*ip*in* usb:v05E3p0503d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_sunplus.ko.xz usb:v0D64p0303d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2060d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2050d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2042d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2040d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2028d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2024d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2022d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2020d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2018d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2016d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2010d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp2008d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp0106d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp0104d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p3281d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p3261d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p2221d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p2211d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p1314d*dc*dsc*dp*ic*isc*ip*in* usb:v0733p1311d*dc*dsc*dp*ic*isc*ip*in* usb:v06D6p0041d*dc*dsc*dp*ic*isc*ip*in* usb:v06D6p0031d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp1018d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC650d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC630d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC540d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC530d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC520d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC440d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC430d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC420d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC360d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC232d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC230d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpC211d*dc*dsc*dp*ic*isc*ip*in* usb:v0546p3273d*dc*dsc*dp*ic*isc*ip*in* usb:v0546p3191d*dc*dsc*dp*ic*isc*ip*in* usb:v0546p3155d*dc*dsc*dp*ic*isc*ip*in* usb:v052Bp1803d*dc*dsc*dp*ic*isc*ip*in* usb:v052Bp1513d*dc*dsc*dp*ic*isc*ip*in* usb:v052Bp1507d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCpFFFFd*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp5360d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp5330d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp504Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp504Ad*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp500Cd*dc*dsc*dp*ic*isc*ip*in* usb:v04F1p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p300Ad*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p3008d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p3003d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0322d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0960d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0905d*dc*dsc*dp*ic*isc*ip*in* usb:v0461p0821d*dc*dsc*dp*ic*isc*ip*in* usb:v0458p7006d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4013d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4012d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep400Bd*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_conex.ko.xz usb:v0572p0041d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_mr97310a.ko.xz usb:v093Ap010Ed*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap010Fd*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp0111d*dc*dsc*dp*ic*isc*ip*in* usb:v08CAp0110d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_konica.ko.xz usb:v04C8p0720d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_ov534_9.ko.xz usb:v05A9p1550d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p3003d*dc*dsc*dp*ic*isc*ip*in* usb:v05A9p8065d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_pac207.ko.xz usb:v2001pF115d*dc*dsc*dp*ic*isc*ip*in* usb:v145Fp013Ad*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2476d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2474d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2472d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2471d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2470d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2468d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2464d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2463d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2461d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2460d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4028d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_main.ko.xz symbol:gspca_debug symbol:gspca_frame_add symbol:gspca_dev_probe2 symbol:gspca_dev_probe symbol:gspca_disconnect symbol:gspca_suspend symbol:gspca_resume symbol:gspca_expo_autogain symbol:gspca_coarse_grained_expo_autogain
videobuf2_v4l2 videodev videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/gspca/gspca_t613.ko.xz usb:v17A1p0128d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_benq.ko.xz usb:v04A5p3035d*dc*dsc*dp*ic*isc*ip*in*
gspca_main

kernel/drivers/media/usb/gspca/gspca_stk1135.ko.xz usb:v174Fp6A31d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_se401.ko.xz usb:v047Dp5003d*dc*dsc*dp*ic*isc*ip*in* usb:v047Dp5002d*dc*dsc*dp*ic*isc*ip*in* usb:v047Dp5001d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p030Bd*dc*dsc*dp*ic*isc*ip*in* usb:v03E8p0004d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_nw80x.ko.xz usb:v0728pD001d*dc*dsc*dp*ic*isc*ip*in* usb:v06BEpD001d*dc*dsc*dp*ic*isc*ip*in* usb:v06A5pD800d*dc*dsc*dp*ic*isc*ip*in* usb:v06A5pD001d*dc*dsc*dp*ic*isc*ip*in* usb:v06A5p0000d*dc*dsc*dp*ic*isc*ip*in* usb:v055FpD001d*dc*dsc*dp*ic*isc*ip*in* usb:v052BpD001d*dc*dsc*dp*ic*isc*ip*in* usb:v0502pD001d*dc*dsc*dp*ic*isc*ip*in* usb:v046DpD001d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_pac7302.ko.xz usb:v1AE7p2001d*dc*dsc*dp*ic*isc*ip*in* usb:v145Fp013Cd*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap262Cd*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap262Ad*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2629d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2628d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2627d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2626d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2625d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2624d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2623d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2622d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2621d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2620d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p301Bd*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p3009d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_pac7311.ko.xz usb:v093Ap260Fd*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap260Ed*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2608d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2603d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2601d*dc*dsc*dp*ic*isc*ip*in* usb:v093Ap2600d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/stv06xx/gspca_stv06xx.ko.xz usb:v046Dp08F6d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08F5d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08F0d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0870d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0850d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0840d*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/gspca/gspca_vc032x.ko.xz usb:v17EFp4802d*dc*dsc*dp*ic*isc*ip*in* usb:v15B8p6002d*dc*dsc*dp*ic*isc*ip*in* usb:v15B8p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8pC301d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8pC002d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8pC001d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p0328d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p0323d*dc*dsc*dp*ic*isc*ip*in* usb:v0AC8p0321d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0897d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0896d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp0892d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep405Bd*dc*dsc*dp*ic*isc*ip*in*
videodev gspca_main

kernel/drivers/media/usb/dvb-usb/dvb-usb-nova-t-usb2.ko.xz usb:v2040p9301d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p9300d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_dibusb_common dvb_usb_dibusb_mc_common dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-cinergyT2.ko.xz usb:v0CCDp0038d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-m920x.ko.xz usb:v13D3p3219d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3211d*dc*dsc*dp*ic*isc*ip*in* usb:v1498pA090d*dc*dsc*dp*ic*isc*ip*in* usb:v1498p9206d*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp0513d*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp0514d*dc*dsc*dp*ic*isc*ip*in* usb:v10FDp1513d*dc*dsc*dp*ic*isc*ip*in* usb:v0DB0p5580d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dibusb-mc.ko.xz usb:v10B9p5001d*dc*dsc*dp*ic*isc*ip*in* usb:v10B9p5000d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6026d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6025d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p810Cd*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p810Bd*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0BC7d*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0BC6d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE361d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1ApE360d*dc*dsc*dp*ic*isc*ip*in* usb:v04CApF001d*dc*dsc*dp*ic*isc*ip*in* usb:v04CApF000d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p810Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8109d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p0BC7d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p0BC6d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_dibusb_common dvb_usb_dibusb_mc_common dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dw2102.ko.xz usb:v9022pD662d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD484d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD483d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3011d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4DpD220d*dc*dsc*dp*ic*isc*ip*in* usb:v1FE1p5456d*dc*dsc*dp*ic*isc*ip*in* usb:v153Bp1182d*dc*dsc*dp*ic*isc*ip*in* usb:v153Bp1181d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0105d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0102d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00B0d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD632d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD421d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp3100d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD482d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD481d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00A8d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pD900d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp3000d*dc*dsc*dp*ic*isc*ip*in* usb:v3034p7500d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD660d*dc*dsc*dp*ic*isc*ip*in* usb:v3011pB012d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD630d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p3101d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0064d*dc*dsc*dp*ic*isc*ip*in* usb:v9022pD650d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p2104d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p2101d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p2102d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb dvb_core

kernel/drivers/media/usb/dvb-usb/dvb-usb-az6027.ko.xz usb:v0FD9p0036d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0025d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p002Ad*dc*dsc*dp*ic*isc*ip*in* usb:v14F7p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v14F7p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10ACd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A4d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3275d*dc*dsc*dp*ic*isc*ip*in*
dvb_core stb6100 stb0899 dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-opera.ko.xz usb:v695Cp3829d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p2830d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-digitv.ko.xz usb:v0547p0201d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-af9005.ko.xz usb:v10B9p6000d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0055d*dc*dsc*dp*ic*isc*ip*in* usb:v15A4p9020d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-cxusb.ko.xz usb:v0572pD811d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p86D6d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB98d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA868d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB71d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB70d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB78d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB59d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB58d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB55d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB54d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB11d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB10d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB01d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB00d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB51d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pDB50d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pD501d*dc*dsc*dp*ic*isc*ip*in* usb:v0FE9pD500d*dc*dsc*dp*ic*isc*ip*in* usb:v1660p0932d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb dib0070

kernel/drivers/media/usb/dvb-usb/dvb-usb-vp702x.ko.xz usb:v13D3p3207d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-af9005-remote.ko.xz symbol:rc_map_af9005_table symbol:rc_map_af9005_table_size symbol:af9005_rc_decode

kernel/drivers/media/usb/dvb-usb/dvb-usb-ttusb2.ko.xz usb:v0B48p3009d*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p300Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3006d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0222d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p020Fd*dc*dsc*dp*ic*isc*ip*in*
dvb_core dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-umt-010.ko.xz usb:v15F4p0015d*dc*dsc*dp*ic*isc*ip*in* usb:v15F4p0001d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_dibusb_common dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-vp7045.ko.xz usb:v13D3p3224d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3223d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3206d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3205d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dibusb-mb.ko.xz usb:v0547p2235d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p810Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8109d*dc*dsc*dp*ic*isc*ip*in* usb:vEB2Ap17DEd*dc*dsc*dp*ic*isc*ip*in* usb:v0458p701Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0458p701Ed*dc*dsc*dp*ic*isc*ip*in* usb:v06E1pA334d*dc*dsc*dp*ic*isc*ip*in* usb:v06E1pA333d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8108d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8107d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8106d*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p8105d*dc*dsc*dp*ic*isc*ip*in* usb:v1822p3202d*dc*dsc*dp*ic*isc*ip*in* usb:v1822p3201d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3202d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3201d*dc*dsc*dp*ic*isc*ip*in* usb:v1025p005Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1025p005Ed*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0BB9d*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0BB8d*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0FA1d*dc*dsc*dp*ic*isc*ip*in* usb:v5032p0FA0d*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap17DFd*dc*dsc*dp*ic*isc*ip*in* usb:vEB1Ap17DEd*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p0BB9d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p0BB8d*dc*dsc*dp*ic*isc*ip*in* usb:v145Fp010Cd*dc*dsc*dp*ic*isc*ip*in* usb:v185BpD001d*dc*dsc*dp*ic*isc*ip*in* usb:v185BpD000d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0001d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_dibusb_common dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dtt200u.ko.xz usb:v18F3p0220d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0220d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0226d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0225d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp022Bd*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp022Ad*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0221d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0222d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0301d*dc*dsc*dp*ic*isc*ip*in* usb:v14AAp0201d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dtv5100.ko.xz usb:v06BEpA232d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-dib0700.ko.xz usb:v045Ep02D5d*dc*dsc*dp*ic*isc*ip*in* usb:v147Fp2758d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1FAAd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p1FAAd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p003Fd*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1F9Cd*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1E6Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2304p023Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2304p023Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1660p1921d*dc*dsc*dp*ic*isc*ip*in* usb:v14F7p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1BB4d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1BB2d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p2384d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1FA8d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p2383d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1FA0d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0248d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0245d*dc*dsc*dp*ic*isc*ip*in* usb:v1E59p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1554p5010d[0_2]*dc*dsc*dp*ic*isc*ip*in* usb:v1554p5010d3[0_9A_E]*dc*dsc*dp*ic*isc*ip*in* usb:v1554p5010d3F00dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1F90d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1F98d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00ABd*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1E80d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0248d*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0245d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0243d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p1E8Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1164p1EFCd*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A1d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp10A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p60F6d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p0871d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB210d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB200d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p2EDCd*dc*dsc*dp*ic*isc*ip*in* usb:v1415p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0081d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0062d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p023Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2304p023Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1736d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p1F08d*dc*dsc*dp*ic*isc*ip*in* usb:v1044p7002d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p8400d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5200d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6F01d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0078d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0060d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p1EDCd*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0237d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0236d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p022Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0058d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7080d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7070d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p173Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p171Fd*dc*dsc*dp*ic*isc*ip*in* usb:v05D8p810Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1044p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApB568d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp1E80d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0229d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1EBEd*dc*dsc*dp*ic*isc*ip*in* usb:v2304p0228d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1EBCd*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1EF0d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p9580d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp005Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2304p022Cd*dc*dsc*dp*ic*isc*ip*in* usb:v07CApB808d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7060d*dc*dsc*dp*ic*isc*ip*in* usb:v0413p6F00d*dc*dsc*dp*ic*isc*ip*in* usb:v1584p6003d*dc*dsc*dp*ic*isc*ip*in* usb:v185Bp1E78d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA807d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7050d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p9950d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p9941d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1E78d*dc*dsc*dp*ic*isc*ip*in* usb:v10B8p1E14d*dc*dsc*dp*ic*isc*ip*in*
dib0090 dib7000m dib0070 dvb_usb dib9000 dib3000mc dibx000_common

kernel/drivers/media/usb/dvb-usb/dvb-usb-dibusb-mc-common.ko.xz symbol:dibusb_dib3000mc_frontend_attach symbol:dibusb_dib3000mc_tuner_attach
dib3000mc dvb_usb_dibusb_common

kernel/drivers/media/usb/dvb-usb/dvb-usb-dibusb-common.ko.xz symbol:dibusb_streaming_ctrl symbol:dibusb_pid_filter symbol:dibusb_pid_filter_ctrl symbol:dibusb_power_ctrl symbol:dibusb2_0_streaming_ctrl symbol:dibusb2_0_power_ctrl symbol:dibusb_i2c_algo symbol:dibusb_read_eeprom_byte symbol:rc_map_dibusb_table symbol:dibusb_rc_query
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-gp8psk.ko.xz usb:v09C0p0204d*dc*dsc*dp*ic*isc*ip*in* usb:v09C0p0206d*dc*dsc*dp*ic*isc*ip*in* usb:v09C0p0203d*dc*dsc*dp*ic*isc*ip*in* usb:v09C0p0202d*dc*dsc*dp*ic*isc*ip*in* usb:v09C0p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v09C0p0200d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb.ko.xz symbol:usb_cypress_load_firmware symbol:dvb_usb_get_hexline symbol:dvb_usb_device_init symbol:dvb_usb_device_exit symbol:dvb_usb_generic_rw symbol:dvb_usb_generic_write symbol:dvb_usb_nec_rc_key_to_event
dvb_core mc

kernel/drivers/media/usb/dvb-usb/dvb-usb-pctv452e.ko.xz usb:v0B48p300Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B48p3007d*dc*dsc*dp*ic*isc*ip*in* usb:v2304p021Fd*dc*dsc*dp*ic*isc*ip*in*
dvb_core dvb_usb ttpci_eeprom

kernel/drivers/media/usb/dvb-usb/dvb-usb-technisat-usb2.ko.xz usb:v14F7p0500d*dc*dsc*dp*ic*isc*ip*in*
dvb_core dvb_usb

kernel/drivers/media/usb/dvb-usb/dvb-usb-a800.ko.xz usb:v07CApA801d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApA800d*dc*dsc*dp*ic*isc*ip*in*
dvb_usb_dibusb_common dvb_usb_dibusb_mc_common dvb_usb

kernel/drivers/media/usb/stk1160/stk1160.ko.xz usb:v05E1p0408d*dc*dsc*dp*ic*isc*ip*in*
videobuf2_v4l2 videodev videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/go7007/go7007-usb.ko.xz usb:v06E1p0709d0204dc*dsc*dp*ic*isc*ip*in* usb:v1943p2250d0001dc*dsc*dp*ic*isc*ip*in* usb:v10FDpDE00d0001dc*dsc*dp*ic*isc*ip*in* usb:v093BpA104d0001dc*dsc*dp*ic*isc*ip*in* usb:v093BpA102d0001dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p7007d0210dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p7007d0209dc*dsc*dp*icFFisc00ipFFin* usb:v0EB1p7007d0208dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p7007d0205dc*dsc*dp*icFFisc00ipFFin* usb:v0EB1p7007d0204dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p7007d0202dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p7007d0200dc*dsc*dp*icFFisc00ipFFin*
videodev go7007

kernel/drivers/media/usb/go7007/go7007-loader.ko.xz usb:v0EB1p6668d*dc*dsc*dp*ic*isc*ip*in* usb:v0EB1p6666d*dc*dsc*dp*ic*isc*ip*in* usb:v093BpA004d*dc*dsc*dp*ic*isc*ip*in* usb:v093BpA002d*dc*dsc*dp*ic*isc*ip*in* usb:v1943pA250d*dc*dsc*dp*ic*isc*ip*in*
cypress_firmware

kernel/drivers/media/usb/go7007/s2250.ko.xz i2c:s2250
videodev

kernel/drivers/media/usb/go7007/go7007.ko.xz symbol:go7007_read_interrupt symbol:go7007_read_addr symbol:go7007_boot_encoder symbol:go7007_register_encoder symbol:go7007_parse_video_stream symbol:go7007_alloc symbol:go7007_update_board symbol:go7007_snd_init symbol:go7007_snd_remove
videobuf2_v4l2 videodev snd_pcm snd videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/b2c2/b2c2-flexcop-usb.ko.xz usb:v0AF7p0101d*dc*dsc*dp*ic*isc*ip*in*
b2c2_flexcop

kernel/drivers/media/usb/cx231xx/cx231xx.ko.xz usb:v199Ep8002d*dc*dsc*dp*ic*isc*ip*in* usb:v15F4p0135d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pD3B2d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp00A6d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp0102d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD9p0037d*dc*dsc*dp*ic*isc*ip*in* usb:v1F4Dp0237d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE421d*dc*dsc*dp*ic*isc*ip*in* usb:v1B80pE424d*dc*dsc*dp*ic*isc*ip*in* usb:v1554p5014d*dc*dsc*dp*ic*isc*ip*in* usb:v1554p5010d400[0_1]dc*dsc*dp*ic*isc*ip*in* usb:v2013p025Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2013p0259d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC200d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB140d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB139d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB138d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB131d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB130d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB150d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB151d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB124d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB123d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB120d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB111d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB110d*dc*dsc*dp*ic*isc*ip*in* usb:v07CApC039d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p589Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A6d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A5d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A4d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A1d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p58A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p5A3Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p6109d*dc*dsc*dp*ic*isc*ip*in* usb:v1D19p6108d*dc*dsc*dp*ic*isc*ip*in* symbol:cx231xx_get_i2c_adap symbol:cx231xx_tuner_callback symbol:cx231xx_register_extension symbol:cx231xx_unregister_extension symbol:cx231xx_send_usb_command symbol:cx231xx_set_alt_setting symbol:cx231xx_demod_reset symbol:is_fw_load symbol:cx231xx_set_mode symbol:cx231xx_uninit_isoc symbol:cx231xx_uninit_bulk symbol:cx231xx_init_isoc symbol:cx231xx_init_bulk symbol:cx231xx_dev_init symbol:cx231xx_dev_uninit symbol:cx231xx_send_gpio_cmd symbol:cx231xx_enable656 symbol:cx231xx_disable656 symbol:cx231xx_unmute_audio symbol:cx231xx_enable_i2c_port_3 symbol:cx231xx_capture_start symbol:cx231xx_uninit_vbi_isoc symbol:cx231xx_init_vbi_isoc
videobuf2_v4l2 videodev mc cx2341x videobuf2_common i2c_mux videobuf2_vmalloc tveeprom

kernel/drivers/media/usb/cx231xx/cx231xx-dvb.ko.xz
cx231xx dvb_core

kernel/drivers/media/usb/cx231xx/cx231xx-alsa.ko.xz
cx231xx snd_pcm snd videodev

kernel/drivers/media/usb/pwc/pwc.ko.xz pwcx usb:v0D81p1910d*dc*dsc*dp*ic*isc*ip*in* usb:v0D81p1900d*dc*dsc*dp*ic*isc*ip*in* usb:v06BEp8116d*dc*dsc*dp*ic*isc*ip*in* usb:v069Ap0001d*dc*dsc*dp*ic*isc*ip*in* usb:v055Dp9002d*dc*dsc*dp*ic*isc*ip*in* usb:v055Dp9001d*dc*dsc*dp*ic*isc*ip*in* usb:v055Dp9000d*dc*dsc*dp*ic*isc*ip*in* usb:v04CCp8116d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p032Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0329d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0313d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0312d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0311d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0310d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p030Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0308d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0307d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0304d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0303d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p0302d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B8d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B7d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B6d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B5d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B4d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B3d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B2d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B1d*dc*dsc*dp*ic*isc*ip*in* usb:v046Dp08B0d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep4011d*dc*dsc*dp*ic*isc*ip*in* usb:v041Ep400Cd*dc*dsc*dp*ic*isc*ip*in*
videobuf2_v4l2 videodev videobuf2_common videobuf2_vmalloc

kernel/drivers/media/usb/pvrusb2/pvrusb2.ko.xz usb:v2040p7510d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7502d*dc*dsc*dp*ic*isc*ip*in* usb:v0CCDp0039d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7501d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7500d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p7300d*dc*dsc*dp*ic*isc*ip*in* usb:v11BAp1001d*dc*dsc*dp*ic*isc*ip*in* usb:v11BAp1003d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p0602d*dc*dsc*dp*ic*isc*ip*in* usb:v1164p0622d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2400d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2950d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2900d*dc*dsc*dp*ic*isc*ip*in*
videodev dvb_core cx2341x tveeprom

kernel/drivers/media/usb/siano/smsusb.ko.xz usb:v2013p0257d*dc*dsc*dp*ic*isc*ip*in* usb:v3275p0080d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p0078d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p0086d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0800d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0700d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0600d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0500d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0310d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0302d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0301d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0202d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pF5A0d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC0A0d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC090d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC080d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC010d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pC000d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB990d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB980d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB910d*dc*dsc*dp*ic*isc*ip*in* usb:v2040pB900d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5590d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5580d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5530d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5520d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5510d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p5500d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2019d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2011d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2010d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p200Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2009d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p1801d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p1800d*dc*dsc*dp*ic*isc*ip*in* usb:v2040p1700d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0300d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0201d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0200d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0100d*dc*dsc*dp*ic*isc*ip*in* usb:v187Fp0010d*dc*dsc*dp*ic*isc*ip*in*
smsmdtv mc

kernel/drivers/media/tuners/mt2131.ko.xz symbol:mt2131_attach

kernel/drivers/media/tuners/tda827x.ko.xz symbol:tda827x_attach

kernel/drivers/media/tuners/msi001.ko.xz spi:msi001
videodev

kernel/drivers/media/tuners/qt1010.ko.xz symbol:qt1010_attach

kernel/drivers/media/tuners/tea5761.ko.xz symbol:tea5761_attach symbol:tea5761_autodetection

kernel/drivers/media/tuners/tda18212.ko.xz i2c:tda18212
regmap_i2c

kernel/drivers/media/tuners/si2157.ko.xz i2c:si2177 i2c:si2141 i2c:si2146 i2c:si2157
mc

kernel/drivers/media/tuners/it913x.ko.xz platform:it9133bx_tuner platform:it9133ax_tuner

kernel/drivers/media/tuners/e4000.ko.xz i2c:e4000
videodev regmap_i2c

kernel/drivers/media/tuners/mt2060.ko.xz i2c:mt2060 symbol:mt2060_attach

kernel/drivers/media/tuners/tea5767.ko.xz symbol:tea5767_attach symbol:tea5767_autodetection

kernel/drivers/media/tuners/max2165.ko.xz symbol:max2165_attach

kernel/drivers/media/tuners/mxl5005s.ko.xz symbol:mxl5005s_attach

kernel/drivers/media/tuners/tua9001.ko.xz i2c:tua9001
regmap_i2c

kernel/drivers/media/tuners/mt2266.ko.xz symbol:mt2266_attach

kernel/drivers/media/tuners/fc0012.ko.xz symbol:fc0012_attach

kernel/drivers/media/tuners/xc4000.ko.xz symbol:xc4000_attach

kernel/drivers/media/tuners/tda9887.ko.xz symbol:tda9887_attach

kernel/drivers/media/tuners/qm1d1b0004.ko.xz i2c:qm1d1b0004

kernel/drivers/media/tuners/xc5000.ko.xz symbol:xc5000_attach

kernel/drivers/media/tuners/r820t.ko.xz symbol:r820t_attach

kernel/drivers/media/tuners/tda18271.ko.xz symbol:tda18271_attach

kernel/drivers/media/tuners/qm1d1c0042.ko.xz i2c:qm1d1c0042

kernel/drivers/media/tuners/mt20xx.ko.xz symbol:microtune_attach

kernel/drivers/media/tuners/tuner-simple.ko.xz symbol:simple_tuner_attach
tuner_types

kernel/drivers/media/tuners/xc2028.ko.xz symbol:xc2028_attach

kernel/drivers/media/tuners/fc2580.ko.xz i2c:fc2580
videodev regmap_i2c

kernel/drivers/media/tuners/mxl301rf.ko.xz i2c:mxl301rf

kernel/drivers/media/tuners/tuner-types.ko.xz symbol:tuners symbol:tuner_count

kernel/drivers/media/tuners/mc44s803.ko.xz symbol:mc44s803_attach

kernel/drivers/media/tuners/tda18250.ko.xz i2c:tda18250
regmap_i2c

kernel/drivers/media/tuners/m88rs6000t.ko.xz i2c:m88rs6000t
regmap_i2c

kernel/drivers/media/tuners/tda8290.ko.xz symbol:tda829x_attach symbol:tda829x_probe

kernel/drivers/media/tuners/tda18218.ko.xz symbol:tda18218_attach

kernel/drivers/media/tuners/mxl5007t.ko.xz symbol:mxl5007t_attach

kernel/drivers/media/tuners/mt2063.ko.xz symbol:mt2063_attach

kernel/drivers/media/tuners/fc0011.ko.xz symbol:fc0011_attach

kernel/drivers/media/tuners/fc0013.ko.xz symbol:fc0013_rc_cal_add symbol:fc0013_rc_cal_reset symbol:fc0013_attach

kernel/drivers/pps/clients/pps-gpio.ko.xz of:N*T*Cpps_gpioC* of:N*T*Cpps_gpio

kernel/drivers/pps/clients/pps-ldisc.ko.xz tty_ldisc_18

kernel/drivers/staging/vc04_services/bcm2835-audio/snd-bcm2835.ko.xz vchiq:bcm2835_audio
snd snd_pcm

kernel/drivers/staging/vc04_services/vchiq-mmal/bcm2835-mmal-vchiq.ko.xz symbol:vchiq_mmal_port_set_format symbol:vchiq_mmal_port_parameter_set symbol:vchiq_mmal_port_parameter_get symbol:vchiq_mmal_port_enable symbol:vchiq_mmal_port_disable symbol:vchiq_mmal_port_connect_tunnel symbol:vchiq_mmal_submit_buffer symbol:mmal_vchi_buffer_init symbol:mmal_vchi_buffer_cleanup symbol:vchiq_mmal_component_init symbol:vchiq_mmal_component_finalise symbol:vchiq_mmal_component_enable symbol:vchiq_mmal_component_disable symbol:vchiq_mmal_version symbol:vchiq_mmal_finalise symbol:vchiq_mmal_init
vc_sm_cma

kernel/drivers/staging/vc04_services/vc-sm-cma/vc-sm-cma.ko.xz vcsm_cma symbol:vc_sm_cma_int_handle symbol:vc_sm_cma_free symbol:vc_sm_cma_import_dmabuf

kernel/drivers/staging/vc04_services/bcm2835-codec/bcm2835-codec.ko.xz vchiq:bcm2835_codec
v4l2_mem2mem videobuf2_v4l2 videodev bcm2835_mmal_vchiq videobuf2_common mc videobuf2_dma_contig

kernel/drivers/staging/vc04_services/bcm2835-isp/bcm2835-isp.ko.xz vchiq:bcm2835_isp
videobuf2_v4l2 bcm2835_mmal_vchiq mc videobuf2_common videodev vc_sm_cma videobuf2_dma_contig

kernel/drivers/staging/vc04_services/bcm2835-camera/bcm2835-v4l2.ko.xz vchiq:bcm2835_camera
videobuf2_v4l2 bcm2835_mmal_vchiq videodev videobuf2_common videobuf2_vmalloc

kernel/drivers/staging/vt6656/vt6656_stage.ko.xz usb:v160Ap3184d*dc*dsc*dp*ic*isc*ip*in*
mac80211 cfg80211

kernel/drivers/staging/fbtft/fb_hx8353d.ko.xz platform:hx8353d spi:hx8353d platform:fb_hx8353d spi:fb_hx8353d of:N*T*Chimax,hx8353dC* of:N*T*Chimax,hx8353d
fbtft

kernel/drivers/staging/fbtft/fb_sh1106.ko.xz of:N*T*Csinowealth,sh1106C* of:N*T*Csinowealth,sh1106 spi:sh1106
fbtft

kernel/drivers/staging/fbtft/fb_tinylcd.ko.xz spi:tinylcd spi:fb_tinylcd of:N*T*Cneosec,tinylcdC* of:N*T*Cneosec,tinylcd
fbtft

kernel/drivers/staging/fbtft/fb_ili9320.ko.xz platform:ili9320 spi:ili9320 platform:fb_ili9320 spi:fb_ili9320 of:N*T*Cilitek,ili9320C* of:N*T*Cilitek,ili9320
fbtft

kernel/drivers/staging/fbtft/fb_ssd1331.ko.xz platform:ssd1331 spi:ssd1331 platform:fb_ssd1331 spi:fb_ssd1331 of:N*T*Csolomon,ssd1331C* of:N*T*Csolomon,ssd1331
fbtft

kernel/drivers/staging/fbtft/fb_ssd1306.ko.xz platform:ssd1306 spi:ssd1306 platform:fb_ssd1306 spi:fb_ssd1306 of:N*T*Csolomon,ssd1306C* of:N*T*Csolomon,ssd1306
fbtft

kernel/drivers/staging/fbtft/fb_ili9341.ko.xz platform:ili9341 spi:ili9341 platform:fb_ili9341 spi:fb_ili9341 of:N*T*Cilitek,ili9341C* of:N*T*Cilitek,ili9341
fbtft

kernel/drivers/staging/fbtft/fbtft.ko.xz symbol:fbtft_write_buf_dc symbol:fbtft_dbg_hex symbol:fbtft_unregister_backlight symbol:fbtft_register_backlight symbol:fbtft_framebuffer_alloc symbol:fbtft_framebuffer_release symbol:fbtft_register_framebuffer symbol:fbtft_unregister_framebuffer symbol:fbtft_init_display symbol:fbtft_probe_common symbol:fbtft_remove_common symbol:fbtft_write_reg8_bus8 symbol:fbtft_write_reg16_bus8 symbol:fbtft_write_reg16_bus16 symbol:fbtft_write_reg8_bus9 symbol:fbtft_write_vmem16_bus8 symbol:fbtft_write_vmem16_bus9 symbol:fbtft_write_vmem8_bus8 symbol:fbtft_write_vmem16_bus16 symbol:fbtft_write_spi symbol:fbtft_write_spi_emulate_9 symbol:fbtft_read_spi symbol:fbtft_write_gpio8_wr symbol:fbtft_write_gpio16_wr symbol:fbtft_write_gpio16_wr_latched
backlight

kernel/drivers/staging/fbtft/fb_agm1264k-fl.ko.xz platform:fb_agm1264k_fl of:N*T*Cdisplaytronic,fb_agm1264k_flC* of:N*T*Cdisplaytronic,fb_agm1264k_fl
fbtft

kernel/drivers/staging/fbtft/fb_ili9340.ko.xz platform:ili9340 spi:ili9340 platform:fb_ili9340 spi:fb_ili9340 of:N*T*Cilitek,ili9340C* of:N*T*Cilitek,ili9340
fbtft

kernel/drivers/staging/fbtft/fb_ssd1351.ko.xz platform:ssd1351 spi:ssd1351 platform:fb_ssd1351 spi:fb_ssd1351 of:N*T*Csolomon,ssd1351C* of:N*T*Csolomon,ssd1351
fbtft backlight

kernel/drivers/staging/fbtft/fb_ili9486.ko.xz platform:ili9486 spi:ili9486 platform:fb_ili9486 spi:fb_ili9486 of:N*T*Cilitek,ili9486C* of:N*T*Cilitek,ili9486
fbtft

kernel/drivers/staging/fbtft/fb_ssd1289.ko.xz platform:ssd1289 spi:ssd1289 platform:fb_ssd1289 spi:fb_ssd1289 of:N*T*Csolomon,ssd1289C* of:N*T*Csolomon,ssd1289
fbtft

kernel/drivers/staging/fbtft/fb_ili9163.ko.xz platform:ili9163 spi:ili9163 platform:fb_ili9163 spi:fb_ili9163 of:N*T*Cilitek,ili9163C* of:N*T*Cilitek,ili9163
fbtft

kernel/drivers/staging/fbtft/fb_ili9481.ko.xz platform:ili9481 spi:ili9481 platform:fb_ili9481 spi:fb_ili9481 of:N*T*Cilitek,ili9481C* of:N*T*Cilitek,ili9481
fbtft

kernel/drivers/staging/fbtft/fb_st7735r.ko.xz platform:adafruit18_green spi:adafruit18_green platform:adafruit18 spi:adafruit18 platform:sainsmart spi:sainsmart18 platform:st7735r spi:st7735r platform:fb_st7735r spi:fb_st7735r of:N*T*Cfbtft,adafruit18_greenC* of:N*T*Cfbtft,adafruit18_green of:N*T*Cfbtft,adafruit18C* of:N*T*Cfbtft,adafruit18 of:N*T*Cfbtft,sainsmart18C* of:N*T*Cfbtft,sainsmart18 of:N*T*Csitronix,st7735rC* of:N*T*Csitronix,st7735r
fbtft

kernel/drivers/staging/fbtft/fb_upd161704.ko.xz platform:upd161704 spi:upd161704 platform:fb_upd161704 spi:fb_upd161704 of:N*T*Cnec,upd161704C* of:N*T*Cnec,upd161704
fbtft

kernel/drivers/staging/fbtft/fb_bd663474.ko.xz platform:bd663474 spi:bd663474 platform:fb_bd663474 spi:fb_bd663474 of:N*T*Chitachi,bd663474C* of:N*T*Chitachi,bd663474
fbtft

kernel/drivers/staging/fbtft/fb_hx8357d.ko.xz platform:hx8357d spi:hx8357d platform:fb_hx8357d spi:fb_hx8357d of:N*T*Chimax,hx8357dC* of:N*T*Chimax,hx8357d
fbtft

kernel/drivers/staging/fbtft/fb_pcd8544.ko.xz spi:pcd8544 spi:fb_pcd8544 of:N*T*Cphilips,pcd8544C* of:N*T*Cphilips,pcd8544
fbtft

kernel/drivers/staging/fbtft/fb_uc1611.ko.xz platform:uc1611 spi:uc1611 platform:fb_uc1611 spi:fb_uc1611 of:N*T*Cultrachip,uc1611C* of:N*T*Cultrachip,uc1611
fbtft

kernel/drivers/staging/fbtft/fb_ra8875.ko.xz platform:ra8875 spi:ra8875 platform:fb_ra8875 spi:fb_ra8875 of:N*T*Craio,ra8875C* of:N*T*Craio,ra8875
fbtft

kernel/drivers/staging/fbtft/fb_hx8340bn.ko.xz platform:hx8340bn spi:hx8340bn platform:fb_hx8340bn spi:fb_hx8340bn of:N*T*Chimax,hx8340bnC* of:N*T*Chimax,hx8340bn
fbtft

kernel/drivers/staging/fbtft/fb_tls8204.ko.xz spi:tls8204 spi:fb_tls8204 of:N*T*Cteralane,tls8204C* of:N*T*Cteralane,tls8204
fbtft

kernel/drivers/staging/fbtft/fb_s6d1121.ko.xz platform:s6d1121 spi:s6d1121 platform:fb_s6d1121 spi:fb_s6d1121 of:N*T*Csamsung,s6d1121C* of:N*T*Csamsung,s6d1121
fbtft

kernel/drivers/staging/fbtft/fb_st7789v.ko.xz platform:st7789v spi:st7789v platform:fb_st7789v spi:fb_st7789v of:N*T*Cfbtft,minipitft13C* of:N*T*Cfbtft,minipitft13 of:N*T*Csitronix,st7789vC* of:N*T*Csitronix,st7789v
fbtft

kernel/drivers/staging/fbtft/fb_hx8347d.ko.xz platform:hx8347d spi:hx8347d platform:fb_hx8347d spi:fb_hx8347d of:N*T*Chimax,hx8347dC* of:N*T*Chimax,hx8347d
fbtft

kernel/drivers/staging/fbtft/fb_uc1701.ko.xz spi:uc1701 spi:fb_uc1701 of:N*T*CUltraChip,uc1701C* of:N*T*CUltraChip,uc1701
fbtft

kernel/drivers/staging/fbtft/fb_ili9325.ko.xz platform:ili9325 spi:ili9325 platform:fb_ili9325 spi:fb_ili9325 of:N*T*Cilitek,ili9325C* of:N*T*Cilitek,ili9325
fbtft

kernel/drivers/staging/fbtft/fb_s6d02a1.ko.xz platform:s6d02a1 spi:s6d02a1 platform:fb_s6d02a1 spi:fb_s6d02a1 of:N*T*Csamsung,s6d02a1C* of:N*T*Csamsung,s6d02a1
fbtft

kernel/drivers/bluetooth/hci_uart.ko.xz tty_ldisc_15 of:N*T*Cinfineon,cyw55572_btC* of:N*T*Cinfineon,cyw55572_bt of:N*T*Ccypress,cyw4373a0_btC* of:N*T*Ccypress,cyw4373a0_bt of:N*T*Cbrcm,bcm4335a0C* of:N*T*Cbrcm,bcm4335a0 of:N*T*Cbrcm,bcm43540_btC* of:N*T*Cbrcm,bcm43540_bt of:N*T*Cbrcm,bcm4349_btC* of:N*T*Cbrcm,bcm4349_bt of:N*T*Cbrcm,bcm43438_btC* of:N*T*Cbrcm,bcm43438_bt of:N*T*Cbrcm,bcm43430a1_btC* of:N*T*Cbrcm,bcm43430a1_bt of:N*T*Cbrcm,bcm43430a0_btC* of:N*T*Cbrcm,bcm43430a0_bt of:N*T*Cbrcm,bcm4345c5C* of:N*T*Cbrcm,bcm4345c5 of:N*T*Cbrcm,bcm4334_btC* of:N*T*Cbrcm,bcm4334_bt of:N*T*Cbrcm,bcm4330_btC* of:N*T*Cbrcm,bcm4330_bt of:N*T*Cbrcm,bcm4329_btC* of:N*T*Cbrcm,bcm4329_bt of:N*T*Cbrcm,bcm20702a1C* of:N*T*Cbrcm,bcm20702a1 symbol:hci_uart_tx_wakeup symbol:hci_uart_register_device_priv symbol:hci_uart_unregister_device symbol:h4_recv_buf
bluetooth btbcm

kernel/drivers/bluetooth/hci_vhci.ko.xz char_major_10_137 devname:vhci
bluetooth

kernel/drivers/bluetooth/btrtl.ko.xz symbol:btrtl_set_driver_name symbol:btrtl_free symbol:btrtl_initialize symbol:btrtl_download_firmware symbol:btrtl_set_quirks symbol:btrtl_setup_realtek symbol:btrtl_shutdown_realtek symbol:btrtl_get_uart_settings
bluetooth

kernel/drivers/bluetooth/btmtk.ko.xz symbol:btmtk_fw_get_filename symbol:btmtk_setup_firmware_79xx symbol:btmtk_setup_firmware symbol:btmtk_set_bdaddr symbol:btmtk_reset_sync symbol:btmtk_register_coredump symbol:btmtk_process_coredump symbol:btmtk_usb_subsys_reset symbol:btmtk_usb_recv_acl symbol:alloc_mtk_intr_urb symbol:btmtk_usb_resume symbol:btmtk_usb_suspend symbol:btmtk_usb_setup symbol:btmtk_usb_shutdown
bluetooth

kernel/drivers/bluetooth/bcm203x.ko.xz usb:v0A5Cp2033d*dc*dsc*dp*ic*isc*ip*in*
bluetooth

kernel/drivers/bluetooth/btusb.ko.xz usb:v8087p0A5Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0930p*d*dc*dsc*dp*icFFisc01ip01in* usb:v413Cp*d*dc*dsc*dp*icFFisc01ip01in* usb:v13D3p*d*dc*dsc*dp*icFFisc01ip01in* usb:v050Dp*d*dc*dsc*dp*icFFisc01ip01in* usb:v0B05p*d*dc*dsc*dp*icFFisc01ip01in* usb:v0A5Cp*d*dc*dsc*dp*icFFisc01ip01in* usb:v04CAp*d*dc*dsc*dp*icFFisc01ip01in* usb:v0489p*d*dc*dsc*dp*icFFisc01ip01in* usb:v0BB4p*d*dc*dsc*dp*icFFisc01ip01in* usb:v105Bp*d*dc*dsc*dp*icFFisc01ip01in* usb:v19FFp0239d*dc*dsc*dp*ic*isc*ip*in* usb:v0C10p0000d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDBp1002d*dc*dsc*dp*ic*isc*ip*in* usb:v044Ep3002d*dc*dsc*dp*ic*isc*ip*in* usb:v044Ep3001d*dc*dsc*dp*ic*isc*ip*in* usb:v04BFp030Ad*dc*dsc*dp*ic*isc*ip*in* usb:v057Cp3800d*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp8281d*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp821Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp821Fd*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp821Bd*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp8218d*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp8215d*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp8213d*dc*dsc*dp*ic*isc*ip*in* usb:v0A5Cp21E1d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp763Fd*dc*dsc*dp*ic*isc*ip*in* usb:v05ACp*d*dc*dsc*dp*icFFisc01ip01in* usb:v*p*d*dc*dsc*dp*icE0isc01ip01in* usb:v*p*d*dcE0dsc01dp04ic*isc*ip*in* usb:v*p*d*dcE0dsc01dp01ic*isc*ip*in* of:N*T*Cusb4ca,301aC* of:N*T*Cusb4ca,301a of:N*T*Cusbcf3,e300C* of:N*T*Cusbcf3,e300 of:N*T*Cusb1286,204eC* of:N*T*Cusb1286,204e
bluetooth btrtl btmtk btintel btbcm

kernel/drivers/bluetooth/btbcm.ko.xz symbol:btbcm_check_bdaddr symbol:btbcm_set_bdaddr symbol:btbcm_read_pcm_int_params symbol:btbcm_write_pcm_int_params symbol:btbcm_patchram symbol:btbcm_initialize symbol:btbcm_finalize symbol:btbcm_setup_patchram symbol:btbcm_setup_apple
bluetooth

kernel/drivers/bluetooth/ath3k.ko.xz usb:v0489pE03Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE036d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE02Cd*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3490d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3487d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3474d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3472d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3432d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3423d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3408d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3402d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3395d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3393d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3375d*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3362d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pE006d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pE005d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pE004d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pE003d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p817Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p817Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p3121d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p311Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p311Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p311Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p3008d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p3004d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p0036d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p17D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0227d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0220d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p021Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0219d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3018d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3014d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3010d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp300Fd*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp300Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp300Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3008d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3007d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3006d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3005d*dc*dsc*dp*ic*isc*ip*in* usb:v04CAp3004d*dc*dsc*dp*ic*isc*ip*in* usb:v04C5p1330d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE095d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE078d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE076d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE05Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE056d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE057d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE04Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE04Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p311Dd*dc*dsc*dp*ic*isc*ip*in* usb:v13D3p3304d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3pE019d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p3002d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0215d*dc*dsc*dp*ic*isc*ip*in* usb:v04F2pAFF1d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE03Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE027d*dc*dsc*dp*ic*isc*ip*in* usb:v0CF3p3000d*dc*dsc*dp*ic*isc*ip*in*
bluetooth

kernel/drivers/bluetooth/bpa10x.ko.xz usb:v08FDp0002d*dc*dsc*dp*ic*isc*ip*in*
bluetooth

kernel/drivers/bluetooth/btmrvl_sdio.ko.xz sdio:c*v02DFd9142* sdio:c*v02DFd914A* sdio:c*v02DFd9146* sdio:c*v02DFd912E* sdio:c*v02DFd9136* sdio:c*v02DFd912A* sdio:c*v02DFd911B* sdio:c*v02DFd911A* sdio:c*v02DFd9105*
bluetooth btmrvl

kernel/drivers/bluetooth/btmrvl.ko.xz symbol:btmrvl_interrupt symbol:btmrvl_check_evtpkt symbol:btmrvl_process_event symbol:btmrvl_send_module_cfg_cmd symbol:btmrvl_pscan_window_reporting symbol:btmrvl_send_hscfg_cmd symbol:btmrvl_enable_ps symbol:btmrvl_enable_hs symbol:btmrvl_register_hdev symbol:btmrvl_add_card symbol:btmrvl_remove_card
bluetooth

kernel/drivers/bluetooth/btintel.ko.xz symbol:btintel_check_bdaddr symbol:btintel_enter_mfg symbol:btintel_exit_mfg symbol:btintel_set_bdaddr symbol:btintel_set_diag symbol:btintel_hw_error symbol:btintel_version_info symbol:btintel_load_ddc_config symbol:btintel_set_event_mask_mfg symbol:btintel_read_version symbol:btintel_version_info_tlv symbol:btintel_parse_version_tlv symbol:btintel_regmap_init symbol:btintel_send_intel_reset symbol:btintel_read_boot_params symbol:btintel_download_firmware symbol:btintel_set_quality_report symbol:btintel_bootloader_setup_tlv symbol:btintel_set_msft_opcode symbol:btintel_print_fseq_info symbol:btintel_shutdown_combined symbol:btintel_configure_setup symbol:btintel_diagnostics symbol:btintel_recv_event symbol:btintel_bootup symbol:btintel_secure_send_result
bluetooth

kernel/drivers/bluetooth/bfusb.ko.xz usb:v057Cp2200d*dc*dsc*dp*ic*isc*ip*in*
bluetooth

kernel/drivers/gpio/gpio-fsm.ko.xz platform:gpio_fsm of:N*T*Crpi,gpio_fsmC* of:N*T*Crpi,gpio_fsm

kernel/drivers/gpio/gpio-regmap.ko.xz symbol:gpio_regmap_get_drvdata symbol:gpio_regmap_register symbol:gpio_regmap_unregister symbol:devm_gpio_regmap_register

kernel/drivers/gpio/gpio-max730x.ko.xz symbol:__max730x_probe symbol:__max730x_remove

kernel/drivers/gpio/gpio-mockup.ko.xz of:N*T*Cgpio_mockupC* of:N*T*Cgpio_mockup

kernel/drivers/gpio/gpio-max7301.ko.xz spi:max7301
gpio_max730x

kernel/drivers/gpio/gpio-max7300.ko.xz i2c:max7300
gpio_max730x

kernel/drivers/gpio/gpio-fxl6408.ko.xz of:N*T*Cfcs,fxl6408C* of:N*T*Cfcs,fxl6408 i2c:fxl6408
regmap_i2c gpio_regmap

kernel/drivers/gpio/gpio-pca953x.ko.xz i2c:xra1202 i2c:tca9554 i2c:tca9539 i2c:tca9538 i2c:tca6424 i2c:tca6416 i2c:tca6408 i2c:pca6107 i2c:max7318 i2c:max7315 i2c:max7313 i2c:max7312 i2c:max7310 i2c:pcal9555a i2c:pcal9554b i2c:pcal9535 i2c:pcal6534 i2c:pcal6524 i2c:pcal6416 i2c:pcal6408 i2c:pca9698 i2c:pca9575 i2c:pca9574 i2c:pca9557 i2c:pca9556 i2c:pca9555 i2c:pca9554 i2c:pca9539 i2c:pca9538 i2c:pca9537 i2c:pca9536 i2c:pca9535 i2c:pca9534 i2c:pca9506 i2c:pca9505 i2c:pca6416 i2c:pca6408 acpi*:INT3491:* of:N*T*Cexar,xra1202C* of:N*T*Cexar,xra1202 of:N*T*Connn,pca9655C* of:N*T*Connn,pca9655 of:N*T*Connn,pca9654C* of:N*T*Connn,pca9654 of:N*T*Connn,cat9554C* of:N*T*Connn,cat9554 of:N*T*Cti,tca9554C* of:N*T*Cti,tca9554 of:N*T*Cti,tca9539C* of:N*T*Cti,tca9539 of:N*T*Cti,tca9538C* of:N*T*Cti,tca9538 of:N*T*Cti,tca9535C* of:N*T*Cti,tca9535 of:N*T*Cti,tca6424C* of:N*T*Cti,tca6424 of:N*T*Cti,tca6416C* of:N*T*Cti,tca6416 of:N*T*Cti,tca6408C* of:N*T*Cti,tca6408 of:N*T*Cti,pca9536C* of:N*T*Cti,pca9536 of:N*T*Cti,pca6107C* of:N*T*Cti,pca6107 of:N*T*Cmaxim,max7318C* of:N*T*Cmaxim,max7318 of:N*T*Cmaxim,max7315C* of:N*T*Cmaxim,max7315 of:N*T*Cmaxim,max7313C* of:N*T*Cmaxim,max7313 of:N*T*Cmaxim,max7312C* of:N*T*Cmaxim,max7312 of:N*T*Cmaxim,max7310C* of:N*T*Cmaxim,max7310 of:N*T*Cnxp,pcal9555aC* of:N*T*Cnxp,pcal9555a of:N*T*Cnxp,pcal9554bC* of:N*T*Cnxp,pcal9554b of:N*T*Cnxp,pcal9535C* of:N*T*Cnxp,pcal9535 of:N*T*Cnxp,pcal6534C* of:N*T*Cnxp,pcal6534 of:N*T*Cnxp,pcal6524C* of:N*T*Cnxp,pcal6524 of:N*T*Cnxp,pcal6416C* of:N*T*Cnxp,pcal6416 of:N*T*Cnxp,pcal6408C* of:N*T*Cnxp,pcal6408 of:N*T*Cnxp,pca9698C* of:N*T*Cnxp,pca9698 of:N*T*Cnxp,pca9575C* of:N*T*Cnxp,pca9575 of:N*T*Cnxp,pca9574C* of:N*T*Cnxp,pca9574 of:N*T*Cnxp,pca9557C* of:N*T*Cnxp,pca9557 of:N*T*Cnxp,pca9556C* of:N*T*Cnxp,pca9556 of:N*T*Cnxp,pca9555C* of:N*T*Cnxp,pca9555 of:N*T*Cnxp,pca9554C* of:N*T*Cnxp,pca9554 of:N*T*Cnxp,pca9539C* of:N*T*Cnxp,pca9539 of:N*T*Cnxp,pca9538C* of:N*T*Cnxp,pca9538 of:N*T*Cnxp,pca9537C* of:N*T*Cnxp,pca9537 of:N*T*Cnxp,pca9536C* of:N*T*Cnxp,pca9536 of:N*T*Cnxp,pca9535C* of:N*T*Cnxp,pca9535 of:N*T*Cnxp,pca9534C* of:N*T*Cnxp,pca9534 of:N*T*Cnxp,pca9506C* of:N*T*Cnxp,pca9506 of:N*T*Cnxp,pca9505C* of:N*T*Cnxp,pca9505 of:N*T*Cnxp,pca6416C* of:N*T*Cnxp,pca6416 of:N*T*Cnxp,pca6408C* of:N*T*Cnxp,pca6408
regmap_i2c

kernel/drivers/gpio/gpio-arizona.ko.xz platform:arizona_gpio

kernel/drivers/gpio/gpio-pcf857x.ko.xz i2c:max7329 i2c:max7328 i2c:pca9675 i2c:pca9673 i2c:pca9671 i2c:pca8575 i2c:pcf8575 i2c:pca9674 i2c:pca9672 i2c:pca9670 i2c:pca8574 i2c:pcf8574a i2c:pcf8574 of:N*T*Cmaxim,max7329C* of:N*T*Cmaxim,max7329 of:N*T*Cmaxim,max7328C* of:N*T*Cmaxim,max7328 of:N*T*Cnxp,pca9675C* of:N*T*Cnxp,pca9675 of:N*T*Cnxp,pca9673C* of:N*T*Cnxp,pca9673 of:N*T*Cnxp,pca9671C* of:N*T*Cnxp,pca9671 of:N*T*Cnxp,pca8575C* of:N*T*Cnxp,pca8575 of:N*T*Cnxp,pcf8575C* of:N*T*Cnxp,pcf8575 of:N*T*Cnxp,pca9674C* of:N*T*Cnxp,pca9674 of:N*T*Cnxp,pca9672C* of:N*T*Cnxp,pca9672 of:N*T*Cnxp,pca9670C* of:N*T*Cnxp,pca9670 of:N*T*Cnxp,pca8574C* of:N*T*Cnxp,pca8574 of:N*T*Cnxp,pcf8574aC* of:N*T*Cnxp,pcf8574a of:N*T*Cnxp,pcf8574C* of:N*T*Cnxp,pcf8574

kernel/drivers/mmc/host/sdhci-of-dwcmshc.ko.xz of:N*T*Csophgo,sg2042_dwcmshcC* of:N*T*Csophgo,sg2042_dwcmshc of:N*T*Cthead,th1520_dwcmshcC* of:N*T*Cthead,th1520_dwcmshc of:N*T*Csophgo,sg2002_dwcmshcC* of:N*T*Csophgo,sg2002_dwcmshc of:N*T*Csophgo,cv1800b_dwcmshcC* of:N*T*Csophgo,cv1800b_dwcmshc of:N*T*Csnps,dwcmshc_sdhciC* of:N*T*Csnps,dwcmshc_sdhci of:N*T*Crockchip,rk3568_dwcmshcC* of:N*T*Crockchip,rk3568_dwcmshc of:N*T*Crockchip,rk3576_dwcmshcC* of:N*T*Crockchip,rk3576_dwcmshc of:N*T*Crockchip,rk3588_dwcmshcC* of:N*T*Crockchip,rk3588_dwcmshc of:N*T*Craspberrypi,rp1_dwcmshcC* of:N*T*Craspberrypi,rp1_dwcmshc

kernel/drivers/mmc/host/mmc_spi.ko.xz spi:mmc_spi spi:mmc_spi_slot of:N*T*Cmmc_spi_slotC* of:N*T*Cmmc_spi_slot
of_mmc_spi crc7

kernel/drivers/mmc/host/of_mmc_spi.ko.xz symbol:mmc_spi_get_pdata symbol:mmc_spi_put_pdata

kernel/drivers/cdrom/cdrom.ko.xz symbol:cdrom_dummy_generic_packet symbol:register_cdrom symbol:unregister_cdrom symbol:cdrom_get_media_event symbol:cdrom_open symbol:cdrom_release symbol:cdrom_number_of_slots symbol:cdrom_check_events symbol:init_cdrom_command symbol:cdrom_mode_sense symbol:cdrom_mode_select symbol:cdrom_multisession symbol:cdrom_read_tocentry symbol:cdrom_get_last_written symbol:cdrom_ioctl

kernel/drivers/ata/libahci.ko.xz symbol:ahci_ignore_sss symbol:ahci_shost_groups symbol:ahci_sdev_groups symbol:ahci_ops symbol:ahci_pmp_retry_srst_ops symbol:ahci_save_initial_config symbol:ahci_start_engine symbol:ahci_stop_engine symbol:ahci_start_fis_rx symbol:ahci_reset_controller symbol:ahci_reset_em symbol:ahci_init_controller symbol:ahci_dev_classify symbol:ahci_fill_cmd_slot symbol:ahci_kick_engine symbol:ahci_check_ready symbol:ahci_do_softreset symbol:ahci_do_hardreset symbol:ahci_handle_port_intr symbol:ahci_qc_issue symbol:ahci_error_handler symbol:ahci_port_resume symbol:ahci_print_info symbol:ahci_set_em_messages symbol:ahci_host_activate
libata

kernel/drivers/ata/sata_mv.ko.xz platform:sata_mv of:N*T*Cmarvell,orion_sataC* of:N*T*Cmarvell,orion_sata of:N*T*Cmarvell,armada_370_sataC* of:N*T*Cmarvell,armada_370_sata pci:v00001103d00002310sv*sd*bc*sc*i* pci:v00001103d00002300sv*sd*bc*sc*i* pci:v000011ABd00007042sv*sd*bc*sc*i* pci:v00009005d00000243sv*sd*bc*sc*i* pci:v00009005d00000241sv*sd*bc*sc*i* pci:v000011ABd00006081sv*sd*bc*sc*i* pci:v000011ABd00006080sv*sd*bc*sc*i* pci:v000011ABd00006042sv*sd*bc*sc*i* pci:v000011ABd00006041sv*sd*bc*sc*i* pci:v000011ABd00006040sv*sd*bc*sc*i* pci:v00001103d00001742sv*sd*bc*sc*i* pci:v00001103d00001740sv*sd*bc*sc*i* pci:v00001103d00001720sv*sd*bc*sc*i* pci:v000011ABd00005081sv*sd*bc*sc*i* pci:v000011ABd00005080sv*sd*bc*sc*i* pci:v000011ABd00005041sv*sd*bc*sc*i* pci:v000011ABd00005040sv*sd*bc*sc*i*
libata

kernel/drivers/ata/ahci.ko.xz pci:v*d*sv*sd*bc01sc06i01* pci:v00000014d00007A08sv*sd*bc*sc*i* pci:v00001C44d00008000sv*sd*bc*sc*i* pci:v0000144Dd0000A800sv*sd*bc*sc*i* pci:v0000144Dd00001600sv*sd*bc*sc*i* pci:v00001B21d00001166sv*sd*bc*sc*i* pci:v00001B21d00001165sv*sd*bc*sc*i* pci:v00001B21d00001164sv*sd*bc*sc*i* pci:v00001B21d00001064sv*sd*bc*sc*i* pci:v00001B21d00001062sv*sd*bc*sc*i* pci:v00001B21d00000624sv*sd*bc*sc*i* pci:v00001B21d00000622sv*sd*bc*sc*i* pci:v00001B21d00000621sv*sd*bc*sc*i* pci:v00001B21d00000612sv*sd*bc*sc*i* pci:v00001B21d00000611sv*sd*bc*sc*i* pci:v00001B21d00000602sv*sd*bc*sc*i* pci:v00001B21d00000601sv*sd*bc*sc*i* pci:v0000105Ad00003781sv*sd*bc*sc*i* pci:v0000105Ad00003F20sv*sd*bc*sc*i* pci:v00001103d00000645sv*sd*bc*sc*i* pci:v00001103d00000642sv*sd*bc*sc*i* pci:v00001B4Bd00009235sv*sd*bc*sc*i* pci:v00001B4Bd00009230sv*sd*bc*sc*i* pci:v00001B4Bd00009215sv*sd*bc*sc*i* pci:v00001B4Bd000091A3sv*sd*bc*sc*i* pci:v00001B4Bd000091A2sv*sd*bc*sc*i* pci:v00001B4Bd000091A0sv*sd*bc*sc*i* pci:v00001B4Bd00009192sv*sd*bc*sc*i* pci:v00001B4Bd00009182sv*sd*bc*sc*i* pci:v00001B4Bd00009172sv*sd*bc*sc*i* pci:v00001B4Bd0000917Asv*sd*bc*sc*i* pci:v00001B4Bd00009178sv00001B4Bsd00009170bc*sc*i* pci:v00001B4Bd00009125sv*sd*bc*sc*i* pci:v00001B4Bd00009123sv*sd*bc01sc06i01* pci:v000011ABd00006121sv*sd*bc*sc*i* pci:v000011ABd00006145sv*sd*bc*sc*i* pci:v0000104Ad0000CC06sv*sd*bc*sc*i* pci:v00001039d00000186sv*sd*bc*sc*i* pci:v00001039d00001185sv*sd*bc*sc*i* pci:v00001039d00001184sv*sd*bc*sc*i* pci:v000010DEd00000D8Fsv*sd*bc*sc*i* pci:v000010DEd00000D8Esv*sd*bc*sc*i* pci:v000010DEd00000D8Dsv*sd*bc*sc*i* pci:v000010DEd00000D8Csv*sd*bc*sc*i* pci:v000010DEd00000D8Bsv*sd*bc*sc*i* pci:v000010DEd00000D8Asv*sd*bc*sc*i* pci:v000010DEd00000D89sv*sd*bc*sc*i* pci:v000010DEd00000D88sv*sd*bc*sc*i* pci:v000010DEd00000D87sv*sd*bc*sc*i* pci:v000010DEd00000D86sv*sd*bc*sc*i* pci:v000010DEd00000D85sv*sd*bc*sc*i* pci:v000010DEd00000D84sv*sd*bc*sc*i* pci:v000010DEd00000ABFsv*sd*bc*sc*i* pci:v000010DEd00000ABEsv*sd*bc*sc*i* pci:v000010DEd00000ABDsv*sd*bc*sc*i* pci:v000010DEd00000ABCsv*sd*bc*sc*i* pci:v000010DEd00000ABBsv*sd*bc*sc*i* pci:v000010DEd00000ABAsv*sd*bc*sc*i* pci:v000010DEd00000AB9sv*sd*bc*sc*i* pci:v000010DEd00000AB8sv*sd*bc*sc*i* pci:v000010DEd00000AB7sv*sd*bc*sc*i* pci:v000010DEd00000AB6sv*sd*bc*sc*i* pci:v000010DEd00000AB5sv*sd*bc*sc*i* pci:v000010DEd00000AB4sv*sd*bc*sc*i* pci:v000010DEd00000ADBsv*sd*bc*sc*i* pci:v000010DEd00000ADAsv*sd*bc*sc*i* pci:v000010DEd00000AD9sv*sd*bc*sc*i* pci:v000010DEd00000AD8sv*sd*bc*sc*i* pci:v000010DEd00000AD7sv*sd*bc*sc*i* pci:v000010DEd00000AD6sv*sd*bc*sc*i* pci:v000010DEd00000AD5sv*sd*bc*sc*i* pci:v000010DEd00000AD4sv*sd*bc*sc*i* pci:v000010DEd00000AD3sv*sd*bc*sc*i* pci:v000010DEd00000AD2sv*sd*bc*sc*i* pci:v000010DEd00000AD1sv*sd*bc*sc*i* pci:v000010DEd00000AD0sv*sd*bc*sc*i* pci:v000010DEd000007FBsv*sd*bc*sc*i* pci:v000010DEd000007FAsv*sd*bc*sc*i* pci:v000010DEd000007F9sv*sd*bc*sc*i* pci:v000010DEd000007F8sv*sd*bc*sc*i* pci:v000010DEd000007F7sv*sd*bc*sc*i* pci:v000010DEd000007F6sv*sd*bc*sc*i* pci:v000010DEd000007F5sv*sd*bc*sc*i* pci:v000010DEd000007F4sv*sd*bc*sc*i* pci:v000010DEd000007F3sv*sd*bc*sc*i* pci:v000010DEd000007F2sv*sd*bc*sc*i* pci:v000010DEd000007F1sv*sd*bc*sc*i* pci:v000010DEd000007F0sv*sd*bc*sc*i* pci:v000010DEd0000058Fsv*sd*bc*sc*i* pci:v000010DEd0000058Esv*sd*bc*sc*i* pci:v000010DEd0000058Dsv*sd*bc*sc*i* pci:v000010DEd0000058Csv*sd*bc*sc*i* pci:v000010DEd0000058Bsv*sd*bc*sc*i* pci:v000010DEd0000058Asv*sd*bc*sc*i* pci:v000010DEd00000589sv*sd*bc*sc*i* pci:v000010DEd00000588sv*sd*bc*sc*i* pci:v000010DEd00000587sv*sd*bc*sc*i* pci:v000010DEd00000586sv*sd*bc*sc*i* pci:v000010DEd00000585sv*sd*bc*sc*i* pci:v000010DEd00000584sv*sd*bc*sc*i* pci:v000010DEd00000583sv*sd*bc*sc*i* pci:v000010DEd00000582sv*sd*bc*sc*i* pci:v000010DEd00000581sv*sd*bc*sc*i* pci:v000010DEd00000580sv*sd*bc*sc*i* pci:v000010DEd0000055Bsv*sd*bc*sc*i* pci:v000010DEd0000055Asv*sd*bc*sc*i* pci:v000010DEd00000559sv*sd*bc*sc*i* pci:v000010DEd00000558sv*sd*bc*sc*i* pci:v000010DEd00000557sv*sd*bc*sc*i* pci:v000010DEd00000556sv*sd*bc*sc*i* pci:v000010DEd00000555sv*sd*bc*sc*i* pci:v000010DEd00000554sv*sd*bc*sc*i* pci:v000010DEd00000553sv*sd*bc*sc*i* pci:v000010DEd00000552sv*sd*bc*sc*i* pci:v000010DEd00000551sv*sd*bc*sc*i* pci:v000010DEd00000550sv*sd*bc*sc*i* pci:v000010DEd0000045Fsv*sd*bc*sc*i* pci:v000010DEd0000045Esv*sd*bc*sc*i* pci:v000010DEd0000045Dsv*sd*bc*sc*i* pci:v000010DEd0000045Csv*sd*bc*sc*i* pci:v000010DEd0000044Fsv*sd*bc*sc*i* pci:v000010DEd0000044Esv*sd*bc*sc*i* pci:v000010DEd0000044Dsv*sd*bc*sc*i* pci:v000010DEd0000044Csv*sd*bc*sc*i* pci:v00001106d00006287sv*sd*bc*sc*i* pci:v00001106d00003349sv*sd*bc*sc*i* pci:v00008086d*sv00001028sd*bc01sc04i00* pci:v00001022d*sv*sd*bc01sc04i00* pci:v00001022d00007901sv*sd*bc*sc*i* pci:v00001022d00007900sv*sd*bc*sc*i* pci:v00001022d00007801sv*sd*bc*sc*i* pci:v00001022d00007800sv*sd*bc*sc*i* pci:v00001C36d00000031sv*sd*bc01sc06i01* pci:v00001002d00004395sv*sd*bc*sc*i* pci:v00001002d00004394sv*sd*bc*sc*i* pci:v00001002d00004393sv*sd*bc*sc*i* pci:v00001002d00004392sv*sd*bc*sc*i* pci:v00001002d00004391sv*sd*bc*sc*i* pci:v00001002d00004390sv*sd*bc*sc*i* pci:v00001002d00004380sv*sd*bc*sc*i* pci:v0000197Bd0000236Fsv*sd*bc*sc*i* pci:v0000197Bd00002362sv*sd*bc*sc*i* pci:v0000197Bd*sv*sd*bc01sc06i01* pci:v00008086d00004B63sv*sd*bc*sc*i* pci:v00008086d000002D7sv*sd*bc*sc*i* pci:v00008086d000002D3sv*sd*bc*sc*i* pci:v00008086d000034D3sv*sd*bc*sc*i* pci:v00008086d00005AE3sv*sd*bc*sc*i* pci:v00008086d000022A3sv*sd*bc*sc*i* pci:v00008086d00000F23sv*sd*bc*sc*i* pci:v00008086d00000F22sv*sd*bc*sc*i* pci:v00008086d0000A386sv*sd*bc*sc*i* pci:v00008086d000006D7sv*sd*bc*sc*i* pci:v00008086d0000A356sv*sd*bc*sc*i* pci:v00008086d0000A256sv*sd*bc*sc*i* pci:v00008086d0000A252sv*sd*bc*sc*i* pci:v00008086d0000A206sv*sd*bc*sc*i* pci:v00008086d0000A202sv*sd*bc*sc*i* pci:v00008086d0000A1D6sv*sd*bc*sc*i* pci:v00008086d0000A1D2sv*sd*bc*sc*i* pci:v00008086d0000A186sv*sd*bc*sc*i* pci:v00008086d0000A182sv*sd*bc*sc*i* pci:v00008086d0000A10Fsv*sd*bc*sc*i* pci:v00008086d0000A107sv*sd*bc*sc*i* pci:v00008086d0000A106sv*sd*bc*sc*i* pci:v00008086d0000A105sv*sd*bc*sc*i* pci:v00008086d0000A103sv*sd*bc*sc*i* pci:v00008086d0000A102sv*sd*bc*sc*i* pci:v00008086d00009D07sv*sd*bc*sc*i* pci:v00008086d00009D05sv*sd*bc*sc*i* pci:v00008086d00009D03sv*sd*bc*sc*i* pci:v00008086d00008C8Fsv*sd*bc*sc*i* pci:v00008086d00008C8Esv*sd*bc*sc*i* pci:v00008086d00008C87sv*sd*bc*sc*i* pci:v00008086d00008C86sv*sd*bc*sc*i* pci:v00008086d00008C85sv*sd*bc*sc*i* pci:v00008086d00008C84sv*sd*bc*sc*i* pci:v00008086d00008C83sv*sd*bc*sc*i* pci:v00008086d00008C82sv*sd*bc*sc*i* pci:v00008086d00009C8Fsv*sd*bc*sc*i* pci:v00008086d00009C87sv*sd*bc*sc*i* pci:v00008086d00009C85sv*sd*bc*sc*i* pci:v00008086d00009C83sv*sd*bc*sc*i* pci:v00008086d000023A3sv*sd*bc*sc*i* pci:v00008086d00008D6Esv*sd*bc*sc*i* pci:v00008086d00008D66sv*sd*bc*sc*i* pci:v00008086d00008D64sv*sd*bc*sc*i* pci:v00008086d00008D62sv*sd*bc*sc*i* pci:v00008086d00008D0Esv*sd*bc*sc*i* pci:v00008086d00008D06sv*sd*bc*sc*i* pci:v00008086d00008D04sv*sd*bc*sc*i* pci:v00008086d00008D02sv*sd*bc*sc*i* pci:v00008086d000043D7sv*sd*bc*sc*i* pci:v00008086d000043D6sv*sd*bc*sc*i* pci:v00008086d000043D5sv*sd*bc*sc*i* pci:v00008086d000043D4sv*sd*bc*sc*i* pci:v00008086d0000282Fsv*sd*bc*sc*i* pci:v00008086d00002827sv*sd*bc*sc*i* pci:v00008086d00002826sv*sd*bc*sc*i* pci:v00008086d00002823sv*sd*bc*sc*i* pci:v00008086d00001F3Fsv*sd*bc*sc*i* pci:v00008086d00001F3Esv*sd*bc*sc*i* pci:v00008086d00001F37sv*sd*bc*sc*i* pci:v00008086d00001F36sv*sd*bc*sc*i* pci:v00008086d00001F35sv*sd*bc*sc*i* pci:v00008086d00001F34sv*sd*bc*sc*i* pci:v00008086d00001F33sv*sd*bc*sc*i* pci:v00008086d00001F32sv*sd*bc*sc*i* pci:v00008086d00001F2Fsv*sd*bc*sc*i* pci:v00008086d00001F2Esv*sd*bc*sc*i* pci:v00008086d00001F27sv*sd*bc*sc*i* pci:v00008086d00001F26sv*sd*bc*sc*i* pci:v00008086d00001F25sv*sd*bc*sc*i* pci:v00008086d00001F24sv*sd*bc*sc*i* pci:v00008086d00001F23sv*sd*bc*sc*i* pci:v00008086d00001F22sv*sd*bc*sc*i* pci:v00008086d00009DD3sv*sd*bc*sc*i* pci:v00008086d00009C0Fsv*sd*bc*sc*i* pci:v00008086d00009C0Esv*sd*bc*sc*i* pci:v00008086d00009C07sv*sd*bc*sc*i* pci:v00008086d00009C06sv*sd*bc*sc*i* pci:v00008086d00009C05sv*sd*bc*sc*i* pci:v00008086d00009C04sv*sd*bc*sc*i* pci:v00008086d00009C03sv*sd*bc*sc*i* pci:v00008086d00009C02sv*sd*bc*sc*i* pci:v00008086d00008C0Fsv*sd*bc*sc*i* pci:v00008086d00008C0Esv*sd*bc*sc*i* pci:v00008086d00008C07sv*sd*bc*sc*i* pci:v00008086d00008C06sv*sd*bc*sc*i* pci:v00008086d00008C05sv*sd*bc*sc*i* pci:v00008086d00008C04sv*sd*bc*sc*i* pci:v00008086d00008C03sv*sd*bc*sc*i* pci:v00008086d00008C02sv*sd*bc*sc*i* pci:v00008086d00001E0Esv*sd*bc*sc*i* pci:v00008086d00001E07sv*sd*bc*sc*i* pci:v00008086d00001E06sv*sd*bc*sc*i* pci:v00008086d00001E05sv*sd*bc*sc*i* pci:v00008086d00001E04sv*sd*bc*sc*i* pci:v00008086d00001E03sv*sd*bc*sc*i* pci:v00008086d00001E02sv*sd*bc*sc*i* pci:v00008086d00002323sv*sd*bc*sc*i* pci:v00008086d00001D06sv*sd*bc*sc*i* pci:v00008086d00001D04sv*sd*bc*sc*i* pci:v00008086d00001D02sv*sd*bc*sc*i* pci:v00008086d00001C07sv*sd*bc*sc*i* pci:v00008086d00001C06sv*sd*bc*sc*i* pci:v00008086d00001C05sv*sd*bc*sc*i* pci:v00008086d00001C04sv*sd*bc*sc*i* pci:v00008086d00001C03sv*sd*bc*sc*i* pci:v00008086d00001C02sv*sd*bc*sc*i* pci:v00008086d000019CFsv*sd*bc*sc*i* pci:v00008086d000019CEsv*sd*bc*sc*i* pci:v00008086d000019C7sv*sd*bc*sc*i* pci:v00008086d000019C6sv*sd*bc*sc*i* pci:v00008086d000019C5sv*sd*bc*sc*i* pci:v00008086d000019C4sv*sd*bc*sc*i* pci:v00008086d000019C3sv*sd*bc*sc*i* pci:v00008086d000019C2sv*sd*bc*sc*i* pci:v00008086d000019C1sv*sd*bc*sc*i* pci:v00008086d000019C0sv*sd*bc*sc*i* pci:v00008086d000019BFsv*sd*bc*sc*i* pci:v00008086d000019BEsv*sd*bc*sc*i* pci:v00008086d000019B7sv*sd*bc*sc*i* pci:v00008086d000019B6sv*sd*bc*sc*i* pci:v00008086d000019B5sv*sd*bc*sc*i* pci:v00008086d000019B4sv*sd*bc*sc*i* pci:v00008086d000019B3sv*sd*bc*sc*i* pci:v00008086d000019B2sv*sd*bc*sc*i* pci:v00008086d000019B1sv*sd*bc*sc*i* pci:v00008086d000019B0sv*sd*bc*sc*i* pci:v00008086d00003B2Fsv*sd*bc*sc*i* pci:v00008086d00003B2Csv*sd*bc*sc*i* pci:v00008086d00003B2Bsv*sd*bc*sc*i* pci:v00008086d00003B29sv*sd*bc*sc*i* pci:v00008086d00003B25sv*sd*bc*sc*i* pci:v00008086d00003B24sv*sd*bc*sc*i* pci:v00008086d00003B23sv*sd*bc*sc*i* pci:v00008086d00003B22sv*sd*bc*sc*i* pci:v00008086d00003A25sv*sd*bc*sc*i* pci:v00008086d00003A22sv*sd*bc*sc*i* pci:v00008086d00003A05sv*sd*bc*sc*i* pci:v00008086d0000502Bsv*sd*bc*sc*i* pci:v00008086d0000502Asv*sd*bc*sc*i* pci:v00008086d0000294Esv*sd*bc*sc*i* pci:v00008086d0000294Dsv*sd*bc*sc*i* pci:v00008086d0000292Fsv*sd*bc*sc*i* pci:v00008086d0000292Csv*sd*bc*sc*i* pci:v00008086d0000292Bsv*sd*bc*sc*i* pci:v00008086d0000292Asv*sd*bc*sc*i* pci:v00008086d00002929sv*sd*bc*sc*i* pci:v00008086d00002927sv*sd*bc*sc*i* pci:v00008086d00002925sv*sd*bc*sc*i* pci:v00008086d00002924sv*sd*bc*sc*i* pci:v00008086d00002923sv*sd*bc*sc*i* pci:v00008086d00002922sv*sd*bc*sc*i* pci:v00008086d0000282Asv*sd*bc*sc*i* pci:v00008086d00002829sv*sd*bc*sc*i* pci:v00008086d00002824sv*sd*bc*sc*i* pci:v00008086d00002822sv*sd*bc*sc*i* pci:v00008086d00002821sv*sd*bc*sc*i* pci:v00008086d000027C6sv*sd*bc*sc*i* pci:v00008086d00002683sv*sd*bc*sc*i* pci:v00008086d00002682sv*sd*bc*sc*i* pci:v00008086d00002681sv*sd*bc*sc*i* pci:v000010B9d00005288sv*sd*bc*sc*i* pci:v00008086d000027C3sv*sd*bc*sc*i* pci:v00008086d000027C5sv*sd*bc*sc*i* pci:v00008086d000027C1sv*sd*bc*sc*i* pci:v00008086d00002653sv*sd*bc*sc*i* pci:v00008086d00002652sv*sd*bc*sc*i* pci:v00008086d000006D6sv*sd*bc*sc*i*
libata libahci

kernel/drivers/ata/libata.ko.xz symbol:ata_link_next symbol:ata_dev_next symbol:atapi_cmd_type symbol:ata_pack_xfermask symbol:ata_xfer_mask2mode symbol:ata_xfer_mode2mask symbol:ata_xfer_mode2shift symbol:ata_mode_string symbol:ata_dev_classify symbol:ata_id_string symbol:ata_id_c_string symbol:ata_id_xfermask symbol:ata_pio_need_iordy symbol:ata_do_dev_read_id symbol:ata_cable_40wire symbol:ata_cable_80wire symbol:ata_cable_unknown symbol:ata_cable_ignore symbol:ata_cable_sata symbol:ata_dev_pair symbol:ata_do_set_mode symbol:ata_wait_after_reset symbol:ata_std_prereset symbol:ata_std_postreset symbol:ata_dev_set_feature symbol:ata_std_qc_defer symbol:ata_qc_complete symbol:ata_qc_get_active symbol:ata_link_online symbol:ata_link_offline symbol:ata_sas_port_suspend symbol:ata_sas_port_resume symbol:ata_host_suspend symbol:ata_host_resume symbol:ata_port_alloc symbol:ata_port_free symbol:ata_host_put symbol:ata_host_alloc symbol:ata_host_alloc_pinfo symbol:ata_host_start symbol:ata_host_init symbol:ata_port_probe symbol:ata_host_register symbol:ata_host_activate symbol:ata_host_detach symbol:ata_pci_remove_one symbol:ata_pci_shutdown_one symbol:pci_test_config_bits symbol:ata_pci_device_do_suspend symbol:ata_pci_device_do_resume symbol:ata_pci_device_suspend symbol:ata_pci_device_resume symbol:ata_platform_remove_one symbol:ata_ratelimit symbol:ata_msleep symbol:ata_wait_register symbol:ata_dummy_port_ops symbol:ata_dummy_port_info symbol:ata_print_version symbol:__tracepoint_ata_tf_load symbol:__traceiter_ata_tf_load symbol:__SCK__tp_func_ata_tf_load symbol:__tracepoint_ata_exec_command symbol:__traceiter_ata_exec_command symbol:__SCK__tp_func_ata_exec_command symbol:__tracepoint_ata_bmdma_setup symbol:__traceiter_ata_bmdma_setup symbol:__SCK__tp_func_ata_bmdma_setup symbol:__tracepoint_ata_bmdma_start symbol:__traceiter_ata_bmdma_start symbol:__SCK__tp_func_ata_bmdma_start symbol:__tracepoint_ata_bmdma_status symbol:__traceiter_ata_bmdma_status symbol:__SCK__tp_func_ata_bmdma_status symbol:dev_attr_unload_heads symbol:ata_common_sdev_groups symbol:ata_std_bios_param symbol:ata_scsi_unlock_native_capacity symbol:ata_sas_scsi_ioctl symbol:ata_scsi_ioctl symbol:ata_scsi_dma_need_drain symbol:ata_scsi_slave_alloc symbol:ata_scsi_device_configure symbol:ata_scsi_slave_destroy symbol:ata_scsi_queuecmd symbol:__ata_ehi_push_desc symbol:ata_ehi_push_desc symbol:ata_ehi_clear_desc symbol:ata_port_desc symbol:ata_port_pbar_desc symbol:ata_scsi_cmd_error_handler symbol:ata_scsi_port_error_handler symbol:ata_port_wait_eh symbol:ata_std_sched_eh symbol:ata_std_end_eh symbol:ata_port_schedule_eh symbol:ata_link_abort symbol:ata_port_abort symbol:ata_port_freeze symbol:ata_eh_freeze_port symbol:ata_dev_disable symbol:ata_get_cmd_name symbol:ata_std_error_handler symbol:ata_tport_delete symbol:ata_tport_add symbol:ata_port_classify symbol:sata_deb_timing_normal symbol:sata_deb_timing_hotplug symbol:sata_deb_timing_long symbol:sata_scr_valid symbol:sata_scr_read symbol:sata_scr_write symbol:sata_scr_write_flush symbol:ata_tf_to_fis symbol:ata_tf_from_fis symbol:sata_link_debounce symbol:sata_link_resume symbol:sata_link_scr_lpm symbol:sata_set_spd symbol:sata_link_hardreset symbol:sata_std_hardreset symbol:ata_qc_complete_multiple symbol:ata_slave_link_init symbol:sata_lpm_ignore_phy_events symbol:dev_attr_link_power_management_supported symbol:dev_attr_link_power_management_policy symbol:ata_ncq_prio_supported symbol:dev_attr_ncq_prio_supported symbol:ata_ncq_prio_enabled symbol:ata_ncq_prio_enable symbol:dev_attr_ncq_prio_enable symbol:ata_ncq_sdev_groups symbol:dev_attr_em_message symbol:dev_attr_em_message_type symbol:dev_attr_sw_activity symbol:ata_change_queue_depth symbol:ata_scsi_change_queue_depth symbol:ata_sas_device_configure symbol:ata_sas_queuecmd symbol:sata_async_notification symbol:ata_eh_analyze_ncq_error symbol:sata_port_ops symbol:ata_sff_port_ops symbol:ata_sff_check_status symbol:ata_sff_pause symbol:ata_sff_dma_pause symbol:ata_sff_wait_ready symbol:ata_sff_dev_select symbol:ata_sff_irq_on symbol:ata_sff_tf_load symbol:ata_sff_tf_read symbol:ata_sff_exec_command symbol:ata_sff_data_xfer symbol:ata_sff_data_xfer32 symbol:ata_sff_hsm_move symbol:ata_sff_queue_work symbol:ata_sff_queue_delayed_work symbol:ata_sff_queue_pio_task symbol:ata_sff_qc_issue symbol:ata_sff_qc_fill_rtf symbol:ata_sff_port_intr symbol:ata_sff_interrupt symbol:ata_sff_lost_interrupt symbol:ata_sff_freeze symbol:ata_sff_thaw symbol:ata_sff_prereset symbol:ata_sff_dev_classify symbol:ata_sff_wait_after_reset symbol:ata_sff_softreset symbol:sata_sff_hardreset symbol:ata_sff_postreset symbol:ata_sff_drain_fifo symbol:ata_sff_error_handler symbol:ata_sff_std_ports symbol:ata_pci_sff_init_host symbol:ata_pci_sff_prepare_host symbol:ata_pci_sff_activate_host symbol:ata_pci_sff_init_one symbol:ata_bmdma_port_ops symbol:ata_bmdma32_port_ops symbol:ata_bmdma_qc_prep symbol:ata_bmdma_dumb_qc_prep symbol:ata_bmdma_qc_issue symbol:ata_bmdma_port_intr symbol:ata_bmdma_interrupt symbol:ata_bmdma_error_handler symbol:ata_bmdma_post_internal_cmd symbol:ata_bmdma_irq_clear symbol:ata_bmdma_setup symbol:ata_bmdma_start symbol:ata_bmdma_stop symbol:ata_bmdma_status symbol:ata_bmdma_port_start symbol:ata_bmdma_port_start32 symbol:ata_pci_bmdma_clear_simplex symbol:ata_pci_bmdma_init symbol:ata_pci_bmdma_prepare_host symbol:ata_pci_bmdma_init_one symbol:sata_pmp_port_ops symbol:sata_pmp_qc_defer_cmd_switch symbol:sata_pmp_error_handler

kernel/drivers/connector/cn.ko.xz net_pf_16_proto_11 symbol:cn_netlink_send_mult symbol:cn_netlink_send symbol:cn_add_callback symbol:cn_del_callback

kernel/drivers/perf/raspberrypi_axi_monitor.ko.xz of:N*T*Cbrcm,bcm2712_axiperfC* of:N*T*Cbrcm,bcm2712_axiperf of:N*T*Cbrcm,bcm2711_axiperfC* of:N*T*Cbrcm,bcm2711_axiperf of:N*T*Cbrcm,bcm2835_axiperfC* of:N*T*Cbrcm,bcm2835_axiperf

kernel/drivers/power/supply/rpi_poe_power.ko.xz platform:rpi_poe_power_supply of:N*T*Craspberrypi,rpi_poe_power_supplyC* of:N*T*Craspberrypi,rpi_poe_power_supply

kernel/drivers/power/supply/ds2760_battery.ko.xz w1_family_0x30
wire

kernel/drivers/power/supply/ltc2941-battery-gauge.ko.xz i2c:ltc2944 i2c:ltc2943 i2c:ltc2942 i2c:ltc2941 of:N*T*Clltc,ltc2944C* of:N*T*Clltc,ltc2944 of:N*T*Clltc,ltc2943C* of:N*T*Clltc,ltc2943 of:N*T*Clltc,ltc2942C* of:N*T*Clltc,ltc2942 of:N*T*Clltc,ltc2941C* of:N*T*Clltc,ltc2941

kernel/drivers/power/supply/gpio-charger.ko.xz platform:gpio_charger of:N*T*Cgpio_chargerC* of:N*T*Cgpio_charger

kernel/drivers/power/supply/max17040_battery.ko.xz i2c:max17059 i2c:max17058 i2c:max17049 i2c:max17048 i2c:max17044 i2c:max77836_battery i2c:max17043 i2c:max17041 i2c:max17040 of:N*T*Cmaxim,max17059C* of:N*T*Cmaxim,max17059 of:N*T*Cmaxim,max17058C* of:N*T*Cmaxim,max17058 of:N*T*Cmaxim,max17049C* of:N*T*Cmaxim,max17049 of:N*T*Cmaxim,max17048C* of:N*T*Cmaxim,max17048 of:N*T*Cmaxim,max17044C* of:N*T*Cmaxim,max17044 of:N*T*Cmaxim,max77836_batteryC* of:N*T*Cmaxim,max77836_battery of:N*T*Cmaxim,max17043C* of:N*T*Cmaxim,max17043 of:N*T*Cmaxim,max17041C* of:N*T*Cmaxim,max17041 of:N*T*Cmaxim,max17040C* of:N*T*Cmaxim,max17040
industrialio regmap_i2c

kernel/drivers/iio/health/max30102.ko.xz i2c:max30105 i2c:max30102 i2c:max30101 of:N*T*Cmaxim,max30105C* of:N*T*Cmaxim,max30105 of:N*T*Cmaxim,max30102C* of:N*T*Cmaxim,max30102 of:N*T*Cmaxim,max30101C* of:N*T*Cmaxim,max30101
industrialio kfifo_buf regmap_i2c

kernel/drivers/iio/humidity/hdc3020.ko.xz i2c:hdc3022 i2c:hdc3021 i2c:hdc3020 of:N*T*Cti,hdc3022C* of:N*T*Cti,hdc3022 of:N*T*Cti,hdc3021C* of:N*T*Cti,hdc3021 of:N*T*Cti,hdc3020C* of:N*T*Cti,hdc3020
crc8 industrialio

kernel/drivers/iio/humidity/hts221_i2c.ko.xz acpi*:SMO9100:* of:N*T*Cst,hts221C* of:N*T*Cst,hts221 i2c:hts221
regmap_i2c hts221

kernel/drivers/iio/humidity/si7020.ko.xz i2c:th06 i2c:si7020 of:N*T*Csilabs,si7020C* of:N*T*Csilabs,si7020
industrialio

kernel/drivers/iio/humidity/hdc100x.ko.xz i2c:hdc1080 i2c:hdc1050 i2c:hdc1010 i2c:hdc1008 i2c:hdc1000 i2c:hdc100x of:N*T*Cti,hdc1080C* of:N*T*Cti,hdc1080 of:N*T*Cti,hdc1050C* of:N*T*Cti,hdc1050 of:N*T*Cti,hdc1010C* of:N*T*Cti,hdc1010 of:N*T*Cti,hdc1008C* of:N*T*Cti,hdc1008 of:N*T*Cti,hdc1000C* of:N*T*Cti,hdc1000 acpi*:TXNW1010:*
industrialio industrialio_triggered_buffer

kernel/drivers/iio/humidity/dht11.ko.xz of:N*T*Cdht11C* of:N*T*Cdht11
industrialio

kernel/drivers/iio/humidity/htu21.ko.xz i2c:ms8607_humidity i2c:htu21 of:N*T*Cmeas,ms8607_humidityC* of:N*T*Cmeas,ms8607_humidity of:N*T*Cmeas,htu21C* of:N*T*Cmeas,htu21
industrialio ms_sensors_i2c

kernel/drivers/iio/humidity/hts221.ko.xz symbol:hts221_probe
industrialio_triggered_buffer industrialio

kernel/drivers/iio/humidity/hts221_spi.ko.xz of:N*T*Cst,hts221C* of:N*T*Cst,hts221 spi:hts221
regmap_spi hts221

kernel/drivers/iio/imu/bno055/bno055_i2c.ko.xz i2c:bno055 of:N*T*Cbosch,bno055C* of:N*T*Cbosch,bno055
bno055 regmap_i2c

kernel/drivers/iio/imu/bno055/bno055.ko.xz symbol:bno055_regmap_config symbol:bno055_probe
industrialio industrialio_triggered_buffer

kernel/drivers/iio/imu/inv_mpu6050/inv-mpu6050-i2c.ko.xz of:N*T*Cinvensense,iam20680C* of:N*T*Cinvensense,iam20680 of:N*T*Cinvensense,icm20690C* of:N*T*Cinvensense,icm20690 of:N*T*Cinvensense,icm20602C* of:N*T*Cinvensense,icm20602 of:N*T*Cinvensense,icm20600C* of:N*T*Cinvensense,icm20600 of:N*T*Cinvensense,icm20689C* of:N*T*Cinvensense,icm20689 of:N*T*Cinvensense,icm20609C* of:N*T*Cinvensense,icm20609 of:N*T*Cinvensense,icm20608dC* of:N*T*Cinvensense,icm20608d of:N*T*Cinvensense,icm20608C* of:N*T*Cinvensense,icm20608 of:N*T*Cinvensense,mpu9255C* of:N*T*Cinvensense,mpu9255 of:N*T*Cinvensense,mpu9250C* of:N*T*Cinvensense,mpu9250 of:N*T*Cinvensense,mpu9150C* of:N*T*Cinvensense,mpu9150 of:N*T*Cinvensense,mpu6880C* of:N*T*Cinvensense,mpu6880 of:N*T*Cinvensense,mpu6515C* of:N*T*Cinvensense,mpu6515 of:N*T*Cinvensense,mpu6500C* of:N*T*Cinvensense,mpu6500 of:N*T*Cinvensense,mpu6050C* of:N*T*Cinvensense,mpu6050 i2c:iam20680 i2c:icm20690 i2c:icm20602 i2c:icm20600 i2c:icm20689 i2c:icm20609 i2c:icm20608d i2c:icm20608 i2c:mpu9255 i2c:mpu9250 i2c:mpu9150 i2c:mpu6880 i2c:mpu6515 i2c:mpu6500 i2c:mpu6050 acpi*:INVN6500:*
inv_mpu6050 regmap_i2c i2c_mux

kernel/drivers/iio/imu/inv_mpu6050/inv-mpu6050.ko.xz symbol:inv_mpu_core_probe symbol:inv_mpu_pmops
industrialio industrialio_triggered_buffer inv_sensors_timestamp

kernel/drivers/iio/common/ms_sensors/ms_sensors_i2c.ko.xz symbol:ms_sensors_reset symbol:ms_sensors_read_prom_word symbol:ms_sensors_convert_and_read symbol:ms_sensors_read_serial symbol:ms_sensors_write_resolution symbol:ms_sensors_show_battery_low symbol:ms_sensors_show_heater symbol:ms_sensors_write_heater symbol:ms_sensors_ht_read_temperature symbol:ms_sensors_ht_read_humidity symbol:ms_sensors_tp_read_prom symbol:ms_sensors_read_temp_and_pressure

kernel/drivers/iio/common/inv_sensors/inv_sensors_timestamp.ko.xz symbol:inv_sensors_timestamp_init symbol:inv_sensors_timestamp_update_odr symbol:inv_sensors_timestamp_interrupt symbol:inv_sensors_timestamp_apply_odr

kernel/drivers/iio/pressure/bmp280-i2c.ko.xz of:N*T*Cbosch,bmp580C* of:N*T*Cbosch,bmp580 of:N*T*Cbosch,bmp380C* of:N*T*Cbosch,bmp380 of:N*T*Cbosch,bme280C* of:N*T*Cbosch,bme280 of:N*T*Cbosch,bmp280C* of:N*T*Cbosch,bmp280 of:N*T*Cbosch,bmp180C* of:N*T*Cbosch,bmp180 of:N*T*Cbosch,bmp085C* of:N*T*Cbosch,bmp085 i2c:bmp580 i2c:bmp380 i2c:bme280 i2c:bmp280 i2c:bmp180 i2c:bmp085
regmap_i2c bmp280

kernel/drivers/iio/pressure/bmp280-spi.ko.xz of:N*T*Cbosch,bmp580C* of:N*T*Cbosch,bmp580 of:N*T*Cbosch,bmp380C* of:N*T*Cbosch,bmp380 of:N*T*Cbosch,bme280C* of:N*T*Cbosch,bme280 of:N*T*Cbosch,bmp280C* of:N*T*Cbosch,bmp280 of:N*T*Cbosch,bmp181C* of:N*T*Cbosch,bmp181 of:N*T*Cbosch,bmp180C* of:N*T*Cbosch,bmp180 of:N*T*Cbosch,bmp085C* of:N*T*Cbosch,bmp085 spi:bmp580 spi:bmp380 spi:bme280 spi:bmp280 spi:bmp181 spi:bmp180 spi:bmp085
bmp280

kernel/drivers/iio/pressure/bmp280.ko.xz symbol:bmp280_chip_info symbol:bme280_chip_info symbol:bmp380_chip_info symbol:bmp580_chip_info symbol:bmp180_chip_info symbol:bmp280_common_probe symbol:bmp280_dev_pm_ops symbol:bmp180_regmap_config symbol:bmp280_regmap_config symbol:bme280_regmap_config symbol:bmp380_regmap_config symbol:bmp580_regmap_config
industrialio_triggered_buffer industrialio

kernel/drivers/iio/pressure/ms5637.ko.xz i2c:ms8607_temppressure i2c:ms5837 i2c:ms5805 i2c:ms5637 of:N*T*Cmeas,ms8607_temppressureC* of:N*T*Cmeas,ms8607_temppressure of:N*T*Cmeas,ms5837C* of:N*T*Cmeas,ms5837 of:N*T*Cmeas,ms5805C* of:N*T*Cmeas,ms5805 of:N*T*Cmeas,ms5803C* of:N*T*Cmeas,ms5803 of:N*T*Cmeas,ms5637C* of:N*T*Cmeas,ms5637
industrialio ms_sensors_i2c

kernel/drivers/iio/light/tcs3472.ko.xz i2c:tcs3472
industrialio industrialio_triggered_buffer

kernel/drivers/iio/light/veml6040.ko.xz i2c:veml6040 of:N*T*Cvishay,veml6040C* of:N*T*Cvishay,veml6040
industrialio regmap_i2c

kernel/drivers/iio/light/as73211.ko.xz of:N*T*Cams,as7331C* of:N*T*Cams,as7331 of:N*T*Cams,as73211C* of:N*T*Cams,as73211 i2c:as7331 i2c:as73211
industrialio industrialio_triggered_buffer

kernel/drivers/iio/light/veml6075.ko.xz i2c:veml6075 of:N*T*Cvishay,veml6075C* of:N*T*Cvishay,veml6075
industrialio regmap_i2c

kernel/drivers/iio/light/veml6030.ko.xz of:N*T*Cvishay,veml6030C* of:N*T*Cvishay,veml6030 i2c:veml6030
industrialio regmap_i2c

kernel/drivers/iio/light/apds9960.ko.xz i2c:apds9960 acpi*:MSHW0184:* of:N*T*Cavago,apds9960C* of:N*T*Cavago,apds9960
industrialio kfifo_buf regmap_i2c

kernel/drivers/iio/light/veml6070.ko.xz i2c:veml6070 of:N*T*Cvishay,veml6070C* of:N*T*Cvishay,veml6070
industrialio

kernel/drivers/iio/light/bh1750.ko.xz i2c:bh1751 i2c:bh1750 i2c:bh1721 i2c:bh1715 i2c:bh1710 of:N*T*Crohm,bh1751C* of:N*T*Crohm,bh1751 of:N*T*Crohm,bh1750C* of:N*T*Crohm,bh1750 of:N*T*Crohm,bh1721C* of:N*T*Crohm,bh1721 of:N*T*Crohm,bh1715C* of:N*T*Crohm,bh1715 of:N*T*Crohm,bh1710C* of:N*T*Crohm,bh1710
industrialio

kernel/drivers/iio/light/tsl4531.ko.xz i2c:tsl4531 of:N*T*Camstaos,tsl4531C* of:N*T*Camstaos,tsl4531
industrialio

kernel/drivers/iio/temperature/tmp117.ko.xz of:N*T*Cti,tmp117C* of:N*T*Cti,tmp117 of:N*T*Cti,tmp116C* of:N*T*Cti,tmp116 i2c:tmp117 i2c:tmp116
industrialio

kernel/drivers/iio/temperature/max31856.ko.xz spi:max31856 of:N*T*Cmaxim,max31856C* of:N*T*Cmaxim,max31856
industrialio

kernel/drivers/iio/temperature/maxim_thermocouple.ko.xz spi:max31855r spi:max31855e spi:max31855t spi:max31855s spi:max31855n spi:max31855j spi:max31855k spi:max31855 spi:max6675 of:N*T*Cmaxim,max31855rC* of:N*T*Cmaxim,max31855r of:N*T*Cmaxim,max31855eC* of:N*T*Cmaxim,max31855e of:N*T*Cmaxim,max31855tC* of:N*T*Cmaxim,max31855t of:N*T*Cmaxim,max31855sC* of:N*T*Cmaxim,max31855s of:N*T*Cmaxim,max31855nC* of:N*T*Cmaxim,max31855n of:N*T*Cmaxim,max31855jC* of:N*T*Cmaxim,max31855j of:N*T*Cmaxim,max31855kC* of:N*T*Cmaxim,max31855k of:N*T*Cmaxim,max31855C* of:N*T*Cmaxim,max31855 of:N*T*Cmaxim,max6675C* of:N*T*Cmaxim,max6675
industrialio industrialio_triggered_buffer

kernel/drivers/iio/accel/adxl355_i2c.ko.xz i2c:adxl359 i2c:adxl355 of:N*T*Cadi,adxl359C* of:N*T*Cadi,adxl359 of:N*T*Cadi,adxl355C* of:N*T*Cadi,adxl355
regmap_i2c adxl355_core

kernel/drivers/iio/accel/adxl355_core.ko.xz symbol:adxl355_readable_regs_tbl symbol:adxl355_writeable_regs_tbl symbol:adxl35x_chip_info symbol:adxl355_core_probe
industrialio industrialio_triggered_buffer

kernel/drivers/iio/trigger/iio-trig-hrtimer.ko.xz
industrialio_sw_trigger industrialio

kernel/drivers/iio/trigger/iio-trig-interrupt.ko.xz
industrialio

kernel/drivers/iio/trigger/iio-trig-sysfs.ko.xz platform:iio_trig_sysfs
industrialio

kernel/drivers/iio/industrialio-sw-trigger.ko.xz symbol:iio_register_sw_trigger_type symbol:iio_unregister_sw_trigger_type symbol:iio_sw_trigger_create symbol:iio_sw_trigger_destroy
industrialio_configfs

kernel/drivers/iio/industrialio-configfs.ko.xz symbol:iio_configfs_subsys

kernel/drivers/iio/buffer/kfifo_buf.ko.xz symbol:iio_kfifo_allocate symbol:iio_kfifo_free symbol:devm_iio_kfifo_buffer_setup_ext
industrialio

kernel/drivers/iio/buffer/industrialio-triggered-buffer.ko.xz symbol:iio_triggered_buffer_setup_ext symbol:iio_triggered_buffer_cleanup symbol:devm_iio_triggered_buffer_setup_ext
kfifo_buf industrialio

kernel/drivers/iio/buffer/industrialio-buffer-cb.ko.xz symbol:iio_channel_get_all_cb symbol:iio_channel_cb_set_buffer_watermark symbol:iio_channel_start_all_cb symbol:iio_channel_stop_all_cb symbol:iio_channel_release_all_cb symbol:iio_channel_cb_get_channels symbol:iio_channel_cb_get_iio_dev
industrialio

kernel/drivers/iio/chemical/sps30_i2c.ko.xz i2c:sps30 of:N*T*Csensirion,sps30C* of:N*T*Csensirion,sps30
crc8 sps30

kernel/drivers/iio/chemical/bme680_spi.ko.xz spi:bme680 of:N*T*Cbosch,bme680C* of:N*T*Cbosch,bme680
bme680_core

kernel/drivers/iio/chemical/sgp30.ko.xz of:N*T*Csensirion,sgpc3C* of:N*T*Csensirion,sgpc3 of:N*T*Csensirion,sgp30C* of:N*T*Csensirion,sgp30 i2c:sgpc3 i2c:sgp30
crc8 industrialio

kernel/drivers/iio/chemical/scd4x.ko.xz of:N*T*Csensirion,scd41C* of:N*T*Csensirion,scd41 of:N*T*Csensirion,scd40C* of:N*T*Csensirion,scd40
crc8 industrialio industrialio_triggered_buffer

kernel/drivers/iio/chemical/bme680_core.ko.xz symbol:bme680_regmap_config symbol:bme680_core_probe
industrialio

kernel/drivers/iio/chemical/ccs811.ko.xz i2c:ccs811 of:N*T*Cams,ccs811C* of:N*T*Cams,ccs811
industrialio industrialio_triggered_buffer

kernel/drivers/iio/chemical/bme680_i2c.ko.xz i2c:bme680 of:N*T*Cbosch,bme680C* of:N*T*Cbosch,bme680
bme680_core regmap_i2c

kernel/drivers/iio/chemical/sps30.ko.xz symbol:sps30_probe
industrialio industrialio_triggered_buffer

kernel/drivers/iio/industrialio.ko.xz symbol:iio_bus_type symbol:iio_device_id symbol:iio_buffer_enabled symbol:iio_get_debugfs_dentry symbol:iio_read_const_attr symbol:iio_device_set_clock symbol:iio_device_get_clock symbol:iio_get_time_ns symbol:iio_enum_available_read symbol:iio_enum_read symbol:iio_enum_write symbol:iio_show_mount_matrix symbol:iio_read_mount_matrix symbol:iio_format_value symbol:iio_str_to_fixpoint symbol:iio_device_alloc symbol:iio_device_free symbol:devm_iio_device_alloc symbol:iio_active_scan_mask_index symbol:__iio_device_register symbol:iio_device_unregister symbol:__devm_iio_device_register symbol:iio_device_claim_direct_mode symbol:iio_device_release_direct_mode symbol:iio_device_claim_buffer_mode symbol:iio_device_release_buffer_mode symbol:iio_device_get_current_mode symbol:iio_push_event symbol:iio_map_array_register symbol:iio_map_array_unregister symbol:devm_iio_map_array_register symbol:fwnode_iio_channel_get_by_name symbol:iio_channel_get symbol:iio_channel_release symbol:devm_iio_channel_get symbol:devm_fwnode_iio_channel_get_by_name symbol:iio_channel_get_all symbol:iio_channel_release_all symbol:devm_iio_channel_get_all symbol:iio_read_channel_raw symbol:iio_read_channel_average_raw symbol:iio_convert_raw_to_processed symbol:iio_read_channel_attribute symbol:iio_read_channel_offset symbol:iio_read_channel_processed_scale symbol:iio_read_channel_processed symbol:iio_read_channel_scale symbol:iio_read_avail_channel_attribute symbol:iio_read_avail_channel_raw symbol:iio_read_max_channel_raw symbol:iio_read_min_channel_raw symbol:iio_get_channel_type symbol:iio_write_channel_attribute symbol:iio_write_channel_raw symbol:iio_get_channel_ext_info_count symbol:iio_read_channel_ext_info symbol:iio_write_channel_ext_info symbol:iio_read_channel_label symbol:iio_pop_from_buffer symbol:iio_buffer_init symbol:iio_update_buffers symbol:iio_buffer_signal_dmabuf_done symbol:iio_validate_scan_mask_onehot symbol:iio_push_to_buffers symbol:iio_push_to_buffers_with_ts_unaligned symbol:iio_buffer_get symbol:iio_buffer_put symbol:iio_device_attach_buffer symbol:iio_trigger_register symbol:iio_trigger_unregister symbol:iio_trigger_set_immutable symbol:iio_trigger_poll symbol:iio_trigger_generic_data_rdy_poll symbol:iio_trigger_poll_nested symbol:iio_trigger_notify_done symbol:iio_pollfunc_store_time symbol:iio_alloc_pollfunc symbol:iio_dealloc_pollfunc symbol:__iio_trigger_alloc symbol:iio_trigger_free symbol:__devm_iio_trigger_alloc symbol:devm_iio_trigger_register symbol:iio_trigger_using_own symbol:iio_validate_own_trigger symbol:iio_trigger_validate_own_device symbol:iio_device_suspend_triggering symbol:iio_device_resume_triggering

kernel/drivers/iio/adc/ad799x.ko.xz i2c:ad7998 i2c:ad7997 i2c:ad7994 i2c:ad7993 i2c:ad7992 i2c:ad7999 i2c:ad7995 i2c:ad7991
industrialio industrialio_triggered_buffer

kernel/drivers/iio/adc/mcp320x.ko.xz of:N*T*Cmicrochip,mcp3553C* of:N*T*Cmicrochip,mcp3553 of:N*T*Cmicrochip,mcp3551C* of:N*T*Cmicrochip,mcp3551 of:N*T*Cmicrochip,mcp3550_60C* of:N*T*Cmicrochip,mcp3550_60 of:N*T*Cmicrochip,mcp3550_50C* of:N*T*Cmicrochip,mcp3550_50 of:N*T*Cmicrochip,mcp3301C* of:N*T*Cmicrochip,mcp3301 of:N*T*Cmicrochip,mcp3208C* of:N*T*Cmicrochip,mcp3208 of:N*T*Cmicrochip,mcp3204C* of:N*T*Cmicrochip,mcp3204 of:N*T*Cmicrochip,mcp3202C* of:N*T*Cmicrochip,mcp3202 of:N*T*Cmicrochip,mcp3201C* of:N*T*Cmicrochip,mcp3201 of:N*T*Cmicrochip,mcp3008C* of:N*T*Cmicrochip,mcp3008 of:N*T*Cmicrochip,mcp3004C* of:N*T*Cmicrochip,mcp3004 of:N*T*Cmicrochip,mcp3002C* of:N*T*Cmicrochip,mcp3002 of:N*T*Cmicrochip,mcp3001C* of:N*T*Cmicrochip,mcp3001 spi:mcp3553 spi:mcp3551 spi:mcp3550_60 spi:mcp3550_50 spi:mcp3301 spi:mcp3208 spi:mcp3204 spi:mcp3202 spi:mcp3201 spi:mcp3008 spi:mcp3004 spi:mcp3002 spi:mcp3001
industrialio

kernel/drivers/iio/adc/ti-ads1015.ko.xz i2c:tla2024 i2c:ads1115 i2c:ads1015 of:N*T*Cti,tla2024C* of:N*T*Cti,tla2024 of:N*T*Cti,ads1115C* of:N*T*Cti,ads1115 of:N*T*Cti,ads1015C* of:N*T*Cti,ads1015
industrialio regmap_i2c industrialio_triggered_buffer

kernel/drivers/iio/adc/mcp3422.ko.xz i2c:mcp3428 i2c:mcp3427 i2c:mcp3426 i2c:mcp3425 i2c:mcp3424 i2c:mcp3423 i2c:mcp3422 i2c:mcp3421 of:N*T*Cmicrochip,mcp3428C* of:N*T*Cmicrochip,mcp3428 of:N*T*Cmicrochip,mcp3427C* of:N*T*Cmicrochip,mcp3427 of:N*T*Cmicrochip,mcp3426C* of:N*T*Cmicrochip,mcp3426 of:N*T*Cmicrochip,mcp3425C* of:N*T*Cmicrochip,mcp3425 of:N*T*Cmicrochip,mcp3424C* of:N*T*Cmicrochip,mcp3424 of:N*T*Cmicrochip,mcp3423C* of:N*T*Cmicrochip,mcp3423 of:N*T*Cmicrochip,mcp3422C* of:N*T*Cmicrochip,mcp3422 of:N*T*Cmicrochip,mcp3421C* of:N*T*Cmicrochip,mcp3421
industrialio

kernel/drivers/base/regmap/regmap-i2c.ko.xz symbol:__regmap_init_i2c symbol:__devm_regmap_init_i2c

kernel/drivers/base/regmap/regmap-spi.ko.xz symbol:__regmap_init_spi symbol:__devm_regmap_init_spi

kernel/drivers/i2c/i2c-dev.ko.xz

kernel/drivers/i2c/i2c-mux.ko.xz symbol:i2c_root_adapter symbol:i2c_mux_alloc symbol:i2c_mux_add_adapter symbol:i2c_mux_del_adapters

kernel/drivers/i2c/muxes/i2c-mux-gpmux.ko.xz of:N*T*Ci2c_muxC* of:N*T*Ci2c_mux
i2c_mux mux_core

kernel/drivers/i2c/muxes/i2c-mux-pca954x.ko.xz i2c:pca9849 i2c:pca9848 i2c:pca9847 i2c:pca9846 i2c:pca9548 i2c:pca9547 i2c:pca9546 i2c:pca9545 i2c:pca9544 i2c:pca9543 i2c:pca9542 i2c:pca9540 i2c:max7369 i2c:max7368 i2c:max7367 i2c:max7358 i2c:max7357 i2c:max7356 of:N*T*Cnxp,pca9849C* of:N*T*Cnxp,pca9849 of:N*T*Cnxp,pca9848C* of:N*T*Cnxp,pca9848 of:N*T*Cnxp,pca9847C* of:N*T*Cnxp,pca9847 of:N*T*Cnxp,pca9846C* of:N*T*Cnxp,pca9846 of:N*T*Cnxp,pca9548C* of:N*T*Cnxp,pca9548 of:N*T*Cnxp,pca9547C* of:N*T*Cnxp,pca9547 of:N*T*Cnxp,pca9546C* of:N*T*Cnxp,pca9546 of:N*T*Cnxp,pca9545C* of:N*T*Cnxp,pca9545 of:N*T*Cnxp,pca9544C* of:N*T*Cnxp,pca9544 of:N*T*Cnxp,pca9543C* of:N*T*Cnxp,pca9543 of:N*T*Cnxp,pca9542C* of:N*T*Cnxp,pca9542 of:N*T*Cnxp,pca9540C* of:N*T*Cnxp,pca9540 of:N*T*Cmaxim,max7369C* of:N*T*Cmaxim,max7369 of:N*T*Cmaxim,max7368C* of:N*T*Cmaxim,max7368 of:N*T*Cmaxim,max7367C* of:N*T*Cmaxim,max7367 of:N*T*Cmaxim,max7358C* of:N*T*Cmaxim,max7358 of:N*T*Cmaxim,max7357C* of:N*T*Cmaxim,max7357 of:N*T*Cmaxim,max7356C* of:N*T*Cmaxim,max7356
i2c_mux

kernel/drivers/i2c/muxes/i2c-mux-pinctrl.ko.xz platform:i2c_mux_pinctrl of:N*T*Ci2c_mux_pinctrlC* of:N*T*Ci2c_mux_pinctrl
i2c_mux

kernel/drivers/i2c/algos/i2c-algo-bit.ko.xz symbol:i2c_bit_algo symbol:i2c_bit_add_bus symbol:i2c_bit_add_numbered_bus

kernel/drivers/i2c/busses/i2c-bcm2708.ko.xz platform:bcm2708_i2c of:N*T*Cbrcm,bcm2708_i2cC* of:N*T*Cbrcm,bcm2708_i2c

kernel/drivers/i2c/busses/i2c-bcm2835.ko.xz platform:i2c_bcm2835 of:N*T*Cbrcm,bcm2835_i2cC* of:N*T*Cbrcm,bcm2835_i2c of:N*T*Cbrcm,bcm2711_i2cC* of:N*T*Cbrcm,bcm2711_i2c

kernel/drivers/i2c/busses/i2c-brcmstb.ko.xz of:N*T*Cbrcm,bcm2711_hdmi_i2cC* of:N*T*Cbrcm,bcm2711_hdmi_i2c of:N*T*Cbrcm,brcmper_i2cC* of:N*T*Cbrcm,brcmper_i2c of:N*T*Cbrcm,brcmstb_i2cC* of:N*T*Cbrcm,brcmstb_i2c

kernel/drivers/i2c/busses/i2c-tiny-usb.ko.xz usb:v1C40p0534d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC631d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/i2c/busses/i2c-designware-platform.ko.xz platform:i2c_designware of:N*T*Cbaikal,bt1_sys_i2cC* of:N*T*Cbaikal,bt1_sys_i2c of:N*T*Cmscc,ocelot_i2cC* of:N*T*Cmscc,ocelot_i2c of:N*T*Csnps,designware_i2cC* of:N*T*Csnps,designware_i2c acpi*:INTC10EF:* acpi*:INT3433:* acpi*:INT3432:* acpi*:INT33C3:* acpi*:INT33C2:* acpi*:HYGO0010:* acpi*:HISI02A3:* acpi*:HISI02A2:* acpi*:HISI02A1:* acpi*:APMC0D0F:* acpi*:AMDI0510:* acpi*:AMDI0019:* acpi*:AMDI0010:* acpi*:AMD0010:* acpi*:808622C1:* acpi*:80860F41:*
i2c_designware_core

kernel/drivers/i2c/busses/i2c-gpio.ko.xz platform:i2c_gpio of:N*T*Ci2c_gpioC* of:N*T*Ci2c_gpio acpi*:LOON0005:*
i2c_algo_bit

kernel/drivers/i2c/busses/i2c-robotfuzz-osif.ko.xz usb:v1964p0001d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/i2c/busses/i2c-designware-core.ko.xz symbol:i2c_dw_fw_parse_and_configure symbol:i2c_dw_prepare_clk symbol:i2c_dw_disable symbol:i2c_dw_probe symbol:i2c_dw_dev_pm_ops symbol:i2c_dw_configure_master symbol:i2c_dw_probe_master

kernel/drivers/char/tpm/tpm.ko.xz symbol:tpm_chip_start symbol:tpm_chip_stop symbol:tpm_try_get_ops symbol:tpm_put_ops symbol:tpm_default_chip symbol:tpm_chip_alloc symbol:tpmm_chip_alloc symbol:tpm_chip_bootstrap symbol:tpm_chip_register symbol:tpm_chip_unregister symbol:tpm_calc_ordinal_duration symbol:tpm_transmit_cmd symbol:tpm_get_timeouts symbol:tpm_is_tpm2 symbol:tpm_pcr_read symbol:tpm_pcr_extend symbol:tpm_pm_suspend symbol:tpm_pm_resume symbol:tpm_get_random symbol:tpm1_getcap symbol:tpm1_do_selftest symbol:tpm2_flush_context symbol:tpm2_get_tpm_pt symbol:tpm2_probe symbol:tpm2_get_cc_attrs_tbl symbol:tpm_buf_init symbol:tpm_buf_reset symbol:tpm_buf_init_sized symbol:tpm_buf_reset_sized symbol:tpm_buf_destroy symbol:tpm_buf_length symbol:tpm_buf_append symbol:tpm_buf_append_u8 symbol:tpm_buf_append_u16 symbol:tpm_buf_append_u32 symbol:tpm_buf_read_u8 symbol:tpm_buf_read_u16 symbol:tpm_buf_read_u32 symbol:tpm_buf_append_name symbol:tpm_buf_append_hmac_session

kernel/drivers/char/tpm/tpm_tis_i2c.ko.xz i2c:tpm_tis_i2c of:N*T*Ctcg,tpm_tis_i2cC* of:N*T*Ctcg,tpm_tis_i2c of:N*T*Cnuvoton,npct75xC* of:N*T*Cnuvoton,npct75x of:N*T*Cinfineon,slb9673C* of:N*T*Cinfineon,slb9673
tpm tpm_tis_core crc_ccitt

kernel/drivers/char/tpm/tpm_tis_core.ko.xz symbol:tpm_tis_remove symbol:tpm_tis_core_init
tpm

kernel/drivers/char/tpm/tpm_tis_spi.ko.xz of:N*T*Cgoogle,cr50C* of:N*T*Cgoogle,cr50 of:N*T*Ctcg,tpm_tis_spiC* of:N*T*Ctcg,tpm_tis_spi of:N*T*Cinfineon,slb9670C* of:N*T*Cinfineon,slb9670 of:N*T*Cst,st33htpm_spiC* of:N*T*Cst,st33htpm_spi of:N*T*Catmel,attpm20pC* of:N*T*Catmel,attpm20p spi:cr50 spi:tpm_tis_spi spi:tpm_tis_spi spi:slb9670 spi:st33htpm_spi spi:attpm20p acpi*:SMO0768:*
tpm tpm_tis_core

kernel/drivers/char/xillybus/xillybus_pcie.ko.xz xillybus_pcie pci:v00001204d0000EBEBsv*sd*bc*sc*i* pci:v000011AAd0000EBEBsv*sd*bc*sc*i* pci:v00001172d0000EBEBsv*sd*bc*sc*i* pci:v000010EEd0000EBEBsv*sd*bc*sc*i*
xillybus_core

kernel/drivers/char/xillybus/xillybus_class.ko.xz xillybus_class symbol:xillybus_init_chrdev symbol:xillybus_cleanup_chrdev symbol:xillybus_find_inode

kernel/drivers/char/xillybus/xillybus_core.ko.xz xillybus_core symbol:xillybus_isr symbol:xillybus_init_endpoint symbol:xillybus_endpoint_discovery symbol:xillybus_endpoint_remove
xillybus_class

kernel/drivers/char/xillybus/xillyusb.ko.xz xillyusb usb:v09FBpEBBEd*dc*dsc*dp*ic*isc*ip*in* usb:v03FDpEBBEd*dc*dsc*dp*ic*isc*ip*in*
xillybus_class

kernel/drivers/char/raspberrypi-gpiomem.ko.xz platform:rpi_gpiomem of:N*T*Craspberrypi,gpiomemC* of:N*T*Craspberrypi,gpiomem of:N*T*Cbrcm,bcm2835_gpiomemC* of:N*T*Cbrcm,bcm2835_gpiomem

kernel/drivers/char/broadcom/bcm2835_smi_dev.ko.xz platform:smi_dev_bcm2835 of:N*T*Cbrcm,bcm2835_smi_devC* of:N*T*Cbrcm,bcm2835_smi_dev
bcm2835_smi

kernel/drivers/input/joystick/sensehat-joystick.ko.xz of:N*T*Craspberrypi,sensehat_joystickC* of:N*T*Craspberrypi,sensehat_joystick

kernel/drivers/input/joystick/fsia6b.ko.xz serio:ty02pr42id*ex*
serio

kernel/drivers/input/joystick/psxpad-spi.ko.xz spi:psxpad_spi
ff_memless

kernel/drivers/input/joystick/xpad.ko.xz usb:v413Dp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v413Dp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v3537p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v3537p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v3537p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v3285p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v3285p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v3285p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v31E3p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v31E3p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2E95p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v2F24p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2F24p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2E24p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v2DC8p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v2DC8p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2DC8p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2C22p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2C22p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2993p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2993p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v294Bp*d*dc*dsc*dp*icFFisc47ipD0in* usb:v260Dp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v260Dp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2563p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2563p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v24C6p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v24C6p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v24C6p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v2345p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v2345p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v20D6p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v20D6p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v20D6p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1EE9p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1EE9p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1BADp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1BADp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1A86p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1A86p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1949p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1949p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v17EFp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v17EFp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1689p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1689p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v162Ep*d*dc*dsc*dp*icFFisc5Dip81in* usb:v162Ep*d*dc*dsc*dp*icFFisc5Dip01in* usb:v15E4p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v15E4p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1532p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v1532p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1532p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v146Bp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v146Bp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1430p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1430p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v12ABp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v12ABp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v1209p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1209p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v11FFp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v11FFp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v11C9p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v11C9p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v10F5p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v1038p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v1038p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0F0Dp*d*dc*dsc*dp*icFFisc47ipD0in* usb:v0F0Dp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0F0Dp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0E6Fp*d*dc*dsc*dp*icFFisc47ipD0in* usb:v0E6Fp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0E6Fp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0DB0p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0DB0p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0C12p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0C12p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0B05p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v07FFp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v07FFp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0738p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v0738p4540d*dc*dsc*dp*ic*isc*ip*in* usb:v0738p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0738p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v06A3p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v06A3p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v056Ep*d*dc*dsc*dp*icFFisc5Dip81in* usb:v056Ep*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0502p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0502p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v046Dp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v046Dp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v045Ep*d*dc*dsc*dp*icFFisc47ipD0in* usb:v045Ep*d*dc*dsc*dp*icFFisc5Dip81in* usb:v045Ep*d*dc*dsc*dp*icFFisc5Dip01in* usb:v044Fp*d*dc*dsc*dp*icFFisc47ipD0in* usb:v044Fp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v044Fp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v03F0p*d*dc*dsc*dp*icFFisc47ipD0in* usb:v03F0p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v03F0p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v03EBp*d*dc*dsc*dp*icFFisc5Dip81in* usb:v03EBp*d*dc*dsc*dp*icFFisc5Dip01in* usb:v0079p*d*dc*dsc*dp*icFFisc5Dip81in* usb:v0079p*d*dc*dsc*dp*icFFisc5Dip01in* usb:v*p*d*dc*dsc*dp*ic58isc42ip00in*
ff_memless

kernel/drivers/input/joystick/iforce/iforce-usb.ko.xz usb:v06F8pA302d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v06F8p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v06A3pFF04d*dc*dsc*dp*ic*isc*ip*in* usb:v061CpC084d*dc*dsc*dp*ic*isc*ip*in* usb:v061CpC0A4d*dc*dsc*dp*ic*isc*ip*in* usb:v05EFp8888d*dc*dsc*dp*ic*isc*ip*in* usb:v05EFp8884d*dc*dsc*dp*ic*isc*ip*in* usb:v05EFp020Ad*dc*dsc*dp*ic*isc*ip*in* usb:v046DpC291d*dc*dsc*dp*ic*isc*ip*in* usb:v046DpC281d*dc*dsc*dp*ic*isc*ip*in* usb:v044FpA01Cd*dc*dsc*dp*ic*isc*ip*in*
iforce

kernel/drivers/input/joystick/iforce/iforce.ko.xz symbol:iforce_init_device symbol:iforce_send_packet symbol:iforce_process_packet

kernel/drivers/input/touchscreen/ads7846.ko.xz of:N*T*Cti,ads7873C* of:N*T*Cti,ads7873 of:N*T*Cti,ads7846C* of:N*T*Cti,ads7846 of:N*T*Cti,ads7845C* of:N*T*Cti,ads7845 of:N*T*Cti,ads7843C* of:N*T*Cti,ads7843 of:N*T*Cti,tsc2046C* of:N*T*Cti,tsc2046 spi:ads7873 spi:ads7846 spi:ads7845 spi:ads7843 spi:tsc2046

kernel/drivers/input/touchscreen/atmel_mxt_ts.ko.xz of:N*T*Catmel,mXT224C* of:N*T*Catmel,mXT224 of:N*T*Catmel,atmel_mxt_tpC* of:N*T*Catmel,atmel_mxt_tp of:N*T*Catmel,atmel_mxt_tsC* of:N*T*Catmel,atmel_mxt_ts of:N*T*Catmel,qt602240_tsC* of:N*T*Catmel,qt602240_ts of:N*T*Catmel,maxtouchC* of:N*T*Catmel,maxtouch i2c:mXT224 i2c:maxtouch i2c:atmel_mxt_tp i2c:atmel_mxt_ts i2c:qt602240_ts

kernel/drivers/input/touchscreen/goodix_ts.ko.xz i2c:GDIX1001:00 of:N*T*Cgoodix,gt967C* of:N*T*Cgoodix,gt967 of:N*T*Cgoodix,gt9286C* of:N*T*Cgoodix,gt9286 of:N*T*Cgoodix,gt928C* of:N*T*Cgoodix,gt928 of:N*T*Cgoodix,gt9271C* of:N*T*Cgoodix,gt9271 of:N*T*Cgoodix,gt927C* of:N*T*Cgoodix,gt927 of:N*T*Cgoodix,gt917sC* of:N*T*Cgoodix,gt917s of:N*T*Cgoodix,gt9147C* of:N*T*Cgoodix,gt9147 of:N*T*Cgoodix,gt912C* of:N*T*Cgoodix,gt912 of:N*T*Cgoodix,gt9110C* of:N*T*Cgoodix,gt9110 of:N*T*Cgoodix,gt911C* of:N*T*Cgoodix,gt911 of:N*T*Cgoodix,gt5688C* of:N*T*Cgoodix,gt5688 of:N*T*Cgoodix,gt5663C* of:N*T*Cgoodix,gt5663 of:N*T*Cgoodix,gt1158C* of:N*T*Cgoodix,gt1158 of:N*T*Cgoodix,gt1151C* of:N*T*Cgoodix,gt1151

kernel/drivers/input/touchscreen/tsc2007.ko.xz of:N*T*Cti,tsc2007C* of:N*T*Cti,tsc2007 i2c:tsc2007
industrialio

kernel/drivers/input/touchscreen/iqs5xx.ko.xz i2c:iqs525 i2c:iqs572 i2c:iqs550 of:N*T*Cazoteq,iqs525C* of:N*T*Cazoteq,iqs525 of:N*T*Cazoteq,iqs572C* of:N*T*Cazoteq,iqs572 of:N*T*Cazoteq,iqs550C* of:N*T*Cazoteq,iqs550

kernel/drivers/input/touchscreen/raspberrypi-ts.ko.xz of:N*T*Craspberrypi,firmware_tsC* of:N*T*Craspberrypi,firmware_ts

kernel/drivers/input/touchscreen/edt-ft5x06.ko.xz i2c:ft8719 i2c:ft8201 i2c:ft6236 i2c:ft5452 i2c:ev_ft5726 i2c:edt_ft5506 i2c:edt_ft5x06 of:N*T*Cfocaltech,ft8719C* of:N*T*Cfocaltech,ft8719 of:N*T*Cfocaltech,ft8201C* of:N*T*Cfocaltech,ft8201 of:N*T*Cfocaltech,ft6236C* of:N*T*Cfocaltech,ft6236 of:N*T*Cfocaltech,ft5452C* of:N*T*Cfocaltech,ft5452 of:N*T*Cfocaltech,ft5426C* of:N*T*Cfocaltech,ft5426 of:N*T*Cevervision,ev_ft5726C* of:N*T*Cevervision,ev_ft5726 of:N*T*Cedt,edt_ft5506C* of:N*T*Cedt,edt_ft5506 of:N*T*Cedt,edt_ft5406C* of:N*T*Cedt,edt_ft5406 of:N*T*Cedt,edt_ft5306C* of:N*T*Cedt,edt_ft5306 of:N*T*Cedt,edt_ft5206C* of:N*T*Cedt,edt_ft5206
regmap_i2c

kernel/drivers/input/touchscreen/stmpe-ts.ko.xz of:N*T*Cst,stmpe_tsC* of:N*T*Cst,stmpe_ts

kernel/drivers/input/touchscreen/ilitek_ts_i2c.ko.xz i2c:ilitek_ts of:N*T*Cilitek,ili2521C* of:N*T*Cilitek,ili2521 of:N*T*Cilitek,ili2520C* of:N*T*Cilitek,ili2520 of:N*T*Cilitek,ili2326C* of:N*T*Cilitek,ili2326 of:N*T*Cilitek,ili2323C* of:N*T*Cilitek,ili2323 of:N*T*Cilitek,ili2322C* of:N*T*Cilitek,ili2322 of:N*T*Cilitek,ili2316C* of:N*T*Cilitek,ili2316 of:N*T*Cilitek,ili2132C* of:N*T*Cilitek,ili2132 of:N*T*Cilitek,ili2131C* of:N*T*Cilitek,ili2131 of:N*T*Cilitek,ili2130C* of:N*T*Cilitek,ili2130

kernel/drivers/input/touchscreen/egalax_ts.ko.xz i2c:egalax_ts of:N*T*Ceeti,egalax_tsC* of:N*T*Ceeti,egalax_ts

kernel/drivers/input/touchscreen/usbtouchscreen.ko.xz mtouchusb itmtouch touchkitusb usb:v7374p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v04E7p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v1870p0001d*dc*dsc*dp*ic0Aisc00ip00in* usb:v10F0p2002d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0664p0306d*dc*dsc*dp*ic*isc*ip*in* usb:v0664p0309d*dc*dsc*dp*ic*isc*ip*in* usb:v14C8p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v1AC7p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0F92p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v08F2p00F4d*dc*dsc*dp*ic*isc*ip*in* usb:v08F2p00CEd*dc*dsc*dp*ic*isc*ip*in* usb:v08F2p007Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0DFCp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1391p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v6615p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v6615p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v595Ap0001d*dc*dsc*dp*ic*isc*ip*in* usb:v255Ep0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0AFAp03E8d*dc*dsc*dp*ic*isc*ip*in* usb:v0637p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1234p5678d*dc*dsc*dp*ic*isc*ip*in* usb:v16E3pF9E9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9E9d*dc*dsc*dp*ic*isc*ip*in* usb:v0596p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v134Cp0004d*dc*dsc*dp*ic*isc*ip*in* usb:v134Cp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v134Cp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v134Cp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1234p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1234p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0EEFp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0EEFp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0123p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v3823p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v3823p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0EEFp0002d*dc*dsc*dp*ic03isc*ip*in* usb:v0EEFp0001d*dc*dsc*dp*ic03isc*ip*in*

kernel/drivers/input/touchscreen/ili210x.ko.xz i2c:ili251x i2c:ili2120 i2c:ili2117 i2c:ili210x of:N*T*Cilitek,ili251xC* of:N*T*Cilitek,ili251x of:N*T*Cilitek,ili2120C* of:N*T*Cilitek,ili2120 of:N*T*Cilitek,ili2117C* of:N*T*Cilitek,ili2117 of:N*T*Cilitek,ili210xC* of:N*T*Cilitek,ili210x
crc_ccitt

kernel/drivers/input/touchscreen/exc3000.ko.xz i2c:exc81w32 i2c:exc80h84 i2c:exc80h60 i2c:exc3000 of:N*T*Ceeti,exc81w32C* of:N*T*Ceeti,exc81w32 of:N*T*Ceeti,exc80h84C* of:N*T*Ceeti,exc80h84 of:N*T*Ceeti,exc80h60C* of:N*T*Ceeti,exc80h60 of:N*T*Ceeti,exc3000C* of:N*T*Ceeti,exc3000

kernel/drivers/input/matrix-keymap.ko.xz symbol:matrix_keypad_parse_properties symbol:matrix_keypad_build_keymap

kernel/drivers/input/serio/serport.ko.xz tty_ldisc_2
serio

kernel/drivers/input/serio/serio.ko.xz symbol:serio_rescan symbol:serio_reconnect symbol:__serio_register_port symbol:serio_unregister_port symbol:serio_unregister_child_port symbol:__serio_register_driver symbol:serio_unregister_driver symbol:serio_open symbol:serio_close symbol:serio_interrupt symbol:serio_bus

kernel/drivers/input/serio/serio_raw.ko.xz serio:ty06pr*id*ex* serio:ty01pr*id*ex*
serio

kernel/drivers/input/ff-memless.ko.xz symbol:input_ff_create_memless

kernel/drivers/input/gameport/gameport.ko.xz symbol:gameport_start_polling symbol:gameport_stop_polling symbol:gameport_set_phys symbol:__gameport_register_port symbol:gameport_unregister_port symbol:__gameport_register_driver symbol:gameport_unregister_driver symbol:gameport_open symbol:gameport_close

kernel/drivers/input/joydev.ko.xz input:b*v*p*e*_e*1,*k*2C0,*r*a*m*l*s*f*w* input:b*v*p*e*_e*1,*k*130,*r*a*m*l*s*f*w* input:b*v*p*e*_e*1,*k*120,*r*a*m*l*s*f*w* input:b*v*p*e*_e*3,*k*r*a*6,*m*l*s*f*w* input:b*v*p*e*_e*3,*k*r*a*8,*m*l*s*f*w* input:b*v*p*e*_e*3,*k*r*a*2,*m*l*s*f*w* input:b*v*p*e*_e*3,*k*r*a*0,*m*l*s*f*w*

kernel/drivers/input/keyboard/cap11xx.ko.xz of:N*T*Cmicrochip,cap1298C* of:N*T*Cmicrochip,cap1298 of:N*T*Cmicrochip,cap1293C* of:N*T*Cmicrochip,cap1293 of:N*T*Cmicrochip,cap1206C* of:N*T*Cmicrochip,cap1206 of:N*T*Cmicrochip,cap1203C* of:N*T*Cmicrochip,cap1203 of:N*T*Cmicrochip,cap1188C* of:N*T*Cmicrochip,cap1188 of:N*T*Cmicrochip,cap1126C* of:N*T*Cmicrochip,cap1126 of:N*T*Cmicrochip,cap1106C* of:N*T*Cmicrochip,cap1106 i2c:cap1298 i2c:cap1293 i2c:cap1206 i2c:cap1203 i2c:cap1188 i2c:cap1126 i2c:cap1106
regmap_i2c

kernel/drivers/input/keyboard/gpio_keys.ko.xz platform:gpio_keys of:N*T*Cgpio_keysC* of:N*T*Cgpio_keys

kernel/drivers/input/keyboard/matrix_keypad.ko.xz platform:matrix_keypad of:N*T*Cgpio_matrix_keypadC* of:N*T*Cgpio_matrix_keypad
matrix_keymap

kernel/drivers/input/keyboard/tca8418_keypad.ko.xz i2c:tca8418 of:N*T*Cti,tca8418C* of:N*T*Cti,tca8418
matrix_keymap

kernel/drivers/input/keyboard/tca6416-keypad.ko.xz i2c:tca6408_keys i2c:tca6416_keys

kernel/drivers/input/misc/cm109.ko.xz usb:v0D8Cp000Ed*dc*dsc*dp*ic03isc00ip00in*

kernel/drivers/input/misc/powermate.ko.xz usb:v05F3p0240d*dc*dsc*dp*ic*isc*ip*in* usb:v077Dp04AAd*dc*dsc*dp*ic*isc*ip*in* usb:v077Dp0410d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/input/misc/cma3000_d0x.ko.xz symbol:cma3000_suspend symbol:cma3000_resume symbol:cma3000_init symbol:cma3000_exit

kernel/drivers/input/misc/uinput.ko.xz devname:uinput char_major_10_223

kernel/drivers/input/misc/ad714x.ko.xz symbol:ad714x_probe

kernel/drivers/input/misc/rotary_encoder.ko.xz platform:rotary_encoder of:N*T*Crotary_encoderC* of:N*T*Crotary_encoder

kernel/drivers/input/misc/yealink.ko.xz usb:v6993pB001d*dc*dsc*dp*ic03isc00ip00in*

kernel/drivers/input/misc/adxl34x-i2c.ko.xz i2c:adxl34x of:N*T*Cadi,adxl34xC* of:N*T*Cadi,adxl34x of:N*T*Cadi,adxl345C* of:N*T*Cadi,adxl345
adxl34x

kernel/drivers/input/misc/adxl34x.ko.xz symbol:adxl34x_groups symbol:adxl34x_probe

kernel/drivers/input/misc/pwm-beeper.ko.xz platform:pwm_beeper of:N*T*Cpwm_beeperC* of:N*T*Cpwm_beeper

kernel/drivers/input/misc/adxl34x-spi.ko.xz
adxl34x

kernel/drivers/input/misc/ad714x-spi.ko.xz
ad714x

kernel/drivers/input/misc/keyspan_remote.ko.xz usb:v06CDp0202d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/input/misc/ati_remote2.ko.xz usb:v0471p0602d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/input/misc/ad714x-i2c.ko.xz i2c:ad7148_captouch i2c:ad7147a_captouch i2c:ad7147_captouch i2c:ad7143_captouch i2c:ad7142_captouch
ad714x

kernel/drivers/watchdog/gpio_wdt.ko.xz of:N*T*Clinux,wdt_gpioC* of:N*T*Clinux,wdt_gpio

kernel/drivers/hwmon/ds1621.ko.xz i2c:ds1731 i2c:ds1721 i2c:ds1631 i2c:ds1625 i2c:ds1621 of:N*T*Cdallas,ds1731C* of:N*T*Cdallas,ds1731 of:N*T*Cdallas,ds1721C* of:N*T*Cdallas,ds1721 of:N*T*Cdallas,ds1631C* of:N*T*Cdallas,ds1631 of:N*T*Cdallas,ds1625C* of:N*T*Cdallas,ds1625 of:N*T*Cdallas,ds1621C* of:N*T*Cdallas,ds1621

kernel/drivers/hwmon/ina238.ko.xz i2c:ina238 of:N*T*Cti,ina238C* of:N*T*Cti,ina238 of:N*T*Cti,ina237C* of:N*T*Cti,ina237
regmap_i2c

kernel/drivers/hwmon/jc42.ko.xz i2c:jc42 of:N*T*Cjedec,jc_42.4_tempC* of:N*T*Cjedec,jc_42.4_temp
regmap_i2c

kernel/drivers/hwmon/tmp102.ko.xz i2c:tmp102 of:N*T*Cti,tmp102C* of:N*T*Cti,tmp102
regmap_i2c

kernel/drivers/hwmon/ina2xx.ko.xz i2c:ina260 i2c:ina231 i2c:ina230 i2c:ina226 i2c:ina220 i2c:ina219 of:N*T*Cti,ina260C* of:N*T*Cti,ina260 of:N*T*Cti,ina231C* of:N*T*Cti,ina231 of:N*T*Cti,ina230C* of:N*T*Cti,ina230 of:N*T*Cti,ina226C* of:N*T*Cti,ina226 of:N*T*Cti,ina220C* of:N*T*Cti,ina220 of:N*T*Cti,ina219C* of:N*T*Cti,ina219
regmap_i2c

kernel/drivers/hwmon/shtc1.ko.xz i2c:shtc3 i2c:shtw1 i2c:shtc1 of:N*T*Csensirion,shtc3C* of:N*T*Csensirion,shtc3 of:N*T*Csensirion,shtw1C* of:N*T*Csensirion,shtw1 of:N*T*Csensirion,shtc1C* of:N*T*Csensirion,shtc1

kernel/drivers/hwmon/chipcap2.ko.xz i2c:cc2d35s i2c:cc2d35 i2c:cc2d33s i2c:cc2d33 i2c:cc2d25s i2c:cc2d25 i2c:cc2d23s i2c:cc2d23 of:N*T*Camphenol,cc2d35sC* of:N*T*Camphenol,cc2d35s of:N*T*Camphenol,cc2d35C* of:N*T*Camphenol,cc2d35 of:N*T*Camphenol,cc2d33sC* of:N*T*Camphenol,cc2d33s of:N*T*Camphenol,cc2d33C* of:N*T*Camphenol,cc2d33 of:N*T*Camphenol,cc2d25sC* of:N*T*Camphenol,cc2d25s of:N*T*Camphenol,cc2d25C* of:N*T*Camphenol,cc2d25 of:N*T*Camphenol,cc2d23sC* of:N*T*Camphenol,cc2d23s of:N*T*Camphenol,cc2d23C* of:N*T*Camphenol,cc2d23

kernel/drivers/hwmon/lm75.ko.xz i2c:tmp1075 i2c:tmp75c i2c:tmp75b i2c:tmp75 i2c:tmp275 i2c:tmp175 i2c:tmp112 i2c:tmp105 i2c:tmp101 i2c:tmp100 i2c:tcn75 i2c:stlm75 i2c:stds75 i2c:pct2075 i2c:mcp980x i2c:max31726 i2c:max31725 i2c:max6626 i2c:max6625 i2c:lm75b i2c:lm75a i2c:lm75 i2c:g751 i2c:ds7505 i2c:ds75 i2c:ds1775 i2c:at30ts74 i2c:as6200 i2c:adt75 of:N*T*Cti,tmp1075C* of:N*T*Cti,tmp1075 of:N*T*Cti,tmp75cC* of:N*T*Cti,tmp75c of:N*T*Cti,tmp75bC* of:N*T*Cti,tmp75b of:N*T*Cti,tmp75C* of:N*T*Cti,tmp75 of:N*T*Cti,tmp275C* of:N*T*Cti,tmp275 of:N*T*Cti,tmp175C* of:N*T*Cti,tmp175 of:N*T*Cti,tmp112C* of:N*T*Cti,tmp112 of:N*T*Cti,tmp105C* of:N*T*Cti,tmp105 of:N*T*Cti,tmp101C* of:N*T*Cti,tmp101 of:N*T*Cti,tmp100C* of:N*T*Cti,tmp100 of:N*T*Cmicrochip,tcn75C* of:N*T*Cmicrochip,tcn75 of:N*T*Cst,stlm75C* of:N*T*Cst,stlm75 of:N*T*Cst,stds75C* of:N*T*Cst,stds75 of:N*T*Cnxp,pct2075C* of:N*T*Cnxp,pct2075 of:N*T*Cmaxim,mcp980xC* of:N*T*Cmaxim,mcp980x of:N*T*Cmaxim,max31726C* of:N*T*Cmaxim,max31726 of:N*T*Cmaxim,max31725C* of:N*T*Cmaxim,max31725 of:N*T*Cmaxim,max6626C* of:N*T*Cmaxim,max6626 of:N*T*Cmaxim,max6625C* of:N*T*Cmaxim,max6625 of:N*T*Cnational,lm75bC* of:N*T*Cnational,lm75b of:N*T*Cnational,lm75aC* of:N*T*Cnational,lm75a of:N*T*Cnational,lm75C* of:N*T*Cnational,lm75 of:N*T*Cgmt,g751C* of:N*T*Cgmt,g751 of:N*T*Cdallas,ds7505C* of:N*T*Cdallas,ds7505 of:N*T*Cdallas,ds75C* of:N*T*Cdallas,ds75 of:N*T*Cdallas,ds1775C* of:N*T*Cdallas,ds1775 of:N*T*Catmel,at30ts74C* of:N*T*Catmel,at30ts74 of:N*T*Cams,as6200C* of:N*T*Cams,as6200 of:N*T*Cadi,adt75C* of:N*T*Cadi,adt75
regmap_i2c

kernel/drivers/hwmon/adt7x10.ko.xz symbol:adt7x10_probe

kernel/drivers/hwmon/iio_hwmon.ko.xz of:N*T*Ciio_hwmonC* of:N*T*Ciio_hwmon
industrialio

kernel/drivers/hwmon/sht21.ko.xz i2c:sht21

kernel/drivers/hwmon/ads7828.ko.xz i2c:ads7830 i2c:ads7828 of:N*T*Cti,ads7830C* of:N*T*Cti,ads7830 of:N*T*Cti,ads7828C* of:N*T*Cti,ads7828
regmap_i2c

kernel/drivers/hwmon/powerz.ko.xz usb:v5FC9p0063d*dc*dsc*dp*ic*isc*ip*in00* usb:v5FC9p0061d*dc*dsc*dp*ic*isc*ip*in00*

kernel/drivers/hwmon/adt7410.ko.xz i2c:adt7420 i2c:adt7410 of:N*T*Cadi,adt7420C* of:N*T*Cadi,adt7420 of:N*T*Cadi,adt7410C* of:N*T*Cadi,adt7410
adt7x10

kernel/drivers/hwmon/sht4x.ko.xz i2c:sht4x of:N*T*Csensirion,sht4xC* of:N*T*Csensirion,sht4x
crc8

kernel/drivers/hwmon/emc2305.ko.xz i2c:emc2301 i2c:emc2302 i2c:emc2303 i2c:emc2305 of:N*T*Cmicrochip,emc2301C* of:N*T*Cmicrochip,emc2301 of:N*T*Cmicrochip,emc2302C* of:N*T*Cmicrochip,emc2302 of:N*T*Cmicrochip,emc2303C* of:N*T*Cmicrochip,emc2303 of:N*T*Cmicrochip,emc2305C* of:N*T*Cmicrochip,emc2305

kernel/drivers/hwmon/pwm-fan.ko.xz platform:pwm_fan of:N*T*Cpwm_fanC* of:N*T*Cpwm_fan

kernel/drivers/hwmon/rp1-adc.ko.xz of:N*T*Craspberrypi,rp1_adcC* of:N*T*Craspberrypi,rp1_adc

kernel/drivers/hwmon/drivetemp.ko.xz platform:drivetemp

kernel/drivers/hwmon/sht3x.ko.xz of:N*T*Csensirion,sts3xC* of:N*T*Csensirion,sts3x of:N*T*Csensirion,sht3xC* of:N*T*Csensirion,sht3x
crc8

kernel/drivers/hwmon/gpio-fan.ko.xz platform:gpio_fan of:N*T*Cgpio_fanC* of:N*T*Cgpio_fan

kernel/drivers/hwmon/raspberrypi-hwmon.ko.xz platform:raspberrypi_hwmon

kernel/drivers/hwmon/aht10.ko.xz i2c:aht20 i2c:aht10 of:N*T*Caosong,aht20C* of:N*T*Caosong,aht20 of:N*T*Caosong,aht10C* of:N*T*Caosong,aht10
crc8

kernel/drivers/nvmem/nvmem-rmem.ko.xz of:N*T*Cnvmem_rmemC* of:N*T*Cnvmem_rmem

kernel/drivers/regulator/rpi-panel-v2-regulator.ko.xz of:N*T*Craspberrypi,v2_touchscreen_panel_regulatorC* of:N*T*Craspberrypi,v2_touchscreen_panel_regulator
regmap_i2c backlight

kernel/drivers/regulator/arizona-ldo1.ko.xz platform:madera_ldo1 platform:arizona_ldo1

kernel/drivers/regulator/arizona-micsupp.ko.xz platform:madera_micsupp platform:arizona_micsupp
snd_soc_core

kernel/drivers/regulator/waveshare-panel-regulator.ko.xz of:N*T*Cwaveshare,touchscreen_panel_regulatorC* of:N*T*Cwaveshare,touchscreen_panel_regulator
regmap_i2c backlight

kernel/drivers/regulator/rpi-panel-attiny-regulator.ko.xz of:N*T*Craspberrypi,7inch_touchscreen_panel_regulatorC* of:N*T*Craspberrypi,7inch_touchscreen_panel_regulator
regmap_i2c backlight

kernel/drivers/video/backlight/pwm_bl.ko.xz platform:pwm_backlight of:N*T*Cpwm_backlightC* of:N*T*Cpwm_backlight
backlight

kernel/drivers/video/backlight/rpi_backlight.ko.xz of:N*T*Craspberrypi,rpi_backlightC* of:N*T*Craspberrypi,rpi_backlight
backlight

kernel/drivers/video/backlight/lm3630a_bl.ko.xz i2c:lm3630a_bl of:N*T*Cti,lm3630aC* of:N*T*Cti,lm3630a
regmap_i2c backlight

kernel/drivers/video/backlight/backlight.ko.xz symbol:backlight_device_set_brightness symbol:backlight_force_update symbol:backlight_device_register symbol:backlight_device_get_by_type symbol:backlight_device_get_by_name symbol:backlight_device_unregister symbol:backlight_register_notifier symbol:backlight_unregister_notifier symbol:devm_backlight_device_register symbol:devm_backlight_device_unregister symbol:backlight_set_display_name symbol:of_find_backlight_by_node symbol:devm_of_find_backlight

kernel/drivers/video/backlight/gpio_backlight.ko.xz platform:gpio_backlight of:N*T*Cgpio_backlightC* of:N*T*Cgpio_backlight
backlight

kernel/drivers/video/fbdev/rpisense-fb.ko.xz of:N*T*Craspberrypi,rpi_sense_fbC* of:N*T*Craspberrypi,rpi_sense_fb

kernel/drivers/video/fbdev/ssd1307fb.ko.xz of:N*T*Csolomon,ssd1309fb_i2cC* of:N*T*Csolomon,ssd1309fb_i2c of:N*T*Csolomon,ssd1307fb_i2cC* of:N*T*Csolomon,ssd1307fb_i2c of:N*T*Csolomon,ssd1306fb_i2cC* of:N*T*Csolomon,ssd1306fb_i2c of:N*T*Csolomon,ssd1305fb_i2cC* of:N*T*Csolomon,ssd1305fb_i2c i2c:ssd1309fb i2c:ssd1307fb i2c:ssd1306fb i2c:ssd1305fb
backlight

kernel/drivers/w1/masters/ds2490.ko.xz usb:v04FAp2490d*dc*dsc*dp*ic*isc*ip*in*
wire

kernel/drivers/w1/masters/w1-gpio.ko.xz of:N*T*Cw1_gpioC* of:N*T*Cw1_gpio
wire

kernel/drivers/w1/masters/ds2482.ko.xz i2c:ds2484 i2c:ds2482
wire

kernel/drivers/w1/slaves/w1_ds2413.ko.xz w1_family_0x3A
wire

kernel/drivers/w1/slaves/w1_ds2433.ko.xz w1_family_0x43 w1_family_0x23
wire

kernel/drivers/w1/slaves/w1_smem.ko.xz w1_family_0x81 w1_family_0x01
wire

kernel/drivers/w1/slaves/w1_ds2430.ko.xz w1_family_0x14
wire

kernel/drivers/w1/slaves/w1_ds2780.ko.xz w1_family_0x32 symbol:w1_ds2780_io symbol:w1_ds2780_eeprom_cmd
wire

kernel/drivers/w1/slaves/w1_ds2408.ko.xz w1_family_0x29
wire

kernel/drivers/w1/slaves/w1_therm.ko.xz w1_family_0x42 w1_family_0x3B w1_family_0x28 w1_family_0x22 w1_family_0x10
wire

kernel/drivers/w1/slaves/w1_ds2438.ko.xz w1_family_0x26
wire

kernel/drivers/w1/slaves/w1_ds28e04.ko.xz w1_family_0x1C
wire

kernel/drivers/w1/slaves/w1_ds2781.ko.xz w1_family_0x3D symbol:w1_ds2781_io symbol:w1_ds2781_eeprom_cmd
wire

kernel/drivers/w1/slaves/w1_ds2406.ko.xz
wire

kernel/drivers/w1/slaves/w1_ds2431.ko.xz w1_family_0x2D
wire

kernel/drivers/w1/slaves/w1_ds28e17.ko.xz w1_family_0x19
wire

kernel/drivers/w1/slaves/w1_ds2423.ko.xz w1_family_0x1D
wire

kernel/drivers/w1/wire.ko.xz symbol:w1_add_master_device symbol:w1_remove_master_device symbol:w1_register_family symbol:w1_unregister_family symbol:w1_touch_bit symbol:w1_write_8 symbol:w1_triplet symbol:w1_read_8 symbol:w1_write_block symbol:w1_touch_block symbol:w1_read_block symbol:w1_reset_bus symbol:w1_calc_crc8 symbol:w1_reset_select_slave symbol:w1_reset_resume_command symbol:w1_next_pullup
cn

kernel/drivers/gpu/drm/ttm/ttm.ko.xz symbol:ttm_tt_init symbol:ttm_tt_fini symbol:ttm_sg_tt_init symbol:ttm_tt_populate symbol:ttm_kmap_iter_tt_init symbol:ttm_tt_pages_limit symbol:ttm_bo_move_to_lru_tail symbol:ttm_bo_set_bulk_move symbol:ttm_bo_put symbol:ttm_bo_eviction_valuable symbol:ttm_bo_pin symbol:ttm_bo_unpin symbol:ttm_bo_mem_space symbol:ttm_bo_validate symbol:ttm_bo_init_reserved symbol:ttm_bo_init_validate symbol:ttm_bo_unmap_virtual symbol:ttm_bo_wait_ctx symbol:ttm_move_memcpy symbol:ttm_bo_move_memcpy symbol:ttm_io_prot symbol:ttm_bo_kmap symbol:ttm_bo_kunmap symbol:ttm_bo_vmap symbol:ttm_bo_vunmap symbol:ttm_bo_move_accel_cleanup symbol:ttm_bo_move_sync_cleanup symbol:ttm_bo_vm_reserve symbol:ttm_bo_vm_fault_reserved symbol:ttm_bo_vm_dummy_page symbol:ttm_bo_vm_fault symbol:ttm_bo_vm_open symbol:ttm_bo_vm_close symbol:ttm_bo_vm_access symbol:ttm_bo_mmap_obj symbol:ttm_eu_backoff_reservation symbol:ttm_eu_reserve_buffers symbol:ttm_eu_fence_buffer_objects symbol:ttm_range_man_init_nocheck symbol:ttm_range_man_fini_nocheck symbol:ttm_lru_bulk_move_init symbol:ttm_lru_bulk_move_fini symbol:ttm_lru_bulk_move_tail symbol:ttm_resource_init symbol:ttm_resource_fini symbol:ttm_resource_free symbol:ttm_resource_manager_init symbol:ttm_resource_manager_evict_all symbol:ttm_resource_manager_usage symbol:ttm_resource_manager_debug symbol:ttm_kmap_iter_iomap_init symbol:ttm_resource_manager_create_debugfs symbol:ttm_pool_alloc symbol:ttm_pool_free symbol:ttm_pool_init symbol:ttm_pool_fini symbol:ttm_pool_debugfs symbol:ttm_glob symbol:ttm_device_swapout symbol:ttm_device_init symbol:ttm_device_fini symbol:ttm_device_clear_dma_mappings
drm

kernel/drivers/gpu/drm/udl/udl.ko.xz usb:v17E9p*d*dc*dsc*dp*icFFisc00ip00in*
drm_kms_helper drm drm_shmem_helper

kernel/drivers/gpu/drm/drm_panel_orientation_quirks.ko.xz symbol:drm_get_panel_orientation_quirk

kernel/drivers/gpu/drm/solomon/ssd130x-i2c.ko.xz of:N*T*Csolomon,ssd1327C* of:N*T*Csolomon,ssd1327 of:N*T*Csolomon,ssd1325C* of:N*T*Csolomon,ssd1325 of:N*T*Csolomon,ssd1322C* of:N*T*Csolomon,ssd1322 of:N*T*Csolomon,ssd1309fb_i2cC* of:N*T*Csolomon,ssd1309fb_i2c of:N*T*Csolomon,ssd1307fb_i2cC* of:N*T*Csolomon,ssd1307fb_i2c of:N*T*Csolomon,ssd1306fb_i2cC* of:N*T*Csolomon,ssd1306fb_i2c of:N*T*Csolomon,ssd1305fb_i2cC* of:N*T*Csolomon,ssd1305fb_i2c of:N*T*Csolomon,ssd1309C* of:N*T*Csolomon,ssd1309 of:N*T*Csolomon,ssd1307C* of:N*T*Csolomon,ssd1307 of:N*T*Csolomon,ssd1306C* of:N*T*Csolomon,ssd1306 of:N*T*Csolomon,ssd1305C* of:N*T*Csolomon,ssd1305 of:N*T*Csinowealth,sh1106C* of:N*T*Csinowealth,sh1106
ssd130x regmap_i2c

kernel/drivers/gpu/drm/solomon/ssd130x-spi.ko.xz of:N*T*Csolomon,ssd1331C* of:N*T*Csolomon,ssd1331 of:N*T*Csolomon,ssd1327C* of:N*T*Csolomon,ssd1327 of:N*T*Csolomon,ssd1325C* of:N*T*Csolomon,ssd1325 of:N*T*Csolomon,ssd1322C* of:N*T*Csolomon,ssd1322 of:N*T*Csolomon,ssd1309C* of:N*T*Csolomon,ssd1309 of:N*T*Csolomon,ssd1307C* of:N*T*Csolomon,ssd1307 of:N*T*Csolomon,ssd1306C* of:N*T*Csolomon,ssd1306 of:N*T*Csolomon,ssd1305C* of:N*T*Csolomon,ssd1305 of:N*T*Csinowealth,sh1106C* of:N*T*Csinowealth,sh1106 spi:ssd1331 spi:ssd1327 spi:ssd1325 spi:ssd1322 spi:ssd1309 spi:ssd1307 spi:ssd1306 spi:ssd1305 spi:sh1106
ssd130x

kernel/drivers/gpu/drm/solomon/ssd130x.ko.xz symbol:ssd130x_variants symbol:ssd130x_probe symbol:ssd130x_remove symbol:ssd130x_shutdown
drm backlight drm_shmem_helper drm_kms_helper

kernel/drivers/gpu/drm/gud/gud.ko.xz usb:v16D0p10A9d*dc*dsc*dp*icFFisc*ip*in* usb:v1D50p614Dd*dc*dsc*dp*icFFisc*ip*in*
drm_kms_helper drm backlight drm_shmem_helper lz4_compress

kernel/drivers/gpu/drm/drm_ttm_helper.ko.xz symbol:drm_gem_ttm_print_info symbol:drm_gem_ttm_vmap symbol:drm_gem_ttm_vunmap symbol:drm_gem_ttm_mmap symbol:drm_gem_ttm_dumb_map_offset symbol:drm_fbdev_ttm_driver_fbdev_probe symbol:drm_fbdev_ttm_setup
drm drm_kms_helper ttm

kernel/drivers/gpu/drm/scheduler/gpu-sched.ko.xz symbol:drm_sched_tdr_queue_imm symbol:drm_sched_fault symbol:drm_sched_suspend_timeout symbol:drm_sched_resume_timeout symbol:drm_sched_stop symbol:drm_sched_start symbol:drm_sched_resubmit_jobs symbol:drm_sched_job_init symbol:drm_sched_job_arm symbol:drm_sched_job_add_dependency symbol:drm_sched_job_add_syncobj_dependency symbol:drm_sched_job_add_resv_dependencies symbol:drm_sched_job_add_implicit_dependencies symbol:drm_sched_job_cleanup symbol:drm_sched_pick_best symbol:drm_sched_init symbol:drm_sched_fini symbol:drm_sched_increase_karma symbol:drm_sched_wqueue_ready symbol:drm_sched_wqueue_stop symbol:drm_sched_wqueue_start symbol:to_drm_sched_fence symbol:drm_sched_entity_init symbol:drm_sched_entity_modify_sched symbol:drm_sched_entity_error symbol:drm_sched_entity_flush symbol:drm_sched_entity_fini symbol:drm_sched_entity_destroy symbol:drm_sched_entity_set_priority symbol:drm_sched_entity_push_job
drm

kernel/drivers/gpu/drm/drm_shmem_helper.ko.xz symbol:drm_gem_shmem_create symbol:drm_gem_shmem_create_with_mnt symbol:drm_gem_shmem_free symbol:drm_gem_shmem_put_pages symbol:drm_gem_shmem_pin_locked symbol:drm_gem_shmem_unpin_locked symbol:drm_gem_shmem_pin symbol:drm_gem_shmem_unpin symbol:drm_gem_shmem_vmap symbol:drm_gem_shmem_vunmap symbol:drm_gem_shmem_madvise symbol:drm_gem_shmem_purge symbol:drm_gem_shmem_dumb_create symbol:drm_gem_shmem_vm_ops symbol:drm_gem_shmem_mmap symbol:drm_gem_shmem_print_info symbol:drm_gem_shmem_get_sg_table symbol:drm_gem_shmem_get_pages_sgt symbol:drm_gem_shmem_prime_import_sg_table symbol:drm_fbdev_shmem_setup
drm drm_kms_helper

kernel/drivers/gpu/drm/display/drm_display_helper.ko.xz symbol:drm_hdmi_infoframe_set_hdr_metadata symbol:drm_hdmi_avi_infoframe_colorimetry symbol:drm_hdmi_avi_infoframe_bars symbol:drm_hdmi_avi_infoframe_content_type symbol:drm_hdmi_compute_mode_clock symbol:drm_scdc_read symbol:drm_scdc_write symbol:drm_scdc_get_scrambling_status symbol:drm_scdc_set_scrambling symbol:drm_scdc_set_high_tmds_clock_ratio symbol:__drm_atomic_helper_connector_hdmi_reset symbol:drm_atomic_helper_connector_hdmi_check symbol:drm_atomic_helper_connector_hdmi_update_infoframes symbol:drm_atomic_helper_connector_hdmi_update_audio_infoframe symbol:drm_atomic_helper_connector_hdmi_clear_audio_infoframe
drm

kernel/drivers/gpu/drm/drm_mipi_dbi.ko.xz symbol:mipi_dbi_command_read symbol:mipi_dbi_command_buf symbol:mipi_dbi_command_stackbuf symbol:mipi_dbi_buf_copy symbol:mipi_dbi_pipe_mode_valid symbol:mipi_dbi_pipe_update symbol:mipi_dbi_enable_flush symbol:mipi_dbi_pipe_disable symbol:mipi_dbi_pipe_begin_fb_access symbol:mipi_dbi_pipe_end_fb_access symbol:mipi_dbi_pipe_reset_plane symbol:mipi_dbi_pipe_duplicate_plane_state symbol:mipi_dbi_pipe_destroy_plane_state symbol:mipi_dbi_dev_init_with_formats symbol:mipi_dbi_dev_init symbol:mipi_dbi_hw_reset symbol:mipi_dbi_display_is_on symbol:mipi_dbi_poweron_reset symbol:mipi_dbi_poweron_conditional_reset symbol:mipi_dbi_spi_cmd_max_speed symbol:mipi_dbi_spi_init symbol:mipi_dbi_spi_transfer symbol:mipi_dbi_debugfs_init
drm_kms_helper drm

kernel/drivers/gpu/drm/tiny/st7735r.ko.xz of:N*T*Cokaya,rh128128tC* of:N*T*Cokaya,rh128128t of:N*T*Cjianda,jd_t18003_t01C* of:N*T*Cjianda,jd_t18003_t01 spi:rh128128t spi:jd_t18003_t01
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/tiny/ili9486.ko.xz of:N*T*Cozzmaker,piscreenC* of:N*T*Cozzmaker,piscreen of:N*T*Cwaveshare,rpi_lcd_35C* of:N*T*Cwaveshare,rpi_lcd_35 spi:piscreen spi:rpi_lcd_35
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/tiny/hx8357d.ko.xz of:N*T*Cadafruit,yx350hv15C* of:N*T*Cadafruit,yx350hv15 spi:yx350hv15
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/tiny/repaper.ko.xz of:N*T*Cpervasive,e2271cs021C* of:N*T*Cpervasive,e2271cs021 of:N*T*Cpervasive,e2200cs021C* of:N*T*Cpervasive,e2200cs021 of:N*T*Cpervasive,e1190cs021C* of:N*T*Cpervasive,e1190cs021 of:N*T*Cpervasive,e1144cs021C* of:N*T*Cpervasive,e1144cs021 spi:e2271cs021 spi:e2200cs021 spi:e1190cs021 spi:e1144cs021
drm_kms_helper drm drm_dma_helper

kernel/drivers/gpu/drm/tiny/ili9225.ko.xz of:N*T*Cvot,v220hf01a_tC* of:N*T*Cvot,v220hf01a_t spi:v220hf01a_t
drm_kms_helper drm drm_mipi_dbi drm_dma_helper

kernel/drivers/gpu/drm/tiny/mi0283qt.ko.xz of:N*T*Cmulti_inno,mi0283qtC* of:N*T*Cmulti_inno,mi0283qt spi:mi0283qt
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/tiny/st7586.ko.xz of:N*T*Clego,ev3_lcdC* of:N*T*Clego,ev3_lcd spi:ev3_lcd
drm_kms_helper drm drm_mipi_dbi drm_dma_helper

kernel/drivers/gpu/drm/tiny/ili9341.ko.xz of:N*T*Cadafruit,yx240qv29C* of:N*T*Cadafruit,yx240qv29 spi:yx240qv29
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/tiny/panel-mipi-dbi.ko.xz of:N*T*Cpanel_mipi_dbi_spiC* of:N*T*Cpanel_mipi_dbi_spi spi:panel_mipi_dbi_spi
drm_kms_helper drm drm_mipi_dbi backlight drm_dma_helper

kernel/drivers/gpu/drm/drm.ko.xz symbol:devm_aperture_acquire_from_firmware symbol:drm_aperture_remove_conflicting_framebuffers symbol:drm_aperture_remove_conflicting_pci_framebuffers symbol:__drm_crtc_commit_free symbol:drm_crtc_commit_wait symbol:drm_atomic_state_default_release symbol:drm_atomic_state_init symbol:drm_atomic_state_alloc symbol:drm_atomic_state_default_clear symbol:drm_atomic_state_clear symbol:__drm_atomic_state_free symbol:drm_atomic_get_crtc_state symbol:drm_atomic_get_plane_state symbol:drm_atomic_private_obj_init symbol:drm_atomic_private_obj_fini symbol:drm_atomic_get_private_obj_state symbol:drm_atomic_get_old_private_obj_state symbol:drm_atomic_get_new_private_obj_state symbol:drm_atomic_get_old_connector_for_encoder symbol:drm_atomic_get_new_connector_for_encoder symbol:drm_atomic_get_old_crtc_for_encoder symbol:drm_atomic_get_new_crtc_for_encoder symbol:drm_atomic_get_connector_state symbol:drm_atomic_get_bridge_state symbol:drm_atomic_get_old_bridge_state symbol:drm_atomic_get_new_bridge_state symbol:drm_atomic_add_encoder_bridges symbol:drm_atomic_add_affected_connectors symbol:drm_atomic_add_affected_planes symbol:drm_atomic_check_only symbol:drm_atomic_commit symbol:drm_atomic_nonblocking_commit symbol:__drm_atomic_helper_disable_plane symbol:__drm_atomic_helper_set_config symbol:drm_atomic_print_new_state symbol:drm_state_dump symbol:drm_atomic_set_mode_for_crtc symbol:drm_atomic_set_mode_prop_for_crtc symbol:drm_atomic_set_crtc_for_plane symbol:drm_atomic_set_fb_for_plane symbol:drm_atomic_set_crtc_for_connector symbol:drm_is_current_master symbol:drm_master_get symbol:drm_file_get_master symbol:drm_master_put symbol:drm_master_internal_acquire symbol:drm_master_internal_release symbol:drm_plane_create_alpha_property symbol:drm_plane_create_rotation_property symbol:drm_connector_create_rotation_property symbol:drm_rotation_simplify symbol:drm_plane_create_zpos_property symbol:drm_plane_create_zpos_immutable_property symbol:drm_atomic_normalize_zpos symbol:drm_plane_create_blend_mode_property symbol:drm_bridge_add symbol:devm_drm_bridge_add symbol:drm_bridge_remove symbol:drm_bridge_attach symbol:drm_bridge_chain_mode_valid symbol:drm_bridge_chain_mode_set symbol:drm_atomic_bridge_chain_disable symbol:drm_atomic_bridge_chain_post_disable symbol:drm_atomic_bridge_chain_pre_enable symbol:drm_atomic_bridge_chain_enable symbol:drm_atomic_bridge_chain_check symbol:drm_bridge_detect symbol:drm_bridge_get_modes symbol:drm_bridge_edid_read symbol:drm_bridge_hpd_enable symbol:drm_bridge_hpd_disable symbol:drm_bridge_hpd_notify symbol:of_drm_find_bridge symbol:drm_clflush_pages symbol:drm_clflush_sg symbol:drm_clflush_virt_range symbol:drm_need_swiotlb symbol:drm_memcpy_from_wc symbol:drm_client_init symbol:drm_client_register symbol:drm_client_release symbol:drm_client_dev_unregister symbol:drm_client_dev_hotplug symbol:drm_client_buffer_vmap_local symbol:drm_client_buffer_vunmap_local symbol:drm_client_buffer_vmap symbol:drm_client_buffer_vunmap symbol:drm_client_framebuffer_create symbol:drm_client_framebuffer_delete symbol:drm_client_framebuffer_flush symbol:drm_client_modeset_probe symbol:drm_client_rotation symbol:drm_client_modeset_check symbol:drm_client_modeset_commit_locked symbol:drm_client_modeset_commit symbol:drm_client_modeset_dpms symbol:drm_color_ctm_s31_32_to_qm_n symbol:drm_crtc_enable_color_mgmt symbol:drm_mode_crtc_set_gamma_size symbol:drm_plane_create_color_properties symbol:drm_plane_create_chroma_siting_properties symbol:drm_color_lut_check symbol:drm_get_connector_type_name symbol:drm_connector_init symbol:drm_connector_init_with_ddc symbol:drmm_connector_init symbol:drmm_connector_hdmi_init symbol:drm_connector_attach_edid_property symbol:drm_connector_attach_encoder symbol:drm_connector_has_possible_encoder symbol:drm_connector_cleanup symbol:drm_connector_register symbol:drm_connector_unregister symbol:drm_get_connector_status_name symbol:drm_connector_list_iter_begin symbol:drm_connector_list_iter_next symbol:drm_connector_list_iter_end symbol:drm_get_subpixel_order_name symbol:drm_display_info_set_bus_formats symbol:drm_get_tv_mode_from_name symbol:drm_hdmi_connector_get_broadcast_rgb_name symbol:drm_hdmi_connector_get_output_format_name symbol:drm_mode_create_dvi_i_properties symbol:drm_connector_attach_dp_subconnector_property symbol:drm_connector_attach_content_type_property symbol:drm_connector_attach_tv_margin_properties symbol:drm_mode_create_tv_margin_properties symbol:drm_mode_create_tv_properties_legacy symbol:drm_mode_create_tv_properties symbol:drm_mode_create_scaling_mode_property symbol:drm_connector_attach_vrr_capable_property symbol:drm_connector_attach_scaling_mode_property symbol:drm_mode_create_aspect_ratio_property symbol:drm_mode_create_hdmi_colorspace_property symbol:drm_mode_create_dp_colorspace_property symbol:drm_mode_create_content_type_property symbol:drm_mode_create_suggested_offset_properties symbol:drm_connector_set_path_property symbol:drm_connector_set_tile_property symbol:drm_connector_set_link_status_property symbol:drm_connector_attach_max_bpc_property symbol:drm_connector_attach_hdr_output_metadata_property symbol:drm_connector_attach_broadcast_rgb_property symbol:drm_connector_attach_colorspace_property symbol:drm_connector_atomic_hdr_metadata_equal symbol:drm_connector_set_vrr_capable_property symbol:drm_connector_set_panel_orientation symbol:drm_connector_set_panel_orientation_with_quirk symbol:drm_connector_set_orientation_from_panel symbol:drm_connector_create_privacy_screen_properties symbol:drm_connector_attach_privacy_screen_properties symbol:drm_connector_attach_privacy_screen_provider symbol:drm_connector_update_privacy_screen symbol:drm_connector_oob_hotplug_event symbol:drm_mode_put_tile_group symbol:drm_mode_get_tile_group symbol:drm_mode_create_tile_group symbol:drm_crtc_from_index symbol:drm_crtc_init_with_planes symbol:drmm_crtc_init_with_planes symbol:__drmm_crtc_alloc_with_planes symbol:drm_crtc_cleanup symbol:drm_mode_set_config_internal symbol:drm_crtc_check_viewport symbol:drm_crtc_create_scaling_filter_property symbol:drm_put_dev symbol:drm_dev_enter symbol:drm_dev_exit symbol:drm_dev_unplug symbol:__devm_drm_dev_alloc symbol:drm_dev_alloc symbol:drm_dev_get symbol:drm_dev_put symbol:drm_dev_register symbol:drm_dev_unregister symbol:drm_edid_header_is_valid symbol:drm_edid_is_valid symbol:drm_edid_valid symbol:drm_edid_override_connector_update symbol:drm_edid_raw symbol:drm_edid_alloc symbol:drm_edid_dup symbol:drm_edid_free symbol:drm_probe_ddc symbol:drm_get_edid symbol:drm_edid_read_custom symbol:drm_edid_read_ddc symbol:drm_edid_read symbol:drm_edid_get_product_id symbol:drm_edid_print_product_id symbol:drm_edid_get_panel_id symbol:drm_edid_read_base_block symbol:drm_get_edid_switcheroo symbol:drm_edid_read_switcheroo symbol:drm_edid_duplicate symbol:drm_mode_find_dmt symbol:drm_match_cea_mode symbol:drm_display_mode_from_cea_vic symbol:drm_edid_match symbol:drm_edid_get_monitor_name symbol:drm_edid_to_sad symbol:drm_edid_to_speaker_allocation symbol:drm_av_sync_delay symbol:drm_detect_hdmi_monitor symbol:drm_detect_monitor_audio symbol:drm_default_rgb_quant_range symbol:drm_edid_connector_update symbol:drm_edid_connector_add_modes symbol:drm_connector_update_edid_property symbol:drm_add_edid_modes symbol:drm_add_modes_noedid symbol:drm_hdmi_avi_infoframe_from_display_mode symbol:drm_hdmi_avi_infoframe_quant_range symbol:drm_hdmi_vendor_infoframe_from_display_mode symbol:drm_edid_is_digital symbol:drm_eld_sad_get symbol:drm_eld_sad_set symbol:drm_encoder_init symbol:drm_encoder_cleanup symbol:__drmm_encoder_alloc symbol:drmm_encoder_init symbol:drm_open symbol:drm_release symbol:drm_release_noglobal symbol:drm_read symbol:drm_poll symbol:drm_event_reserve_init_locked symbol:drm_event_reserve_init symbol:drm_event_cancel_free symbol:drm_send_event_timestamp_locked symbol:drm_send_event_locked symbol:drm_send_event symbol:drm_print_memory_stats symbol:drm_show_memory_stats symbol:drm_show_fdinfo symbol:drm_mode_legacy_fb_format symbol:drm_driver_legacy_fb_format symbol:drm_driver_color_mode_format symbol:drm_format_info symbol:drm_get_format_info symbol:drm_format_info_block_width symbol:drm_format_info_block_height symbol:drm_format_info_bpp symbol:drm_format_info_min_pitch symbol:drm_framebuffer_init symbol:drm_framebuffer_lookup symbol:drm_framebuffer_unregister_private symbol:drm_framebuffer_cleanup symbol:drm_framebuffer_remove symbol:drm_gem_object_init_with_mnt symbol:drm_gem_object_init symbol:drm_gem_private_object_init symbol:drm_gem_private_object_fini symbol:drm_gem_handle_delete symbol:drm_gem_dumb_map_offset symbol:drm_gem_handle_create symbol:drm_gem_free_mmap_offset symbol:drm_gem_create_mmap_offset_size symbol:drm_gem_create_mmap_offset symbol:drm_gem_get_pages symbol:drm_gem_put_pages symbol:drm_gem_objects_lookup symbol:drm_gem_object_lookup symbol:drm_gem_dma_resv_wait symbol:drm_gem_object_release symbol:drm_gem_object_free symbol:drm_gem_vm_open symbol:drm_gem_vm_close symbol:drm_gem_mmap_obj symbol:drm_gem_mmap symbol:drm_gem_vmap symbol:drm_gem_vunmap symbol:drm_gem_lock symbol:drm_gem_unlock symbol:drm_gem_vmap_unlocked symbol:drm_gem_vunmap_unlocked symbol:drm_gem_lock_reservations symbol:drm_gem_unlock_reservations symbol:drm_gem_lru_init symbol:drm_gem_lru_remove symbol:drm_gem_lru_move_tail_locked symbol:drm_gem_lru_move_tail symbol:drm_gem_lru_scan symbol:drm_gem_evict symbol:drm_noop symbol:drm_invalid_op symbol:drm_ioctl_kernel symbol:drm_ioctl symbol:drm_ioctl_flags symbol:__drmm_add_action symbol:__drmm_add_action_or_reset symbol:drmm_release_action symbol:drmm_kmalloc symbol:drmm_kstrdup symbol:drmm_kfree symbol:__drmm_mutex_release symbol:__drm_mm_interval_first symbol:drm_mm_reserve_node symbol:drm_mm_insert_node_in_range symbol:drm_mm_remove_node symbol:drm_mm_scan_init_with_range symbol:drm_mm_scan_add_block symbol:drm_mm_scan_remove_block symbol:drm_mm_scan_color_evict symbol:drm_mm_init symbol:drm_mm_takedown symbol:drm_mm_print symbol:drm_mode_config_reset symbol:drmm_mode_config_init symbol:drm_mode_config_cleanup symbol:drm_mode_object_find symbol:drm_mode_object_put symbol:drm_mode_object_get symbol:drm_object_attach_property symbol:drm_object_property_set_value symbol:drm_object_property_get_value symbol:drm_object_property_get_default_value symbol:drm_mode_debug_printmodeline symbol:drm_mode_create symbol:drm_mode_destroy symbol:drm_mode_probed_add symbol:drm_analog_tv_mode symbol:drm_cvt_mode symbol:drm_gtf_mode_complex symbol:drm_gtf_mode symbol:drm_display_mode_from_videomode symbol:drm_display_mode_to_videomode symbol:drm_bus_flags_from_videomode symbol:of_get_drm_display_mode symbol:of_get_drm_panel_display_mode symbol:drm_mode_set_name symbol:drm_mode_vrefresh symbol:drm_mode_get_hv_timing symbol:drm_mode_set_crtcinfo symbol:drm_mode_copy symbol:drm_mode_init symbol:drm_mode_duplicate symbol:drm_mode_match symbol:drm_mode_equal symbol:drm_mode_equal_no_clocks symbol:drm_mode_equal_no_clocks_no_stereo symbol:drm_mode_validate_driver symbol:drm_mode_validate_size symbol:drm_mode_validate_ycbcr420 symbol:drm_mode_prune_invalid symbol:drm_mode_sort symbol:drm_connector_list_update symbol:drm_mode_parse_command_line_for_connector symbol:drm_mode_create_from_cmdline_mode symbol:drm_mode_is_420_only symbol:drm_mode_is_420_also symbol:drm_mode_is_420 symbol:drm_set_preferred_mode symbol:drm_modeset_lock_all symbol:drm_modeset_unlock_all symbol:drm_warn_on_modeset_not_all_locked symbol:drm_modeset_acquire_init symbol:drm_modeset_acquire_fini symbol:drm_modeset_drop_locks symbol:drm_modeset_backoff symbol:drm_modeset_lock_init symbol:drm_modeset_lock symbol:drm_modeset_lock_single_interruptible symbol:drm_modeset_unlock symbol:drm_modeset_lock_all_ctx symbol:drm_universal_plane_init symbol:__drmm_universal_plane_alloc symbol:__drm_universal_plane_alloc symbol:drm_plane_cleanup symbol:drm_plane_from_index symbol:drm_plane_force_disable symbol:drm_mode_plane_set_obj_prop symbol:drm_plane_has_format symbol:drm_any_plane_has_format symbol:drm_plane_enable_fb_damage_clips symbol:drm_plane_get_damage_clips_count symbol:drm_plane_get_damage_clips symbol:drm_plane_create_scaling_filter_property symbol:drm_plane_add_size_hints_property symbol:drm_gem_dmabuf_export symbol:drm_gem_dmabuf_release symbol:drm_gem_prime_fd_to_handle symbol:drm_gem_prime_handle_to_dmabuf symbol:drm_gem_prime_handle_to_fd symbol:drm_gem_map_attach symbol:drm_gem_map_detach symbol:drm_gem_map_dma_buf symbol:drm_gem_unmap_dma_buf symbol:drm_gem_dmabuf_vmap symbol:drm_gem_dmabuf_vunmap symbol:drm_gem_prime_mmap symbol:drm_gem_dmabuf_mmap symbol:drm_prime_pages_to_sg symbol:drm_prime_get_contiguous_size symbol:drm_gem_prime_export symbol:drm_gem_prime_import_dev symbol:drm_gem_prime_import symbol:drm_prime_sg_to_page_array symbol:drm_prime_sg_to_dma_addr_array symbol:drm_prime_gem_destroy symbol:__drm_debug symbol:__drm_puts_coredump symbol:__drm_printfn_coredump symbol:__drm_puts_seq_file symbol:__drm_printfn_seq_file symbol:__drm_printfn_info symbol:__drm_printfn_dbg symbol:__drm_printfn_err symbol:drm_puts symbol:drm_printf symbol:drm_print_bits symbol:drm_dev_printk symbol:__drm_dev_dbg symbol:__drm_err symbol:drm_print_regset32 symbol:drm_property_create symbol:drm_property_create_enum symbol:drm_property_create_bitmask symbol:drm_property_create_range symbol:drm_property_create_signed_range symbol:drm_property_create_object symbol:drm_property_create_bool symbol:drm_property_add_enum symbol:drm_property_destroy symbol:drm_property_create_blob symbol:drm_property_blob_put symbol:drm_property_blob_get symbol:drm_property_lookup_blob symbol:drm_property_replace_global_blob symbol:drm_property_replace_blob symbol:drm_property_replace_blob_from_id symbol:drm_syncobj_find symbol:drm_syncobj_add_point symbol:drm_syncobj_replace_fence symbol:drm_syncobj_find_fence symbol:drm_syncobj_free symbol:drm_syncobj_create symbol:drm_syncobj_get_handle symbol:drm_syncobj_get_fd symbol:drm_timeout_abs_to_jiffies symbol:drm_sysfs_hotplug_event symbol:drm_sysfs_connector_hotplug_event symbol:drm_sysfs_connector_property_event symbol:drm_class_device_register symbol:drm_class_device_unregister symbol:drm_crtc_vblank_crtc symbol:drm_crtc_accurate_vblank_count symbol:drm_vblank_init symbol:drm_dev_has_vblank symbol:drm_crtc_vblank_waitqueue symbol:drm_calc_timestamping_constants symbol:drm_crtc_vblank_helper_get_vblank_timestamp_internal symbol:drm_crtc_vblank_helper_get_vblank_timestamp symbol:drm_crtc_vblank_count symbol:drm_crtc_vblank_count_and_time symbol:drm_crtc_next_vblank_start symbol:drm_crtc_arm_vblank_event symbol:drm_crtc_send_vblank_event symbol:drm_crtc_vblank_get symbol:drm_crtc_vblank_put symbol:drm_wait_one_vblank symbol:drm_crtc_wait_one_vblank symbol:drm_crtc_vblank_off symbol:drm_crtc_vblank_reset symbol:drm_crtc_set_max_vblank_count symbol:drm_crtc_vblank_on_config symbol:drm_crtc_vblank_on symbol:drm_crtc_vblank_restore symbol:drm_handle_vblank symbol:drm_crtc_handle_vblank symbol:drm_vblank_work_schedule symbol:drm_vblank_work_cancel_sync symbol:drm_vblank_work_flush symbol:drm_vblank_work_flush_all symbol:drm_vblank_work_init symbol:drm_vma_offset_manager_init symbol:drm_vma_offset_manager_destroy symbol:drm_vma_offset_lookup_locked symbol:drm_vma_offset_add symbol:drm_vma_offset_remove symbol:drm_vma_node_allow symbol:drm_vma_node_allow_once symbol:drm_vma_node_revoke symbol:drm_vma_node_is_allowed symbol:drm_writeback_connector_init symbol:drm_writeback_connector_init_with_encoder symbol:drm_writeback_prepare_job symbol:drm_writeback_queue_job symbol:drm_writeback_cleanup_job symbol:drm_writeback_signal_completion symbol:drm_writeback_get_out_fence symbol:drm_compat_ioctl symbol:drm_panel_init symbol:drm_panel_add symbol:drm_panel_remove symbol:drm_panel_prepare symbol:drm_panel_unprepare symbol:drm_panel_enable symbol:drm_panel_disable symbol:drm_panel_get_modes symbol:of_drm_find_panel symbol:of_drm_get_panel_orientation symbol:drm_is_panel_follower symbol:drm_panel_add_follower symbol:drm_panel_remove_follower symbol:devm_drm_panel_add_follower symbol:drm_panel_of_backlight symbol:drm_of_crtc_port_mask symbol:drm_of_find_possible_crtcs symbol:drm_of_component_match_add symbol:drm_of_component_probe symbol:drm_of_encoder_active_endpoint symbol:drm_of_find_panel_or_bridge symbol:drm_of_lvds_get_dual_link_pixel_order symbol:drm_of_lvds_get_data_mapping symbol:drm_of_get_data_lanes_count symbol:drm_of_get_data_lanes_count_ep symbol:drm_of_get_dsi_bus symbol:drm_debugfs_gpuva_info symbol:drm_debugfs_create_files symbol:drm_debugfs_remove_files symbol:drm_debugfs_add_file symbol:drm_debugfs_add_files symbol:drm_crtc_add_crc_entry
backlight drm_panel_orientation_quirks

kernel/drivers/gpu/drm/rp1/rp1-vec/drm-rp1-vec.ko.xz of:N*T*Craspberrypi,rp1vecC* of:N*T*Craspberrypi,rp1vec
drm drm_kms_helper drm_dma_helper drm_ttm_helper

kernel/drivers/gpu/drm/rp1/rp1-dpi/drm-rp1-dpi.ko.xz of:N*T*Craspberrypi,rp1dpiC* of:N*T*Craspberrypi,rp1dpi
drm drm_kms_helper rp1_pio drm_dma_helper drm_ttm_helper

kernel/drivers/gpu/drm/rp1/rp1-dsi/drm-rp1-dsi.ko.xz of:N*T*Craspberrypi,rp1dsiC* of:N*T*Craspberrypi,rp1dsi
drm drm_kms_helper drm_dma_helper drm_ttm_helper

kernel/drivers/gpu/drm/drm_kms_helper.ko.xz symbol:drm_atomic_helper_check_modeset symbol:drm_atomic_helper_check_wb_connector_state symbol:drm_atomic_helper_check_plane_state symbol:drm_atomic_helper_check_crtc_primary_plane symbol:drm_atomic_helper_check_planes symbol:drm_atomic_helper_check symbol:drm_atomic_helper_update_legacy_modeset_state symbol:drm_atomic_helper_calc_timestamping_constants symbol:drm_atomic_helper_commit_modeset_disables symbol:drm_atomic_helper_commit_modeset_enables symbol:drm_atomic_helper_wait_for_fences symbol:drm_atomic_helper_wait_for_vblanks symbol:drm_atomic_helper_wait_for_flip_done symbol:drm_atomic_helper_commit_tail symbol:drm_atomic_helper_commit_tail_rpm symbol:drm_atomic_helper_async_check symbol:drm_atomic_helper_async_commit symbol:drm_atomic_helper_commit symbol:drm_atomic_helper_setup_commit symbol:drm_atomic_helper_wait_for_dependencies symbol:drm_atomic_helper_fake_vblank symbol:drm_atomic_helper_commit_hw_done symbol:drm_atomic_helper_commit_cleanup_done symbol:drm_atomic_helper_prepare_planes symbol:drm_atomic_helper_unprepare_planes symbol:drm_atomic_helper_commit_planes symbol:drm_atomic_helper_commit_planes_on_crtc symbol:drm_atomic_helper_disable_planes_on_crtc symbol:drm_atomic_helper_cleanup_planes symbol:drm_atomic_helper_swap_state symbol:drm_atomic_helper_update_plane symbol:drm_atomic_helper_disable_plane symbol:drm_atomic_helper_set_config symbol:drm_atomic_helper_disable_all symbol:drm_atomic_helper_shutdown symbol:drm_atomic_helper_duplicate_state symbol:drm_atomic_helper_suspend symbol:drm_atomic_helper_commit_duplicated_state symbol:drm_atomic_helper_resume symbol:drm_atomic_helper_page_flip symbol:drm_atomic_helper_page_flip_target symbol:drm_atomic_helper_bridge_propagate_bus_fmt symbol:__drm_atomic_helper_crtc_state_reset symbol:__drm_atomic_helper_crtc_reset symbol:drm_atomic_helper_crtc_reset symbol:__drm_atomic_helper_crtc_duplicate_state symbol:drm_atomic_helper_crtc_duplicate_state symbol:__drm_atomic_helper_crtc_destroy_state symbol:drm_atomic_helper_crtc_destroy_state symbol:__drm_atomic_helper_plane_state_reset symbol:__drm_atomic_helper_plane_reset symbol:drm_atomic_helper_plane_reset symbol:__drm_atomic_helper_plane_duplicate_state symbol:drm_atomic_helper_plane_duplicate_state symbol:__drm_atomic_helper_plane_destroy_state symbol:drm_atomic_helper_plane_destroy_state symbol:__drm_atomic_helper_connector_state_reset symbol:__drm_atomic_helper_connector_reset symbol:drm_atomic_helper_connector_reset symbol:drm_atomic_helper_connector_tv_margins_reset symbol:drm_atomic_helper_connector_tv_reset symbol:drm_atomic_helper_connector_tv_check symbol:__drm_atomic_helper_connector_duplicate_state symbol:drm_atomic_helper_connector_duplicate_state symbol:__drm_atomic_helper_connector_destroy_state symbol:drm_atomic_helper_connector_destroy_state symbol:__drm_atomic_helper_private_obj_duplicate_state symbol:__drm_atomic_helper_bridge_duplicate_state symbol:drm_atomic_helper_bridge_duplicate_state symbol:drm_atomic_helper_bridge_destroy_state symbol:__drm_atomic_helper_bridge_reset symbol:drm_atomic_helper_bridge_reset symbol:drm_helper_encoder_in_use symbol:drm_helper_crtc_in_use symbol:drm_helper_disable_unused_functions symbol:drm_crtc_helper_set_mode symbol:drm_crtc_helper_atomic_check symbol:drm_crtc_helper_set_config symbol:drm_helper_connector_dpms symbol:drm_helper_resume_force_mode symbol:drm_helper_force_disable_all symbol:drm_atomic_helper_check_plane_damage symbol:drm_atomic_helper_dirtyfb symbol:drm_atomic_helper_damage_iter_init symbol:drm_atomic_helper_damage_iter_next symbol:drm_atomic_helper_damage_merged symbol:drm_i2c_encoder_init symbol:drm_i2c_encoder_destroy symbol:drm_i2c_encoder_dpms symbol:drm_i2c_encoder_mode_fixup symbol:drm_i2c_encoder_prepare symbol:drm_i2c_encoder_commit symbol:drm_i2c_encoder_mode_set symbol:drm_i2c_encoder_detect symbol:drm_i2c_encoder_save symbol:drm_i2c_encoder_restore symbol:drm_flip_work_queue symbol:drm_flip_work_commit symbol:drm_flip_work_init symbol:drm_flip_work_cleanup symbol:drm_format_conv_state_init symbol:drm_format_conv_state_copy symbol:drm_format_conv_state_reserve symbol:drm_format_conv_state_release symbol:drm_fb_clip_offset symbol:drm_fb_memcpy symbol:drm_fb_swab symbol:drm_fb_xrgb8888_to_rgb332 symbol:drm_fb_xrgb8888_to_rgb565 symbol:drm_fb_xrgb8888_to_xrgb1555 symbol:drm_fb_xrgb8888_to_argb1555 symbol:drm_fb_xrgb8888_to_rgba5551 symbol:drm_fb_xrgb8888_to_rgb888 symbol:drm_fb_xrgb8888_to_bgr888 symbol:drm_fb_xrgb8888_to_argb8888 symbol:drm_fb_xrgb8888_to_abgr8888 symbol:drm_fb_xrgb8888_to_xbgr8888 symbol:drm_fb_xrgb8888_to_bgrx8888 symbol:drm_fb_xrgb8888_to_xrgb2101010 symbol:drm_fb_xrgb8888_to_argb2101010 symbol:drm_fb_xrgb8888_to_gray8 symbol:drm_fb_blit symbol:drm_fb_xrgb8888_to_mono symbol:drm_fb_build_fourcc_list symbol:drm_gem_plane_helper_prepare_fb symbol:__drm_gem_duplicate_shadow_plane_state symbol:drm_gem_duplicate_shadow_plane_state symbol:__drm_gem_destroy_shadow_plane_state symbol:drm_gem_destroy_shadow_plane_state symbol:__drm_gem_reset_shadow_plane symbol:drm_gem_reset_shadow_plane symbol:drm_gem_begin_shadow_fb_access symbol:drm_gem_end_shadow_fb_access symbol:drm_gem_simple_kms_begin_shadow_fb_access symbol:drm_gem_simple_kms_end_shadow_fb_access symbol:drm_gem_simple_kms_reset_shadow_plane symbol:drm_gem_simple_kms_duplicate_shadow_plane_state symbol:drm_gem_simple_kms_destroy_shadow_plane_state symbol:drm_gem_fb_get_obj symbol:drm_gem_fb_destroy symbol:drm_gem_fb_create_handle symbol:drm_gem_fb_init_with_funcs symbol:drm_gem_fb_create_with_funcs symbol:drm_gem_fb_create symbol:drm_gem_fb_create_with_dirty symbol:drm_gem_fb_vmap symbol:drm_gem_fb_vunmap symbol:drm_gem_fb_begin_cpu_access symbol:drm_gem_fb_end_cpu_access symbol:drm_gem_fb_afbc_init symbol:drm_helper_move_panel_connectors_to_head symbol:drm_helper_mode_fill_fb_struct symbol:drm_crtc_init symbol:drm_mode_config_helper_suspend symbol:drm_mode_config_helper_resume symbol:drm_plane_helper_update_primary symbol:drm_plane_helper_disable_primary symbol:drm_plane_helper_destroy symbol:drm_kms_helper_poll_enable symbol:drm_kms_helper_poll_reschedule symbol:drm_helper_probe_detect symbol:drm_helper_probe_single_connector_modes symbol:drm_kms_helper_hotplug_event symbol:drm_kms_helper_connector_hotplug_event symbol:drm_kms_helper_is_poll_worker symbol:drm_kms_helper_poll_disable symbol:drm_kms_helper_poll_init symbol:drm_kms_helper_poll_fini symbol:drmm_kms_helper_poll_init symbol:drm_connector_helper_hpd_irq_event symbol:drm_helper_hpd_irq_event symbol:drm_crtc_helper_mode_valid_fixed symbol:drm_connector_helper_get_modes_fixed symbol:drm_connector_helper_get_modes symbol:drm_connector_helper_tv_get_modes symbol:drm_connector_helper_detect_from_ddc symbol:drm_rect_intersect symbol:drm_rect_clip_scaled symbol:drm_rect_calc_hscale symbol:drm_rect_calc_vscale symbol:drm_rect_debug_print symbol:drm_rect_rotate symbol:drm_rect_rotate_inv symbol:drm_self_refresh_helper_update_avg_times symbol:drm_self_refresh_helper_alter_state symbol:drm_self_refresh_helper_init symbol:drm_self_refresh_helper_cleanup symbol:drm_simple_encoder_init symbol:__drmm_simple_encoder_alloc symbol:drm_simple_display_pipe_attach_bridge symbol:drm_simple_display_pipe_init symbol:drm_client_setup symbol:drm_client_setup_with_fourcc symbol:drm_client_setup_with_color_mode symbol:drm_bridge_is_panel symbol:drm_panel_bridge_add symbol:drm_panel_bridge_add_typed symbol:drm_panel_bridge_remove symbol:drm_panel_bridge_set_orientation symbol:devm_drm_panel_bridge_add symbol:devm_drm_panel_bridge_add_typed symbol:drmm_panel_bridge_add symbol:drm_panel_bridge_connector symbol:devm_drm_of_get_bridge symbol:drmm_of_get_bridge symbol:drm_fbdev_client_setup symbol:drm_fb_helper_debug_enter symbol:drm_fb_helper_debug_leave symbol:drm_fb_helper_restore_fbdev_mode_unlocked symbol:drm_fb_helper_blank symbol:drm_fb_helper_prepare symbol:drm_fb_helper_unprepare symbol:drm_fb_helper_init symbol:drm_fb_helper_alloc_info symbol:drm_fb_helper_release_info symbol:drm_fb_helper_unregister_info symbol:drm_fb_helper_fini symbol:drm_fb_helper_damage_range symbol:drm_fb_helper_damage_area symbol:drm_fb_helper_deferred_io symbol:drm_fb_helper_set_suspend symbol:drm_fb_helper_set_suspend_unlocked symbol:drm_fb_helper_setcmap symbol:drm_fb_helper_ioctl symbol:drm_fb_helper_check_var symbol:drm_fb_helper_set_par symbol:drm_fb_helper_pan_display symbol:drm_fb_helper_fill_info symbol:drm_fb_helper_initial_config symbol:drm_fb_helper_hotplug_event symbol:drm_fb_helper_lastclose
drm backlight

kernel/drivers/gpu/drm/panel/panel-waveshare-dsi.ko.xz of:N*T*Cwaveshare,7.0inch_h_panelC* of:N*T*Cwaveshare,7.0inch_h_panel of:N*T*Cwaveshare,13.3inch_2lane_panelC* of:N*T*Cwaveshare,13.3inch_2lane_panel of:N*T*Cwaveshare,13.3inch_4lane_panelC* of:N*T*Cwaveshare,13.3inch_4lane_panel of:N*T*Cwaveshare,8.8inch_panelC* of:N*T*Cwaveshare,8.8inch_panel of:N*T*Cwaveshare,6.25inch_panelC* of:N*T*Cwaveshare,6.25inch_panel of:N*T*Cwaveshare,5.0inch_panelC* of:N*T*Cwaveshare,5.0inch_panel of:N*T*Cwaveshare,4inch_panelC* of:N*T*Cwaveshare,4inch_panel of:N*T*Cwaveshare,11.9inch_panelC* of:N*T*Cwaveshare,11.9inch_panel of:N*T*Cwaveshare,10.1inch_panelC* of:N*T*Cwaveshare,10.1inch_panel of:N*T*Cwaveshare,8.0inch_panelC* of:N*T*Cwaveshare,8.0inch_panel of:N*T*Cwaveshare,7.9inch_panelC* of:N*T*Cwaveshare,7.9inch_panel of:N*T*Cwaveshare,7.0inch_c_panelC* of:N*T*Cwaveshare,7.0inch_c_panel of:N*T*Cwaveshare,4.0inch_panelC* of:N*T*Cwaveshare,4.0inch_panel of:N*T*Cwaveshare,3.4inch_panelC* of:N*T*Cwaveshare,3.4inch_panel of:N*T*Cwaveshare,2.8inch_panelC* of:N*T*Cwaveshare,2.8inch_panel
drm backlight

kernel/drivers/gpu/drm/panel/panel-jdi-lt070me05000.ko.xz of:N*T*Cjdi,lt070me05000C* of:N*T*Cjdi,lt070me05000
drm backlight

kernel/drivers/gpu/drm/panel/panel-tdo-y17p.ko.xz of:N*T*Ctdo,y17pC* of:N*T*Ctdo,y17p of:N*T*Cpimoroni,hyperpixel4squareC* of:N*T*Cpimoroni,hyperpixel4square of:N*T*Ctdo,tl040hds20ctC* of:N*T*Ctdo,tl040hds20ct spi:y17p spi:hyperpixel4square spi:tl040hds20ct
drm

kernel/drivers/gpu/drm/panel/panel-ilitek-ili9881c.ko.xz of:N*T*Craspberrypi,dsi_7inchC* of:N*T*Craspberrypi,dsi_7inch of:N*T*Craspberrypi,dsi_5inchC* of:N*T*Craspberrypi,dsi_5inch of:N*T*Cnwe,nwe080C* of:N*T*Cnwe,nwe080 of:N*T*Ccrystalfontz,cfaf7201280a0_050txC* of:N*T*Ccrystalfontz,cfaf7201280a0_050tx of:N*T*Campire,am8001280gC* of:N*T*Campire,am8001280g of:N*T*Cwanchanglong,w552946abaC* of:N*T*Cwanchanglong,w552946aba of:N*T*Ctdo,tl050hdv35C* of:N*T*Ctdo,tl050hdv35 of:N*T*Cstartek,kd050hdfia020C* of:N*T*Cstartek,kd050hdfia020 of:N*T*Cfeixin,k101_im2byl02C* of:N*T*Cfeixin,k101_im2byl02 of:N*T*Cbananapi,lhr050h41C* of:N*T*Cbananapi,lhr050h41
drm

kernel/drivers/gpu/drm/panel/panel-simple.ko.xz of:N*T*Cpanel_dpiC* of:N*T*Cpanel_dpi of:N*T*Cmicrochip,ac69t88aC* of:N*T*Cmicrochip,ac69t88a of:N*T*Cyes_optoelectronics,ytc700tlag_05_201cC* of:N*T*Cyes_optoelectronics,ytc700tlag_05_201c of:N*T*Cwinstar,wf35ltiacdC* of:N*T*Cwinstar,wf35ltiacd of:N*T*Cvxt,vl050_8048nt_c01C* of:N*T*Cvxt,vl050_8048nt_c01 of:N*T*Cvivax,tpc9150_panelC* of:N*T*Cvivax,tpc9150_panel of:N*T*Curt,umsh_8596md_20tC* of:N*T*Curt,umsh_8596md_20t of:N*T*Curt,umsh_8596md_19tC* of:N*T*Curt,umsh_8596md_19t of:N*T*Curt,umsh_8596md_11tC* of:N*T*Curt,umsh_8596md_11t of:N*T*Curt,umsh_8596md_7tC* of:N*T*Curt,umsh_8596md_7t of:N*T*Curt,umsh_8596md_1tC* of:N*T*Curt,umsh_8596md_1t of:N*T*Curt,umsh_8596md_tC* of:N*T*Curt,umsh_8596md_t of:N*T*Ctpk,f10a_0102C* of:N*T*Ctpk,f10a_0102 of:N*T*Ctpk,f07a_0102C* of:N*T*Ctpk,f07a_0102 of:N*T*Ctoshiba,lt089ac29000C* of:N*T*Ctoshiba,lt089ac29000 of:N*T*Cti,nspire_classic_lcd_panelC* of:N*T*Cti,nspire_classic_lcd_panel of:N*T*Cti,nspire_cx_lcd_panelC* of:N*T*Cti,nspire_cx_lcd_panel of:N*T*Ctianma,tm070rvhg71C* of:N*T*Ctianma,tm070rvhg71 of:N*T*Ctianma,tm070jvhg33C* of:N*T*Ctianma,tm070jvhg33 of:N*T*Ctianma,tm070jdhg30C* of:N*T*Ctianma,tm070jdhg30 of:N*T*Ctfc,s9700rtwv43tr_01bC* of:N*T*Ctfc,s9700rtwv43tr_01b of:N*T*Cteam_source_display,tst043015cmhxC* of:N*T*Cteam_source_display,tst043015cmhx of:N*T*Cstartek,kd070wvfpaC* of:N*T*Cstartek,kd070wvfpa of:N*T*Cstarry,kr070pe2tC* of:N*T*Cstarry,kr070pe2t of:N*T*Cshelly,sca07010_bfn_lnnC* of:N*T*Cshelly,sca07010_bfn_lnn of:N*T*Csharp,ls020b1dd01dC* of:N*T*Csharp,ls020b1dd01d of:N*T*Csharp,lq101k1ly04C* of:N*T*Csharp,lq101k1ly04 of:N*T*Csharp,lq070y3dg3bC* of:N*T*Csharp,lq070y3dg3b of:N*T*Csharp,lq035q7db03C* of:N*T*Csharp,lq035q7db03 of:N*T*Csatoz,sat050at40h12r2C* of:N*T*Csatoz,sat050at40h12r2 of:N*T*Csamsung,ltn101nt05C* of:N*T*Csamsung,ltn101nt05 of:N*T*Csamsung,ltl101al01C* of:N*T*Csamsung,ltl101al01 of:N*T*Crocktech,rk101ii01d_ctC* of:N*T*Crocktech,rk101ii01d_ct of:N*T*Crocktech,rk070er9427C* of:N*T*Crocktech,rk070er9427 of:N*T*Craspberrypi,7inch_dsiC* of:N*T*Craspberrypi,7inch_dsi of:N*T*Crocktech,rk043fn48hC* of:N*T*Crocktech,rk043fn48h of:N*T*Cqishenglong,gopher2b_lcdC* of:N*T*Cqishenglong,gopher2b_lcd of:N*T*Cqiaodian,qd43003c0_40C* of:N*T*Cqiaodian,qd43003c0_40 of:N*T*Cprimeview,pm070wl4C* of:N*T*Cprimeview,pm070wl4 of:N*T*Cpowertip,ph800480t013_idf02C* of:N*T*Cpowertip,ph800480t013_idf02 of:N*T*Cpowertip,ph128800t006_zhc01C* of:N*T*Cpowertip,ph128800t006_zhc01 of:N*T*Cpda,91_00156_a0C* of:N*T*Cpda,91_00156_a0 of:N*T*Cosddisplays,osd070t1718_19tsC* of:N*T*Cosddisplays,osd070t1718_19ts of:N*T*Cortustech,com43h4m85ulcC* of:N*T*Cortustech,com43h4m85ulc of:N*T*Cortustech,com37h3m99dtcC* of:N*T*Cortustech,com37h3m99dtc of:N*T*Cortustech,com37h3m05dtcC* of:N*T*Cortustech,com37h3m05dtc of:N*T*Contat,yx700wv03C* of:N*T*Contat,yx700wv03 of:N*T*Contat,kd50g21_40nt_a1C* of:N*T*Contat,kd50g21_40nt_a1 of:N*T*Colimex,lcd_olinuxino_43_tsC* of:N*T*Colimex,lcd_olinuxino_43_ts of:N*T*Cokaya,rs800480t_7x0gpC* of:N*T*Cokaya,rs800480t_7x0gp of:N*T*Cnvd,9128C* of:N*T*Cnvd,9128 of:N*T*Cnlt,nl192108ac18_02dC* of:N*T*Cnlt,nl192108ac18_02d of:N*T*Cnewhaven,nhd_4.3_480272ef_atxlC* of:N*T*Cnewhaven,nhd_4.3_480272ef_atxl of:N*T*Cnetron_dy,e231732C* of:N*T*Cnetron_dy,e231732 of:N*T*Cnec,nl4827hc19_05bC* of:N*T*Cnec,nl4827hc19_05b of:N*T*Cnec,nl12880bc20_05C* of:N*T*Cnec,nl12880bc20_05 of:N*T*Cmulti_inno,mi1010ait_1cpC* of:N*T*Cmulti_inno,mi1010ait_1cp of:N*T*Cmulti_inno,mi0800ft_9C* of:N*T*Cmulti_inno,mi0800ft_9 of:N*T*Cmulti_inno,mi0700s4t_6C* of:N*T*Cmulti_inno,mi0700s4t_6 of:N*T*Cmitsubishi,aa084xe01C* of:N*T*Cmitsubishi,aa084xe01 of:N*T*Cmitsubishi,aa070mc01_ca1C* of:N*T*Cmitsubishi,aa070mc01_ca1 of:N*T*Cmicrotips,mf_103hieb0ga0C* of:N*T*Cmicrotips,mf_103hieb0ga0 of:N*T*Cmicrotips,mf_101hiebcaf0C* of:N*T*Cmicrotips,mf_101hiebcaf0 of:N*T*Clogictechno,lttd800480070_l6wh_rtC* of:N*T*Clogictechno,lttd800480070_l6wh_rt of:N*T*Clogictechno,lttd800480070_l2rtC* of:N*T*Clogictechno,lttd800480070_l2rt of:N*T*Clogictechno,lt170410_2whcC* of:N*T*Clogictechno,lt170410_2whc of:N*T*Clogictechno,lt161010_2nhrC* of:N*T*Clogictechno,lt161010_2nhr of:N*T*Clogictechno,lt161010_2nhcC* of:N*T*Clogictechno,lt161010_2nhc of:N*T*Clogicpd,type28C* of:N*T*Clogicpd,type28 of:N*T*Clincolntech,lcd185_101ctC* of:N*T*Clincolntech,lcd185_101ct of:N*T*Clg,lb070wv8C* of:N*T*Clg,lb070wv8 of:N*T*Clemaker,bl035_rgb_002C* of:N*T*Clemaker,bl035_rgb_002 of:N*T*Ckyo,tcg121xglpC* of:N*T*Ckyo,tcg121xglp of:N*T*Ckoe,tx31d200vm0baaC* of:N*T*Ckoe,tx31d200vm0baa of:N*T*Ckoe,tx26d202vm0bwaC* of:N*T*Ckoe,tx26d202vm0bwa of:N*T*Ckoe,tx14d24vm1bpaC* of:N*T*Ckoe,tx14d24vm1bpa of:N*T*Cinnolux,zj070na_01pC* of:N*T*Cinnolux,zj070na_01p of:N*T*Cinnolux,n156bge_l21C* of:N*T*Cinnolux,n156bge_l21 of:N*T*Cinnolux,g156hce_l01C* of:N*T*Cinnolux,g156hce_l01 of:N*T*Cinnolux,g121xce_l01C* of:N*T*Cinnolux,g121xce_l01 of:N*T*Cinnolux,g121x1_l03C* of:N*T*Cinnolux,g121x1_l03 of:N*T*Cinnolux,g121i1_l01C* of:N*T*Cinnolux,g121i1_l01 of:N*T*Cinnolux,g101ice_l01C* of:N*T*Cinnolux,g101ice_l01 of:N*T*Cinnolux,g070y2_t02C* of:N*T*Cinnolux,g070y2_t02 of:N*T*Cinnolux,g070y2_l01C* of:N*T*Cinnolux,g070y2_l01 of:N*T*Cinnolux,g070ace_lh3C* of:N*T*Cinnolux,g070ace_lh3 of:N*T*Cinnolux,g070ace_l01C* of:N*T*Cinnolux,g070ace_l01 of:N*T*Cinnolux,at070tn92C* of:N*T*Cinnolux,at070tn92 of:N*T*Cinnolux,at056tn53v1C* of:N*T*Cinnolux,at056tn53v1 of:N*T*Cinnolux,at043tn24C* of:N*T*Cinnolux,at043tn24 of:N*T*Chit,tx23d38vm0caaC* of:N*T*Chit,tx23d38vm0caa of:N*T*Channstar,hsd101pww2C* of:N*T*Channstar,hsd101pww2 of:N*T*Channstar,hsd100pxn1C* of:N*T*Channstar,hsd100pxn1 of:N*T*Channstar,hsd070pww1C* of:N*T*Channstar,hsd070pww1 of:N*T*Cgiantplus,gpm940b0C* of:N*T*Cgiantplus,gpm940b0 of:N*T*Cgiantplus,gpg482739qs5C* of:N*T*Cgiantplus,gpg482739qs5 of:N*T*Cgeekworm,mzp280C* of:N*T*Cgeekworm,mzp280 of:N*T*Cfriendlyarm,hd702eC* of:N*T*Cfriendlyarm,hd702e of:N*T*Cfrida,frd350h54004C* of:N*T*Cfrida,frd350h54004 of:N*T*Cfoxlink,fl500wvr00_a0tC* of:N*T*Cfoxlink,fl500wvr00_a0t of:N*T*Cevervision,vgg804821C* of:N*T*Cevervision,vgg804821 of:N*T*Cevervision,vgg644804C* of:N*T*Cevervision,vgg644804 of:N*T*Ceink,vb3300_kcaC* of:N*T*Ceink,vb3300_kca of:N*T*Cedt,etmv570g2dhuC* of:N*T*Cedt,etmv570g2dhu of:N*T*Cedt,etml1010g3draC* of:N*T*Cedt,etml1010g3dra of:N*T*Cedt,etml0700y5dhaC* of:N*T*Cedt,etml0700y5dha of:N*T*Cedt,etm0700g0edh6C* of:N*T*Cedt,etm0700g0edh6 of:N*T*Cedt,etm0700g0bdh6C* of:N*T*Cedt,etm0700g0bdh6 of:N*T*Cedt,etm0700g0dh6C* of:N*T*Cedt,etm0700g0dh6 of:N*T*Cedt,et070080dh6C* of:N*T*Cedt,et070080dh6 of:N*T*Cedt,et057090dhuC* of:N*T*Cedt,et057090dhu of:N*T*Cedt,etm0430g0dh6C* of:N*T*Cedt,etm0430g0dh6 of:N*T*Cedt,etm043080dh6gpC* of:N*T*Cedt,etm043080dh6gp of:N*T*Cedt,etm0350g0dh6C* of:N*T*Cedt,etm0350g0dh6 of:N*T*Cedt,et035012dm6C* of:N*T*Cedt,et035012dm6 of:N*T*Cdlc,dlc1010gigC* of:N*T*Cdlc,dlc1010gig of:N*T*Cdlc,dlc0700yzg_1C* of:N*T*Cdlc,dlc0700yzg_1 of:N*T*Cdataimage,scf0700c48ggu18C* of:N*T*Cdataimage,scf0700c48ggu18 of:N*T*Cdataimage,fg1001l0dsswmg01C* of:N*T*Cdataimage,fg1001l0dsswmg01 of:N*T*Cdataimage,fg040346dsswbg04C* of:N*T*Cdataimage,fg040346dsswbg04 of:N*T*Cchunghwa,claa101wb01C* of:N*T*Cchunghwa,claa101wb01 of:N*T*Cchunghwa,claa101wa01aC* of:N*T*Cchunghwa,claa101wa01a of:N*T*Cchunghwa,claa070wp03xgC* of:N*T*Cchunghwa,claa070wp03xg of:N*T*Cchefree,ch101olhlwh_002C* of:N*T*Cchefree,ch101olhlwh_002 of:N*T*Ccdtech,s070wv95_ct16C* of:N*T*Ccdtech,s070wv95_ct16 of:N*T*Ccdtech,s070swv29hg_dc44C* of:N*T*Ccdtech,s070swv29hg_dc44 of:N*T*Ccdtech,s070pws19hp_fc21C* of:N*T*Ccdtech,s070pws19hp_fc21 of:N*T*Ccdtech,s043wq26h_ct7C* of:N*T*Ccdtech,s043wq26h_ct7 of:N*T*Ccct,cmt430b19n00C* of:N*T*Ccct,cmt430b19n00 of:N*T*Cboe,hv070wsa_100C* of:N*T*Cboe,hv070wsa_100 of:N*T*Cboe,ev121wxm_n10_1850C* of:N*T*Cboe,ev121wxm_n10_1850 of:N*T*Cboe,bp101wx1_100C* of:N*T*Cboe,bp101wx1_100 of:N*T*Cboe,bp082wx1_100C* of:N*T*Cboe,bp082wx1_100 of:N*T*Cbananapi,s070wv20_ct16C* of:N*T*Cbananapi,s070wv20_ct16 of:N*T*Cavic,tm070ddh03C* of:N*T*Cavic,tm070ddh03 of:N*T*Cauo,t215hvn01C* of:N*T*Cauo,t215hvn01 of:N*T*Cauo,p320hvn03C* of:N*T*Cauo,p320hvn03 of:N*T*Cauo,g190ean01C* of:N*T*Cauo,g190ean01 of:N*T*Cauo,g185han01C* of:N*T*Cauo,g185han01 of:N*T*Cauo,g156xtn01C* of:N*T*Cauo,g156xtn01 of:N*T*Cauo,g156han04C* of:N*T*Cauo,g156han04 of:N*T*Cauo,g133han01C* of:N*T*Cauo,g133han01 of:N*T*Cauo,g121ean01C* of:N*T*Cauo,g121ean01 of:N*T*Cauo,g104stn01C* of:N*T*Cauo,g104stn01 of:N*T*Cauo,g104sn02C* of:N*T*Cauo,g104sn02 of:N*T*Cauo,g101evn010C* of:N*T*Cauo,g101evn010 of:N*T*Cauo,g070vvn01C* of:N*T*Cauo,g070vvn01 of:N*T*Cauo,b116xw03C* of:N*T*Cauo,b116xw03 of:N*T*Cauo,b101xtn01C* of:N*T*Cauo,b101xtn01 of:N*T*Cauo,b101aw03C* of:N*T*Cauo,b101aw03 of:N*T*Carmadeus,st0700_adaptC* of:N*T*Carmadeus,st0700_adapt of:N*T*Carm,rtsm_displayC* of:N*T*Carm,rtsm_display of:N*T*Campire,am800600p5tmqw_tb8hC* of:N*T*Campire,am800600p5tmqw_tb8h of:N*T*Campire,am800480r3tmqwa1hC* of:N*T*Campire,am800480r3tmqwa1h of:N*T*Campire,am_800480l1tmqw_t00hC* of:N*T*Campire,am_800480l1tmqw_t00h of:N*T*Campire,am_480272h3tmqw_t01hC* of:N*T*Campire,am_480272h3tmqw_t01h of:N*T*Campire,am_1280800n3tzqw_t00hC* of:N*T*Campire,am_1280800n3tzqw_t00h of:N*T*Cpanel_dsiC* of:N*T*Cpanel_dsi of:N*T*Cosddisplays,osd101t2045_53tsC* of:N*T*Cosddisplays,osd101t2045_53ts of:N*T*Clg,acx467akm_7C* of:N*T*Clg,acx467akm_7 of:N*T*Cpanasonic,vvx10f004b00C* of:N*T*Cpanasonic,vvx10f004b00 of:N*T*Clg,lh500wx1_sd03C* of:N*T*Clg,lh500wx1_sd03 of:N*T*Clg,ld070wx3_sl01C* of:N*T*Clg,ld070wx3_sl01 of:N*T*Cboe,tv080wum_nl0C* of:N*T*Cboe,tv080wum_nl0 of:N*T*Cauo,b080uan01C* of:N*T*Cauo,b080uan01
drm

kernel/drivers/gpu/drm/panel/panel-sitronix-st7701.ko.xz of:N*T*Ctechstar,ts8550bC* of:N*T*Ctechstar,ts8550b of:N*T*Celida,kd50t048aC* of:N*T*Celida,kd50t048a of:N*T*Cdensitron,dmt028vghmcmi_1aC* of:N*T*Cdensitron,dmt028vghmcmi_1a of:N*T*Canbernic,rg_arc_panelC* of:N*T*Canbernic,rg_arc_panel of:N*T*Cpimoroni,hyperpixel2roundC* of:N*T*Cpimoroni,hyperpixel2round of:N*T*Ctxw,txw210001b0C* of:N*T*Ctxw,txw210001b0 of:N*T*Canbernic,rg28xx_panelC* of:N*T*Canbernic,rg28xx_panel spi:hyperpixel2round spi:txw210001b0 spi:rg28xx_panel
drm drm_mipi_dbi

kernel/drivers/gpu/drm/panel/panel-raspberrypi-touchscreen.ko.xz of:N*T*Craspberrypi,7inch_touchscreen_panelC* of:N*T*Craspberrypi,7inch_touchscreen_panel
drm

kernel/drivers/gpu/drm/panel/panel-ilitek-ili9806e.ko.xz of:N*T*Cortustech,com35h3p70ulcC* of:N*T*Cortustech,com35h3p70ulc of:N*T*Cdensitron,dmt028vghmcmi_1dC* of:N*T*Cdensitron,dmt028vghmcmi_1d
drm drm_kms_helper

kernel/drivers/gpu/drm/panel/panel-ilitek-ili9806e-spi.ko.xz of:N*T*Cilitek,ili9806eC* of:N*T*Cilitek,ili9806e of:N*T*Cpimoroni,hyperpixel4C* of:N*T*Cpimoroni,hyperpixel4 of:N*T*Ctxw,txw397017s2C* of:N*T*Ctxw,txw397017s2 spi:hyperpixel4 spi:ili9806e spi:txw397017s2
drm

kernel/drivers/gpu/drm/panel/panel-lvds.ko.xz of:N*T*Cpanel_lvdsC* of:N*T*Cpanel_lvds
drm

kernel/drivers/gpu/drm/panel/panel-waveshare-dsi-v2.ko.xz of:N*T*Cwaveshare,3.4_dsi_touch_cC* of:N*T*Cwaveshare,3.4_dsi_touch_c of:N*T*Cwaveshare,4.0_dsi_touch_cC* of:N*T*Cwaveshare,4.0_dsi_touch_c of:N*T*Cwaveshare,5.0_dsi_touch_aC* of:N*T*Cwaveshare,5.0_dsi_touch_a of:N*T*Cwaveshare,5.5_dsi_touch_aC* of:N*T*Cwaveshare,5.5_dsi_touch_a of:N*T*Cwaveshare,7.0_dsi_touch_cC* of:N*T*Cwaveshare,7.0_dsi_touch_c of:N*T*Cwaveshare,7.0_dsi_touch_bC* of:N*T*Cwaveshare,7.0_dsi_touch_b of:N*T*Cwaveshare,7.0_dsi_touch_aC* of:N*T*Cwaveshare,7.0_dsi_touch_a of:N*T*Cwaveshare,8.0_dsi_touch_aC* of:N*T*Cwaveshare,8.0_dsi_touch_a of:N*T*Cwaveshare,8.0_dsi_touch_a_4laneC* of:N*T*Cwaveshare,8.0_dsi_touch_a_4lane of:N*T*Cwaveshare,8.8_dsi_touch_aC* of:N*T*Cwaveshare,8.8_dsi_touch_a of:N*T*Cwaveshare,9.0_dsi_touch_bC* of:N*T*Cwaveshare,9.0_dsi_touch_b of:N*T*Cwaveshare,9.0_dsi_touch_b,4laneC* of:N*T*Cwaveshare,9.0_dsi_touch_b,4lane of:N*T*Cwaveshare,10.1_dsi_touch_bC* of:N*T*Cwaveshare,10.1_dsi_touch_b of:N*T*Cwaveshare,10.1_dsi_touch_b,4laneC* of:N*T*Cwaveshare,10.1_dsi_touch_b,4lane of:N*T*Cwaveshare,10.1_dsi_touch_aC* of:N*T*Cwaveshare,10.1_dsi_touch_a of:N*T*Cwaveshare,10.1_dsi_touch_a_4laneC* of:N*T*Cwaveshare,10.1_dsi_touch_a_4lane of:N*T*Cwaveshare,12.3_dsi_touch_a,4laneC* of:N*T*Cwaveshare,12.3_dsi_touch_a,4lane
drm

kernel/drivers/gpu/drm/v3d/v3d.ko.xz platform:v3d_drm of:N*T*Cbrcm,7278_v3dC* of:N*T*Cbrcm,7278_v3d of:N*T*Cbrcm,7268_v3dC* of:N*T*Cbrcm,7268_v3d of:N*T*Cbrcm,2712_v3dC* of:N*T*Cbrcm,2712_v3d of:N*T*Cbrcm,2711_v3dC* of:N*T*Cbrcm,2711_v3d
drm gpu_sched drm_shmem_helper

kernel/drivers/gpu/drm/drm_dma_helper.ko.xz symbol:drm_gem_dma_create symbol:drm_gem_dma_free symbol:drm_gem_dma_dumb_create_internal symbol:drm_gem_dma_dumb_create symbol:drm_gem_dma_vm_ops symbol:drm_gem_dma_print_info symbol:drm_gem_dma_get_sg_table symbol:drm_gem_dma_prime_import_sg_table symbol:drm_gem_dma_vmap symbol:drm_gem_dma_mmap symbol:drm_gem_dma_prime_import_sg_table_vmap symbol:drm_fbdev_dma_driver_fbdev_probe symbol:drm_fbdev_dma_setup symbol:drm_fb_dma_get_gem_obj symbol:drm_fb_dma_get_gem_addr symbol:drm_fb_dma_sync_non_coherent symbol:drm_fb_dma_get_scanout_buffer
drm drm_kms_helper

kernel/drivers/gpu/drm/drm_vram_helper.ko.xz symbol:drm_gem_vram_create symbol:drm_gem_vram_put symbol:drm_gem_vram_offset symbol:drm_gem_vram_pin symbol:drm_gem_vram_unpin symbol:drm_gem_vram_vmap symbol:drm_gem_vram_vunmap symbol:drm_gem_vram_fill_create_dumb symbol:drm_gem_vram_driver_dumb_create symbol:drm_gem_vram_plane_helper_prepare_fb symbol:drm_gem_vram_plane_helper_cleanup_fb symbol:drm_gem_vram_simple_display_pipe_prepare_fb symbol:drm_gem_vram_simple_display_pipe_cleanup_fb symbol:drm_vram_mm_debugfs_init symbol:drmm_vram_helper_init symbol:drm_vram_helper_mode_valid
ttm drm drm_ttm_helper drm_kms_helper

kernel/drivers/gpu/drm/vc4/vc4.ko.xz platform:vc4_drm of:N*T*Cbrcm,cygnus_vc4C* of:N*T*Cbrcm,cygnus_vc4 of:N*T*Cbrcm,bcm2835_vc4C* of:N*T*Cbrcm,bcm2835_vc4 of:N*T*Cbrcm,bcm2712_vc6C* of:N*T*Cbrcm,bcm2712_vc6 of:N*T*Cbrcm,bcm2711_vc5C* of:N*T*Cbrcm,bcm2711_vc5
drm cec drm_kms_helper drm_dma_helper drm_display_helper snd_soc_core

kernel/drivers/gpu/drm/bridge/simple-bridge.ko.xz of:N*T*Cti,ths8134C* of:N*T*Cti,ths8134 of:N*T*Cti,ths8135C* of:N*T*Cti,ths8135 of:N*T*Cti,opa362C* of:N*T*Cti,opa362 of:N*T*Cadi,adv7123C* of:N*T*Cadi,adv7123 of:N*T*Cdumb_vga_dacC* of:N*T*Cdumb_vga_dac
drm drm_kms_helper

kernel/drivers/gpu/drm/bridge/tc358762.ko.xz of:N*T*Ctoshiba,tc358762C* of:N*T*Ctoshiba,tc358762
drm drm_kms_helper

kernel/drivers/gpu/drm/bridge/ti-sn65dsi83.ko.xz i2c:ti,sn65dsi84 i2c:ti,sn65dsi83 of:N*T*Cti,sn65dsi84C* of:N*T*Cti,sn65dsi84 of:N*T*Cti,sn65dsi83C* of:N*T*Cti,sn65dsi83
drm drm_kms_helper regmap_i2c

kernel/drivers/gpu/drm/bridge/display-connector.ko.xz of:N*T*Cdp_connectorC* of:N*T*Cdp_connector of:N*T*Cvga_connectorC* of:N*T*Cvga_connector of:N*T*Csvideo_connectorC* of:N*T*Csvideo_connector of:N*T*Chdmi_connectorC* of:N*T*Chdmi_connector of:N*T*Cdvi_connectorC* of:N*T*Cdvi_connector of:N*T*Ccomposite_video_connectorC* of:N*T*Ccomposite_video_connector
drm drm_kms_helper

kernel/drivers/mux/mux-core.ko.xz symbol:mux_chip_alloc symbol:mux_chip_register symbol:mux_chip_unregister symbol:mux_chip_free symbol:devm_mux_chip_alloc symbol:devm_mux_chip_register symbol:mux_control_states symbol:mux_control_select_delay symbol:mux_state_select_delay symbol:mux_control_try_select_delay symbol:mux_state_try_select_delay symbol:mux_control_deselect symbol:mux_state_deselect symbol:mux_control_get symbol:mux_control_put symbol:devm_mux_control_get symbol:devm_mux_state_get

kernel/drivers/mux/mux-gpio.ko.xz of:N*T*Cgpio_muxC* of:N*T*Cgpio_mux
mux_core

kernel/drivers/md/dm-raid.ko.xz dm_raid6 dm_raid5 dm_raid4 dm_raid10 dm_raid1 dm_raid0
dm_mod md_mod raid456

kernel/drivers/md/dm-zero.ko.xz
dm_mod

kernel/drivers/md/dm-multipath.ko.xz symbol:dm_register_path_selector symbol:dm_unregister_path_selector
dm_mod

kernel/drivers/md/persistent-data/dm-persistent-data.ko.xz symbol:dm_array_info_init symbol:dm_array_empty symbol:dm_array_resize symbol:dm_array_new symbol:dm_array_del symbol:dm_array_get_value symbol:dm_array_set_value symbol:dm_array_walk symbol:dm_array_cursor_begin symbol:dm_array_cursor_end symbol:dm_array_cursor_next symbol:dm_array_cursor_skip symbol:dm_array_cursor_get_value symbol:dm_disk_bitset_init symbol:dm_bitset_empty symbol:dm_bitset_new symbol:dm_bitset_resize symbol:dm_bitset_del symbol:dm_bitset_flush symbol:dm_bitset_set_bit symbol:dm_bitset_clear_bit symbol:dm_bitset_test_bit symbol:dm_bitset_cursor_begin symbol:dm_bitset_cursor_end symbol:dm_bitset_cursor_next symbol:dm_bitset_cursor_skip symbol:dm_bitset_cursor_get_value symbol:dm_block_location symbol:dm_block_data symbol:dm_block_manager_create symbol:dm_block_manager_destroy symbol:dm_block_manager_reset symbol:dm_bm_block_size symbol:dm_bm_read_lock symbol:dm_bm_write_lock symbol:dm_bm_write_lock_zero symbol:dm_bm_unlock symbol:dm_bm_flush symbol:dm_bm_is_read_only symbol:dm_bm_set_read_only symbol:dm_bm_set_read_write symbol:dm_bm_checksum symbol:dm_sm_disk_create symbol:dm_sm_disk_open symbol:dm_tm_create_non_blocking_clone symbol:dm_tm_destroy symbol:dm_tm_pre_commit symbol:dm_tm_commit symbol:dm_tm_shadow_block symbol:dm_tm_read_lock symbol:dm_tm_unlock symbol:dm_tm_inc symbol:dm_tm_inc_range symbol:dm_tm_dec symbol:dm_tm_dec_range symbol:dm_tm_with_runs symbol:dm_tm_issue_prefetches symbol:dm_tm_create_with_sm symbol:dm_tm_open_with_sm symbol:dm_btree_empty symbol:dm_btree_del symbol:dm_btree_lookup symbol:dm_btree_lookup_next symbol:dm_btree_insert symbol:dm_btree_insert_notify symbol:dm_btree_find_highest_key symbol:dm_btree_find_lowest_key symbol:dm_btree_walk symbol:dm_btree_cursor_begin symbol:dm_btree_cursor_end symbol:dm_btree_cursor_next symbol:dm_btree_cursor_skip symbol:dm_btree_cursor_get_value symbol:dm_btree_remove symbol:dm_btree_remove_leaves
dm_bufio

kernel/drivers/md/dm-cache.ko.xz symbol:dm_cache_policy_register symbol:dm_cache_policy_unregister symbol:dm_cache_policy_create symbol:dm_cache_policy_destroy symbol:dm_cache_policy_get_name symbol:dm_cache_policy_get_version symbol:dm_cache_policy_get_hint_size symbol:btracker_create symbol:btracker_destroy symbol:btracker_nr_writebacks_queued symbol:btracker_nr_demotions_queued symbol:btracker_queue symbol:btracker_issue symbol:btracker_complete symbol:btracker_promotion_already_present
dm_persistent_data dm_mod dm_bio_prison

kernel/drivers/md/dm-log-userspace.ko.xz
dm_mod dm_log cn

kernel/drivers/md/dm-thin-pool.ko.xz
dm_bio_prison dm_persistent_data dm_mod

kernel/drivers/md/raid456.ko.xz raid6 raid5 md_level_6 md_raid6 md_personality_8 md_level_4 md_level_5 md_raid4 md_raid5 md_personality_4 symbol:raid5_set_cache_size symbol:r5c_journal_mode_set
md_mod async_xor async_pq async_tx async_memcpy async_raid6_recov raid6_pq

kernel/drivers/md/dm-bufio.ko.xz symbol:dm_bufio_get symbol:dm_bufio_read symbol:dm_bufio_read_with_ioprio symbol:dm_bufio_new symbol:dm_bufio_prefetch symbol:dm_bufio_prefetch_with_ioprio symbol:dm_bufio_release symbol:dm_bufio_mark_partial_buffer_dirty symbol:dm_bufio_mark_buffer_dirty symbol:dm_bufio_write_dirty_buffers_async symbol:dm_bufio_write_dirty_buffers symbol:dm_bufio_issue_flush symbol:dm_bufio_issue_discard symbol:dm_bufio_forget symbol:dm_bufio_forget_buffers symbol:dm_bufio_set_minimum_buffers symbol:dm_bufio_get_block_size symbol:dm_bufio_get_device_size symbol:dm_bufio_get_dm_io_client symbol:dm_bufio_get_block_number symbol:dm_bufio_get_block_data symbol:dm_bufio_get_aux_data symbol:dm_bufio_get_client symbol:dm_bufio_client_create symbol:dm_bufio_client_destroy symbol:dm_bufio_client_reset symbol:dm_bufio_set_sector_offset
dm_mod

kernel/drivers/md/bcache/bcache.ko.xz symbol:__tracepoint_bcache_request_start symbol:__traceiter_bcache_request_start symbol:__SCK__tp_func_bcache_request_start symbol:__tracepoint_bcache_request_end symbol:__traceiter_bcache_request_end symbol:__SCK__tp_func_bcache_request_end symbol:__tracepoint_bcache_bypass_sequential symbol:__traceiter_bcache_bypass_sequential symbol:__SCK__tp_func_bcache_bypass_sequential symbol:__tracepoint_bcache_bypass_congested symbol:__traceiter_bcache_bypass_congested symbol:__SCK__tp_func_bcache_bypass_congested symbol:__tracepoint_bcache_read symbol:__traceiter_bcache_read symbol:__SCK__tp_func_bcache_read symbol:__tracepoint_bcache_write symbol:__traceiter_bcache_write symbol:__SCK__tp_func_bcache_write symbol:__tracepoint_bcache_read_retry symbol:__traceiter_bcache_read_retry symbol:__SCK__tp_func_bcache_read_retry symbol:__tracepoint_bcache_cache_insert symbol:__traceiter_bcache_cache_insert symbol:__SCK__tp_func_bcache_cache_insert symbol:__tracepoint_bcache_journal_replay_key symbol:__traceiter_bcache_journal_replay_key symbol:__SCK__tp_func_bcache_journal_replay_key symbol:__tracepoint_bcache_journal_write symbol:__traceiter_bcache_journal_write symbol:__SCK__tp_func_bcache_journal_write symbol:__tracepoint_bcache_journal_full symbol:__traceiter_bcache_journal_full symbol:__SCK__tp_func_bcache_journal_full symbol:__tracepoint_bcache_journal_entry_full symbol:__traceiter_bcache_journal_entry_full symbol:__SCK__tp_func_bcache_journal_entry_full symbol:__tracepoint_bcache_btree_cache_cannibalize symbol:__traceiter_bcache_btree_cache_cannibalize symbol:__SCK__tp_func_bcache_btree_cache_cannibalize symbol:__tracepoint_bcache_btree_read symbol:__traceiter_bcache_btree_read symbol:__SCK__tp_func_bcache_btree_read symbol:__tracepoint_bcache_btree_write symbol:__traceiter_bcache_btree_write symbol:__SCK__tp_func_bcache_btree_write symbol:__tracepoint_bcache_btree_node_alloc symbol:__traceiter_bcache_btree_node_alloc symbol:__SCK__tp_func_bcache_btree_node_alloc symbol:__tracepoint_bcache_btree_node_alloc_fail symbol:__traceiter_bcache_btree_node_alloc_fail symbol:__SCK__tp_func_bcache_btree_node_alloc_fail symbol:__tracepoint_bcache_btree_node_free symbol:__traceiter_bcache_btree_node_free symbol:__SCK__tp_func_bcache_btree_node_free symbol:__tracepoint_bcache_btree_gc_coalesce symbol:__traceiter_bcache_btree_gc_coalesce symbol:__SCK__tp_func_bcache_btree_gc_coalesce symbol:__tracepoint_bcache_gc_start symbol:__traceiter_bcache_gc_start symbol:__SCK__tp_func_bcache_gc_start symbol:__tracepoint_bcache_gc_end symbol:__traceiter_bcache_gc_end symbol:__SCK__tp_func_bcache_gc_end symbol:__tracepoint_bcache_gc_copy symbol:__traceiter_bcache_gc_copy symbol:__SCK__tp_func_bcache_gc_copy symbol:__tracepoint_bcache_gc_copy_collision symbol:__traceiter_bcache_gc_copy_collision symbol:__SCK__tp_func_bcache_gc_copy_collision symbol:__tracepoint_bcache_btree_insert_key symbol:__traceiter_bcache_btree_insert_key symbol:__SCK__tp_func_bcache_btree_insert_key symbol:__tracepoint_bcache_btree_node_split symbol:__traceiter_bcache_btree_node_split symbol:__SCK__tp_func_bcache_btree_node_split symbol:__tracepoint_bcache_btree_node_compact symbol:__traceiter_bcache_btree_node_compact symbol:__SCK__tp_func_bcache_btree_node_compact symbol:__tracepoint_bcache_btree_set_root symbol:__traceiter_bcache_btree_set_root symbol:__SCK__tp_func_bcache_btree_set_root symbol:__tracepoint_bcache_invalidate symbol:__traceiter_bcache_invalidate symbol:__SCK__tp_func_bcache_invalidate symbol:__tracepoint_bcache_alloc_fail symbol:__traceiter_bcache_alloc_fail symbol:__SCK__tp_func_bcache_alloc_fail symbol:__tracepoint_bcache_writeback symbol:__traceiter_bcache_writeback symbol:__SCK__tp_func_bcache_writeback symbol:__tracepoint_bcache_writeback_collision symbol:__traceiter_bcache_writeback_collision symbol:__SCK__tp_func_bcache_writeback_collision

kernel/drivers/md/dm-round-robin.ko.xz
dm_multipath

kernel/drivers/md/dm-log.ko.xz symbol:dm_dirty_log_type_register symbol:dm_dirty_log_type_unregister symbol:dm_dirty_log_create symbol:dm_dirty_log_destroy
dm_mod

kernel/drivers/md/dm-writecache.ko.xz
dm_mod

kernel/drivers/md/raid10.ko.xz md_level_10 md_raid10 md_personality_9
md_mod

kernel/drivers/md/md-mod.ko.xz block_major_9_* md symbol:md_cluster_ops symbol:md_new_event symbol:md_handle_request symbol:mddev_suspend symbol:mddev_resume symbol:md_flush_request symbol:mddev_init symbol:mddev_destroy symbol:mddev_unlock symbol:md_find_rdev_nr_rcu symbol:md_find_rdev_rcu symbol:md_rdev_clear symbol:sync_page_io symbol:md_check_no_bitmap symbol:md_integrity_register symbol:md_update_sb symbol:md_rdev_init symbol:md_idle_sync_thread symbol:md_frozen_sync_thread symbol:md_unfrozen_sync_thread symbol:mddev_stack_rdev_limits symbol:mddev_stack_new_rdev symbol:mddev_update_io_opt symbol:md_init_stacking_limits symbol:md_run symbol:md_start symbol:md_stop_writes symbol:md_stop symbol:md_set_array_sectors symbol:__md_wakeup_thread symbol:md_register_thread symbol:md_unregister_thread symbol:md_error symbol:register_md_personality symbol:unregister_md_personality symbol:register_md_cluster_operations symbol:unregister_md_cluster_operations symbol:md_done_sync symbol:md_write_start symbol:md_write_inc symbol:md_write_end symbol:md_submit_discard_bio symbol:md_account_bio symbol:md_free_cloned_bio symbol:md_allow_write symbol:md_do_sync symbol:md_check_recovery symbol:md_reap_sync_thread symbol:md_wait_for_blocked_rdev symbol:md_finish_reshape symbol:rdev_set_badblocks symbol:rdev_clear_badblocks symbol:md_reload_sb

kernel/drivers/md/dm-cache-smq.ko.xz dm_cache_cleaner dm_cache_mq dm_cache_default
dm_cache

kernel/drivers/md/dm-integrity.ko.xz
dm_bufio dm_mod async_xor

kernel/drivers/md/dm-mirror.ko.xz
dm_region_hash dm_log dm_mod

kernel/drivers/md/dm-delay.ko.xz
dm_mod

kernel/drivers/md/dm-snapshot.ko.xz dm_snapshot_merge dm_snapshot_origin symbol:dm_snap_origin symbol:dm_snap_cow symbol:dm_exception_store_type_register symbol:dm_exception_store_type_unregister symbol:dm_exception_store_create symbol:dm_exception_store_destroy
dm_mod dm_bufio

kernel/drivers/md/dm-verity.ko.xz
dm_mod dm_bufio

kernel/drivers/md/dm-region-hash.ko.xz symbol:dm_rh_region_to_sector symbol:dm_rh_bio_to_region symbol:dm_rh_region_context symbol:dm_rh_get_region_key symbol:dm_rh_get_region_size symbol:dm_region_hash_create symbol:dm_region_hash_destroy symbol:dm_rh_dirty_log symbol:dm_rh_get_state symbol:dm_rh_mark_nosync symbol:dm_rh_update_states symbol:dm_rh_inc_pending symbol:dm_rh_dec symbol:dm_rh_recovery_prepare symbol:dm_rh_recovery_start symbol:dm_rh_recovery_end symbol:dm_rh_recovery_in_flight symbol:dm_rh_flush symbol:dm_rh_delay symbol:dm_rh_stop_recovery symbol:dm_rh_start_recovery
dm_log

kernel/drivers/md/dm-crypt.ko.xz
dm_mod

kernel/drivers/md/raid0.ko.xz md_level_0 md_raid0 md_personality_2
md_mod

kernel/drivers/md/dm-mod.ko.xz devname:mapper/control char_major_10_236 symbol:dm_audit_log_ti symbol:dm_audit_log_bio symbol:dm_per_bio_data symbol:dm_bio_from_per_bio_data symbol:dm_bio_get_target_bio_nr symbol:dm_get_reserved_bio_based_ios symbol:dm_start_time_ns_from_clone symbol:dm_set_target_max_io_len symbol:dm_accept_partial_bio symbol:dm_submit_bio_remap symbol:dm_get_md symbol:dm_hold symbol:dm_device_name symbol:dm_put symbol:dm_internal_suspend_noflush symbol:dm_internal_resume symbol:dm_internal_suspend_fast symbol:dm_internal_resume_fast symbol:dm_disk symbol:dm_suspended symbol:dm_post_suspending symbol:dm_noflush_suspending symbol:dm_devt_from_path symbol:dm_get_device symbol:dm_put_device symbol:dm_read_arg symbol:dm_read_arg_group symbol:dm_shift_arg symbol:dm_consume_args symbol:dm_table_set_type symbol:dm_table_event symbol:dm_table_get_size symbol:dm_table_get_mode symbol:dm_table_get_md symbol:dm_table_device_name symbol:dm_table_run_md_queue_async symbol:dm_register_target symbol:dm_unregister_target symbol:dm_copy_name_and_uuid symbol:dm_io_client_create symbol:dm_io_client_destroy symbol:dm_io symbol:dm_kcopyd_copy symbol:dm_kcopyd_zero symbol:dm_kcopyd_prepare_callback symbol:dm_kcopyd_do_callback symbol:dm_kcopyd_client_create symbol:dm_kcopyd_client_destroy symbol:dm_kcopyd_client_flush symbol:dm_mq_kick_requeue_list

kernel/drivers/md/raid1.ko.xz md_level_1 md_raid1 md_personality_3
md_mod

kernel/drivers/md/dm-bio-prison.ko.xz symbol:dm_bio_prison_create symbol:dm_bio_prison_destroy symbol:dm_bio_prison_alloc_cell symbol:dm_bio_prison_free_cell symbol:dm_cell_key_has_valid_range symbol:dm_bio_detain symbol:dm_get_cell symbol:dm_cell_release symbol:dm_cell_release_no_holder symbol:dm_cell_error symbol:dm_cell_visit_release symbol:dm_cell_promote_or_release symbol:dm_deferred_set_create symbol:dm_deferred_set_destroy symbol:dm_deferred_entry_inc symbol:dm_deferred_entry_dec symbol:dm_deferred_set_add_work symbol:dm_bio_prison_create_v2 symbol:dm_bio_prison_destroy_v2 symbol:dm_bio_prison_alloc_cell_v2 symbol:dm_bio_prison_free_cell_v2 symbol:dm_cell_get_v2 symbol:dm_cell_put_v2 symbol:dm_cell_lock_v2 symbol:dm_cell_quiesce_v2 symbol:dm_cell_lock_promote_v2 symbol:dm_cell_unlock_v2

kernel/drivers/spi/spi-bcm2835aux.ko.xz of:N*T*Cbrcm,bcm2835_aux_spiC* of:N*T*Cbrcm,bcm2835_aux_spi

kernel/drivers/spi/spi-bitbang.ko.xz symbol:spi_bitbang_setup_transfer symbol:spi_bitbang_setup symbol:spi_bitbang_cleanup symbol:spi_bitbang_init symbol:spi_bitbang_start symbol:spi_bitbang_stop

kernel/drivers/spi/spi-gpio.ko.xz platform:spi_gpio of:N*T*Cspi_gpioC* of:N*T*Cspi_gpio
spi_bitbang

kernel/drivers/spi/spi-dw.ko.xz symbol:dw_spi_set_cs symbol:dw_spi_check_status symbol:dw_spi_update_config symbol:dw_spi_add_host symbol:dw_spi_remove_host symbol:dw_spi_suspend_host symbol:dw_spi_resume_host symbol:dw_spi_dma_setup_mfld symbol:dw_spi_dma_setup_generic

kernel/drivers/spi/spi-dw-mmio.ko.xz of:N*T*Camd,pensando_elba_spiC* of:N*T*Camd,pensando_elba_spi of:N*T*Ccanaan,k210_spiC* of:N*T*Ccanaan,k210_spi of:N*T*Cmicrochip,sparx5_spiC* of:N*T*Cmicrochip,sparx5_spi of:N*T*Cintel,mountevans_imc_ssiC* of:N*T*Cintel,mountevans_imc_ssi of:N*T*Cintel,keembay_ssiC* of:N*T*Cintel,keembay_ssi of:N*T*Csnps,dwc_ssi_1.01aC* of:N*T*Csnps,dwc_ssi_1.01a of:N*T*Crenesas,rzn1_spiC* of:N*T*Crenesas,rzn1_spi of:N*T*Camazon,alpine_dw_apb_ssiC* of:N*T*Camazon,alpine_dw_apb_ssi of:N*T*Cmscc,jaguar2_spiC* of:N*T*Cmscc,jaguar2_spi of:N*T*Cmscc,ocelot_spiC* of:N*T*Cmscc,ocelot_spi of:N*T*Csnps,dw_apb_ssiC* of:N*T*Csnps,dw_apb_ssi
spi_dw

kernel/drivers/spi/spi-rp2040-gpio-bridge.ko.xz i2c:rp2040_gpio_bridge of:N*T*Craspberrypi,rp2040_gpio_bridgeC* of:N*T*Craspberrypi,rp2040_gpio_bridge

kernel/drivers/spi/spi-bcm2835.ko.xz of:N*T*Cbrcm,bcm2835_spiC* of:N*T*Cbrcm,bcm2835_spi

kernel/drivers/spi/spidev.ko.xz spi:spidev spi:si3210 spi:em3581 spi:spi_authenta spi:spi_petra spi:m53cpld spi:dhcom_board spi:bk4 spi:sx1301 spi:ltc2488 spi:jg10309_01 spi:dh2228fv spi:bh2228fv of:N*T*Csilabs,si3210C* of:N*T*Csilabs,si3210 of:N*T*Csilabs,em3581C* of:N*T*Csilabs,em3581 of:N*T*Csemtech,sx1301C* of:N*T*Csemtech,sx1301 of:N*T*Crohm,dh2228fvC* of:N*T*Crohm,dh2228fv of:N*T*Crohm,bh2228fvC* of:N*T*Crohm,bh2228fv of:N*T*Cmicron,spi_authentaC* of:N*T*Cmicron,spi_authenta of:N*T*Cmenlo,m53cpldC* of:N*T*Cmenlo,m53cpld of:N*T*Clwn,bk4C* of:N*T*Clwn,bk4 of:N*T*Clineartechnology,ltc2488C* of:N*T*Clineartechnology,ltc2488 of:N*T*Celgin,jg10309_01C* of:N*T*Celgin,jg10309_01 of:N*T*Cdh,dhcom_boardC* of:N*T*Cdh,dhcom_board of:N*T*Ccisco,spi_petraC* of:N*T*Ccisco,spi_petra acpi*:SPT0003:* acpi*:SPT0002:* acpi*:SPT0001:*

kernel/drivers/auxdisplay/hd44780_common.ko.xz symbol:hd44780_common_print symbol:hd44780_common_gotoxy symbol:hd44780_common_home symbol:hd44780_common_clear_display symbol:hd44780_common_init_display symbol:hd44780_common_shift_cursor symbol:hd44780_common_shift_display symbol:hd44780_common_display symbol:hd44780_common_cursor symbol:hd44780_common_blink symbol:hd44780_common_fontsize symbol:hd44780_common_lines symbol:hd44780_common_redefine_char symbol:hd44780_common_alloc
charlcd

kernel/drivers/auxdisplay/hd44780.ko.xz of:N*T*Chit,hd44780C* of:N*T*Chit,hd44780
charlcd hd44780_common

kernel/drivers/auxdisplay/charlcd.ko.xz symbol:charlcd_backlight symbol:charlcd_poke symbol:charlcd_alloc symbol:charlcd_free symbol:charlcd_register symbol:charlcd_unregister

kernel/drivers/usb/serial/ir-usb.ko.xz usb:v*p*d*dc*dsc*dp*icFEisc02ip00in* usb:v09C4p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v08E9p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v050Fp0180d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/option.ko.xz usb:v2949p8700d*dc*dsc*dp*icFFisc*ip*in* usb:v1BBBp0640d*dc*dsc*dp*icFFisc*ip*in* usb:v1BBBp0530d*dc*dsc*dp*icFFisc*ip*in* usb:v1782p4E00d*dc*dsc*dp*icFFisc00ip00in* usb:v1782p4064d*dc*dsc*dp*icFFisc00ip00in* usb:v1782p4055d*dc*dsc*dp*icFFisc00ip00in* usb:v1199p90E3d*dc*dsc*dp*icFFiscFFip40in* usb:v1199p90E3d*dc*dsc*dp*icFFiscFFip30in* usb:v1199p90D3d*dc*dsc*dp*icFFisc00ip00in* usb:v1199p90D3d*dc*dsc*dp*icFFiscFFip40in* usb:v1199p90D3d*dc*dsc*dp*icFFiscFFip30in* usb:v22D9p276Cd*dc*dsc*dp*icFFiscFFip30in* usb:v3731p010Dd*dc*dsc*dp*icFFiscFFip40in* usb:v3731p010Dd*dc*dsc*dp*icFFisc00ip40in* usb:v3731p010Dd*dc*dsc*dp*icFFiscFFip30in* usb:v3731p010Cd*dc*dsc*dp*icFFiscFFip40in* usb:v3731p010Cd*dc*dsc*dp*icFFisc00ip40in* usb:v3731p010Cd*dc*dsc*dp*icFFiscFFip30in* usb:v3731p010Bd*dc*dsc*dp*icFFiscFFip40in* usb:v3731p010Bd*dc*dsc*dp*icFFisc00ip40in* usb:v3731p010Bd*dc*dsc*dp*icFFiscFFip30in* usb:v3731p010Ad*dc*dsc*dp*icFFiscFFip40in* usb:v3731p010Ad*dc*dsc*dp*icFFisc00ip40in* usb:v3731p010Ad*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0116d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0116d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0116d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0115d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0115d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0115d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0113d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0113d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0113d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0112d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0112d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0112d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0111d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0111d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0111d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0106d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0106d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0106d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0101d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0101d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0101d*dc*dsc*dp*icFFiscFFip30in* usb:v3731p0100d*dc*dsc*dp*icFFiscFFip40in* usb:v3731p0100d*dc*dsc*dp*icFFisc00ip40in* usb:v3731p0100d*dc*dsc*dp*icFFiscFFip30in* usb:v33F8p0802d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p0302d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p0301d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p01A9d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p01A8d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p01A4d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p01A3d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p01A2d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p0115d*dc*dsc*dp*icFFisc*ip*in* usb:v33F8p0104d*dc*dsc*dp*ic*isc*ip*in* usb:v305Ap1406d*dc*dsc*dp*icFFisc*ip*in* usb:v305Ap1405d*dc*dsc*dp*icFFisc*ip*in* usb:v305Ap1404d*dc*dsc*dp*icFFisc*ip*in* usb:v2DF3p9D03d*dc*dsc*dp*icFFisc*ip*in* usb:v2DEEp4D22d*dc*dsc*dp*icFFiscFFip60in* usb:v2DEEp4D22d*dc*dsc*dp*icFFiscFFip40in* usb:v2DEEp4D22d*dc*dsc*dp*icFFiscFFip30in* usb:v2DEEp4D22d*dc*dsc*dp*icFFisc10ip03in* usb:v2DEEp4D22d*dc*dsc*dp*icFFisc10ip02in* usb:v2DEEp4D22d*dc*dsc*dp*icFFisc00ip00in* usb:v2DEEp4D57d*dc*dsc*dp*icFFisc00ip00in* usb:v2DEEp4D41d*dc*dsc*dp*icFFisc00ip00in* usb:v2CB7p0A07d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0A06d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0A05d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0A04d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p01A4d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p01A3d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p01A2d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p01A0d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0115d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0112d*dc*dsc*dp*icFFisc00ip00in* usb:v2CB7p0112d*dc*dsc*dp*icFFiscFFip40in* usb:v2CB7p0112d*dc*dsc*dp*icFFiscFFip30in* usb:v2CB7p0111d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p010Bd*dc*dsc*dp*icFFisc00ip00in* usb:v2CB7p010Bd*dc*dsc*dp*icFFiscFFip30in* usb:v2CB7p010Ad*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0106d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0105d*dc*dsc*dp*icFFisc*ip*in* usb:v2CB7p0104d*dc*dsc*dp*ic*isc*ip*in* usb:v2CB7p0001d*dc*dsc*dp*icFFiscFFipFFin* usb:v1782p4D11d*dc*dsc*dp*icFFisc*ip*in* usb:v1782p4D10d*dc*dsc*dp*ic*isc*ip*in* usb:v1508p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE167d*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE15Fd*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE145d*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE123d*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE0F0d*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE0EEd*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE0DBd*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE0DAd*dc*dsc*dp*icFFisc*ip*in* usb:v0489pE0B5d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE0B4d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0pA31Dd*dc*dsc*dp*icFFisc06ip1Bin* usb:v03F0pA31Dd*dc*dsc*dp*icFFisc06ip14in* usb:v03F0pA31Dd*dc*dsc*dp*icFFisc06ip13in* usb:v03F0pA31Dd*dc*dsc*dp*icFFisc06ip12in* usb:v03F0pA31Dd*dc*dsc*dp*icFFisc06ip10in* usb:v03F0p421Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v22DEp6803d*dc*dsc*dp*icFFiscFFipFFin* usb:v22DEp6802d*dc*dsc*dp*icFFiscFFipFFin* usb:v22DEp6801d*dc*dsc*dp*icFFiscFFipFFin* usb:v15EBp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v20A6p1105d*dc*dsc*dp*ic*isc*ip*in* usb:v2020p4000d*dc*dsc*dp*icFFisc*ip*in* usb:v2020p2060d*dc*dsc*dp*icFFisc*ip*in* usb:v2020p2033d*dc*dsc*dp*icFFisc*ip*in* usb:v2020p2031d*dc*dsc*dp*icFFisc*ip*in* usb:v1690p7588d*dc*dsc*dp*icFFisc*ip*in* usb:v1435pD191d*dc*dsc*dp*icFFisc*ip*in* usb:v07D1p7E11d*dc*dsc*dp*icFFiscFFipFFin* usb:v07D1p3E02d*dc*dsc*dp*icFFiscFFipFFin* usb:v07D1p3E01d*dc*dsc*dp*icFFiscFFipFFin* usb:v2001p7E3Dd*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7E35d*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7E19d*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7D0Ed*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7D04d*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7D03d*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7D02d*dc*dsc*dp*icFFisc*ip*in* usb:v2001p7D01d*dc*dsc*dp*icFFisc*ip*in* usb:v2077p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v2357p000Dd*dc*dsc*dp*icFFisc00ip00in* usb:v1FF4p600Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1FF4p600Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2692p9025d*dc*dsc*dp*ic*isc*ip*in* usb:v2692p9005d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp7129d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp7127d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp7126d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp00A7d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp00A7d*dc*dsc*dp*icFFisc02ip01in* usb:v0E8Dp7106d*dc*dsc*dp*ic02isc02ip01in* usb:v0E8Dp7103d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp0033d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0E8Dp0043d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0E8Dp0023d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0E8Dp0003d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0E8Dp7102d*dc*dsc*dp*ic02isc02ip01in* usb:v0E8Dp7101d*dc*dsc*dp*ic02isc00ip00in* usb:v0E8Dp00A5d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp00A5d*dc*dsc*dp*icFFisc02ip01in* usb:v0E8Dp00A4d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp00A4d*dc*dsc*dp*icFFisc02ip01in* usb:v0E8Dp00A0d*dc*dsc*dp*ic0Aisc00ip00in* usb:v0E8Dp00A2d*dc*dsc*dp*icFFisc02ip01in* usb:v0E8Dp00A2d*dc*dsc*dp*icFFisc00ip00in* usb:v0E8Dp00A1d*dc*dsc*dp*icFFisc02ip01in* usb:v0E8Dp00A1d*dc*dsc*dp*icFFisc00ip00in* usb:v1004p618Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0685p7000d*dc*dsc*dp*icFFiscFFipFFin* usb:v2262p0002d*dc*dsc*dp*icFFiscFFipFFin* usb:v257Ap262Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap261Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Ed*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap162Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap161Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap360Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap360Dd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap360Cd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap360Bd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap360Ad*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3609d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3608d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3607d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3606d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3605d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3604d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3603d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3602d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap3601d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Dd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Cd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Bd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap260Ad*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2609d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2608d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2607d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2606d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2605d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2604d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2603d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2602d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap2601d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap160Fd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap160Dd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap160Cd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap160Bd*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap160Ad*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1609d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1608d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1607d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1606d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1605d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1604d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1603d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1602d*dc*dsc*dp*ic*isc*ip*in* usb:v257Ap1601d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6889d*dc*dsc*dp*ic0Aisc00ip00in* usb:v211Fp6801d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC00Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC00Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC005d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC004d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC003d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC002d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC001d*dc*dsc*dp*ic*isc*ip*in* usb:v0B3CpC000d*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp00F4d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00F2d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00F3d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00F1d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00B9d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00B8d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00B7d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00B3d*dc*dsc*dp*icFFisc*ip*in* usb:v0681p004Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0681p004Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0681p0040d*dc*dsc*dp*ic*isc*ip*in* usb:v0681p0047d*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp004Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp004Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp006Cd*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp00B0d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0085d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0084d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0083d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0082d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0060d*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp0055d*dc*dsc*dp*icFFisc*ip*in* usb:v1E2Dp0053d*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp0052d*dc*dsc*dp*ic*isc*ip*in* usb:v1E2Dp0051d*dc*dsc*dp*ic*isc*ip*in* usb:v1266p1012d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1011d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Fd*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Ed*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Dd*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Cd*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1266p100Ad*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1009d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1008d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1007d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1006d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1005d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1004d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1003d*dc*dsc*dp*icFFisc*ip*in* usb:v1266p1002d*dc*dsc*dp*icFFisc*ip*in* usb:v201Ep10F8d*dc*dsc*dp*icFFiscFFipFFin* usb:v201Ep2009d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9605d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9607d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9B3Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9B05d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9803d*dc*dsc*dp*icFFisc*ip*in* usb:v1C9Ep9801d*dc*dsc*dp*icFFisc*ip*in* usb:v1C9Ep9800d*dc*dsc*dp*icFFisc*ip*in* usb:v1C9Ep9B02d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9B01d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep9603d*dc*dsc*dp*ic*isc*ip*in* usb:v1C9Ep7605d*dc*dsc*dp*ic*isc*ip*in* usb:v20B9p1682d*dc*dsc*dp*ic*isc*ip*in* usb:v1011p3198d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp0203d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp011Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp00B7d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp00B6d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp0052d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp0017d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp0000d*dc*dsc*dp*ic*isc*ip*in* usb:v1E0Ep9206d*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep9205d*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep907Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep9078d*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep9071d*dc*dsc*dp*ic*isc*ip*in* usb:v1E0Ep9011d*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep9003d*dc*dsc*dp*icFFisc*ip*in* usb:v1E0Ep9001d*dc*dsc*dp*ic*isc*ip*in* usb:v1E0Ep9200d*dc*dsc*dp*icFFiscFFipFFin* usb:v1E0Ep9100d*dc*dsc*dp*ic*isc*ip*in* usb:v1E0Ep9000d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p1302d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0D45d*dc*dsc*dp*ic*isc*ip*in* usb:v1DA5p4519d*dc*dsc*dp*ic*isc*ip*in* usb:v1DA5p4518d*dc*dsc*dp*ic*isc*ip*in* usb:v1DA5p4515d*dc*dsc*dp*ic*isc*ip*in* usb:v1DA5p4523d*dc*dsc*dp*ic*isc*ip*in* usb:v1DA5p4512d*dc*dsc*dp*ic*isc*ip*in* usb:v1E0EpCE1Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1E0EpCE16d*dc*dsc*dp*ic*isc*ip*in* usb:v1186p3E04d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p4068d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p*d*dc*dsc*dp*icFFisc86ip10in* usb:v19D2p*d*dc*dsc*dp*icFFisc02ip05in* usb:v19D2p*d*dc*dsc*dp*icFFisc02ip01in* usb:v19D2p0396d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p1432d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p0426d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p1433d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2pFFEDd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFEBd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFE8d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFFFd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFF1d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFFEd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFFDd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFFCd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFFBd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFF9d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFF8d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFF7d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFF6d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFEEd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFECd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFE9d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD5d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD4d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD3d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD2d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD1d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFD0d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCFd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCEd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCDd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCCd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCBd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFCAd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC9d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC8d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC7d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC6d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC5d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC4d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC3d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC2d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC1d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFC0d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBFd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBEd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBDd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBCd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBBd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFBAd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB9d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB8d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB7d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB6d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB5d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB4d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB3d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB2d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB1d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFB0d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFAFd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFAEd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFACd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFABd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFAAd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA9d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA8d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA7d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA6d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA5d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA4d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA3d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA2d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA1d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFFA0d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF9Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF94d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF93d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF92d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF91d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF90d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF8Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF89d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF88d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF87d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF86d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF85d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF84d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF83d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF82d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF81d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF80d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF7Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF79d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF78d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF77d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF76d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF75d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF74d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF73d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF72d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF71d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF70d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF6Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF69d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF68d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF67d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF66d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF65d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF64d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF63d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF62d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF61d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF60d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF5Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF59d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF58d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF57d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF56d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF55d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF54d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF53d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF52d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF51d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF50d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF4Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF49d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF48d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF47d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF46d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF45d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF44d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF43d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2pFF42d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0178d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0176d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0170d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0168d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0152d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0147d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0141d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0133d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0130d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0073d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0070d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0060d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0059d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0027d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0014d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p2003d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p2002d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1600d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1598d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1596d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1594d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1592d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1591d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1590d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1589d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1567d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1566d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1565d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1547d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1546d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1545d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1535d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1534d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1533d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1485d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1481d*dc*dsc*dp*icFFisc00ip00in* usb:v19D2p1476d*dc*dsc*dp*icFFisc*ip*in* usb:v19D2p1428d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1426d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1425d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1424d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1402d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1401d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1333d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1303d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1302d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1301d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1300d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1299d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1298d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1297d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1296d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1295d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1294d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1293d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1292d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1291d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1290d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1289d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1288d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1287d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1286d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1285d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1284d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1283d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1282d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1281d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1280d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1279d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1278d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1277d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1276d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1275d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2p1274d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1273d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1272d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1271d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1270d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1269d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1268d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1267d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1266d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1265d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1264d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1263d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1262d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1261d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1260d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1259d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1258d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1257d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1256d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1255d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1254d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1253d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1252d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1251d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1250d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1249d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1248d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1247d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1246d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1245d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1244d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1170d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1169d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1168d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1167d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1166d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1165d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1164d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1163d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1162d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1161d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1160d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1159d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1158d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1157d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1156d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1155d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1154d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1153d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1152d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1151d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1150d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1149d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1148d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1147d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1146d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1145d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1144d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1143d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1142d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1141d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1140d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1139d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1138d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1137d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1136d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1135d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1134d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1133d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1132d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1131d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1130d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1129d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1128d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1127d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1126d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1125d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1124d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1123d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1122d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1121d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1120d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1119d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1118d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1117d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1116d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1115d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1114d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1113d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1112d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1111d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1110d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1109d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1108d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1107d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1106d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1105d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1104d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1103d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1102d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1101d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1100d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1099d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1098d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1097d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1096d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1095d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1094d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1093d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1092d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1091d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1090d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1089d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1088d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1087d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1086d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1085d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1084d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1083d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1082d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1081d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1080d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1079d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1078d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1077d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1076d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1075d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1074d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1073d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1072d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1071d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1070d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1069d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1068d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1067d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1066d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1065d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1064d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1063d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1062d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1061d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1060d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1059d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1058d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1057d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1021d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1018d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1012d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1010d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p1008d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0602d*dc*dsc*dp*icFFisc*ip*in* usb:v19D2p0601d*dc*dsc*dp*icFFisc*ip*in* usb:v19D2p0417d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0414d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0412d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0395d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0330d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0326d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0317d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0284d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0265d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0257d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0254d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0201d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0200d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0199d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0197d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0196d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0191d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0189d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0167d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0165d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0164d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0162d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0161d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0159d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0158d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0157d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0156d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0155d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0153d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0151d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0148d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0145d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0144d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0143d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0142d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0139d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0137d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0136d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0135d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0128d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0126d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0125d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0124d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0123d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0122d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0121d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0118d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0117d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0113d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0108d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0106d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0105d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0104d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0097d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0096d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0095d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0094d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0093d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0092d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0091d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0090d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0089d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0088d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0087d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0086d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0083d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0082d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0079d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0078d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0077d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0076d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0069d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0067d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0066d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0065d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0064d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0063d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0062d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0061d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0058d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0057d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0056d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0055d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0054d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0052d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0051d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0050d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0049d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0048d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0044d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0043d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0042d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0040d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0039d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0038d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0037d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0034d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0033d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0032d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0031d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0030d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0029d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0028d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0025d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0024d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0023d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0022d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0021d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0020d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0019d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0018d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0017d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0016d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0015d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0013d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0012d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0011d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0010d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Fd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Dd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p000Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0009d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0008d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0006d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0005d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0004d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0003d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0002d*dc*dsc*dp*icFFiscFFipFFin* usb:v19D2p0001d*dc*dsc*dp*icFFiscFFipFFin* usb:v1BC7p9201d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p9200d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p9010d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p9000d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p701Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p701Ad*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p7011d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p7010d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p3001d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p3000d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1901d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1900d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1261d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1260d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1252d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1250d*dc*dsc*dp*icFFisc00ip00in* usb:v1BC7p1231d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1230d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1214d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1213d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1212d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1211d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1208d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1207d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1200d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1206d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1204d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1203d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1201d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p110Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p110Ad*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1102d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1101d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1100d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p10D3d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10D3d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10D3d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10D2d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10D2d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10D2d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10D1d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10D1d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10D1d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10D0d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10D0d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10D0d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10CBd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C9d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C8d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C7d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10C7d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10C6d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C5d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C4d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C3d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C2d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C1d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10C0d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10B3d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10B3d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10B3d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10B2d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10B2d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10B2d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10B1d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10B1d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10B1d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10B0d*dc*dsc*dp*icFFiscFFip60in* usb:v1BC7p10B0d*dc*dsc*dp*icFFiscFFip40in* usb:v1BC7p10B0d*dc*dsc*dp*icFFiscFFip30in* usb:v1BC7p10AAd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A9d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A8d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A7d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A4d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A3d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A2d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p10A0d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1083d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1082d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1081d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1080d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1079d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1078d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1077d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1075d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1073d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1072d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1071d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1070d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1063d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1062d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1061d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1060d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1058d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1057d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1056d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1055d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1054d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1053d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1052d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1051d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1050d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1045d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1043d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1041d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1040d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1042d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p103Cd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p103Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1038d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1037d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1036d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1035d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1034d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1033d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1031d*dc*dsc*dp*icFFisc*ip*in* usb:v1BC7p1012d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1010d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1006d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1005d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1004d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7253d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7252d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7251d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7213d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7212d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7211d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p700Ad*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7006d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7005d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7004d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7003d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7002d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6804d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6803d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6281d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6280d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6008d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6007d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6006d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6005d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6004d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6003d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6002d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v2C7Cp0316d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp0316d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0316d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0122d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0122d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp7001d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp6007d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp6001d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp6026d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp6002d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0901d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp6005d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0900d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0801d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0801d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0801d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0800d*dc*dsc*dp*icFFiscFFip10in* usb:v2C7Cp0800d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0800d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0800d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0700d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0620d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0620d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0512d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0512d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp6008d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp6008d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp6008d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0123d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp0123d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0123d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0124d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp0124d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0124d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp6009d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp6009d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp6009d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp012Cd*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp012Cd*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp012Cd*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp012Bd*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp012Bd*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp012Bd*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp012Ad*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp012Ad*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp012Ad*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0129d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp0129d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0129d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp0128d*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp0128d*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0128d*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp030Bd*dc*dsc*dp*icFFiscFFip40in* usb:v2C7Cp030Bd*dc*dsc*dp*icFFiscFFip30in* usb:v2C7Cp030Bd*dc*dsc*dp*icFFisc00ip40in* usb:v2C7Cp0311d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0314d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0313d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp030Cd*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp030Ed*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp030Ad*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0310d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0312d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0306d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0306d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0296d*dc*dsc*dp*ic*isc*ip*in* usb:v2C7Cp0203d*dc*dsc*dp*icFFisc*ip*in* usb:v2C7Cp0195d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0195d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0191d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0191d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0125d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0125d*dc*dsc*dp*icFFiscFFipFFin* usb:v2C7Cp0121d*dc*dsc*dp*icFFisc00ip00in* usb:v2C7Cp0121d*dc*dsc*dp*icFFiscFFipFFin* usb:v1546p1343d*dc*dsc*dp*ic*isc*ip*in* usb:v1546p1342d*dc*dsc*dp*ic*isc*ip*in* usb:v1546p1341d*dc*dsc*dp*ic*isc*ip*in* usb:v1546p1313d*dc*dsc*dp*icFFisc*ip*in* usb:v1546p1312d*dc*dsc*dp*ic*isc*ip*in* usb:v1546p1311d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p90FAd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p908Bd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p90B2d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9625d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9003d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9090d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p0023d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p6613d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p6001d*dc*dsc*dp*icFFiscFFipFFin* usb:v05C6p6000d*dc*dsc*dp*ic*isc*ip*in* usb:v0C88p180Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C88p17DAd*dc*dsc*dp*ic*isc*ip*in* usb:v1A8Dp1012d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1011d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1010d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Fd*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Ed*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Dd*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Cd*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Bd*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp100Ad*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1009d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1008d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1007d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1006d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1005d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1004d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1003d*dc*dsc*dp*icFFisc*ip*in* usb:v1A8Dp1002d*dc*dsc*dp*icFFisc*ip*in* usb:v0EABpC893d*dc*dsc*dp*ic*isc*ip*in* usb:v1726p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v16D5p6202d*dc*dsc*dp*ic*isc*ip*in* usb:v16D5p6502d*dc*dsc*dp*ic*isc*ip*in* usb:v16D5p6501d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8213d*dc*dsc*dp*icFFisc*ip*in* usb:v413Cp8215d*dc*dsc*dp*icFFisc*ip*in* usb:v413Cp81E4d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81E6d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81E0d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81D7d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp819Bd*dc*dsc*dp*icFFiscFFipFFin* usb:v413Cp8196d*dc*dsc*dp*icFFiscFFipFFin* usb:v413Cp8195d*dc*dsc*dp*icFFiscFFipFFin* usb:v413Cp8182d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8181d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8180d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8138d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8137d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8136d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8135d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8134d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8133d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8129d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8128d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8118d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8117d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8116d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8115d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8114d*dc*dsc*dp*ic*isc*ip*in* usb:v1614p0407d*dc*dsc*dp*ic*isc*ip*in* usb:v1614p0802d*dc*dsc*dp*ic*isc*ip*in* usb:v1614p7002d*dc*dsc*dp*ic*isc*ip*in* usb:v1614p0800d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p9022d*dc*dsc*dp*icFFisc00ip00in* usb:v1410p9011d*dc*dsc*dp*icFFiscFFipFFin* usb:v1410p9010d*dc*dsc*dp*icFFiscFFipFFin* usb:v1410pB001d*dc*dsc*dp*icFFiscFFipFFin* usb:v1410pA010d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7042d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7041d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7030d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7007d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7006d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7005d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7004d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7003d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p8000d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p7000d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p6000d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p6010d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p6002d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p4100d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p4400d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2420d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2410d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2400d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2130d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2120d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2110d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p2100d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1450d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1430d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1420d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1410d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1400d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1130d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1120d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1110d*dc*dsc*dp*ic*isc*ip*in* usb:v1410p1100d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p900Ed*dc*dsc*dp*icFFiscFFipFFin* usb:v22B8p4281d*dc*dsc*dp*ic0Aisc00ipFCin* usb:v22B8p2E0Ad*dc*dsc*dp*icFFiscFFipFFin* usb:v22B8p2A70d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc06ip01in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc05ip01in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc04ip01in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc03ip01in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc02ip01in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip7Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip7Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip7Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip79in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip78in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip75in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip74in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip73in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip72in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip6Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip6Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip6Din* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip6Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip6Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip66in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip65in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip64in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip63in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip62in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip61in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip4Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip4Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip4Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip49in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip48in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip3Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip3Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip3Din* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip3Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip3Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip36in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip35in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip34in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip33in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip32in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip31in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip1Cin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip1Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip1Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip19in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip18in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip17in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip15in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip14in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip13in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip12in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip10in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip0Fin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip0Ein* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip0Din* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip0Bin* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip0Ain* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip06in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip05in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip04in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip03in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip02in* usb:v12D1p*d*dc*dsc*dp*icFFisc01ip01in* usb:v12D1p*d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p14C6d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p14ACd*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p1465d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p1464d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p1442d*dc*dsc*dp*ic02isc02ipFFin* usb:v12D1p1441d*dc*dsc*dp*ic02isc02ipFFin* usb:v12D1p1406d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p1C07d*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p140Cd*dc*dsc*dp*icFFiscFFipFFin* usb:v12D1p1C23d*dc*dsc*dp*ic02isc02ipFFin* usb:v12D1p1C1Fd*dc*dsc*dp*ic02isc02ipFFin* usb:v12D1p1C05d*dc*dsc*dp*ic02isc02ipFFin* usb:v0408pEA42d*dc*dsc*dp*ic*isc*ip*in* usb:v0408pEA06d*dc*dsc*dp*ic*isc*ip*in* usb:v0408pEA05d*dc*dsc*dp*ic*isc*ip*in* usb:v0408pEA04d*dc*dsc*dp*ic*isc*ip*in* usb:v0408pEA03d*dc*dsc*dp*ic*isc*ip*in* usb:v0408pEA02d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7201d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7100d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7061d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7041d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7021d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6901d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6800d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6761d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6741d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6721d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6701d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6601d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6600d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6501d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6500d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6350d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6250d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6150d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6050d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6300d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6200d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6100d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p6000d*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p5000d*dc*dsc*dp*ic*isc*ip*in*
usbserial usb_wwan

kernel/drivers/usb/serial/qcserial.ko.xz usb:v03F0p581Dd*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8218d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8217d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81D2d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81D1d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81D0d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81CFd*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81CCd*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81CBd*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81C2d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81B6d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81B5d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81B3d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81B1d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A9d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A8d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A4d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A3d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A2d*dc*dsc*dp*ic*isc*ip*in* usb:v1199pC081d*dc*dsc*dp*ic*isc*ip*in* usb:v1199pC080d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p90E5d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p90E4d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p90D2d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9091d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9090d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p907Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p907Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9079d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9078d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9071d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9070d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9063d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9062d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9061d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9060d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9056d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9055d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9054d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9053d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9051d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9041d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9040d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p901Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p901Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1199p901Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68C0d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68A2d*dc*dsc*dp*ic*isc*ip*in* usb:v114Fp68A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0F3Dp68A2d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4E1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0AF0p8120d*dc*dsc*dp*ic*isc*ip*in* usb:v12D1p14F1d*dc*dsc*dp*ic*isc*ip*in* usb:v12D1p14F0d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p901Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9019d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9018d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9015d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9014d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9013d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9012d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9010d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68A9d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68A8d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68A5d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68A4d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp81A6d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8194d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8193d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA021d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA020d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p920Dd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p920Cd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p371Dd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9205d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9204d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p8002d*dc*dsc*dp*ic*isc*ip*in* usb:v16D8p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9011d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p900Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9009d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9008d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9007d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9006d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9005d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9004d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9003d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9002d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9275d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9274d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9235d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9234d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9265d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9264d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9215d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9214d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p251Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p241Dd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9245d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9244d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9225d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9224d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p920Bd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9208d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8186d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8185d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA014d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA013d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA012d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA011d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA010d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p900Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1F45p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9231d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9221d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9201d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9009d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9008d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9222d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9203d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9202d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9002d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v1557p0A80d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2pFFF2d*dc*dsc*dp*ic*isc*ip*in* usb:v19D2pFFF3d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1774d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p1776d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA008d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA007d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA006d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA005d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA004d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA003d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA002d*dc*dsc*dp*ic*isc*ip*in* usb:v1410pA001d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8171d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp8172d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp250Cd*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp250Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p201Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1F1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9212d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p9211d*dc*dsc*dp*ic*isc*ip*in*
usbserial usb_wwan

kernel/drivers/usb/serial/spcp8x5.ko.xz usb:v04FCp0201d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp0235d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp0231d*dc*dsc*dp*ic*isc*ip*in* usb:v04FCp0204d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p081Ed*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/navman.ko.xz usb:v0DF7p0900d*dc*dsc*dp*ic*isc*ip*in* usb:v0A99p0001d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/mos7840.ko.xz usb:v0856pBC03d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC44d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pBC02d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC42d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC32d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC31d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC30d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC29d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pBC01d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC24d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pBC00d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC22d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7843d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7840d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7820d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7810d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap2210d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p7820d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2011d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/keyspan_pda.ko.xz usb:v06CDp0104d*dc*dsc*dp*ic*isc*ip*in* usb:v1645p8093d*dc*dsc*dp*ic*isc*ip*in* usb:v085Ap8025d*dc*dsc*dp*ic*isc*ip*in* usb:v085Ap8027d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0103d*dc*dsc*dp*ic*isc*ip*in*
usbserial ezusb

kernel/drivers/usb/serial/usb_debug.ko.xz usb:v1D6Bp0011d*dc*dsc*dp*ic*isc*ip*in* usb:v1D6Bp0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0525p127Ad*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/f81534.ko.xz usb:v2C42p1202d*dc*dsc*dp*ic*isc*ip*in* usb:v1934p1202d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/usbserial.ko.xz symbol:usb_serial_claim_interface symbol:usb_serial_port_softint symbol:usb_serial_suspend symbol:usb_serial_resume symbol:__usb_serial_register_drivers symbol:usb_serial_deregister_drivers symbol:usb_serial_generic_open symbol:usb_serial_generic_close symbol:usb_serial_generic_write_start symbol:usb_serial_generic_write symbol:usb_serial_generic_chars_in_buffer symbol:usb_serial_generic_wait_until_sent symbol:usb_serial_generic_submit_read_urbs symbol:usb_serial_generic_process_read_urb symbol:usb_serial_generic_read_bulk_callback symbol:usb_serial_generic_write_bulk_callback symbol:usb_serial_generic_throttle symbol:usb_serial_generic_unthrottle symbol:usb_serial_generic_tiocmiwait symbol:usb_serial_generic_get_icount symbol:usb_serial_handle_dcd_change symbol:usb_serial_generic_resume

kernel/drivers/usb/serial/cp210x.ko.xz usb:v413Cp9500d*dc*dsc*dp*ic*isc*ip*in* usb:v3923p7A0Bd*dc*dsc*dp*ic*isc*ip*in* usb:v3195pF281d*dc*dsc*dp*ic*isc*ip*in* usb:v3195pF280d*dc*dsc*dp*ic*isc*ip*in* usb:v3195pF190d*dc*dsc*dp*ic*isc*ip*in* usb:v2626pEA60d*dc*dsc*dp*ic*isc*ip*in* usb:v2184p0030d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0701d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0700d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0602d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0601d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0600d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0404d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0403d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0402d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0401d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0400d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0303d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0302d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0300d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0203d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0202d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v1FB9p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v1E29p0501d*dc*dsc*dp*ic*isc*ip*in* usb:v1E29p0102d*dc*dsc*dp*ic*isc*ip*in* usb:v1D6Fp0010d*dc*dsc*dp*ic*isc*ip*in* usb:v1BE3p07A6d*dc*dsc*dp*ic*isc*ip*in* usb:v1BA4p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1B93p1013d*dc*dsc*dp*ic*isc*ip*in* usb:v1B1Cp1C00d*dc*dsc*dp*ic*isc*ip*in* usb:v1ADBp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v19CFp3000d*dc*dsc*dp*ic*isc*ip*in* usb:v199BpBA30d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0198d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0197d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0196d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0195d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0194d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0193d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0190d*dc*dsc*dp*ic*isc*ip*in* usb:v18EFpE032d*dc*dsc*dp*ic*isc*ip*in* usb:v18EFpE030d*dc*dsc*dp*ic*isc*ip*in* usb:v18EFpE025d*dc*dsc*dp*ic*isc*ip*in* usb:v18EFpE00Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1843p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v17F4pAAAAd*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0102d*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0101d*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v17A8p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v16DCp0015d*dc*dsc*dp*ic*isc*ip*in* usb:v16DCp0012d*dc*dsc*dp*ic*isc*ip*in* usb:v16DCp0011d*dc*dsc*dp*ic*isc*ip*in* usb:v16DCp0010d*dc*dsc*dp*ic*isc*ip*in* usb:v16D6p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v16C0p09B1d*dc*dsc*dp*ic*isc*ip*in* usb:v16C0p09B0d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0101d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0401d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0305d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0304d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0303d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0301d*dc*dsc*dp*ic*isc*ip*in* usb:v166Ap0201d*dc*dsc*dp*ic*isc*ip*in* usb:v155Ap1006d*dc*dsc*dp*ic*isc*ip*in* usb:v1555p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v13ADp9999d*dc*dsc*dp*ic*isc*ip*in* usb:v12B8pEC62d*dc*dsc*dp*ic*isc*ip*in* usb:v12B8pEC60d*dc*dsc*dp*ic*isc*ip*in* usb:v11CAp0212d*dc*dsc*dp*ic*isc*ip*in* usb:v10CEpEA6Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C5pEA61d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pF004d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pF003d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pF002d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pF001d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA7Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA7Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA71d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA70d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA63d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA61d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4pEA60d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8B34d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8A5Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8A5Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8A2Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p89FBd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p89A4d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8998d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8977d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8962d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8946d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8938d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p88FBd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p88D8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p88A5d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p88A4d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8857d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8856d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p87EDd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8665d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8664d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p863Cd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p85F8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p85EBd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p85EAd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p85B8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p85A7d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p851Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p84B6d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8477d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8470d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p846Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8418d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8414d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8411d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p83D8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p83AAd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p83A8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8382d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8341d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82F9d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82F4d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82F2d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82F1d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82EFd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p82AAd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8293d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8281d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p826Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p822Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8218d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81F2d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81E8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81E7d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81E2d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81D7d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81C8d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81ADd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81ACd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81A9d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p81A6d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p819Fd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p818Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p817Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p817Dd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p817Cd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p815Fd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p815Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8156d*dc*dsc*dp*ic*isc*ip*in* usb:v2405p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p814Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p814Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p813Fd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p813Dd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8115d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p80F6d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p80DDd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p80CAd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p80C4d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p807Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p806Fd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8066d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8056d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8054d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8053d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p804Ed*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p8044d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p803Bd*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p800Ad*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p1601d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p1101d*dc*dsc*dp*ic*isc*ip*in* usb:v10C4p0F91d*dc*dsc*dp*ic*isc*ip*in* usb:v10B5pAC70d*dc*dsc*dp*ic*isc*ip*in* usb:v10ABp10C5d*dc*dsc*dp*ic*isc*ip*in* usb:v10A6pAA26d*dc*dsc*dp*ic*isc*ip*in* usb:v106Fp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0FDEpCA05d*dc*dsc*dp*ic*isc*ip*in* usb:v0FCFp1006d*dc*dsc*dp*ic*isc*ip*in* usb:v0FCFp1004d*dc*dsc*dp*ic*isc*ip*in* usb:v0FCFp1003d*dc*dsc*dp*ic*isc*ip*in* usb:v0BEDp1101d*dc*dsc*dp*ic*isc*ip*in* usb:v0BEDp1100d*dc*dsc*dp*ic*isc*ip*in* usb:v0B00p3070d*dc*dsc*dp*ic*isc*ip*in* usb:v0988p0578d*dc*dsc*dp*ic*isc*ip*in* usb:v0908p01FFd*dc*dsc*dp*ic*isc*ip*in* usb:v0908p0070d*dc*dsc*dp*ic*isc*ip*in* usb:v08FDp000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v08E6p5501d*dc*dsc*dp*ic*isc*ip*in* usb:v0846p1100d*dc*dsc*dp*ic*isc*ip*in* usb:v0745p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v04BFp1303d*dc*dsc*dp*ic*isc*ip*in* usb:v04BFp1301d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE003d*dc*dsc*dp*ic*isc*ip*in* usb:v0489pE000d*dc*dsc*dp*ic*isc*ip*in* usb:v0471p066Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp0053d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p034Cd*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/ssu100.ko.xz usb:v061DpC020d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/wishbone-serial.ko.xz usb:v1D50p6062d*dc*dsc*dp*icFFiscFFipFFin*
usbserial

kernel/drivers/usb/serial/belkin_sa.ko.xz usb:v050Dp1203d*dc*dsc*dp*ic*isc*ip*in* usb:v0921p1200d*dc*dsc*dp*ic*isc*ip*in* usb:v0921p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v0565p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v056Cp8007d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0103d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/garmin_gps.ko.xz usb:v091Ep0003d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/mct_u232.ko.xz usb:v050Dp0109d*dc*dsc*dp*ic*isc*ip*in* usb:v0711p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v0711p0230d*dc*dsc*dp*ic*isc*ip*in* usb:v0711p0210d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/symbolserial.ko.xz usb:v05E0p0600d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/whiteheat.ko.xz usb:v0710p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0710p8001d*dc*dsc*dp*ic*isc*ip*in*
usbserial ezusb

kernel/drivers/usb/serial/sierra.ko.xz usb:v0F3Dp68A3d*dc*dsc*dp*icFFiscFFipFFin* usb:v0F3Dp68AAd*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p68ABd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p68AAd*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p68A3d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p6893d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6892d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p6891d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p6890d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p6880d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p685Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6859d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6856d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6855d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6853d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6852d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6851d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6850d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p683Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1199p683Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p683Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p683Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1199p683Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6839d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6838d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6835d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6834d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6833d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6832d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6822d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6821d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6820d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6816d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6815d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6813d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6812d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6809d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6808d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6805d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6804d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6803d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p6802d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0029d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0028d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0027d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0026d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0025d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p0023d*dc*dsc*dp*icFFiscFFipFFin* usb:v1199p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0120d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0112d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0019d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0224d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0024d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0022d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0220d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0218d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v1199p0017d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1E1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p211Dd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1B1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0F3Dp0112d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/ti_usb_3410_5052.ko.xz usb:v14B0p3410d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1151d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1150d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1131d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1130d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1110d*dc*dsc*dp*ic*isc*ip*in* usb:v10ACp0102d*dc*dsc*dp*ic*isc*ip*in* usb:v0451p5053d*dc*dsc*dp*ic*isc*ip*in* usb:v1A61p3420d*dc*dsc*dp*ic*isc*ip*in* usb:v1A61p3410d*dc*dsc*dp*ic*isc*ip*in* usb:v04B3p454Cd*dc*dsc*dp*ic*isc*ip*in* usb:v04B3p454Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04B3p4543d*dc*dsc*dp*ic*isc*ip*in* usb:v0451p505Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0451p505Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0451p5152d*dc*dsc*dp*ic*isc*ip*in* usb:v0451p5052d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0p0319d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF115d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF114d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF112d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF111d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF110d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF109d*dc*dsc*dp*ic*isc*ip*in* usb:v06E0pF108d*dc*dsc*dp*ic*isc*ip*in* usb:v0451pF430d*dc*dsc*dp*ic*isc*ip*in* usb:v0451p3410d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/aircable.ko.xz usb:v16CAp1502d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/mos7720.ko.xz usb:v9710p7715d*dc*dsc*dp*ic*isc*ip*in* usb:v9710p7720d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/cypress_m8.ko.xz usb:v07D0p4101d*dc*dsc*dp*ic*isc*ip*in* usb:v6737p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0D9Fp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v17DDp5500d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p5500d*dc*dsc*dp*ic*isc*ip*in* usb:v1163p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v1163p0100d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/qcaux.ko.xz usb:v1FACp0151d*dc*dsc*dp*icFFiscFFipFFin* usb:v106Cp*d*dc*dsc*dp*icFFiscFFipFFin* usb:v106Cp*d*dc*dsc*dp*icFFiscFEipFFin* usb:v106Cp*d*dc*dsc*dp*icFFiscFDipFFin* usb:v04E8p6640d*dc*dsc*dp*icFFisc00ip00in* usb:v0474p0754d*dc*dsc*dp*icFFiscFFip00in* usb:v1004p6000d*dc*dsc*dp*icFFiscFFip00in* usb:v16D8p6512d*dc*dsc*dp*icFFiscFFip00in* usb:v16D8p5553d*dc*dsc*dp*icFFiscFFip00in* usb:v106Cp3715d*dc*dsc*dp*icFFisc00ip00in* usb:v106Cp3714d*dc*dsc*dp*icFFisc00ip00in* usb:v106Cp3712d*dc*dsc*dp*icFFisc00ip00in* usb:v106Cp3711d*dc*dsc*dp*icFFisc00ip00in* usb:v106Cp3702d*dc*dsc*dp*icFFisc00ip00in* usb:v106Cp3701d*dc*dsc*dp*icFFisc00ip00in*
usbserial

kernel/drivers/usb/serial/iuu_phoenix.ko.xz usb:v104Fp0004d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/f81232.ko.xz usb:v2C42p16F8d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1636d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1635d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1634d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1632d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1608d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1606d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1605d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1604d*dc*dsc*dp*ic*isc*ip*in* usb:v2C42p1602d*dc*dsc*dp*ic*isc*ip*in* usb:v1934p0706d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/usb-serial-simple.ko.xz usb:v1CBEp0103d*dc*dsc*dp*ic*isc*ip*in* usb:v1D5Fp1004d*dc*dsc*dp*ic*isc*ip*in* usb:v0FCFp1009d*dc*dsc*dp*ic*isc*ip*in* usb:v0FCFp1008d*dc*dsc*dp*ic*isc*ip*in* usb:v0908p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v5345p1234d*dc*dsc*dp*ic*isc*ip*in* usb:v09D7p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0421p069Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9016d*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9015d*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9013d*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9012d*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9011d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2C64d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2C84d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2A64d*dc*dsc*dp*ic*isc*ip*in* usb:v0C44p0022d*dc*dsc*dp*ic*isc*ip*in* usb:v05C6p3197d*dc*dsc*dp*ic*isc*ip*in* usb:v1209p8B00d*dc*dsc*dp*ic*isc*ip*in* usb:v16D0p0870d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0121d*dc*dsc*dp*ic*isc*ip*in* usb:v18D1p*d*dc*dsc*dp*icFFisc50ip01in* usb:v1404pCDDCd*dc*dsc*dp*ic*isc*ip*in* usb:v8087p0801d*dc*dsc*dp*ic*isc*ip*in* usb:v8087p0716d*dc*dsc*dp*ic*isc*ip*in* usb:v058Bp0041d*dc*dsc*dp*ic0Aisc*ip*in* usb:v0A21p8001d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/metro-usb.ko.xz usb:v0C2Ep0730d*dc*dsc*dp*icFFisc*ip*in* usb:v0C2Ep0700d*dc*dsc*dp*ic*isc*ip*in* usb:v0C2Ep0720d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/ark3116.ko.xz usb:v18ECp3118d*dc*dsc*dp*ic*isc*ip*in* usb:v6547p0232d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/upd78f0730.ko.xz usb:v064Bp7825d*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp0212d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p0063d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/safe_serial.ko.xz usb:v05F9pFFFFd*dc02dsc*dp*icFFisc02ip*in* usb:v04DDp8004d*dc02dsc*dp*icFFisc02ip*in* usb:v04DDp8003d*dc02dsc*dp*icFFisc02ip*in* usb:v04DDp8002d*dc02dsc*dp*icFFisc02ip*in* usb:v04DDp8001d*dc02dsc*dp*icFFisc02ip*in* usb:v03F0p2101d*dc02dsc*dp*icFFisc02ip*in* usb:v049FpFFFFd*dc02dsc*dp*icFFisc02ip*in*
usbserial

kernel/drivers/usb/serial/ch341.ko.xz usb:v9986p7523d*dc*dsc*dp*ic*isc*ip*in* usb:v4348p5523d*dc*dsc*dp*ic*isc*ip*in* usb:v2184p0057d*dc*dsc*dp*ic*isc*ip*in* usb:v1A86p7523d*dc*dsc*dp*ic*isc*ip*in* usb:v1A86p7522d*dc*dsc*dp*ic*isc*ip*in* usb:v1A86p5523d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/ftdi_sio.ko.xz usb:v0403pF458d*dc*dsc*dp*ic*isc*ip*in* usb:v09FBp602Ed*dc*dsc*dp*ic*isc*ip*in03* usb:v09FBp602Ed*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp602Ed*dc*dsc*dp*ic*isc*ip*in01* usb:v09FBp602Dd*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp602Dd*dc*dsc*dp*ic*isc*ip*in01* usb:v09FBp602Cd*dc*dsc*dp*ic*isc*ip*in01* usb:v09FBp602Ad*dc*dsc*dp*ic*isc*ip*in03* usb:v09FBp602Ad*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp6029d*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp6026d*dc*dsc*dp*ic*isc*ip*in03* usb:v09FBp6026d*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp6025d*dc*dsc*dp*ic*isc*ip*in02* usb:v09FBp6022d*dc*dsc*dp*ic*isc*ip*in01* usb:v1CD7p0217d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p7151d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p7150d*dc*dsc*dp*ic*isc*ip*in01* usb:v1546p0506d*dc*dsc*dp*ic*isc*ip*in02* usb:v1546p0503d*dc*dsc*dp*ic*isc*ip*in* usb:v1546p0502d*dc*dsc*dp*ic*isc*ip*in* usb:v0590p00B2d*dc*dsc*dp*ic*isc*ip*in* usb:v2CAFp13A3d*dc*dsc*dp*ic*isc*ip*in* usb:v2CAFp13A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0920p7500d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p8348d*dc*dsc*dp*ic*isc*ip*in* usb:v22B7p150Dd*dc*dsc*dp*ic*isc*ip*in01* usb:v1C40p0477d*dc*dsc*dp*ic*isc*ip*in* usb:v1E8Ep6001d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4pF900d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p009Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0451pC32Ad*dc*dsc*dp*ic*isc*ip*in01* usb:v0A5Cp6422d*dc*dsc*dp*ic*isc*ip*in* usb:v1B5Cp0105d*dc*dsc*dp*ic*isc*ip*in* usb:v1B5Cp0104d*dc*dsc*dp*ic*isc*ip*in* usb:v1B5Cp0103d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC811d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p8050d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA5AFd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA5AEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA5ADd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA5ACd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA54Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA54Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA549d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA548d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9AFd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9AEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9ADd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9ACd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9ABd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9AAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9A9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD9A8d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0015d*dc*dsc*dp*ic*isc*ip*in* usb:v058Bp0043d*dc*dsc*dp*ic*isc*ip*in01* usb:v058Bp0028d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pCB08d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p8004d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p8003d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p8002d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2012d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2011d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2003d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p7001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p3012d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p3011d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1013d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1019d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2024d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2023d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2022d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p2021d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p5001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1017d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9008d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9007d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9006d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9005d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9004d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9003d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9002d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1021d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1011d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1004d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v05D1p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p87D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p8E08d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6002d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pCFF8d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p8A28d*dc*dsc*dp*ic*isc*ip*in* usb:v0483p3747d*dc*dsc*dp*ic*isc*ip*in* usb:v0483p3746d*dc*dsc*dp*ic*isc*ip*in01* usb:v20B7p0713d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p9868d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA9A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA951d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF1Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF18d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFFd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFDd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFCd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFBd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAFAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAF9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDAF8d*dc*dsc*dp*ic*isc*ip*in* usb:v1C0Cp0102d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pD578d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE729d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBCA4d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBCA2d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBCA1d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBCA0d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p937Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403p937Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403p9379d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p9378d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pED71d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pED73d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pED72d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pED74d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA6D0d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p9E90d*dc*dsc*dp*ic*isc*ip*in01* usb:v1A79p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v165Cp0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1016d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1015d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1014d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1013d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1012d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1011d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p100Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p100Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p100Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1009d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1008d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1007d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1005d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v1A72p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0A1d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0C33p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0FD8p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v9E88p9E8Fd*dc*dsc*dp*ic*isc*ip*in01* usb:v0C6Cp04B2d*dc*dsc*dp*ic*isc*ip*in* usb:v1514p2008d*dc*dsc*dp*ic*isc*ip*in02* usb:v04D8p000Ad*dc*dsc*dp*icFFiscFFip00in* usb:v0456pF001d*dc*dsc*dp*ic*isc*ip*in01* usb:v0456pF000d*dc*dsc*dp*ic*isc*ip*in01* usb:v1CF1p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v1CF1p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp2109d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB99d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC9p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEF51d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEF50d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8005d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8004d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8003d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8002d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p8000d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p1000d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0F00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0E00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0D00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0C00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0B00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0A00d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0900d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0800d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0700d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0500d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0400d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0300d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0107d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0106d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0105d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0104d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0103d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0102d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0101d*dc*dsc*dp*ic*isc*ip*in* usb:v5050p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pED22d*dc*dsc*dp*ic*isc*ip*in* usb:v0584pB03Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0584pB020d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBDC8d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBD90d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBCDAd*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBCD9d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBCD8d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pBAF8d*dc*dsc*dp*ic*isc*ip*in01* usb:v1457p5118d*dc*dsc*dp*ic*isc*ip*in01* usb:v15BAp002Ad*dc*dsc*dp*ic*isc*ip*in01* usb:v15BAp0004d*dc*dsc*dp*ic*isc*ip*in01* usb:v15BAp002Bd*dc*dsc*dp*ic*isc*ip*in01* usb:v15BAp0003d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p8698d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pD739d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD738d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE700d*dc*dsc*dp*ic*isc*ip*in* usb:v1B91p0064d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE40Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEE18d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E6Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E69d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E68d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E67d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E66d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E65d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E64d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E63d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E62d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E61d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E60d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Fd*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Ed*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Cd*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Bd*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E5Ad*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E59d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E58d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E57d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E56d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E55d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E54d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E53d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E52d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E51d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9E50d*dc*dsc*dp*ic*isc*ip*in* usb:v2100p9001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p9E50d*dc*dsc*dp*ic*isc*ip*in* usb:v1A28p6010d*dc*dsc*dp*ic*isc*ip*in* usb:v1781p0C30d*dc*dsc*dp*ic*isc*ip*in* usb:v23F2p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDA74d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDA73d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDA72d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDA71d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDA70d*dc*dsc*dp*ic*isc*ip*in* usb:v0C7Dp0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pCC4Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pCC49d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pCC48d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD678d*dc*dsc*dp*ic*isc*ip*in* usb:v128Dp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v128Dp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFAF0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE050d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDD20d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p000Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p000Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0009d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC1E0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC991d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC7D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA88d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDC01d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDC00d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEA90d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF20d*dc*dsc*dp*ic*isc*ip*in* usb:v0D3Ap0300d*dc*dsc*dp*ic*isc*ip*in* usb:v0D46p2021d*dc*dsc*dp*ic*isc*ip*in* usb:v0D46p2020d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF35d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF33d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF31d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF32d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF30d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pDF28d*dc*dsc*dp*ic*isc*ip*in* usb:vDEEEp0303d*dc*dsc*dp*ic*isc*ip*in* usb:vDEEEp0302d*dc*dsc*dp*ic*isc*ip*in* usb:vDEEEp0300d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEC89d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEC88d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEEFd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEEEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEEDd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEECd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEEBd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEEAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEE9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEEE8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE548d*dc*dsc*dp*ic*isc*ip*in* usb:v1342p0202d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD491d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0300d*dc*dsc*dp*ic*isc*ip*in* usb:v2639pD00Dd*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0101d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0102d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD38Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD389d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD388d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF3C2d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF3C1d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF3C0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE520d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pBA02d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC50d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC49d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC34d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC33d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC27d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC26d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC25d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC19d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC18d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC17d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC16d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC12d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC11d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC03d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC02d*dc*dsc*dp*ic*isc*ip*in* usb:v0856pAC01d*dc*dsc*dp*ic*isc*ip*in* usb:v06D3p0284d*dc*dsc*dp*ic*isc*ip*in* usb:v06CEp8311d*dc*dsc*dp*ic*isc*ip*in* usb:v0647p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFD60d*dc*dsc*dp*ic*isc*ip*in* usb:v103Ep03E8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF460d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF680d*dc*dsc*dp*ic*isc*ip*in* usb:v0F94p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v0F94p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v093Cp0701d*dc*dsc*dp*ic*isc*ip*in* usb:v093Cp0601d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFAD0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D5d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D4d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D3d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D2d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D1d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF9D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF44Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF44Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF44Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF449d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF448d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF441d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF440d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0EEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0EDd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0ECd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0EBd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0EAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0E9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0EFd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0E8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F7d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F6d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F5d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F4d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F3d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F2d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F1d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE0F0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF069d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF068d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB59d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE00Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE009d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE008d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE006d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE004d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE002d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE000d*dc*dsc*dp*ic*isc*ip*in* usb:v1B1FpC006d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFD4Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFD4Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFD49d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFD48d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p9090d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p7C93d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p7C92d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p7C91d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p7C90d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403p8A98d*dc*dsc*dp*ic*isc*ip*in01* usb:v0403pFA33d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF3Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF39d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF38d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE6C8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF06Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB58d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB5Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE88Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE889d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE888d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE80Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE809d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pE808d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC73d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC72d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC71d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC70d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF850d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA78d*dc*dsc*dp*ic*isc*ip*in* usb:v0B39p0103d*dc*dsc*dp*ic*isc*ip*in* usb:v0B39p0421d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACDp0300d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52pA02Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0C52pA02Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0C52pA02Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0C52pA02Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2883d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2873d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2863d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2853d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2843d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2833d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2823d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2813d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2882d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2872d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2862d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2852d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2842d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2832d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2822d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2812d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2881d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2871d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2861d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2851d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2841d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2831d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2821d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2811d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2443d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2433d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2423d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2413d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2442d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2432d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2422d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2412d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2441d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2431d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2421d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2411d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2223d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2213d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2222d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2212d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2221d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2211d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p9020d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2104d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2103d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2102d*dc*dsc*dp*ic*isc*ip*in* usb:v0C52p2101d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF857d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pEBE0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF208d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF0C0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp931Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9319d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9318d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9317d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9316d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9315d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9314d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9313d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9312d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9311d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9310d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp930Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9309d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9308d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9307d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9306d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9305d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9304d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9303d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9302d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9301d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp9300d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp4701d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FDd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FCd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FBd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01FAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01F0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01EFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01EEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01EDd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01ECd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01EBd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01EAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01E0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DDd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DCd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DBd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01DAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01D0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CDd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CCd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CBd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01CAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01C0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BDd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BCd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BBd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01BAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01B0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01AFd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01AEd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01ADd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01ACd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01ABd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01AAd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A9d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A8d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A7d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A6d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A5d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A4d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A3d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A2d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A1d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp01A0d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp019Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0199d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0198d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0197d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0196d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0195d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0194d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0193d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0192d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0191d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0190d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp018Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0189d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0188d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0187d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0186d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0185d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0184d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0183d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0182d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0181d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0180d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp017Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0179d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0178d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0177d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0176d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0175d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0174d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0173d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0172d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0171d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0170d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp016Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0169d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0168d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0167d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0166d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0165d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0164d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0163d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0162d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0161d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0160d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp015Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0159d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0158d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0157d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0156d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0155d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0154d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0153d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0152d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0151d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0150d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp014Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0149d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0148d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0147d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0146d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0145d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0144d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0143d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0142d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0141d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0140d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp013Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0139d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0138d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0137d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0136d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0135d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0134d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0133d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0132d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0131d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0130d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp012Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0129d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0128d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0127d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0126d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0125d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0124d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0123d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0122d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0121d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0120d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp011Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0119d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0118d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0117d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0116d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0115d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0114d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0113d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0112d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0111d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0110d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp010Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0109d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0108d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0107d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0106d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0105d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0104d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0103d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0102d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0101d*dc*dsc*dp*ic*isc*ip*in* usb:v1B3Dp0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p4F50d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF070d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFB80d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA06d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA05d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA04d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA03d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA02d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA01d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA00d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFE38d*dc*dsc*dp*ic*isc*ip*in* usb:v0DCDp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC8Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC8Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC82d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC0Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC09d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC08d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD780d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF0EEd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF0E9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF0C8d*dc*dsc*dp*ic*isc*ip*in* usb:v1209p1006d*dc*dsc*dp*ic*isc*ip*in* usb:v1209p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v104Dp3006d*dc*dsc*dp*ic*isc*ip*in* usb:v104Dp3002d*dc*dsc*dp*ic*isc*ip*in* usb:v104Dp3000d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFDDd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFDCd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFDBd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFDAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFD9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pBFD8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFA10d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pCAA0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6048d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6045d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6044d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6043d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6042d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6041d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6040d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6015d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6014d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6011d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6010d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFBFAd*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6006d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p6001d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p8372d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pC850d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD071d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD070d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFC60d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF2D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pB812d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pB811d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pB810d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD017d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD016d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD015d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD014d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD013d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD012d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD011d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pD010d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pABB9d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pABB8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pA559d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p9F80d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFFA8d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pFF00d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF60Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF608d*dc*dsc*dp*ic*isc*ip*in* usb:v0403pF7C0d*dc*dsc*dp*ic*isc*ip*in* usb:v0403p0000d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/visor.ko.xz usb:v0E67p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0C88p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v4766p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v091Ep0004d*dc*dsc*dp*ic*isc*ip*in* usb:v12EFp0100d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6601d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p8001d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0169d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0144d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp00E9d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp00DAd*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp009Ad*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0095d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0066d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0038d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0070d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0031d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0061d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0060d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0050d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0040d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0080d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v0830p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v115EpF100d*dc*dsc*dp*ic*isc*ip*in* usb:v082Dp0300d*dc*dsc*dp*ic*isc*ip*in* usb:v082Dp0200d*dc*dsc*dp*ic*isc*ip*in* usb:v082Dp0100d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/quatech2.ko.xz usb:v061DpC180d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC1A0d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC170d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC160d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC150d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC140d*dc*dsc*dp*ic*isc*ip*in* usb:v061DpC120d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/io_edgeport.ko.xz usb:v05D9pA225d*dc*dsc*dp*ic*isc*ip*in* usb:v05D9pA794d*dc*dsc*dp*ic*isc*ip*in* usb:v05D9pA758d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p0312d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p0311d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p0310d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p0203d*dc*dsc*dp*ic*isc*ip*in* usb:v0404p0202d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0008d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0014d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0019d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p001Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p000Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p000Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1608p000Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p000Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0007d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p1403d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0001d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/opticon.ko.xz usb:v065Ap0009d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/kl5kusb105.ko.xz usb:v0830p0080d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/ipaq.ko.xz usb:v5E04pCE00d*dc*dsc*dp*ic*isc*ip*in* usb:v4505p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4009d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4008d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4007d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4006d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4005d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4004d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4003d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4002d*dc*dsc*dp*ic*isc*ip*in* usb:v413Cp4001d*dc*dsc*dp*ic*isc*ip*in* usb:v4113p0410d*dc*dsc*dp*ic*isc*ip*in* usb:v4113p0400d*dc*dsc*dp*ic*isc*ip*in* usb:v4113p0211d*dc*dsc*dp*ic*isc*ip*in* usb:v4113p0210d*dc*dsc*dp*ic*isc*ip*in* usb:v3708p21CEd*dc*dsc*dp*ic*isc*ip*in* usb:v3708p20CEd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p3326d*dc*dsc*dp*ic*isc*ip*in* usb:v3340p2326d*dc*dsc*dp*ic*isc*ip*in* usb:v3340p191Cd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p1326d*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0F3Ad*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0F1Cd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0E3Ad*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0B1Cd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p071Cd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p053Ad*dc*dsc*dp*ic*isc*ip*in* usb:v3340p051Cd*dc*dsc*dp*ic*isc*ip*in* usb:v3340p043Ad*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0426d*dc*dsc*dp*ic*isc*ip*in* usb:v3340p0326d*dc*dsc*dp*ic*isc*ip*in* usb:v3340p011Cd*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p4244d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p4234d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p4224d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p4214d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p4204d*dc*dsc*dp*ic*isc*ip*in* usb:v1690p0601d*dc*dsc*dp*ic*isc*ip*in* usb:v1231pCE02d*dc*dsc*dp*ic*isc*ip*in* usb:v1231pCE01d*dc*dsc*dp*ic*isc*ip*in* usb:v11D9p1003d*dc*dsc*dp*ic*isc*ip*in* usb:v11D9p1002d*dc*dsc*dp*ic*isc*ip*in* usb:v1182p1388d*dc*dsc*dp*ic*isc*ip*in* usb:v1114p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v1114p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v1114p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v1066p0700d*dc*dsc*dp*ic*isc*ip*in* usb:v1066p0600d*dc*dsc*dp*ic*isc*ip*in* usb:v1066p0500d*dc*dsc*dp*ic*isc*ip*in* usb:v1066p0300d*dc*dsc*dp*ic*isc*ip*in* usb:v1066p00CEd*dc*dsc*dp*ic*isc*ip*in* usb:v0FB8p4001d*dc*dsc*dp*ic*isc*ip*in* usb:v0FB8p3003d*dc*dsc*dp*ic*isc*ip*in* usb:v0FB8p3002d*dc*dsc*dp*ic*isc*ip*in* usb:v0FB8p3001d*dc*dsc*dp*ic*isc*ip*in* usb:v0F98p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v0F4Ep0200d*dc*dsc*dp*ic*isc*ip*in* usb:v0CADp9001d*dc*dsc*dp*ic*isc*ip*in* usb:v0C8Ep6000d*dc*dsc*dp*ic*isc*ip*in* usb:v0C44p03A2d*dc*dsc*dp*ic*isc*ip*in* usb:v0BF8p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0BCEd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A9Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A99d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A98d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A97d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A96d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A95d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A94d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A93d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A92d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A91d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A90d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A8Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A89d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A88d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A87d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A86d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A85d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A84d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A83d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A82d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A81d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A80d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A7Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A79d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A78d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A77d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A76d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A75d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A74d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A73d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A72d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A71d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A70d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A6Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A69d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A68d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A67d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A66d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A65d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A64d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A63d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A62d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A61d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A60d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A5Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A59d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A58d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A57d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A56d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A55d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A54d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A53d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A52d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A51d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A50d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A4Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A49d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A48d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A47d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A46d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A45d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A44d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A43d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A42d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A41d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A40d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A3Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A39d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A38d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A37d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A36d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A35d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A34d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A33d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A32d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A31d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A30d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A2Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A29d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A28d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A27d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A26d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A25d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A24d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A23d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A22d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A21d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A20d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A1Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A19d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A18d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A17d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A16d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A15d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A14d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A13d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A12d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A11d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A10d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Dd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A0Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A09d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A08d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A07d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A06d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A05d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A04d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A03d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A02d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p0A01d*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p00CFd*dc*dsc*dp*ic*isc*ip*in* usb:v0BB4p00CEd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p9202d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p9200d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p420Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p4202d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p4201d*dc*dsc*dp*ic*isc*ip*in* usb:v0B05p4200d*dc*dsc*dp*ic*isc*ip*in* usb:v099Ep4000d*dc*dsc*dp*ic*isc*ip*in* usb:v099Ep0052d*dc*dsc*dp*ic*isc*ip*in* usb:v0961p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0960p0067d*dc*dsc*dp*ic*isc*ip*in* usb:v0960p0066d*dc*dsc*dp*ic*isc*ip*in* usb:v0960p0065d*dc*dsc*dp*ic*isc*ip*in* usb:v094Bp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p070Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0930p070Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0709d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0708d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0707d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0706d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0705d*dc*dsc*dp*ic*isc*ip*in* usb:v0930p0700d*dc*dsc*dp*ic*isc*ip*in* usb:v07CFp2003d*dc*dsc*dp*ic*isc*ip*in* usb:v07CFp2002d*dc*dsc*dp*ic*isc*ip*in* usb:v07CFp2001d*dc*dsc*dp*ic*isc*ip*in* usb:v067Ep1001d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p200Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2009d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2008d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2007d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2006d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2005d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2004d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2003d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2002d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2001d*dc*dsc*dp*ic*isc*ip*in* usb:v05E0p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p1923d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p1922d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p1921d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p152Ed*dc*dsc*dp*ic*isc*ip*in* usb:v0543p152Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0543p1529d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p1527d*dc*dsc*dp*ic*isc*ip*in* usb:v0543p0ED9d*dc*dsc*dp*ic*isc*ip*in* usb:v0536p01A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0502p16E3d*dc*dsc*dp*ic*isc*ip*in* usb:v0502p16E2d*dc*dsc*dp*ic*isc*ip*in* usb:v0502p16E1d*dc*dsc*dp*ic*isc*ip*in* usb:v0502p1632d*dc*dsc*dp*ic*isc*ip*in* usb:v0502p1631d*dc*dsc*dp*ic*isc*ip*in* usb:v04F1p3012d*dc*dsc*dp*ic*isc*ip*in* usb:v04F1p3011d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6632d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6630d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p662Ed*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p661Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6619d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6617d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6615d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6613d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p6611d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p5F04d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p5F03d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p5F02d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p5F01d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p5F00d*dc*dsc*dp*ic*isc*ip*in* usb:v04DDp91ACd*dc*dsc*dp*ic*isc*ip*in* usb:v04DDp9151d*dc*dsc*dp*ic*isc*ip*in* usb:v04DDp9123d*dc*dsc*dp*ic*isc*ip*in* usb:v04DDp9121d*dc*dsc*dp*ic*isc*ip*in* usb:v04DDp9102d*dc*dsc*dp*ic*isc*ip*in* usb:v04DAp2500d*dc*dsc*dp*ic*isc*ip*in* usb:v04C5p1079d*dc*dsc*dp*ic*isc*ip*in* usb:v04C5p1058d*dc*dsc*dp*ic*isc*ip*in* usb:v04B7p0531d*dc*dsc*dp*ic*isc*ip*in* usb:v04ADp0306d*dc*dsc*dp*ic*isc*ip*in* usb:v04ADp0303d*dc*dsc*dp*ic*isc*ip*in* usb:v04ADp0302d*dc*dsc*dp*ic*isc*ip*in* usb:v04ADp0301d*dc*dsc*dp*ic*isc*ip*in* usb:v04A4p0014d*dc*dsc*dp*ic*isc*ip*in* usb:v049Fp0032d*dc*dsc*dp*ic*isc*ip*in* usb:v049Fp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04EAd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E9d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E8d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E7d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E6d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E5d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E4d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E3d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E2d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E1d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04E0d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DFd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DEd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DDd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DCd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DBd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04DAd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04D9d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04D8d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04D7d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04CEd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04CDd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04CCd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04CBd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04CAd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04C9d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep04C8d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep047Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep047Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0479d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0478d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0477d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0476d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0475d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0474d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0473d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0472d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0471d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0470d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Fd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Cd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep046Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0469d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0468d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0467d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0466d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0465d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0464d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0463d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0462d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0461d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0460d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Fd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Cd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep045Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0459d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0458d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0457d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0456d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0455d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0454d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0453d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0452d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0451d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0450d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Fd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Cd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep044Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0449d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0448d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0447d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0446d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0445d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0444d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0443d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0442d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0441d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0440d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Fd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Cd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep043Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0439d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0438d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0437d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0436d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0435d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0434d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0433d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0432d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0417d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0416d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0415d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0414d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0413d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0412d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0411d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0410d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Fd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Ed*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Cd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Bd*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep040Ad*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0409d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0408d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0407d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0406d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0405d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0404d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0403d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0402d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0401d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep0400d*dc*dsc*dp*ic*isc*ip*in* usb:v045Ep00CEd*dc*dsc*dp*ic*isc*ip*in* usb:v043Ep9C01d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p8025d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p8024d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p00D7d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p00D6d*dc*dsc*dp*ic*isc*ip*in* usb:v0409p00D5d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p5216d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p5116d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p5016d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4216d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4116d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4016d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3216d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3116d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3016d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p2216d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p2116d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p2016d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1216d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1116d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p1016d*dc*dsc*dp*ic*isc*ip*in* usb:v0104p00BEd*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/kobil_sct.ko.xz usb:v0D46p0081d*dc*dsc*dp*ic*isc*ip*in* usb:v0D46p0078d*dc*dsc*dp*ic*isc*ip*in* usb:v0D46p2012d*dc*dsc*dp*ic*isc*ip*in* usb:v0D46p2011d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/omninet.ko.xz usb:v0586p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p1500d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p1000d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/digi_acceleport.ko.xz usb:v05C5p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v05C5p0002d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/keyspan.ko.xz usb:v06CDp0131d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp012Ad*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp010Ad*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0135d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0115d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0110d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp010Fd*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp011Cd*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0121d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0119d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp010Cd*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0108d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0107d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0112d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp011Ad*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0109d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0113d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0114d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0102d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0101d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp011Bd*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0118d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp010Bd*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0106d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0103d*dc*dsc*dp*ic*isc*ip*in* usb:v06CDp0105d*dc*dsc*dp*ic*isc*ip*in*
usbserial ezusb

kernel/drivers/usb/serial/mxuport.ko.xz usb:v110Ap1653d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1613d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1658d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1618d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1451d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1450d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1410d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1251d*dc*dsc*dp*ic*isc*ip*in* usb:v110Ap1250d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/oti6858.ko.xz usb:v0EA0p6858d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/xr_serial.ko.xz usb:v04E2p1424d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1422d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1420d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1414d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1412d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1411d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1410d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1403d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1402d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1401d*dc*dsc*dp*ic02isc*ip*in* usb:v04E2p1400d*dc*dsc*dp*ic02isc*ip*in*
usbserial

kernel/drivers/usb/serial/pl2303.ko.xz usb:v345Fp3020d*dc*dsc*dp*ic*isc*ip*in* usb:v04B3p4016d*dc*dsc*dp*ic*isc*ip*in* usb:v0CAAp3001d*dc*dsc*dp*ic*isc*ip*in* usb:v0B8Cp2303d*dc*dsc*dp*ic*isc*ip*in* usb:v0B63p653Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0B63p6530d*dc*dsc*dp*ic*isc*ip*in* usb:v11ADp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp0437d*dc*dsc*dp*ic*isc*ip*in* usb:v04B8p0522d*dc*dsc*dp*ic*isc*ip*in* usb:v04B8p0521d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0956d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p5039d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0F9Bd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p026Bd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3239d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3139d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4439d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0B39d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0183d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0F7Fd*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p4349d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p3524d*dc*dsc*dp*ic*isc*ip*in* usb:v5372p2303d*dc*dsc*dp*ic*isc*ip*in* usb:v05ADp0FBAd*dc*dsc*dp*ic*isc*ip*in* usb:v07AAp002Ad*dc*dsc*dp*ic*isc*ip*in* usb:v11F6p2001d*dc*dsc*dp*ic*isc*ip*in* usb:v058Fp9720d*dc*dsc*dp*ic*isc*ip*in* usb:v050Dp0257d*dc*dsc*dp*ic*isc*ip*in* usb:v0731p2003d*dc*dsc*dp*ic*isc*ip*in* usb:v0E55p110Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0413p2101d*dc*dsc*dp*ic*isc*ip*in* usb:v079Bp0027d*dc*dsc*dp*ic*isc*ip*in* usb:v10B5pAC70d*dc*dsc*dp*ic*isc*ip*in* usb:v078Bp1234d*dc*dsc*dp*ic*isc*ip*in* usb:v0745p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v04A5p4027d*dc*dsc*dp*ic*isc*ip*in* usb:v11F5p0005d*dc*dsc*dp*ic*isc*ip*in* usb:v11F5p0004d*dc*dsc*dp*ic*isc*ip*in* usb:v11F5p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v11F5p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v11F7p02DFd*dc*dsc*dp*ic*isc*ip*in* usb:v6189p2068d*dc*dsc*dp*ic*isc*ip*in* usb:v0731p0528d*dc*dsc*dp*ic*isc*ip*in* usb:v1453p4026d*dc*dsc*dp*ic*isc*ip*in* usb:v2478p2008d*dc*dsc*dp*ic*isc*ip*in* usb:v0584pB000d*dc*dsc*dp*ic*isc*ip*in* usb:v0DF7p0620d*dc*dsc*dp*ic*isc*ip*in* usb:v0EBAp2080d*dc*dsc*dp*ic*isc*ip*in* usb:v0EBAp1080d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep5004d*dc*dsc*dp*ic*isc*ip*in* usb:v056Ep5003d*dc*dsc*dp*ic*isc*ip*in* usb:v0547p2008d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2118d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2022d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2021d*dc*dsc*dp*ic*isc*ip*in* usb:v0557p2008d*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0A0Ed*dc*dsc*dp*ic*isc*ip*in* usb:v04BBp0A03d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23F3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23E3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23D3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23C3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23B3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp23A3d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp2304d*dc*dsc*dp*ic*isc*ip*in* usb:v067BpE1F1d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0307d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp331Ad*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0609d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0612d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp0611d*dc*dsc*dp*ic*isc*ip*in* usb:v067BpAAA0d*dc*dsc*dp*ic*isc*ip*in* usb:v067BpAAA8d*dc*dsc*dp*ic*isc*ip*in* usb:v067BpAAA2d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp1234d*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp04BBd*dc*dsc*dp*ic*isc*ip*in* usb:v067Bp2303d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/cyberjack.ko.xz usb:v0C4Bp0100d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/usb_wwan.ko.xz symbol:usb_wwan_dtr_rts symbol:usb_wwan_tiocmget symbol:usb_wwan_tiocmset symbol:usb_wwan_write symbol:usb_wwan_write_room symbol:usb_wwan_chars_in_buffer symbol:usb_wwan_open symbol:usb_wwan_close symbol:usb_wwan_port_probe symbol:usb_wwan_port_remove symbol:usb_wwan_suspend symbol:usb_wwan_resume
usbserial

kernel/drivers/usb/serial/ipw.ko.xz usb:v0BC3p0001d*dc*dsc*dp*ic*isc*ip*in*
usbserial usb_wwan

kernel/drivers/usb/serial/xsens_mt.ko.xz usb:v2639p0017d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0013d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0012d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0011d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0002d*dc*dsc*dp*ic*isc*ip*in* usb:v2639p0001d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/io_ti.ko.xz usb:v1608p1A01d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0247d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0212d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0243d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0244d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0242d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p021Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1608p021Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p021Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p021Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0206d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0201d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0217d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p020Dd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p020Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0207d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p021Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0205d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p030Ed*dc*dsc*dp*ic*isc*ip*in* usb:v1608p030Cd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p030Bd*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0309d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p030Ad*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0308d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0307d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0306d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0305d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0304d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0303d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0302d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0301d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0241d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0240d*dc*dsc*dp*ic*isc*ip*in* usb:v1608p0215d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/serial/empeg.ko.xz usb:v084Fp0001d*dc*dsc*dp*ic*isc*ip*in*
usbserial

kernel/drivers/usb/mon/usbmon.ko.xz

kernel/drivers/usb/class/cdc-acm.ko.xz char_major_166_* usb:v1519p0452d*dc*dsc*dp*ic*isc*ip*in* usb:v*p*d*dc*dsc*dp*ic02isc02ip06in* usb:v*p*d*dc*dsc*dp*ic02isc02ip05in* usb:v*p*d*dc*dsc*dp*ic02isc02ip04in* usb:v*p*d*dc*dsc*dp*ic02isc02ip03in* usb:v*p*d*dc*dsc*dp*ic02isc02ip02in* usb:v*p*d*dc*dsc*dp*ic02isc02ip01in* usb:v*p*d*dc*dsc*dp*ic02isc02ip00in* usb:v32A7p0000d*dc*dsc*dp*ic*isc*ip*in* usb:v27C6p5395d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p0023d*dc*dsc*dp*ic*isc*ip*in* usb:v1BC7p0021d*dc*dsc*dp*ic*isc*ip*in* usb:v108Cp0169d*dc*dsc*dp*ic*isc*ip*in* usb:v108Cp0168d*dc*dsc*dp*ic*isc*ip*in* usb:v108Cp0159d*dc*dsc*dp*ic*isc*ip*in* usb:v058Bp0041d*dc*dsc*dp*ic*isc*ip*in* usb:v04E8p685Dd*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1424d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1422d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1420d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1414d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1412d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1411d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1410d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1403d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1402d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1401d*dc*dsc*dp*ic*isc*ip*in* usb:v04E2p1400d*dc*dsc*dp*ic*isc*ip*in* usb:v04D8pF58Bd*dc*dsc*dp*ic*isc*ip*in* usb:v04D8pFD08d*dc*dsc*dp*ic*isc*ip*in* usb:v03EBp0030d*dc*dsc*dp*ic*isc*ip*in* usb:v04E7p6651d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p03CDd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0335d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0302d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p01D4d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04CEd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0154d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p026Cd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0275d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0223d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p01D0d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p02D9d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p010Ed*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0178d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p02E3d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p01F5d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0108d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p00E9d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p003Ad*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0094d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p007Bd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p00A0d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p008Fd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0128d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0099d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0070d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04F0d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0071d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0007d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0481d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p00ABd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p00B0d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0042d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p00FCd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0088d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p002Fd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p046Ed*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0134d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04B2d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04E6d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0420d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p048Ed*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p042Fd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0445d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p000Ed*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04DFd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0486d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0425d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0418d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0508d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0475d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0001d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p044Dd*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p0419d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04C9d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p04D8d*dc*dsc*dp*ic02isc02ipFFin* usb:v0421p042Dd*dc*dsc*dp*ic02isc02ipFFin* usb:v2912p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0CA6pA050d*dc*dsc*dp*ic*isc*ip*in* usb:v0C26p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v09D8p0320d*dc*dsc*dp*ic*isc*ip*in* usb:vFFF0p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v1576p03B1d*dc*dsc*dp*ic*isc*ip*in* usb:v1BBBp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v05F9p4002d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1340d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1329d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D9Ad*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D99d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D97d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D96d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D95d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D93d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D92d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p2D91d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p6425d*dc*dsc*dp*ic*isc*ip*in* usb:v2184p0036d*dc*dsc*dp*ic*isc*ip*in* usb:v2184p001Cd*dc*dsc*dp*ic*isc*ip*in* usb:v20DFp0001d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1349d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1328d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1324d*dc*dsc*dp*ic*isc*ip*in* usb:v0572p1321d*dc*dsc*dp*ic*isc*ip*in* usb:v0803p3095d*dc*dsc*dp*ic*isc*ip*in* usb:v22B8p7000d*dc*dsc*dp*ic*isc*ip*in* usb:v1965p0018d*dc*dsc*dp*ic*isc*ip*in* usb:v1901p0006d*dc*dsc*dp*ic*isc*ip*in* usb:v11CAp0201d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1611d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1608d*dc*dsc*dp*ic*isc*ip*in* usb:v0ACEp1602d*dc*dsc*dp*ic*isc*ip*in* usb:v079Bp000Fd*dc*dsc*dp*ic*isc*ip*in* usb:v0482p0203d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp3329d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0E8Dp0003d*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp024Dd*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp0248d*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp0247d*dc*dsc*dp*ic*isc*ip*in* usb:v045Bp023Cd*dc*dsc*dp*ic*isc*ip*in* usb:v0870p0001d*dc*dsc*dp*ic*isc*ip*in* usb:v17EFp7000d*dc*dsc*dp*ic*isc*ip*in* usb:v076Dp0006d*dc*dsc*dp*ic*isc*ip*in* usb:v0424p274Ed*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/class/usblp.ko.xz usb:v04B8p0202d*dc*dsc*dp*ic*isc*ip*in* usb:v*p*d*dc*dsc*dp*ic07isc01ip03in* usb:v*p*d*dc*dsc*dp*ic07isc01ip02in* usb:v*p*d*dc*dsc*dp*ic07isc01ip01in* usb:v*p*d*dc07dsc01dp03ic*isc*ip*in* usb:v*p*d*dc07dsc01dp02ic*isc*ip*in* usb:v*p*d*dc07dsc01dp01ic*isc*ip*in*

kernel/drivers/usb/class/cdc-wdm.ko.xz usb:v*p*d*dc*dsc*dp*ic02isc09ip*in* symbol:usb_cdc_wdm_register

kernel/drivers/usb/class/usbtmc.ko.xz usb:v*p*d*dc*dsc*dp*icFEisc03ip01in* usb:v*p*d*dc*dsc*dp*icFEisc03ip00in*

kernel/drivers/usb/storage/ums-realtek.ko.xz usb:v0BDAp0184d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0177d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0159d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0158d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0153d*dc*dsc*dp*ic*isc*ip*in* usb:v0BDAp0138d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-usbat.ko.xz usb:v0781p0005d0005dc*dsc*dp*ic*isc*ip*in* usb:v04E6p1010d*dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0307d0001dc*dsc*dp*ic*isc*ip*in* usb:v03F0p0207d0001dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-sddr55.ko.xz usb:v55AApA103d*dc*dsc*dp*ic*isc*ip*in* usb:v0C0BpA109d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA109d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA103d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-eneub6250.ko.xz usb:v0CF2p6250d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-sddr09.ko.xz usb:v07AFp0006d0100dc*dsc*dp*ic*isc*ip*in* usb:v0781p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v066Bp0105d0100dc*dsc*dp*ic*isc*ip*in* usb:v04E6p0005d01*dc*dsc*dp*ic*isc*ip*in* usb:v04E6p0005d020[0_8]dc*dsc*dp*ic*isc*ip*in* usb:v04E6p0003d*dc*dsc*dp*ic*isc*ip*in* usb:v0436p0005d0100dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-datafab.ko.xz usb:v0C0BpA109d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA10Bd*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA109d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA006d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA005d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA004d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA003d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA002d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA001d*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA000d000*dc*dsc*dp*ic*isc*ip*in* usb:v07C4pA000d001[0_5]dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-karma.ko.xz usb:v045Ap5210d0101dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-onetouch.ko.xz usb:v0D49p7010d*dc*dsc*dp*ic*isc*ip*in* usb:v0D49p7000d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-jumpshot.ko.xz usb:v05DCp0001d000[0_1]dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-isd200.ko.xz usb:v0BF6pA001d010*dc*dsc*dp*ic*isc*ip*in* usb:v0BF6pA001d0110dc*dsc*dp*ic*isc*ip*in* usb:v05ABp5701d010*dc*dsc*dp*ic*isc*ip*in* usb:v05ABp5701d0110dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0351d010*dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0351d0110dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0301d010*dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0301d0110dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0031d010*dc*dsc*dp*ic*isc*ip*in* usb:v05ABp0031d0110dc*dsc*dp*ic*isc*ip*in* usb:v054Cp002Bd010*dc*dsc*dp*ic*isc*ip*in* usb:v054Cp002Bd0110dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-cypress.ko.xz usb:v14CDp6116d015*dc*dsc*dp*ic*isc*ip*in* usb:v14CDp6116d0160dc*dsc*dp*ic*isc*ip*in* usb:v04B4p6831d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p6830d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-alauda.ko.xz usb:v07B4p010Ad0102dc*dsc*dp*ic*isc*ip*in* usb:v0584p0008d0102dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/storage/ums-freecom.ko.xz usb:v07ABpFC01d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/usbip/usbip-vudc.ko.xz
usbip_core

kernel/drivers/usb/usbip/usbip-core.ko.xz symbol:usbip_debug_flag symbol:dev_attr_usbip_debug symbol:usbip_dump_urb symbol:usbip_dump_header symbol:usbip_recv symbol:usbip_pack_pdu symbol:usbip_header_correct_endian symbol:usbip_alloc_iso_desc_pdu symbol:usbip_recv_iso symbol:usbip_pad_iso symbol:usbip_recv_xbuff symbol:usbip_start_eh symbol:usbip_stop_eh symbol:usbip_event_add symbol:usbip_event_happened symbol:usbip_in_eh

kernel/drivers/usb/usbip/usbip-host.ko.xz
usbip_core

kernel/drivers/usb/usbip/vhci-hcd.ko.xz
usbip_core

kernel/drivers/usb/host/xhci-pci-renesas.ko.xz pci:v00001912d00000015sv*sd*bc*sc*i* pci:v00001912d00000014sv*sd*bc*sc*i*

kernel/drivers/usb/image/mdc800.ko.xz usb:v055FpA800d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/image/microtek.ko.xz usb:v05DAp00B6d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp80ACd*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp80A3d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp00A3d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp00A0d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp009Ad*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp0099d*dc*dsc*dp*ic*isc*ip*in* usb:v05DAp0094d*dc*dsc*dp*ic*isc*ip*in* usb:v04CEp0300d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/atm/ueagle-atm.ko.xz usb:v0BAFp00F7d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F8d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F5d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F6d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F9d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00FAd*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F1d*dc*dsc*dp*ic*isc*ip*in* usb:v0BAFp00F2d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3363d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3362d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3353d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3352d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3350d*dc*dsc*dp*ic*isc*ip*in* usb:v05CCp3351d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2120d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2121d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2130d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2131d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2100d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2101d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2110d*dc*dsc*dp*ic*isc*ip*in* usb:v1039p2111d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9041d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9042d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9031d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9032d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9023d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9024d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9021d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9022d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p900Fd*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9010d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9000d*dc*dsc*dp*ic*isc*ip*in* usb:v1110p9001d*dc*dsc*dp*ic*isc*ip*in*
usbatm atm

kernel/drivers/usb/atm/usbatm.ko.xz symbol:usbatm_usb_probe symbol:usbatm_usb_disconnect
atm

kernel/drivers/usb/atm/xusbatm.ko.xz
usbatm

kernel/drivers/usb/atm/cxacru.ko.xz usb:v100Dp3342d*dc*dsc*dp*ic*isc*ip*in* usb:v100DpCB01d*dc*dsc*dp*ic*isc*ip*in* usb:v0509p0812d*dc*dsc*dp*ic*isc*ip*in* usb:v0659p0020d*dc*dsc*dp*ic*isc*ip*in* usb:v0586p330Bd*dc*dsc*dp*ic*isc*ip*in* usb:v0586p330Ad*dc*dsc*dp*ic*isc*ip*in* usb:v0675p0200d*dc*dsc*dp*ic*isc*ip*in* usb:v1803p5510d*dc*dsc*dp*ic*isc*ip*in* usb:v0EB0p3457d*dc*dsc*dp*ic*isc*ip*in* usb:v08E3p0102d*dc*dsc*dp*ic*isc*ip*in* usb:v08E3p0100d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCB07d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCB06d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCB02d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCB01d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCB00d*dc*dsc*dp*ic*isc*ip*in* usb:v0572pCAFEd*dc*dsc*dp*ic*isc*ip*in*
usbatm atm

kernel/drivers/usb/atm/speedtch.ko.xz usb:v06B9p4061d*dc*dsc*dp*ic*isc*ip*in*
usbatm atm

kernel/drivers/usb/gadget/legacy/g_ether.ko.xz
libcomposite u_ether usb_f_rndis

kernel/drivers/usb/gadget/legacy/g_midi.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_webcam.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_multi.ko.xz
libcomposite usb_f_mass_storage u_ether

kernel/drivers/usb/gadget/legacy/g_serial.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_zero.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_printer.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_hid.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_audio.ko.xz
libcomposite

kernel/drivers/usb/gadget/legacy/g_mass_storage.ko.xz
usb_f_mass_storage libcomposite

kernel/drivers/usb/gadget/legacy/g_acm_ms.ko.xz
libcomposite usb_f_mass_storage

kernel/drivers/usb/gadget/legacy/g_cdc.ko.xz
libcomposite u_ether

kernel/drivers/usb/gadget/legacy/gadgetfs.ko.xz fs_gadgetfs

kernel/drivers/usb/gadget/function/usb_f_rndis.ko.xz usbfunc:rndis symbol:rndis_borrow_net symbol:rndis_signal_connect symbol:rndis_signal_disconnect symbol:rndis_uninit symbol:rndis_set_host_mac symbol:rndis_msg_parser symbol:rndis_register symbol:rndis_deregister symbol:rndis_set_param_dev symbol:rndis_set_param_vendor symbol:rndis_set_param_medium symbol:rndis_add_hdr symbol:rndis_free_response symbol:rndis_get_next_response symbol:rndis_rm_hdr
libcomposite u_ether

kernel/drivers/usb/gadget/function/usb_f_eem.ko.xz usbfunc:eem
libcomposite u_ether

kernel/drivers/usb/gadget/function/usb_f_ecm_subset.ko.xz usbfunc:geth
libcomposite u_ether

kernel/drivers/usb/gadget/function/usb_f_uvc.ko.xz usbfunc:uvc
videobuf2_v4l2 videodev videobuf2_dma_sg libcomposite uvc videobuf2_common videobuf2_vmalloc

kernel/drivers/usb/gadget/function/usb_f_hid.ko.xz usbfunc:hid
libcomposite

kernel/drivers/usb/gadget/function/usb_f_serial.ko.xz usbfunc:gser
libcomposite u_serial

kernel/drivers/usb/gadget/function/usb_f_mass_storage.ko.xz usbfunc:mass_storage symbol:fsg_common_set_sysfs symbol:fsg_common_set_num_buffers symbol:fsg_common_remove_lun symbol:fsg_common_remove_luns symbol:fsg_common_free_buffers symbol:fsg_common_set_cdev symbol:fsg_common_create_lun symbol:fsg_common_create_luns symbol:fsg_common_set_inquiry_string symbol:fsg_config_from_params symbol:fsg_intf_desc symbol:fsg_fs_bulk_in_desc symbol:fsg_fs_bulk_out_desc symbol:fsg_fs_function symbol:fsg_hs_bulk_in_desc symbol:fsg_hs_bulk_out_desc symbol:fsg_hs_function symbol:fsg_ss_bulk_in_desc symbol:fsg_ss_bulk_in_comp_desc symbol:fsg_ss_bulk_out_desc symbol:fsg_ss_bulk_out_comp_desc symbol:fsg_ss_function symbol:fsg_lun_close symbol:fsg_lun_open symbol:fsg_lun_fsync_sub symbol:store_cdrom_address symbol:fsg_show_ro symbol:fsg_show_nofua symbol:fsg_show_file symbol:fsg_show_cdrom symbol:fsg_show_removable symbol:fsg_show_inquiry_string symbol:fsg_store_ro symbol:fsg_store_nofua symbol:fsg_store_file symbol:fsg_store_cdrom symbol:fsg_store_removable symbol:fsg_store_inquiry_string symbol:fsg_store_forced_eject
libcomposite

kernel/drivers/usb/gadget/function/usb_f_uac1.ko.xz usbfunc:uac1
u_audio libcomposite

kernel/drivers/usb/gadget/function/usb_f_midi.ko.xz usbfunc:midi
snd_rawmidi snd libcomposite

kernel/drivers/usb/gadget/function/usb_f_uac2.ko.xz usbfunc:uac2
u_audio libcomposite

kernel/drivers/usb/gadget/function/usb_f_obex.ko.xz usbfunc:obex
libcomposite u_serial

kernel/drivers/usb/gadget/function/usb_f_ecm.ko.xz usbfunc:ecm
libcomposite u_ether

kernel/drivers/usb/gadget/function/usb_f_acm.ko.xz usbfunc:acm
u_serial libcomposite

kernel/drivers/usb/gadget/function/usb_f_ss_lb.ko.xz usbfunc:Loopback usbfunc:SourceSink
libcomposite

kernel/drivers/usb/gadget/function/u_audio.ko.xz symbol:u_audio_set_capture_srate symbol:u_audio_get_capture_srate symbol:u_audio_set_playback_srate symbol:u_audio_get_playback_srate symbol:u_audio_start_capture symbol:u_audio_stop_capture symbol:u_audio_start_playback symbol:u_audio_stop_playback symbol:u_audio_suspend symbol:u_audio_get_volume symbol:u_audio_set_volume symbol:u_audio_get_mute symbol:u_audio_set_mute symbol:g_audio_setup symbol:g_audio_cleanup
snd_pcm snd libcomposite

kernel/drivers/usb/gadget/function/usb_f_fs.ko.xz usbfunc:ffs fs_functionfs symbol:ffs_lock symbol:ffs_name_dev symbol:ffs_single_dev
libcomposite

kernel/drivers/usb/gadget/function/u_ether.ko.xz symbol:gether_setup_name symbol:gether_setup_name_default symbol:gether_register_netdev symbol:gether_set_gadget symbol:gether_set_dev_addr symbol:gether_get_dev_addr symbol:gether_set_host_addr symbol:gether_get_host_addr symbol:gether_get_host_addr_cdc symbol:gether_get_host_addr_u8 symbol:gether_set_qmult symbol:gether_get_qmult symbol:gether_get_ifname symbol:gether_set_ifname symbol:gether_suspend symbol:gether_resume symbol:gether_cleanup symbol:gether_connect symbol:gether_disconnect
libcomposite

kernel/drivers/usb/gadget/function/usb_f_ncm.ko.xz usbfunc:ncm
libcomposite u_ether

kernel/drivers/usb/gadget/function/usb_f_printer.ko.xz usbfunc:printer
libcomposite

kernel/drivers/usb/gadget/function/u_serial.ko.xz symbol:gs_alloc_req symbol:gs_free_req symbol:gserial_free_line symbol:gserial_alloc_line_no_console symbol:gserial_alloc_line symbol:gserial_connect symbol:gserial_disconnect symbol:gserial_suspend symbol:gserial_resume

kernel/drivers/usb/gadget/libcomposite.ko.xz symbol:usb_gadget_get_string symbol:usb_validate_langid symbol:usb_descriptor_fillbuf symbol:usb_gadget_config_buf symbol:usb_copy_descriptors symbol:usb_assign_descriptors symbol:usb_free_all_descriptors symbol:usb_otg_descriptor_alloc symbol:usb_otg_descriptor_init symbol:usb_ep_autoconfig_ss symbol:usb_ep_autoconfig symbol:usb_ep_autoconfig_release symbol:usb_ep_autoconfig_reset symbol:config_ep_by_speed_and_alt symbol:config_ep_by_speed symbol:usb_add_function symbol:usb_remove_function symbol:usb_function_deactivate symbol:usb_function_activate symbol:usb_interface_id symbol:usb_func_wakeup symbol:usb_add_config_only symbol:usb_add_config symbol:usb_string_id symbol:usb_string_ids_tab symbol:usb_gstrings_attach symbol:usb_string_ids_n symbol:usb_composite_probe symbol:usb_composite_unregister symbol:usb_composite_setup_continue symbol:usb_composite_overwrite_options symbol:usb_get_function_instance symbol:usb_get_function symbol:usb_put_function_instance symbol:usb_put_function symbol:usb_function_register symbol:usb_function_unregister symbol:usb_os_desc_prepare_interf_dir symbol:unregister_gadget_item symbol:alloc_ep_req

kernel/drivers/usb/misc/cypress_cy7c63.ko.xz usb:v0A2Cp0008d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/idmouse.ko.xz usb:v0681p0010d*dc*dsc*dp*ic*isc*ip*in* usb:v0681p0005d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/ldusb.ko.xz usb:v0F11p20A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2090d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2080d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2070d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2060d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2051d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2050d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2040d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2030d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2020d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2010d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p2000d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1210d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1200d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1101d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1100d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p10B0d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p10A0d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1090d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1081d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1080d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1043d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1042d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1040d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1038d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1035d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1033d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1032d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1031d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1021d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1020d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1011d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1010d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1001d*dc*dsc*dp*ic*isc*ip*in* usb:v0F11p1000d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/trancevibrator.ko.xz usb:v0B49p064Fd*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/emi62.ko.xz usb:v086Ap0110d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/yurex.ko.xz usb:v0C45p1010d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/legousbtower.ko.xz usb:v0694p0001d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/adutux.ko.xz usb:v0A07p00DAd*dc*dsc*dp*ic*isc*ip*in* usb:v0A07p00D0d*dc*dsc*dp*ic*isc*ip*in* usb:v0A07p00C8d*dc*dsc*dp*ic*isc*ip*in* usb:v0A07p0082d*dc*dsc*dp*ic*isc*ip*in* usb:v0A07p0078d*dc*dsc*dp*ic*isc*ip*in* usb:v0A07p0064d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/iowarrior.ko.xz usb:v07C0p1506d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1505d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1504d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p158Bd*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p158Ad*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1503d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1512d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1511d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1501d*dc*dsc*dp*ic*isc*ip*in* usb:v07C0p1500d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/ezusb.ko.xz symbol:ezusb_fx1_set_reset symbol:ezusb_fx1_ihex_firmware_download

kernel/drivers/usb/misc/cytherm.ko.xz usb:v04B4p0002d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/isight_firmware.ko.xz usb:v05ACp8300d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/usblcd.ko.xz usb:v10D2p*d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/emi26.ko.xz usb:v086Ap0102d*dc*dsc*dp*ic*isc*ip*in* usb:v086Ap0100d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/appledisplay.ko.xz usb:v05ACp9236d*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp9226d*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp9222d*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp921Dd*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp921Cd*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp9219d*dc*dsc*dp*ic03isc*ip00in* usb:v05ACp9218d*dc*dsc*dp*ic03isc*ip00in*
backlight

kernel/drivers/usb/misc/usbtest.ko.xz usb:v0525pA4A3d*dc*dsc*dp*ic*isc*ip*in* usb:v0525pA4A4d*dc*dsc*dp*ic*isc*ip*in* usb:v0525pA4A0d*dc*dsc*dp*ic*isc*ip*in* usb:vFFF0pFFF0d*dc*dsc*dp*ic*isc*ip*in* usb:v04B4p8613d*dc*dsc*dp*ic*isc*ip*in* usb:v0547p0080d*dc*dsc*dp*ic*isc*ip*in* usb:v0547p2235d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/usb/misc/usbsevseg.ko.xz usb:v0FC5p1227d*dc*dsc*dp*ic*isc*ip*in*

kernel/drivers/tty/serial/rpi-fw-uart.ko.xz of:N*T*Craspberrypi,firmware_uartC* of:N*T*Craspberrypi,firmware_uart

kernel/drivers/tty/serial/sc16is7xx_i2c.ko.xz i2c:sc16is762 i2c:sc16is760 i2c:sc16is752 i2c:sc16is750 i2c:sc16is741 i2c:sc16is740 i2c:sc16is74x
sc16is7xx regmap_i2c

kernel/drivers/tty/serial/sc16is7xx_spi.ko.xz spi:sc16is762 spi:sc16is760 spi:sc16is752 spi:sc16is750 spi:sc16is741 spi:sc16is740 spi:sc16is74x
sc16is7xx regmap_spi

kernel/drivers/tty/serial/sc16is7xx.ko.xz of:N*T*Cnxp,sc16is762C* of:N*T*Cnxp,sc16is762 of:N*T*Cnxp,sc16is760C* of:N*T*Cnxp,sc16is760 of:N*T*Cnxp,sc16is752C* of:N*T*Cnxp,sc16is752 of:N*T*Cnxp,sc16is750C* of:N*T*Cnxp,sc16is750 of:N*T*Cnxp,sc16is741C* of:N*T*Cnxp,sc16is741 of:N*T*Cnxp,sc16is740C* of:N*T*Cnxp,sc16is740 symbol:sc16is74x_devtype symbol:sc16is750_devtype symbol:sc16is752_devtype symbol:sc16is760_devtype symbol:sc16is762_devtype symbol:sc16is7xx_probe symbol:sc16is7xx_remove symbol:sc16is7xx_dt_ids symbol:sc16is7xx_regcfg symbol:sc16is7xx_regmap_name symbol:sc16is7xx_regmap_port_mask

kernel/drivers/firmware/rp1-fw.ko.xz of:N*T*Craspberrypi,rp1_firmwareC* of:N*T*Craspberrypi,rp1_firmware symbol:rp1_firmware_message symbol:rp1_firmware_put symbol:rp1_firmware_get_feature symbol:rp1_firmware_get symbol:devm_rp1_firmware_get

kernel/drivers/firmware/cirrus/cs_dsp.ko.xz symbol:cs_dsp_mem_region_name symbol:cs_dsp_init_debugfs symbol:cs_dsp_cleanup_debugfs symbol:cs_dsp_coeff_write_acked_control symbol:cs_dsp_coeff_write_ctrl symbol:cs_dsp_coeff_lock_and_write_ctrl symbol:cs_dsp_coeff_read_ctrl symbol:cs_dsp_coeff_lock_and_read_ctrl symbol:cs_dsp_get_ctl symbol:cs_dsp_find_alg_region symbol:cs_dsp_adsp1_init symbol:cs_dsp_adsp1_power_up symbol:cs_dsp_adsp1_power_down symbol:cs_dsp_set_dspclk symbol:cs_dsp_power_up symbol:cs_dsp_power_down symbol:cs_dsp_run symbol:cs_dsp_stop symbol:cs_dsp_adsp2_init symbol:cs_dsp_halo_init symbol:cs_dsp_remove symbol:cs_dsp_read_raw_data_block symbol:cs_dsp_read_data_word symbol:cs_dsp_write_data_word symbol:cs_dsp_remove_padding symbol:cs_dsp_adsp2_bus_error symbol:cs_dsp_halo_bus_error symbol:cs_dsp_halo_wdt_expire symbol:cs_dsp_chunk_write symbol:cs_dsp_chunk_flush symbol:cs_dsp_chunk_read symbol:cs_dsp_wseq_init symbol:cs_dsp_wseq_write symbol:cs_dsp_wseq_multi_write

kernel/drivers/pwm/pwm-pio-rp1.ko.xz of:N*T*Craspberrypi,pwm_pio_rp1C* of:N*T*Craspberrypi,pwm_pio_rp1
rp1_pio

kernel/drivers/pwm/pwm-pca9685.ko.xz i2c:pca9685 of:N*T*Cnxp,pca9685_pwmC* of:N*T*Cnxp,pca9685_pwm
regmap_i2c

kernel/drivers/pwm/pwm-bcm2835.ko.xz of:N*T*Cbrcm,bcm2835_pwmC* of:N*T*Cbrcm,bcm2835_pwm

kernel/drivers/pwm/pwm-raspberrypi-poe.ko.xz of:N*T*Craspberrypi,poe_pwmC* of:N*T*Craspberrypi,poe_pwm of:N*T*Craspberrypi,firmware_poe_pwmC* of:N*T*Craspberrypi,firmware_poe_pwm

kernel/drivers/pwm/pwm-gpio.ko.xz of:N*T*Cpwm_gpioC* of:N*T*Cpwm_gpio

kernel/drivers/misc/rp1-pio.ko.xz of:N*T*Craspberrypi,rp1_pioC* of:N*T*Craspberrypi,rp1_pio symbol:rp1_pio_can_add_program symbol:rp1_pio_add_program symbol:rp1_pio_remove_program symbol:rp1_pio_clear_instr_mem symbol:rp1_pio_sm_claim symbol:rp1_pio_sm_unclaim symbol:rp1_pio_sm_is_claimed symbol:rp1_pio_sm_init symbol:rp1_pio_sm_set_config symbol:rp1_pio_sm_exec symbol:rp1_pio_sm_clear_fifos symbol:rp1_pio_sm_set_clkdiv symbol:rp1_pio_sm_set_pins symbol:rp1_pio_sm_set_pindirs symbol:rp1_pio_sm_set_enabled symbol:rp1_pio_sm_restart symbol:rp1_pio_sm_clkdiv_restart symbol:rp1_pio_sm_enable_sync symbol:rp1_pio_sm_put symbol:rp1_pio_sm_get symbol:rp1_pio_sm_set_dmactrl symbol:rp1_pio_sm_fifo_state symbol:rp1_pio_sm_drain_tx symbol:rp1_pio_gpio_init symbol:rp1_pio_gpio_set_function symbol:rp1_pio_gpio_set_pulls symbol:rp1_pio_gpio_set_outover symbol:rp1_pio_gpio_set_inover symbol:rp1_pio_gpio_set_oeover symbol:rp1_pio_gpio_set_input_enabled symbol:rp1_pio_gpio_set_drive_strength symbol:rp1_pio_sm_config_xfer symbol:rp1_pio_sm_xfer_data symbol:rp1_pio_open symbol:rp1_pio_close symbol:rp1_pio_set_error symbol:rp1_pio_get_error symbol:rp1_pio_clear_error
rp1_fw

kernel/drivers/misc/bcm2835_smi.ko.xz platform:smi_bcm2835 of:N*T*Cbrcm,bcm2835_smiC* of:N*T*Cbrcm,bcm2835_smi symbol:bcm2835_smi_set_regs_from_settings symbol:bcm2835_smi_get_settings_from_regs symbol:bcm2835_smi_user_dma symbol:bcm2835_smi_write_buf symbol:bcm2835_smi_read_buf symbol:bcm2835_smi_set_address symbol:bcm2835_smi_get

kernel/drivers/misc/eeprom/eeprom_93cx6.ko.xz symbol:eeprom_93cx6_read symbol:eeprom_93cx6_multiread symbol:eeprom_93cx6_readb symbol:eeprom_93cx6_multireadb symbol:eeprom_93cx6_wren symbol:eeprom_93cx6_write

kernel/drivers/misc/eeprom/at24.ko.xz i2c:at24 i2c:24c2048 i2c:24c1025 i2c:24c1024 i2c:24c512 i2c:24c256 i2c:24c128 i2c:24cs64 i2c:24c64_wl i2c:24c64 i2c:24cs32 i2c:24c32d_wl i2c:24c32 i2c:24cs16 i2c:24c16 i2c:24cs08 i2c:24c08 i2c:24cs04 i2c:24c04 i2c:24c02_vaio i2c:spd i2c:24aa025e64 i2c:24aa025e48 i2c:24mac602 i2c:24mac402 i2c:24cs02 i2c:24c02 i2c:24cs01 i2c:24c01 i2c:24c00 of:N*T*Cmicrochip,24aa025e64C* of:N*T*Cmicrochip,24aa025e64 of:N*T*Cmicrochip,24aa025e48C* of:N*T*Cmicrochip,24aa025e48 of:N*T*Catmel,24c2048C* of:N*T*Catmel,24c2048 of:N*T*Catmel,24c1025C* of:N*T*Catmel,24c1025 of:N*T*Catmel,24c1024C* of:N*T*Catmel,24c1024 of:N*T*Catmel,24c512C* of:N*T*Catmel,24c512 of:N*T*Catmel,24c256C* of:N*T*Catmel,24c256 of:N*T*Catmel,24c128C* of:N*T*Catmel,24c128 of:N*T*Catmel,24cs64C* of:N*T*Catmel,24cs64 of:N*T*Catmel,24c64d_wlC* of:N*T*Catmel,24c64d_wl of:N*T*Catmel,24c64C* of:N*T*Catmel,24c64 of:N*T*Catmel,24cs32C* of:N*T*Catmel,24cs32 of:N*T*Catmel,24c32d_wlC* of:N*T*Catmel,24c32d_wl of:N*T*Catmel,24c32C* of:N*T*Catmel,24c32 of:N*T*Catmel,24cs16C* of:N*T*Catmel,24cs16 of:N*T*Catmel,24c16C* of:N*T*Catmel,24c16 of:N*T*Catmel,24cs08C* of:N*T*Catmel,24cs08 of:N*T*Catmel,24c08C* of:N*T*Catmel,24c08 of:N*T*Catmel,24cs04C* of:N*T*Catmel,24cs04 of:N*T*Catmel,24c04C* of:N*T*Catmel,24c04 of:N*T*Catmel,spdC* of:N*T*Catmel,spd of:N*T*Catmel,24mac602C* of:N*T*Catmel,24mac602 of:N*T*Catmel,24mac402C* of:N*T*Catmel,24mac402 of:N*T*Catmel,24cs02C* of:N*T*Catmel,24cs02 of:N*T*Catmel,24c02C* of:N*T*Catmel,24c02 of:N*T*Catmel,24cs01C* of:N*T*Catmel,24cs01 of:N*T*Catmel,24c01C* of:N*T*Catmel,24c01 of:N*T*Catmel,24c00C* of:N*T*Catmel,24c00 acpi*:TPF0001:* acpi*:INT3499:*
regmap_i2c

kernel/drivers/misc/eeprom/at25.ko.xz of:N*T*Ccypress,fm25C* of:N*T*Ccypress,fm25 of:N*T*Catmel,at25C* of:N*T*Catmel,at25 spi:fm25 spi:at25

kernel/drivers/misc/ti-st/st_drv.ko.xz symbol:st_register symbol:st_unregister

kernel/drivers/misc/ws2812-pio-rp1.ko.xz of:N*T*Craspberrypi,ws2812_pio_rp1C* of:N*T*Craspberrypi,ws2812_pio_rp1
rp1_pio

kernel/drivers/rtc/rtc-s35390a.ko.xz i2c:s35390a of:N*T*Csii,s35390aC* of:N*T*Csii,s35390a

kernel/drivers/rtc/rtc-rx8025.ko.xz i2c:rx8035 i2c:rx8025

kernel/drivers/rtc/rtc-pcf85063.ko.xz i2c:rv8263 i2c:pcf85063a i2c:pcf85063tp i2c:pcf85063 i2c:pca85073a of:N*T*Cmicrocrystal,rv8263C* of:N*T*Cmicrocrystal,rv8263 of:N*T*Cnxp,pcf85063aC* of:N*T*Cnxp,pcf85063a of:N*T*Cnxp,pcf85063tpC* of:N*T*Cnxp,pcf85063tp of:N*T*Cnxp,pcf85063C* of:N*T*Cnxp,pcf85063 of:N*T*Cnxp,pca85073aC* of:N*T*Cnxp,pca85073a
regmap_i2c

kernel/drivers/rtc/rtc-pcf8523.ko.xz i2c:pcf8523 of:N*T*Cmicrocrystal,rv8523C* of:N*T*Cmicrocrystal,rv8523 of:N*T*Cnxp,pcf8523C* of:N*T*Cnxp,pcf8523
regmap_i2c

kernel/drivers/rtc/rtc-ds1302.ko.xz of:N*T*Cmaxim,ds1302C* of:N*T*Cmaxim,ds1302 spi:ds1302

kernel/drivers/rtc/rtc-rv3032.ko.xz acpi*:MCRY3032:* of:N*T*Cmicrocrystal,rv3032C* of:N*T*Cmicrocrystal,rv3032
regmap_i2c

kernel/drivers/rtc/rtc-ds1390.ko.xz spi:rtc_ds1390 of:N*T*Cdallas,ds1390C* of:N*T*Cdallas,ds1390 spi:ds1390

kernel/drivers/rtc/rtc-rs5c348.ko.xz spi:rtc_rs5c348

kernel/drivers/rtc/rtc-max6900.ko.xz i2c:max6900

kernel/drivers/rtc/rtc-x1205.ko.xz i2c:x1205 of:N*T*Cxicor,x1205C* of:N*T*Cxicor,x1205

kernel/drivers/rtc/rtc-ds1672.ko.xz i2c:ds1672 of:N*T*Cdallas,ds1672C* of:N*T*Cdallas,ds1672

kernel/drivers/rtc/rtc-em3027.ko.xz i2c:em3027 of:N*T*Cemmicro,em3027C* of:N*T*Cemmicro,em3027

kernel/drivers/rtc/rtc-rs5c372.ko.xz i2c:rv5c387a i2c:rv5c386 i2c:rs5c372b i2c:rs5c372a i2c:r2221tl i2c:r2025sd of:N*T*Cricoh,rv5c387aC* of:N*T*Cricoh,rv5c387a of:N*T*Cricoh,rv5c386C* of:N*T*Cricoh,rv5c386 of:N*T*Cricoh,rs5c372bC* of:N*T*Cricoh,rs5c372b of:N*T*Cricoh,rs5c372aC* of:N*T*Cricoh,rs5c372a of:N*T*Cricoh,r2221tlC* of:N*T*Cricoh,r2221tl of:N*T*Cricoh,r2025sdC* of:N*T*Cricoh,r2025sd

kernel/drivers/rtc/rtc-pcf8583.ko.xz i2c:pcf8583

kernel/drivers/rtc/rtc-isl1208.ko.xz i2c:raa215300_a0 i2c:isl1219 i2c:isl1218 i2c:isl1209 i2c:isl1208 of:N*T*Cisil,isl1219C* of:N*T*Cisil,isl1219 of:N*T*Cisil,isl1218C* of:N*T*Cisil,isl1218 of:N*T*Cisil,isl1209C* of:N*T*Cisil,isl1209 of:N*T*Cisil,isl1208C* of:N*T*Cisil,isl1208

kernel/drivers/rtc/rtc-pcf8563.ko.xz i2c:pca8565 i2c:rtc8564 i2c:pcf8563 of:N*T*Cnxp,pca8565C* of:N*T*Cnxp,pca8565 of:N*T*Cmicrocrystal,rv8564C* of:N*T*Cmicrocrystal,rv8564 of:N*T*Cepson,rtc8564C* of:N*T*Cepson,rtc8564 of:N*T*Cnxp,pcf8563C* of:N*T*Cnxp,pcf8563

kernel/drivers/rtc/rtc-rx8581.ko.xz i2c:rx8581 of:N*T*Cepson,rx8581C* of:N*T*Cepson,rx8581 of:N*T*Cepson,rx8571C* of:N*T*Cepson,rx8571
regmap_i2c

kernel/drivers/rtc/rtc-pcf2123.ko.xz spi:rtc_pcf2123 of:N*T*Cnxp,rtc_pcf2123C* of:N*T*Cnxp,rtc_pcf2123 of:N*T*Cmicrocrystal,rv2123C* of:N*T*Cmicrocrystal,rv2123 of:N*T*Cnxp,pcf2123C* of:N*T*Cnxp,pcf2123 spi:rv2123 spi:pcf2123
regmap_spi

kernel/drivers/rtc/rtc-pcf85363.ko.xz of:N*T*Cnxp,pcf85363C* of:N*T*Cnxp,pcf85363 of:N*T*Cnxp,pcf85263C* of:N*T*Cnxp,pcf85263
regmap_i2c

kernel/drivers/rtc/rtc-m41t93.ko.xz spi:rtc_m41t93

kernel/drivers/rtc/rtc-abx80x.ko.xz i2c:rv1805 i2c:ab1805 i2c:ab1804 i2c:ab1803 i2c:ab1801 i2c:ab0805 i2c:ab0804 i2c:ab0803 i2c:ab0801 i2c:abx80x of:N*T*Cmicrocrystal,rv1805C* of:N*T*Cmicrocrystal,rv1805 of:N*T*Cabracon,ab1805C* of:N*T*Cabracon,ab1805 of:N*T*Cabracon,ab1804C* of:N*T*Cabracon,ab1804 of:N*T*Cabracon,ab1803C* of:N*T*Cabracon,ab1803 of:N*T*Cabracon,ab1801C* of:N*T*Cabracon,ab1801 of:N*T*Cabracon,ab0805C* of:N*T*Cabracon,ab0805 of:N*T*Cabracon,ab0804C* of:N*T*Cabracon,ab0804 of:N*T*Cabracon,ab0803C* of:N*T*Cabracon,ab0803 of:N*T*Cabracon,ab0801C* of:N*T*Cabracon,ab0801 of:N*T*Cabracon,abx80xC* of:N*T*Cabracon,abx80x

kernel/drivers/rtc/rtc-ds1307.ko.xz i2c:rx8130 i2c:isl12057 i2c:rx8025 i2c:pt7c4338 i2c:mcp7941x i2c:mcp7940x i2c:m41t11 i2c:m41t00 i2c:m41t0 i2c:ds3231 i2c:ds1341 i2c:ds1340 i2c:ds1388 i2c:ds1339 i2c:ds1338 i2c:ds1337 i2c:ds1308 i2c:ds1307 of:N*T*Cepson,rx8130C* of:N*T*Cepson,rx8130 of:N*T*Cisil,isl12057C* of:N*T*Cisil,isl12057 of:N*T*Cepson,rx8025C* of:N*T*Cepson,rx8025 of:N*T*Cpericom,pt7c4338C* of:N*T*Cpericom,pt7c4338 of:N*T*Cmicrochip,mcp7941xC* of:N*T*Cmicrochip,mcp7941x of:N*T*Cmicrochip,mcp7940xC* of:N*T*Cmicrochip,mcp7940x of:N*T*Cst,m41t11C* of:N*T*Cst,m41t11 of:N*T*Cst,m41t00C* of:N*T*Cst,m41t00 of:N*T*Cst,m41t0C* of:N*T*Cst,m41t0 of:N*T*Cmaxim,ds3231C* of:N*T*Cmaxim,ds3231 of:N*T*Cdallas,ds1341C* of:N*T*Cdallas,ds1341 of:N*T*Cdallas,ds1340C* of:N*T*Cdallas,ds1340 of:N*T*Cdallas,ds1388C* of:N*T*Cdallas,ds1388 of:N*T*Cdallas,ds1339C* of:N*T*Cdallas,ds1339 of:N*T*Cdallas,ds1338C* of:N*T*Cdallas,ds1338 of:N*T*Cdallas,ds1337C* of:N*T*Cdallas,ds1337 of:N*T*Cdallas,ds1308C* of:N*T*Cdallas,ds1308 of:N*T*Cdallas,ds1307C* of:N*T*Cdallas,ds1307
regmap_i2c

kernel/drivers/rtc/rtc-r9701.ko.xz spi:rtc_r9701

kernel/drivers/rtc/rtc-rx4581.ko.xz spi:rtc_rx4581 spi:rx4581

kernel/drivers/rtc/rtc-sd3078.ko.xz i2c:sd3078 of:N*T*Cwhwave,sd3078C* of:N*T*Cwhwave,sd3078
regmap_i2c

kernel/drivers/rtc/rtc-isl12022.ko.xz of:N*T*Cisil,isl12022C* of:N*T*Cisil,isl12022 of:N*T*Cisl,isl12022C* of:N*T*Cisl,isl12022 i2c:isl12022
regmap_i2c

kernel/drivers/rtc/rtc-ds1374.ko.xz i2c:ds1374 of:N*T*Cdallas,ds1374C* of:N*T*Cdallas,ds1374

kernel/drivers/rtc/rtc-bq32k.ko.xz i2c:bq32000 of:N*T*Cti,bq32000C* of:N*T*Cti,bq32000

kernel/drivers/rtc/rtc-max6902.ko.xz spi:rtc_max6902

kernel/drivers/rtc/rtc-rv3029c2.ko.xz spi:rv3049 i2c:rv3029c2 i2c:rv3029 of:N*T*Cmicrocrystal,rv3029C* of:N*T*Cmicrocrystal,rv3029
regmap_i2c regmap_spi

kernel/drivers/rtc/rtc-rv8803.ko.xz i2c:rx8900 i2c:rx8803 i2c:rv8804 i2c:rv8803 of:N*T*Cepson,rx8900C* of:N*T*Cepson,rx8900 of:N*T*Cepson,rx8804C* of:N*T*Cepson,rx8804 of:N*T*Cepson,rx8803C* of:N*T*Cepson,rx8803 of:N*T*Cmicrocrystal,rv8803C* of:N*T*Cmicrocrystal,rv8803

kernel/drivers/rtc/rtc-rv3028.ko.xz acpi*:MCRY3028:* of:N*T*Cmicrocrystal,rv3028C* of:N*T*Cmicrocrystal,rv3028 i2c:rv3028
regmap_i2c

kernel/drivers/rtc/rtc-pcf2127.ko.xz of:N*T*Cnxp,pcf2131C* of:N*T*Cnxp,pcf2131 of:N*T*Cnxp,pca2129C* of:N*T*Cnxp,pca2129 of:N*T*Cnxp,pcf2129C* of:N*T*Cnxp,pcf2129 of:N*T*Cnxp,pcf2127C* of:N*T*Cnxp,pcf2127 i2c:pcf2131 i2c:pca2129 i2c:pcf2129 i2c:pcf2127 spi:pcf2131 spi:pca2129 spi:pcf2129 spi:pcf2127
regmap_spi

kernel/drivers/rtc/rtc-m41t94.ko.xz spi:rtc_m41t94

kernel/drivers/rtc/rtc-fm3130.ko.xz i2c:fm3130

kernel/drivers/rtc/rtc-ds3232.ko.xz spi:ds3234 i2c:ds3232 of:N*T*Cdallas,ds3232C* of:N*T*Cdallas,ds3232 of:N*T*Cdallas,ds3234C* of:N*T*Cdallas,ds3234
regmap_i2c regmap_spi

kernel/drivers/rtc/rtc-ds1305.ko.xz spi:rtc_ds1305

kernel/drivers/rtc/rtc-m41t80.ko.xz i2c:rv4162 i2c:m41st87 i2c:m41st85 i2c:m41st84 i2c:m41t83 i2c:m41t82 i2c:m41t81s i2c:m41t81 i2c:m41t80 i2c:m41t65 i2c:m41t62 of:N*T*Crv4162C* of:N*T*Crv4162 of:N*T*Cst,rv4162C* of:N*T*Cst,rv4162 of:N*T*Cmicrocrystal,rv4162C* of:N*T*Cmicrocrystal,rv4162 of:N*T*Cst,m41t87C* of:N*T*Cst,m41t87 of:N*T*Cst,m41t85C* of:N*T*Cst,m41t85 of:N*T*Cst,m41t84C* of:N*T*Cst,m41t84 of:N*T*Cst,m41t83C* of:N*T*Cst,m41t83 of:N*T*Cst,m41t82C* of:N*T*Cst,m41t82 of:N*T*Cst,m41t81sC* of:N*T*Cst,m41t81s of:N*T*Cst,m41t81C* of:N*T*Cst,m41t81 of:N*T*Cst,m41t80C* of:N*T*Cst,m41t80 of:N*T*Cst,m41t65C* of:N*T*Cst,m41t65 of:N*T*Cst,m41t62C* of:N*T*Cst,m41t62

kernel/drivers/pinctrl/pinctrl-mcp23s08.ko.xz symbol:mcp23x08_regmap symbol:mcp23x17_regmap symbol:mcp23s08_probe_one

kernel/drivers/pinctrl/pinctrl-mcp23s08_i2c.ko.xz i2c:mcp23018 i2c:mcp23017 i2c:mcp23008 of:N*T*Cmcp,mcp23017C* of:N*T*Cmcp,mcp23017 of:N*T*Cmcp,mcp23008C* of:N*T*Cmcp,mcp23008 of:N*T*Cmicrochip,mcp23018C* of:N*T*Cmicrochip,mcp23018 of:N*T*Cmicrochip,mcp23017C* of:N*T*Cmicrochip,mcp23017 of:N*T*Cmicrochip,mcp23008C* of:N*T*Cmicrochip,mcp23008
regmap_i2c pinctrl_mcp23s08

kernel/drivers/pinctrl/pinctrl-mcp23s08_spi.ko.xz spi:mcp23s18 spi:mcp23s17 spi:mcp23s08 of:N*T*Cmcp,mcp23s17C* of:N*T*Cmcp,mcp23s17 of:N*T*Cmcp,mcp23s08C* of:N*T*Cmcp,mcp23s08 of:N*T*Cmicrochip,mcp23s18C* of:N*T*Cmicrochip,mcp23s18 of:N*T*Cmicrochip,mcp23s17C* of:N*T*Cmicrochip,mcp23s17 of:N*T*Cmicrochip,mcp23s08C* of:N*T*Cmicrochip,mcp23s08
pinctrl_mcp23s08

kernel/drivers/mtd/spi-nor/spi-nor.ko.xz of:N*T*Cjedec,spi_norC* of:N*T*Cjedec,spi_nor spi:mr25h40 spi:mr25h10 spi:mr25h256 spi:mr25h128 spi:m25p128_nonjedec spi:m25p64_nonjedec spi:m25p32_nonjedec spi:m25p16_nonjedec spi:m25p80_nonjedec spi:m25p40_nonjedec spi:m25p20_nonjedec spi:m25p10_nonjedec spi:m25p05_nonjedec spi:w25q256 spi:w25q128 spi:w25q80bl spi:w25q32dw spi:w25q32 spi:w25x32 spi:w25x80 spi:m25p128 spi:m25p64 spi:m25p32 spi:m25p16 spi:m25p80 spi:m25p40 spi:sst25wf040 spi:sst25vf032b spi:sst25vf016b spi:sst25vf040b spi:s25fl064k spi:s25fl008k spi:s25sl12801 spi:s25fl512s spi:s25fl256s1 spi:n25q512a spi:n25q128a13 spi:n25q128a11 spi:n25q064 spi:mx66l51235l spi:mx25l25635e spi:mx25l12805d spi:mx25l6405d spi:mx25l1606e spi:mx25l4005a spi:at26df081a spi:at25df641 spi:at25df321a spi:m25px64 spi:m25p10 spi:w25x16 spi:s25sl064a spi:spi_nor symbol:spi_nor_scan
mtd

kernel/drivers/mtd/ubi/ubi.ko.xz symbol:ubi_do_get_device_info symbol:ubi_get_device_info symbol:ubi_get_volume_info symbol:ubi_open_volume symbol:ubi_open_volume_nm symbol:ubi_open_volume_path symbol:ubi_close_volume symbol:ubi_leb_read symbol:ubi_leb_read_sg symbol:ubi_leb_write symbol:ubi_leb_change symbol:ubi_leb_erase symbol:ubi_leb_unmap symbol:ubi_leb_map symbol:ubi_is_mapped symbol:ubi_sync symbol:ubi_flush symbol:ubi_register_volume_notifier symbol:ubi_unregister_volume_notifier
mtd

kernel/drivers/mtd/chips/chipreg.ko.xz symbol:register_mtd_chip_driver symbol:unregister_mtd_chip_driver symbol:do_map_probe symbol:map_destroy

kernel/drivers/mtd/parsers/ofpart.ko.xz ofoldpart fixed_partitions of:N*T*Clinksys,ns_partitionsC* of:N*T*Clinksys,ns_partitions of:N*T*Cbrcm,bcm4908_partitionsC* of:N*T*Cbrcm,bcm4908_partitions of:N*T*Cfixed_partitionsC* of:N*T*Cfixed_partitions
mtd

kernel/drivers/mtd/mtd.ko.xz char_major_90_* symbol:mtd_table_mutex symbol:__mtd_next_device symbol:mtd_check_expert_analysis_mode symbol:mtd_wunit_to_pairing_info symbol:mtd_pairing_info_to_wunit symbol:mtd_pairing_groups symbol:mtd_device_parse_register symbol:mtd_device_unregister symbol:register_mtd_user symbol:unregister_mtd_user symbol:get_mtd_device symbol:__get_mtd_device symbol:of_get_mtd_device_by_node symbol:get_mtd_device_nm symbol:put_mtd_device symbol:__put_mtd_device symbol:mtd_erase symbol:mtd_point symbol:mtd_unpoint symbol:mtd_get_unmapped_area symbol:mtd_read symbol:mtd_write symbol:mtd_panic_write symbol:mtd_read_oob symbol:mtd_write_oob symbol:mtd_ooblayout_ecc symbol:mtd_ooblayout_free symbol:mtd_ooblayout_find_eccregion symbol:mtd_ooblayout_get_eccbytes symbol:mtd_ooblayout_set_eccbytes symbol:mtd_ooblayout_get_databytes symbol:mtd_ooblayout_set_databytes symbol:mtd_ooblayout_count_freebytes symbol:mtd_ooblayout_count_eccbytes symbol:mtd_get_fact_prot_info symbol:mtd_read_fact_prot_reg symbol:mtd_get_user_prot_info symbol:mtd_read_user_prot_reg symbol:mtd_write_user_prot_reg symbol:mtd_lock_user_prot_reg symbol:mtd_erase_user_prot_reg symbol:mtd_lock symbol:mtd_unlock symbol:mtd_is_locked symbol:mtd_block_isreserved symbol:mtd_block_isbad symbol:mtd_block_markbad symbol:mtd_writev symbol:mtd_kmalloc_up_to symbol:get_tree_mtd symbol:kill_mtd_super symbol:mtd_concat_create symbol:mtd_concat_destroy symbol:mtd_add_partition symbol:mtd_del_partition symbol:__register_mtd_parser symbol:deregister_mtd_parser symbol:mtd_get_device_size

kernel/drivers/mtd/mtdblock.ko.xz
mtd_blkdevs mtd

kernel/drivers/mtd/mtd_blkdevs.ko.xz symbol:mtd_blktrans_cease_background symbol:register_mtd_blktrans symbol:deregister_mtd_blktrans symbol:add_mtd_blktrans_dev symbol:del_mtd_blktrans_dev
mtd

kernel/drivers/mtd/nand/spi/spinand.ko.xz of:N*T*Cspi_nandC* of:N*T*Cspi_nand spi:spi_nand
mtd nandcore

kernel/drivers/mtd/nand/nandcore.ko.xz symbol:nanddev_isbad symbol:nanddev_markbad symbol:nanddev_isreserved symbol:nanddev_mtd_erase symbol:nanddev_mtd_max_bad_blocks symbol:nanddev_ecc_engine_init symbol:nanddev_ecc_engine_cleanup symbol:nanddev_init symbol:nanddev_cleanup symbol:nanddev_bbt_init symbol:nanddev_bbt_cleanup symbol:nanddev_bbt_update symbol:nanddev_bbt_get_block_status symbol:nanddev_bbt_set_block_status symbol:nand_ecc_init_ctx symbol:nand_ecc_cleanup_ctx symbol:nand_ecc_prepare_io_req symbol:nand_ecc_finish_io_req symbol:nand_get_small_page_ooblayout symbol:nand_get_large_page_ooblayout symbol:nand_get_large_page_hamming_ooblayout symbol:of_get_nand_ecc_user_config symbol:nand_ecc_is_strong_enough symbol:nand_ecc_init_req_tweaking symbol:nand_ecc_cleanup_req_tweaking symbol:nand_ecc_tweak_req symbol:nand_ecc_restore_req symbol:nand_ecc_get_sw_engine symbol:nand_ecc_get_on_die_hw_engine symbol:nand_ecc_register_on_host_hw_engine symbol:nand_ecc_unregister_on_host_hw_engine symbol:nand_ecc_get_on_host_hw_engine symbol:nand_ecc_put_on_host_hw_engine
mtd

kernel/drivers/mtd/devices/block2mtd.ko.xz
mtd

kernel/drivers/bcma/bcma.ko.xz pci:v000014E4d0000A8DCsv*sd*bc*sc*i* pci:v000014E4d0000A8DBsv*sd*bc*sc*i* pci:v000014E4d00004727sv*sd*bc*sc*i* pci:v000014E4d000043B1sv*sd*bc*sc*i* pci:v000014E4d000043AAsv*sd*bc*sc*i* pci:v000014E4d000043A9sv*sd*bc*sc*i* pci:v000014E4d000043A0sv*sd*bc*sc*i* pci:v000014E4d00004365sv0000103Csd0000804Abc*sc*i* pci:v000014E4d00004365sv0000105Bsd0000E092bc*sc*i* pci:v000014E4d00004365sv00001028sd00000018bc*sc*i* pci:v000014E4d00004365sv00001028sd00000016bc*sc*i* pci:v000014E4d00004360sv*sd*bc*sc*i* pci:v000014E4d00004359sv*sd*bc*sc*i* pci:v000014E4d00004358sv*sd*bc*sc*i* pci:v000014E4d00004357sv*sd*bc*sc*i* pci:v000014E4d00004353sv*sd*bc*sc*i* pci:v000014E4d00004331sv*sd*bc*sc*i* pci:v000014E4d0000A8D8sv*sd*bc*sc*i* pci:v000014E4d00004313sv*sd*bc*sc*i* pci:v000014E4d00000576sv*sd*bc*sc*i* symbol:bcma_find_core_unit symbol:bcma_core_irq symbol:__bcma_driver_register symbol:bcma_driver_unregister symbol:bcma_core_is_enabled symbol:bcma_core_disable symbol:bcma_core_enable symbol:bcma_core_set_clockmode symbol:bcma_core_pll_ctl symbol:bcma_core_dma_translation symbol:bcma_chipco_get_alp_clock symbol:bcma_chipco_gpio_out symbol:bcma_chipco_gpio_outen symbol:bcma_chipco_gpio_control symbol:bcma_chipco_pll_read symbol:bcma_chipco_pll_write symbol:bcma_chipco_pll_maskset symbol:bcma_chipco_chipctl_maskset symbol:bcma_chipco_regctl_maskset symbol:bcma_pmu_get_bus_clock symbol:bcma_pmu_spuravoid_pllupdate symbol:bcma_chipco_b_mii_write symbol:bcma_core_pci_power_save symbol:bcma_host_pci_up symbol:bcma_host_pci_down symbol:bcma_host_pci_irq_ctl

kernel/kernel/configs.ko.xz

kernel/fs/gfs2/gfs2.ko.xz fs_gfs2meta fs_gfs2

kernel/fs/ceph/ceph.ko.xz fs_ceph
libceph netfs

kernel/fs/hfsplus/hfsplus.ko.xz fs_hfsplus
cdrom

kernel/fs/dlm/dlm.ko.xz symbol:dlm_new_lockspace symbol:dlm_release_lockspace symbol:dlm_lock symbol:dlm_unlock symbol:dlm_posix_lock symbol:dlm_posix_unlock symbol:dlm_posix_cancel symbol:dlm_posix_get

kernel/fs/reiserfs/reiserfs.ko.xz fs_reiserfs

kernel/fs/fuse/cuse.ko.xz devname:cuse char_major_10_203
fuse

kernel/fs/fuse/fuse.ko.xz devname:fuse char_major_10_229 fs_fuseblk fs_fuse fs_fusectl symbol:fuse_len_args symbol:fuse_get_unique symbol:fuse_dev_fiq_ops symbol:fuse_request_end symbol:fuse_simple_background symbol:fuse_abort_conn symbol:fuse_dev_release symbol:fuse_dev_operations symbol:fuse_do_open symbol:fuse_sync_release symbol:fuse_direct_io symbol:fuse_file_poll symbol:fuse_conn_init symbol:fuse_conn_put symbol:fuse_conn_get symbol:fuse_send_init symbol:fuse_free_conn symbol:fuse_dev_alloc symbol:fuse_dev_install symbol:fuse_dev_alloc_install symbol:fuse_dev_free symbol:fuse_init_fs_context_submount symbol:fuse_fill_super_common symbol:fuse_mount_remove symbol:fuse_conn_destroy symbol:fuse_mount_destroy symbol:fuse_do_ioctl

kernel/fs/cachefiles/cachefiles.ko.xz
netfs

kernel/fs/efivarfs/efivarfs.ko.xz fs_efivarfs

kernel/fs/btrfs/btrfs.ko.xz devname:btrfs_control char_major_10_234 fs_btrfs
raid6_pq xor

kernel/fs/squashfs/squashfs.ko.xz fs_squashfs

kernel/fs/bcachefs/bcachefs.ko.xz fs_bcachefs symbol:u128_div symbol:mean_and_variance_get_mean symbol:mean_and_variance_get_variance symbol:mean_and_variance_get_stddev symbol:mean_and_variance_weighted_update symbol:mean_and_variance_weighted_get_mean symbol:mean_and_variance_weighted_get_variance symbol:mean_and_variance_weighted_get_stddev symbol:six_trylock_ip symbol:six_relock_ip symbol:six_lock_ip_waiter symbol:six_unlock_ip symbol:six_lock_downgrade symbol:six_lock_tryupgrade symbol:six_trylock_convert symbol:six_lock_increment symbol:six_lock_wakeup_all symbol:six_lock_counts symbol:six_lock_readers_add symbol:six_lock_exit symbol:__six_lock_init symbol:bch2_run_thread_with_stdout
raid6_pq lz4_compress lz4hc_compress xor

kernel/fs/udf/udf.ko.xz fs_udf
cdrom

kernel/fs/jfs/jfs.ko.xz fs_jfs
nls_ucs2_utils

kernel/fs/netfs/netfs.ko.xz symbol:netfs_readahead symbol:netfs_read_folio symbol:netfs_write_begin symbol:netfs_buffered_read_iter symbol:netfs_file_read_iter symbol:netfs_perform_write symbol:netfs_buffered_write_iter_locked symbol:netfs_file_write_iter symbol:netfs_page_mkwrite symbol:netfs_unbuffered_read_iter_locked symbol:netfs_unbuffered_read_iter symbol:netfs_unbuffered_write_iter_locked symbol:netfs_unbuffered_write_iter symbol:netfs_extract_user_iter symbol:netfs_limit_iter symbol:netfs_start_io_read symbol:netfs_end_io_read symbol:netfs_start_io_write symbol:netfs_end_io_write symbol:netfs_start_io_direct symbol:netfs_end_io_direct symbol:__tracepoint_netfs_sreq symbol:__traceiter_netfs_sreq symbol:__SCK__tp_func_netfs_sreq symbol:netfs_dirty_folio symbol:netfs_unpin_writeback symbol:netfs_clear_inode_writeback symbol:netfs_invalidate_folio symbol:netfs_release_folio symbol:netfs_read_subreq_progress symbol:netfs_read_subreq_terminated symbol:netfs_write_subrequest_terminated symbol:netfs_prepare_write_failed symbol:netfs_writepages symbol:netfs_stats_show symbol:fscache_addremove_sem symbol:fscache_clearance_waiters symbol:fscache_acquire_cache symbol:fscache_relinquish_cache symbol:fscache_add_cache symbol:fscache_io_error symbol:fscache_withdraw_cache symbol:fscache_end_cookie_access symbol:fscache_cookie_lookup_negative symbol:fscache_resume_after_invalidation symbol:fscache_caching_failed symbol:__fscache_acquire_cookie symbol:__fscache_use_cookie symbol:__fscache_unuse_cookie symbol:fscache_withdraw_cookie symbol:__fscache_relinquish_cookie symbol:fscache_put_cookie symbol:fscache_get_cookie symbol:__fscache_invalidate symbol:fscache_wait_for_operation symbol:__fscache_begin_read_operation symbol:__fscache_begin_write_operation symbol:__fscache_clear_page_bits symbol:__fscache_write_to_cache symbol:__fscache_resize_cookie symbol:__tracepoint_fscache_access_cache symbol:__traceiter_fscache_access_cache symbol:__SCK__tp_func_fscache_access_cache symbol:__tracepoint_fscache_access_volume symbol:__traceiter_fscache_access_volume symbol:__SCK__tp_func_fscache_access_volume symbol:__tracepoint_fscache_access symbol:__traceiter_fscache_access symbol:__SCK__tp_func_fscache_access symbol:fscache_wq symbol:fscache_try_get_volume symbol:fscache_end_volume_access symbol:__fscache_acquire_volume symbol:fscache_put_volume symbol:__fscache_relinquish_volume symbol:fscache_withdraw_volume symbol:fscache_n_updates symbol:fscache_n_read symbol:fscache_n_write symbol:fscache_n_no_write_space symbol:fscache_n_no_create_space symbol:fscache_n_culled symbol:fscache_n_dio_misfit

kernel/fs/erofs/erofs.ko.xz fs_erofs

kernel/fs/nfsd/nfsd.ko.xz fs_nfsd

kernel/fs/nfs/blocklayout/blocklayoutdriver.ko.xz nfs_layouttype4_5 nfs_layouttype4_3

kernel/fs/ocfs2/dlm/ocfs2_dlm.ko.xz symbol:dlm_unregister_domain symbol:dlm_register_domain symbol:dlm_setup_eviction_cb symbol:dlm_register_eviction_cb symbol:dlm_unregister_eviction_cb symbol:dlm_print_one_lock symbol:dlm_errmsg symbol:dlm_errname symbol:dlmlock symbol:dlmunlock
ocfs2_nodemanager

kernel/fs/ocfs2/ocfs2_stackglue.ko.xz symbol:ocfs2_stack_glue_register symbol:ocfs2_stack_glue_unregister symbol:ocfs2_stack_glue_set_max_proto_version symbol:ocfs2_dlm_lock symbol:ocfs2_dlm_unlock symbol:ocfs2_dlm_lock_status symbol:ocfs2_dlm_lvb_valid symbol:ocfs2_dlm_lvb symbol:ocfs2_dlm_dump_lksb symbol:ocfs2_stack_supports_plocks symbol:ocfs2_plock symbol:ocfs2_cluster_connect symbol:ocfs2_cluster_connect_agnostic symbol:ocfs2_cluster_disconnect symbol:ocfs2_cluster_hangup symbol:ocfs2_cluster_this_node symbol:ocfs2_kset

kernel/fs/ocfs2/ocfs2_stack_user.ko.xz
dlm ocfs2_stackglue

kernel/fs/ocfs2/ocfs2_stack_o2cb.ko.xz
ocfs2_dlm ocfs2_nodemanager ocfs2_stackglue

kernel/fs/ocfs2/cluster/ocfs2_nodemanager.ko.xz symbol:o2hb_fill_node_map symbol:o2hb_setup_callback symbol:o2hb_register_callback symbol:o2hb_unregister_callback symbol:o2hb_check_node_heartbeating_no_sem symbol:o2hb_check_node_heartbeating_from_callback symbol:o2hb_stop_all_regions symbol:o2hb_get_all_regions symbol:o2hb_global_heartbeat_active symbol:mlog_and_bits symbol:mlog_not_bits symbol:__mlog_printk symbol:o2nm_get_node_by_num symbol:o2nm_configured_node_map symbol:o2nm_get_node_by_ip symbol:o2nm_node_put symbol:o2nm_node_get symbol:o2nm_this_node symbol:o2net_register_handler symbol:o2net_unregister_handler_list symbol:o2net_fill_node_map symbol:o2net_send_message_vec symbol:o2net_send_message

kernel/fs/ocfs2/ocfs2.ko.xz fs_ocfs2
ocfs2_stackglue quota_tree ocfs2_nodemanager

kernel/fs/ocfs2/dlmfs/ocfs2_dlmfs.ko.xz fs_ocfs2_dlmfs
ocfs2_stackglue ocfs2_nodemanager

kernel/fs/unicode/utf8data.ko.xz symbol:utf8_data_table

kernel/fs/hfs/hfs.ko.xz fs_hfs
cdrom

kernel/fs/xfs/xfs.ko.xz fs_xfs

kernel/fs/quota/quota_v2.ko.xz
quota_tree

kernel/fs/quota/quota_v1.ko.xz

kernel/fs/quota/quota_tree.ko.xz symbol:qtree_entry_unused symbol:qtree_write_dquot symbol:qtree_delete_dquot symbol:qtree_read_dquot symbol:qtree_release_dquot symbol:qtree_get_next_id

kernel/fs/nls/nls_cp874.ko.xz nls_tis_620

kernel/fs/nls/nls_iso8859-7.ko.xz

kernel/fs/nls/nls_iso8859-14.ko.xz

kernel/fs/nls/nls_cp862.ko.xz

kernel/fs/nls/nls_cp775.ko.xz

kernel/fs/nls/nls_iso8859-9.ko.xz

kernel/fs/nls/nls_cp737.ko.xz

kernel/fs/nls/nls_iso8859-5.ko.xz

kernel/fs/nls/nls_cp850.ko.xz

kernel/fs/nls/nls_cp869.ko.xz

kernel/fs/nls/nls_cp1255.ko.xz nls_iso8859_8

kernel/fs/nls/nls_cp860.ko.xz

kernel/fs/nls/nls_utf8.ko.xz

kernel/fs/nls/nls_iso8859-4.ko.xz

kernel/fs/nls/nls_cp857.ko.xz

kernel/fs/nls/nls_euc-jp.ko.xz

kernel/fs/nls/nls_koi8-u.ko.xz

kernel/fs/nls/nls_iso8859-15.ko.xz

kernel/fs/nls/nls_cp855.ko.xz

kernel/fs/nls/nls_koi8-r.ko.xz

kernel/fs/nls/nls_iso8859-6.ko.xz

kernel/fs/nls/nls_cp861.ko.xz

kernel/fs/nls/nls_cp932.ko.xz nls_sjis

kernel/fs/nls/nls_cp863.ko.xz

kernel/fs/nls/nls_cp1250.ko.xz

kernel/fs/nls/nls_iso8859-3.ko.xz

kernel/fs/nls/nls_iso8859-13.ko.xz

kernel/fs/nls/nls_cp864.ko.xz

kernel/fs/nls/nls_cp865.ko.xz

kernel/fs/nls/nls_iso8859-1.ko.xz

kernel/fs/nls/nls_cp950.ko.xz nls_big5

kernel/fs/nls/nls_cp949.ko.xz nls_euc_kr

kernel/fs/nls/nls_ucs2_utils.ko.xz symbol:NlsUniUpperTable symbol:NlsUniUpperRange

kernel/fs/nls/nls_cp852.ko.xz

kernel/fs/nls/nls_koi8-ru.ko.xz

kernel/fs/nls/nls_cp936.ko.xz nls_gb2312

kernel/fs/nls/nls_cp866.ko.xz

kernel/fs/nls/nls_cp1251.ko.xz

kernel/fs/nls/nls_iso8859-2.ko.xz

kernel/fs/nilfs2/nilfs2.ko.xz fs_nilfs2

kernel/fs/ecryptfs/ecryptfs.ko.xz fs_ecryptfs

kernel/fs/isofs/isofs.ko.xz iso9660 fs_iso9660
cdrom

kernel/fs/jffs2/jffs2.ko.xz fs_jffs2
mtd

kernel/fs/binfmt_misc.ko.xz fs_binfmt_misc

kernel/fs/ntfs3/ntfs3.ko.xz fs_ntfs3

kernel/fs/ubifs/ubifs.ko.xz fs_ubifs
ubi

kernel/fs/9p/9p.ko.xz fs_9p
9pnet netfs

kernel/fs/overlayfs/overlay.ko.xz fs_overlay

kernel/fs/smb/common/cifs_arc4.ko.xz symbol:cifs_arc4_setkey symbol:cifs_arc4_crypt

kernel/fs/smb/common/cifs_md4.ko.xz symbol:cifs_md4_init symbol:cifs_md4_update symbol:cifs_md4_final

kernel/fs/smb/client/cifs.ko.xz smb3 fs_smb3 fs_cifs
cifs_md4 netfs nls_ucs2_utils cifs_arc4

kernel/fs/smb/server/ksmbd.ko.xz
nls_ucs2_utils cifs_arc4

kernel/fs/exfat/exfat.ko.xz fs_exfat

